package app.messages;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageRepository {
  private static final Log logger = LogFactory.getLog(MessageRepository.class);
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  private DataSource dataSource;

  public MessageRepository(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Message saveMessage(Message message) {
    GeneratedKeyHolder holder = new GeneratedKeyHolder();
    
    // 생성된 레코드의 키값을 받을 객체 및 SQL에 들어갈 파라미터들
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("text", message.getText());
    params.addValue("createdDate", message.getCreatedDate());
    String insertSQL = "INSERT INTO messages (`id`, `text`, `created_date`) VALUE (null, :text, :createdDate)";
    try {
      this.jdbcTemplate.update(insertSQL, params, holder);
    } catch (DataAccessException e) {
      logger.error("Failed to save message", e);
      return null;
    }
    // 생성된 레코드의 내용을 담은 해당하는 객체
    return new Message(holder.getKey().intValue(), message.getText(), message.getCreatedDate());
  }
}

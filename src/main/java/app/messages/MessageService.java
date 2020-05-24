package app.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    // @Autowired 필드 기반 주입은 사용하지 말자
    private MessageRepository repository;

    @Autowired
    public MessageService (MessageRepository repository) {
        this.repository = repository;
    }

    // @Required
    // public void setRepository(MessageRepository repository) {
    //     this.repository = repository;
    // }

    @SecurityCheck
    public Message save(String text) {
        return repository.saveMessage(new Message(text));
    }
}
package app.messages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // SpringBoot의 컨테이너 구동 코드
        // 이제 MessageService.java는 필요 없다.
        

        // SpringBoot가 아닌 SpringContainer 구동 코드
        // ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // MessageService messageService = context.getBean(MessageService.class);
        // messageService.save("Hello, Spring!");
    }
}
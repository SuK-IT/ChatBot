package de.sukit.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot class. Calling {@link #main(String[])} starts our tomcat webserver which in turn hosts our frontend, allowing
 * communication between said frontend and our REST-API in the backend.
 * @author Griefed
 */
@SpringBootApplication
public class ChatBotApplication {

    /**
     * Runs our Spring Boot application.
     * @author Griefed
     * @param args String Array. Arguments with which the application was executed. Passed from {@link Main#main(String[])}.
     */
    public static void main(String[] args) {
        SpringApplication.run(ChatBotApplication.class, args);
    }
}

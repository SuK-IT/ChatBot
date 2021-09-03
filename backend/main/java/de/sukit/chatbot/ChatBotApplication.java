/* Copyright (C) 2021  SUK-IT
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
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

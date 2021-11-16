package com.softserve.webhookbot;

import com.softserve.webhookbot.config.BotConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebhookBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebhookBotApplication.class, args);
    }

}

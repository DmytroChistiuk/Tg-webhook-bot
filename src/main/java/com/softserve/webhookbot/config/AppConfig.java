package com.softserve.webhookbot.config;


import com.softserve.webhookbot.bot.TelegramFacade;
import com.softserve.webhookbot.bot.WebHookBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
public class AppConfig {
    private final BotConfig botConfig;

    public AppConfig(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(botConfig.getWebHookPath()).build();
    }

    @Bean
    public WebHookBot springWebhookBot(SetWebhook setWebhook, TelegramFacade telegramFacade) {
        WebHookBot bot = new WebHookBot(telegramFacade, setWebhook);
        bot.setBotToken(botConfig.getToken());
        bot.setBotUserName(botConfig.getUsername());
        bot.setWebHookPath(botConfig.getWebHookPath());

        return bot;
    }
}
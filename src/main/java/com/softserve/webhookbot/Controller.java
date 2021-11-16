package com.softserve.webhookbot;

import com.softserve.webhookbot.bot.WebHookBot;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
@RestController
public class Controller {
    private WebHookBot telegramBot;

    public Controller(WebHookBot telegramBot) {
        this.telegramBot = telegramBot;
    }
    // point for message
    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return telegramBot.onWebhookUpdateReceived(update);
    }
}




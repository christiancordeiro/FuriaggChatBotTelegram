package org.example.telegrambot;

import io.github.cdimascio.dotenv.Dotenv;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class FuriaBot extends TelegramLongPollingBot {

    private static final Dotenv dotenv = Dotenv.load();
    private final MessageHandler messageHandler;

    public FuriaBot() {
        this.messageHandler = new MessageHandler(this);
    }

    @Override
    public String getBotUsername() {
        return dotenv.get("BOT_USERNAME");
    }

    @Override
    public String getBotToken() {
        return dotenv.get("BOT_TOKEN");
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            messageHandler.handleUpdate(update);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}

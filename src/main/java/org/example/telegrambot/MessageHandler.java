package org.example.telegrambot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MessageHandler {
    private final AbsSender bot;
    private final KeyboardFactory keyboardFactory;
    private final FuriaDataService dataService;

    public MessageHandler(AbsSender bot) {
        this.bot = bot;
        this.keyboardFactory = new KeyboardFactory();
        this.dataService = new FuriaDataService();
    }

    public void handleUpdate(Update update) throws TelegramApiException {
        if (update.hasMessage() && update.getMessage().hasText()) {
            handleCommand(update);
        } else if (update.hasCallbackQuery()) {
            handleButtonClick(update);
        }
    }

    private void handleCommand(Update update) throws TelegramApiException {
        String command = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();
        SendMessage message = new SendMessage();

        if (command.equals("/start") || command.equals("/menu")) {
            showMainMenu(chatId);
        } else {
            message.setChatId(String.valueOf(chatId));
            message.setText("Comando não reconhecido. Use /start ou /menu para começar.");
            try {
                bot.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleButtonClick(Update update) throws TelegramApiException {
        String callbackData = update.getCallbackQuery().getData();
        long chatId = update.getCallbackQuery().getMessage().getChatId();
        int messageId = update.getCallbackQuery().getMessage().getMessageId();

        switch (callbackData) {
            case "MENU":
                showMainMenu(chatId, messageId);
                break;
            case "RESULTS":
                showResults(chatId, messageId);
                break;
            case "MATCHES":
                showNextMatches(chatId, messageId);
                break;
            case "STATS":
                showTeamStats(chatId, messageId);
                break;
            case "PLAYERS":
                showPlayersMenu(chatId, messageId);
                break;
            case "FACTS":
                showRandomFact(chatId, messageId);
                break;
            case "STORE":
                showStoreInfo(chatId, messageId);
                break;
            case "SOCIAL":
                showSocial(chatId, messageId);
                break;
            case "QUIZ":
                startQuiz(chatId, messageId);
                break;
            default:
                if (callbackData.startsWith("PLAYER_")) {
                    showPlayerProfile(chatId, messageId, callbackData.replace("PLAYER_", ""));
                }
        }
    }
    private void showSocial(long chatId, int messageId) throws TelegramApiException {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        message.setText(dataService.getSocial());
        message.setReplyMarkup(keyboardFactory.createBackButton());
        bot.execute(message);
    }


    private void showMainMenu(long chatId) throws TelegramApiException {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("🤖 Bem-vindo ao FURIABot!\n\nEscolha uma opção:");
        message.setReplyMarkup(keyboardFactory.createMainMenu());
        bot.execute(message);
    }

    private void showMainMenu(long chatId, int messageId) throws TelegramApiException {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        message.setText("🤖 Bem-vindo ao FURIABot!\n\nEscolha uma opção:");
        message.setReplyMarkup(keyboardFactory.createMainMenu());
        bot.execute(message);
    }

    private void showResults(long chatId, int messageId) throws TelegramApiException {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        message.setText(dataService.getLastResults());
        message.setReplyMarkup(keyboardFactory.createBackButton());
        bot.execute(message);
    }

    private void showNextMatches(long chatId, int messageId) throws TelegramApiException {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        message.setText(dataService.getNextMatches());

        // Adiciona botão extra para lembrete
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(List.of(
                InlineKeyboardButton.builder()
                        .text("🔔 Criar Lembrete")
                        .callbackData("SET_REMINDER")
                        .build()
        ));
        rows.add(keyboardFactory.createBackButton().getKeyboard().get(0));

        message.setReplyMarkup(new InlineKeyboardMarkup(rows));
        bot.execute(message);
    }

    private void showTeamStats(long chatId, int messageId) throws TelegramApiException {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        message.setText(dataService.getTeamStats());
        message.setReplyMarkup(keyboardFactory.createBackButton());
        bot.execute(message);
    }

    private void showPlayersMenu(long chatId, int messageId) throws TelegramApiException {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        message.setText("Escolha um jogador:");
        message.setReplyMarkup(keyboardFactory.createPlayersMenu());
        bot.execute(message);
    }

    private void showRandomFact(long chatId, int messageId) throws TelegramApiException {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        message.setText(dataService.getRandomFact());

        // Botão para nova curiosidade
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(List.of(
                InlineKeyboardButton.builder()
                        .text("🔁 Nova Curiosidade")
                        .callbackData("FACTS")
                        .build()
        ));
        rows.add(keyboardFactory.createBackButton().getKeyboard().get(0));

        message.setReplyMarkup(new InlineKeyboardMarkup(rows));
        bot.execute(message);
    }

    private void showStoreInfo(long chatId, int messageId) throws TelegramApiException {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        message.setText(dataService.getStoreInfo());

        // Botão com link direto para a loja
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(List.of(
                InlineKeyboardButton.builder()
                        .text("🛍️ Acessar Loja")
                        .url("https://www.furia.gg/produtos/")
                        .build()
        ));
        rows.add(keyboardFactory.createBackButton().getKeyboard().get(0));

        message.setReplyMarkup(new InlineKeyboardMarkup(rows));
        message.setDisableWebPagePreview(true);
        bot.execute(message);
    }

    private void startQuiz(long chatId, int messageId) throws TelegramApiException {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        message.setText(dataService.getQuizQuestion());

        // Teclado com opções do quiz
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        // Opções A/B
        rows.add(List.of(
                InlineKeyboardButton.builder().text("A) 2015").callbackData("QUIZ_ANSWER_A").build(),
                InlineKeyboardButton.builder().text("B) 2017").callbackData("QUIZ_ANSWER_B").build()
        ));

        // Opções C/D
        rows.add(List.of(
                InlineKeyboardButton.builder().text("C) 2018").callbackData("QUIZ_ANSWER_C").build(),
                InlineKeyboardButton.builder().text("D) 2020").callbackData("QUIZ_ANSWER_D").build()
        ));

        // Botão de sair
        rows.add(List.of(
                InlineKeyboardButton.builder().text("🚪 Sair do Quiz").callbackData("MENU").build()
        ));

        markup.setKeyboard(rows);
        message.setReplyMarkup(markup);
        bot.execute(message);
    }

    private void showPlayerProfile(long chatId, int messageId, String player) throws TelegramApiException {
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        message.setText(dataService.getPlayerProfile(player));

        // Adiciona botão de highlights para jogadores
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        if(!player.equals("FALLEN")) { // Exemplo: não mostrar para FalleN
            rows.add(List.of(
                    InlineKeyboardButton.builder()
                            .text("🎥 Melhores Clipes")
                            .url(getPlayerHighlightUrl(player))
                            .build()
            ));
        }

        rows.add(keyboardFactory.createBackButton().getKeyboard().get(0));
        message.setReplyMarkup(new InlineKeyboardMarkup(rows));
        bot.execute(message);
    }

    private String getPlayerHighlightUrl(String player) {
        switch(player.toLowerCase()) {
            case "kscerato": return "https://youtube.com/search?q=FURIA+KSCERATO+highlights";
            case "yuurih": return "https://youtube.com/search?q=FURIA+yuurih+highlights";
            case "molodoy": return "https://youtube.com/search?q=FURIA+molodoy+highlights";
            case "yekindar": return "https://youtube.com/search?q=YEKINDAR+highlights";
            default: return "https://youtube.com/furiagg";
        }
    }
}
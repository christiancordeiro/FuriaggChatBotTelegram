package org.example.telegrambot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyboardFactory {
    public InlineKeyboardMarkup createMainMenu() {
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        // Linha 1
        rows.add(List.of(
                createButton("\uD83C\uDFC1 Últimos Resultados", "RESULTS"),
                createButton("\uD83D\uDCC5 Próximas Partidas", "MATCHES")
        ));

        // Linha 2
        rows.add(List.of(
                createButton("\uD83D\uDCCA Estatísticas", "STATS"),
                createButton("\uD83E\uDDD1\u200D\uD83D\uDCBB Jogadores", "PLAYERS")
        ));

        // Linha 3
        rows.add(List.of(
                createButton("\uD83E\uDD14 Curiosidades", "FACTS"),
                createButton("\uD83D\uDED2 Loja", "STORE")
        ));

        // Linha 4
        rows.add(List.of(
                createButton("\uD83D\uDCF1 Social", "SOCIAL"),
                createButton("Quiz FURIOSO 🔥", "QUIZ")
        ));

        return new InlineKeyboardMarkup(rows);
    }

    public InlineKeyboardMarkup createPlayersMenu() {
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        rows.add(List.of(createButton("KSCERATO", "PLAYER_KSCERATO")));
        rows.add(List.of(createButton("yuurih", "PLAYER_YUURIH")));
        rows.add(List.of(createButton("FalleN", "PLAYER_FALLEN")));
        rows.add(List.of(createButton("molodoy", "PLAYER_MOLODOY")));
        rows.add(List.of(createButton("YEKINDAR", "PLAYER_YEKINDAR")));
        rows.add(List.of(createButton("🔙 Voltar", "MENU")));

        return new InlineKeyboardMarkup(rows);
    }

    public InlineKeyboardMarkup createBackButton() {
        return new InlineKeyboardMarkup(List.of(
                List.of(createButton("🔙 Voltar", "MENU"))
        ));
    }

    private InlineKeyboardButton createButton(String text, String callbackData) {
        return InlineKeyboardButton.builder()
                .text(text)
                .callbackData(callbackData)
                .build();
    }
}

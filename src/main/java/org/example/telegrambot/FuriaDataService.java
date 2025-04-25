package org.example.telegrambot;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FuriaDataService {

    private final Random random = new Random();

    public String getLastResults() {
        return "🆚 Últimos Resultados:\n\n" +
                "• FURIA 16 x 10 NAVI (Inferno)\n" +
                "• FURIA 13 x 16 Vitality (Mirage)\n" +
                "• FURIA 2 x 0 MIBR (Bo3 - IEM Dallas)";
    }

    public String getNextMatches() {
        return "📅 Próximas Partidas:\n\n" +
                "• FURIA vs Cloud9 - 25/04 às 16h (BRT)\n" +
                "• FURIA vs FaZe Clan - 28/04 às 19h (BRT)\n\n" +
                "📺 Transmissão: twitch.tv/ESL_CSGO";
    }

    public String getPlayerProfile(String player) {
        switch (player.toUpperCase()) {
            case "KSCERATO":
                return "🧑‍💻 KSCERATO (Kaike Cerato)\n\n" +
                        "🛡️ Função: Rifler\n" +
                        "🌍 Nacionalidade: 🇧🇷 Brasileiro\n" +
                        "🎂 Idade: 25 anos\n" +
                        "⭐ Rating: 1.19\n" +
                        "🔥 Curiosidade: Conhecido como \"O Robô\" pela sua precisão e consistência. Está na FURIA desde 2018, sendo um dos pilares da equipe.";
            case "YUURIH":
                return "🧑‍💻 yuurih (Yuri Santos)\n\n" +
                        "🛡️ Função: Rifler\n" +
                        "🌍 Nacionalidade: 🇧🇷 Brasileiro\n" +
                        "🎂 Idade: 25 anos\n" +
                        "⭐ Rating: 1.17\n" +
                        "🔥 Curiosidade: Jogador mais antigo da FURIA, conhecido por sua versatilidade e impacto em momentos decisivos.";
            case "FALLEN":
                return "🧑‍💻 FalleN (Gabriel Toledo)\n\n" +
                        "🛡️ Função: IGL / AWPer\n" +
                        "🌍 Nacionalidade: 🇧🇷 Brasileiro\n" +
                        "🎂 Idade: 33 anos\n" +
                        "⭐ Rating: 1.01\n" +
                        "🔥 Curiosidade: Lenda do CS brasileiro, bicampeão de Major. Apelidado de \"Professor\", lidera a equipe com experiência e estratégia.";
            case "MOLODOY":
                return "🧑‍💻 molodoy (Danil Golubenko)\n\n" +
                        "🛡️ Função: AWPer\n" +
                        "🌍 Nacionalidade: Cazaquistão\n" +
                        "🎂 Idade: 20 anos\n" +
                        "⭐ Rating: 1.21\n" +
                        "🔥 Curiosidade: Reforço recente vindo da AMKAL Esports. Destaca-se por sua precisão e agressividade com a AWP.";
            case "YEKINDAR":
                return "🧑‍💻 YEKINDAR (Mareks Gaļinskis)\n\n" +
                        "🛡️ Função: Rifler\n" +
                        "🌍 Nacionalidade: 🇱🇻 Letônia\n" +
                        "🎂 Idade: 25 anos\n" +
                        "⭐ Rating: 1.12\n" +
                        "🔥 Curiosidade: Jogador emprestado para o BLAST.tv Major: Austin 2025. Conhecido por seu estilo agressivo e jogadas impactantes.";
            default:
                return "❓ Jogador não encontrado. Verifique o nome e tente novamente.";
        }
    }

    private final List<String> facts = Arrays.asList(
            "🔥 Em 2023, a FURIA foi o time brasileiro com melhor colocação no Major",
            "🎯 Art é conhecido pelo seu estilo ultra agressivo de jogar!",
            "🤖 KSCERATO tem o apelido de 'O Robô' por sua precisão",
            "🏆 A FURIA já venceu 5 torneios internacionais"
    );

    public String getTeamStats() {
        return "📊 Estatísticas da FURIA:\n\n" +
                "🏆 Taxa de Vitória: 68% (últimos 3 meses)\n" +
                "🗺️ Mapa Favorito: Mirage (72% WR)\n" +
                "🎯 MVP Recente: KSCERATO (1.32 Rating)\n\n" +
                "📈 Melhor Ranking Alcançado: #4 Mundial";
    }

    public String getRandomFact() {
        return "🔥 FATOS FURIOSOS:\n\n" + facts.get(random.nextInt(facts.size()));
    }

    public String getStoreInfo() {
        return "🛍️ Loja da FURIA\n\n" +
                "🔹 Camiseta Furia Oficial '24 Preta: R$ 259,00\n" +
                "🔹 Camiseta Furia x Zor Preta: R$ 129,00\n" +
                "🔹 Boné Furia Furioso Preto: R$ 119,90\n\n" +
                "💡 Frete grátis para compras acima de R$ 250!";
    }

    public String getQuizQuestion() {
        return "📝 Quiz FURIA - Nível: Fã Hardcore\n\n" +
                "Pergunta 1/5:\n" +
                "Em que ano a FURIA foi fundada?\n\n" +
                "Escolha uma opção:";
    }

    public String getSocial() {
        return "📱 Redes Sociais Oficiais da FURIA:\n\n" +
                "🐦 Twitter:https://x.com/FURIA\n" +
                "📸 Instagram: https://instagram.com/furiagg\n" +
                "🎥 YouTube: https://www.youtube.com/@FURIAggCS\n" +
                "🎮 Twitch: https://www.twitch.tv/furiatv\n" +
                "🖥️ Site Oficial: https://furia.gg\n\n" +
                "🔗 Todos os links em: https://linktr.ee/furiagg";
    }

}
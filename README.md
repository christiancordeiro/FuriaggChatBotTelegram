# 🤖 FURIABot - Telegram Bot da FURIA

Um bot do Telegram desenvolvido em Java para interagir com fãs da equipe FURIA Esports, esse projeto foi desenvolvido para o processo seletivo. Ele oferece informações como últimos resultados, próximos jogos, estatísticas do time, curiosidades, quiz e muito mais — tudo de forma interativa com botões inline.

## 📦 Tecnologias utilizadas

- **Java 17+**
- **Maven**
- **Telegram Bots Java SDK**
- **dotenv-java** (para variáveis de ambiente)

## 🚀 Funcionalidades

- `/start` ou `/menu`: Mostra o menu principal com várias opções.
- 📊 **Resultados Recentes**: Mostra os últimos jogos e resultados da FURIA.
- 🗓️ **Próximos Jogos**: Informa a data e o adversário das próximas partidas.
- 📈 **Estatísticas do Time**: Exibe estatísticas da equipe.
- 🎮 **Jogadores**: Permite ver perfis dos jogadores com links para highlights.
- 🧠 **Curiosidades**: Mostra curiosidades aleatórias sobre a equipe.
- 🛍️ **Loja Oficial**: Link direto para a loja da FURIA.
- 🌐 **Redes Sociais**: Lista as redes sociais oficiais da equipe.
- ❓ **Quiz**: Interativo com perguntas e opções de resposta.

## 🤖 Como criar seu bot no Telegram com o BotFather

Siga este passo a passo para registrar seu bot e obter o token de acesso:

1. Abra o Telegram e pesquise por [@BotFather](https://t.me/BotFather).

2. Inicie uma conversa com o BotFather clicando em **Start** ou enviando o comando:

   ```bash
   /start
   ```
3. Crie um novo bot com o comando:

   ```bash
   /newbot
   ```

4. O BotFather irá pedir que você defina um nome para o bot. Esse é o nome que será exibido nas conversas. Exemplo:

   ```bash
   FURIA Interativo
   ```

5. Em seguida, escolha um username para o bot. Ele deve terminar com bot. Exemplo:

   ```bash
   furia_interativo_bot
   ```

6. Após isso, o BotFather irá gerar e mostrar um token de API, algo como:

   ```bash
   123456789:ABCDefGhIJklMNOpQRsTuvWXyZ
   ```

7. Copie esse token e adicione no seu arquivo .env:

   ```bash
   BOT_USERNAME=furia_interativo_bot
   BOT_TOKEN=123456789:ABCDefGhIJklMNOpQRsTuvWXyZ
   ```

## 🔧 Como rodar o projeto

1. **Clone o repositório**

```bash
git clone https://github.com/christiancordeiro/FuriaggChatBotTelegram.git
cd furia-bot
```

2. *Crie o arquivo .env na raiz do projeto com seu token:*

```bash
BOT_TOKEN=seu_token_aqui
BOT_USERNAME=nome_do_bot
```

2. **Compile e execute o projeto**

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="org.example.Main"
```

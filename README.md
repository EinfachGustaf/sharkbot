# 🦈 SharkBot
A Discord bot containing various features. Used for the EinfachGustaf(.live) Discord server.

## 📈 Features
- [ ] Level System
- [ ] Economy
    - [ ] Daily rewards
    - [ ] Gambling
- [ ] Games
  - [ ] Tic Tac Toe
  - [ ] Counting
- [ ] Moderation
  - [ ] Timeout a user when tagging a team member
- [ ] Music
  - [ ] Play music from YouTube
  - [ ] Play music from Spotify

## 🚀 Installation
Currently, there is no way to install SharkBot on your own server. This might change in the future. At the moment, you have to compile the bot yourself.

### 🧪 Compiling
1. Clone the repository
2. Run `./gradlew shadowJar`
3. The compiled jar file can be found in `build/libs/`
4. Copy the `.env` located in the project root and fill in the required values
5. Run the jar with `java -jar sharkbot.jar`

```bash
git clone https://github.com/EinfachGustaf/sharkbot.git
cd sharkbot
./gradlew shadowJar
# Do the rest of your setup
```

## 📦 Tech Stack
- [Kotlin](https://kotlinlang.org/)
- [Kord](https://github.com/kordlib/kord)
- [Kord Extensions](https://kordex.dev)
- [MongoDB](https://www.mongodb.com/)

## 🌏 Contributing
If you want to contribute to the project, feel free to create a pull request.

## 🎯 License
This project is licensed under the GPL-3.0 License - see the [LICENSE](LICENSE) file for details.
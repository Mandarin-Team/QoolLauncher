package wtf.foximus.qoollauncher.utils.discord;

import ru.mandarin.discordipc.DiscordIPC;
import ru.mandarin.discordipc.activity.Button;
import ru.mandarin.discordipc.activity.RichPresence;
import wtf.foximus.qoollauncher.api.Constants;

public class RPC {
    public static void startRPC() {

        if (!DiscordIPC.start(1510913508869537894L, () -> System.out.println("Discord IPC подключен для пользователя: " + DiscordIPC.getUser().username()))) {
            System.out.println("Не удалось запустить Discord IPC");
            return;
        }

        RichPresence presence = new RichPresence();
       /*
       Если нужно изменить информацию об активности,
        то можно использовать presence.update(), в который вы должны передать функцию,
         принимающую информацию о текущей активности и возвращающую измененную информацию об активности.
        */
        presence.update(activityInfo ->
                activityInfo
                        .setDetails("Build: " + Constants.BUILD)
                        .setState("UID: " + Constants.UID)
                        .setLargeImage("a")
                        .setLargeText(Constants.UserName)
                        .setSmallImage("b")
                        .setSmallText("Small Image")
                        .setButtons(new Button("SITE", Constants.WEBSITE)) //Максимально под активностью может быть видно только 2 кнопки
                        .setButtons(new Button("TG", Constants.TELEGRAM))
        );
        //Устанавливаем активность в ipc
        DiscordIPC.setRichPresence(presence);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            DiscordIPC.stop();
        }
    }

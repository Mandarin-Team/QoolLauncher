package wtf.foximus.qoollauncher;

import wtf.foximus.qoollauncher.utils.config.Config;
import wtf.foximus.qoollauncher.utils.discord.RPC;
import wtf.foximus.qoollauncher.utils.folder.Folder;
import wtf.foximus.qoollauncher.utils.Utils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Запуск");
        RPC.startRPC();

        //ConnectionCheck
        if (Utils.ConnectionCheck() == false){
            System.err.println("Не удалось подключиться к серверу");
            System.exit(1);
            }

        //Folder
        try {
            Folder.appPathCreate();
            Folder.gamePathCreate();
            Folder.launcherPathCreate();

            System.out.println("Папки успешно созданны");
        } catch (IOException e) {
            System.err.println("Не удалось создать папки");
        }
        //Config
        try {
            Config.configCreate();

            System.out.println("Файл конфигурации успешно создан");
        } catch (IOException e) {
            System.err.println(("Не удалось создать файл конфигурации"));
        }

        Config.set("version", "1.0.0");
        String version = Config.get("version");
        System.out.println(version);

        Config.set("version", "1.0.1");
        String version1 = Config.get("version");
        System.out.println(version1);
    }
}

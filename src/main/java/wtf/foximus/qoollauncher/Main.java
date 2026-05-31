package wtf.foximus.qoollauncher;

import wtf.foximus.qoollauncher.utils.Folder.Folder;
import wtf.foximus.qoollauncher.utils.Utils;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        System.out.println("Запуск");

        if (Utils.ConnectionCheck() == false){
            System.err.println("Не удалось подключиться к серверу");
            System.exit(1);
            }

        try {
            Folder.appPathCreate();
            Folder.gamePathCreate();
            Folder.launcherPathCreate();

            System.out.println("Папки успешно созданны");
        } catch (IOException e) {
            System.err.println("Не удалось создать папки");
        }
    }
}

package wtf.foximus.qoollauncher.utils.folder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Folder {

    private static final String ROOT_DIR = "C:\\QoolLauncher";

    private static void createDirectory(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    public static void appPathCreate() throws IOException {
        createDirectory(Paths.get(ROOT_DIR));
    }

    public static void launcherPathCreate() throws IOException {
        createDirectory(Paths.get(ROOT_DIR, "launcher"));
    }

    public static void gamePathCreate() throws IOException {
        createDirectory(Paths.get(ROOT_DIR, "game"));
    }

}

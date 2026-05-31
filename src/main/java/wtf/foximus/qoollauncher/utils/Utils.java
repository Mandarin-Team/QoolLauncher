package wtf.foximus.qoollauncher.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils {

    public static boolean ConnectionCheck() {
        try {
            URL url = new URL("https://ely.by/");
            HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
            urlConnect.setConnectTimeout(3000);
            urlConnect.setReadTimeout(3000);
            urlConnect.connect();
            if (urlConnect.getResponseCode() == 200) {
                return true;
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }

}

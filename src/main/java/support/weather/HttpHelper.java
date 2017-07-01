package support.weather;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpHelper {

    static OkHttpClient client = new OkHttpClient();

    public static Response get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("auth-token", "token")
                .get()
                .build();

        return client.newCall(request).execute();
    }
}

package org.example.okhttp;


import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.example.model.Post;

import java.io.IOException;

public class MakePostRequestOkHttp {
        public String makePostRequest() throws IOException {
                OkHttpClient client = new OkHttpClient();

                okhttp3.MediaType JSON =  okhttp3.MediaType.parse("application/json; charset=utf-8");

                Post post = new Post();
                post.setTitle("foo");
                post.setBody("bar");
                post.setUserId(1);

                Gson gson = new Gson();
                String json = gson.toJson(post);

                RequestBody body = RequestBody.create(JSON,json );
                Request request = new Request.Builder()
                        .url("https://jsonplaceholder.typicode.com/posts")
                        .post(body)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                        return response.body().string();
                }
        }
}


package org.example.httpclient;
import com.google.gson.Gson;
import org.example.model.Post;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class MakePostRequestJavaHttpClient {
    public String makePostRequest() throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        Post post = new Post();
        post.setTitle("foo");
        post.setBody("bar");
        post.setUserId(1);

        String json = new Gson().toJson(post);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() < 200 && response.statusCode() >= 300) {
            throw new Exception("Unexpected response code: " + response.statusCode());
        }

        return response.body();
    }
}

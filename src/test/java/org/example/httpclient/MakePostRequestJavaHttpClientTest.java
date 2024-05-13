package org.example.httpclient;

import org.example.core.PostRequestExecutor;
import org.example.model.Post;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MakePostRequestJavaHttpClientTest {

    @Test
    void makePostRequest() throws Exception {

        Post post = new Post();
        post.setTitle("foo");
        post.setBody("bar");
        post.setUserId(1);

        MakePostRequestJavaHttpClient executor = new MakePostRequestJavaHttpClient();
        String response = executor.makePostRequest(post, "https://jsonplaceholder.typicode.com/posts");

        assertThat(response).isNotEmpty().contains("id");
    }
}

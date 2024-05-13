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

        PostRequestExecutor<Post,String> executor = new PostRequestExecutor<>(new MakePostRequestJavaHttpClient());
        String response = executor.executePostRequest(post, "https://jsonplaceholder.typicode.com/posts");

        assertThat(response).isNotEmpty().contains("id");
    }
}

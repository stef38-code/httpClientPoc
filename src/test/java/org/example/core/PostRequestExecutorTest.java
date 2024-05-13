package org.example.core;

import org.example.httpclient.MakePostRequestJavaHttpClient;
import org.example.model.Post;
import org.example.okhttp.MakePostRequestOkHttp;
import org.example.retrofit.MakePostRequestRetrofit;
import org.example.spring.MakePostRequestSpring;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostRequestExecutorTest {
    private Post post;

    @BeforeEach
    void setUp() {
        post = new Post();
        post.setTitle("foo");
        post.setBody("bar");
        post.setUserId(1);

    }

    @Test
    void executePostRequestRetrofit() throws Exception {
        PostRequestExecutor executor = new PostRequestExecutor(new MakePostRequestRetrofit());
        String response = executor.executePostRequest(post);
        assertThat(response).isNotEmpty().contains("id");
    }

    @Test
    void executePostRequestSpring() throws Exception {
        PostRequestExecutor executor = new PostRequestExecutor(new MakePostRequestSpring());
        String response = executor.executePostRequest(post);
        assertThat(response).isNotEmpty().contains("id");
    }

    @Test
    void executePostRequestHttpClient() throws Exception {
        PostRequestExecutor executor = new PostRequestExecutor(new MakePostRequestJavaHttpClient());
        String response = executor.executePostRequest(post);
        assertThat(response).isNotEmpty().contains("id");
    }

    @Test
    void executePostRequestOkHttp() throws Exception {
        PostRequestExecutor executor = new PostRequestExecutor(new MakePostRequestOkHttp());
        String response = executor.executePostRequest(post);
        assertThat(response).isNotEmpty().contains("id");
    }
}

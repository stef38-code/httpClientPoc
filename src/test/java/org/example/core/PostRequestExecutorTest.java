package org.example.core;

import org.example.httpclient.MakePostRequestJavaHttpClient;
import org.example.model.Post;
import org.example.okhttp.MakePostRequestOkHttp;
import org.example.spring.MakePostRequestSpring;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostRequestExecutorTest {
    private Post post;
    private String url;

    @BeforeEach
    void setUp() {
        post = new Post();
        post.setTitle("foo");
        post.setBody("bar");
        post.setUserId(1);

        url = "https://jsonplaceholder.typicode.com/posts";
    }


    @Test
    void executePostRequestSpring() throws Exception {
        String response = PostRequestExecutor.<Post, String>builder()
                .postRequestMaker(new MakePostRequestSpring())
                .body(post)
                .url(url)
                .build();

        assertThat(response).isNotEmpty().contains("id");
    }

    @Test
    void executePostRequestHttpClient() throws Exception {

        String response = PostRequestExecutor.<Post, String>builder()
                .postRequestMaker(new MakePostRequestJavaHttpClient())
                .body(post)
                .url(url)
                .build();
        assertThat(response).isNotEmpty().contains("id");
    }

    @Test
    void executePostRequestOkHttp() throws Exception {
        String response = PostRequestExecutor.<Post, String>builder()
                .postRequestMaker(new MakePostRequestOkHttp())
                .body(post)
                .url(url)
                .build();
        assertThat(response).isNotEmpty().contains("id");
    }
}

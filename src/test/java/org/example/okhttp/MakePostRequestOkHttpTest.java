package org.example.okhttp;

import org.example.model.Post;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class MakePostRequestOkHttpTest {
    @Test
    void makePostRequest() throws IOException {
        Post post = new Post();
        post.setTitle("foo");
        post.setBody("bar");
        post.setUserId(1);
        MakePostRequestOkHttp makePostRequestOkHttp = new MakePostRequestOkHttp();
            String actual = makePostRequestOkHttp.makePostRequest(post);
            assertThat(actual).isNotBlank().contains("id");
    }
}

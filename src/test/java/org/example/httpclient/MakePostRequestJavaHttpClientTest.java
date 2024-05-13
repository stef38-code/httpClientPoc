package org.example.httpclient;

import org.example.core.PostRequestExecutor;
import org.example.model.Post;
import org.example.retrofit.MakePostRequestRetrofit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MakePostRequestJavaHttpClientTest {

    @Test
    void makePostRequest() throws Exception {
        MakePostRequestJavaHttpClient makePostRequestJavaHttpClient = new MakePostRequestJavaHttpClient();
        Post post = new Post();
post.setTitle("foo");
post.setBody("bar");
post.setUserId(1);

PostRequestExecutor executor = new PostRequestExecutor(new MakePostRequestRetrofit());
String response = executor.executePostRequest(post);

        assertThat(response).isNotEmpty().contains("id");
    }
}

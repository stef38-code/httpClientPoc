package org.example.retrofit;

import org.example.model.Post;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MakePostRequestRetrofitTest {

    @Test
    void makePostRequest() throws Exception {
        Post post = new Post();
        post.setTitle("foo");
        post.setBody("bar");
        post.setUserId(1);
        MakePostRequestRetrofit makePostRequestRetrofit = new MakePostRequestRetrofit();
            String actual = makePostRequestRetrofit.makePostRequest(post);
            assertThat(actual).isNotEmpty().contains("id");
       }
}

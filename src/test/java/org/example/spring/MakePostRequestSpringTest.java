package org.example.spring;

import org.example.model.Post;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MakePostRequestSpringTest {

    @Test
    void makePostRequest() {
        Post post = new Post();
        post.setTitle("foo");
        post.setBody("bar");
        post.setUserId(1);
        MakePostRequestSpring makePostRequestSpring = new MakePostRequestSpring();
        String actual = makePostRequestSpring.makePostRequest(post,"https://jsonplaceholder.typicode.com/posts");
        assertThat(actual).isNotEmpty().contains("id");
    }
}

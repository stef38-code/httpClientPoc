package org.example.spring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MakePostRequestSpringTest {

    @Test
    void makePostRequest() {
        MakePostRequestSpring makePostRequestSpring = new MakePostRequestSpring();
        String actual = makePostRequestSpring.makePostRequest();
        assertThat(actual).isNotEmpty().contains("id");
    }
}

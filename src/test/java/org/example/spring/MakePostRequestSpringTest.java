package org.example.spring;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class MakePostRequestSpringTest {

    @Test
    void makePostRequest() {
        MakePostRequestSpring makePostRequestSpring = new MakePostRequestSpring();
        ResponseEntity<String> actual = makePostRequestSpring.makePostRequest();
        assertThat(actual).isNotNull();
        assertThat(actual.getStatusCode().is2xxSuccessful()).isTrue();
    }
}

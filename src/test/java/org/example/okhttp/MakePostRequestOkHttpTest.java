package org.example.okhttp;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class MakePostRequestOkHttpTest {
    @Test
    void makePostRequest() throws IOException {
        MakePostRequestOkHttp makePostRequestOkHttp = new MakePostRequestOkHttp();
            String actual = makePostRequestOkHttp.makePostRequest();
            assertThat(actual).isNotBlank().contains("id");
    }
}

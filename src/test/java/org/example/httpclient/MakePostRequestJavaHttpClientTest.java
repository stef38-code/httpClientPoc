package org.example.httpclient;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MakePostRequestJavaHttpClientTest {

    @Test
    void makePostRequest() throws Exception {
        MakePostRequestJavaHttpClient makePostRequestJavaHttpClient = new MakePostRequestJavaHttpClient();
        String actual = makePostRequestJavaHttpClient.makePostRequest();
        assertThat(actual).isNotEmpty().contains("id");
    }
}

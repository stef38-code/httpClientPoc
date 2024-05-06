package org.example.spring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MakePostRequestRetrofitTest {

    @Test
    void makePostRequest() throws Exception {
        MakePostRequestRetrofit makePostRequestRetrofit = new MakePostRequestRetrofit();
            String actual = makePostRequestRetrofit.makePostRequest();
            assertThat(actual).isNotEmpty().contains("id");
       }
}

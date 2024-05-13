package org.example.core;

import org.example.httpclient.MakePostRequestJavaHttpClient;
import org.example.okhttp.MakePostRequestOkHttp;
import org.example.retrofit.MakePostRequestRetrofit;
import org.example.spring.MakePostRequestSpring;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostRequestExecutorTest {

    @Test
    void executePostRequestRetrofit() throws Exception {
       PostRequestExecutor executor = new PostRequestExecutor(new MakePostRequestRetrofit());
        String response = executor.executePostRequest();
        assertThat(response).isNotEmpty().contains("id");
    }
    @Test
    void executePostRequestSpring() throws Exception {
        PostRequestExecutor executor = new PostRequestExecutor(new MakePostRequestSpring());
        String response = executor.executePostRequest();
        assertThat(response).isNotEmpty().contains("id");
    }
    @Test
    void executePostRequestHttpClient() throws Exception {
        PostRequestExecutor executor = new PostRequestExecutor(new MakePostRequestJavaHttpClient());
        String response = executor.executePostRequest();
        assertThat(response).isNotEmpty().contains("id");
    }
    @Test
    void executePostRequestOkHttp() throws Exception {
        PostRequestExecutor executor = new PostRequestExecutor(new MakePostRequestOkHttp());
        String response = executor.executePostRequest();
        assertThat(response).isNotEmpty().contains("id");
    }
}

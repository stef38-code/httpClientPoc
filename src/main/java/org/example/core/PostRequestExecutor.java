package org.example.core;

public class PostRequestExecutor {
    private PostRequestMaker postRequestMaker;

    public PostRequestExecutor(PostRequestMaker postRequestMaker) {
        this.postRequestMaker = postRequestMaker;
    }

    public String executePostRequest() throws Exception {
        return postRequestMaker.makePostRequest();
    }
}

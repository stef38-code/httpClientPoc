package org.example.core;

import org.example.model.Post;

public class PostRequestExecutor {
    private PostRequestMaker postRequestMaker;

    public PostRequestExecutor(PostRequestMaker postRequestMaker) {
        this.postRequestMaker = postRequestMaker;
    }

    public String executePostRequest(Post post) throws Exception {
        return postRequestMaker.makePostRequest(post);
    }
}

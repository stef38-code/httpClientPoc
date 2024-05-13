package org.example.core;

public class PostRequestExecutor<T, R> {
    private PostRequestMaker<T, R> postRequestMaker;

    public PostRequestExecutor(PostRequestMaker<T, R> postRequestMaker) {
        this.postRequestMaker = postRequestMaker;
    }

    public R executePostRequest(T post,
                                String url) throws Exception {
        return postRequestMaker.makePostRequest(post, url);
    }
}

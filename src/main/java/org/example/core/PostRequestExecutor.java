package org.example.core;

public class PostRequestExecutor<T, R> implements PostRequestMakerStep<T, R>, BodyStep<T, R>, UrlStep<T, R>, BuildStep<R> {
    private PostRequestMaker<T, R> postRequestMaker;
    private T body;
    private String url;

    private PostRequestExecutor() {
    }

    public static <T, R> PostRequestMakerStep<T, R> builder() {
        return new PostRequestExecutor<>();
    }

    @Override
    public BodyStep<T, R> postRequestMaker(PostRequestMaker<T, R> postRequestMaker) {
        this.postRequestMaker = postRequestMaker;
        return this;
    }

    @Override
    public UrlStep<T, R> body(T body) {
        this.body = body;
        return this;
    }

    @Override
    public BuildStep<R> url(String url) {
        this.url = url;
        return this;
    }

    @Override
    public R build() throws Exception {
        return postRequestMaker.makePostRequest(body, url);
    }
}

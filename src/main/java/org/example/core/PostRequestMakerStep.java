package org.example.core;

public interface PostRequestMakerStep<T, R> {
    BodyStep<T, R> postRequestMaker(PostRequestMaker<T, R> postRequestMaker);
}

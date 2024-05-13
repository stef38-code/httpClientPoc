package org.example.core;

public interface PostRequestMaker<T, R> {
    R makePostRequest(T body, String url) throws Exception;
}

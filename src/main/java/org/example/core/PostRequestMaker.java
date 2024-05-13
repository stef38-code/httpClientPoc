package org.example.core;

public interface PostRequestMaker<T> {
    String makePostRequest(T body,
                           String url) throws Exception;
}

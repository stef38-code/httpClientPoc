package org.example.core;

public interface UrlStep<T, R> {
    BuildStep<R> url(String url);
}

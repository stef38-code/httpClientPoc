package org.example.core;

public interface BodyStep<T, R> {
    UrlStep<T, R> body(T body);
}

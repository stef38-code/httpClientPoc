package org.example.core;

public interface BuildStep<R> {
    R build() throws Exception;
}

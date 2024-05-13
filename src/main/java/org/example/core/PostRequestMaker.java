package org.example.core;

import org.example.model.Post;

public interface PostRequestMaker {
    String makePostRequest(Post post, String url) throws Exception;
}

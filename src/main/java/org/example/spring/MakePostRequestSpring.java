package org.example.spring;


import org.example.core.PostRequestMaker;
import org.example.model.Post;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class MakePostRequestSpring implements PostRequestMaker<Post> {
    @Override
    public String makePostRequest(Post post,
                                  String url) {
        RestTemplate restTemplate = new RestTemplate();


        // Création des headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Création de l'entité Http
        HttpEntity<Post> entity = new HttpEntity<>(post, headers);

        // Envoi de la requête POST
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
    }
}



package org.example.spring;


import org.example.model.Post;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MakePostRequestSpring {
    public ResponseEntity<String> makePostRequest() {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://jsonplaceholder.typicode.com/posts";

            // Création de l'objet à envoyer
            Post post = new Post();
            post.setTitle("foo");
            post.setBody("bar");
            post.setUserId(1);

            // Création des headers
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            // Création de l'entité Http
            HttpEntity<Post> entity = new HttpEntity<>(post, headers);

            // Envoi de la requête POST
            return  restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }
}



package org.example.spring;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class MakePostRequestRetrofit {

    public interface PostService {
        @POST("posts")
        Call<String> createPost(@Body Post post);
    }

    public String makePostRequest() throws Exception {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PostService service = retrofit.create(PostService.class);

        Post post = new Post();
        post.setTitle("foo");
        post.setBody("bar");
        post.setUserId(1);

        Call<String> call = service.createPost(post);

        return call.execute().body();
    }
}

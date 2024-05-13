package org.example.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.ResponseBody;
import org.example.model.Post;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class MakePostRequestRetrofit {

    public interface PostService {
        @POST("posts")
        Call<ResponseBody> createPost(@Body Post post);
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

        Call<ResponseBody> call = service.createPost(post);

        ResponseBody body = call.execute().body();
        return body.string();
    }
}

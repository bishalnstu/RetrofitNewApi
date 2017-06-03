package me.imbishal.retrofitnew;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ROOT on 6/4/2017.
 */

public interface GithubClient {

    @GET("/users/{user}/repos")
    Call<ArrayList<GitHubRepos>>reposforUser(@Path("user") String user);

}

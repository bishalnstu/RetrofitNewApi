package me.imbishal.retrofitnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

     public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        listView = (ListView) findViewById(R.id.reposList);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

         Retrofit retrofit = builder.build();

        GithubClient githubClient = retrofit.create(GithubClient.class);
        Call<ArrayList<GitHubRepos>> call = githubClient.reposforUser("bishalnstu");

        call.enqueue(new Callback<ArrayList<GitHubRepos>>() {
            @Override
            public void onResponse(Call<ArrayList<GitHubRepos>> call, Response<ArrayList<GitHubRepos>> response) {

                ArrayList<GitHubRepos> repos = response.body();

                listView.setAdapter(new CustomArrayAdapter(MainActivity.this,repos));

                Toast.makeText(getApplicationContext(),"Success!!!",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ArrayList<GitHubRepos>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Error!!!",Toast.LENGTH_LONG).show();
            }
        });
    }


}

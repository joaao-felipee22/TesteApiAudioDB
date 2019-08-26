  package com.example.theaudiodb.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.theaudiodb.R;
import com.example.theaudiodb.controller.PlayListAdapter;
import com.example.theaudiodb.model.Playlist;
import com.example.theaudiodb.model.Pojo;
import com.example.theaudiodb.service.ClientRetrofit;
import com.example.theaudiodb.service.ServiceGet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

  public class MainActivity extends AppCompatActivity {


      RecyclerView recyclerView;
      PlayListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ServiceGet serviceGet = ClientRetrofit.getClient().create(ServiceGet.class);

        Call<Playlist> call = serviceGet.getPlaylist();

        call.enqueue(new Callback<Playlist>() {
            @Override
            public void onResponse(Call<Playlist> call, Response<Playlist> response) {
                generateListCards((ArrayList<Pojo>) response.body().getListPlay());
            }

            @Override
            public void onFailure(Call<Playlist> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Deu merda", Toast.LENGTH_SHORT).show();

            }
        });
    }

      private void generateListCards(ArrayList<Pojo> listaCards) {

          recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

          adapter = new PlayListAdapter(listaCards, MainActivity.this);

          RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

          recyclerView.setLayoutManager(layoutManager);

          recyclerView.setAdapter(adapter);
      }
}

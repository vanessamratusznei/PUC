package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WatchedActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WatchedAnimeAdapter adapter;
    private AnimeDatabaseHelper dbHelper;
    private List<Anime> listaAssistidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watched);

        dbHelper = new AnimeDatabaseHelper(this);
        recyclerView = findViewById(R.id.recyclerViewAssistidos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        carregarAnimesAssistidos();
    }

    private void carregarAnimesAssistidos() {
        listaAssistidos = dbHelper.getAnimesAssistidos();
        adapter = new WatchedAnimeAdapter(listaAssistidos);
        recyclerView.setAdapter(adapter);
    }
}


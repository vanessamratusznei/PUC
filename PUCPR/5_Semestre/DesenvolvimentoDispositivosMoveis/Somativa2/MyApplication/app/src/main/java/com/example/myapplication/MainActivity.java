package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AnimeAdapter adapter;
    private AnimeDatabaseHelper dbHelper;
    private List<Anime> animeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new AnimeDatabaseHelper(this);
        recyclerView = findViewById(R.id.recyclerViewAnimes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        carregarAnimes();

        FloatingActionButton fabAdd = findViewById(R.id.fabAdicionarAnime);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEditAnimeActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fabAssistidos = findViewById(R.id.fabAssistidos);
        fabAssistidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WatchedActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarAnimes(); // recarrega a lista ao voltar
    }

    private void carregarAnimes() {
        animeList = dbHelper.getAnimesParaAssistir();
        adapter = new AnimeAdapter(animeList, new AnimeAdapter.OnAnimeActionListener() {
            @Override
            public void onMarcarComoAssistido(Anime anime) {
                mostrarDialogoGostou(anime);
            }

            @Override
            public void onEditar(Anime anime) {
                Intent intent = new Intent(MainActivity.this, AddEditAnimeActivity.class);
                intent.putExtra("anime_id", anime.getId());
                startActivity(intent);
            }

            @Override
            public void onExcluir(Anime anime) {
                dbHelper.deleteAnime(anime.getId());
                carregarAnimes();
                Toast.makeText(MainActivity.this, "Anime excluído", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private void mostrarDialogoGostou(Anime anime) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Você gostou de \"" + anime.getNome() + "\"?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                anime.setAssistido(true);
                anime.setGostou(true);
                dbHelper.updateAnime(anime);
                carregarAnimes();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                anime.setAssistido(true);
                anime.setGostou(false);
                dbHelper.updateAnime(anime);
                carregarAnimes();
            }
        });
        builder.setNeutralButton("Cancelar", null);
        builder.show();
    }
}

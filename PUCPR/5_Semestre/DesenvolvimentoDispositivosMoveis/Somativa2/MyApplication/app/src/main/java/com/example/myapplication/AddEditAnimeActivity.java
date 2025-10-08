package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddEditAnimeActivity extends AppCompatActivity {

    private EditText editTextNome;
    private Button btnSalvar;

    private AnimeDatabaseHelper dbHelper;
    private Anime animeParaEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_anime);

        dbHelper = new AnimeDatabaseHelper(this);
        editTextNome = findViewById(R.id.editTextNome);
        btnSalvar = findViewById(R.id.btnSalvar);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("anime_id")) {
            // Editar anime existente
            int animeId = intent.getIntExtra("anime_id", -1);
            animeParaEditar = encontrarAnimePorId(animeId);
            if (animeParaEditar != null) {
                editTextNome.setText(animeParaEditar.getNome());
            }
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString().trim();
                if (TextUtils.isEmpty(nome)) {
                    Toast.makeText(AddEditAnimeActivity.this, "Informe o nome do anime", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (animeParaEditar != null) {
                    animeParaEditar.setNome(nome);
                    dbHelper.updateAnime(animeParaEditar);
                    Toast.makeText(AddEditAnimeActivity.this, "Anime atualizado", Toast.LENGTH_SHORT).show();
                } else {
                    Anime novoAnime = new Anime(nome);
                    dbHelper.addAnime(novoAnime);
                    Toast.makeText(AddEditAnimeActivity.this, "Anime adicionado", Toast.LENGTH_SHORT).show();
                }

                finish(); // Voltar para a tela principal
            }
        });
    }

    private Anime encontrarAnimePorId(int id) {
        for (Anime anime : dbHelper.getAnimesParaAssistir()) {
            if (anime.getId() == id) return anime;
        }
        for (Anime anime : dbHelper.getAnimesAssistidos()) {
            if (anime.getId() == id) return anime;
        }
        return null;
    }
}


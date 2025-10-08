package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {

    private List<Anime> animeList;
    private OnAnimeActionListener listener;

    public interface OnAnimeActionListener {
        void onMarcarComoAssistido(Anime anime);
        void onEditar(Anime anime);
        void onExcluir(Anime anime);
    }

    public AnimeAdapter(List<Anime> animeList, OnAnimeActionListener listener) {
        this.animeList = animeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_anime, parent, false);
        return new AnimeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Anime anime = animeList.get(position);
        holder.textNome.setText(anime.getNome());

        holder.btnAssistido.setOnClickListener(v -> {
            listener.onMarcarComoAssistido(anime);
        });

        holder.btnEditar.setOnClickListener(v -> {
            listener.onEditar(anime);
        });

        holder.btnExcluir.setOnClickListener(v -> {
            listener.onExcluir(anime);
        });
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {

        TextView textNome;
        ImageButton btnAssistido, btnEditar, btnExcluir;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.textNome);
            btnAssistido = itemView.findViewById(R.id.btnAssistido);
            btnEditar = itemView.findViewById(R.id.btnEditar);
            btnExcluir = itemView.findViewById(R.id.btnExcluir);
        }
    }
}


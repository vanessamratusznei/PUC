package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WatchedAnimeAdapter extends RecyclerView.Adapter<WatchedAnimeAdapter.AnimeViewHolder> {

    private List<Anime> listaAssistidos;

    public WatchedAnimeAdapter(List<Anime> listaAssistidos) {
        this.listaAssistidos = listaAssistidos;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_watched_anime, parent, false);
        return new AnimeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Anime anime = listaAssistidos.get(position);
        holder.textNome.setText(anime.getNome());

        if (Boolean.TRUE.equals(anime.getGostou())) {
            holder.imageStatus.setImageResource(android.R.drawable.btn_star_big_on); // Gostou
        } else {
            holder.imageStatus.setImageResource(android.R.drawable.btn_star_big_off); // Não gostou
        }
    }

    @Override
    public int getItemCount() {
        return listaAssistidos.size();
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        TextView textNome;
        ImageView imageStatus;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.textNomeAssistido);
            imageStatus = itemView.findViewById(R.id.imageStatus);
        }
    }
}


package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

// Classe para gerenciar o banco de dados SQLite
public class AnimeDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "animes.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "animes";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOME = "nome";
    private static final String COLUMN_ASSISTIDO = "assistido";
    private static final String COLUMN_GOSTOU = "gostou";

    public AnimeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Criação da tabela
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NOME + " TEXT NOT NULL, "
                + COLUMN_ASSISTIDO + " INTEGER NOT NULL DEFAULT 0, "
                + COLUMN_GOSTOU + " INTEGER)";
        db.execSQL(sql);
    }

    // Atualização do banco, se necessário
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Inserir novo anime
    public void addAnime(Anime anime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOME, anime.getNome());
        values.put(COLUMN_ASSISTIDO, anime.isAssistido() ? 1 : 0);
        if (anime.getGostou() != null) {
            values.put(COLUMN_GOSTOU, anime.getGostou() ? 1 : 0);
        } else {
            values.putNull(COLUMN_GOSTOU);
        }
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Atualizar anime
    public void updateAnime(Anime anime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOME, anime.getNome());
        values.put(COLUMN_ASSISTIDO, anime.isAssistido() ? 1 : 0);
        if (anime.getGostou() != null) {
            values.put(COLUMN_GOSTOU, anime.getGostou() ? 1 : 0);
        } else {
            values.putNull(COLUMN_GOSTOU);
        }
        db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(anime.getId())});
        db.close();
    }

    // Deletar anime
    public void deleteAnime(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // Listar animes NÃO assistidos
    public List<Anime> getAnimesParaAssistir() {
        List<Anime> animeList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_ASSISTIDO + " = 0", null, null, null, COLUMN_NOME);
        if (cursor.moveToFirst()) {
            do {
                Anime anime = fromCursor(cursor);
                animeList.add(anime);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return animeList;
    }

    // Listar animes assistidos
    public List<Anime> getAnimesAssistidos() {
        List<Anime> animeList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_ASSISTIDO + " = 1", null, null, null, COLUMN_NOME);
        if (cursor.moveToFirst()) {
            do {
                Anime anime = fromCursor(cursor);
                animeList.add(anime);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return animeList;
    }

    // Constrói um objeto Anime a partir de um Cursor
    private Anime fromCursor(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
        String nome = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOME));
        boolean assistido = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ASSISTIDO)) == 1;
        int gostouIndex = cursor.getColumnIndexOrThrow(COLUMN_GOSTOU);
        Boolean gostou = null;
        if (!cursor.isNull(gostouIndex)) {
            gostou = cursor.getInt(gostouIndex) == 1;
        }
        return new Anime(id, nome, assistido, gostou);
    }
}


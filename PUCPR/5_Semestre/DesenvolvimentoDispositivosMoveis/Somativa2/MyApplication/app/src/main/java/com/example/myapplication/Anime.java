package com.example.myapplication;

// Classe modelo para representar um anime
public class Anime {

    private int id;             // ID único no banco de dados
    private String nome;        // Nome do anime
    private boolean assistido;  // true = assistido, false = ainda não
    private Boolean gostou;     // null = ainda não respondeu, true = gostou, false = não gostou

    // Construtor padrão
    public Anime() {}

    // Construtor completo
    public Anime(int id, String nome, boolean assistido, Boolean gostou) {
        this.id = id;
        this.nome = nome;
        this.assistido = assistido;
        this.gostou = gostou;
    }

    // Construtor sem ID (para inserções no banco)
    public Anime(String nome) {
        this.nome = nome;
        this.assistido = false;
        this.gostou = null;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAssistido() {
        return assistido;
    }

    public void setAssistido(boolean assistido) {
        this.assistido = assistido;
    }

    public Boolean getGostou() {
        return gostou;
    }

    public void setGostou(Boolean gostou) {
        this.gostou = gostou;
    }
}

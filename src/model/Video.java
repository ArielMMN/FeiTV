/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ariel
 */
package model;

public abstract class Video {
    private int idVideo;
    private String titulo;
    private String descricao;
    private String tipo; // "filme" ou "serie"
    private int anoLancamento;

    public Video(int idVideo, String titulo, String descricao, String tipo, int anoLancamento) {
        this.idVideo = idVideo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.anoLancamento = anoLancamento;
    }

    // Getters e Setters
    public int getIdVideo() { return idVideo; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getTipo() { return tipo; }
    public int getAnoLancamento() { return anoLancamento; }

    public void setIdVideo(int idVideo) { this.idVideo = idVideo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setAnoLancamento(int anoLancamento) { this.anoLancamento = anoLancamento; }

    // Método abstrato para obrigar subclasses a implementar
    public abstract void exibirInfo();
}

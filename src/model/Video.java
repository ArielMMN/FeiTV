/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ariel
 */
public abstract class Video {
    private int idVideo;
    private String titulo;
    private String descricao;
    private String tipo;
    private int anoLancamento;

    public Video(int idVideo, String titulo, String descricao, String tipo, int anoLancamento) {
        this.idVideo = idVideo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.anoLancamento = anoLancamento;
    }

    public int getIdVideo() { return idVideo; }
    public void setIdVideo(int idVideo) { this.idVideo = idVideo; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getAnoLancamento() { return anoLancamento; }
    public void setAnoLancamento(int anoLancamento) { this.anoLancamento = anoLancamento; }
}

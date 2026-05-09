/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ariel
 */
import java.util.ArrayList;
import java.util.List;

public class ListaReproducao {
    private int idLista;
    private String nomeLista;
    private Usuario usuario;
    private List<Video> videos;

    public ListaReproducao(int idLista, String nomeLista, Usuario usuario) {
        this.idLista = idLista;
        this.nomeLista = nomeLista;
        this.usuario = usuario;
        this.videos = new ArrayList<>();
    }

    public int getIdLista() { return idLista; }
    public void setIdLista(int idLista) { this.idLista = idLista; }

    public String getNomeLista() { return nomeLista; }
    public void setNomeLista(String nomeLista) { this.nomeLista = nomeLista; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<Video> getVideos() { return videos; }
    public void adicionarVideo(Video video) { videos.add(video); }
    public void removerVideo(Video video) { videos.remove(video); }
}


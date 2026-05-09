/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ariel
 */
public class Curtida {
    private Usuario usuario;
    private Video video;

    public Curtida(Usuario usuario, Video video) {
        this.usuario = usuario;
        this.video = video;
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Video getVideo() { return video; }
    public void setVideo(Video video) { this.video = video; }
}


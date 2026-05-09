/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ariel
 */
public class Serie extends Video {
    private int temporadas;

    public Serie(int idVideo, String titulo, String descricao, int anoLancamento, int temporadas) {
        super(idVideo, titulo, descricao, "serie", anoLancamento);
        this.temporadas = temporadas;
    }

    public int getTemporadas() { return temporadas; }
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }
}


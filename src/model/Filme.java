/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Filme extends Video {
    private int duracao; // em minutos

    public Filme(int idVideo, String titulo, String descricao, int anoLancamento, int duracao) {
        super(idVideo, titulo, descricao, "filme", anoLancamento);
        this.duracao = duracao;
    }

    public int getDuracao() { return duracao; }
    public void setDuracao(int duracao) { this.duracao = duracao; }

    @Override
    public void exibirInfo() {
        System.out.println("Filme: " + getTitulo() + " (" + getAnoLancamento() + ") - Duração: " + duracao + " min");
    }
}


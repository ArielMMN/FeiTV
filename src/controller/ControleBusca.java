/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.VideoDAO;
import model.Usuario;
import model.Video;
import view.Busca;
import view.DetalhesVideo;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;

public class ControleBusca {

    private Busca tela;
    private Usuario usuario;
    private List<Video> resultados;

    public ControleBusca(Busca tela, Usuario usuario) {
        this.tela = tela;
        this.usuario = usuario;
    }

    public List<Video> buscarVideos(String termo) {
        VideoDAO dao = new VideoDAO();
        try {
            resultados = dao.buscarPorNome(termo);
            return resultados;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela,
                "Erro ao buscar videos: " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void abrirDetalhes(int indiceSelecionado) {
        if (resultados == null || indiceSelecionado < 0 || indiceSelecionado >= resultados.size()) {
            JOptionPane.showMessageDialog(tela, "Selecione um video.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Video video = resultados.get(indiceSelecionado);
        DetalhesVideo detalhes = new DetalhesVideo(video, usuario);
        detalhes.setVisible(true);
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

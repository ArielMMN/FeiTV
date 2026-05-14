package controller;
 
import dao.CurtidaDAO;
import dao.FavoritoDAO;
import dao.ListaReproducaoDAO;
import model.ListaReproducao;
import model.Usuario;
import model.Video;
import view.DetalhesVideo;
 
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;
 
public class ControleDetalhesVideo {
 
    private DetalhesVideo tela;
    private Video video;
    private Usuario usuario;
 
    public ControleDetalhesVideo(DetalhesVideo tela, Video video, Usuario usuario) {
        this.tela = tela;
        this.video = video;
        this.usuario = usuario;
    }
 
    public boolean isCurtido() {
        try {
            return new CurtidaDAO().isCurtido(usuario.getIdUsuario(), video.getIdVideo());
        } catch (SQLException e) {
            return false;
        }
    }
 
    public int contarCurtidas() {
        try {
            return new CurtidaDAO().contarCurtidas(video.getIdVideo());
        } catch (SQLException e) {
            return 0;
        }
    }
 
    public void curtir() {
        try {
            new CurtidaDAO().curtirVideo(usuario.getIdUsuario(), video.getIdVideo());
            JOptionPane.showMessageDialog(tela, "Video curtido!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao curtir: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    public void descurtir() {
        try {
            new CurtidaDAO().descurtirVideo(usuario.getIdUsuario(), video.getIdVideo());
            JOptionPane.showMessageDialog(tela, "Curtida removida!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao descurtir: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    public void adicionarFavorito() {
        try {
            new FavoritoDAO().adicionarFavorito(usuario.getIdUsuario(), video.getIdVideo());
            JOptionPane.showMessageDialog(tela, "Adicionado aos favoritos!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao favoritar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    public List<ListaReproducao> listarListas() {
        try {
            return new ListaReproducaoDAO().listarPorUsuario(usuario);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao carregar listas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
 
    public void adicionarNaLista(int idLista) {
        try {
            new ListaReproducaoDAO().adicionarVideo(idLista, video.getIdVideo());
            JOptionPane.showMessageDialog(tela, "Video adicionado a lista!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao adicionar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
 
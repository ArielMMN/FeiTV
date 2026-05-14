package controller;
 
import dao.FavoritoDAO;
import model.Usuario;
import model.Video;
import view.Favoritos;
 
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;
 
public class ControleFavoritos {
 
    private Favoritos tela;
    private Usuario usuario;
 
    public ControleFavoritos(Favoritos tela, Usuario usuario) {
        this.tela = tela;
        this.usuario = usuario;
    }
 
    public List<Video> carregarFavoritos() {
        try {
            return new FavoritoDAO().listarFavoritos(usuario.getIdUsuario());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao carregar favoritos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
 
    public void removerFavorito(int idVideo) {
        try {
            new FavoritoDAO().removerFavorito(usuario.getIdUsuario(), idVideo);
            JOptionPane.showMessageDialog(tela, "Removido dos favoritos!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao remover: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    public Usuario getUsuario() {
        return usuario;
    }
}
 

package controller;

import dao.UsuarioDAO;
import dao.Conexao;
import model.Usuario;
import view.Login;
import view.Logado;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleLogin {
    private Login tela1;
    
    public ControleLogin(Login tela1){
        this.tela1 = tela1;
    }
    
    public void loginUsuario(){
        // pega email e senha da tela
        String email = tela1.getTxtUsuario().getText();
        String senha = tela1.getTxtSenha().getText();

        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO();
            
            // chama o método login do DAO
            Usuario usuarioLogado = dao.login(email, senha);

            if(usuarioLogado != null){
                JOptionPane.showMessageDialog(tela1, 
                    "Login efetuado com sucesso!", 
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);

                // abre tela Logado com o objeto Usuario
                Logado tela2 = new Logado(usuarioLogado);
                tela2.setVisible(true);
                tela1.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(tela1, 
                    "Login não efetuado. Verifique usuário e senha.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(tela1, 
                "Erro de conexão: " + e.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
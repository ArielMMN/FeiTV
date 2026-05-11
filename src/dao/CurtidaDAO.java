/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;

public class CurtidaDAO {
    private Conexao conexao = new Conexao();

    public void curtirVideo(int usuarioId, int videoId) throws SQLException {
        String sql = "INSERT INTO curtida (usuario_id, video_id) VALUES (?, ?)";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);
            stmt.executeUpdate();
        }
    }

    public void descurtirVideo(int usuarioId, int videoId) throws SQLException {
        String sql = "DELETE FROM curtida WHERE usuario_id = ? AND video_id = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);
            stmt.executeUpdate();
        }
    }

    
}


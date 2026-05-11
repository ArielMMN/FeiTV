/*
 * DAO para gerenciar vídeos
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Video;
import model.Filme;
import model.Serie;

public class VideoDAO {
    private Conexao conexao;

    public VideoDAO() {
        this.conexao = new Conexao();
    }

    public List<Video> buscarPorNome(String nome) throws SQLException {
        List<Video> videos = new ArrayList<>();
        String sql = "SELECT * FROM video WHERE titulo ILIKE ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String tipo = rs.getString("tipo");
                Video video;

                if (tipo.equalsIgnoreCase("filme")) {
                    video = new Filme(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getInt("anoLancamento"),
                        rs.getInt("duracao")
                    );
                } else if (tipo.equalsIgnoreCase("serie")) {
                    video = new Serie(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getInt("anoLancamento"),
                        rs.getInt("temporadas")
                    );
                } else {
                    continue; // ignora tipos desconhecidos
                }

                videos.add(video);
            }
        }
        return videos;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem.DAO;

import eduSystem.DatabaseManager;
import eduSystem.Eleve;
import eduSystem.Serie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ytchao
 */
public class EleveDAO {

    public static boolean add(Eleve e) {
        if (e.getSerie() == null) {
            System.err.println("Erreur : l’élève n’a pas de série associée !");
            return false;
        }

        String sql = "INSERT INTO eleve(id, nom, coordonnees, id_serie) VALUES(?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, e.getId());
            pstmt.setString(2, e.getNom());
            pstmt.setString(3, e.getCoordonnees());
            pstmt.setInt(4, e.getSerie().getId());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static List<Eleve> getAll() {
        List<Eleve> list = new ArrayList<>();
        String sql = "SELECT * FROM eleve";

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String coord = rs.getString("coordonnees");
                Serie serie = new Serie(rs.getInt("id_serie"));
                Eleve e = new Eleve(id, nom, coord, serie);
                list.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public static List<Eleve> getBySerieId(int idSerie) {
    List<Eleve> eleves = new ArrayList<>();
    String sql = "SELECT * FROM eleve WHERE id_serie = ?";
    
    try (Connection conn = DatabaseManager.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, idSerie);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Serie serie = new Serie(idSerie);
            Eleve e = new Eleve(rs.getInt("id"), rs.getString("nom"), rs.getString("coordonnees"), serie);
            eleves.add(e);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return eleves;
}
}
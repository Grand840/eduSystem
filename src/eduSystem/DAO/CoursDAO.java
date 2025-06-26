/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem.DAO;

import eduSystem.Cours;
import eduSystem.DatabaseManager;
import eduSystem.Local;
import eduSystem.Professeur;
import eduSystem.Serie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ytchao
 */
public class CoursDAO {

    public static boolean add(Cours c) {
        String sql = "INSERT INTO cours(id, nom, id_prof, id_local) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, c.getId());
            pstmt.setString(2, c.getNom());
            pstmt.setInt(3, c.getProfesseur().getId());
            pstmt.setInt(4, c.getLocal().getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Cours> getAll() {
        List<Cours> list = new ArrayList<>();
        String sql = "SELECT c.id, c.nom, p.id AS prof_id, p.nom AS prof_nom, l.id AS local_id, l.batiment, l.etage, l.numero " +
                     "FROM cours c " +
                     "JOIN professeur p ON c.id_prof = p.id " +
                     "JOIN local l ON c.id_local = l.id";

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");

                int profId = rs.getInt("prof_id");
                String profNom = rs.getString("prof_nom");
                Professeur prof = new Professeur(profId, profNom);

                int localId = rs.getInt("local_id");
                char bat = rs.getString("batiment").charAt(0);
                int etage = rs.getInt("etage");
                int numero = rs.getInt("numero");
                Local local = new Local(localId, bat, etage, numero);

                Cours cours = new Cours(id, nom, prof, local);
                list.add(cours);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public static List<Serie> getSeriesByCoursId(int idCours) {
    List<Serie> series = new ArrayList<>();
    String sql = "SELECT id_serie FROM cours_serie WHERE id_cours = ?";
    
    try (Connection conn = DatabaseManager.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, idCours);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            series.add(new Serie(rs.getInt("id_serie")));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return series;
}
}
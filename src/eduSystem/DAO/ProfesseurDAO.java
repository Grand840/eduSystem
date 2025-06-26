/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem.DAO;

import java.sql.*;
import eduSystem.DatabaseManager;
import eduSystem.Professeur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ytchao
 */
public class ProfesseurDAO {

    public static boolean add(Professeur p) {
        String sql = "INSERT INTO professeur(id, nom) VALUES(?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, p.getId());
            pstmt.setString(2, p.getNom());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Professeur> getAll() {
        List<Professeur> list = new ArrayList<>();
        String sql = "SELECT * FROM professeur";

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Professeur p = new Professeur(rs.getInt("id"), rs.getString("nom"));
                list.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem.DAO;

import eduSystem.DatabaseManager;
import eduSystem.Local;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ytchao
 */

public class LocalDAO {

    public static boolean add(Local l) {
        String sql = "INSERT INTO local(id, batiment, etage, numero) VALUES(?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, l.getId());
            pstmt.setString(2, String.valueOf(l.getBatiment()));
            pstmt.setInt(3, l.getEtage());
            pstmt.setInt(4, l.getNumero());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Local> getAll() {
        List<Local> list = new ArrayList<>();
        String sql = "SELECT * FROM local";

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                char batiment = rs.getString("batiment").charAt(0);
                int etage = rs.getInt("etage");
                int numero = rs.getInt("numero");

                list.add(new Local(id, batiment, etage, numero));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
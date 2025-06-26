/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem.DAO;

import eduSystem.DatabaseManager;
import eduSystem.Serie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ytchao
 */
public class SerieDAO {

    public static boolean add(Serie s) {
        String sql = "INSERT INTO serie(id) VALUES(?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, s.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Serie> getAll() {
        List<Serie> list = new ArrayList<>();
        String sql = "SELECT * FROM serie";

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Serie(rs.getInt("id")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
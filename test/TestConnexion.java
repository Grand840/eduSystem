/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.SQLException;
import eduSystem.DatabaseManager;

/**
 *
 * @author ytchao
 */
public class TestConnexion {
    public static void main(String[] args) {
        try {
            DatabaseManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


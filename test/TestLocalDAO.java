
import eduSystem.DAO.LocalDAO;
import eduSystem.Local;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ytchao
 */
public class TestLocalDAO {
    public static void main(String[] args) {
        System.out.println("✅ Connexion SQLite établie.");

        // Test d'ajout
        Local l1 = new Local(20, 'T', 4, 9);
        boolean ajout1 = LocalDAO.add(l1);
        if (ajout1) {
            System.out.println("✅ Local ajouté avec succès !");
        } else {
            System.out.println("❌ Échec de l’ajout du local.");
        }

        // Test récupération
        List<Local> locaux = LocalDAO.getAll();
        System.out.println("Liste des locaux :");
        for (Local l : locaux) {
            System.out.println(" - " + l.getId() + ": " + l.getCoordonnees());
        }
    }
}

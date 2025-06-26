
import eduSystem.Cours;
import eduSystem.DAO.CoursDAO;
import eduSystem.DAO.LocalDAO;
import eduSystem.DAO.ProfesseurDAO;
import eduSystem.DatabaseManager;
import eduSystem.Local;
import eduSystem.Professeur;
import eduSystem.Serie;
import java.util.List;
import java.sql.SQLException;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ytchao
 */
public class TestCoursDAO {

    public static void main(String[] args) throws SQLException {
        System.out.println("✅ Connexion SQLite établie.");
        DatabaseManager.getConnection(); // Pour tester la connexion

        List<Professeur> profs = ProfesseurDAO.getAll();
        List<Local> locaux = LocalDAO.getAll();

        if (profs.isEmpty() || locaux.isEmpty()) {
            System.out.println("❌ Veuillez d’abord ajouter des professeurs et des locaux.");
            return;
        }

        Professeur p = profs.get(0);
        Local l = locaux.get(0);

        Cours cours = new Cours(100, "Programmation Orientée Objet", p, l);

        boolean added = CoursDAO.add(cours);
        if (added) {
            System.out.println("✅ Cours ajouté avec succès !");
        } else {
            System.out.println("❌ Échec de l’ajout du cours.");
        }

        List<Cours> coursList = CoursDAO.getAll();
        System.out.println("Liste des cours :");
        for (Cours c : coursList) {
            System.out.println(" - ID " + c.getId() + ": " + c.getNom() + " | Prof: " + c.getProfesseur().getNom() + " | Local: " + c.getLocal().getCoordonnees());
        }
    }
}
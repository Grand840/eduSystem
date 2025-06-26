/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import eduSystem.*;
import eduSystem.DAO.*;
import java.util.List;
import java.sql.SQLException;


/**
 *
 * @author ytchao
 */

public class TestAllDAO {

    public static void main(String[] args) throws SQLException {
        System.out.println("✅ Connexion SQLite établie.");
        DatabaseManager.getConnection();

        // === Test Professeur ===
        Professeur prof = new Professeur(99, "Dr. Élodie");
        if (ProfesseurDAO.add(prof)) {
            System.out.println("✅ Professeur ajouté.");
        }
        List<Professeur> profs = ProfesseurDAO.getAll();
        for (Professeur p : profs) {
            System.out.println("👨‍🏫 Professeur : " + p.getId() + " - " + p.getNom());
        }

        // === Test Local ===
        Local local = new Local(77, 'D', 1, 5);
        if (LocalDAO.add(local)) {
            System.out.println("✅ Local ajouté.");
        }
        List<Local> locaux = LocalDAO.getAll();
        for (Local l : locaux) {
            System.out.println("📍 Local : " + l.getId() + " - " + l.getCoordonnees());
        }

        // === Test Série ===
        Serie serie = new Serie(101);
        if (SerieDAO.add(serie)) {
            System.out.println("✅ Série ajoutée.");
        }
        List<Serie> series = SerieDAO.getAll();
        for (Serie s : series) {
            System.out.println("📘 Série : " + s.getId());
        }

        // === Test Élève ===
        Eleve eleve = new Eleve(202, "Amivi", "Lomé", serie);
        if (EleveDAO.add(eleve)) {
            System.out.println("✅ Élève ajouté.");
        }
        List<Eleve> eleves = EleveDAO.getAll();
        for (Eleve e : eleves) {
            System.out.println("🧑‍🎓 Élève : " + e.getId() + " - " + e.getNom() + " | Série: " + e.getSerie().getId());
        }

        // === Test Cours ===
        Cours cours = new Cours(500, "Java Avancé", prof, local);
        if (CoursDAO.add(cours)) {
            System.out.println("✅ Cours ajouté.");
        }
        List<Cours> coursList = CoursDAO.getAll();
        for (Cours c : coursList) {
            System.out.println("📚 Cours : " + c.getId() + " - " + c.getNom() + " | Prof: " + c.getProfesseur().getNom() + " | Local: " + c.getLocal().getCoordonnees());
        }

        System.out.println("✅✅ Tous les tests DAO ont été exécutés.");
    }
}
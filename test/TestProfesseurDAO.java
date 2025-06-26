/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import eduSystem.DAO.LocalDAO;
import eduSystem.DAO.ProfesseurDAO;
import eduSystem.Local;
import eduSystem.Professeur;
import java.util.List;

/**
 *
 * @author ytchao
 */
public class TestProfesseurDAO {
    public static void main(String[] args) {
        Professeur p = new Professeur(451, "Dr Joe");
        boolean result = ProfesseurDAO.add(p);
        System.out.println(result ? "Ajout prof OK" : "Erreur ajout prof");

        for (Professeur prof : ProfesseurDAO.getAll()) {
            System.out.println(prof.getId() + " - " + prof.getNom());
        }
    }
}


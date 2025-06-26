/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem.GUI;

import eduSystem.Cours;
import eduSystem.DAO.CoursDAO;
import eduSystem.DAO.LocalDAO;
import eduSystem.DAO.ProfesseurDAO;
import eduSystem.DAO.SerieDAO;
import eduSystem.Eleve;
import eduSystem.Local;
import eduSystem.Professeur;
import eduSystem.Serie;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.List;

/**
 *
 * @author ytchao
 */
public class FenetrePrincipale extends JFrame {
    public FenetrePrincipale() {
        super("Système de Gestion des Cours");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));

        JButton btnAjouterProf = new JButton("Ajouter Professeur");
        JButton btnAjouterLocal = new JButton("Ajouter Local");
        JButton btnAjouterSerie = new JButton("Ajouter Série");
        JButton btnAjouterCours = new JButton("Ajouter Cours");
        JButton btnAjouterEleve = new JButton("Ajouter Élève");
        JButton btnAfficherCours = new JButton("Afficher élèves d’un cours");
        JButton btnQuitter = new JButton("Quitter");

        panel.add(btnAjouterProf);
        panel.add(btnAjouterLocal);
        panel.add(btnAjouterSerie);
        panel.add(btnAjouterCours);
        panel.add(btnAjouterEleve);
        panel.add(btnAfficherCours);
        panel.add(btnQuitter);

        add(panel);

        btnQuitter.addActionListener(e -> System.exit(0));

        btnAjouterProf.addActionListener(e -> {
            new AjouterProfesseurForm().setVisible(true);
        });

        btnAjouterLocal.addActionListener(e -> {
            new AjouterLocalForm().setVisible(true);
        });

        btnAjouterSerie.addActionListener(e -> {
            new AjouterSerieForm().setVisible(true);
        });

        btnAjouterCours.addActionListener(e -> {
            List<Professeur> profs = ProfesseurDAO.getAll();
            List<Local> locaux = LocalDAO.getAll();
            new AjouterCoursForm(profs, locaux).setVisible(true);
        });

        btnAjouterEleve.addActionListener(e -> {
            List<Serie> series = SerieDAO.getAll();
            new AjouterEleveForm(series).setVisible(true);
        });

        btnAfficherCours.addActionListener(e -> {
            List<Cours> coursList = CoursDAO.getAll();
            new AfficherElevesCoursForm(coursList).setVisible(true);
        });
    }
}
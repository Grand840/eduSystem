/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem.GUI;

import eduSystem.Cours;
import eduSystem.DAO.CoursDAO;
import eduSystem.DAO.EleveDAO;
import eduSystem.Eleve;
import eduSystem.Serie;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ytchao
 */
public class AfficherElevesCoursForm extends JFrame {

    private JTable table;
    private JComboBox<Cours> comboCours;

    public AfficherElevesCoursForm(List<Cours> coursList) {
        super("Liste des élèves d’un cours");
        this.setSize(650, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JLabel header = new JLabel("🏠 Élèves inscrits à un cours", JLabel.LEFT);
        header.setFont(new Font("SansSerif", Font.BOLD, 18));
        header.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        panel.add(header, BorderLayout.NORTH);

        table = new JTable(new DefaultTableModel(new Object[]{"ID", "Nom", "Coordonnées", "Série"}, 0));
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        comboCours = new JComboBox<>();
        chargerCoursDepuisBD();
        comboCours.addActionListener((ActionEvent e) -> afficherElevesCours());

        bottomPanel.add(new JLabel("Choisir un cours : "), BorderLayout.WEST);
        bottomPanel.add(comboCours, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void chargerCoursDepuisBD() {
        List<Cours> coursList = CoursDAO.getAll();
        for (Cours c : coursList) {
            comboCours.addItem(c);
        }
    }

    private void afficherElevesCours() {
        Cours cours = (Cours) comboCours.getSelectedItem();
        if (cours == null) return;

        List<Serie> series = CoursDAO.getSeriesByCoursId(cours.getId());
        List<Eleve> tousLesEleves = new ArrayList<>();

        for (Serie s : series) {
            tousLesEleves.addAll(EleveDAO.getBySerieId(s.getId()));
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Eleve e : tousLesEleves) {
            model.addRow(new Object[]{
                    e.getId(),
                    e.getNom(),
                    e.getCoordonnees(),
                    e.getSerie().getId()
            });
        }
    }
}

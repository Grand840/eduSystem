/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem.GUI;

import eduSystem.DAO.ProfesseurDAO;
import eduSystem.Professeur;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ytchao
 */
public class AjouterProfesseurForm extends JFrame {

    public AjouterProfesseurForm() {
        super("Ajouter un professeur");
        this.setSize(400, 220);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // En-tête avec image
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("img/eleve.png"); // Mets une image de prof si tu en as une
        imageLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
        headerPanel.add(imageLabel);
        headerPanel.add(new JLabel("<html><h2>Ajout d’un professeur</h2></html>"));
        panel.add(headerPanel, BorderLayout.NORTH);

        // Formulaire
        JPanel formPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        formPanel.add(new JLabel("Nom du professeur :"));
        JTextField txtNom = new JTextField();
        formPanel.add(txtNom);
        panel.add(formPanel, BorderLayout.CENTER);

        // Boutons
        JPanel btnPanel = new JPanel();
        JButton btnAjouter = new JButton("Ajouter");
        JButton btnAnnuler = new JButton("Annuler");
        btnPanel.add(btnAjouter);
        btnPanel.add(btnAnnuler);
        panel.add(btnPanel, BorderLayout.SOUTH);

        btnAnnuler.addActionListener(e -> dispose());

        btnAjouter.addActionListener(e -> {
            String nom = txtNom.getText().trim();

            if (nom.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Le nom est requis.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id = (int) (Math.random() * 1000);
            Professeur p = new Professeur(id, nom);

            if (ProfesseurDAO.add(p)) {
                JOptionPane.showMessageDialog(this, "✅ Professeur ajouté avec succès.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "❌ Erreur lors de l'ajout.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panel);
    }
}
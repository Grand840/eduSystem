/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem.GUI;

import eduSystem.Cours;
import eduSystem.DAO.CoursDAO;
import eduSystem.DAO.LocalDAO;
import eduSystem.DAO.ProfesseurDAO;
import eduSystem.Local;
import eduSystem.Professeur;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ytchao
 */
public class AjouterCoursForm extends JFrame {
    public AjouterCoursForm(List<Professeur> professeurs, List<Local> locaux) {
        super("Ajouter un Cours");
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("img/cours.png");
        imageLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.add(imageLabel);
        headerPanel.add(new JLabel("<html><h2>Formulaire d’ajout de cours</h2></html>"));

        JTextField txtNomCours = new JTextField();
        JComboBox<Professeur> comboProf = new JComboBox<>();
        JComboBox<Local> comboLocal = new JComboBox<>();

        for (Professeur p : professeurs) comboProf.addItem(p);
        for (Local l : locaux) comboLocal.addItem(l);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.add(new JLabel("Nom du cours :"));
        formPanel.add(txtNomCours);
        formPanel.add(new JLabel("Professeur :"));
        formPanel.add(comboProf);
        formPanel.add(new JLabel("Local :"));
        formPanel.add(comboLocal);

        JPanel buttonPanel = new JPanel();
        JButton btnValider = new JButton("Enregistrer");
        JButton btnAnnuler = new JButton("Annuler");
        buttonPanel.add(btnValider);
        buttonPanel.add(btnAnnuler);

        btnAnnuler.addActionListener(e -> dispose());

        btnValider.addActionListener((ActionEvent e) -> {
            String nom = txtNomCours.getText().trim();
            Professeur prof = (Professeur) comboProf.getSelectedItem();
            Local local = (Local) comboLocal.getSelectedItem();

            if (nom.isEmpty() || prof == null || local == null) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                Cours cours = new Cours((int) (Math.random() * 1000), nom, prof, local);
                if (CoursDAO.add(cours)) {
                    JOptionPane.showMessageDialog(this, "Cours enregistré avec succès !");
                } else {
                    JOptionPane.showMessageDialog(this, "Erreur lors de l’enregistrement du cours", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                dispose();
            }
        });

        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
    }
}
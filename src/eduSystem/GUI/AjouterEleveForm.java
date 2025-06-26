/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem.GUI;

import eduSystem.Eleve;
import eduSystem.Serie;
import eduSystem.DAO.EleveDAO;
import eduSystem.DAO.SerieDAO;
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
public class AjouterEleveForm extends JFrame {

    public AjouterEleveForm(List<Serie> series) {
        super("Ajouter un Élève");
        this.setSize(460, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("img/eleve.png");
        imageLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
        headerPanel.add(imageLabel);
        headerPanel.add(new JLabel("<html><h2>Ajout d’un élève à une série</h2></html>"));
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        
        JTextField txtNom = new JTextField();
        JTextField txtCoordonnees = new JTextField();
        JComboBox<Serie> comboSerie = new JComboBox<>();

        
        for (Serie s : SerieDAO.getAll()) {
            comboSerie.addItem(s);
        }

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.add(new JLabel("Nom de l’élève :"));
        formPanel.add(txtNom);
        formPanel.add(new JLabel("Coordonnées :"));
        formPanel.add(txtCoordonnees);
        formPanel.add(new JLabel("Série :"));
        formPanel.add(comboSerie);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        
        JButton btnAjouter = new JButton("Ajouter");
        JButton btnAnnuler = new JButton("Annuler");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAjouter);
        buttonPanel.add(btnAnnuler);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        btnAnnuler.addActionListener(e -> dispose());

        btnAjouter.addActionListener((ActionEvent e) -> {
            String nom = txtNom.getText().trim();
            String coord = txtCoordonnees.getText().trim();
            Serie serie = (Serie) comboSerie.getSelectedItem();

            if (nom.isEmpty() || coord.isEmpty() || serie == null) {
                JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (serie.getNombresEleves() >= 20) {
                JOptionPane.showMessageDialog(this, "Cette série est déjà pleine (20 élèves).", "Erreur", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int id = (int)(Math.random() * 1000);
            Eleve eleve = new Eleve(id, nom, coord, serie);

            if (EleveDAO.add(eleve)) {
                JOptionPane.showMessageDialog(this,
                        "<html><b>Élève ajouté avec succès !</b><br>Nom : " + nom + "<br>Série : " + serie.getId() + "</html>",
                        "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Erreur lors de l’ajout en base.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(mainPanel);
    }
}
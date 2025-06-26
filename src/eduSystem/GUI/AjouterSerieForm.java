/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem.GUI;

import eduSystem.DAO.SerieDAO;
import eduSystem.Serie;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.List;
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
public class AjouterSerieForm extends JFrame {

    public AjouterSerieForm() {
        super("Ajouter une Série");
        this.setSize(400, 230);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ImageIcon icon = new ImageIcon("img/serie.png");
        JLabel imageLabel = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH)));
        JLabel titleLabel = new JLabel("<html><h2>Création d’une nouvelle série</h2></html>");
        headerPanel.add(imageLabel);
        headerPanel.add(titleLabel);

        JTextField txtIdSerie = new JTextField();

        JPanel formPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        formPanel.add(new JLabel("Identifiant de la série :"));
        formPanel.add(txtIdSerie);

        JButton btnValider = new JButton("Créer");
        JButton btnAnnuler = new JButton("Annuler");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnValider);
        buttonPanel.add(btnAnnuler);

        btnAnnuler.addActionListener(e -> dispose());

        btnValider.addActionListener((ActionEvent e) -> {
            String text = txtIdSerie.getText().trim();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer un identifiant.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int id = Integer.parseInt(text);
                List<Serie> seriesExistantes = SerieDAO.getAll();

                boolean existeDeja = seriesExistantes.stream().anyMatch(s -> s.getId() == id);
                if (existeDeja) {
                    JOptionPane.showMessageDialog(this, "Cette série existe déjà.", "Erreur", JOptionPane.WARNING_MESSAGE);
                } else {
                    Serie nouvelleSerie = new Serie(id);
                    if (SerieDAO.add(nouvelleSerie)) {
                        JOptionPane.showMessageDialog(this, "✅ Série " + id + " ajoutée avec succès !");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "❌ Erreur lors de l’enregistrement en base de données.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "L'identifiant doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}
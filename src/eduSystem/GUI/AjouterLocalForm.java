/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem.GUI;

import eduSystem.DAO.LocalDAO;
import eduSystem.Local;
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

public class AjouterLocalForm extends JFrame {
    public AjouterLocalForm() {
        super("Ajouter un Local");
        this.setSize(400, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("img/serie.png"); // Mets une image 'local.png' si dispo
        imageLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
        header.add(imageLabel);
        header.add(new JLabel("<html><h2>Ajout d’un local</h2></html>"));
        panel.add(header, BorderLayout.NORTH);

        JTextField txtBloc = new JTextField();
        JTextField txtEtage = new JTextField();
        JTextField txtNumero = new JTextField();

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.add(new JLabel("Bloc (A-Z) :"));
        formPanel.add(txtBloc);
        formPanel.add(new JLabel("Étage :"));
        formPanel.add(txtEtage);
        formPanel.add(new JLabel("Numéro :"));
        formPanel.add(txtNumero);
        panel.add(formPanel, BorderLayout.CENTER);

        JButton btnAjouter = new JButton("Ajouter");
        JButton btnAnnuler = new JButton("Annuler");
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAjouter);
        btnPanel.add(btnAnnuler);
        panel.add(btnPanel, BorderLayout.SOUTH);

        btnAnnuler.addActionListener(e -> dispose());

        btnAjouter.addActionListener(e -> {
            String blocStr = txtBloc.getText().trim();
            String etageStr = txtEtage.getText().trim();
            String numeroStr = txtNumero.getText().trim();

            if (blocStr.isEmpty() || etageStr.isEmpty() || numeroStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            char bloc = blocStr.toUpperCase().charAt(0);
            int etage = Integer.parseInt(etageStr);
            int numero = Integer.parseInt(numeroStr);

            Local local = new Local(etage, bloc, numero, numero);

            if (LocalDAO.add(local)) {
                JOptionPane.showMessageDialog(this, "✅ Local ajouté avec succès !");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "❌ Erreur lors de l'ajout du local.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panel);
    }
}
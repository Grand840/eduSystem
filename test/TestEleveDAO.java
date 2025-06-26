
import eduSystem.DAO.EleveDAO;
import eduSystem.Eleve;
import eduSystem.Serie;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ytchao
 */
public class TestEleveDAO {
    public static void main(String[] args) {
        // Création de la série (doit exister en BDD avec id = 1)
        Serie s = new Serie(1); // 💡 IMPORTANT : l’ID ici doit correspondre à la base

        // Élèves liés à la série
        Eleve e1 = new Eleve(1, "Kodjo", "Lomé", s);
        Eleve e2 = new Eleve(2, "Afi", "Sokodé", s);

        // Insertion
        boolean r1 = EleveDAO.add(e1);
        boolean r2 = EleveDAO.add(e2);

        System.out.println((r1 && r2) ? "✅ Élèves ajoutés avec succès" : "❌ Échec ajout élèves");
    }
}


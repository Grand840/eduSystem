
import eduSystem.DAO.SerieDAO;
import eduSystem.Serie;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ytchao
 */
public class TestSerieDAO {
    public static void main(String[] args) {
        Serie s = new Serie(1);
        boolean result = SerieDAO.add(s);
        System.out.println(result ? "Ajout série OK" : "Erreur ajout série");

        for (Serie serie : SerieDAO.getAll()) {
            System.out.println("Série ID : " + serie.getId());
        }
    }
}


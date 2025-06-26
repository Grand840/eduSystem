/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ytchao
 */
public class Cours {
    private int id;
    private String nom;
    private Professeur prof;
    private Local local;
    private List<Serie> series;
    
    public Cours(int id, String nom, Professeur prof, Local local){
        this.id = id;
        this.nom = nom;
        this.prof = prof;
        this.local = local;
        this.series = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Professeur getProfesseur() {
        return prof;
    }

    public Local getLocal() {
        return local;
    }
    
    public boolean ajouterSerie(Serie s){
        if(series.size() >= 4)
            return false;
        return series.add(s);
    }
    
    public List<Eleve> getEleves(){
        List<Eleve> all = new ArrayList<>();
        for(Serie s : series) {
            all.addAll(s.getListeEleves());
        }
        return all;
    }
    
    public boolean contientEleve(Eleve e){
        return getEleves().contains(e);
    }
    
    public Local aPourLocal() {
        return local;
    }

    public List<Serie> getSeries(){
        return series;
    }
    
    

    @Override
    public String toString() {
        return "Cours: " + nom + " (ID: " + id + "), Prof: " + prof.getNom() + ", Local: " + local.getCoordonnees();
    }

        
    
}

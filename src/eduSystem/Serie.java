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
public class Serie {
    private int id;
    private List<Eleve> listeEleves;
    
    public Serie(int id){
        this.id = id;
        this.listeEleves = new ArrayList<>();
    }
    
    public boolean ajouterEleve(Eleve e){
        if(listeEleves.size() >= 20)
            return false;
        return listeEleves.add(e);
    }
    
    public boolean supprimerEleve(Eleve e){
        return listeEleves.remove(e);
    }
    
    public int getNombresEleves(){
        return listeEleves.size();
    }
    
    public List<Eleve> getListeEleves(){
        return listeEleves;
    }
    
    public int getId(){
        return id;
    }
    
    @Override
    public String toString() {
        return "Série " + id + " (" + getNombresEleves() + " élèves)";
}

}

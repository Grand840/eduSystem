/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem;

/**
 *
 * @author ytchao
 */
public class Eleve extends Personne{

    private String coordonnees;
    private Serie serie;
            
    public Eleve(int id, String nom, String coordonnees, Serie serie){
        super(id, nom);
        this.coordonnees = coordonnees;
        this.serie = serie;
    }
    
    
    public Serie getSerie(){
        return serie;
    }
    
    public String getCoordonnees(){
        return coordonnees;
    }
    
    @Override
    public String toString(){
        return "Elève : " + nom + "(ID : " + id + ", Coordonnées : " + coordonnees + ")"; 
    }
}

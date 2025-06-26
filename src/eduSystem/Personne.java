/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem;

/**
 *
 * @author ytchao
 */
public abstract class Personne {
    protected int id;
    protected String nom;
    
    public Personne(int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNom(){
        return nom;
    }
    
}

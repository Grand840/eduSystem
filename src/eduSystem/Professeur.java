/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem;

/**
 *
 * @author ytchao
 */
public class Professeur extends Personne {
   
    public Professeur(int id, String nom){
        super(id, nom);
    }
    
    @Override
    public String toString(){
        return "Professeur : " + nom + "(ID :" + id +")"  ;
    }
    
    
}

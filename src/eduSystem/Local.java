/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eduSystem;

/**
 *
 * @author ytchao
 */
public class Local {
    private int id;
    private char batiment;
    private int etage;
    private int numero;
    
    public Local(int id, char batiment, int etage, int numero){
        this.id = id;
        this.batiment = batiment;
        this.etage = etage;
        this.numero = numero;
    }
    
    public int getId(){
        return id;
    }
    
    public char getBatiment(){
        return batiment;
    }
    
    public int getEtage(){
        return etage;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public String getCoordonnees(){
        return batiment + "" + numero + "-" + etage;

    }
    
    @Override
    public String toString(){
        return id + ": " + getCoordonnees();
    }
}

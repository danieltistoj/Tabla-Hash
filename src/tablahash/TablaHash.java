/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablahash;

/**
 *
 * @author Usuario
 */
public class TablaHash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Lista lista = new Lista();
        lista.InsertarFondo("", "","", "", 10);
        lista.InsertarFondo("", "","", "", 11);
        lista.InsertarFondo("", "","", "", 12);
        System.out.println(lista.Mostrar());
        */
        
        System.out.println(98 % 11);
        Tabla tablaHash = new Tabla(1,10);
        System.out.println(tablaHash.Insertar("", "", "", "", 13));
        System.out.println(tablaHash.Insertar("", "", "", "", 20));
        System.out.println(tablaHash.Insertar("", "", "", "", 78));
        System.out.println(tablaHash.Insertar("", "", "", "", 66669999));
        tablaHash.Insertar("","", "","", 55558888);
         tablaHash.Insertar("","", "","", 98);
         tablaHash.Insertar("","", "","", 100);
         tablaHash.Insertar("","", "","", 89);
         tablaHash.Insertar("","", "","", 90);
          tablaHash.Insertar("","", "","", 76);
         tablaHash.Insertar("","", "","", 55558887);
       // tablaHash.Insertar("","", "","", 13);
        tablaHash.MostrarTabla();
        System.out.println(tablaHash.getNumM());

           
    }
    
}

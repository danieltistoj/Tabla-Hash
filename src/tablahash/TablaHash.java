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
        
        Tabla tablaHash = new Tabla(0,30);
        System.out.println(tablaHash.Insertar("Juan","", "","", 55558888));
        System.out.println(tablaHash.getCadena());
        System.out.println(tablaHash.Insertar("Pedro","", "","", 54318043));
        System.out.println(tablaHash.getCadena());
        
        
       // tablaHash.Insertar("","", "","", 13);
        System.out.println(tablaHash.MostrarTabla());
        System.out.println("Buscar: 55558888. "+tablaHash.Buscar(55558888));
        System.out.println(tablaHash.getCadena());
        System.out.println("Buscar: 54318043. "+tablaHash.Buscar(54318043));
        System.out.println(tablaHash.getCadena());
        System.out.println(tablaHash.Eliminar(54318043));
        System.out.println(tablaHash.MostrarTabla());
        //System.out.println(tablaHash.getNumM());

           
    }
    
}

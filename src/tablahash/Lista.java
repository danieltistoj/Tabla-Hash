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
public class Lista {
    private Nodo tope, fondo;
    private int numValores = 0;
    private String cadena = "";
    
    public void InsertarFondo(String nombre, String correo, String organizacion, String comentario, int telefono){
        Nodo nuevo = new Nodo(nombre,correo,organizacion,comentario,telefono);
        if(Vacia()){
            tope = nuevo;
            fondo = nuevo;
            
            tope.setSiguiente(null);
            fondo.setSiguiente(null);
            
        }
        else{
            Nodo fin = fondo;
            fin.setSiguiente(nuevo);
            nuevo.setSiguiente(null);
            fondo = nuevo;
            
        }
        numValores++;
    }
   
    public void Eliminar(int telefono){
       Nodo aux = tope;
       int conta = numValores, aux2=0;
       if(aux.getTelefono()== telefono){
          
           aux = aux.getSiguiente();
           tope = aux;
           numValores--;
       }
       else{
          while(conta!=1){
              if(conta == 2 && aux.getSiguiente().getTelefono() == telefono){
                  fondo = aux;
                  fondo.setSiguiente(null);
                  numValores--;
                  break;
              }
              else if(aux.getSiguiente().getTelefono() == telefono){
                
                  aux.setSiguiente(aux.getSiguiente().getSiguiente());
                  aux2=1;
                  numValores--;
                  break;
              }
              aux = aux.getSiguiente();
              conta--;     
          }
          
       }
      
    }
    //buscar un valor de la lista 
    private boolean BuscarValor(int telefono,Nodo nodo_actual){
        boolean existe = false;
        if(nodo_actual!=null){
            if(telefono == nodo_actual.getTelefono()){
                existe = true;
            }
            else{
              existe = BuscarValor(telefono, nodo_actual.getSiguiente());
                
            }
        }
        return existe;
    }
   
    public boolean Buscar(int telefono){
        Nodo nodo_actual = tope;
        return BuscarValor(telefono, nodo_actual);
    }
    
    
    //mostrar los valores de la lista 
    private void MostrarValor(Nodo nodo_actual,int conta){
        if(nodo_actual!=null){
            if(conta == numValores){
                cadena += nodo_actual.getTelefono()+" --> null";
            }
            else{
                if(conta == 1){
                  cadena += "[ "+nodo_actual.getTelefono()+" ]"+" --> "; 
                }
                else{
                  cadena += nodo_actual.getTelefono()+" --> "; 
                }
              
            }
            conta++;
            MostrarValor(nodo_actual.getSiguiente(),conta);
        }
        
    }
    public String Mostrar(){
        cadena ="";
        Nodo nodo_actual = tope;
        int conta = 1;
        MostrarValor(nodo_actual,conta );
        return cadena;
    }

    public Nodo getTope() {
        return tope;
    }

    public void setTope(Nodo tope) {
        this.tope = tope;
    }

    public Nodo getFondo() {
        return fondo;
    }

    public void setFondo(Nodo fondo) {
        this.fondo = fondo;
    }

    public int getNumValores() {
        return numValores;
    }

    public void setNumValores(int numValores) {
        this.numValores = numValores;
    }
    
    
    
    public boolean Vacia(){
        return(fondo==null)?true:false;
    }
    
    
}

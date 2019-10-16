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
public class Tabla {
    /*
    * numM: es el valor que es un numero primo, que no es potencia de 2 y no es potencia de 10, que seria "m" en la ecuacion H(k) = k % m.
    
    * FuncionHash: sera un numero ya sea 1 o 0 que va a determinar si la tabla usar la funcion de division o de multiplicacion; 1 funcion de division, 0 funcion de multiplicacion 
    
    * La tabla sera un array de lista debido a las colisiones, ya que le programa es un hashin abierto o encademanito separado. 
    
    *La clase requerimiento ve si un numero es potencia de dos, es potencia de diez o es primo. 
    
    */
    private Lista TablaHash[];
    private int FuncionHash, numM;
    private float num_para_multi;// es el numero que se utiliza para hacer la funcion de multiplicacion. 
    private Requerimiento requerimiento;

    public Tabla(int FuncionHash,int TamTabla) {
        this.FuncionHash = FuncionHash; //segun este numero, la tabla hash usara la funcion de division o de multiplicaion. 
        this.requerimiento = new Requerimiento();//instanciamos el objeto requerimiento para obtener el valor m 
         this.numM = requerimiento.RetornarM(TamTabla);// obtenemos el valor m que se utiliza en la ecuacion h(k) = k%m
        this.TablaHash = new Lista[numM];// le damos una tamano al array que debe de ser numM. 
        //this.numM = requerimiento.RetornarM(TamTabla);// obtenemos el valor m que se utiliza en la ecuacion h(k) = k%m
        float aux_num =  (float) Math.sqrt(5)/2;
        num_para_multi = 1+aux_num;
        System.out.println(num_para_multi);
        
    }
    
    public boolean Insertar(String nombre, String correo,String organizacion, String comentario, int telefono){
        boolean Insercion_Correctamente = false;
        if(FuncionHash == 1){ // Funcion de division 
             int posicion = telefono % numM; // se encuentra la posicion a insertar 
             Insercion_Correctamente = InsertarValor(nombre, correo, organizacion, comentario, telefono, posicion);// se manda a insertar el valor
        }
        else{// funcion de multiplicacion
            
           
        }
       return Insercion_Correctamente; 
    }
    public boolean  InsertarValor(String nombre, String correo, String organizacion, String comentario, int telefono, int posicion){
        boolean Insertar_Correctamente = false;
        //System.out.println(posicion);
        if(TablaHash[posicion] != null){ // si en la posicion ya hay una lista 
            Lista lista_auxiliar = TablaHash[posicion];
            //si el numero telefonico ya existe no inserta en dado caso no existe lo inserta 
                if(!lista_auxiliar.Buscar(telefono)){ //si el numero no existe 
                    lista_auxiliar.InsertarFondo(nombre, correo, organizacion, comentario, telefono); // se insertar en la lista 
                    Insertar_Correctamente = true;
                }
                
            }
        else{// si en la posicion no hay una lista. 
            Lista nueva_lista = new Lista();// se crea una lista nueva 
            nueva_lista.InsertarFondo(nombre, correo, organizacion, comentario, telefono);// se inserta el nuevo numero 
            TablaHash[posicion] = nueva_lista;// se ingresa en la posicion correspondiente 
            Insertar_Correctamente = true;
        }
        return Insertar_Correctamente;
    }
    
    public void MostrarTabla(){
        int conta = 0;
        for(Lista lista:TablaHash){
            if(lista!=null){
                System.out.print(conta+") ");
                System.out.println(lista.Mostrar());
                
            }
            else{
                System.out.println(conta+")"+" Vacia");
            }
            conta++;
        }
    }
    

    

    public int getFuncionHash() {
        return FuncionHash;
    }

    public void setFuncionHash(int FuncionHash) {
        this.FuncionHash = FuncionHash;
    }

    public int getNumM() {
        return numM;
    }

    public void setNumM(int numM) {
        this.numM = numM;
    }
  
    
    
    
}

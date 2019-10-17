/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablahash;

import java.math.BigDecimal;
import java.math.BigInteger;

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
    private BigDecimal num_para_multi;// es el numero que se utiliza para hacer la funcion de multiplicacion, se colaca en este tipo de datos para que soporte gran cantidad de decimales . 
    private Requerimiento requerimiento;
    private String cadena;

    public Tabla(int FuncionHash,int TamTabla) {
        this.FuncionHash = FuncionHash; //segun este numero, la tabla hash usara la funcion de division o de multiplicaion. 
        this.requerimiento = new Requerimiento();//instanciamos el objeto requerimiento para obtener el valor m 
         this.numM = requerimiento.RetornarM(TamTabla);// obtenemos el valor m que se utiliza en la ecuacion h(k) = k%m
        this.TablaHash = new Lista[numM];// le damos una tamano al array que debe de ser numM. 
        
        // se obtiene el numero asignado para la funcion de multiplicar. 
        float aux_num =  ((float) Math.sqrt(5)/2)+1;
        num_para_multi = new BigDecimal(aux_num);
        System.out.println(num_para_multi);
    }
    
    public boolean Insertar(String nombre, String correo,String organizacion, String comentario, int telefono){
        boolean Insercion_Correctamente = false;
        if(FuncionHash == 1){ // Funcion de division 
             int posicion = FuncionDivision(telefono); // se encuentra la posicion a insertar 
             Insercion_Correctamente = InsertarValor(nombre, correo, organizacion, comentario, telefono, posicion);// se manda a insertar el valor
        }
        else{// funcion de multiplicacion
        
         int posicion = FuncionMultiplicar(telefono);
         Insercion_Correctamente = InsertarValor(nombre, correo, organizacion, comentario, telefono, posicion);// se manda a insertar el valor en la tabla 
                 
        }
       return Insercion_Correctamente; 
    }
    
    public boolean  InsertarValor(String nombre, String correo, String organizacion, String comentario, int telefono, int posicion){
        boolean Insertar_Correctamente = false;
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
  //Mostrar la tabla   
    public String MostrarTabla(){
        cadena = "";
        int conta = 0;
        for(Lista lista:TablaHash){
            if(lista!=null){
            
                cadena += conta+") "+lista.Mostrar()+"\n";
                
            }
            else{
                cadena += conta+") "+"[ Vacia ]"+"\n";
            }
            conta++;
        }
        return cadena;
    }
    
    //*Funcion de division 
    private int FuncionDivision(int telefono){
        int posicion = 0;
        posicion = telefono % numM; // se encuentra la posicion a insertar 
        cadena = "Posicion en donde se inserto: "+posicion;
        return posicion;
    }
    //Funcion de multiplicacion
    private int FuncionMultiplicar(int telefono){
        int posicion = 0;
         BigDecimal multi = BigDecimal.valueOf(telefono);// se coloca el telefono en una variable que soporte un numero decimal granded 
         multi = multi.multiply(num_para_multi); // se multiplica con el numero recervado para la multiplicacion de la llave. 
         //System.out.println(multi);
         int parte_entera = multi.intValue(); // si coloca la parte entera del resultado de la multiplicacion en una variable entera.
        // System.out.println(parte_entera);
         BigDecimal parte_entera2 = BigDecimal.valueOf(parte_entera);// se coloca en una varia bigdecimal para restarlo con multi. 
         multi = multi.subtract(parte_entera2);// al resultado de de la multiplicacion se le resta la parte entera para quedarce con la parte decimal 
        // System.out.println(multi);
         BigDecimal numM2 = BigDecimal.valueOf(numM);// el valor "m" se coloca en una variable bigdecimal 
        // System.out.println(numM2);
         numM2 = numM2.multiply(multi);// se multiplica con la parte decimal que se guardo en multi. 
        // System.out.println(numM2);
         posicion = numM2.intValue();// al resultado de esta multiplicacion se extrae solo la parte entera que seria posicion a insertar
         cadena = "Posicion en donde se inserto: "+posicion;
        return posicion;
    }
    
 //Buscar valor. 
    public boolean Buscar(int telefono){
        cadena = "";
        boolean existe = false;
        int posicion;
        if(FuncionHash == 1){
            posicion = FuncionDivision(telefono);
            if(TablaHash[posicion]!=null){
                existe = TablaHash[posicion].Buscar(telefono);
                cadena = TablaHash[posicion].getCadena();
            }
        }
        else{
            posicion = FuncionMultiplicar(telefono);
            if(TablaHash[posicion]!=null){
                existe = TablaHash[posicion].Buscar(telefono);
                cadena = TablaHash[posicion].getCadena();
            }
        }
        
        return existe;
    }
    
  public boolean Eliminar(int telefono){
      boolean seElimino = false;
      Lista lista_aux;
      int posicion;
      if(FuncionHash == 1){
            posicion = FuncionDivision(telefono);// buscamos la posicion donde deberia estar 
            lista_aux = TablaHash[posicion];//pasamos a un auxiliar la lista en esa posicion 
            if(TablaHash[posicion]!=null ){// la lista tiene que ser distinta de nulo
                if(lista_aux.Buscar(telefono)){//el valor tiene que existir en la lista 
               lista_aux.Eliminar(telefono);// eliminamos el valor de la lista 
               if(lista_aux.getTope() == null){// si el tope de la lista queda como nulo, se pone en esa posicion de la tabla un nulo 
                   TablaHash[posicion] = null;
               }
               seElimino = true;
            }
            }
      }
      
      else{ 
            posicion = FuncionMultiplicar(telefono);
            lista_aux = TablaHash[posicion];
            if(TablaHash[posicion]!=null ){// la lista tiene que ser distinta de nulo
                if(lista_aux.Buscar(telefono)){//el valor tiene que existir en la lista 
               lista_aux.Eliminar(telefono);// eliminamos el valor de la lista 
               if(lista_aux.getTope() == null){// si el tope de la lista queda como nulo, se pone en esa posicion de la tabla un nulo 
                   TablaHash[posicion] = null;
               }
               seElimino = true;
            }
            }
          
      }
      return seElimino;
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

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    
    
    
}

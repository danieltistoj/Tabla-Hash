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
    private Requerimiento requerimiento;

    public Tabla(int FuncionHash,int TamTabla) {
        this.FuncionHash = FuncionHash;
        this.TablaHash = new Lista[TamTabla];
        this.requerimiento = new Requerimiento();
        this.numM = requerimiento.RetornarM(TamTabla);
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

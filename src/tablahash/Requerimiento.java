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
public class Requerimiento {
     private boolean esPotenciaDeDos, esPotenciaDeDiez, esPrimo;

    public Requerimiento() {
        this.esPotenciaDeDos = false;
        this.esPotenciaDeDiez = false;
        this.esPrimo = false;
    }
    
    
    
    public boolean PotenciaDeDos(int valor){
        esPotenciaDeDos = false;
        int valor_aux = 1;
        while(valor_aux != valor && valor_aux<valor){
            valor_aux *=2;
        }
        if(valor_aux == valor ){
            esPotenciaDeDos = true;
            
        }
        
        return esPotenciaDeDos;   
    }
    public boolean PotenciaDeDiez(int valor){
        esPotenciaDeDiez = false;
        int valor_aux = 1;
        while(valor_aux != valor && valor_aux<valor){
            valor_aux *= 10;
        }
        if(valor_aux == valor){
            esPotenciaDeDiez = true;
        }
       return esPotenciaDeDiez;
    }
    public boolean NumeroPrimo(int valor){
        esPrimo = false;
        int contador = 0, residuo;
        
        for(int i=1; i<=valor; i++){
            residuo = valor%i;
            if(residuo == 0){
                contador++;
            }
                
        }
        if(contador == 2){
            esPrimo = true;
        }
       return esPrimo;

    }
    
    public int RetornarM(int sizeTabla){
        int numero_aux = 0, numM = 0;
        while(numero_aux == 0){
            if((PotenciaDeDos(sizeTabla)&&PotenciaDeDiez(sizeTabla)) && NumeroPrimo(sizeTabla)){
                numM = sizeTabla;
                numero_aux = 1;
            }
            sizeTabla++;
            
        }
        
        return numM;
    }
    
}

package main;
import funcions.logica.funcionsLogica;
import utils.colors;
import funcions.grafics.*;

public class laberintGame {
    public static void main(String[] args) throws InterruptedException {
        String array[][]=new String [11][20];
        
        funcionsMostrar.omple(array);
        funcionsMostrar.benvinguda();
        
        int contador = 23;
        boolean finalitzar = true, sumaComptador = false;


        String nomJugador = funcionsLogica.preguntaJugador();
        funcionsMostrar.mostrarQuadricula(array);
    
        do{
            finalitzar = funcionsLogica.moviment(array, contador, nomJugador);
            contador = funcionsLogica.sumaContador(contador, sumaComptador);
        } while(finalitzar);
    }  
}

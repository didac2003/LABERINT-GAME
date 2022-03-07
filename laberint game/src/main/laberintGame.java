package main;
import funcions.logica.funcionsLogica;
import funcions.grafics.*;

public class laberintGame {
    public static void main(String[] args) throws InterruptedException {
        String array[][] = new String [11][20];
        int contador = 28;
        boolean finalitzar = true;

        funcionsMostrar.omplirArray(array);
        funcionsMostrar.benvinguda();
        String nomJugador = funcionsLogica.preguntaJugador();
        funcionsMostrar.mostrarQuadricula(array);
    
        do{
            contador = funcionsLogica.comptador(contador);
            finalitzar = funcionsLogica.moviment(array, contador, nomJugador);
        } while(finalitzar);
    }  
}
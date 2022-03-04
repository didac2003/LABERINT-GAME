package main;
import funcions.logica.jugador;
import funcions.logica.grafics.*;
import java.util.*;

public class laberintGame {
    public static void main(String[] args) throws InterruptedException {
        String array[][]=new String [11][20];
        Scanner teclat = new Scanner (System.in);
        tauler.mostrarQuadricula(array);
        System.out.println("Bon dia, benvingut a LABERINT GAME ");
        System.out.println("Com et dius jugador?");
        String jugadors=teclat.next();
        String posicio;
        int contador=23;
        boolean finalitzar=true;
        
        do{
            System.out.println(jugadors+"on vols moure?");
            posicio = teclat.next();
            finalitzar=jugador.moviment(posicio,array,contador);
            contador--;
            System.out.println("Moviments: "+contador);
        }while(finalitzar);
        
        }  
    }


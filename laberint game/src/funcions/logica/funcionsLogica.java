package funcions.logica;
import java.util.*;
import funcions.grafics.*;
import utils.*;

public class funcionsLogica {
    public static final Scanner teclat = new Scanner (System.in);

    public static String preguntaJugador(){
        System.out.print("Com et dius jugador? ");
        String jugador = teclat.next();
        return jugador;
    }

    public static boolean moviment(String array[][], int contador, String nomJugador){
        boolean finalitzar = true, sumaComptador = false;

        System.out.print("\nOn vols moure, " + colors.YELLOW + nomJugador + colors.RESET + "? ");
        String posicio = teclat.next();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j].equals("X")){

                    if(posicio.equals("s")) array[i+1][j] = "X";

                    else if(posicio.equals("d")) {

                        if(array[i][j+1] == "\uD83D\uDC9B"){
                            sumaComptador = true;
                            contador = sumaContador(contador, sumaComptador);
                        }

                        else if(array[i][j+1] != " "){
                            finalitzar = false;
                            array[i][j+1] = "X";
                        }

                        if(finalitzar) array[i][j+1]="X";
                    }

                    else if(posicio.equals("a")) {

                        if(array[i][j-1] == "\uD83D\uDCA3"){
                            finalitzar = false;
                            array[i][j-1] = "\uD83D\uDCA5";
                        }

                        else if(array[i][j-1] != " "){
                            finalitzar = false;
                            array[i][j-1] = "X";
                        }

                        if(finalitzar) array[i][j-1]="X";
                    }
                    
                    else if(posicio.equals("w")){

                        if(array[i-1][j] == "\uD83D\uDCA3"){
                            finalitzar = false;
                            array[i-1][j] = "\uD83D\uDCA5";
                        }

                        else if(array[i-1][j] != " "){
                            finalitzar = false;
                            array[i-1][j] = "X";
                        }

                        if(finalitzar) array[i-1][j]="X";
                    }
                    array[i][j] = " ";
                    break;
                }
            }
        }
        

        if(contador == 0) finalitzar=false;
        
        if(finalitzar) {
            funcionsMostrar.mostrarQuadricula(array);
            System.out.println(colors.GREEN + "Moviments: " + contador + colors.RESET);
        } else  funcionsMostrar.tableroDerrota(array);
         
        return finalitzar;
    }

    public static int sumaContador(int contador, boolean sumaComptador){
        if(sumaComptador) contador+=5;
        else contador--;
        return contador;
    }
}

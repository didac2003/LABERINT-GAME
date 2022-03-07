package funcions.logica;
import java.util.*;
import funcions.grafics.*;
import utils.*;

public class funcionsLogica {
    public static final Scanner teclat = new Scanner (System.in);

    public static String preguntaJugador(){
        System.out.print("\nIntrodueix el teu nick: ");
        String jugador = teclat.next();
        return jugador;
    }

    public static String preguntaPosicio(String nomJugador, String array[][]){
        String posicio;
        do{
            System.out.print("\nOn vols moure, " + colors.YELLOW + nomJugador + colors.RESET + "? ");
            posicio = teclat.next();
            if(!posicio.equals("w") && !posicio.equals("s") && !posicio.equals("a") && !posicio.equals("d")) {
                funcionsMostrar.mostrarQuadricula(array);
                System.out.println(colors.RED + "Posició incorrecte." + colors.RESET);
            }
        } while(!posicio.equals("w") && !posicio.equals("s") && !posicio.equals("a") && !posicio.equals("d"));
        return posicio;
    }

    public static boolean moviment(String array[][], int contador, String nomJugador){
        String posicio = funcionsLogica.preguntaPosicio(nomJugador, array);

        boolean finalitzar = true, guanyador = false, seguent = false;
        int suma = 0;
        String calavera = "\uD83D\uDC80", bomba = "\uD83D\uDCA3", chispas = "\uD83D\uDCA5", corazon = "\uD83D\uDC9B";

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j].contains("X")){
                    if(posicio.equals("s")) {
                        if(array[i+1][j] == array[7][18] && array[7][16] == corazon){
                            if(suma==0){
                                suma++;
                                array[7][17] = colors.GREEN + "X" + colors.RESET;
                                array[i][j] = " ";
                                array[7][18]="\u2503";
                                
                            }
                        }

                        else if(array[i+1][j] == corazon){
                            if(suma==0){
                                suma++;
                                array[i+1][j] = colors.GREEN + "X" + colors.RESET;
                                array[i][j] = " ";
                                array[7][18]=" ";
                                array[7][19]="\u2503";
                                contador +=5;
                            }
                        }

                        else if(array[i+1][j] != " "){
                            if(suma == 0){
                                suma++;
                                array[i+1][j] = calavera;
                                array[i][j] = " ";
                                finalitzar = false;
                            }
                        }

                        if(finalitzar){
                            if(suma==0){
                                suma++;
                                array[i+1][j] = colors.GREEN + "X" + colors.RESET;
                                if(contador == 0) array[i+1][j] = calavera;
                                array[i][j] = " ";
                            }
                        }
                        break;
                    }

                    else if(posicio.equals("d")) {
                        if(array[i][j+1] == "\uD83C\uDFC1"){
                            array[i][j+1] = "\uD83E\uDD73";
                            finalitzar = false;
                            guanyador = true;
                        }

                        else if(array[i][j+1] != " "){
                            finalitzar = false;
                            array[i][j+1] = calavera;
                        }

                        if(finalitzar) {
                            array[i][j+1] = colors.GREEN + "X" + colors.RESET;
                            if(contador == 0) array[i][j+1] = calavera;
                        }
                    }

                    else if(posicio.equals("a")) {
                        if(array[i][j-1] == corazon){
                            array[i][j-1] = colors.GREEN + "X" + colors.RESET;
                            array[i][j] = " ";
                            array[7][18]=" ";
                            array[7][19]="\u2503";
                            contador +=5;
                        }

                        else if(array[i][j-1] != " "){
                            finalitzar = false;
                            array[i][j-1] = calavera;
                        }

                        if(finalitzar) {
                            array[i][j-1] = colors.GREEN + "X" + colors.RESET;
                            if(contador == 0) array[i][j-1] = calavera;
                        }
                    }
                    
                    else if(posicio.equals("w")){
                        if(array[i-1][j] == array[2][16]) array[i-1][j] = colors.GREEN + "X" + colors.RESET;
                    
                        else if(array[i-1][j] == array[2][18]){
                            array[2][17] = colors.GREEN + "X" + colors.RESET;
                            seguent = true;
                        }

                        else if(array[i-1][j] == bomba){
                            finalitzar = false;
                            array[i-1][j] = chispas;
                        }

                        else if(array[i-1][j] != " "){
                            finalitzar = false;
                            array[i-1][j] = calavera;
                        }

                        if(finalitzar && !seguent) {
                            array[i-1][j] = colors.GREEN + "X" + colors.RESET;
                            if(contador == 0) array[i-1][j] = calavera;
                        }
                    }
                    array[i][j] = " ";
                    break;
                }
            }
        }

        if(contador == 0) finalitzar = false;
        
        if(finalitzar) {
            funcionsMostrar.mostrarQuadricula(array);
            System.out.println(colors.GREEN + "Moviments: " + contador + colors.RESET);
        } else funcionsMostrar.tableroFinal(array, guanyador);
         
        return finalitzar;
    }

    public static int comptador(int contador){
        contador--;
        return contador;
    }
}

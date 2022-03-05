package funcions.grafics;
import utils.*;

public class funcionsMostrar {
    public static void benvinguda(){
        System.out.println(colors.BLUE + "**************************");
        System.out.println("BENVINGUT AL LABERINT GAME");
        System.out.println("**************************" + colors.RESET);
    }

    public static void tableroDerrota(String array [][]){
        for (int j2 = 0; j2 < array.length; j2++) {
            for (int j3 = 0; j3 < array[0].length; j3++) {
                System.out.print(colors.RED + array[j2][j3]);  
            }
            System.out.println();
        }
        System.out.println(colors.BLUE+ "**************************");
        System.out.println("Has perdut!");
        System.out.println("**************************" + colors.RESET);   
    }

    public static void mostrarQuadricula(String array [][]){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        } 
    }

    public static void omple(String array[][]){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j]=" ";
            }
        }
        
        for (int i = 0; i < array[0].length; i++) {
            array[0][i]="\u2501";
            array[10][i]="\u2501";
        }
        for (int i = 0; i < 9; i++) {
            array[i][0]="\u2503";
    
        }
        for (int i = 0; i < array.length; i++) {
            array[i][19]="\u2503";
        }
        for (int i = 10; i > 8; i--) {
            array[i][3]="\u2503";
        }
        for (int i = 4; i < 11; i++) {
            array[8][i]="\u2501";
        }
        for (int i = 6; i > 2; i--) {
            array[i][3]="\u2503";
        }
        for (int i = 3; i < 14; i++) {
            array[2][i]="\u2501";
        }
        for (int i = 0; i < 5; i++) {
            array[i][16]="\u2503";
        }
        for (int i = 16; i > 6; i--) {
            array[4][i]="\u2501";
        }
        for (int i = 5; i < 6; i++) {
            array[i][7]="\u2503";
        }
        for (int i = 6; i >3; i--) {
            array[6][i]="\u2501";
        }
        for (int i = 8; i > 6; i--) {
            array[i][11]="\u2503";
        }
        for (int i = 11; i < 16; i++) {
            array[6][i]="\u2501";
        }

        array[9][0]="X";
        array[1][1]="\uD83D\uDCA3";
        array[6][11]="\u250f";
        array[8][11]="\u251b";
        array[6][3]="\u2517";
        array[6][7]="\u251b";
        array[4][7]="\u250f";
        array[4][16]="\u251b";
        array[0][16]="\u2533";
        array[2][3]="\u250f";
        array[8][3]="\u250f";
        array[0][19]=" ";
        array[1][19]=" ";
        array[0][0]="\u250f";
        array[10][19]="\u251b";
        array[10][3]="\u253b";
        array[1][16]="\uD83D\uDC9B";
        array[7][16]="\uD83D\uDC9B";
        array[7][18]="\u2503";
        array[7][19]=" ";
    }
}
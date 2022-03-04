package funcions.logica.grafics;

public class omplenaArray {
        public static void omple(String array[][]){
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    array[i][j] = (" ");
                }
            }
            array[0][0]="X";
        }
}
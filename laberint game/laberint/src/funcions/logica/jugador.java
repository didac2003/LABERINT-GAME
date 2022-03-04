package funcions.logica;

public class jugador {
    public static boolean moviment(String posicio,String array[][],int contador){
        boolean finalitzar=true;
        if(posicio.equals("d")){
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if(array[i][j].equals("X")){
                        array[i][j+1]="X";
                        array[i][j]=" ";
                        System.out.println("fvs");
                        break;
                        

                    }

                }
            }
        }

            if(posicio.equals("a")){
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[0].length; j++) {
                        if(array[i][j].equals("X")){
                            array[i][j-1]="X";
                            array[i][j]=" ";
                            break;
                            
    
                        }
    
                    }
                }
            }

            if(posicio.equals("w")){
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[0].length; j++) {
                        if(array[i][j].equals("X")){
                            
                            
                            
                            if(array[i-1][j]=="\uD83D\uDCA3"){
                                finalitzar=false;
                                System.out.println("la bombet t'ha reventat!");
                                array[i-1][j]="\uD83D\uDCA5";
                                array[i][j]=" ";
                            }

                            else if(array[i-1][j]!=" "){
                                finalitzar=false;
                                System.out.println("no pots tocar les parets!");
                            }
                            if(finalitzar==true){
                            array[i-1][j]="X";
                            array[i][j]=" ";
                            }
                            if(finalitzar==false){
                            for ( int j2 = 0; j2 < array.length; j2++) {
                                for (int j3 = 0; j3 < array[0].length; j3++) {
                                  System.out.print("\u001B[31m"+array[j2][j3]);  
                                }
                                System.out.println();
                            }
                            }
                            break;
                        }
                       
                    }
                }
            }


            if(posicio.equals("s")){
                for (int i = 0; i < array.length-1; i++) {
                    for (int j = 0; j < array[0].length; j++) {
                        if(array[i][j].equals("X")){
                            array[i+1][j]="X";
                            array[i][j]=" ";
                            break;
                        }
                        
    
                    }
                }
            }
            if(finalitzar==true){
             for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }
        }
           
            if(contador==1){
                System.out.println("Vides acabades,has perdut!");
                finalitzar=false;

            }

            

            return finalitzar;
           

        
    }

    


    
}

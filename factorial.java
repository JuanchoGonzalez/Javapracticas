import javax.swing.*;

public class factorial {
    public static void main(String[] args){
        int fact=Integer.parseInt(JOptionPane.showInputDialog("introduce un numero"));
        int resultado=1;
           
        System.out.println(fact); 

        for (int i=1;i<=fact;i++){ // <= ya q hasta el numero q sea fact tiene q multiplicarse sino queda en un menos
            resultado=resultado*i;
        }

     System.out.println("el factorial de " + fact + " es " + resultado );
    } 
}

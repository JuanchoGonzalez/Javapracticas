package racionales.main;
import racionales.Racionales;

public class MainRacionales {

    public static void main(String[] args) {
    
    Racionales num1 = new Racionales(1L,4L);
    Racionales numeroASumar = new Racionales(5L, 4L);
    Racionales suma=num1.sumarRacionales(numeroASumar);
    System.out.println("Valor sumado:" + suma.toString());
    

    //entendiendo y probando getters y setters de los Racionales
    
    Racionales num2 = new Racionales(2L,5L);

    long nume = num2.getNume();

    System.out.println("el numerador es:" + nume);

    num2.setNume(10L);

    System.out.println("el nuevo numerador es:" + num2.getNume());

    //lo mismo para restar

    }
}

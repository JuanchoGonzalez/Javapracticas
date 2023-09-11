package racionales;

public class Racionales {
    private long nume;
    private long deno;
   
    public Racionales(long nume,long deno){
		  this.nume = nume;
		  this.deno = deno;
    }
    
    // setter de nume
    public void setNume(long nume){
        this.nume=nume;
    }
    // getter de nume
    public long getNume(){
        return nume;
    }
    // setter de deno
    public void setDeno(long deno){
        this.deno=deno;
    }
    // getter de deno
    public long getDeno(){
        return deno;
    }

    // getter                       el otro es el this
    public Racionales sumarRacionales(Racionales num1) {
      Racionales aux = new Racionales(nume,deno); //creador
      //creacion de numeros racionales con su numerador y denominador correspondiente
      //ver si alguno de los denominadores es 0 retorno ?
      //aunque se supone q lo contempla la clase
      /*if (num1.deno == 0 || num2.deno == 0){
        //return error;
      }
      */
      //se puede sumar
      if (this.deno == num1.deno){
       aux.nume=this.nume + num1.nume;
       aux.deno=this.deno;
       return aux;  
      }else {
       aux.nume = (((this.deno * num1.nume) / this.deno )* this.nume) + (((this.deno * num1.nume) / num1.deno)* num1.nume);
       aux.deno = num1.deno * this.deno;

      return aux;
      }
    }

    // getter                       el otro es el this
    public Racionales restaRacionales(Racionales num1) {
      Racionales aux = new Racionales(nume,deno); //creador
      //creacion de numeros racionales con su numerador y denominador correspondiente
      //ver si alguno de los denominadores es 0 retorno ?
      //aunque se supone q lo contempla la clase
      /*if (num1.deno == 0 || num2.deno == 0){
        //return error;
      }
      */
      //se puede restar
      if (this.deno == num1.deno){
       aux.nume=this.nume - num1.nume;
       aux.deno=this.deno;
       return aux;  
      }else {
       aux.nume = (num1.nume * this.deno) - (this.nume * num1.deno);
       aux.deno = num1.deno * this.deno;

      return aux;
      }
    }

    @Override
    public String toString(){
          return this.nume + "/" + this.deno;
    }

    @Override
    public boolean equals(Object num1) {
        if (num1 == null){
          return false;
        }
        if (num1 == this){
          return true;
        }
        if (!(num1 instanceof Racionales)){
          return false;
        }
        Racionales otroRacional = (Racionales) num1;

       return otroRacional.nume == nume && otroRacional.deno==deno; 
    }
}
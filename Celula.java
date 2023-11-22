package Celula;

import java.util.Scanner;

public class Celula {
	public String reino;
	   public int tamaño;
	   public int moleculasATP;
	   public String hebra1;
	   public String hebra2;
	   public String estado;

	   public Celula(String reino, int tamaño, int moleculasATP, String hebra1, String hebra2, String estado) {
	      this.reino = reino;
	      this.tamaño = tamaño;
	      this.moleculasATP = moleculasATP;
	      this.hebra1 = hebra1;
	      this.hebra2 = hebra2;
	      this.estado = estado;
	   }

	   public boolean estadoM() {
	      int i = 0;

	      while(i < this.hebra1.length()) {
	         char hebra1C = this.hebra1.charAt(i);
	         char hebra2C = this.hebra2.charAt(i);
	         if ((hebra1C != 'A' || hebra2C == 'T') && (hebra1C != 'T' || hebra2C == 'A') && (hebra1C != 'G' || hebra2C == 'C') && (hebra1C != 'C' || hebra2C == 'G')) {
	            if ((hebra2C != 'A' || hebra1C == 'T') && (hebra2C != 'T' || hebra1C == 'A') && (hebra2C != 'G' || hebra1C == 'C') && (hebra2C != 'C' || hebra1C == 'G')) {
	               ++i;
	               continue;
	            }

	            return false;
	         }

	         return false;
	      }

	      return true;
	   }

	   public void estadoS() {
	      if (this.estadoM()) {
	         this.estado = "Sana";
	      } else {
	         this.estado = "Dañada";
	      }

	   }

	   public void recibir() {
	      Scanner sc = new Scanner(System.in);
	      System.out.println("Cuantas moleculas deseas que reciba tu celula?");
	      int moleculasM = sc.nextInt();
	      this.moleculasATP += moleculasM;
	   }

	   public void crecer() {
	      Scanner sc = new Scanner(System.in);
	      System.out.println("Cuantas moleculas ATP deseas consumir para crecer?");
	      int moleculas = sc.nextInt();
	      if (moleculas > this.moleculasATP) {
	         System.out.println("No tienes suficientes moleculas ATP para crecer");
	      } else {
	         this.moleculasATP -= moleculas;
	         this.tamaño += moleculas * 2;
	         System.out.println("Has gastado " + moleculas + " moleculas ATP para crecer " + moleculas * 2 + " micrometros");
	         System.out.println("Ahora tienes " + this.moleculasATP + " moleculas ATP y " + this.tamaño + " micrometros");
	      }

	   }

	   public void dividirse() {
	      if (this.moleculasATP >= 11 && this.tamaño > 0) {
	         this.moleculasATP = (this.moleculasATP - 10) / 2;
	         this.tamaño /= 2;
	         System.out.println("Has creado una nueva celula hija con " + this.moleculasATP + " moleculasATP y " + this.tamaño + " micrometros");
	         System.out.println("Estos tambien son las caracteristicas de tu celula original");
	      } else {
	         System.out.println("Moleculas o tamaño insuficienta para dividirse");
	      }

	   }
}

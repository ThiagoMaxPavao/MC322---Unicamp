package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
      for (int l = 0; l < lombrigas.length; l++)
         System.out.println(lombrigas[l]);

      for (int l = 0; l < lombrigas.length; l++) {
          Animacao a = new Animacao(lombrigas[l]);
          
          tk.gravaPasso("=====");
          tk.gravaPasso(a.apresenta());
          
          int nPassos = lombrigas[l].length() - 6;
          for (int i = 0; i<nPassos; i++) {
              a.passo();
              tk.gravaPasso(a.apresenta());
          }
      }

      tk.stop();
   }

}
package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      
      Tabuleiro t = new Tabuleiro();
      tk.writeBoard("Tabuleiro inicial", t.apresenta());
      
      for (int l = 0; l < commands.length; l++) {
    	  t.moverPorComando(commands[l]);
    	  tk.writeBoard(commands[l], t.apresenta());
      }
      
      tk.stop();
   }

}
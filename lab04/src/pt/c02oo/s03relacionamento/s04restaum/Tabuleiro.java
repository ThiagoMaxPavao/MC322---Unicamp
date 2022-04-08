package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	Peca tabuleiro[][] = new Peca[7][7];
	
	public Tabuleiro() {
		for(int x = 0; x < 7; x++)
			for(int y = 0; y < 7; y++) {
				tabuleiro[x][y] = null;
				if(x == 3 && y == 3) continue;
				if((x >= 2 && x <= 4) || (y >= 2 && y <= 4))
					tabuleiro[x][y] = new Peca(x, y);
			}
	}
	
	char[][] apresenta() {
		char matrizChar[][] = new char[7][7];
		for(int y = 0; y < 7; y++)
			for(int x = 0; x < 7; x++)
				if(tabuleiro[x][y] != null)
					matrizChar[y][x] = 'P';
				else if((x >= 2 && x <= 4) || (y >= 2 && y <= 4))
					matrizChar[y][x] = '-';
				else
					matrizChar[y][x] = ' ';
		return matrizChar;
	}
	
	boolean temPeca(int x, int y) {
		return tabuleiro[x][y] != null;
	}
	
	boolean dentroDoTabuleiro(int x, int y) {
		if(x < 0 || y < 0 || x > 6 || y > 6) return false;
		if((x >= 2 && x <= 4) || (y >= 2 && y <= 4)) return true;
		return false;
	}
	
	boolean validaMovimento(int xi, int yi, int xf, int yf) {
		if(!temPeca(xi,yi)) return false;
		if( temPeca(xf,yf)) return false;
		if(!dentroDoTabuleiro(xf, yf)) return false;
		if(!temPeca((xi + xf)/2, (yi + yf)/2)) return false; // sem peça na posição pulada
		return true;
	}
	
	void moverPeca(int xi, int yi, int xf, int yf) {
		if(!validaMovimento(xi, yi, xf, yf)) return;			// Validação geral
		if(!tabuleiro[xi][yi].validaMovimento(xf, yf)) return;  // Validação especifica da peça
		
		tabuleiro[xi][yi].mover(xf, yf);
		matarPeca((xi + xf)/2, (yi + yf)/2);
		tabuleiro[xf][yf] = tabuleiro[xi][yi];
		tabuleiro[xi][yi] = null;
	}
	
	void moverPorComando(String comando) {
		int a = 'a';
		int xi = comando.charAt(0) - a;
		int yi = Character.getNumericValue(comando.charAt(1)) - 1;
		int xf = comando.charAt(3) - a;
		int yf = Character.getNumericValue(comando.charAt(4)) - 1;
		moverPeca(xi, yi, xf, yf);
	}
	
	void matarPeca(int x, int y) {
		tabuleiro[x][y] = null;
	}
}

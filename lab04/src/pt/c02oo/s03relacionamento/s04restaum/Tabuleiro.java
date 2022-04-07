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
		for(int x = 0; x < 7; x++)
			for(int y = 0; y < 7; y++)
				if(tabuleiro[x][y] != null)
					matrizChar[x][y] = 'P';
				else if((x >= 2 && x <= 4) || (y >= 2 && y <= 4))
					matrizChar[x][y] = '-';
				else
					matrizChar[x][y] = ' ';
		return matrizChar;
	}
}

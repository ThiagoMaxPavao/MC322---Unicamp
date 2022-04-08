package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	int x, y;
	public Peca(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	boolean movimentoDiagonal(int xf, int yf) {
		if(x != xf && y != yf) return true;
		return false;
	}
	
	boolean movimentoDe2Casas(int xf, int yf) {
		if(Math.abs(xf - x) == 2) return true;
		if(Math.abs(yf - y) == 2) return true;
		return false;
	}
	
	boolean validaMovimento(int xf, int yf) {
		if( movimentoDiagonal(xf, yf)) return false;
		if(!movimentoDe2Casas(xf, yf)) return false;
		return true;
	}

	void mover(int xf, int yf) {
		x = xf;
		y = yf;
	}
}

package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
	private int x, y;
	private Tabuleiro t;
	
	public Peca(int x, int y, Tabuleiro t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
	
	private boolean movimentoDiagonal(int xf, int yf) {
		if(x != xf && y != yf) return true;
		return false;
	}
	
	private boolean movimentoDe2Casas(int xf, int yf) {
		if(Math.abs(xf - x) == 2) return true;
		if(Math.abs(yf - y) == 2) return true;
		return false;
	}
	
	public boolean validaMovimento(int xf, int yf) {
		if( movimentoDiagonal(xf, yf)) return false;
		if(!movimentoDe2Casas(xf, yf)) return false;
		if(!t.temPeca((x + xf)/2, (y + yf)/2)) return false; // sem peca na posicao pulada
		return true;
	}

	public void mover(int xf, int yf) {
		x = xf;
		y = yf;
	}
}

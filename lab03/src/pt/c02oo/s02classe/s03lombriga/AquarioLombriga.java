package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
	int tamAquario, tamLombriga, pos;
	char dir;
	
	AquarioLombriga(int tamAquario, int tamLombriga, int pos) {
		this.tamAquario = tamAquario < tamLombriga ? tamLombriga : tamAquario; // tamAquario vira o tamanho da lombriga caso ele seja dado menor do que o tamanho dela
		this.tamLombriga = tamLombriga;
		this.pos = pos + tamLombriga -1 <= this.tamAquario ? pos : 1; // posição da cabeça -> seta para um caso corpo fique para fora
		this.dir = 'E';
	}
	
	void crescer() {
		if(dir == 'E' && pos + tamLombriga <= tamAquario)
			tamLombriga++;
		else if(dir == 'D' && pos - tamLombriga > 1)
			tamLombriga++;
	}
	
	void mover() {
		if(dir == 'E' && pos > 1)
			pos--;
		else if(dir == 'E')
			this.virar();
		else if(pos < tamAquario) // dir = 'D'
			pos++;
		else
			this.virar();
	}
	
	void virar() {
		if(dir == 'E') {
			pos += tamLombriga -1;
			dir = 'D';
		}
		else {
			pos -= tamLombriga -1;
			dir = 'E';
		}
	}
	
	String apresenta() {
		String aquario = "";
		if(dir == 'E') {
			for(int i = 1; i <= tamAquario; i++) {
				if(i < pos)
					aquario += "#";
				else if(i == pos)
					aquario += "@";
				else if(i < pos + tamLombriga)
					aquario += "o";
				else
					aquario += "#";
			}
		}
		else {
			for(int i = 1; i <= tamAquario; i++) {
				if(i <= pos - tamLombriga)
					aquario += "#";
				else if(i == pos)
					aquario += "@";
				else if(i < pos)
					aquario += "o";
				else
					aquario += "#";
			}
		}
		return aquario;
	}
}
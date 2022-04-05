package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	AquarioLombriga lombriga;
	String passos;
	int passoAtual;
	
	Animacao (String params) {
		int tamAquario = Character.getNumericValue(params.charAt(0)) * 10 + Character.getNumericValue(params.charAt(1));
		int tamLomb    = Character.getNumericValue(params.charAt(2)) * 10 + Character.getNumericValue(params.charAt(3));
		int posCabeca  = Character.getNumericValue(params.charAt(4)) * 10 + Character.getNumericValue(params.charAt(5));
		lombriga = new AquarioLombriga(tamAquario, tamLomb, posCabeca);
		passos = params.substring(6);
		passoAtual = 0;
	}
	
	String apresenta () {
		return lombriga.apresenta();
	}
	
	void passo () {
		if (passoAtual == passos.length()) return;
		char acao = passos.charAt(passoAtual);
		switch (acao) {
		case 'C':
			lombriga.crescer();
			break;
		case 'M':
			lombriga.mover();
			break;
		case 'V':
			lombriga.virar();
			break;
		}
		passoAtual++;
	}
}
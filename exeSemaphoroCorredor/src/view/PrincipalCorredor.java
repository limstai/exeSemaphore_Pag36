package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCorredor;

public class PrincipalCorredor {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idPessoa = 0; idPessoa < 4; idPessoa++) {
			Thread corredor = new ThreadCorredor(semaforo);
			corredor.start();
		}
	}
}

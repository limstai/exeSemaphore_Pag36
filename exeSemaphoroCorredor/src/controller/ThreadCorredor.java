package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {
	private static int abrirPorta;
	private Semaphore semaforo;

	public ThreadCorredor(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			pessoaAndando();
			sair();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			
		}

	}

	private void pessoaAndando() {
		int distanciaCorredor = 200;
		int distanciaPercorrida = 0;
		int deslocamento = 100;

		int tempo = 1000;

		while (distanciaPercorrida < distanciaCorredor) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("A pessoa #" + ((getId()) - 10) + " já caminhou" + distanciaPercorrida + "m.");
		}
		
	}
	
	private void sair() {
		abrirPorta++;
		System.out.println("A pessoa #" + ((getId() - 10)) + " foi o " + abrirPorta + "º a abrir a porta e a cruzar");
	}

}
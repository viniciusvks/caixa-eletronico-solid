package br.org.fundatec.lp3.caixaeletronico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        System.out.println("|--Caixa Eletronico--|");
        System.out.println();
        System.out.print("> Digite o valor a ser sacado: ");
        int valor = scanner.nextInt();

		int[] notasOrdenadas = new int[6];
		notasOrdenadas[0] = 100;
		notasOrdenadas[1] = 50;
		notasOrdenadas[2] = 20;
		notasOrdenadas[3] = 10;
		notasOrdenadas[4] = 5;
		notasOrdenadas[5] = 2;
		
		int notasDeCincoDisponiveis = 20;
		int notasDeDezDisponiveis = 20;
		int notasDeVinteDisponiveis = 20;
		int notasDeCinquentaDisponiveis = 10;
		int notasDeCemDisponiveis = 5;

		List<String> dispensas = new ArrayList<>();

		for (int i = 0; i < notasOrdenadas.length; i++) {

			int nota = notasOrdenadas[i];
			int quantidadeDeNotas = (int) Math.floor(valor / nota);
			
			if (quantidadeDeNotas > 0) {
				
				if(nota == 5) {
					
					if(quantidadeDeNotas > notasDeCincoDisponiveis) {
						System.out.println("Quantidade de notas de 5 indisponível para o valor informado");
						return;
					} else {
						notasDeCincoDisponiveis --;
					}
					
				} 
				
				if(nota == 10) {
					
					if(quantidadeDeNotas > notasDeDezDisponiveis) {
						System.out.println("Quantidade de notas de 10 indisponível para o valor informado");
						return;
					} else {
						notasDeDezDisponiveis --;
					}
					
				}
				
				if(nota == 20) {
					
					if(quantidadeDeNotas > notasDeVinteDisponiveis) {
						System.out.println("Quantidade de notas de 20 indisponível para o valor informado");
						return;
					} else {
						notasDeVinteDisponiveis --;
					}
					
				}
				
				if(nota == 50) {
					
					if(quantidadeDeNotas > notasDeCinquentaDisponiveis) {
						System.out.println("Quantidade de notas de 50 indisponível para o valor informado");
						return;
					} else {
						notasDeCinquentaDisponiveis --;
					}
					
				}
				
				if(nota == 100) {
					
					if(quantidadeDeNotas > notasDeCemDisponiveis) {
						System.out.println("Quantidade de notas de 100 indisponível para o valor informado");
						return;
					} else {
						notasDeCemDisponiveis --;
					}
					
				}

				valor = valor - (quantidadeDeNotas * nota);
				dispensas.add(String.format("%d notas de %d", quantidadeDeNotas, nota));
			
			}
		}
		
		if(valor > 0) {

			System.out.println("Valor inválido");

		} else {
			
			System.out.println("Notas dispensadas:");
		
			for(String dispensa : dispensas) {
				System.out.println(dispensa);
			}
		}
		
	}
		
}

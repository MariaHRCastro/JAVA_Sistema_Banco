package Aplicativo;

import java.util.Locale;
import java.util.Scanner;

import Entidade.Conta;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		// INICIA A VARIAVEL, TAVA ESQUECENDO J�
		Conta conta;

		System.out.print("Digite o n�mero da conta: ");
		int numero = sc.nextInt();
		System.out.print("Digite o nome do usu�rio dono da conta: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Haver� um dep�sito inicial (s/n) ? ");
		char resp = sc.next().charAt(0);
		// USO VARI�VEIS GEN�RICAS ANTES DA INSTANCIA��O QUE ACONTECE NO IF,LEMBRANDO DA
		// SOBRECARGA QUE ACONTECE
		if (resp == 's') {
			System.out.print("Digite o valor do dep�sito inicial: ");
			double balanco = sc.nextDouble();
			conta = new Conta(numero, nome, balanco);
		} else {
			conta = new Conta(numero, nome);
		}

		// ESSA VARI�VEL CONTA J� VAI ESTAR ATUALIZADA, E EDITADA DE ACORDO COM O
		// TOSTRING QUE EU DEFINI
		System.out.println();
		System.out.println("Dados da conta : ");
		System.out.println(conta);

		// AGORA AS OPERA��ES, METODOS//
		System.out.println();
		System.out.print("Qual opera��o voc� deseja fazer ? (1-Saque/ 2- Dep�sito):");
		// CRIO UMA VARI�VEL GEN�RICA PRA PEGAR A RESPOSTA
		int escolha = sc.nextInt();

		if (escolha == 1) {
			System.out.println("Voce escolheu SAQUE.");
			System.out.println("Digite o valor do saque, lembrando que o saldo de sua conta � de R$ "
					+ conta.getBalanco() + " reais: ");
			double valor = sc.nextDouble();
			// CHAMANDO A ENTIDADE, O NOME DA FUN��O (PARAM�TROS)
			if (conta.getBalanco() < valor) {
				System.out.println();
				System.out.println("SALDO INSUFICIENTE. Contate o gerente ou tente novamente!");
			} else {
				conta.saque(valor);
				System.out.println();
				System.out.println("Opera��o realizada com sucesso!");
				System.out.println("Seu novo saldo � de R$" + conta.getBalanco() + " reais .");
			}
		} else {
			System.out.println("Voce escolheu DEP�SITO.");
			System.out.println("Digite o valor do dep�sito, lembrando que o saldo de sua conta � de R$ "
					+ conta.getBalanco() + " reais: ");
			double valor = sc.nextDouble();
			conta.deposito(valor);
			System.out.println("Opera��o realizada com sucesso!");
			System.out.println("Seu novo saldo � de R$" + conta.getBalanco() + " reais :");
		}

		System.out.println();
		System.out.println("Agradecemos a prefer�ncia! Tenha um bom dia !");

		sc.close();

	}

}

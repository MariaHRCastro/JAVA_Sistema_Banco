package Aplicativo;

import java.util.Locale;
import java.util.Scanner;

import Entidade.Conta;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		// INICIA A VARIAVEL, TAVA ESQUECENDO JÁ
		Conta conta;

		System.out.print("Digite o número da conta: ");
		int numero = sc.nextInt();
		System.out.print("Digite o nome do usuário dono da conta: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Haverá um depósito inicial (s/n) ? ");
		char resp = sc.next().charAt(0);
		// USO VARIÁVEIS GENÉRICAS ANTES DA INSTANCIAÇÃO QUE ACONTECE NO IF,LEMBRANDO DA
		// SOBRECARGA QUE ACONTECE
		if (resp == 's') {
			System.out.print("Digite o valor do depósito inicial: ");
			double balanco = sc.nextDouble();
			conta = new Conta(numero, nome, balanco);
		} else {
			conta = new Conta(numero, nome);
		}

		// ESSA VARIÁVEL CONTA JÁ VAI ESTAR ATUALIZADA, E EDITADA DE ACORDO COM O
		// TOSTRING QUE EU DEFINI
		System.out.println();
		System.out.println("Dados da conta : ");
		System.out.println(conta);

		// AGORA AS OPERAÇÕES, METODOS//
		System.out.println();
		System.out.print("Qual operação você deseja fazer ? (1-Saque/ 2- Depósito):");
		// CRIO UMA VARIÁVEL GENÉRICA PRA PEGAR A RESPOSTA
		int escolha = sc.nextInt();

		if (escolha == 1) {
			System.out.println("Voce escolheu SAQUE.");
			System.out.println("Digite o valor do saque, lembrando que o saldo de sua conta é de R$ "
					+ conta.getBalanco() + " reais: ");
			double valor = sc.nextDouble();
			// CHAMANDO A ENTIDADE, O NOME DA FUNÇÃO (PARAMÊTROS)
			if (conta.getBalanco() < valor) {
				System.out.println();
				System.out.println("SALDO INSUFICIENTE. Contate o gerente ou tente novamente!");
			} else {
				conta.saque(valor);
				System.out.println();
				System.out.println("Operação realizada com sucesso!");
				System.out.println("Seu novo saldo é de R$" + conta.getBalanco() + " reais .");
			}
		} else {
			System.out.println("Voce escolheu DEPÓSITO.");
			System.out.println("Digite o valor do depósito, lembrando que o saldo de sua conta é de R$ "
					+ conta.getBalanco() + " reais: ");
			double valor = sc.nextDouble();
			conta.deposito(valor);
			System.out.println("Operação realizada com sucesso!");
			System.out.println("Seu novo saldo é de R$" + conta.getBalanco() + " reais :");
		}

		System.out.println();
		System.out.println("Agradecemos a preferência! Tenha um bom dia !");

		sc.close();

	}

}

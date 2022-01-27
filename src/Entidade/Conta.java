package Entidade;

public class Conta {
	
		private int numero;
		private String nome;
		private double balanco;
		
		//ENCAPSULAMENTO//
		public int getNumero() {
			return numero;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public double getBalanco() {
			return balanco;
		}
		
		
		//SOBRECARGA - MESMO NOME MAS DIFERENTES LISTAS DE PARAMETRO//
		public Conta (int numero, String nome) {
			this.numero = numero;
			this.nome = nome;
		}
		public Conta (int numero, String nome,double balanco) {
			this.numero = numero;
			this.nome = nome;
			this.balanco = balanco;
		}
		
		//MÉTODOS DE SAQUE E DEPOSITO
		
		public void deposito(double quantia) {
			balanco += quantia;
		}
		public void saque (double quantia) {
			balanco -= quantia;
		}
		
		//TOSTRING DE IMPRESSÃO//
		public String toString(){
			return "Número da conta :"
					+  numero
					+ " Usuário: "
					+  nome
					+ " Saldo: R$ "
					+ balanco ;
		}
		
}

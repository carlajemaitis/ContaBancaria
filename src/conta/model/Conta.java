package conta.model;

public abstract class Conta { 

	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	protected float saldo; //Posso usar o protected? Para conseguir usar a variável na subclasse ContaCorrente
	
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public boolean sacar(float valor, int tipo_saque) {
		
		// 1-transf ou 2-saque
		
		if (this.getSaldo() < valor) {
			if(tipo_saque == 2){
			System.out.println("\n>>>> Saque de " + valor + " <<<<");
			System.out.println(">>>> Seu saldo é insuficiente! <<<<");
			System.out.println(">>>> Faça um saque de até " + this.saldo + " <<<<");
			return false;
			}
			else {
				System.out.println("\n>>>> Não foi possível fazer a transferência, saldo insuficiente, seu saldo é de:" + this.getSaldo() + "<<<<");
				return false;
			}
		}
		
		this.setSaldo(this.getSaldo() - valor);
			if(tipo_saque == 2) {
			System.out.println("\n>>>> Saque de " + valor + " <<<<");
			System.out.println(">>>> Operação realizada com sucesso! <<<<");
			System.out.println(">>>> Saldo atual: " + this.saldo + " <<<<");
			}
			else {
				System.out.println("\n>>>> Sua tranferência de " + valor + " foi realizada com sucesso. <<<<");
			}
			return true;
		}
	
	public void depositar(float valor, int tipo_deposito) {
		
		// 1-deposito ou 2-transf
		this.setSaldo(this.getSaldo() + valor);
		if(tipo_deposito == 1) {
		System.out.println("\n>>>> Depósito de " + valor + " <<<<");
		System.out.println(">>>> Operação realizada com sucesso! <<<<");
		System.out.println(">>>> Saldo atual: " + this.saldo + " <<<<");
		}
	}
	
	public void visualizar() {
		
		String tipo = "";
		
		switch (this.tipo) {
		case 1: 
			tipo = "Conta Corrente";
			break;
		case 2:
			tipo = "Conta Poupança";
			break;
		}
		
		System.out.println("\n\n*******************************************************");
		System.out.println("                 DADOS DA CONTA:");
		System.out.println("*******************************************************");
		System.out.println("Número da conta: " + this.numero);
		System.out.println("Agência: " + this.agencia);
		System.out.println("Tipo da conta: " + tipo);
		System.out.println("Titular: " + this.titular);
		System.out.println("Saldo: " + this.saldo);
	}
}

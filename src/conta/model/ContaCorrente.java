package conta.model;

public class ContaCorrente extends Conta {
	
	private float limite;
	 
	public ContaCorrente (int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	
	public float getLimite() {
		return limite;
	}
		
	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar (float valor) {
		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n>>>> Saque de " + valor + " <<<<");
			System.out.println(">>>> Seu saldo é insuficiente! <<<<");
			System.out.println(">>>> Faça um saque de até " + saldo + " <<<<");
			return false;
		}
	
		this.setSaldo(this.getSaldo() - valor);
		System.out.println("\n>>>> Saque de " + valor + " <<<<");
		System.out.println(">>>> Operação realizada com sucesso! <<<<");
		System.out.println(">>>> Saldo atual: " + saldo + " <<<<");
		return true;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite de crédito: " + this.limite);
	}
}

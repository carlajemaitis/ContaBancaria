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
	public boolean sacar (float valor, int tipo_saque) {
		if (this.getSaldo() + this.getLimite() < valor) {
			if(tipo_saque == 2){
			System.out.println("\n>>>> Saque de " + valor + " <<<<");
			System.out.println(">>>> Seu saldo é insuficiente! <<<<");
			System.out.println(">>>> Faça um saque de até " + saldo + " <<<<");
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
		System.out.println(">>>> Saldo atual: " + saldo + " <<<<");
		}
		else {
			System.out.println("\n>>>> Sua tranferência de " + valor + " foi realizada com sucesso. <<<<");
		}
		return true;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite de crédito: " + this.limite);
	}
}

public class ContaCorrente {
    private String nomeConta;
    private String nomeCliente;
    private double saldo;

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double s) {
        this.saldo = s;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        boolean resultado = false;
        double taxa = 0.005d;
        if(this.saldo >= (valor + (valor * taxa))){
            this.saldo = this.saldo - valor - (valor * taxa);
            resultado = true;
        }
        return resultado;
    }
}
public class Banco extends ContaCorrente {
    public static void main(String[] args) {
        System.out.println("Conta Corrente:");
        ContaCorrente cc1 = new ContaCorrente();
        cc1.depositar(1000);
        System.out.println("saldo: " + cc1.getSaldo());
        cc1.sacar(100);
        System.out.println("Sacou 100. Novo saldo: " + cc1.getSaldo());

        System.out.println("Conta Corrente:");
        ContaCorrente ce1 = new ContaCorrente();
        ce1.depositar(2000);
        System.out.println("Saldo: " + ce1.getSaldo());
        boolean sacou = ce1.sacar(100);
        if (sacou) {
            System.out.println("Sacou 500");
        }
        System.out.println("Saldo: " + ce1.getSaldo());
    }
}

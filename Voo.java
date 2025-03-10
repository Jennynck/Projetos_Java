package Trabalho;

public class Voo {
    private int codigoVoo; // Número do voo atualizado para um nome mais descritivo
    private String horario;
    private int quantidadePassageiros;
    private Passageiro[] listaPassageiros;
    private static final int capacidadeMaxima = 50;

    public Voo() {
        this.listaPassageiros = new Passageiro[capacidadeMaxima];
        this.quantidadePassageiros = 0;
    }

    public int getCodigoVoo() {
        return this.codigoVoo;
    }

    public void setCodigoVoo(int codigo) {
        this.codigoVoo = codigo;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Passageiro getPassageiro(int indice) {
        return this.listaPassageiros[indice];
    }

    public void adicionarPassageiro(Passageiro passageiro) {
        // Verifica se ainda há assentos disponíveis
        if (this.quantidadePassageiros < capacidadeMaxima) {
            this.listaPassageiros[this.quantidadePassageiros] = passageiro;
            this.quantidadePassageiros++;
        } else {
            System.out.println("Capacidade máxima atingida! Não é possível adicionar mais passageiros.");
        }
    }

    public int getQuantidadePassageiros() {
        return this.quantidadePassageiros;
    }

    // Método para calcular os assentos disponíveis (decresce conforme passageiros são adicionados)
    public int getAssentosDisponiveis() {
        return capacidadeMaxima - this.quantidadePassageiros;
    }
}

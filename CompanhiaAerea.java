package Trabalho;

public class CompanhiaAerea {
    private String nomeComp;
    private String fone;
    private int qtdVoos;
    private Voo[] vetVoos;

    public CompanhiaAerea() {
        this.vetVoos = new Voo[10];
        this.qtdVoos = 0;
    }

    // Getter para o nome da companhia
    public String getNomeComp() {
        return nomeComp;
    }

    // Setter para o nome da companhia
    public void setNomeComp(String nomeComp) {
        this.nomeComp = nomeComp;
    }

    // Getter para o telefone
    public String getFone() {
        return fone;
    }

    // Setter para o telefone
    public void setFone(String fone) {
        this.fone = fone;
    }

    // Retorna um voo específico pelo índice
    public Voo getVoo(int indiceVoo) {
        return this.vetVoos[indiceVoo];
    }

    // Adiciona um novo voo à lista, caso o limite não tenha sido alcançado
    public void adicionarVoo(Voo novoVoo) {
        if (this.qtdVoos < 10) {
            this.vetVoos[this.qtdVoos] = novoVoo;
            this.qtdVoos++;
        } else {
            System.out.println("Limite de voos atingido!");
        }
    }

    // Retorna a quantidade de voos cadastrados
    public int getQuantidadeVoos() {
        return this.qtdVoos;
    }
}

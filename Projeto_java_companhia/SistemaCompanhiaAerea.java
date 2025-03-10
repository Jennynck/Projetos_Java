package Trabalho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SistemaCompanhiaAerea {
    private CompanhiaAerea companhiaAerea;
    private BufferedReader reader;

    public static void main(String[] args) throws Exception {
        SistemaCompanhiaAerea sistema = new SistemaCompanhiaAerea();
        sistema.companhiaAerea = new CompanhiaAerea();
        sistema.reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Nome da Companhia Aérea:");
        sistema.companhiaAerea.setNomeComp(sistema.reader.readLine());
        System.out.println("Telefone:");
        sistema.companhiaAerea.setFone(sistema.reader.readLine());
        sistema.menu();
    }

    // Menu de opções
    private void menu() throws IOException {
        String opcao = "";
        while (!opcao.equals("4")) {
            System.out.println("-------------------------");
            System.out.println("[1] Cadastrar novo Voo");
            System.out.println("[2] Listar Voos ");
            System.out.println("[3] Consultar um Voo");
            System.out.println("[4] Sair");
            opcao = this.reader.readLine();
            switch (opcao) {
                case "1":
                    this.cadastrarVoo();
                    break;

                case "2":
                    this.listarVoos();
                    break;

                case "3":
                    this.consultarVoo();
                    break;

                default:
                    break;
            }
        }
    }

    // Cadastrar novo Voo
    private void cadastrarVoo() throws IOException {
        Voo voo = new Voo();
        System.out.println("Cadastro de Voo: ");
        System.out.println("Código do Voo: ");
        voo.setCodigoVoo(Integer.parseInt(reader.readLine()));

        System.out.println("Horário: ");
        voo.setHorario(reader.readLine());

        System.out.println("-----Passageiros-----");
        for (int i = 0; i < 50; i++) {
            System.out.println("Nome: ");
            String nome = reader.readLine();
            if (nome.equals("")) {
                break;
            }
            Passageiro passageiro = new Passageiro();
            passageiro.setNome(nome);
            System.out.println("CPF: ");
            passageiro.setCpf(reader.readLine());
            System.out.println("Telefone: ");
            passageiro.setFone(reader.readLine());

            voo.adicionarPassageiro(passageiro);
        }
        this.companhiaAerea.adicionarVoo(voo);
    }

    // Listar todos os voos
    private void listarVoos() throws IOException {
        System.out.println("-----------------------");
        System.out.println("Relatório de Voos: ");
        for (int i = 0; i < this.companhiaAerea.getQuantidadeVoos(); i++) {
            Voo voo = this.companhiaAerea.getVoo(i);
            System.out.println("Código: " + voo.getCodigoVoo() + " - Horário: " + voo.getHorario());
            // Exibe o número de assentos livres para cada voo
            System.out.println("Assentos livres: " + voo.getAssentosDisponiveis());
        }
    }

    // Consultar detalhes de um voo específico
    private void consultarVoo() throws IOException {
        System.out.println("------------------");
        System.out.println("Consulta do Voo:");
        System.out.println("Código do Voo:");
        int codigoVoo = Integer.parseInt(reader.readLine());
        boolean achou = false;

        for (int i = 0; i < this.companhiaAerea.getQuantidadeVoos(); i++) {
            Voo voo = this.companhiaAerea.getVoo(i);
            if (voo.getCodigoVoo() == codigoVoo) {
                System.out.println("Assentos disponíveis: " + voo.getAssentosDisponiveis());
                System.out.println("[Passageiros do Voo]");
                int posPassageiro = 0;
                while (voo.getPassageiro(posPassageiro) != null) {
                    String linha = "Nome: " + voo.getPassageiro(posPassageiro).getNome();
                    linha += " . CPF: " + voo.getPassageiro(posPassageiro).getCpf();
                    linha += " . Telefone: " + voo.getPassageiro(posPassageiro).getFone();
                    System.out.println(linha);
                    posPassageiro++;
                }

                achou = true;
                break;
            }
        }

        if (!achou) {
            System.out.println("Voo não encontrado.");
        }
    }
}

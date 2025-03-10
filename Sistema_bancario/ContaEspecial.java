public class ContaEspecial extends ContaCorrente {

    //polimorfismo de sobreposição ou por herança (override)
    @Override //annotation que força o polimorfismo de sobreposição
    public boolean sacar (double valor){
        boolean resultado = false;
        double taxa = 0.003d;
        if(this.getSaldo() >= (valor + (valor * taxa))){
            this.setSaldo(this.getSaldo() - valor - (valor * taxa));
            resultado = true;
        }
        return resultado;
    }

    //polimorfismo por sobrecarga de método ( overload)

    public boolean sacar(double valor, double taxa){
        boolean resultado = false;
        if(this.getSaldo() >= (valor + (valor * taxa))){
            this.setSaldo(this.getSaldo() - valor - (valor * taxa));
            resultado = true;
        }
        return resultado;
    }

}
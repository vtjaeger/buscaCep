public record Endereco(String cep, String bairro,String localidade, String uf, int numeroPredio, int numeroCasa) {
    @Override
    public String toString() {
        return String.format("CEP: %s%n" +
                "Bairro: %s%n" +
                "Cidade: %s%n" +
                "Numero casa/ predio: %d%n" +
                "Numero apartamento: %d%n" +
                "Estado: %s%n", cep,localidade, bairro,numeroCasa, numeroPredio, uf);

    }
    public Endereco setNumeroCasa(int numeroCasa){
        return new Endereco(cep,localidade, bairro, uf, numeroPredio, numeroCasa);
    }

    public Endereco setNumeroApartamento(int numeroApartamento) {
        return new Endereco(cep,localidade, bairro, uf, numeroPredio, numeroApartamento);
    }

    public Endereco setNumeroPredio(int numeroPredio) {
        return new Endereco(cep,localidade, bairro, uf, numeroPredio, numeroCasa);
    }
}

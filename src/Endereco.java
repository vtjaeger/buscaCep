public record Endereco(String cep, String bairro,String localidade, String uf, int numeroCasa) {
    @Override
    public String toString() {
        return String.format("CEP: %s%n" +
                "Bairro: %s%n" +
                "Cidade: %s%n" +
                "Numero casa/ predio: %d%n" +
                "Estado: %s%n", cep,localidade, bairro,numeroCasa, uf);

    }
    public Endereco setNumeroCasa(int numeroCasa){
        return new Endereco(cep,localidade, bairro, uf, numeroCasa);
    }

    public Endereco setNumeroApartamento(int numeroApartamento) {
        return new Endereco(cep,localidade, bairro, uf, numeroApartamento);
    }
}

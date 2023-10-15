public record Endereco(String cep, String bairro, String localidade, String uf, int numeroCasa) {
    public String toString() {
        return String.format("CEP: %s%n" +
                "Bairro: %s%n" +
                "Cidade: %s%n" +
                "Numero casa: %d%n" +
                "Estado: %s%n", cep, bairro, localidade, numeroCasa, uf);

    }
    public Endereco setNumeroCasa(int numeroCasa){
        return new Endereco(cep,localidade, bairro, uf, numeroCasa);
    }
}

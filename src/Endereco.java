public record Endereco(String cep, String bairro, String uf, int numeroCasa) {
    @Override
    public String toString() {
        return String.format("CEP: %s%n" +
                "Bairro: %s%n" +
                "Numero casa: %d%n" +
                "Estado: %s%n", cep, bairro,numeroCasa, uf);

    }
    public Endereco setNumeroCasa(int numeroCasa){
        return new Endereco(cep, bairro, uf, numeroCasa);
    }
}

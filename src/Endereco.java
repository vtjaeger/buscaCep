public record Endereco(String cep, String localidade, String bairro, String uf, int numeroCasa) {
    @Override
    public String toString() {
        return String.format(
                        "CEP: %s%n" +
                        "Bairro: %s%n" +
                        "Cidade: %s%n" +
                        "Número da Casa: %d%n" +
                        "Estado: %s%n", cep,bairro, localidade, numeroCasa, uf);
    }
    public Endereco setNumeroCasa(int numeroCasa){
        return new Endereco(cep,localidade, bairro, uf, numeroCasa);
    }
}

public record Endereco(String cep, String bairro, String complemento,  String localidade, String uf) {
    @Override
    public String toString() {
        return String.format("CEP: %s%n" +
                "Bairro: %s%n" +
                "Localidade: %s%n" +
                "UF: %s%n",  cep, bairro, complemento, localidade, uf);
    }
}

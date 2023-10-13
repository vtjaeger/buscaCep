public class CalculaFrete {
    public double calcularFrete(Endereco endereco){
        String uf = endereco.uf();
        double valor;
        double formulaFrete;
        double precoAtual;

        switch (uf){
            case "SP":
                valor = 4;
                break;
            case "RJ":
                valor = 5;
                break;
            case "RS":
                valor = 0;
                break;
            case "MG":
                valor = 6;
                break;
            case "ES":
                valor = 3;
                break;
            case "BH":
                valor = 7;
                break;

            default:
                throw new UnsupportedOperationException("UF nao suportada " + uf);
        }
        formulaFrete = (10 * valor);
        precoAtual = formulaFrete;

        return precoAtual;
    }
}

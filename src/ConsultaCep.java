import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaCep {
    Scanner scanner = new Scanner(System.in);
    public Endereco buscaEndereco(String cep) throws IOException, InterruptedException {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();


        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        Endereco enderecoObj = new Gson().fromJson(response.body(), Endereco.class);
        CalculaFrete calculoDeFrete = new CalculaFrete();
        double frete = calculoDeFrete.calcularFrete(enderecoObj);

        VerificaCasa casaOuAp = new VerificaCasa();
        boolean isCasa = casaOuAp.casa(enderecoObj);

        int numeroPredio = 0;
        int numeroCasaOuAp = 0;
        if (isCasa) {
            System.out.println("Insira o número da casa:");
            numeroCasaOuAp = scanner.nextInt();
            enderecoObj = enderecoObj.setNumeroCasa(numeroCasaOuAp);
        } else {
            System.out.println("Insira o número do predio:");
            numeroPredio = scanner.nextInt();
            System.out.println("Insira o número do apartamento:");
            numeroCasaOuAp = scanner.nextInt();
            enderecoObj = enderecoObj.setNumeroApartamento(numeroCasaOuAp);
        }

        if (frete == 0) {
            System.out.println("Frete grátis");

        } else {
            String freteFormato = String.format("Valor do frete para %s: %.2f", enderecoObj.uf(), frete);
            System.out.println(freteFormato);
        }
        Thread.sleep(200);
        System.out.println("Confirmando os dados do CEP...");

        return enderecoObj;
    }

}
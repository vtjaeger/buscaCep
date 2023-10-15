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

        int numeroCasa = 0;

        System.out.println("Insira o número da casa:");
        numeroCasa = scanner.nextInt();
        enderecoObj = enderecoObj.setNumeroCasa(numeroCasa);

        if (frete == 0) {
            System.out.println("Frete grátis\n");

        } else {
            String freteFormato = String.format("Valor do frete para %s: %.2f", enderecoObj.uf(), frete);
            System.out.println(freteFormato);
        }
        System.out.println("Confirmando os dados do CEP...");
        return enderecoObj;
    }

}
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    public Endereco buscaEndereco(String cep) {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Endereco enderecoObj = new Gson().fromJson(response.body(), Endereco.class);
            CalculaFrete calculoDeFrete = new CalculaFrete();
            double frete = calculoDeFrete.calcularFrete(enderecoObj);


            if(frete == 0) {
                System.out.println("Frete grátis");
                Thread.sleep(200);
                System.out.println("Confirmando os dados do CEP...");
            }
            else {
                String freteFormato = String.format("Valor do frete para %s: %.2f", enderecoObj.uf(), frete);
                System.out.println(freteFormato);
                Thread.sleep(200);
                System.out.println("Confirmando os dados do CEP...");
            }
            return enderecoObj;
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }
    }
}
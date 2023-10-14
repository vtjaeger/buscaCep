import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaCep consula = new ConsultaCep();

        System.out.println("Digite o número do CEP:");
        String cep = scanner.nextLine();

        try{
            Endereco novoEndereco = consula.buscaEndereco(cep);

            System.out.println(novoEndereco);
            GeradorArquivo gerador = new GeradorArquivo();
            gerador.geraJson(novoEndereco);

        } catch (RuntimeException | IOException | InterruptedException e){
            System.out.println(e.getMessage());;
            System.out.println("Finalizando aplicacao");
        }

    }
}
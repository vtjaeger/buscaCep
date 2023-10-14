import java.util.Scanner;

public class VerificaCasa {
    Scanner scanner = new Scanner(System.in);
    public boolean casa(Endereco endereco){
        int opcao;
        do{
            System.out.println("Selecione o tipo de residencia:");
            System.out.println("1 - Casa");
            System.out.println("2 - Apartamento");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Opção selecionada: CASA");
                    return true;
                case 2:
                    System.out.println("Opção selecionada: APARTAMENTO");
                    return false;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }
}

import java.util.HashMap;
import java.util.Map;

public class CalculaFrete {
    private static final Map<String, Double> VALORES_POR_ESTADO = iniciarlizarValoresPorEstado();
    private static Map<String, Double> iniciarlizarValoresPorEstado(){
        Map<String, Double> valoresPorEstado = new HashMap<>();
        valoresPorEstado.put("AC", 4.0);
        valoresPorEstado.put("AL", 5.4);
        valoresPorEstado.put("AP", 2.4);
        valoresPorEstado.put("AM", 0.0);
        valoresPorEstado.put("BA", 5.7);
        valoresPorEstado.put("CE", 4.2);
        valoresPorEstado.put("ES", 2.1);
        valoresPorEstado.put("GO", 4.0);
        valoresPorEstado.put("MA", 5.2);
        valoresPorEstado.put("MT", 5.0);
        valoresPorEstado.put("MS", 4.9);
        valoresPorEstado.put("MG", 5.3);
        valoresPorEstado.put("PA", 5.1);
        valoresPorEstado.put("PB", 5.2);
        valoresPorEstado.put("PR", 4.7);
        valoresPorEstado.put("PE", 4.6);
        valoresPorEstado.put("PI", 5.1);
        valoresPorEstado.put("RJ", 2.0);
        valoresPorEstado.put("RN", 6.6);
        valoresPorEstado.put("RS", 0.0);
        valoresPorEstado.put("RO", 6.4);
        valoresPorEstado.put("RR", 6.1);
        valoresPorEstado.put("SC", 1.1);
        valoresPorEstado.put("SP", 2.1);
        valoresPorEstado.put("SE", 6.1);
        valoresPorEstado.put("TO", 6.3);
        valoresPorEstado.put("DF", 4.0);
        return valoresPorEstado;
    }
    public double calcularFrete(Endereco endereco){

        String uf = endereco.uf();
        double valor;

        if(VALORES_POR_ESTADO.containsKey(uf)){
            valor = VALORES_POR_ESTADO.get(uf);
        } else {
            throw new UnsupportedOperationException("Nao é possivel realizar entregas em " + uf);
        }
        return (8.9 * valor);
    }

}

import java.util.HashMap;
import java.util.Map;

public class CalculaFrete {
    private static final Map<String, Double> VALORES_POR_ESTADO = iniciarlizarValoresPorEstado();

    private static Map<String, Double> iniciarlizarValoresPorEstado(){
        Map<String, Double> valoresPorEstado = new HashMap<>();
        valoresPorEstado.put("SP", 4.0);
        valoresPorEstado.put("RJ", 5.0);
        valoresPorEstado.put("RS", 0.0);
        valoresPorEstado.put("MG", 6.0);
        valoresPorEstado.put("ES", 3.0);
        valoresPorEstado.put("BH", 7.0);
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
        double formulaFrete = (10 * valor);
        return formulaFrete;
    }
}

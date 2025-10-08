import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Dijkstra {

    public static Map<Livro, Integer> dijkstra(Map<Livro, Set<Livro>> grafo, Livro origem) {

        Map<Livro, Integer> distancias = new HashMap<>();
        Queue<Livro> fila = new LinkedList<>();

        distancias.put(origem, 0);

        fila.add(origem);

        while (!fila.isEmpty()) {

            Livro atual = fila.poll();

            int distanciaAtual = distancias.get(atual);

            for (Livro vizinho : grafo.getOrDefault(atual, new HashSet<>())) {

                int novaDistancia = distanciaAtual + 1; // Supondo que a distância entre cada par de livros é 1

                if (!distancias.containsKey(vizinho) || novaDistancia < distancias.get(vizinho)) {

                    distancias.put(vizinho, novaDistancia);

                    fila.add(vizinho);
                }
            }
        }

        return distancias;
    }
    
    public static void calcularEImprimirDistancias(Livro livroOrigem, Map<Livro, Set<Livro>> grafo) {
        Map<Livro, Integer> distancias = dijkstra(grafo, livroOrigem);
        imprimirDistancias(livroOrigem, distancias);
    }
    
    public static void imprimirDistancias(Livro livroOrigem, Map<Livro, Integer> distancias) {
    	String stringSublinhado = "\033[4m" + livroOrigem + "\033[0m";
        System.out.println("- Distancias de " + stringSublinhado + " para outros livros:");

        // Converter o Map em uma lista de pares (livro, distância)
        List<Map.Entry<Livro, Integer>> listaDistancias = new ArrayList<>(distancias.entrySet());

        // Ordenar a lista por distância
        Collections.sort(listaDistancias, Comparator.comparing(Map.Entry::getValue));

        // Imprimir os livros ordenados por distância
        for (Map.Entry<Livro, Integer> entry : listaDistancias) {
            Livro livro = entry.getKey();
            int distancia = entry.getValue();
            if (!livro.equals(livroOrigem)) {
                System.out.println("> " + livro + " - \033[4mDistancia: " + distancia + "\033[0m");
            } 
        }
        System.out.println();
    }
            
}

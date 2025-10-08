import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class Grafo {
	private HashMap<Livro, Set<Livro>> grafo;

    public Grafo() {
    	grafo = new HashMap<>();
    }

    public void addLivro(Livro livro) {
        grafo.put(livro, new LinkedHashSet<>());
    }
    
    public void addRecomendacao(Livro origem, Livro... destinos) {
        if (grafo.containsKey(origem)) {
            for (Livro destino : destinos) {
                if (grafo.containsKey(destino)) {
                    grafo.get(origem).add(destino);
                    grafo.get(destino).add(origem);
                }
            }
        }
    }
    
    public Map<Livro, Set<Livro>> getGrafo() {
        return grafo;
    }
    
    public void imprimirRecomendacoesGrafo() {
    	for (Livro livro : grafo.keySet()) {
    		String stringSublinhado = "\033[4m" + livro.toString() + "\033[0m";
            System.out.print("- Para o livro " + stringSublinhado + "; recomenda-se os seguintes livros:\n");
            Set<Livro> recomendacoes = grafo.get(livro);
            
            for (Livro recomendacao : recomendacoes) {
                System.out.print("> " + recomendacao.toString());
                System.out.println();  
            }
            System.out.println();
        }
    }
}
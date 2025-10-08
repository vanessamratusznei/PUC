import java.util.Stack;

public class Usuario {
	String nome;
	Stack<Livro> historicoNavegacao;
	
	public Usuario(String nome) {
		this.nome = nome;
		this.historicoNavegacao = new Stack<>();
	}
	
	public void addLivroHistoricoNavegacao (Livro livro) {
		historicoNavegacao.push(livro);
	}
	
	public void imprimirHistoricoNavegacao() {
		String stringSublinhado = "\033[4m" + this.nome + "\033[0m";
		System.out.println("- Pilha de navegacao do usuario " + stringSublinhado + ":");
		if (historicoNavegacao.isEmpty()) {
			System.out.println("[X] Nao ha historico de navegacao para esse usuario.");
		} else {
			int contador = 1;
			while (!this.historicoNavegacao.isEmpty()) {
				System.out.println("[" + contador + "] " + this.historicoNavegacao.pop().toString());
				contador++;
			}
		}
		System.out.println();
	}
}

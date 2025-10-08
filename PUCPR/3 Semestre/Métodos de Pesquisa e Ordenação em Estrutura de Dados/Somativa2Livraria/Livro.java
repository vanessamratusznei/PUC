import java.util.LinkedList;
import java.util.Queue;

public class Livro {
	String titulo;
	String autor;
	int anoPublicacao;
	Queue<Usuario> filaEsperaLivro;
	
	public Livro(String titulo, String autor, int anoPublicacao) {
		this.titulo = titulo;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;
		this.filaEsperaLivro = new LinkedList<>();
	}
	
	@Override
	public String toString() {
		return "'" + this.titulo + "' por " + this.autor + ", " + this.anoPublicacao;
	}
	
	public void addUsuarioFilaEsperaLivro(Usuario nome) {
		this.filaEsperaLivro.add(nome);
	}
	
	public void imprimirFilaEspera() {
		String stringSublinhado = "\033[4m" + toString() + "\033[0m";
	    System.out.println("- Fila de espera do livro " + stringSublinhado + ":");
		if (filaEsperaLivro.isEmpty()) {
			System.out.println("[X] Nao ha fila de espera para esse livro.");
		} else {
			int contador = 1;
			while (!this.filaEsperaLivro.isEmpty()) {
				System.out.println("[" + contador + "] " + this.filaEsperaLivro.poll().nome);
				contador++;
			}
		}
		System.out.println();
	}
}

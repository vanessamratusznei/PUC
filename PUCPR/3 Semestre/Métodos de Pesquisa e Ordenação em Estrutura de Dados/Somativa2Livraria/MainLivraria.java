import java.util.LinkedList;

public class MainLivraria {

	public static void main(String[] args) {
		LinkedList<Livro> listaLivros = new LinkedList<>();
		
		// Criando Usuarios
		Usuario user1 = new Usuario("Vanessa");
		Usuario user2 = new Usuario("Nicole");
		Usuario user3 = new Usuario("Clara");
		
		// Criando Livros
		Livro livro1 = new Livro("(1)Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997);
		Livro livro2 = new Livro("(2)Game of Thrones", "George R.R. Martin", 1996);
		Livro livro3 = new Livro("(3)O Senhor dos Aneis: A Sociedade do Anel", "J.R.R. Tolkien", 1954);
		Livro livro4 = new Livro("(4)O Hobbit", "J.R.R. Tolkien", 1937);
		Livro livro5 = new Livro("(5)As Cronicas de Narnia: O Leao, a Feiticeira e o Guarda-Roupa", "C.S. Lewis", 1950);
		Livro livro6 = new Livro("(6)Game of Thrones: A Furia dos Reis", "George R.R. Martin", 1998);
		Livro livro7 = new Livro("(7)Percy Jackson e o Ladrao de Raios", "Rick Riordan", 2005);
		Livro livro8 = new Livro("(8)Harry Potter e a Camara Secreta", "J.K. Rowling", 1998);
		Livro livro9 = new Livro("(9)O Senhor dos Aneis: As Duas Torres", "J.R.R. Tolkien", 1954);
		Livro livro10 = new Livro("(10)O Senhor dos Aneis: O Retorno do Rei", "J.R.R. Tolkien", 1955);
		
		// Adicionando livros a 'Lista de Livros'
		listaLivros.add(livro1);
		listaLivros.add(livro2);
		listaLivros.add(livro3);
		listaLivros.add(livro4);
		listaLivros.add(livro5);
		listaLivros.add(livro6);
		listaLivros.add(livro7);
		listaLivros.add(livro8);
		listaLivros.add(livro9);
		listaLivros.add(livro10);
		// Mostrando livros presentes na 'Lista de Livros'
		System.out.println("- Lista de livros:");
		int contador = 1;
		for (Livro livro : listaLivros) {
			System.out.println("[" + contador + "] " + livro.toString());
			contador++;
		}
		System.out.println();
		
		// Demonstrando que a fila de espera por livro está funcionando:
		// Adicionando usuario a fila de espera do livro
		livro1.addUsuarioFilaEsperaLivro(user1);
		livro1.addUsuarioFilaEsperaLivro(user2);
		livro2.addUsuarioFilaEsperaLivro(user3);
		// Mostrando a fila de espera de usuarios por livro
		livro1.imprimirFilaEspera();
		livro2.imprimirFilaEspera();
		livro3.imprimirFilaEspera();
		livro1.addUsuarioFilaEsperaLivro(user2); //adicionando um usuario na fila após a fila ter sido chamada
		livro1.imprimirFilaEspera();//mostrando a fila novamente para demonstar que o .poll está funcionando corretamente
		
		
		// Demonstrando que a pilha de historico de livros por usuario está funcioando:
		// Adicionando livro a pilha de historico do usuario
		user1.addLivroHistoricoNavegacao(livro4);
		user1.addLivroHistoricoNavegacao(livro5);
		user1.addLivroHistoricoNavegacao(livro4);//adicionando livro repetido para demosntrar o que acontece
		user2.addLivroHistoricoNavegacao(livro6);
		user2.addLivroHistoricoNavegacao(livro7);
		user3.addLivroHistoricoNavegacao(livro9);
		user3.addLivroHistoricoNavegacao(livro10);
		// Mostrando Historico de livros por usuario
		user1.imprimirHistoricoNavegacao();
		user2.imprimirHistoricoNavegacao();
		user3.imprimirHistoricoNavegacao();
		user1.imprimirHistoricoNavegacao();//mostrando a pilha novamente para demonstar que o .pop está funcionando corretamente
		
		//Criando grafo para o relacionamento dos livros
		Grafo grafoLivros = new Grafo();
		
		//Demonstrando o funcionamento do grafo:
		//Adicionando livros no grafo
		grafoLivros.addLivro(livro1);
		grafoLivros.addLivro(livro2);
		grafoLivros.addLivro(livro3);
		grafoLivros.addLivro(livro4);
		grafoLivros.addLivro(livro5);
		grafoLivros.addLivro(livro6);
		grafoLivros.addLivro(livro7);
		grafoLivros.addLivro(livro8);
		grafoLivros.addLivro(livro9);
		grafoLivros.addLivro(livro10);
		//Adicionando recomendacoes por livro
		grafoLivros.addRecomendacao(livro1, livro8);
		grafoLivros.addRecomendacao(livro2, livro6, livro3);
		grafoLivros.addRecomendacao(livro3, livro9, livro10);
		grafoLivros.addRecomendacao(livro4, livro3);
		grafoLivros.addRecomendacao(livro5, livro7, livro1);
		grafoLivros.addRecomendacao(livro6, livro3);
		grafoLivros.addRecomendacao(livro7, livro1);
		grafoLivros.addRecomendacao(livro8, livro5, livro7);
		grafoLivros.addRecomendacao(livro9, livro10, livro4, livro2);
		grafoLivros.addRecomendacao(livro10, livro4, livro2);
		
		//adicinando mais recomendacoes para aumentar a complexidade do grafo (e melhorar a demonstracao do algoritmo de Dijkstra)
		grafoLivros.addRecomendacao(livro1, livro2);
		grafoLivros.addRecomendacao(livro2, livro3);
		grafoLivros.addRecomendacao(livro3, livro10);
		
		//Mostrando as recomendacoes feitas - minimo de 2 recomendacoes por livro
		grafoLivros.imprimirRecomendacoesGrafo();
		
		// Utilizando o algoritmo de Dijkstra para encontrar os caminhos mais curtos e imprimir as distâncias
        Dijkstra.calcularEImprimirDistancias(livro1, grafoLivros.getGrafo());
        Dijkstra.calcularEImprimirDistancias(livro2, grafoLivros.getGrafo());
        Dijkstra.calcularEImprimirDistancias(livro3, grafoLivros.getGrafo());
        Dijkstra.calcularEImprimirDistancias(livro4, grafoLivros.getGrafo());
        Dijkstra.calcularEImprimirDistancias(livro5, grafoLivros.getGrafo());
        Dijkstra.calcularEImprimirDistancias(livro6, grafoLivros.getGrafo());
        Dijkstra.calcularEImprimirDistancias(livro7, grafoLivros.getGrafo());
        Dijkstra.calcularEImprimirDistancias(livro8, grafoLivros.getGrafo());
        Dijkstra.calcularEImprimirDistancias(livro9, grafoLivros.getGrafo());
        Dijkstra.calcularEImprimirDistancias(livro10, grafoLivros.getGrafo());
        //Quanto menor a distância, mais próximo este livro é, e maior é a chance de ser uma boa recomendação
	}
}

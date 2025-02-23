package application;
import model.entities.Livros;

public class Program {

	public static void main(String[] args) {
		Livros livro = new Livros("Java", "Deitel", "Programação", 10, 2021, "DISPONIVEL");
		System.out.println(livro);
	}

}

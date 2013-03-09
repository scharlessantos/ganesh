package ganesh.db;

public class Grupo extends AbstractDBEntity {

	private int id = 0;

	private String nome = "Teste";

	@_XMLEntity("id")
	public int getId() {
		return id;
	}

	@_XMLEntity("nome")
	public String getNome() {
		return nome;
	}
}

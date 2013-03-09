package ganesh.db;

public class Grupo extends AbstractDBEntity {

	private int id = 0;

	private String nome = "Teste";

	@_XMLField("id")
	public int getId() {
		return id;
	}

	@_XMLField("nome")
	public String getNome() {
		return nome;
	}
}

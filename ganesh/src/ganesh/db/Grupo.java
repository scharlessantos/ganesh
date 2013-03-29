/* Ganesh Server, developed in 2013*/
package ganesh.db;

public class Grupo extends AbstractDBEntity {

	private int id = 0;

	private String nome = "Teste";

	@_DBField("id")
	public int getId() {
		return id;
	}

	@_DBField("nome")
	public String getNome() {
		return nome;
	}
}

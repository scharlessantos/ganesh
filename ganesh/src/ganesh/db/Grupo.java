/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;

@Entity("grupo")
public class Grupo extends AbstractDBEntity {

	@Id("id_grupo")
	private int id;

	@Property("nome")
	private String nome = "Teste";

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	protected void merge(AbstractDBEntity other) {
		// TODO Auto-generated method stub

	}
}

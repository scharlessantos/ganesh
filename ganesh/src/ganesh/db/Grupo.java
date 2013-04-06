/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotation.Entity;
import ganesh.db.annotation.Field;
import ganesh.db.annotation.Id;

@Entity("grupo")
public class Grupo extends AbstractDBEntity {

	@Id("id_grupo")
	private int id;

	@Field("nome")
	private String nome = "Teste";

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}

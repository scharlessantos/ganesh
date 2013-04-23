/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;

@Entity("grupo")
public class Grupo extends AbstractDBEntity {

	@Id("id_grupo")
	protected Long id;

	@Property("codigo")
	protected String codigo = null;

	@Property("descricao")
	protected String nome = null;

	public long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	protected void merge(AbstractDBEntity other) {
		if (other instanceof Grupo) {
			Grupo grp = (Grupo)other;

			if (this.id == null) {
				this.id = grp.id;

				this.nome = grp.nome;
			} else if (this.id.equals(grp.id))
				this.nome = grp.nome;
		}
	}
}

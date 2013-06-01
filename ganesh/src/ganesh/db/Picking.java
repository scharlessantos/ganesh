/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;

@Entity("picking")
public class Picking extends AbstractDBEntity {

	@Id("id_picking")
	protected Long id;

	@Property("codigo")
	protected String codigo = null;

	@Property("descricao")
	protected String descricao = null;

	public long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	protected void merge(AbstractDBEntity other) {
		if (other instanceof Picking) {
			Picking grp = (Picking)other;

			if (this.id == null) {
				this.id = grp.id;

				this.descricao = grp.descricao;
			} else if (this.id.equals(grp.id))
				this.descricao = grp.descricao;
		}
	}

}

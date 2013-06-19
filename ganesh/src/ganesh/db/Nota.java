/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;

import org.scharlessantos.hermes.Hermes;

@Entity("nota")
public class Nota extends AbstractDBEntity {

	@Id("id_nota")
	protected Long id;

	@Property("id_cliente")
	protected Long idCliente;

	@Property("id_entrega")
	protected Long idEntrega;

	@Property("codigo")
	protected String codigo;

	public Long getId() {
		return id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public Long getIdEntrega() {
		return idEntrega;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public void setIdEntrega(Long idEntrega) {
		this.idEntrega = idEntrega;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	protected void merge(AbstractDBEntity other) {
		Hermes.warn("no merge for Nota");
	}

}

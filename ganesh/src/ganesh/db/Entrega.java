/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;

import java.util.Date;

import org.scharlessantos.hermes.Hermes;

@Entity("entrega")
public class Entrega extends AbstractDBEntity {

	@Id("id_entrega")
	protected Long id;

	@Property("id_motorista")
	protected Long idMotorista;

	@Property("id_caminhao")
	protected Long idCaminhao;

	@Property("dia")
	protected Date dia;

	public Long getId() {
		return id;
	}

	public Long getIdMotorista() {
		return idMotorista;
	}

	public Long getIdCaminhao() {
		return idCaminhao;
	}

	public Date getDia() {
		return dia;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIdMotorista(Long idMotorista) {
		this.idMotorista = idMotorista;
	}

	public void setIdCaminhao(Long idCaminhao) {
		this.idCaminhao = idCaminhao;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	@Override
	protected void merge(AbstractDBEntity other) {
		Hermes.warn("no merge for Entrega");
	}

}

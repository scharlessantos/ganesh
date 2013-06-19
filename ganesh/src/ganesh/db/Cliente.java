/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;

@Entity("cliente")
public class Cliente extends AbstractDBEntity {

	@Id("id_cliente")
	protected Long id;

	@Property("codigo")
	protected String codigo;

	@Property("nome")
	protected String nome;

	@Property("endereco")
	protected String endereco;

	@Property("contato")
	protected String contato;

	@Property("responsavel")
	protected Long responsavel;

	@Override
	protected void merge(AbstractDBEntity other) {
		if (other instanceof Cliente) {

			Cliente cliente = (Cliente)other;

			if (this.id == null)
				this.id = cliente.id;

			if ((cliente.codigo != null && !cliente.codigo.equals(this.codigo)))
				this.codigo = cliente.codigo;

			if ((cliente.nome != null && !cliente.nome.equals(this.nome)))
				this.nome = cliente.nome;

			if ((cliente.codigo != null && !cliente.codigo.equals(this.codigo)))
				this.codigo = cliente.codigo;

			if ((cliente.responsavel != null && !cliente.responsavel.equals(this.responsavel)))
				this.responsavel = cliente.responsavel;

			if ((cliente.contato != null && !cliente.contato.equals(this.contato)))
				this.contato = cliente.contato;

			if ((cliente.endereco != null && !cliente.endereco.equals(this.endereco)))
				this.endereco = cliente.endereco;
		}

	}

}

/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.common.exceptions.GException;
import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;
import ganesh.db.utils.Filter;
import ganesh.db.utils.Filter.FilterType;

@Entity("produto")
public class Produto extends AbstractDBEntity {

	@Id("id_produto")
	protected Long idProduto;

	@Property("codigo")
	protected String codigo;

	@Property("nome")
	protected String nome;

	@Property("complemento")
	protected String complemento;

	@Property("pesavel")
	protected boolean pesavel = false;

	public Long getIdProduto() {
		return idProduto;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getComplemento() {
		return complemento;
	}

	public boolean isPesavel() {
		return pesavel;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setPesavel(boolean pesavel) {
		this.pesavel = pesavel;
	}

	@Override
	protected void merge(AbstractDBEntity other) {
		if (other instanceof Produto) {

			Produto prod = (Produto)other;

			if (idProduto == null)
				idProduto = prod.idProduto;

			if (codigo == null || !codigo.equals(prod.codigo))
				codigo = prod.codigo;

			if (complemento == null || !complemento.equals(prod.complemento))
				codigo = prod.complemento;

			if (pesavel != prod.pesavel)
				pesavel = prod.pesavel;
		}
	}

	public static Produto getById(Long id) throws GException {
		if (id == null)
			return null;

		return DB.first(Produto.class, new Filter(Produto.class, "id_produto", id, FilterType.EQUALS));
	}
}

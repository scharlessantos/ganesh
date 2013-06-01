/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.common.exceptions.GException;
import ganesh.common.request.RequestFilter.FilterType;
import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;
import ganesh.db.utils.Filter;

@Entity("Embalagem")
public class Embalagem extends AbstractDBEntity {

	@Id("id_embalagem")
	protected Long idEmbalagem;

	@Property("id_produto")
	protected Long idProduto;

	@Property("qtd")
	protected long qtd;

	@Property("descricao")
	protected String descricao;

	public Produto getProduto() throws GException {
		return Produto.getById(idProduto);
	}

	public void setProduto(Produto produto) {
		if (produto == null)
			return;

		idProduto = produto.getIdProduto();
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public Long getIdEmbalagem() {
		return idEmbalagem;
	}

	public long getQtd() {
		return qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	protected void merge(AbstractDBEntity other) {
		if (other instanceof Embalagem) {

			Embalagem emb = (Embalagem)other;

			if (emb.idEmbalagem != null && emb.idEmbalagem.equals(idEmbalagem)) {
				qtd = emb.qtd;

				if (emb.descricao != null && !emb.descricao.equals(descricao))
					descricao = emb.descricao;
			}
		}

	}

	public static Embalagem getById(Long id) throws GException {
		if (id == null)
			return null;

		return DB.first(Embalagem.class, new Filter(Embalagem.class, "id_embalagem", id, FilterType.EQUALS));
	}

}

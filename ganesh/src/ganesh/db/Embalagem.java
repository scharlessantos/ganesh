/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.common.exceptions.GException;
import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;

@Entity("Embalagem")
public class Embalagem extends AbstractDBEntity {

	@Id("id_embalagem")
	protected Long idEmbalagem;

	@Property("id_produto")
	protected Long idProduto;

	@Property("qtd")
	protected long qtd;

	public Produto getProduto() throws GException {
		return Produto.getById(idProduto);
	}

	public void setProduto(Produto produto) {
		if (produto == null)
			return;

		idProduto = produto.getIdProduto();
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

	@Override
	protected void merge(AbstractDBEntity other) {
		if (other instanceof Embalagem) {

			Embalagem emb = (Embalagem)other;

			if (emb.idEmbalagem != null && emb.idEmbalagem.equals(idEmbalagem)) {
				qtd = emb.qtd;
			}
		}

	}

}

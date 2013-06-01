/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.common.exceptions.GException;
import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Id;
import ganesh.db.annotations.Property;

import org.scharlessantos.hermes.Hermes;

@Entity("picking_produto")
public class PickingProduto extends AbstractDBEntity {

	@Id("id_embalagem")
	protected Long idEmbalagem;

	@Id("id_picking")
	protected Long idPicking;

	@Property("qtd")
	protected long qtd;

	public long getQtd() {
		return qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

	public Long getIdEmbalagem() {
		return idEmbalagem;
	}

	public Long getIdPicking() {
		return idPicking;
	}

	public void setEmbalagem(Embalagem embalagem) {
		if (embalagem != null)
			idEmbalagem = embalagem.getIdEmbalagem();
	}

	public void setPicking(Picking picking) {
		if (picking != null)
			idPicking = picking.getId();
	}

	@Override
	protected void merge(AbstractDBEntity other) {

	}

	@Override
	public String toXML() {
		StringBuilder sb = new StringBuilder();

		sb.append("<picking_produto id_picking='");
		sb.append(idPicking == null ? "" : idPicking);
		sb.append("' id_embalagem='");
		sb.append(idEmbalagem == null ? "" : idEmbalagem);
		sb.append("' qtd='");
		sb.append(qtd);

		try {
			Embalagem embalagem = Embalagem.getById(idEmbalagem);

			if (embalagem != null) {
				sb.append("' embalagem='");
				sb.append(embalagem.getDescricao());
				sb.append("(");
				sb.append(embalagem.getQtd());
				sb.append(")");

				Produto produto = embalagem.getProduto();

				if (produto != null) {
					sb.append("' produto='");
					sb.append(produto.getCodigo());
					sb.append(" - ");
					sb.append(produto.getNome());
				}
			}

		} catch (GException e) {
			Hermes.error(e);
		}

		return sb.append("' />").toString();
	}
}

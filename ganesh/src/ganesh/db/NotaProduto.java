/* Ganesh Server, developed in 2013*/
package ganesh.db;

import ganesh.db.annotations.Aggregated;
import ganesh.db.annotations.Entity;
import ganesh.db.annotations.Property;

@Entity("Nota")
public class NotaProduto extends AbstractDBEntity {

	@Aggregated("id_nota")
	protected Nota nota;

	@Aggregated("id_produto")
	protected Produto produto;

	@Property("qtd")
	long qtd;

	@Override
	protected void merge(AbstractDBEntity other) {
		// TODO Auto-generated method stub

	}

}

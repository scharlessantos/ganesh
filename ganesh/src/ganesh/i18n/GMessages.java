/* Ganesh Server, developed in 2013*/
package ganesh.i18n;

import ganesh.common.i18n.GString;

/**
 * Interface para traduçoes indiretas
 */
public interface GMessages {

	GString grupos();

	GString erroAoAtualizarOBancoDeDados();

	GString naoFoiPossivelCriarODiretorioDeDados();

	GString arquivoDeDadosExistePoremNaoEhUmDiretorio();

	GString bancoMaisNovoDoQueGaneshEspera();

}

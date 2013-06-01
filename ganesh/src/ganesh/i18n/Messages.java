/* Ganesh Server, developed in 2013*/
package ganesh.i18n;

/**
 * Interface para trauções diretas
 */
public interface Messages {

	String erroAoAtualizarOBancoDeDados();

	String erroAoInserir_(String entity);

	String erroAoSalvar();

	String requisicaoInvalida();

	String usuarioSenhaInvalido();

	String _naoEhUmParametroValido(String simpleName);

	String sessaoInvalida();

	String codigo();

	String _EhObrigatorio(String oque);

	String produto();

	String _jahCadastradoCom_IgualA_(String entidade, String field, String valor);

	String erroAoApagar();

	String _naoEncontrado(String produto);

	String _apagadoComSucesso(String produto);

	String cnpj();

	String nome();

	String empresa();

	String grupo();

	String quantidade();

	String embalagem();

	String caminhao();

	String motorista();

	String documento();

	String picking();

	String quantidadeDeveSerNumerico();

}

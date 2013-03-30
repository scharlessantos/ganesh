/* Ganesh Server, developed in 2013*/
package ganesh;

import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GaneshI18n;
import ganesh.db.Usuario;
import ganesh.i18n.GMessages;
import ganesh.i18n.Messages;
import ganesh.programs.ProgramManager;
import ganesh.programs.grupo.PrgGrupo;

import org.scharlessantos.hermes.Hermes;

public class Ganesh {

	public static Ganesh instance;

	public static Ganesh getInstance() {
		if (instance == null)
			instance = new Ganesh();

		return instance;
	}

	private Ganesh() {

	}

	public void start() {
		registerPrograms();

		try {
			Usuario usuario = Usuario.getByUsername("root");

			if (usuario != null)
				Hermes.info(usuario.toString());
			else {
				usuario = new Usuario();
				usuario.setCodigo("root");
				usuario.setNome("Super Usuário");
				usuario.setContato("root@ganesh");
				usuario.setDocumento("GANESH");
				usuario.setEndereco("R. India");
				usuario.setSenha("123456");
				usuario.setUsername("root");
				usuario.save();
			}

		} catch (GException e) {
			Hermes.error(e);
		}
	}

	private void registerPrograms() {
		ProgramManager.registerProgram("grupo", PrgGrupo.class);
	}

	public static Messages getMessages() {
		return GaneshI18n.genI18nClass(Messages.class);
	}

	public static GMessages getGMessages() {
		return GaneshI18n.genI18nClass(GMessages.class);
	}

}

/* Ganesh Server, developed in 2013*/
package ganesh;

import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GaneshI18n;
import ganesh.db.Usuario;
import ganesh.i18n.GMessages;
import ganesh.i18n.Messages;
import ganesh.programs.ProgramManager;
import ganesh.programs.grupo.PrgGrupo;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import org.scharlessantos.hermes.Hermes;

public class Ganesh {

	public static Ganesh instance;

	public static Ganesh getInstance() {
		if (instance == null)
			instance = new Ganesh();

		return instance;
	}

	private final int pid;

	private Ganesh() {
		RuntimeMXBean rt = ManagementFactory.getRuntimeMXBean();
		pid = Integer.parseInt(rt.getName().substring(0, rt.getName().indexOf("@")));
	}

	public int getPid() {
		return pid;
	}

	public void start() {
		registerPrograms();

		try {
			Hermes.info("Verificando Usuário root");
			Usuario usuario = Usuario.getByUsername("root");

			if (usuario == null) {
				Hermes.info("Criando Usuário root");
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

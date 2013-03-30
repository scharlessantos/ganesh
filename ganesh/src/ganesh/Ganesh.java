/* Ganesh Server, developed in 2013*/
package ganesh;

import ganesh.common.i18n.GaneshI18n;
import ganesh.i18n.GMessages;
import ganesh.i18n.Messages;
import ganesh.programs.ProgramManager;
import ganesh.programs.grupo.PrgGrupo;

import org.scharlessantos.atlas.Language;
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
		GaneshI18n.loadTranslations(Language.PT_BR, this.getClass().getResourceAsStream("i18n/translations/messages.pt_BR.trd"));
		GaneshI18n.loadTranslations(Language.EN_US, this.getClass().getResourceAsStream("i18n/translations/messages.en_US.trd"));

		registerPrograms();
	}

	private void registerPrograms() {

		Hermes.info(Ganesh.getGMessages().arquivoDeDadosExistePoremNaoEhUmDiretorio().toString());

		ProgramManager.registerProgram("grupo", PrgGrupo.class);

	}

	public static Messages getMessages() {
		return GaneshI18n.genI18nClass(Messages.class);
	}

	public static GMessages getGMessages() {
		return GaneshI18n.genI18nClass(GMessages.class);
	}

}

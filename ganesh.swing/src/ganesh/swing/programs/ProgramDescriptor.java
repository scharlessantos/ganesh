/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.programs;

import ganesh.common.i18n.GString;
import ganesh.swing.ProgramManager.Menu;

public class ProgramDescriptor {

	private String name;
	private Class<? extends GaneshProgram> program;
	private GString title;
	private Menu menu;
	private String icon;

	public ProgramDescriptor(String name, Class<? extends GaneshProgram> program, GString title, Menu menu, String icon) {
		this.name = name;
		this.program = program;
		this.title = title;
		this.menu = menu;
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public Class<? extends GaneshProgram> getProgram() {
		return program;
	}

	public GString getTitle() {
		return title;
	}

	public Menu getMenu() {
		return menu;
	}

	public String getIcon() {
		return icon;
	}

}
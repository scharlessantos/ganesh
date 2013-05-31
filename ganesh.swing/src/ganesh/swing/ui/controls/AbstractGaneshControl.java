/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.controls;

import ganesh.common.i18n.GString;
import ganesh.swing.ui.pages.AbstractGaneshPage;

import javax.swing.JComponent;

public abstract class AbstractGaneshControl<G extends JComponent> {

	protected AbstractGaneshPage page;
	protected String name;
	protected GString label;
	protected GString tooltip;

	public AbstractGaneshControl(String name, GString label) {
		this.name = name;
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public GString getLabel() {
		return label;
	}

	public AbstractGaneshControl<G> setLabel(GString label) {
		this.label = label;
		return this;
	}

	public AbstractGaneshPage getPages() {
		return page;
	}

	public AbstractGaneshControl<G> setPage(AbstractGaneshPage page) {
		this.page = page;
		return this;
	}

	public GString getTooltip() {
		return tooltip;
	}

	public AbstractGaneshControl<G> setTooltip(GString tooltip) {
		this.tooltip = tooltip;
		return this;
	}

	public abstract G render();

	public abstract boolean isResponsible();

	public Object get() {
		return null;
	}

	public void set(Object set) {}
}

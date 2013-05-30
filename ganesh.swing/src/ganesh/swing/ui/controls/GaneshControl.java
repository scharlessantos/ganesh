/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.controls;

import ganesh.common.i18n.GString;
import ganesh.swing.ui.pages.GaneshPage;

import javax.swing.JComponent;

public abstract class GaneshControl<E extends JComponent> {

	protected GaneshPage page;
	protected GString label;
	protected GString tooltip;

	public GaneshControl(GString label) {
		this.label = label;
	}

	public GString getLabel() {
		return label;
	}

	public GaneshControl<E> setLabel(GString label) {
		this.label = label;
		return this;
	}

	public GaneshPage getPages() {
		return page;
	}

	public GaneshControl<E> setPage(GaneshPage page) {
		this.page = page;
		return this;
	}

	public GString getTooltip() {
		return tooltip;
	}

	public GaneshControl<E> setTooltip(GString tooltip) {
		this.tooltip = tooltip;
		return this;
	}

	public abstract E render();

}

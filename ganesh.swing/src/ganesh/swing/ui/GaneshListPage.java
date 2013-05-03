/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui;

import ganesh.common.i18n.GString;
import ganesh.swing.ui.custom.RowNumberTable;
import ganesh.swing.ui.images.Images.Icons;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public abstract class GaneshListPage extends GaneshPage {

	private List<Column> columns = new ArrayList<>();
	private boolean multi = false;

	public boolean isMulti() {
		return multi;
	}

	public void setMulti(boolean multi) {
		this.multi = multi;
	}

	protected Column addColumn(String field, GString title, int width) {
		Column col = new Column(field, title, width);
		addColumn(col);
		return col;
	}

	protected Column addColumn(String field, GString title) {
		return addColumn(field, title, 2);
	}

	protected void addColumn(int pos, Column col) {
		columns.add(pos, col);
	}

	protected void addColumn(Column col) {
		columns.add(col);
	}

	protected Column getColumn(String field) {
		for (Column c: columns)
			if (c.getField() == field)
				return c;

		return null;
	}

	private JTable table = null;

	@Override
	public final JPanel toJPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 2));
		panel.setLayout(new BorderLayout());

		panel.add(getScrollTable(), BorderLayout.CENTER);

		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);

		toolbar.add(new GaneshButton(null, "REFRESH", Icons.ARROW_REFRESH).setTooltip(GM.atualizar()).render());
		toolbar.add(new GaneshButton(null, "REPORT_XLS", Icons.PAGE_EXCEL).setTooltip(GM.exportarComo_(GM.excel())).render());
		toolbar.add(new GaneshButton(null, "REPORT_PDF", Icons.PAGE_WHITE_ACROBAT).setTooltip(GM.exportarComo_(GM.pdf())).render());

		panel.add(toolbar, BorderLayout.SOUTH);

		return panel;
	}

	private JScrollPane getScrollTable() {
		RowNumberTable rowTable = new RowNumberTable(getTable());

		JScrollPane scroll = new JScrollPane(getTable());
		scroll.setRowHeaderView(rowTable);
		scroll.setCorner(JScrollPane.UPPER_LEFT_CORNER, rowTable.getTableHeader());

		return scroll;
	}

	protected JTable getTable() {
		if (table == null) {

			String[] mycols = new String[columns.size()];
			for (int i = 0; i < columns.size(); i++)
				mycols[i] = columns.get(i).getTitle().toString();

			DefaultTableModel model = new DefaultTableModel(new Object[][] {}, mycols);

			table = new JTable() {

				private static final long serialVersionUID = 1L;

				{
					final TableCellRenderer renderer = getTableHeader().getDefaultRenderer();

					for (int i = 0; i < getColumnCount(); ++i)
						getColumnModel().getColumn(i).setPreferredWidth(
							renderer.getTableCellRendererComponent(this,
								getModel().getColumnName(i), false, false, 0, i)
								.getPreferredSize().width);
				}

				@Override
				public Component prepareRenderer(final TableCellRenderer renderer, final int row, final int column) {
					final Component prepareRenderer = super.prepareRenderer(renderer, row, column);

					if (column >= getColumnModel().getColumnCount())
						return prepareRenderer;

					final TableColumn tableColumn = getColumnModel().getColumn(column);
					tableColumn.setPreferredWidth(Math.max(prepareRenderer.getPreferredSize().width, tableColumn.getPreferredWidth()));

					return prepareRenderer;
				}
			};

			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			table.setAutoCreateRowSorter(true);
			table.setModel(model);
			table.doLayout();
		}

		return table;
	}

	@Override
	protected boolean isDetailEnabled() {
		return getTable().getSelectedRowCount() > 0;
	}

	protected static class Column {

		private String field;
		private String format;
		private GString title;
		private GString tooltip;
		private int width = 2;
		private boolean filter = true;
		private boolean order = true;
		private boolean key = false;
		private boolean description = false;
		private boolean autoFilter = true;
		private byte align = 8;

		/**
		 * Descreve uma coluna. <br>
		 * O padrão da largura é de dois
		 * 
		 * @param field Field do DObject correspondente
		 * @param title Título da coluna
		 */
		public Column(String field, GString title) {
			this(field, title, 2);
		}

		/**
		 * Descreve uma coluna informando sua largura
		 * 
		 * @param field Field do DObject correspondente
		 * @param title Título da coluna
		 * @param width largura desejada da coluna
		 */
		public Column(String field, GString title, int width) {
			this.field = field;
			this.title = title;
			this.width = width;
		}

		/**
		 * Referencia para "casar" com o field do object
		 */
		public String getField() {
			return field;
		}

		/**
		 * Alterar a referencia para "casar" com o field do DObject
		 */
		public Column setField(String field) {
			this.field = field;
			return this;
		}

		/**
		 * Título da coluna
		 */
		public GString getTitle() {
			return title;
		}

		/**
		 * Alterar o título da coluna
		 */
		public Column setTitle(GString title) {
			this.title = title;
			return this;
		}

		/**
		 * Tooltip com uma breve explicação sobre do que se trata os dados da coluna
		 */
		public GString getTooltip() {
			return tooltip;
		}

		public Column setTooltip(GString tooltip) {
			this.tooltip = tooltip;
			return this;
		}

		public int getWidth() {
			return width;
		}

		public Column setWidth(int width) {
			this.width = width;
			return this;
		}

		public boolean isFilter() {
			return filter;
		}

		public Column setFilter(boolean filter) {
			this.filter = filter;
			return this;
		}

		public boolean isOrder() {
			return order;
		}

		public Column setOrder(boolean order) {
			this.order = order;
			return this;
		}

		public String getFormat() {
			return format;
		}

		public Column setFormat(String format) {
			this.format = format;
			return this;
		}

		/**
		 * Usado somente construir lookups, é a chave de busca do lookup
		 */
		public boolean isKey() {
			return key;
		}

		public Column setKey(boolean key) {
			this.key = key;
			return this;
		}

		/**
		 * Usado construir lookups, é o campo descrição do lookup
		 */
		public boolean isDescription() {
			return description;
		}

		public Column setDescription(boolean description) {
			this.description = description;
			return this;
		}

		public boolean isAutoFilter() {
			return autoFilter;
		}

		public Column setAutoFilter(boolean autoFilter) {
			this.autoFilter = autoFilter;
			return this;
		}

		public byte getAlign() {
			return align;
		}

		public Column setAlign(byte align) {
			this.align = align;
			return this;
		}

	}

}

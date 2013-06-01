/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.pages;

import ganesh.common.i18n.GString;
import ganesh.swing.programs.GaneshData;
import ganesh.swing.ui.controls.GaneshButton;
import ganesh.swing.ui.controls.GaneshButton.ButtonHandler;
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

import org.scharlessantos.hermes.Hermes;

public abstract class GaneshListPage extends GaneshPage {

	public static final String SELECTED_ROWS = "$SELECTED_ROWS";

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
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 2));

		panel.add(getScrollTable(), BorderLayout.CENTER);

		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);

		toolbar.add(new GaneshButton(null, "REFRESH", Icons.ARROW_REFRESH).setTooltip(GM.atualizar()).setPage(this).render());
		//		toolbar.add(new GaneshButton(null, "REPORT_XLS", Icons.PAGE_EXCEL).setTooltip(GM.exportarComo_(GM.excel())).setPage(this).render());
		//		toolbar.add(new GaneshButton(null, "REPORT_PDF", Icons.PAGE_WHITE_ACROBAT).setTooltip(GM.exportarComo_(GM.pdf())).setPage(this).render());

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
							Math.max(renderer.getTableCellRendererComponent(this, getModel().getColumnName(i), false, false, 0, i).getPreferredSize().width,
								Math.max(GaneshListPage.this.columns.get(i).getWidth(), 75)));

				}

				@Override
				public Component prepareRenderer(final TableCellRenderer renderer, final int row, final int column) {
					final Component prepareRenderer = super.prepareRenderer(renderer, row, column);

					if (column >= getColumnModel().getColumnCount())
						return prepareRenderer;

					final TableColumn tableColumn = getColumnModel().getColumn(column);
					tableColumn.setPreferredWidth(Math.max(tableColumn.getPreferredWidth(), Math.max(GaneshListPage.this.columns.get(column).getWidth(), 75)));

					return prepareRenderer;
				}
			};

			table.setDefaultEditor(Object.class, null);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setAutoCreateRowSorter(true);

			table.setModel(model);

			realLoadTableData(table);
		}

		return table;
	}

	@Override
	public GaneshData getData() {
		JTable table = getTable();

		if (data == null)
			data = new GaneshData();

		if (table.getSelectedRowCount() == 1) {
			data = mydata.get(table.getSelectedRow());
		} else if (table.getSelectedRowCount() > 1) {
			List<GaneshData> list = new ArrayList<>();

			for (int r: table.getSelectedRows())
				list.add(mydata.get(r));

			data.setGaneshDataList(SELECTED_ROWS, list);
		}

		return data;
	}

	private List<GaneshData> mydata = new ArrayList<>();

	protected final void realLoadTableData(JTable table) {
		List<GaneshData> data = loadTableData();

		DefaultTableModel model = (DefaultTableModel)table.getModel();

		List<String> ordem = new ArrayList<>();

		for (Column col: columns)
			ordem.add(col.getField());

		int t = model.getRowCount();
		for (int i = 0; i < t; i++)
			model.removeRow(0);

		mydata.clear();

		if (data != null)
			for (GaneshData d: data) {
				List<Object> row = new ArrayList<>();

				for (String field: ordem)
					row.add(d.get(field));

				mydata.add(d);

				model.addRow(row.toArray());
			}

		super.data = null;
		table.doLayout();
	}

	protected List<GaneshData> loadTableData() {
		Hermes.info("loadTableData nao implementado em " + getClass().getName());
		return new ArrayList<>();
	}

	@ButtonHandler("REFRESH")
	public void reloadData() {
		realLoadTableData(getTable());
	}

	protected static class Column {

		private String field;
		private String format;
		private GString title;
		private GString tooltip;
		private int width = 75;
		private boolean filter = true;
		private boolean order = true;
		private byte align = 8;

		/**
		 * Descreve uma coluna. <br>
		 * O padrão da largura é de dois
		 * 
		 * @param field Field do DObject correspondente
		 * @param title Título da coluna
		 */
		public Column(String field, GString title) {
			this(field, title, 75);
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

		public byte getAlign() {
			return align;
		}

		public Column setAlign(byte align) {
			this.align = align;
			return this;
		}

	}

}

/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui.main;

import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GString;
import ganesh.common.response.Message.ErrorMessage;
import ganesh.swing.GaneshSwing;
import ganesh.swing.ProgramManager;
import ganesh.swing.ProgramManager.Menu;
import ganesh.swing.ProgramManager.ProgramDescriptor;
import ganesh.swing.Starter;
import ganesh.swing.ui.GaneshFrame;
import ganesh.swing.ui.GaneshProgram;
import ganesh.swing.ui.MessageHandler;
import ganesh.swing.ui.images.Images;
import ganesh.swing.ui.images.Images.Flags;
import ganesh.swing.ui.images.Images.Icons;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

import org.scharlessantos.hermes.Hermes;

public class GaneshMainFrame extends GaneshFrame {

	private static final long serialVersionUID = 6320218631272101962L;

	private JTabbedPane tabPane;

	private JPanel main;
	private JScrollPane menu;
	private JToolBar rodape;

	public GaneshMainFrame() {
		super();
		setSize(640, 480);
		setMinimumSize(new Dimension(640, 320));

		// Adding Panels
		add(getMainPanel());

		setLocationRelativeTo(null);

		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle(M.ganeshClient());

	}

	private JPanel getMainPanel() {
		if (main == null) {
			main = new JPanel();
			main.setLayout(new BorderLayout());

			main.add(getMenuPanel(), BorderLayout.WEST);
			main.add(getProgramsPane(), BorderLayout.CENTER);
			main.add(getBottomToolbar(), BorderLayout.SOUTH);
		}

		return main;
	}

	private JTabbedPane getProgramsPane() {
		if (tabPane == null) {
			tabPane = new JTabbedPane();
			tabPane.setFocusable(false);

			tabPane.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {

					if (tabPane.getSelectedComponent() != null) {
						if (e.getButton() == MouseEvent.BUTTON2 || e.getButton() == MouseEvent.BUTTON3)
							if (JOptionPane.showConfirmDialog(null, M.desejaRealmenteFecharEstePrograma(), M.fechandoPrograma(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								int selected = getProgramsPane().getSelectedIndex();

								if (selected > 0)
									getProgramsPane().setSelectedIndex(selected - 1);

								getProgramsPane().removeTabAt(selected);
							}
					}

				}

			});

		}

		return tabPane;
	}

	private JScrollPane getMenuPanel() {
		if (menu == null) {
			menu = new JScrollPane();
			Node root = new Node("root", GM.ganeshClient(), null);

			Map<Menu, Node> nodes = new LinkedHashMap<>();

			{
				List<Menu> contextos = new ArrayList<>(Arrays.asList(Menu.values()));
				Collections.sort(contextos);

				for (Menu m: contextos)
					nodes.put(m, new Node(m.name(), m.getTitle(), m.getIcon()));

			}

			for (ProgramDescriptor prg: ProgramManager.listPrograms()) {
				Node node = nodes.get(prg.getMenu());

				if (node != null)
					node.add(new Node("program::" + prg.getName(), prg.getTitle(), prg.getIcon()));

			}

			for (Node node: nodes.values()) {
				if (!node.isLeaf())
					root.add(node);
			}

			root.add(new Node("logout", GM.logout(), Icons.DOOR_OUT));
			root.add(new Node("sair", GM.sair(), Icons.DECLINE));

			final JTree tree = new JTree(root);

			tree.setCellRenderer(new TreeRenderer());

			tree.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						TreePath path = tree.getSelectionPath();

						if (path != null) {
							Object obj = path.getLastPathComponent();

							if (obj instanceof Node) {
								Node no = (Node)obj;

								String id = no.getId();

								if (id.equals("sair"))
									GaneshMainFrame.this.processWindowEvent(new WindowEvent(GaneshMainFrame.this, WindowEvent.WINDOW_CLOSING));
								else if (id.equals("logout"))
									GaneshMainFrame.this.processWindowEvent(new WindowEvent(GaneshMainFrame.this, 0));
								else if (id.startsWith("program::")) {
									openProgram(id.substring("program::".length()));
								}

							}
						}

					}

				}

			});

			for (int i = 0; i < tree.getRowCount(); i++) {
				tree.expandRow(i);
			}

			menu.setViewportView(tree);

		}
		return menu;
	}

	private JToolBar getBottomToolbar() {
		if (rodape == null) {
			rodape = new JToolBar();
			rodape.setFloatable(false);
			rodape.add(new JLabel(Icons.get(Icons.USER)));
			rodape.add(new JLabel(M.usuario() + ": (" + GaneshSwing.getSession().getProperty("username") + ") " + GaneshSwing.getSession().getProperty("pessoa.nome")));
			rodape.addSeparator();
			rodape.add(Box.createHorizontalGlue()); //Para que a barra se expanda
			rodape.addSeparator();
			rodape.add(new JLabel(GaneshSwing.getLanguage().getDescripton()));
			rodape.add(new JLabel(Flags.get(GaneshSwing.getLanguage().getAcronym().toLowerCase())));
			rodape.addSeparator();
			JLabel versao = new JLabel(M.versao("1.1"));
			versao.setToolTipText(M.versaoAtualDoClienteGaneshSwing());
			rodape.add(versao);
		}

		return rodape;
	}

	@Override
	protected void processWindowEvent(WindowEvent e) {
		switch (e.getID()) {
			case 0:
				if (JOptionPane.showConfirmDialog(null, M.desejaRealmenteEfetuarLogOut(), M.saindo() + "...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					Starter.login();
					this.dispose();
				}

				break;
			case WindowEvent.WINDOW_CLOSING:
				if (JOptionPane.showConfirmDialog(null, M.desejaRealmenteSair(), M.saindo() + "...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
					System.exit(0);
				break;
			default:
				super.processWindowEvent(e);
				break;
		}

	}

	private void openProgram(String name) {
		try {
			GaneshProgram program = ProgramManager.newProgram(name);

			JPanel panel = program.render();

			if (panel != null) {
				JTabbedPane tabs = getProgramsPane();
				tabs.addTab(ProgramManager.getTitle(name).toString(), Icons.get(ProgramManager.getIcon(name)), panel, M.cliqueComOBotaoDireitoParaFechar());
				tabs.setSelectedIndex(tabs.getTabCount() - 1);

				panel.doLayout();
			}

		} catch (GException e) {
			Hermes.error(e);

			MessageHandler.show(new ErrorMessage(e.getCode().toString() + " " + M.naoFoiPossivelAbrirOPrograma()));
		}

	}

	@Override
	public void onLanguageChanged() {
		Hermes.warn("Troca de linguagem somente no login");
		JOptionPane.showMessageDialog(null, M.naoEhPossivelAlterarOIdiomaAposALogin());
	}

	private static class Node extends DefaultMutableTreeNode {

		private static final long serialVersionUID = -326029124598923552L;
		private String id;
		private String icon;

		public Node(String id, GString nome, String icon) {
			super(nome);

			this.id = id;
			this.icon = icon;
		}

		public String getId() {
			return id;
		}

		public String getIcon() {
			return icon;
		}

	}

	private static class TreeRenderer extends DefaultTreeCellRenderer {

		private static final long serialVersionUID = -3168064998184708624L;

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasfocus) {
			super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasfocus);

			if (row == 0) {
				setIcon(Images.get(Images.GANESH2));

			} else if (value instanceof Node) {
				Node n = (Node)value;
				ImageIcon icon = Images.Icons.get(n.getIcon());

				if (icon != null)
					setIcon(icon);
			}

			return this;
		}
	}

}

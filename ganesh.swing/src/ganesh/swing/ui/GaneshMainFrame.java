/* Ganesh Swing Client, developed in 2013 */
package ganesh.swing.ui;

import ganesh.swing.GaneshSwing;
import ganesh.swing.i18n.Messages;
import ganesh.swing.ui.images.Images;
import ganesh.swing.ui.images.Images.Icons;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				//if (GaneshMainFrame.this.close) {
				if (JOptionPane.showConfirmDialog(null, M.desejaRealmenteSair(), M.saindo() + "...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
					System.exit(0);
				//					else {
				//						txtUsuario.requestFocus();
				//					}
				//				} else {
				//					new GaneshMain().start();
				//					GaneshMainFrame.this.setVisible(false);
				//				}
			}

		});
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
							if (JOptionPane.showConfirmDialog(null, "Do you really close this tab?", "Closing tab", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
								getMainPanel().getActionForKeyStroke(getMainPanel().getRegisteredKeyStrokes()[2]).actionPerformed(new ActionEvent(this, 0, ""));

					}

				}

			});

		}

		return tabPane;
	}

	private JScrollPane getMenuPanel() {
		if (menu == null) {
			menu = new JScrollPane();
			Node root = new Node("root", M.ganeshClient(), null);

			Node cadastro = new Node("cadastro", M.cadastro(), Icons.COG);
			cadastro.add(new Node("grupo", M.grupo(), Icons.GROUP));

			root.add(cadastro);
			root.add(new Node("logout", M.logout(), Icons.DOOR_OUT));
			root.add(new Node("sair", M.sair(), Icons.DECLINE));

			final JTree tree = new JTree(root);
			tree.setCellRenderer(new TreeRenderer());

			tree.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						TreePath path = tree.getSelectionPath();

						if (path != null) {
							Object obj = path.getLastPathComponent();

							if (obj instanceof Node) {
								Node no = (Node)obj;

								if (no.getId().equals("sair")) {
									GaneshMainFrame.this.processWindowEvent(new WindowEvent(GaneshMainFrame.this, WindowEvent.WINDOW_CLOSING));
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
			rodape.addSeparator();
			rodape.add(new JLabel("Usuário root logado desde sempre!!"));
			rodape.addSeparator();
			rodape.add(Box.createHorizontalGlue());
			//toolBar.add(new JLabel("Ctrl + T to create and Ctrl + W to close tabs"));
			rodape.addSeparator();
			JLabel versao = new JLabel(M.versao("1.0"));
			versao.setToolTipText(M.versaoAtualDoClienteGaneshSwing());
			rodape.add(versao);
		}

		return rodape;
	}

	@Override
	public void onLanguageChanged() {
		Hermes.warn("Troca de linguagem somente no login");
	}

	private static class Node extends DefaultMutableTreeNode {

		private static final long serialVersionUID = -326029124598923552L;
		private String id;
		private String icon;

		public Node(String id, String nome, String icon) {
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

		protected static final Messages M = GaneshSwing.getMessages();

		private static final long serialVersionUID = -3168064998184708624L;

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasfocus) {
			super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasfocus);

			if (row == 0) {
				setIcon(Images.get("ganesh2.png"));
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

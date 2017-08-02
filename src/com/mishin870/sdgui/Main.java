package com.mishin870.sdgui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.mishin870.sdgui.data.Chapters;
import com.mishin870.sdgui.data.Chapters.Chapter;
import javax.swing.SwingConstants;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 821673176397745808L;
	private JPanel mainPane;
	private JTextField nameTf;
	private JTextField imgTf;
	private DefaultListModel<String> chaptersModel = new DefaultListModel<String>();
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Main() {
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setTitle("SDGUI");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 455);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
		tabs.setBorder(null);
		mainPane.add(tabs);
		
		JPanel chaptersPanel = new JPanel();
		tabs.addTab("\u0420\u0430\u0437\u0434\u0435\u043B\u044B", new ImageIcon(getClass().getResource("/chapters.png")), chaptersPanel, "\u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435 \u043A\u0430\u0441\u0442\u043E\u043C\u043D\u044B\u0445 \u0440\u0430\u0437\u0434\u0435\u043B\u043E\u0432 \u0430\u0434\u043C\u0438\u043D-\u043F\u0430\u043D\u0435\u043B\u0438");
		chaptersPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JList chaptersList = new JList();
		chaptersList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent paramListSelectionEvent) {
				int i = chaptersList.getSelectedIndex();
				if (i != -1) {
					Chapter chapter = Chapters.get(i);
					nameTf.setText(chapter.name);
					imgTf.setText(chapter.img);
				}
			}
		});
		chaptersList.setModel(chaptersModel);
		chaptersPanel.add(chaptersList);
		
		JPanel chapterProps = new JPanel();
		chaptersPanel.add(chapterProps);
		chapterProps.setBorder(new TitledBorder(null, "\u041F\u0430\u0440\u0430\u043C\u0435\u0442\u0440\u044B", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		chapterProps.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel nameLabel = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435");
		chapterProps.add(nameLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		chapterProps.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{135, 0};
		gbl_panel.rowHeights = new int[]{20, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		nameTf = new JTextField();
		nameTf.setToolTipText("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435 \u0440\u0430\u0437\u0434\u0435\u043B\u0430");
		GridBagConstraints gbc_nameTf = new GridBagConstraints();
		gbc_nameTf.fill = GridBagConstraints.BOTH;
		gbc_nameTf.gridx = 0;
		gbc_nameTf.gridy = 0;
		panel.add(nameTf, gbc_nameTf);
		nameTf.setColumns(10);
		
		JLabel imgLabel = new JLabel("\u041A\u0430\u0440\u0442\u0438\u043D\u043A\u0430");
		chapterProps.add(imgLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		chapterProps.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{135, 0};
		gbl_panel_1.rowHeights = new int[]{20, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		imgTf = new JTextField();
		imgTf.setToolTipText("\u041A\u0430\u0440\u0442\u0438\u043D\u043A\u0430 \u0440\u0430\u0437\u0434\u0435\u043B\u0430 (\u0432 \u043F\u0430\u043F\u043A\u0435 /simpla/design/images/). \u041F\u0440\u0438\u043C\u0435\u0440: \"test.png\"");
		GridBagConstraints gbc_imgTf = new GridBagConstraints();
		gbc_imgTf.fill = GridBagConstraints.BOTH;
		gbc_imgTf.gridx = 0;
		gbc_imgTf.gridy = 0;
		panel_1.add(imgTf, gbc_imgTf);
		imgTf.setColumns(10);
		
		JButton chapterAddBtn = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		chapterAddBtn.setToolTipText("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043D\u043E\u0432\u044B\u0439 \u0440\u0430\u0437\u0434\u0435\u043B");
		chapterAddBtn.setIcon(new ImageIcon(getClass().getResource("/add.png")));
		chapterAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				String name = nameTf.getText();
				String img = imgTf.getText();
				chaptersModel.addElement(name);
				Chapters.addChapter(name, img);
			}
		});
		chapterProps.add(chapterAddBtn);
		
		JButton chapterSaveBtn = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C");
		chapterSaveBtn.setToolTipText("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C \u0432\u044B\u0431\u0440\u0430\u043D\u043D\u044B\u0439 \u0440\u0430\u0437\u0434\u0435\u043B");
		chapterSaveBtn.setIcon(new ImageIcon(getClass().getResource("/save.png")));
		chapterSaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				int i = chaptersList.getSelectedIndex();
				if (i != -1) {
					String name = nameTf.getText();
					String img = imgTf.getText();
					Chapters.update(i, name, img);
					chaptersModel.set(i, name);
				}
			}
		});
		chapterProps.add(chapterSaveBtn);
		
		JPanel danger = new JPanel();
		danger.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u041E\u043F\u0430\u0441\u043D\u0430\u044F \u0437\u043E\u043D\u0430", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(75, 75, 75)));
		chapterProps.add(danger);
		
		JButton chapterDelBtn = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		chapterDelBtn.setToolTipText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C \u0432\u044B\u0431\u0440\u0430\u043D\u043D\u044B\u0439 \u0440\u0430\u0437\u0434\u0435\u043B");
		chapterDelBtn.setIcon(new ImageIcon(getClass().getResource("/delete.png")));
		chapterDelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				int i = chaptersList.getSelectedIndex();
				if (i != -1) {
					chaptersModel.remove(i);
					Chapters.remove(i);
					if (i >= 1) chaptersList.setSelectedIndex(i - 1);
				}
			}
		});
		danger.add(chapterDelBtn);
		
		JPanel tabsPanel = new JPanel();
		tabs.addTab("\u0412\u043A\u043B\u0430\u0434\u043A\u0438", new ImageIcon(getClass().getResource("/tabs.png")), tabsPanel, "\u0412\u043A\u043B\u0430\u0434\u043A\u0438 \u0440\u0430\u0437\u0434\u0435\u043B\u043E\u0432 \u0430\u0434\u043C\u0438\u043D-\u043F\u0430\u043D\u0435\u043B\u0438");
		tabsPanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JList tabsList = new JList();
		tabsPanel.add(tabsList);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u041F\u0430\u0440\u0430\u043C\u0435\u0442\u0440\u044B", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabsPanel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel tabNameLabel = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435");
		panel_2.add(tabNameLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{135, 0};
		gbl_panel_3.rowHeights = new int[]{20, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		textField = new JTextField();
		textField.setToolTipText("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435 \u0440\u0430\u0437\u0434\u0435\u043B\u0430");
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel_3.add(textField, gbc_textField);
		
		JLabel tabInternalNameLabel = new JLabel("\u0421\u0438\u043C\u0432. \u0438\u043C\u044F");
		panel_2.add(tabInternalNameLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{135, 0};
		gbl_panel_4.rowHeights = new int[]{20, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("\u041A\u0430\u0440\u0442\u0438\u043D\u043A\u0430 \u0440\u0430\u0437\u0434\u0435\u043B\u0430 (\u0432 \u043F\u0430\u043F\u043A\u0435 /simpla/design/images/). \u041F\u0440\u0438\u043C\u0435\u0440: \"test.png\"");
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 0;
		panel_4.add(textField_1, gbc_textField_1);
		
		JButton button = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		button.setToolTipText("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043D\u043E\u0432\u044B\u0439 \u0440\u0430\u0437\u0434\u0435\u043B");
		panel_2.add(button);
		
		JButton button_1 = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C");
		button_1.setToolTipText("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C \u0432\u044B\u0431\u0440\u0430\u043D\u043D\u044B\u0439 \u0440\u0430\u0437\u0434\u0435\u043B");
		panel_2.add(button_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u041E\u043F\u0430\u0441\u043D\u0430\u044F \u0437\u043E\u043D\u0430", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(75, 75, 75)));
		panel_2.add(panel_5);
		
		JButton button_2 = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		button_2.setToolTipText("\u0423\u0434\u0430\u043B\u0438\u0442\u044C \u0432\u044B\u0431\u0440\u0430\u043D\u043D\u044B\u0439 \u0440\u0430\u0437\u0434\u0435\u043B");
		panel_5.add(button_2);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

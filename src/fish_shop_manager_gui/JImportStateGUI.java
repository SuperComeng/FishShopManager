package fish_shop_manager_gui;
/*
 * �ۼ���: SuperComeng
 * �ο�� �������� ���� ��Ȳ
 */

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JImportStateGUI extends JPanel {
	private	JLabel		m_lbCategory;
	private	JComboBox	m_cbCategory;
	
	private	JLabel		m_lbType;
	private	JTextField	m_tfType;
	
	private	JLabel		m_lbImportPrice;
	private	JTextField	m_tfImportPrice;
		
	private	JLabel		m_lbExportPrice;
	private	JTextField	m_tfExportPrice;
		
	private	JLabel		m_lbImportAmount;
	private	JTextField	m_tfImportAmount;
	
	public JImportStateGUI(String[] strCategories) {
		CreateGUI(strCategories);
	}
	
	public JImportStateGUI() {
		
	}
	
	public void CreateGUI(String[] strCategories) {
		///< create GUI
		m_lbCategory = new JLabel("ǰ��� :");
		m_cbCategory = new JComboBox(strCategories);

		m_lbType = new JLabel("����: ");
		m_tfType = new JTextField();

		m_lbImportPrice = new JLabel("�԰�: ");
		m_tfImportPrice = new JTextField();

		m_lbExportPrice = new JLabel("�ǸŰ�: ");
		m_tfExportPrice = new JTextField();

		m_lbImportAmount = new JLabel("�԰�: ");
		m_tfImportAmount = new JTextField();

		setLayout(new GridLayout(5, 2));
		add(m_lbCategory);
		add(m_cbCategory);
		add(m_lbType);
		add(m_tfType);
		add(m_lbImportPrice);
		add(m_tfImportPrice);
		add(m_lbExportPrice);
		add(m_tfExportPrice);
		add(m_lbImportAmount);
		add(m_tfImportAmount);
	}
}

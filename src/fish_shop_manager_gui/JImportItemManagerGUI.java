package fish_shop_manager_gui;
import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JImportItemManagerGUI extends JPanel {
	private	JLabel		m_lbImportShopName;
	private	JComboBox	m_cbImportShopName;
	
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
		
	public JImportItemManagerGUI(String[] strCategories) {
		///< create GUI
		m_lbImportShopName = new JLabel("����ó: ");
		m_cbImportShopName = new JComboBox();
		
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
		
		setLayout(new GridLayout(6, 2));
		add(m_lbImportShopName);
		add(m_cbImportShopName);
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
	
	public String GetCategory() {
		return m_cbCategory.getSelectedItem().toString();
	}
	
	public String GetType() {
		return m_tfType.getText();
	}
	
	public double GetImportPrice() {
		return Double.parseDouble(m_tfImportPrice.getText());
	}
	
	public double GetExportPrice() {
		return Double.parseDouble(m_tfExportPrice.getText());
	}
	
	public int GetImportAmount() {
		return Integer.parseInt(m_tfImportAmount.getText());
	}
	
	@ Override
	public String toString() {
		return "ǰ���: " + GetCategory() + 
				"\n����: " + GetType() + 
				"\n�԰�: " + GetImportPrice() + 
				"\n�ǸŰ�: " + GetExportPrice() +
				"\n�԰�: " + GetImportAmount() +
				"\n�� ����ݾ�: " + GetImportPrice() * GetImportAmount();
	}
}

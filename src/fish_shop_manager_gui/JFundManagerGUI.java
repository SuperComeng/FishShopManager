package fish_shop_manager_gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JFundManagerGUI extends JPanel {
	private	JLabel		m_lbExpenditure;
	private	JComboBox	m_cbExpenditure;
	private	JLabel		m_lbExpenditureDetail;
	private	JTextField	m_tfExpenditureDetail;
	private	JLabel		m_lbExpenditureAmount;
	private	JTextField	m_tfExpenditureAmount;
	
	private	DefaultTableModel	m_tmExpenditureList;
	private	JTable	m_tbExpenditureList;
	public JFundManagerGUI() {
		CreateGUI();
		AdjustGUI();
		AddEventHandler();
	}
	
	public void CreateGUI() {
		m_lbExpenditure = new JLabel("사용내역: ");
		m_cbExpenditure = new JComboBox(new String[] {"경상비"});
		
		m_lbExpenditureDetail = new JLabel("상세 사용내역: ");
		m_tfExpenditureDetail = new JTextField("");
		
		m_lbExpenditureAmount = new JLabel("사용금액: ");
		m_tfExpenditureAmount = new JTextField("0");
		
		String str[] = new String[]{"사용내역", "상세내역", "사용금액"};
		m_tmExpenditureList = new DefaultTableModel(str, 0);
		m_tbExpenditureList = new JTable(m_tmExpenditureList);
	}
	
	public void AdjustGUI() {
		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(3, 2));
		pn.add(m_lbExpenditure);
		pn.add(m_cbExpenditure);
		pn.add(m_lbExpenditureDetail);
		pn.add(m_tfExpenditureDetail);
		pn.add(m_lbExpenditureAmount);
		pn.add(m_tfExpenditureAmount);
		
		JScrollPane sPane = new JScrollPane(m_tbExpenditureList);
		
		setLayout(new BorderLayout());
		add(pn, BorderLayout.NORTH);
		add(sPane, BorderLayout.CENTER);
	}
	
	public void AddEventHandler() {
		
	}
}

package fish_shop_manager_gui;
import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fish_shop.utils.JItem;

public class JItemManagerGUI extends JPanel implements ActionListener {
	private	ArrayList<JItem>	m_alItemList;
	
	private	JLabel		m_lbCategory;
	private	JComboBox	m_cbCategory;
	
	private	DefaultTableModel	m_tmItemList;
	private	JTable				m_tbItemList;
	
	private	JButton	m_btnSale;
	private	JButton	m_btnRegister;
	private	JButton	m_btnList;
	
	private	JFrame m_fParent;
	public JItemManagerGUI(JFrame fParent) {
		m_fParent = fParent;
		CreateGUI();
		
		AdjustGUI();
		
		AddEventHandler();
	}
	
	public void CreateGUI() {
		JShopManagerMainFrame f = (JShopManagerMainFrame)m_fParent;
		Vector<String[]> vAvailableItems = f.GetAvailableItemList();
		Vector<String> vItemCategories = new Vector<String>();
		for (int i = 0; i < vAvailableItems.size(); i++)
			vItemCategories.add(vAvailableItems.get(i)[0]);
		
		m_lbCategory = new JLabel("상품명");
		m_cbCategory = new JComboBox(vItemCategories);
		
		String[] str2 = {"매입처", "품목코드", "상품명", "종류", "입고가", "판매가", "할인율", "재고량"};
		Object[] str3 = {""};
		m_tmItemList = new DefaultTableModel(str2, 0);
		m_tbItemList = new JTable(m_tmItemList);
		
		m_btnSale = new JButton("상품판매");
		m_btnRegister = new JButton("상품매입");
		m_btnList = new JButton("전체보기");
	}
	
	public void AdjustGUI() {
		JPanel pnCategory = new JPanel();
		pnCategory.setLayout(new GridLayout(1, 2));
		pnCategory.add(m_lbCategory);
		pnCategory.add(m_cbCategory);
		
		JScrollPane sPane = new JScrollPane(m_tbItemList);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new GridLayout(1, 3));
		pnButton.add(m_btnSale);
		pnButton.add(m_btnRegister);
		pnButton.add(m_btnList);
		
		setLayout(new BorderLayout());
		
		add(pnCategory, BorderLayout.NORTH);
		add(sPane, BorderLayout.CENTER);
		add(pnButton, BorderLayout.SOUTH);
	}
	
	public void AddEventHandler() {
		m_btnRegister.addActionListener(this);
		m_cbCategory.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(m_btnRegister)) {
			ImportItem();
		} else if (e.getSource().equals(m_cbCategory)) {
			String strSelectedCategory = m_cbCategory.getSelectedItem().toString();
			ArrayList<Integer> alSelectedCategories = new ArrayList<Integer>();
			for (int i = 0; i < m_alItemList.size(); i++) {
				if (m_alItemList.get(i).IsEqualCategory(strSelectedCategory))
					alSelectedCategories.add(i);
			}
		}
	}
	
	public void ImportItem() {
		JImportItemManagerGUI panel = new JImportItemManagerGUI(new String[]{"aaa", "bbb", "ccc"}); 
		int result = JOptionPane.showConfirmDialog(null, panel, "Test",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate today = LocalDate.now();
			String strMsg = "상품명: " + panel.GetCategory() +
					"\n종류: " + panel.GetType() +
					"\n입고가: " + panel.GetImportPrice() +
					"\n판매가: " + panel.GetExportPrice() +
					"\n수량: " + panel.GetImportAmount() + 
					"\n입고일: " + today.toString();

			if (JOptionPane.showConfirmDialog(this, strMsg + "\n상품을 등록하시겠습니까?") == JOptionPane.OK_OPTION) {
				JShopManagerMainFrame f = (JShopManagerMainFrame)m_fParent; 
				f.AddImport(new JItem(panel.GetCategory(),
						panel.GetType(),
						panel.GetImportPrice(),
						panel.GetExportPrice(),
						panel.GetImportAmount(),
						Date.from(today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())));
			}
		} else {
			System.out.println("Cancelled");
		}
	}
}

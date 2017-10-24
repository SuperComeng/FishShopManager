package fish_shop_manager_gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import fish_shop.utils.JCustomer;

public class JCustomerManagerGUI extends JPanel implements ActionListener, MouseListener, KeyListener {
	private	JLabel		m_lbCustomerName;
	private	JTextField	m_tfCustomerName;
	
	private	JButton	m_btnRegister;
	private	JButton	m_btnTransactionList;
	private	int		m_nSelectedCustomerIdx;
	
	private	DefaultTableModel	m_tmCustomerList;
	private	JTable	m_tbCustomerList;
	
	private	JFrame m_fParent;
	private	ArrayList<JCustomer>	m_alCustomerList;
	public JCustomerManagerGUI(JFrame fParent) {
		m_fParent = fParent;
				
		CreateGUI();
		AdjustGUI();
		AddEventHandlerOnGUI();
		
		UpdateCustomerList();
		
		InitializeSelectedCustomerIdx();
	}
	
	public void InitializeSelectedCustomerIdx() {
		m_nSelectedCustomerIdx = -1;
	}
	
	public void CreateGUI() {
		m_lbCustomerName = new JLabel("상호명: ");
		m_tfCustomerName = new JTextField();
		
		m_btnRegister = new JButton("고객등록");
		m_btnTransactionList = new JButton("거래내역조회");
		
		String[] strColumns = {"상호명", "사업자등록번호", "주소", "연락처", "미수금"};
		m_tmCustomerList = new DefaultTableModel(strColumns, 0);
		m_tbCustomerList = new JTable(m_tmCustomerList);
	}
	
	public void AdjustGUI() {
		JPanel	pnSearchCustomer = new JPanel();
		pnSearchCustomer.setBorder(BorderFactory.createTitledBorder("고객 검색"));
		pnSearchCustomer.setLayout(new GridLayout(1, 2));
		pnSearchCustomer.add(m_lbCustomerName);
		pnSearchCustomer.add(m_tfCustomerName);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1, 3));
		btnPanel.add(m_btnRegister);
		btnPanel.add(m_btnTransactionList);
		
		JScrollPane sPane = new JScrollPane(m_tbCustomerList);
		
		JPanel pnCustomerList = new JPanel();
		pnCustomerList.setBorder(BorderFactory.createTitledBorder("고객 명단"));
		pnCustomerList.setLayout(new BorderLayout());
		pnCustomerList.add(sPane, BorderLayout.CENTER);
		
		setLayout(new BorderLayout());
		add(pnSearchCustomer, BorderLayout.NORTH);
		add(btnPanel, BorderLayout.SOUTH);
		add(pnCustomerList, BorderLayout.CENTER);
	}
	
	public void AddEventHandlerOnGUI() {
		m_btnRegister.addActionListener(this);
		m_btnTransactionList.addActionListener(this);
		
		m_tfCustomerName.addKeyListener(this);
		m_tbCustomerList.addMouseListener(this);
		m_tbCustomerList.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(m_btnRegister)) {
			AddCustomer();
		} else if (e.getSource().equals(m_btnTransactionList))  {
			if (m_nSelectedCustomerIdx != -1) {
				;
			} else
				JOptionPane.showMessageDialog(this, "고객 리스트에서 조회하고자 하는 상호를 먼저 선택해야합니다.");
		}
	}
	
	public void AddCustomer() {
		JAddCustomerGUI panel = new JAddCustomerGUI(); 
		int result = JOptionPane.showConfirmDialog(null, panel, "Test",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate today = LocalDate.now();
			String strMsg = "상호명: " + panel.GetName() +
					"\n사업자등록번호: " + panel.GetSocialNumber() +
					"\n주소: " + panel.GetAddress() +
					"\n연락처: " + panel.GetPhoneNumber() +
					"\n미수금: " + 0;

			if (JOptionPane.showConfirmDialog(this, strMsg + "\n거래처를 등록하시겠습니까?") == JOptionPane.OK_OPTION) {
				JShopManagerMainFrame f = (JShopManagerMainFrame)m_fParent; 
				f.AddCustomer(new JCustomer(panel.GetName(),
											panel.GetSocialNumber(),
											panel.GetAddress(),
											panel.GetPhoneNumber(), 0));
				
				UpdateCustomerList();
			}
		} else {
			System.out.println("Cancelled");
		}
	}
	
	public void UpdateCustomerList() {
		JShopManagerMainFrame f = (JShopManagerMainFrame)m_fParent;
		
		m_alCustomerList = f.GetCustomerList();
		m_tmCustomerList.setRowCount(0);
		for (int i = 0; i < m_alCustomerList.size(); i++) {
			JCustomer customer=  m_alCustomerList.get(i);
			
			m_tmCustomerList.addRow(new String[]{customer.GetName(),
					customer.GetBLN(),
					customer.GetPhoneNumber(),
					customer.GetAddress(),
					Double.toString(customer.GetReceivable())}); 
		}
		
		m_tbCustomerList.setModel(m_tmCustomerList);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2 && e.getSource().equals(m_tbCustomerList))
			m_nSelectedCustomerIdx = m_tbCustomerList.getSelectedRow();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(m_tfCustomerName)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				int nRowCount = m_tbCustomerList.getRowCount();
				for (int i = 0; i < nRowCount; i++) {
					String strCustomerName = m_tbCustomerList.getValueAt(i, 0).toString();
					if (strCustomerName.equals(m_tfCustomerName.getText())) {
						System.out.println("there is a shop");
						return;
					}
				}
				
				System.out.println("there is no shop");
			}
		}
		else if (e.getSource().equals(m_tbCustomerList)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				String[] options = new String[] {"예", "아니오"};
				
				int nResult = JOptionPane.showOptionDialog(this, "aaa", "거래처 정보 수정", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (nResult == JOptionPane.OK_OPTION) {
					System.out.println(m_tbCustomerList.getModel().getValueAt(m_nSelectedCustomerIdx, 0).toString());
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

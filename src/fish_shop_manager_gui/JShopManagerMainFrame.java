package fish_shop_manager_gui;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fish_shop.utils.JCustomer;
import fish_shop.utils.JItem;

public class JShopManagerMainFrame extends JFrame implements ChangeListener {
	private	JTabbedPane	m_tpLayout;
	
	private	JFundManagerGUI			m_pnFundManagerGUI;			///< 재무관리
	private	JCustomerManagerGUI		m_pnCustomerManagerGUI;		///< 거래처관리
	private	JInventoryManagerGUI	m_pnInventoryManagerGUI;	///< 재고관리
	private	JItemManagerGUI			m_pnItemManagerGUI;			///< 상품관리
	private	JImportStateGUI			m_pnImportStateGUI;			///< 매입관리
	private	JExportStateGUI			m_pnExportStateGUI;			///< 매출관리
	
	private	ArrayList<JCustomer>	m_alCustomerList;
	private	ArrayList<JItem>	m_alImportList;	///< 매입현황
	private	ArrayList<JItem>	m_alExportList;	///< 매출현황
	private	ArrayList<JItem>	m_alInvetory;	///< 재고현황: 매입 - 매출
	
	private	Vector<String[]>	m_vAvailableItems;	///< 판매 가능한 상품 내역
	
	public JShopManagerMainFrame() {
		ReadCustomerList();
		ReadAvailableItemList();
		
		m_tpLayout = new JTabbedPane();
		m_pnFundManagerGUI = new JFundManagerGUI();
		m_pnCustomerManagerGUI = new JCustomerManagerGUI(this);
		m_pnInventoryManagerGUI	= new JInventoryManagerGUI();
		m_pnItemManagerGUI = new JItemManagerGUI(this);
		m_pnImportStateGUI = new JImportStateGUI();
		m_pnExportStateGUI = new JExportStateGUI();
		
		m_tpLayout.add("고객관리", m_pnCustomerManagerGUI);
		m_tpLayout.add("상품관리",  m_pnItemManagerGUI);
		m_tpLayout.add("재무관리", m_pnFundManagerGUI);
		m_tpLayout.add("재고관리",  m_pnInventoryManagerGUI);
		m_tpLayout.add("매입현황",  m_pnImportStateGUI);
		m_tpLayout.add("매출현황",  m_pnExportStateGUI);
		add(m_tpLayout);
		setTitle("민우네 생선가게");
		
		///< add event handler to tabbedpane
		m_tpLayout.addChangeListener(this);
		
		ReadInvetory();
	}
	
	public void ReadCustomerList() {
		m_alCustomerList = new ArrayList<JCustomer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("CustomerList.txt"));
			String str;
			
			while ((str = br.readLine()) != null) {
				String[] strCustomer = str.split(" ");
				JCustomer customer = new JCustomer(strCustomer[0],
												   strCustomer[1],
												   strCustomer[2],
												   strCustomer[3],
												   Double.parseDouble(strCustomer[4]));
				System.out.println(customer);
				m_alCustomerList.add(customer);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public void ReadAvailableItemList() {
		m_vAvailableItems = new Vector<String[]>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("AvailableItemList.txt"));
			String str;
			
			for (int i = 0; (str = br.readLine()) != null; i++) {
				String[] strAvailableItem = str.split(" ");
				m_vAvailableItems.add(strAvailableItem);
			}
			
			br.close();
		} catch (IOException e) {
			System.err.println(e);
		}
		
	}
	
	public Vector<String[]> GetAvailableItemList() {
		return m_vAvailableItems;
	}
	
	public void finalize() {
		
	}
	
	public void ReadInvetory() {
		m_alImportList = new ArrayList<JItem>();
		///< read item list from yesterday
		///< get today date
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate today = LocalDate.now();
		System.out.println(dtf.format(today));
		
		System.out.println(today.getDayOfYear() + " " + today.getDayOfMonth());
	}
	
	public void AddImport(JItem item) {
		m_alImportList.add(item);
	}
	
	public void AddCustomer(JCustomer customer) {
		m_alCustomerList.add(customer);
	}
	
	public ArrayList<JCustomer> GetCustomerList() {
		return m_alCustomerList;
	}
	
	public void AddExport(JCustomer customer, JItem item) {
		
	}
	
	public void CalculateInventory() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JShopManagerMainFrame frame = new JShopManagerMainFrame();
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int nSelectedPaneIdx = m_tpLayout.getSelectedIndex();
		switch (nSelectedPaneIdx) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		}
	}

}

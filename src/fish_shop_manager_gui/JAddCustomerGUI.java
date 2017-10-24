package fish_shop_manager_gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JAddCustomerGUI extends JPanel {
	private	JLabel		m_lbName;			///< 거래처 이름
	private	JTextField	m_tfName;
	private	JLabel		m_lbSocialNumber;	///< 사업자등록번호
	private	JTextField	m_tfSocialNumber;
	private	JLabel		m_lbAddress;		///< 주소
	private	JTextField	m_tfAddress;
	private	JLabel		m_lbPhoneNumber;	///< 대표전화번호
	private	JTextField	m_tfPhoneNumber;
	
	public JAddCustomerGUI() {
		m_lbName = new JLabel("상호: ");
		m_tfName = new JTextField();
		
		m_lbSocialNumber = new JLabel("사업자등록번호: ");
		m_tfSocialNumber = new JTextField();
		
		m_lbAddress = new JLabel("주소: ");
		m_tfAddress = new JTextField();
		
		m_lbPhoneNumber = new JLabel("연락처: ");
		m_tfPhoneNumber = new JTextField();
		
		setLayout(new GridLayout(4, 2));
		add(m_lbName);
		add(m_tfName);
		add(m_lbSocialNumber);
		add(m_tfSocialNumber);
		add(m_lbAddress);
		add(m_tfAddress);
		add(m_lbPhoneNumber);
		add(m_tfPhoneNumber);
	}
	
	public String GetName() {
		return m_tfName.getText();
	}
	
	public String GetSocialNumber() {
		return m_tfSocialNumber.getText();
	}
	
	public String GetAddress() {
		return m_tfAddress.getText();
	}
	
	public String GetPhoneNumber() {
		return m_tfPhoneNumber.getText();
	}
	
	public String toString() {
		return "상호명: " + GetName() +
				"\n사업자등록번호: " + GetSocialNumber() +
				"\n주소: " + GetAddress() +
				"\n연락처: " + GetPhoneNumber();
	}
}

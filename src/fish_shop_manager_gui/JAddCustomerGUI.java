package fish_shop_manager_gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JAddCustomerGUI extends JPanel {
	private	JLabel		m_lbName;			///< �ŷ�ó �̸�
	private	JTextField	m_tfName;
	private	JLabel		m_lbSocialNumber;	///< ����ڵ�Ϲ�ȣ
	private	JTextField	m_tfSocialNumber;
	private	JLabel		m_lbAddress;		///< �ּ�
	private	JTextField	m_tfAddress;
	private	JLabel		m_lbPhoneNumber;	///< ��ǥ��ȭ��ȣ
	private	JTextField	m_tfPhoneNumber;
	
	public JAddCustomerGUI() {
		m_lbName = new JLabel("��ȣ: ");
		m_tfName = new JTextField();
		
		m_lbSocialNumber = new JLabel("����ڵ�Ϲ�ȣ: ");
		m_tfSocialNumber = new JTextField();
		
		m_lbAddress = new JLabel("�ּ�: ");
		m_tfAddress = new JTextField();
		
		m_lbPhoneNumber = new JLabel("����ó: ");
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
		return "��ȣ��: " + GetName() +
				"\n����ڵ�Ϲ�ȣ: " + GetSocialNumber() +
				"\n�ּ�: " + GetAddress() +
				"\n����ó: " + GetPhoneNumber();
	}
}

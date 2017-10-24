package fish_shop.utils;

import java.util.ArrayList;

public class JCustomer {
	private	String	m_strName;			///< �ŷ�ó �̸�
	private	String	m_strBLN;			///< business license number: ����ڵ�Ϲ�ȣ
	private	String	m_strAddress;		///< �ּ�
	private	String	m_strPhoneNumber;	///< ��ǥ��ȭ��ȣ
	private	double	m_dbReceivable;		///< �̼���
	
	private	ArrayList<JItem>	m_alTransactions;
	public	JCustomer() {
		m_strName = "";
		m_strBLN = "";
		m_strAddress = "";
		m_strPhoneNumber = "";
		m_dbReceivable = 0;
		
		m_alTransactions = new ArrayList<JItem>();
	}
	
	public	JCustomer(String strName, 
			String strBLN,
			String strAddress,
			String strPhoneNumber,			
			double dbReceivable) {
		
		m_strName = strName;
		m_strBLN = strBLN;
		m_strAddress = strAddress;
		m_strPhoneNumber = strPhoneNumber;
		m_dbReceivable = dbReceivable;
		
		m_strPhoneNumber = m_strPhoneNumber.replace("-", "");
		
		m_alTransactions = new ArrayList<JItem>();
	}
	
	public void AddTransaction(JItem item) {
		m_alTransactions.add(item);
	}
	
	public void AddTransactions(ArrayList<JItem> alTransactions) {
//		for (int i = 0; i < alTransactions.size(); i++)
//			m_alTransactions.add(alTransactions.get(i));
		m_alTransactions.addAll(alTransactions);
	}

	public String GetName() {
		return m_strName;
	}
	
	public String GetBLN() {
		return m_strBLN;
	}

//	public void SetName(String strName) {
//		m_strName = strName;
//	}
	
//	public void SetPhoneNumber(String strPhoneNumber) {
//		m_strPhoneNumber = strPhoneNumber;
//		m_strPhoneNumber.replace("-", "");
//	}
	
	public String GetPhoneNumber() {
		return m_strPhoneNumber;
	}
	
	public void SetReceivable(double dbReceivable) {
		m_dbReceivable = dbReceivable;
	}
	
	public double GetReceivable() {
		return m_dbReceivable;
	}
	
	public String GetAddress() {
		return m_strAddress;
	}
	
	@Override
	public String toString() {
		String msg = "";
		msg += "��ȣ��: " + GetName() +
				"\n����ڵ�Ϲ�ȣ: " + GetBLN() +
				"\n�ּ�: " + GetAddress() +
				"\n��ȭ��ȣ: " + GetPhoneNumber() +
				"\n�̼���: " + GetReceivable();
		return msg;
	}
}

package fish_shop.utils;

import java.util.ArrayList;

public class JCustomer {
	private	String	m_strName;			///< 거래처 이름
	private	String	m_strBLN;			///< business license number: 사업자등록번호
	private	String	m_strAddress;		///< 주소
	private	String	m_strPhoneNumber;	///< 대표전화번호
	private	double	m_dbReceivable;		///< 미수금
	
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
		msg += "상호명: " + GetName() +
				"\n사업자등록번호: " + GetBLN() +
				"\n주소: " + GetAddress() +
				"\n전화번호: " + GetPhoneNumber() +
				"\n미수금: " + GetReceivable();
		return msg;
	}
}

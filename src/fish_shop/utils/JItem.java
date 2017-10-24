package fish_shop.utils;
import java.util.Date;

public class JItem {
	private String	m_strID;				///< ��ǰ�ڵ�
	private	String	m_strCategory;			///< ��ǰ��
	private	String	m_strType;				///< ����
	private	Date	m_dateImport;			///< ������
	private	double	m_dbImportPrice;		///< ���԰�
	private	double	m_dbExportPrice;		///< �ǸŰ�
	private	double	m_dbDiscountAmount;		///< ������
	private	int		m_nImportAmount;		///< ���Է�
	private	int		m_nRemainedAmount;		///< ���
	
	public JItem() {
		
	}
	
	public JItem(String strCategory, 
			     String strType, 
				 double dbImportPrice, 
				 double dbExportPrice, 
				 int nImportAmount,
				 Date today) {
		m_strCategory = strCategory;
		m_strType = strType;
		m_dateImport = today;
		m_dbImportPrice = dbImportPrice;
		m_dbExportPrice = dbExportPrice;
		m_nImportAmount = m_nRemainedAmount = nImportAmount;
	}
	
	public boolean IsEqualCategory(String strCategory) {
		return m_strCategory.equals(strCategory);
	}
}

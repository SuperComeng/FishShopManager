package fish_shop.utils;
import java.util.Date;

public class JItem {
	private String	m_strID;				///< 물품코드
	private	String	m_strCategory;			///< 상품명
	private	String	m_strType;				///< 종류
	private	Date	m_dateImport;			///< 매입일
	private	double	m_dbImportPrice;		///< 매입가
	private	double	m_dbExportPrice;		///< 판매가
	private	double	m_dbDiscountAmount;		///< 할인율
	private	int		m_nImportAmount;		///< 매입량
	private	int		m_nRemainedAmount;		///< 재고량
	
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

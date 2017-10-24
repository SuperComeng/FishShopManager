package fish_shop.utils;

import java.util.Date;

public class JImportedItem extends JItem {
	private	Date	m_dateImport;			///< 매입일
	private	String	m_strImportedShopName;	///< 매입처
	
	public JImportedItem() {
		
	}
	
	public JImportedItem(String strCategory, 
					     String strType, 
						 double dbImportPrice, 
						 double dbExportPrice, 
						 int nImportAmount,
						 Date today) {
		super(strCategory, strType, dbImportPrice, dbExportPrice, nImportAmount, today);		
	}
}

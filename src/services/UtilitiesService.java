package services;

import java.lang.reflect.Field;
import java.util.Vector;

public class UtilitiesService {
	
	public static final String Tbl_Sehir = "Tbl_Sehir";
	public static final String Tbl_Renk = "Tbl_Renk";
	public static final String Tbl_VitesTuru = "Tbl_VitesTuru";
	public static final String Tbl_YakitTuru = "Tbl_YakitTuru";
	public static final String Tbl_Ilan = "Tbl_Ilan";
	public static final String Tbl_Araba = "Tbl_Araba";
	public static final String IlanSearchSonuc = "IlanSearchSonuc";
	

	/*
	 * herhangi bir sinifin tanimli olan degiskenlerininin isimlerini liste halinde dondurur
	 * tabloda kolonlari belirlemek icin
	 * */
	public static Vector<String> getKolonIsimleri(Class sinif) {

		Vector<String> result = new Vector<>();

		for (Field field : sinif.getDeclaredFields()) {
			//field.getType()
			result.add(field.getName());
		}

		return result;
	}
	
	/*
	 * gelen ifadenin sayi olup olmamasinin kontrolu
	 * */
	public static boolean isNumber(String str) {
		
		try {		
			Double.parseDouble(str);	
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public static String whereOlustur(String tableName, int id) {

		String whereKosul = "";

		switch (tableName) {
			case Tbl_Sehir: {
				whereKosul = "SehirID = " + id;
				break;
			}
			case Tbl_Renk: {
				whereKosul = "RenkID = " + id;
				break;
			}
			case Tbl_VitesTuru: {
				whereKosul = "VitesTuruID = " + id;
				break;
			}
			case Tbl_YakitTuru: {
				whereKosul = "YakitTuruID = " + id;
				break;
			}
			case Tbl_Ilan: {
				whereKosul = "IlanID = " + id;
				break;
			}
			case Tbl_Araba: {
				whereKosul = "ArabaID = " + id;
				break;
			}
			default: {
				return "";
			}
		}
		
		return whereKosul;		
	}
	

}

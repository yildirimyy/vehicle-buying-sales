package services;

public class DeleteService {
	
	private static String deleteQuery = "";
	
	public static boolean arabaSil(String id) {
		
		try {
			int idDeger = Integer.parseInt(id);
			String whereKosul = UtilitiesService.whereOlustur(UtilitiesService.Tbl_Araba, idDeger);
			
			deleteQuery = DBService.GetDeleteQuery(UtilitiesService.Tbl_Araba, whereKosul);
			
			String sonuc = DBService.ExecQuery(deleteQuery);
			
			if(sonuc == DBService.ERROR)
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static boolean ilanSil(String id) {
		
		try {
			int idDeger = Integer.parseInt(id);
			String whereKosul = UtilitiesService.whereOlustur(UtilitiesService.Tbl_Ilan, idDeger);
			
			deleteQuery = DBService.GetDeleteQuery(UtilitiesService.Tbl_Ilan, whereKosul);
			
			String sonuc = DBService.ExecQuery(deleteQuery);
			
			if(sonuc == DBService.ERROR)
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static boolean sehirSil(String id) {
		
		try {
			int idDeger = Integer.parseInt(id);
			String whereKosul = UtilitiesService.whereOlustur(UtilitiesService.Tbl_Sehir, idDeger);
			
			deleteQuery = DBService.GetDeleteQuery(UtilitiesService.Tbl_Sehir, whereKosul);
			
			String sonuc = DBService.ExecQuery(deleteQuery);
			
			if(sonuc == DBService.ERROR)
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static boolean vitesTuruSil(String id) {
		
		try {
			int idDeger = Integer.parseInt(id);
			String whereKosul = UtilitiesService.whereOlustur(UtilitiesService.Tbl_VitesTuru, idDeger);
			
			deleteQuery = DBService.GetDeleteQuery(UtilitiesService.Tbl_VitesTuru, whereKosul);
			
			String sonuc = DBService.ExecQuery(deleteQuery);
			
			if(sonuc == DBService.ERROR)
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static boolean renkSil(String id) {
		
		try {
			int idDeger = Integer.parseInt(id);
			String whereKosul = UtilitiesService.whereOlustur(UtilitiesService.Tbl_Renk, idDeger);
			
			deleteQuery = DBService.GetDeleteQuery(UtilitiesService.Tbl_Renk, whereKosul);
			
			String sonuc = DBService.ExecQuery(deleteQuery);
			
			if(sonuc == DBService.ERROR)
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	public static boolean yakitTuruSil(String id) {
		
		try {
			int idDeger = Integer.parseInt(id);
			String whereKosul = UtilitiesService.whereOlustur(UtilitiesService.Tbl_YakitTuru, idDeger);
			
			deleteQuery = DBService.GetDeleteQuery(UtilitiesService.Tbl_YakitTuru, whereKosul);
			
			String sonuc = DBService.ExecQuery(deleteQuery);
			
			if(sonuc == DBService.ERROR)
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

}

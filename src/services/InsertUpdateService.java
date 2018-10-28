package services;

import java.lang.reflect.Field;
import java.util.Vector;

import models.Araba;
import models.Ilan;
import models.Renk;
import models.Sehir;
import models.VitesTuru;
import models.YakitTuru;

public class InsertUpdateService {

	private static String insertSql = "";
	private static String updateSql = "";	
	
	/*
	 * gelen degerleri ilgili tabloya insertmek icin dbservice cagiriyor
	 * */
	private static boolean insertDegerler(String tableName, Vector<ColumnValue> degerler) {

		// calistirilacak sql stringini al
		insertSql = DBService.GetInsertQuery(tableName, degerler);

		if (insertSql == "")
			return false;

		// sql string calistir ve basari durumunu al
		String sonuc = DBService.ExecQuery(insertSql);

		if (sonuc == DBService.ERROR) {
			return false;
		}

		return true;
	}
	
	/*
	 * gelen degerleri ilgili tabloya insertmek icin dbservice cagiriyor
	 * */
	private static boolean updateDegerler(String tableName, Vector<ColumnValue> degerler, int id) {

		String whereKosul = "";
		whereKosul = UtilitiesService.whereOlustur(tableName, id);
		
		// calistirilacak sql stringini al
		updateSql = DBService.GetUpdateQuery(tableName, degerler, whereKosul);

		if (updateSql == "")
			return false;

		// sql string calistir ve basari durumunu al
		String sonuc = DBService.ExecQuery(updateSql);

		if (sonuc == DBService.ERROR) {
			return false;
		}

		return true;
	}
	

	public static boolean arabaEkleGuncelle(Araba araba) {
		
		if (araba == null)
			return false;

		boolean sonuc = false;
		try {
			Vector<ColumnValue> degerler = new Vector<>();			
			ColumnValue deger1 = new ColumnValue("Araba_Marka", araba.Araba_Marka);
			ColumnValue deger2 = new ColumnValue("Araba_Model", araba.Araba_Model);
			ColumnValue deger3 = new ColumnValue("Araba_VitesTuruID", Integer.toString(araba.Araba_VitesTuruID));
			ColumnValue deger4 = new ColumnValue("Araba_YakitTuruID", Integer.toString(araba.Araba_YakitTuruID));
			ColumnValue deger5 = new ColumnValue("Araba_RenkID", Integer.toString(araba.Araba_RenkID));
			degerler.add(deger1);
			degerler.add(deger2);
			degerler.add(deger3);
			degerler.add(deger4);
			degerler.add(deger5);
			
			//id varsa update cagir
			if(araba.ArabaID > 0) {
				sonuc = updateDegerler(UtilitiesService.Tbl_Araba, degerler, araba.ArabaID);
			}else {
				sonuc = insertDegerler(UtilitiesService.Tbl_Araba, degerler);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return sonuc;
	}

	public static boolean ilanEkleGuncelle(Ilan ilan) {
		
		if (ilan == null)
			return false;

		boolean sonuc = false;
		try {

			Vector<ColumnValue> degerler = new Vector<>();
			ColumnValue deger1 = new ColumnValue("Ilan_Adi", ilan.Ilan_Adi);
			ColumnValue deger2 = new ColumnValue("Ilan_Fiyat", Double.toString(ilan.Ilan_Fiyat));
			ColumnValue deger3 = new ColumnValue("Ilan_Km", Double.toString(ilan.Ilan_Km));
			ColumnValue deger4 = new ColumnValue("Ilan_Tarih", ilan.Ilan_Tarih);
			ColumnValue deger5 = new ColumnValue("Ilan_ArabaID", Integer.toString(ilan.Ilan_ArabaID));
			ColumnValue deger6 = new ColumnValue("Ilan_SehirID", Integer.toString(ilan.Ilan_SehirID));
			degerler.add(deger1);
			degerler.add(deger2);
			degerler.add(deger3);
			degerler.add(deger4);
			degerler.add(deger5);
			degerler.add(deger6);
			
			//id varsa update cagir
			if(ilan.IlanID > 0) {
				sonuc = updateDegerler(UtilitiesService.Tbl_Ilan, degerler, ilan.IlanID);
			}else {
				sonuc = insertDegerler(UtilitiesService.Tbl_Ilan, degerler);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return sonuc;
	}

	public static boolean sehirEkleGuncelle(Sehir sehir) {

		if (sehir == null)
			return false;

		boolean sonuc = false;
		try {

			Vector<ColumnValue> degerler = new Vector<>();
			ColumnValue yeniDeger = new ColumnValue("Sehir", sehir.Sehir);
			degerler.add(yeniDeger);

			//id varsa update cagir
			if(sehir.SehirID > 0) {
				sonuc = updateDegerler(UtilitiesService.Tbl_Sehir, degerler, sehir.SehirID);
			}else {
				sonuc = insertDegerler(UtilitiesService.Tbl_Sehir, degerler);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return sonuc;
	}

	public static boolean vitesTuruEkleGuncelle(VitesTuru vitesTuru) {

		if (vitesTuru == null)
			return false;

		boolean sonuc = false;

		try {

			Vector<ColumnValue> degerler = new Vector<>();
			ColumnValue yeniDeger = new ColumnValue("Vites_Turu", vitesTuru.Vites_Turu);
			degerler.add(yeniDeger);
			
			//id varsa update cagir
			if(vitesTuru.VitesTuruID > 0 ) {
				sonuc = updateDegerler(UtilitiesService.Tbl_VitesTuru, degerler, vitesTuru.VitesTuruID);
			}else {
				sonuc = insertDegerler(UtilitiesService.Tbl_VitesTuru, degerler);
			}		

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return sonuc;
	}

	public static boolean renkEkleGuncelle(Renk renk) {

		if (renk == null)
			return false;

		boolean sonuc = false;

		try {

			Vector<ColumnValue> degerler = new Vector<>();
			ColumnValue yeniDeger = new ColumnValue("Renk", renk.Renk);
			degerler.add(yeniDeger);	
			
			//id varsa update cagir
			if(renk.RenkID > 0) {
				sonuc = updateDegerler(UtilitiesService.Tbl_Renk, degerler, renk.RenkID);
			}else {
				sonuc = insertDegerler(UtilitiesService.Tbl_Renk, degerler);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return sonuc;
	}

	public static boolean yakitTuruEkleGuncelle(YakitTuru yakitTuru) {

		if (yakitTuru == null)
			return false;

		boolean sonuc = false;

		try {

			Vector<ColumnValue> degerler = new Vector<>();
			ColumnValue yeniDeger = new ColumnValue("Yakit_Turu", yakitTuru.Yakit_Turu);
			degerler.add(yeniDeger);

			//id varsa update cagir
			if(yakitTuru.YakitTuruID > 0) {
				sonuc = updateDegerler(UtilitiesService.Tbl_YakitTuru, degerler, yakitTuru.YakitTuruID);
			}else {
				sonuc = insertDegerler(UtilitiesService.Tbl_YakitTuru, degerler);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return sonuc;
	}



}

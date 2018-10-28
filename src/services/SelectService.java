package services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import models.Araba;
import models.Ilan;
import models.IlanSearchSonuc;
import models.Renk;
import models.Sehir;
import models.VitesTuru;
import models.YakitTuru;

public class SelectService {
	
	private static String selectQuery = "";
	
	/*
	 * id = 0 olursa hepsini getirir
	 * */
	public static Vector<Araba> arabalariAl(int id){
		
		Vector<Araba> arabalar = new Vector<Araba>();
		
		try {
			String whereKosul = "";
			if(id > 0) {
				whereKosul = UtilitiesService.whereOlustur(UtilitiesService.Tbl_Araba, id);
			}
			
			selectQuery = DBService.GetSelectQuery(UtilitiesService.Tbl_Araba, whereKosul);
			
			String sonuc = DBService.ExecQuerySelect(selectQuery, UtilitiesService.Tbl_Araba);
			
			if(sonuc == DBService.ERROR)
				return arabalar;
			
			arabalar = (Vector<Araba>) DBService.arabalar.clone();
			
		} catch (Exception e) {
			e.printStackTrace();
			arabalar = new Vector<>();
		}
		
		return arabalar; 
	}
	
	/*
	 * id = 0 olursa hepsini getirir
	 * */
	public static Vector<Ilan> ilanlariAl(int id){
		
		Vector<Ilan> ilanlar = new Vector<Ilan>();
		
		try {
			String whereKosul = "";
			if(id > 0) {
				whereKosul = UtilitiesService.whereOlustur(UtilitiesService.Tbl_Ilan, id);
			}
			
			selectQuery = DBService.GetSelectQuery(UtilitiesService.Tbl_Ilan, whereKosul);
			
			String sonuc = DBService.ExecQuerySelect(selectQuery, UtilitiesService.Tbl_Ilan);
			
			if(sonuc == DBService.ERROR)
				return ilanlar;
			
			ilanlar = (Vector<Ilan>) DBService.ilanlar.clone();
			
		} catch (Exception e) {
			e.printStackTrace();
			ilanlar = new Vector<>();
		}
		
		return ilanlar; 
	}
	
	/*
	 * id = 0 olursa hepsini getirir
	 * */
	public static Vector<Renk> renkleriAl(int id){
		
		Vector<Renk> renkler = new Vector<Renk>();
		
		try {
			String whereKosul = "";
			if(id > 0) {
				whereKosul = UtilitiesService.whereOlustur(UtilitiesService.Tbl_Renk, id);
			}
			
			selectQuery = DBService.GetSelectQuery(UtilitiesService.Tbl_Renk, whereKosul);
			
			String sonuc = DBService.ExecQuerySelect(selectQuery, UtilitiesService.Tbl_Renk);
			
			if(sonuc == DBService.ERROR)
				return renkler;
			
			renkler = (Vector<Renk>) DBService.renkler.clone();
			
		} catch (Exception e) {
			e.printStackTrace();
			renkler = new Vector<>();
		}
		
		return renkler; 
	}
	
	/*
	 * id = 0 olursa hepsini getirir
	 * */
	public static Vector<YakitTuru> yakitTurleriniAl(int id){
		
		Vector<YakitTuru> yakitTurleri = new Vector<YakitTuru>();
		
		try {
			String whereKosul = "";
			if(id > 0) {
				whereKosul = UtilitiesService.whereOlustur(UtilitiesService.Tbl_YakitTuru, id);
			}
			
			selectQuery = DBService.GetSelectQuery(UtilitiesService.Tbl_YakitTuru, whereKosul);
			
			String sonuc = DBService.ExecQuerySelect(selectQuery, UtilitiesService.Tbl_YakitTuru);
			
			if(sonuc == DBService.ERROR)
				return yakitTurleri;
			
			yakitTurleri = (Vector<YakitTuru>) DBService.yakitTurleri.clone();
			
		} catch (Exception e) {
			e.printStackTrace();
			yakitTurleri = new Vector<>();
		}
		
		return yakitTurleri; 
	}
	
	/*
	 * id = 0 olursa hepsini getirir
	 * */
	public static Vector<VitesTuru> vitesTurleriniAl(int id){
		
		Vector<VitesTuru> vitesTurleri = new Vector<VitesTuru>();
		
		try {
			String whereKosul = "";
			if(id > 0) {
				whereKosul = UtilitiesService.whereOlustur(UtilitiesService.Tbl_VitesTuru, id);
			}
			
			selectQuery = DBService.GetSelectQuery(UtilitiesService.Tbl_VitesTuru, whereKosul);
			
			String sonuc = DBService.ExecQuerySelect(selectQuery, UtilitiesService.Tbl_VitesTuru);
			
			if(sonuc == DBService.ERROR)
				return vitesTurleri;
			
			vitesTurleri = (Vector<VitesTuru>) DBService.vitesTurleri.clone();
			
		} catch (Exception e) {
			e.printStackTrace();
			vitesTurleri = new Vector<>();
		}
		
		return vitesTurleri; 
	}
	
	/*
	 * id = 0 olursa hepsini getirir
	 * */
	public static Vector<Sehir> sehirleriAl(int id){
		
		Vector<Sehir> sehirler = new Vector<Sehir>();
		
		try {
			String whereKosul = "";
			if(id > 0) {
				whereKosul = UtilitiesService.whereOlustur(UtilitiesService.Tbl_Sehir, id);
			}
			
			selectQuery = DBService.GetSelectQuery(UtilitiesService.Tbl_Sehir, whereKosul);
			
			String sonuc = DBService.ExecQuerySelect(selectQuery, UtilitiesService.Tbl_Sehir);
			
			if(sonuc == DBService.ERROR)
				return sehirler;
			
			sehirler = (Vector<Sehir>) DBService.sehirler.clone();
			
		} catch (Exception e) {
			e.printStackTrace();
			sehirler = new Vector<>();
		}
		
		return sehirler; 
	}
	
	public static Vector<IlanSearchSonuc> search(String arananIlanAd, int tarihGun, Sehir secilenSehir,
			YakitTuru secilenYakitTuru, VitesTuru secilenVitesTuru, Renk secilenRenk, double minFiyat, double maxFiyat,
			double minKm, double maxkm, ComboSiralama adSiralama, ComboSiralama fiyatSiralama, ComboSiralama kmSiralama,
			ComboSiralama tarihSiralama, ComboSiralama markaSiralama, ComboSiralama modelSiralama,
			ComboSiralama yakitSiralama, ComboSiralama vitesSiralama, ComboSiralama renkSiralama,
			ComboSiralama sehirSiralama) {
		
		
		Vector<IlanSearchSonuc> sonuclar = new Vector<IlanSearchSonuc>();
		String searchQuery = "SELECT i.*, s.*, a.*, r.*, v.*, y.* " + 
				"FROM Tbl_Ilan i " + 
				"LEFT JOIN Tbl_Sehir s on s.SehirID = i.Ilan_SehirID " + 
				"LEFT JOIN Tbl_Araba a ON a.ArabaID = i.Ilan_ArabaID " + 
				"LEFT JOIN Tbl_Renk r on r.RenkID = a.Araba_RenkID " + 
				"LEFT JOIN Tbl_VitesTuru v on v.VitesTuruID = a.Araba_VitesTuruID " + 
				"LEFT JOIN Tbl_YakitTuru y on y.YakitTuruID = a.Araba_YakitTuruID ";
		
		String orderQuery = "ORDER BY IlanID ASC;";
		String secimOrderQuery = "ORDER BY ";
	
		if(adSiralama.id > 0) {
			if(adSiralama.sirala) {
				secimOrderQuery += "Ilan_Adi ASC ,";
			}else {
				secimOrderQuery += "Ilan_Adi DESC ,";
			}
		}		
		if(fiyatSiralama.id > 0 ) {
			if(fiyatSiralama.sirala) {
				secimOrderQuery += "Ilan_Fiyat ASC ,";
			}else {
				secimOrderQuery += "Ilan_Fiyat DESC ,";
			}
		}
		if(kmSiralama.id > 0) {
			if(kmSiralama.sirala) {
				secimOrderQuery += "Ilan_Km ASC ,";
			}else {
				secimOrderQuery += "Ilan_Km DESC ,";
			}
		}
		
		if(tarihSiralama.id > 0) {
			if(tarihSiralama.sirala) {
				secimOrderQuery += "Ilan_Tarih ASC ,";
			}else {
				secimOrderQuery += "Ilan_Tarih DESC ,";
			}
		}
		
		if(markaSiralama.id > 0) {
			if(markaSiralama.sirala) {
				secimOrderQuery += "Araba_Marka ASC ,";
			}else {
				secimOrderQuery += "Araba_Marka DESC ,";
			}
		}
		
		if(modelSiralama.id > 0) {
			if(modelSiralama.sirala) {
				secimOrderQuery += "Araba_Model ASC ,";
			}else {
				secimOrderQuery += "Araba_Model DESC ,";
			}
		}
		if(yakitSiralama.id > 0) {
			if(yakitSiralama.sirala) {
				secimOrderQuery += "Yakit_Turu ASC ,";
			}else {
				secimOrderQuery += "Yakit_Turu DESC ,";
			}
		}
		if(vitesSiralama.id > 0) {
			if(vitesSiralama.sirala) {
				secimOrderQuery += "Vites_Turu ASC ,";
			}else {
				secimOrderQuery += "Vites_Turu DESC ,";
			}
		}
		if(renkSiralama.id > 0) {
			if(renkSiralama.sirala) {
				secimOrderQuery += "Renk ASC ,";
			}else {
				secimOrderQuery += "Renk DESC ,";
			}
		}
		if(sehirSiralama.id > 0) {
			if(sehirSiralama.sirala) {
				secimOrderQuery += "Sehir ASC ,";
			}else {
				secimOrderQuery += "Sehir DESC ,";
			}
		}
		
		if(secimOrderQuery != "ORDER BY ") {
			//sondaki virgulu temizlemek icin regex
			secimOrderQuery = secimOrderQuery.replaceAll("\\,$", "");
			secimOrderQuery += ";";
			orderQuery = secimOrderQuery;
		}
		
		try {
			String whereKosul = "WHERE ";		
			if(!arananIlanAd.equals("")) {
				whereKosul += " Ilan_Adi = '" + arananIlanAd + "' ?";
			}
			
			if(tarihGun != 0) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        Date bugun = new Date();
		        Calendar tarihAyarlama = Calendar.getInstance();
		        tarihAyarlama.setTime(bugun);
		        
		        // son 24 ise -24 son 1 hafta ise -24*7 son bir ay ise -24*30
		        tarihAyarlama.add(Calendar.HOUR, tarihGun);
		        
		        Date bakilacakTarih = tarihAyarlama.getTime();		        
		        String bakilacakTarihString = dateFormat.format(bakilacakTarih);
		        
		        whereKosul += " Ilan_Tarih > '" + bakilacakTarihString + "' ?";
			}
			
			if(secilenSehir.SehirID > 0) {
				whereKosul += " SehirID = " + secilenSehir.SehirID + " ?";
			}
			
			if(secilenYakitTuru.YakitTuruID > 0) {
				whereKosul += " YakitTuruID = " + secilenYakitTuru.YakitTuruID + " ?";
			}
			
			if(secilenVitesTuru.VitesTuruID > 0) {
				whereKosul += " VitesTuruID = " + secilenVitesTuru.VitesTuruID + " ?";
			}
			
			if(secilenRenk.RenkID > 0) {
				whereKosul += " RenkID = " + secilenRenk.RenkID + " ?";
			}
			
			if(minFiyat > 0) {
				whereKosul += " Ilan_Fiyat >= " + Double.toString(minFiyat) + " ?";
			}
			
			if(maxFiyat > 0) {
				whereKosul += " Ilan_Fiyat <= " + Double.toString(maxFiyat) + " ?";
			}
			
			if(minKm > 0) {
				whereKosul += " Ilan_Km >= " + Double.toString(minKm) + " ?";
			}
			
			if(maxkm > 0) {
				whereKosul += " Ilan_Km <= " + Double.toString(maxkm) + " ?";
			}
			
			//sondaki soru isaretini temizle soru isareti yerine and kosulu koy
			whereKosul = whereKosul.replaceAll("\\?$", "");
			whereKosul = whereKosul.replace("?", "and");
			
			//where where esitse kosul yok
			if(whereKosul.equals("WHERE ") ) {
				whereKosul = "";
			}
			
			//join islemi ile where kosulu birlestir
			searchQuery += whereKosul;
			
			//order
			searchQuery += orderQuery;
			
			String sonuc = DBService.ExecQuerySelect(searchQuery, UtilitiesService.IlanSearchSonuc);
			
			if(sonuc == DBService.ERROR)
				return sonuclar;
			
			sonuclar = (Vector<IlanSearchSonuc>) DBService.ilanSearchSonuclar.clone();
			
		} catch (Exception e) {
			e.printStackTrace();
			sonuclar = new Vector<>();
		}
		
		return sonuclar;
	}
	
	
	
	
	
	
	
	
}

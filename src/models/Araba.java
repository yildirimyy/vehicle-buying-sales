package models;

public class Araba {
	
	public int ArabaID;
	public String Araba_Marka;
	public String Araba_Model;
	public int Araba_VitesTuruID;
	public int Araba_YakitTuruID;
	public int Araba_RenkID;
	
	public Araba(int arabaID, String araba_Marka, String araba_Model, int araba_VitesTuruID, int araba_YakitTuruID,
			int araba_RenkID) {
		super();
		ArabaID = arabaID;
		Araba_Marka = araba_Marka;
		Araba_Model = araba_Model;
		Araba_VitesTuruID = araba_VitesTuruID;
		Araba_YakitTuruID = araba_YakitTuruID;
		Araba_RenkID = araba_RenkID;
	}
	
	

}

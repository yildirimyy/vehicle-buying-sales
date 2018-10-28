package models;

public class VitesTuru {
	
	public int VitesTuruID;
	public String Vites_Turu;
	
	public VitesTuru(int vitesTuruID, String vites_Turu) {
		super();
		VitesTuruID = vitesTuruID;
		Vites_Turu = vites_Turu;
	}
	
    @Override
    public String toString() {
        return this.Vites_Turu;
    }
}

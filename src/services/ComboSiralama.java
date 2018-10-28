package services;

public class ComboSiralama {
	
	int id;
	String metin;
	
	//false olursa ters true olursa duz siralama
	boolean sirala;

	public ComboSiralama(int id, String metin, boolean sirala) {
		super();
		this.id = id;
		this.metin = metin;
		this.sirala = sirala;
	}
	
    @Override
    public String toString() {
        return this.metin;
    }

}

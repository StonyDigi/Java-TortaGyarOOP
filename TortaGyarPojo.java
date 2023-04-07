package tortaGyar;

public class TortaGyarPojo {
	
	private String azonosito;
	private String megnevezes;
	private Integer netto_ar;
	private Integer szeletes;
	private boolean akcios;
	private boolean gm;
	private boolean lm;
	public TortaGyarPojo(String azonosito, String megnevezes, Integer netto_ar, Integer szeletes, boolean akcios,
			boolean gm, boolean lm) {
		
		this.azonosito = azonosito;
		this.megnevezes = megnevezes;
		this.netto_ar = netto_ar;
		this.szeletes = szeletes;
		this.akcios = akcios;
		this.gm = gm;
		this.lm = lm;
	}
	public String getAzonosito() {
		return azonosito;
	}
	public String getMegnevezes() {
		return megnevezes;
	}
	public Integer getNetto_ar() {
		return netto_ar;
	}
	public double getAfaKulcs() {
		int netto = 0;
		double osszeg = 0.0;
		if(getNetto_ar()>0) {
			osszeg += netto;	
		}
		return netto*1.27;
	}
	public Integer getSzeletes() {
		return szeletes;
	}
	public boolean isAkcios() {
		return akcios;
	}
	public boolean isGm() {
		return gm;
	}
	public boolean isLm() {
		return lm;
	}
	
	public String toString() {
		return this.azonosito +"\t" +this.megnevezes 
				+"\t" +this.netto_ar +"\t" +this.szeletes +"\t" +this.akcios +"\t" +this.gm +"\t" +this.lm + "\n";
	}
	public String isAkciosSzovegesen() {
		String valasz = "nem akciós";
		if(akcios) {
			valasz = "akciós";
		}
		return valasz;
	}
	public String isGlutenMentes() {
		String valasz = "nem gluténmentes";
		if(gm) {
			valasz = "gluténmentes";
		}
		return valasz;
	}
	public String isLaktozMentes() {
		String valasz = "nem laktózmentes";
		if(lm) {
			valasz = "laktózmentes";
		}
		return valasz;
	}
	

}

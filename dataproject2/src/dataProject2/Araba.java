package dataProject2;

public class Araba {
	private String renk;
	private Araba sonrakiAraba;
	int beklemeSuresi;
	
	public Araba(String renk){
		this.renk = renk;
	}
	public Araba(){}
	
	public Araba getSonrakiAraba() {
		return sonrakiAraba;
	}
	public void setSonrakiAraba(Araba sonrakiAraba) {
		this.sonrakiAraba = sonrakiAraba;
	}
	public String getRenk() {
		return renk;
	}
	public void setRenk(String renk) {
		this.renk = renk;
	}
	public int getBeklemeSuresi() {
		return beklemeSuresi;
	}
	public void setBeklemeSuresi(int beklemeSuresi) {
		this.beklemeSuresi = beklemeSuresi;
	}
}

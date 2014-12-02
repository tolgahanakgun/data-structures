package dataProject2;

public class Araba {
	private String renk;
	private Araba sonrakiAraba;
	
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
}

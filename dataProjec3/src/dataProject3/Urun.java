package dataProject3;

import java.util.ArrayList;

public class Urun {
    private String urunAdi;
    private String urunKategori;
    private String marka;
    private String model;
    private int miktar;
    private int maliyet;
    private int satisFiyatý;
    private ArrayList<String> aciklama;
    private Urun left, right;
    private int N;
    
    public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getMiktar() {
		return miktar;
	}
	public void setMiktar(int miktar) {
		this.miktar = miktar;
	}
	public int getMaliyet() {
		return maliyet;
	}
	public void setMaliyet(int maliyet) {
		this.maliyet = maliyet;
	}
	public int getSatisFiyatý() {
		return satisFiyatý;
	}
	public void setSatisFiyatý(int satisFiyatý) {
		this.satisFiyatý = satisFiyatý;
	}
	public String getUrunAdi() {
		return urunAdi;
	}
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}
	public String getUrunKategori() {
		return urunKategori;
	}
	public void setUrunKategori(String urunKategori) {
		this.urunKategori = urunKategori;
	}
	public Urun getLeft() {
		return left;
	}
	public void setLeft(Urun left) {
		this.left = left;
	}
	public Urun getRight() {
		return right;
	}
	public void setRight(Urun right) {
		this.right = right;
	}
	public int getN() {
		return N;
	}
	public void setN(int n) {
		N = n;
	}
	public ArrayList<String> getAciklama() {
		return aciklama;
	}
	public void setAciklama(ArrayList<String> aciklama) {
		this.aciklama = aciklama;
	}
	
}

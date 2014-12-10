package dataProject3;

import java.util.LinkedList;

public class Urun {
    private String urunAdi;
    private String urunKategori;
    private LinkedList<Urun> lstIlgiliUrunler;
    private Urun left, right;
    private int N;
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
	public LinkedList<Urun> getLstIlgiliUrunler() {
		return lstIlgiliUrunler;
	}
	public void setLstIlgiliUrunler(LinkedList<Urun> lstIlgiliUrunler) {
		this.lstIlgiliUrunler = lstIlgiliUrunler;
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
	
	

}

package dataProject2;

import java.util.Random;

public class ArabaBagliListe {
	private Araba listeBasiDugumu;	//baðlý listemiz daireseldir fakat araba eklemeleri hep sona yapýlacaðýndan
	private Araba listeSonuDugumu;	//liste sonuna kolay eriþim için liste sonu ayrýca tutulmaktadýr
	private int arabaSayisi;
	private static int nSayisi; //n. araba çýkar kuyruktan
	private Araba sonCikanAraba=null;
	
	public ArabaBagliListe() {
		listeBasiDugumu=null;
		listeSonuDugumu=listeBasiDugumu;
		arabaSayisi=0;
		Random rd = new Random();
		nSayisi = rd.nextInt(15);
	}
	
	public void arabaEkle(Araba eklenecekAraba) {
		if(listeBasiDugumu==null){ //liste boþsa baþa ekle
			listeBasiDugumu=eklenecekAraba;
			listeSonuDugumu=eklenecekAraba;
			eklenecekAraba.setSonrakiAraba(listeBasiDugumu);
			arabaSayisi++;
		}else{
			listeSonuDugumu.setSonrakiAraba(eklenecekAraba);
			listeSonuDugumu=eklenecekAraba; //liste sonuna eklenen aracýn referansý atanýyor
			eklenecekAraba.setSonrakiAraba(listeBasiDugumu); //liste dairesel baðlý yapýlýyor
			arabaSayisi++;
		} 
	}
	
	public Araba arabaCikar() {
		Araba oncekiAraba;
		Araba geciciAraba;
		if(sonCikanAraba!=null){
			oncekiAraba = sonCikanAraba;
			geciciAraba=oncekiAraba.getSonrakiAraba();
		}else{
			oncekiAraba=listeBasiDugumu;
			geciciAraba=oncekiAraba.getSonrakiAraba();
		}
		if(listeBasiDugumu!=null){
			arabaSayisi--;
			
			for(int i=0;i<nSayisi;i++){
				oncekiAraba=geciciAraba;
				geciciAraba=geciciAraba.getSonrakiAraba();
			}
			
			oncekiAraba.setSonrakiAraba(geciciAraba.getSonrakiAraba());
			sonCikanAraba=oncekiAraba;
			return geciciAraba;
		}
		return null;
	}

	public int getListedekiArabaSayisi() {
		return arabaSayisi;
	}
	
	public Araba get(int indis){
		if(indis<arabaSayisi){
			Araba gecici = listeBasiDugumu.getSonrakiAraba();
			for(int i=0;i<indis;i++){
				gecici = gecici.getSonrakiAraba();
			}
			return gecici;
		}
		else
			return null;
	}
	
	public int getNSayisi() {
		return nSayisi;
	}
}

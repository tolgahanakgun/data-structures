package dataProject2;

public class ArabaBagliListe {
	private Araba listeBasiDugumu = new Araba("ilk");	//ba�l� listemiz daireseldir fakat araba eklemeleri hep sona yap�laca��ndan
	private Araba listeSonuDugumu;	//liste sonuna kolay eri�im i�in liste sonu ayr�ca tutulmaktad�r
	private int arabaSayisi;
	
	public ArabaBagliListe() {
		listeBasiDugumu.setSonrakiAraba(listeBasiDugumu);
		listeSonuDugumu=listeBasiDugumu;
		arabaSayisi=0;
	}
	
	public void arabaEkle(Araba eklenecekAraba) {
		if(listeBasiDugumu.getSonrakiAraba() == listeBasiDugumu){ //liste bo�sa ba�a ekle
			listeBasiDugumu.setSonrakiAraba(eklenecekAraba);
			listeSonuDugumu=eklenecekAraba;
			eklenecekAraba.setSonrakiAraba(listeBasiDugumu);
			arabaSayisi++;
		}else{
			listeSonuDugumu.setSonrakiAraba(eklenecekAraba);
			listeSonuDugumu=eklenecekAraba; //liste sonuna eklenen arac�n referans� atan�yor
			eklenecekAraba.setSonrakiAraba(listeBasiDugumu); //liste dairesel ba�l� yap�l�yor
			arabaSayisi++;
		} 
	}
	
	public Araba arabaCikar() {
		if(listeBasiDugumu.getSonrakiAraba()!=listeBasiDugumu){
			Araba geciciAraba=listeBasiDugumu.getSonrakiAraba();
			listeBasiDugumu.setSonrakiAraba(geciciAraba.getSonrakiAraba());
			arabaSayisi--; 
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
}

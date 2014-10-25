package bağlılistedeneme;

class bagliListe {
	 private int ayinKacinciGunu=0;
	 private int bugunDoganKisiSayisi=0;
	 private bagliListe sonrakiBagliListe;
	
	public bagliListe() {
		sonrakiBagliListe = null;
	}

	public void dogumGunuEkle(int hangiGunDogdu){
		if(sonrakiBagliListe==null){
			sonrakiBagliListe = new bagliListe();
			sonrakiBagliListe.ayinKacinciGunu=hangiGunDogdu;
			sonrakiBagliListe.bugunDoganKisiSayisi++;
			sonrakiBagliListe.sonrakiBagliListe=null;
		}else{
			bagliListe gecici = sonrakiBagliListe;
			bagliListe oncekiBagliListe = this;
			while(gecici != null && gecici.ayinKacinciGunu<hangiGunDogdu){
				oncekiBagliListe=gecici;
				gecici = gecici.sonrakiBagliListe;
			}
			if(gecici!=null){
				if(gecici.ayinKacinciGunu==hangiGunDogdu){
					gecici.bugunDoganKisiSayisi++;
				}else{
					bagliListe sonrakiBagliListe = new bagliListe();
					oncekiBagliListe.sonrakiBagliListe=sonrakiBagliListe;
					sonrakiBagliListe.sonrakiBagliListe=gecici;
					sonrakiBagliListe.bugunDoganKisiSayisi++;
					sonrakiBagliListe.ayinKacinciGunu=hangiGunDogdu;
				}
			}
			else{
				gecici = new bagliListe();
				gecici.ayinKacinciGunu=hangiGunDogdu;
				gecici.bugunDoganKisiSayisi++;
				gecici.sonrakiBagliListe = null;
			}
		}
	}
	
	public int[] listeyiYazdır(){
		bagliListe gecici;
		gecici = sonrakiBagliListe;
		int[] buAyDoganlar = new int[30];
		while(gecici!=null){
			buAyDoganlar[ayinKacinciGunu] = bugunDoganKisiSayisi;
		}
		return buAyDoganlar;
	}
	
	public int bugunDoganKacKisiVar(int ayinKacicigunu){
		bagliListe gecici = sonrakiBagliListe;
		if(gecici==null)
			System.out.println("null");
		while(gecici != null && gecici.ayinKacinciGunu<ayinKacicigunu){
			gecici=gecici.sonrakiBagliListe;
		}
		if(gecici!=null)
			return gecici.bugunDoganKisiSayisi;
		return 0;
	}
	
	public int buAykiCakismalar() {
		int top=0;
		bagliListe gecici = sonrakiBagliListe;
		while(gecici!=null){
			if(gecici.bugunDoganKisiSayisi>1)
				top+=gecici.bugunDoganKisiSayisi-1;
			gecici=gecici.sonrakiBagliListe;
		}
		return top;
	}
}
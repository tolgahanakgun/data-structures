package datajframe;

import java.util.Arrays;
import java.util.Collections;

public class randomNames {
	
	String[] isimler = new String[] {"Mehmet", "Yunus","Aybars","Nagihan", 
			"Merve", "G�lcan", "Cemal", "Serkan", "Berk", 
			"Tunahan", "Barbaros", "Bilal", "Enes", "Sel�uk", 
			"�ule", "Tu��e","Hadise", "G�zde", "Esra", "Tu�ba"};
	
	String[] soyIsimler = new String[] {"Atik", "Emircan", "�pek�i","Bursal�",
			"Kaya", "Y�lmaz", "Kom�uk�z�", "D�zyatan", "Ersoy", "Yerlikaya",
			"Sar�","�ansal","Ulusay","T�rker","�st�n","Y�ksel","U�ur",
			"Ate�","D�zoba","K�l��"};
	
	String[] karistirilmisIsimleString = new String[400];
	
	public randomNames() {
		Collections.shuffle(Arrays.asList(isimler)); //isimlerin s�ralamas� de�i�tiriliyor
		Collections.shuffle(Arrays.asList(soyIsimler)); //soyisimlerin s�ralamas� de�i�tiriliyor
		isimleriBirlestir();
	}
	
	private void isimleriBirlestir() {
		for(int i = 0; i<20; i++){
			for(int j=0; j<20; j++)
			karistirilmisIsimleString[20*i+j] = isimler[j] + " " + soyIsimler[i];
		}
	}
	
	public String[] isimleriOku(int n){
		String[] isimler = new String[n];
		Collections.shuffle(Arrays.asList(karistirilmisIsimleString)); //isim soyisim kombinasyonlar� kar��t�r�l�yor
		for(int i=0; i<n;i++){
			isimler[i]=karistirilmisIsimleString[i];
		}
		return isimler;
	}
}

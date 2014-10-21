import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class randomNames {
	
	String[] isimler = new String[] {"Mehmet", "Yunus","Aybars","Nagihan", 
			"Merve", "G�lcan", "Cemal", "Serkan", "Berk", 
			"Tunahan", "Barbaros", "Bilal", "Enes", "Sel�uk", 
			"�ule", "Tu��e","Hadise", "G�zde", "Esra", "Tu�ba"};
	
	String[] soyIsimler = new String[] {"Atik", "Emircan", "Yeti�","Bursal�",
			"Kaya", "Y�lmaz", "Y�ld�z", "D�zyatan", "Ersoy", "Yerlikaya",
			"Sar�","Damla","Ulusay","T�rker","�st�n","Y�ksel","U�ur",
			"Ate�","Di�siz","K�l��"};
	
	String[] karistirilmisIsimleString = new String[400];
	
	Random rnd = new Random();

	
	public randomNames() {
		Collections.shuffle(Arrays.asList(isimler));
		Collections.shuffle(Arrays.asList(soyIsimler));
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
		Collections.shuffle(Arrays.asList(karistirilmisIsimleString));
		for(int i=0; i<n;i++){
			isimler[i]=karistirilmisIsimleString[i];
		}
		return isimler;
	}

}

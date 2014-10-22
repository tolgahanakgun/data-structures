import java.util.Arrays;
import java.util.Collections;

public class randomNames {
	
	String[] isimler = new String[] {"Mehmet", "Yunus","Aybars","Nagihan", 
			"Merve", "Gülcan", "Cemal", "Serkan", "Berk", 
			"Tunahan", "Barbaros", "Bilal", "Enes", "Selçuk", 
			"Þule", "Tuðçe","Hadise", "Gözde", "Esra", "Tuðba"};
	
	String[] soyIsimler = new String[] {"Atik", "Emircan", "Ýpekçi","Bursalý",
			"Kaya", "Yýlmaz", "Yýldýz", "Düzyatan", "Ersoy", "Yerlikaya",
			"Sarý","Þansal","Ulusay","Türker","Üstün","Yüksel","Uður",
			"Ateþ","Düzoba","Kýlýç"};
	
	String[] karistirilmisIsimleString = new String[400];
	
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

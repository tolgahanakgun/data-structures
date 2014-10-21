import java.util.Random;

public class randomNames {
	String[] isimler = new String[] {"Mehmet", "Yunus","Aybars","Nagihan", 
			"Merve", "Gülcan", "Cemal", "Serkan", "Berk", 
			"Tunahan", "Barbaros", "Bilal", "Enes", "Selçuk", 
			"Þule", "Tuðçe","Hadise", "Gözde", "Esra", "Tuðba"};
	
	String[] soyIsimler = new String[] {"Atik", "Emircan", "Yetiþ","Bursalý",
			"Kaya", "Yýlmaz", "Yýldýz", "Düzyatan", "Ersoy", "Yerlikaya",
			"Sarý","Damla","Ulusay","Türker","Üstün","Yüksel","Uður",
			"Ateþ","Diþsiz","Kýlýç"};
	
	int[] isimSiralamalar = {0,1,2,3,4,5,6,7,8,9,10,
									11,12,13,14,15,16,17,18,19};
	
	int[] soyIsimSiralamalar = {0,1,2,3,4,5,6,7,8,9,10,
									11,12,13,14,15,16,17,18,19};
	Random rnd = new Random();
	
	public randomNames() {
		shuffleArray(isimSiralamalar);
		shuffleArray(soyIsimSiralamalar);
	}
	
	public String[] isimleriOku() {
		String[] karistirilmisIsimleString = new String[400];
		for(int i = 0; i<20; i++){
			for(int j=0; j<20; j++)
			karistirilmisIsimleString[20*i+j] = isimler[isimSiralamalar[j]] + " " + soyIsimler[soyIsimSiralamalar[i]];
			//System.out.println(karistirilmisIsimleString[i]);
		}
		return karistirilmisIsimleString;
	}

	  void shuffleArray(int[] ar)
	  {
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
}

package dataProject2;

public class anaEkran {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArabaBagliListe liste = new ArabaBagliListe();
		liste.arabaEkle(new Araba("1"));
		liste.arabaEkle(new Araba("2"));
		liste.arabaEkle(new Araba("3"));
		liste.arabaEkle(new Araba("4"));
		liste.arabaEkle(new Araba("5"));

		Araba geciciAraba=liste.arabaCikar();
		while(geciciAraba!=null){
			System.out.println(geciciAraba.getRenk());
			geciciAraba=liste.arabaCikar();
		}
	}

}

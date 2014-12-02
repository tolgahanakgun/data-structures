package dataProject2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;


public class anaEkran {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ArabaBagliListe liste = new ArabaBagliListe();
		liste.arabaEkle(new Araba("1"));
		liste.arabaEkle(new Araba("2"));
		liste.arabaEkle(new Araba("3"));
		liste.arabaEkle(new Araba("4"));
		liste.arabaEkle(new Araba("5"));

		Araba geciciAraba=liste.arabaCikar();
		while(geciciAraba!=null){
			System.out.println(geciciAraba.getRenk());
			geciciAraba=liste.arabaCikar();
		}*/
		
		Stack<Araba> fifo = new Stack<Araba>();
		
		/*fifo.push(new Araba("sarý"));
		fifo.push(new Araba("mor"));
		fifo.push(new Araba("mavi"));
		fifo.push(new Araba("yeþil"));
		fifo.push(new Araba("gri"));
		while ( !fifo.empty() ){
			System.out.println(fifo.pop().getRenk());
		}*/
		Queue<Araba> kuyruk = new LinkedList<Araba>();
		ArabaBagliListe lstArabaBagliListe = new ArabaBagliListe();
		rastgeleArabaEkle(fifo, lstArabaBagliListe,kuyruk,15);
	}
	
	private static void rastgeleArabaEkle(Stack<Araba> fifo, ArabaBagliListe arabaBagliListe, Queue<Araba> kuyruk, int eklenecekArabaSayýsý){
		Random rnd = new Random();
		for(int i=0;i<eklenecekArabaSayýsý;i++){
			fifo.push(new Araba(rastgeleRenkBelirle(rnd.nextInt(10))));
			arabaBagliListe.arabaEkle(new Araba(rastgeleRenkBelirle(rnd.nextInt(10))));
			kuyruk.add(new Araba(rastgeleRenkBelirle(rnd.nextInt(10))));
		}

	}
	
	private static String rastgeleRenkBelirle(int i){
		switch (i) {
		case 0:
			return "Siyah";
		case 1:
			return "Beyaz";
		case 2:
			return "Mavi";
		case 3:
			return "Kýrmýzý";
		case 4:
			return "Mor";
		case 5:
			return "Yeþil";
		case 6:
			return "Sarý";
		case 7:
			return "Gri";
		case 8:
			return "Turuncu";	
		case 9:
			return "Pembe";
		default:
			return "Siyah";
		}
	}

}

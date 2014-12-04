package dataProject2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;


public class anaEkran {

	public static void main(String[] args) {
		
		Stack<Araba> yigin = new Stack<Araba>();	
		Queue<Araba> kuyruk = new LinkedList<Araba>();
		ArabaBagliListe lstArabaBagliListe = new ArabaBagliListe();
		rastgeleArabaEkle(yigin, lstArabaBagliListe,kuyruk,15);
		
		ArrayList kat = new ArrayList();
		kat.add(yigin);
		kat.add(kuyruk);
		kat.add(lstArabaBagliListe);
		
		arabalariListele(yigin, lstArabaBagliListe, kuyruk);
		Random rn = new Random();
		do{
			int hangiKat = rn.nextInt(2);
			if(hangiKat == 0){//Bodrum kattan araba cýkarýlýyorsa.
				if(yigin.size()!=0){
					System.out.println("Bodrum kattan cikan arabanin rengi: " + yigin.peek().getRenk() + "\n");
					kuyruk.add(yigin.pop());
					arabalariListele(yigin, lstArabaBagliListe, kuyruk);
				}
			}
			else{//2. kattan araba cýkarýlýyorsa.			
				if(lstArabaBagliListe.getListedekiArabaSayisi()!=0){
					System.out.println("2. kattan cikan arabanin rengi: " + lstArabaBagliListe.get(0).getRenk() + "\n");
					kuyruk.add(lstArabaBagliListe.arabaCikar());
					arabalariListele(yigin, lstArabaBagliListe, kuyruk);
				}
			}
		}while(yigin.size()!=0 || lstArabaBagliListe.getListedekiArabaSayisi()!=0);
		Araba[] a = new Araba[45];
		kuyruk.toArray(a);
		System.out.println("Son kalan arabanýn rengi: " + a[44].getRenk());
		
		CikisKuyrugu cikisKuyruk = new CikisKuyrugu(45);
		int beklemeSuresi = rn.nextInt(291)+10;
		
	}

	private static void rastgeleArabaEkle(Stack<Araba> yigin, ArabaBagliListe arabaBagliListe, Queue<Araba> kuyruk, int eklenecekArabaSayýsý){
		Random rnd = new Random();
		for(int i=0;i<eklenecekArabaSayýsý;i++){
			yigin.push(new Araba(rastgeleRenkBelirle(i)));
			kuyruk.add(new Araba(rastgeleRenkBelirle(14-i)));
			arabaBagliListe.arabaEkle(new Araba(rastgeleRenkBelirle(i)));
		}
	}
	
	private static String rastgeleRenkBelirle(int i){
		switch (i) {
		case 0: return "Siyah";
		case 1: return "Beyaz";
		case 2: return "Mavi";
		case 3: return "Kirmizi";
		case 4: return "Mor";
		case 5: return "Yesil";
		case 6: return "Sari";
		case 7: return "Gri";
		case 8: return "Turuncu";
		case 9: return "Pembe";
		case 10: return "Turkuaz";
		case 11: return "Lacivert";
		case 12: return "Metalik Gri";
		case 13: return "Kahverengi";
		case 14: return "Metalik Mavi";
		default: return "Siyah";
		}
	}
	
	private static void arabalariListele(Stack<Araba> yigin, ArabaBagliListe arabaBagliListe, Queue<Araba> kuyruk){
		
		System.out.println("Bodrum kattaki arabalar: ");
		System.out.println("-------------------------");
		for(int j=0;j<yigin.size();j++)
			System.out.println((j+1)+". "+yigin.get(j).getRenk());
		System.out.println();
		
		System.out.println("1. kattaki arabalar: ");
		System.out.println("-------------------------");
		int j=0;
		for(Araba a : kuyruk)
			System.out.println((++j)+". "+a.getRenk());
		System.out.println();
		
		System.out.println("2. kattaki arabalar: ");
		System.out.println("-------------------------");
		for(j=0;j<arabaBagliListe.getListedekiArabaSayisi();j++)
			System.out.println((j+1)+". "+arabaBagliListe.get(j).getRenk());
		System.out.println();
	}

}

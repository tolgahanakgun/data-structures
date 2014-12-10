package dataProject2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.PriorityQueue;


public class anaEkran {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Comparator<Araba> cmpAraba = new ArabaComparator();
		PriorityQueue<Araba> pqAraba = new PriorityQueue<Araba>(45,cmpAraba);

		Stack<Araba> yigin = new Stack<Araba>();//Bodrum kat	
		Queue<Araba> kuyruk = new LinkedList<Araba>();//1. kat
		ArabaBagliListe lstArabaBagliListe = new ArabaBagliListe();//2. kat
		rastgeleArabaEkle(yigin, lstArabaBagliListe,kuyruk,15);
		
		ArrayList<Object> kat = new ArrayList<Object>();
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
					Araba geciciAraba=lstArabaBagliListe.arabaCikar();
					System.out.println("2. kattan cikan arabanin rengi: " + geciciAraba.getRenk() + "\n");
					kuyruk.add(geciciAraba);
					arabalariListele(yigin, lstArabaBagliListe, kuyruk);
				}
			}
		}while(yigin.size()!=0 || lstArabaBagliListe.getListedekiArabaSayisi()!=0);
		
		
		Araba[] a = new Araba[45];
		kuyruk.toArray(a);
		System.out.println("Son kalan arabanýn rengi: " + a[44].getRenk());
		System.out.println();
		
		CikisKuyrugu cikisKuyruk = new CikisKuyrugu(45);
		Araba araba;
		int toplamCikisSuresi = 0;
		int sira=0;
		int[] beklemeDizi = new int[46];
		int[] islemSuresiDizisi = new int[46];
		int toplamBeklemeSuresi=0;
		
		do{//Arabalar cikis kuyruguna ekleniyor...
			int beklemeSuresi = rn.nextInt(291)+10;
			araba = kuyruk.poll();
			sira++;
			Araba pqEklenecekAraba = new Araba(araba.getRenk(), beklemeSuresi, sira);
			pqAraba.add(pqEklenecekAraba);
			islemSuresiDizisi[sira]=beklemeSuresi;
			toplamCikisSuresi += beklemeSuresi;
			beklemeDizi[sira]=toplamCikisSuresi;
			toplamBeklemeSuresi+=toplamCikisSuresi;
			araba.beklemeSuresi = toplamCikisSuresi;
			araba.setSiraNo(sira);
			cikisKuyruk.enque(araba);
		}while(!kuyruk.isEmpty());
		
		int i = 0;
		while(!cikisKuyruk.bosMu()){//FIFO kuyrugundan arabalar cikariliyor...
			i++;
			araba = cikisKuyruk.deque();
			System.out.println(i + ". arabanýn toplam bekleme süresi: " + araba.beklemeSuresi + " sn");
		}
		
		i=0;
		Araba gecici = null;
		int toplamCikisSuresi2=0;
		int toplamBeklemeSuresi2=0;
		System.out.println("\n\n\n--------Arabalardan iþlem süresi en az olan önce çýkýyor------------");
		
		while(!pqAraba.isEmpty()){
			gecici=pqAraba.poll();
			toplamCikisSuresi2+=gecici.getBeklemeSuresi();
			toplamBeklemeSuresi2+=toplamCikisSuresi2;
			if(beklemeDizi[gecici.getSiraNo()]>toplamCikisSuresi2)
				System.out.println(gecici.getSiraNo()+". Araba daha az bekledi---"+beklemeDizi[gecici.getSiraNo()]+
						">"+toplamCikisSuresi2);
		}
		System.out.println("\n-----Istatistikler------");
		System.out.println("Oncelik kuyrugu kullanilmadan onceki ort bekleme suresi = "+toplamBeklemeSuresi/45+" sn");
		System.out.println("Oncelik kuyrugu kullanildiktan sonraki ort bekleme suresi = "+toplamBeklemeSuresi2/45+" sn");
		System.out.println("Ortalama bekleme suresindeki fark = "+(toplamBeklemeSuresi/45-toplamBeklemeSuresi2/45)+" sn");
		System.out.println("Ortalama bekleme suresindeki kazanc yuzdesi = % "+100*((float)(toplamBeklemeSuresi-toplamBeklemeSuresi2)/toplamBeklemeSuresi));
		
		LinkedList<Araba>[] kuyrukDizisi = new LinkedList[4];
		
		for(int o=0;o<4;o++)
			kuyrukDizisi[o]=new LinkedList<Araba>();
		
		for(int j=0;j<45;j++)
			kuyrukDizisi[j%4].add(new Araba(islemSuresiDizisi[j+1], j+1));

		while(!kuyrukDizisi[0].isEmpty() || !kuyrukDizisi[1].isEmpty() ||
				!kuyrukDizisi[2].isEmpty() ||!kuyrukDizisi[3].isEmpty()){
			int minIndis = 0;
			for(int k=0;k<4;k++){
				if(kuyrukDizisi[k].peek()!=null){
					minIndis=k;
					break;
				}	
			}
			Araba geciciAraba;
			for(int k=1;k<4;k++){
				if(kuyrukDizisi[minIndis].peek()!=null && kuyrukDizisi[k].peek()!=null)
					if(kuyrukDizisi[minIndis].peek().getBeklemeSuresi()>kuyrukDizisi[k].peek().getBeklemeSuresi())
						minIndis=k;
			}
			cikisKuyruk.enque(kuyrukDizisi[minIndis].pop());
		}
		int toplamCikisSuresi3=0;
		int toplamBeklemeSuresi3=0;
		System.out.println("\n\n\n----------Arabalardan 4lu kuyruktan iþlem süresi en az olan öncelikli çýkýyor---------");
		while (!cikisKuyruk.bosMu()) {
			gecici=cikisKuyruk.deque();
			toplamCikisSuresi3+=gecici.getBeklemeSuresi();
			toplamBeklemeSuresi3+=toplamCikisSuresi3;
			if(beklemeDizi[gecici.getSiraNo()]>toplamCikisSuresi3)
				System.out.println(gecici.getSiraNo()+". Araba daha az bekledi---"+beklemeDizi[gecici.getSiraNo()]+
						">"+toplamCikisSuresi3);
		}
		System.out.println("\n-----Istatistikler------");
		System.out.println("Oncelik kuyrugu kullanilmadan onceki ort bekleme suresi = "+toplamBeklemeSuresi/45+" sn");
		System.out.println("4lü kuyruk kullanildiktan sonraki ort bekleme suresi = "+toplamBeklemeSuresi3/45+" sn");
		System.out.println("Ortalama bekleme suresindeki fark = "+(toplamBeklemeSuresi/45-toplamBeklemeSuresi3/45)+" sn");
		System.out.println("Ortalama bekleme suresindeki kazanc yuzdesi = % "+100*((float)(toplamBeklemeSuresi-toplamBeklemeSuresi3)/toplamBeklemeSuresi));
		System.out.println("\n\n\n--------Arabalarýn iþlem süresi------------");
		for(i=1;i<=45;i++)
			System.out.println(i+". "+islemSuresiDizisi[i]);
		System.out.println("----Bagli listedeki çýkarmlar n="+lstArabaBagliListe.getNSayisi()+" icin yapilmistir----");

		long start = System.currentTimeMillis();
		long end = start + 5*1000; // 60 seconds * 1000 ms/sec
		int sayac=0;
		while (System.currentTimeMillis() < end)
		{
		    zamaniOlc();
		    sayac++;
		}
		System.out.println("------Bilgisayarimiz 5 saniye de "+ sayac +" tane otopark problemi cosebilir");


	}

	private static void rastgeleArabaEkle(Stack<Araba> yigin, ArabaBagliListe arabaBagliListe, Queue<Araba> kuyruk, int eklenecekArabaSayýsý){
		@SuppressWarnings("unused")
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
	
	private static void zamaniOlc() {
		Comparator<Araba> cmpAraba = new ArabaComparator();
		PriorityQueue<Araba> pqAraba = new PriorityQueue<Araba>(45,cmpAraba);
		Stack<Araba> yigin = new Stack<Araba>();//Bodrum kat	
		Queue<Araba> kuyruk = new LinkedList<Araba>();//1. kat
		ArabaBagliListe lstArabaBagliListe = new ArabaBagliListe();//2. kat
		rastgeleArabaEkle(yigin, lstArabaBagliListe,kuyruk,15);
		
		ArrayList<Object> kat = new ArrayList<Object>();
		kat.add(yigin);
		kat.add(kuyruk);
		kat.add(lstArabaBagliListe);
		
		//arabalariListele(yigin, lstArabaBagliListe, kuyruk);
		Random rn = new Random();
		do{
			int hangiKat = rn.nextInt(2);
			if(hangiKat == 0){//Bodrum kattan araba cýkarýlýyorsa.
				if(yigin.size()!=0){
					
					kuyruk.add(yigin.pop());
				}
			}
			else{//2. kattan araba cýkarýlýyorsa.			
				if(lstArabaBagliListe.getListedekiArabaSayisi()!=0){
					Araba geciciAraba=lstArabaBagliListe.arabaCikar();
					kuyruk.add(geciciAraba);
				}
			}
		}while(yigin.size()!=0 || lstArabaBagliListe.getListedekiArabaSayisi()!=0);
				
		Araba[] a = new Araba[45];
		kuyruk.toArray(a);

		CikisKuyrugu cikisKuyruk = new CikisKuyrugu(45);
		Araba araba;
		int toplamCikisSuresi = 0;
		int sira=0;
		int[] beklemeDizi = new int[46];
		int[] islemSuresiDizisi = new int[46];
		int toplamBeklemeSuresi=0;
		
		do{//Arabalar cikis kuyruguna ekleniyor...
			int beklemeSuresi = rn.nextInt(291)+10;
			araba = kuyruk.poll();
			sira++;
			Araba pqEklenecekAraba = new Araba(araba.getRenk(), beklemeSuresi, sira);
			pqAraba.add(pqEklenecekAraba);
			islemSuresiDizisi[sira]=beklemeSuresi;
			toplamCikisSuresi += beklemeSuresi;
			beklemeDizi[sira]=toplamCikisSuresi;
			toplamBeklemeSuresi+=toplamCikisSuresi;
			araba.beklemeSuresi = toplamCikisSuresi;
			araba.setSiraNo(sira);
			cikisKuyruk.enque(araba);
		}while(!kuyruk.isEmpty());
		
		int i = 0;
		while(!cikisKuyruk.bosMu()){//FIFO kuyrugundan arabalar cikariliyor...
			i++;
			araba = cikisKuyruk.deque();
		}
		
		i=0;
		Araba gecici = null;
		int toplamCikisSuresi2=0;
		int toplamBeklemeSuresi2=0;
		
		while(!pqAraba.isEmpty()){
			gecici=pqAraba.poll();
			toplamCikisSuresi2+=gecici.getBeklemeSuresi();
			toplamBeklemeSuresi2+=toplamCikisSuresi2;		
		}

		LinkedList<Araba>[] kuyrukDizisi = new LinkedList[4];
		
		for(int o=0;o<4;o++)
			kuyrukDizisi[o]=new LinkedList<Araba>();
		
		for(int j=0;j<45;j++)
			kuyrukDizisi[j%4].add(new Araba(islemSuresiDizisi[j+1], j+1));

		while(!kuyrukDizisi[0].isEmpty() || !kuyrukDizisi[1].isEmpty() ||
				!kuyrukDizisi[2].isEmpty() ||!kuyrukDizisi[3].isEmpty()){
			int minIndis = 0;
			for(int k=0;k<4;k++){
				if(kuyrukDizisi[k].peek()!=null){
					minIndis=k;
					break;
				}	
			}
			Araba geciciAraba;
			for(int k=1;k<4;k++){
				if(kuyrukDizisi[minIndis].peek()!=null && kuyrukDizisi[k].peek()!=null)
					if(kuyrukDizisi[minIndis].peek().getBeklemeSuresi()>kuyrukDizisi[k].peek().getBeklemeSuresi())
						minIndis=k;
			}
			cikisKuyruk.enque(kuyrukDizisi[minIndis].pop());
		}
		int toplamCikisSuresi3=0;
		int toplamBeklemeSuresi3=0;
		
		while (!cikisKuyruk.bosMu()) {
			gecici=cikisKuyruk.deque();
			toplamCikisSuresi3+=gecici.getBeklemeSuresi();
			toplamBeklemeSuresi3+=toplamCikisSuresi3;

		}

	}

}

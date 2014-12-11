package dataProject3;

import java.util.ArrayList;
import java.util.LinkedList;

public class anaEkran {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Urun urun1=new Urun();
		urun1.setUrunAdi("asdasd");
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("araba");
		urun1.setAciklama(lst);
		
		Urun urun2=new Urun();
		urun2.setUrunAdi("sdasd");
		ArrayList<String> lst1 = new ArrayList<String>();
		lst1.add("bot");
		lst1.add("cd");
		lst1.add("araba");
		urun2.setAciklama(lst1);
		
		/*Urun urun3=new Urun();
		urun3.setUrunAdi("dasd");
		ArrayList<String> lst2 = new ArrayList<String>();
		lst2.add("pc");
		lst2.add("araba");
		urun2.setAciklama(lst2);*/
		
		UrunHashTablosu hashlerHashTablosu = new UrunHashTablosu();
		hashlerHashTablosu.urunEkle(urun1);
		hashlerHashTablosu.urunEkle(urun2);
		//hashlerHashTablosu.urunEkle(urun3);
		hashlerHashTablosu.isimeGoreAra("pc");
		
		/*BSTUrun treeBstUrun = new BSTUrun();
		treeBstUrun.put(urun1);
		treeBstUrun.put(urun2);
		treeBstUrun.put(urun3);
		System.out.println("oldu galba :D");
		//treeBstUrun.delete("asdasd");
		System.out.println(treeBstUrun.get("asdasd").getUrunAdi());
		System.out.println(treeBstUrun.get("sdasd").getUrunAdi());
		System.out.println(treeBstUrun.get("dasd").getUrunAdi());
		treeBstUrun.delete("asdasd");
		System.out.println(treeBstUrun.get("sdasd").getUrunAdi());
		System.out.println(treeBstUrun.get("dasd").getUrunAdi());
		System.out.println(treeBstUrun.get("asdasd"));*/
	}

}

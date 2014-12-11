package dataProject3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class UrunHashTablosu {
	//LinkedList<LinkedList<Urun>> sozlukLinkedList = new LinkedList<LinkedList<Urun>>();
	LinkedHashMap<String, LinkedList<Urun>> hashtablo =  new LinkedHashMap<String, LinkedList<Urun>>();
	public UrunHashTablosu() {}
	
	public void urunEkle(Urun urun) {
		Iterator<String> it = urun.getAciklama().iterator();
		String gecici;
		while (it.hasNext()) {
			gecici=it.next();
			if(hashtablo.containsKey(gecici)){
				hashtablo.get(gecici).add(urun);
			}else {
				LinkedList<Urun> lstGecici = new LinkedList<Urun>();
				lstGecici.add(urun);
				hashtablo.put(gecici, lstGecici);
			}
		}
	}
	
	public void isimeGoreAra(String urunAdi) {
		if(hashtablo.get(urunAdi)!=null){
			Iterator<Urun> it = hashtablo.get(urunAdi).iterator();
			while (it.hasNext()) {
				System.out.println(it.next().getUrunAdi());
			}
		}
	}
}

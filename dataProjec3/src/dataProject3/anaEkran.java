package dataProject3;

public class anaEkran {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Urun urun1=new Urun();
		urun1.setUrunAdi("asdasd");
		Urun urun2=new Urun();
		urun2.setUrunAdi("sdasd");
		Urun urun3=new Urun();
		urun3.setUrunAdi("dasd");
		BSTUrun treeBstUrun = new BSTUrun();
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
		System.out.println(treeBstUrun.get("asdasd"));
	}

}

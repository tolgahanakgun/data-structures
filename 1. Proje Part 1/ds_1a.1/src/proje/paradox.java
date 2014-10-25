package proje;

import java.util.Random;
import java.util.Scanner;

public class paradox {

	public static void main(String[] Args){
		System.out.print("Kiþi sayýsýný giriniz: ");
		Scanner scan = new Scanner(System.in);
		int kisiSay = scan.nextInt();
		for(int i=0;i<10;i++)
			tarihOlustur(kisiSay);
	}
	
	public static void tarihOlustur(int kisiSay){
		int hata = 0;
		int yil1,yil2;
		do{
			System.out.print("Birinci yili giriniz: ");
			Scanner scan = new Scanner(System.in);
			yil1 = scan.nextInt();
			System.out.print("Ýkinci yili giriniz: ");
			yil2 = scan.nextInt();
			if(yil1==yil2){
				hata = 1;
				System.out.println("Lütfen farklý yýllar seçiniz.");
			}
		}while(hata==1);
		
		donence(kisiSay,yil1,yil2);
			//randomcu(yil1, yil2);
	}
	
	public static void randomcu(int yil1,int yil2){
		Random rn = new Random();
		int uretilenYil;
		if(yil1<yil2)
			uretilenYil = rn.nextInt(yil2-yil1+1)+yil1;
		else
			uretilenYil = rn.nextInt(Math.abs(yil1-yil2+1))+yil2;
		int ay = rn.nextInt(12)+1;
		int gun = 0;
		
		switch(ay){
		case 1:case 3:case 5:
		case 7:case 8:case 10:case 12:
			gun = rn.nextInt(31)+1;
			break;
		case 4:case 6:case 9:case 11:
			gun = rn.nextInt(30)+1;
			break;
		case 2:
			if(uretilenYil%4==0)
				gun = rn.nextInt(29)+1;
			else
				gun = rn.nextInt(28)+1;
		}
		System.out.println(gun + "-" + ay + "-" + uretilenYil);
	}
	
	public static void donence(int n,int p1,int p2){
		for(int i=0;i<n;i++){
			randomcu(p1,p2);
		}
	}
	
}


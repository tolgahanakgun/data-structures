package ds_1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Paradox {

	public static void main(String[] Args) throws IOException{
		
		int[][] cakisma = new int[12][];
		cakisma[0] = new int[31];
		cakisma[1] = new int[29];
		cakisma[2] = new int[31];
		cakisma[3] = new int[30];
		cakisma[4] = new int[31];
		cakisma[5] = new int[30];
		cakisma[6] = new int[31];
		cakisma[7] = new int[31];
		cakisma[8] = new int[30];
		cakisma[9] = new int[31];
		cakisma[10] = new int[30];
		cakisma[11] = new int[31];
		
		for(int i=0;i<3;i++){
			System.out.print((i+1)+".test için kiþi sayýsýný giriniz: ");
			Scanner scan = new Scanner(System.in);
			int kisiSay = scan.nextInt();
			tarihOlustur(kisiSay,cakisma);
			System.out.println("\n"+(i+1)+".test bitti...\n");
			
		}
	}
	
	public static void tarihOlustur(int kisiSay,int cakisma[][]) throws IOException{
		
		int hata;
		int yil1,yil2;
		int toplamYil;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do{
			hata = 0;
			System.out.print("Baþlangýç yýlýný giriniz: ");
			Scanner scan = new Scanner(System.in);
			
			yil1 = scan.nextInt();
			System.out.print("Bitiþ yýlýný giriniz: ");
			yil2 = scan.nextInt();
			
			if(yil1==yil2){
				hata = 1;
				System.out.println("\nLütfen farklý yýllar seçiniz.");
			}
			
		}while(hata==1);
		
		if(yil1<yil2)
			toplamYil = yil2 - yil1 +1;
		else
			toplamYil = yil1 - yil2 +1;
				
		for(int i=0;i<10;i++){//Deneyler 10 kere tekrarlanýyor...
			donence(kisiSay,yil1,yil2,cakisma,toplamYil);
			System.out.print("Devam etmek için bir tuþa basýnýz");
			br.readLine();
		}
	}
	
	public static void randomcu(int yil1,int yil2,int sayac[][][]){
		
		Random rn = new Random();
		
		int yil=0;
		
		int kucukYil = kucukYilHesapla(yil1, yil2);
		
		yil = (rn.nextInt(yil2-yil1+1)+yil1)-kucukYil;
		
		int ay = 0;
		ay = rn.nextInt(12);
		int gun = 0;
		
		switch(ay){
		case 0:case 2:case 4:
		case 6:case 7:case 9:case 11:
			gun = rn.nextInt(31);
			break;
		case 3:case 5:case 8:case 10:
			gun = rn.nextInt(30);
			break;
		case 1:
			if((yil+kucukYil)%4==0)
				gun = rn.nextInt(29);
			else
				gun = rn.nextInt(28);
		}
				
		sayac[yil][ay][gun]++;
		
	}
	
	public static void donence(int n,int yil1,int yil2,int cakisma[][],int toplamYil){
		
		int[][][] sayac = new int[toplamYil][12][31];
		
		int kucukYil = kucukYilHesapla(yil1, yil2);
		
		for(int i=0;i<n;i++){
			randomcu(yil1,yil2,sayac);
		}
		
		for(int x=0;x<yil2-yil1+1;x++){
			for(int y=0;y<12;y++){
				switch(y){
				case 0:case 2:case 4:
				case 6:case 7:case 9:case 11:
					for(int z=0;z<31;z++){
						cakisma[y][z]+=sayac[x][y][z];
					}
					break;
				case 3:case 5:case 8:case 10:
					for(int z=0;z<30;z++){
						cakisma[y][z]+=sayac[x][y][z];
					}
					break;
				case 1:
					if((x+kucukYil)%4==0)
						for(int z=0;z<29;z++){
							cakisma[y][z]+=sayac[x][y][z];
						}
					else
						for(int z=0;z<28;z++){
							cakisma[y][z]+=sayac[x][y][z];
						}
					break;
				}
			}
		}
		yazdir(cakisma,kucukYil);
	}
	
	public static void yazdir(int cakisma[][],int kucukYil){
		
		System.out.println("   1 2 3 4 5 6 7 8 9 10111213141516171819202122232425262728293031");
		System.out.println("   --------------------------------------------------------------");
		for(int i=0;i<12;i++){
			switch(i){
			case 0:case 2:case 4:
			case 6:case 7:case 9:case 11:
				System.out.print((i+1)+". ");
				for(int j=0;j<31;j++){
					System.out.print(cakisma[i][j] + " ");
				}
				break;
			case 3:case 5:case 8:case 10:
				System.out.print((i+1)+". ");
				for(int j=0;j<30;j++){
					System.out.print(cakisma[i][j] + " ");
				}
				break;
			case 1:
				System.out.print((i+1)+". ");
				if((i+1+kucukYil)%4==0)
					for(int j=0;i<29;j++){
						System.out.print(cakisma[i][j] + " ");
					}
				else
					for(int j=0;j<28;j++){
						System.out.print(cakisma[i][j] + " ");
					}
				break;
			}
			System.out.println();
		}
	}
	
	public static int kucukYilHesapla(int yil1,int yil2){
		
		if(yil1<yil2)
			return yil1;
		else
			return yil2;
	}
	
}

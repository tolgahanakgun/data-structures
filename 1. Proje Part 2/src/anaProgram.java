import masalar.*;

public class anaProgram {

	public static void main(String[] args) {
		randomNames rnmsNames = new randomNames();
		masa[] masalar = masaDizisiOlustur();
		masalaraYerlestir(rnmsNames.isimleriOku(32), masalar);
		for(int i=0;i<10;i++){
			System.out.println(i+1+". ci masadakiler--------------------\n");
			int j=0;
			for(String str: masalar[i].oku()){
				if(str==null)
					break;
				System.out.println(++j+"."+str);		
			}
			System.out.println();
			System.out.println();
		}
	}
		
	public static void masalaraYerlestir(String[] kisiler,masa[] masalar) {
		int[][] yerlestirmeSirasi = new int[][] {{1, 1,	1,	1,	1,	1,	1,	1,	1,	1,},
												{1,  1,	1,	1,	1,	1,	1,	1,	1,	1,},
												{1,  1,	1,	1,	0,	1,	1,	0,	1,	1,},
												{1,  1,	1,	1,	0,	1,	1,	0,	1,	1,},
												{1,	 1,	1,	1,	0,	1,	1,	0,	1,	1,},
												{1,	 0,	0,	1,	0,	0,	1,	0,	1,	0,},
												{1,	 0,	0,	1,	0,	0,	1,	0,	1,	0,},
												{1,	 0,	0,	1,	0,	0,	1,	0,	1,	0,},
												{1,	 0,	0,	1,	0,	0,	1,	0,	1,	0,},
												{1,	 0,	0,	1,	0,	0,	1,	0,	1,	0}};
		int i=0,j=0,k=0;
		for(i=0;i<10;i++){
			for(j=0;j<10;j++){
				if(yerlestirmeSirasi[j][i]==1){
					masalar[j].masayaOturt(kisiler[k]);
					k++;
				}
				if(kisiler.length==k) break;
			}
			if(kisiler.length==k) break;
		}
	}
	public static masa[] masaDizisiOlustur(){
		masa[] masalar = new masa[10];
		int i=0,j=0,k=0;
		for(;i<2;i++) masalar[i] = new masa(10);
		for(;j<3;j++) masalar[i+j] = new masa(8);
		for(;k<5;k++) masalar[i+j+k] = new masa(4);
		return masalar;
	}
}

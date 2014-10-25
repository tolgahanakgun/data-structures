package datajframe;

public class masa{
	String[] kisiler;
	int masadakiKisiSayisi;
	
	public masa(int masadaOturacakKisiSayisi){
		kisiler = new String[masadaOturacakKisiSayisi];
		masadakiKisiSayisi = masadaOturacakKisiSayisi;
	}
	
	public void masayaOturt(String kisi){
		this.kisiler[this.kacKisiVar()]=kisi;
	}
	
	public String[] oku(){
		return kisiler;
	}
	
	public int kacKisiVar(){
		int i = 0;
		while(kisiler[i]!=null){
			i++;
			if(i==kisiler.length)
				return i;
		}
		return i;
	}
	
	public int masaDolulukYuzdesi(){
		return (int)(100/((double)masadakiKisiSayisi/this.kacKisiVar()));
	}
}
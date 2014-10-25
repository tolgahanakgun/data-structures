public class masa{
	String[] kisiler;
	
	public masa(int masadaOturacakKisiSayisi){
		kisiler = new String[masadaOturacakKisiSayisi];
	}
	
	public void masayaOturt(String kisi){
		this.kisiler[this.kacKisiVar()]=kisi;
	}
	
	public String[] oku(){
		return kisiler;
	}
	
	private int kacKisiVar(){
		int i = 0;
		while(kisiler[i]!=null) i++;
		return i;
	}
}
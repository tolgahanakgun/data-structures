
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		randomNames rnmsNames = new randomNames();
		for (String str: rnmsNames.isimleriOku(90)) System.out.println(++i+". "+str);
	}

}

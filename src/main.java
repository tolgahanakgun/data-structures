
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		randomNames rnmsNames = new randomNames();
		String[] yazdirilacaklarStrings = rnmsNames.isimleriOku();
		int i = 1;
		for (String string : yazdirilacaklarStrings) {
			System.out.println(i+". "+string);
			i++;
		}
	}

}

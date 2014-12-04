package dataProject2;

import java.util.Comparator;


public class ArabaComparator implements Comparator<Araba> {

	@Override
	public int compare(Araba o1, Araba o2) {
		
		if(o1.beklemeSuresi < o2.beklemeSuresi)
			return -1;
		if(o1.beklemeSuresi > o2.beklemeSuresi)
			return 1;
		return 0;
	}
	
}

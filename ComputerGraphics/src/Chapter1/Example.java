package Chapter1;

/**
 * Math with decimals does not always turn out to be
 * exact. Sometimes it is just close enough.
 */
public class Example {
	public static void main (String[] args) {
		float f1 = 0.999f;
		float f2 = 1.1f;
        
		double d1 = f1 + 0.001;
		double d2 = f2 - 0.1;
        
		//d1 != d2 as would be expected
		if (d1 == d2) System.out.println("d1 == d2");
		else System.out.println(d1+" != "+d2);
	}
}
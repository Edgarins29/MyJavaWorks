public class Fxs {
	public static double Fx(int num, double x) {
		switch(num) {
			case 0: return x;
			case 1: return Math.pow(x, 2);
			case 2: return Math.sin(x);
			case 3: return Math.sin(3*x) + Math.cos(x) - Math.sin(x);
			case 4: return 2 * Math.sin(x) + (x / 2);
			case 5: return Math.cos(Math.pow(x, 2)) - Math.sin(x);
			default: return 0;
		}
	}
	
	private static String[] strFxs = {"y = x", "y = x^2", "y = sin(x)", "y = sin(3x)+sin(x)-sin(x)", "y = 2sin(x)+(x/2)", "y = cos(x^2)-sin(x)"};
	//private static String funkcija = "";
	
	public static String StrFx(int num) {
		return strFxs[num];
	}
	
	public static int GetNumOfFxs() {
		return strFxs.length;
	}
}

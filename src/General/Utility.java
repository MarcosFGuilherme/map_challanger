package General;

public class Utility {

	public static final int TAM = 15;
	
	public static String stringFix(String str) {
		for (int i = 1; i <= TAM; i++) {
			str += " ";
		}
		return str.substring(0, TAM);
	}
	
	public static String stringFix(String str, int tam, String rep) {
		for (int i = 1; i <= tam; i++) {
			str += rep;
		}
		return str.substring(0, tam);
	}
	

}
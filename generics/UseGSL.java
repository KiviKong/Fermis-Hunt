package generics;

public class UseGSL {
	
	public static void main(String[] args) {
		GSL<String> gsl = new GSL<String>();
		
		System.out.println(gsl.isEmpty());
		
		gsl.add("H");
		gsl.push("o");
		gsl.add("i");
		
		gsl.insert(2, "l");	
		
		// Imprime el valor del nodo que sale
		System.out.println(gsl.pop());
		gsl.add("i");
		
		// Imprime el valor del nodo que sale
		System.out.println(gsl.remove(0));
		
		gsl.insert(0, "H");
		
		System.out.println(gsl.toString());
		
		gsl.add(" :D");
		
		System.out.println(gsl.toString());
		System.out.println(gsl.get(2));
		
		System.out.println("Nodos usados: " + gsl.size());
	}

}
// Added a coment
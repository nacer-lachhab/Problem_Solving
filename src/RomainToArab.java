import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomainToArab {
	public static void main(String[] args) {
		
		Map<Character, Integer> tab = new HashMap<>();
		
		tab.put('i', 1);
		tab.put('v', 5);
		tab.put('x', 10);
		tab.put('l', 50);
		tab.put('c', 100);
		tab.put('d', 500);
		tab.put('m', 1000);
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().toLowerCase();

		if(input.indexOf("v")!= -1 && input.indexOf("v")!=input.lastIndexOf("v")) {
			System.out.println("lettre v duppliqué");
			System.out.println(input.indexOf("v"));
			System.exit(-1);
		}
		if(input.indexOf("l")!= -1 && input.indexOf("l")!=input.lastIndexOf("l")) {
			System.out.println("lettre l duppliqué");
			System.exit(-1);
		}
		if(input.indexOf("d")!= -1 && input.indexOf("d")!=input.lastIndexOf("d")) {
			System.out.println("lettre d duppliqué");
			System.exit(-1);
		}
		
		int somme;
		int i=1;
		
		//tester si un symbole est duplique 3fois
		for(int j=0;j<input.length();j++) {
			int cmpt = 1; 
			for(int k=j+1;k<input.length();k++) {
				if(input.charAt(k)==input.charAt(j)) {
					cmpt++;
					if(cmpt==4) {
						System.out.println(input.charAt(k) +"4fois");
						System.exit(-1);
					}
				}
			}
		}
		
		if(input.length()>2	) {
			somme = tab.get(input.charAt(0));
			while(i<=input.length()-1) {
				 int temp_i0 = tab.get(input.charAt(i));
				 int temp_i1 = tab.get(input.charAt(i+1));
				 if(temp_i0>=temp_i1) 
					 somme=somme + temp_i1 + temp_i0;
				 else
					 somme=somme + temp_i1 - temp_i0;
				 i=i+2; 
			}
			if(i==input.length()+1) {
				int temp_i0 = tab.get(input.charAt(i-2));//deja calculé dans somme
				int temp_i1 = tab.get(input.charAt(i-1));//loopé, non calculé 
				if(temp_i0>temp_i1)
					somme = somme + temp_i1;
				else
					somme = (somme - temp_i0) + (temp_i1-temp_i0);
			}
		}
		else {
			int temp_i0 = tab.get(input.charAt(0));//deja calculé dans somme
			int temp_i1 = tab.get(input.charAt(1));//loopé, non calculé 
			if(temp_i0>temp_i1)
				somme = temp_i0 + temp_i1;
			else
				somme = temp_i1-temp_i0;
		}
		System.out.println(somme);
	}
}

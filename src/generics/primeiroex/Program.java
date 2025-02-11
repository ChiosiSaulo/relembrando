package generics.primeiroex;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many values? ");
		int n = sc.nextInt();
		
		PrintService service = new PrintService();
		
		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			service.addValue(value);
		}
		
		service.print();
		
		System.out.println("First: " + service.firts());
		
		
		sc.close();

	}
}

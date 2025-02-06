package arquivos.fixacao.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import arquivos.fixacao.entities.Product;

public class Program {

	public static void main(String[] args) {
		String path = "C:\\temp\\ws-java-completo-revendo\\revendo\\source.csv";
		String suf = "\\source.csv";
		String targetPath1 = "";
		String targetPath2 = "";
		if (path.endsWith(suf)) {
			targetPath1 = path.substring(0, path.length() - suf.length());
			targetPath2 = targetPath1 + "\\out\\summary.csv";
        }
		new File(targetPath1 + "\\out").mkdir();
		
		List<Product> list = new ArrayList<>();
		/* List<String> lines = new ArrayList<>(); */
		
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quant = Integer.parseInt(fields[2]);
				
				list.add(new Product(name, price, quant));
				
				line = br.readLine();
			}
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath2))){
				for(Product p : list) {
					bw.write(p.toString());
					bw.newLine();
				}
			}
			catch(IOException e) {
				System.out.println("Error writer:" + e.getMessage());;
			}
			
		}
		
		catch(IOException e) {
			System.out.println("Error reader:" + e.getMessage());;
		}
		for(Product p : list) {
			System.out.println(p);
		}
		
		
	}

}

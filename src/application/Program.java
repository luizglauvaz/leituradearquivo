package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Produto;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual é o caminho do arquivo a ser lido?");
		String strPath = sc.nextLine();
		File path = new File(strPath);
		List<Produto> list = new ArrayList<>();
		boolean path2 = new File(path.getParent() + "\\out").mkdir();
				
		try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
			String line = br.readLine();
			while (line != null) {
			String[] parts = line.split(",");
			String nome = parts[0];
			double preco = Double.parseDouble(parts[1]);
			int quantidade = Integer.parseInt(parts[2]);
			
			list.add(new Produto(nome, preco, quantidade));
			
			line = br.readLine();
			}
			} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			} 
		
		
				
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.getParent() + "\\out\\sumary.csv"))) {
			for (Produto lists : list) {
			bw.write(lists.toString());
			bw.newLine();
			}
			} catch (IOException e) {
			e.printStackTrace();
			}
	
		sc.close();
	}
}
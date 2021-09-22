package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		// E preciso criar a pasta e o arquivo
		String caminhoDoArquivo = "C:\\temp\\in.txt";
		String saidaDoArquivo = "C:\\temp\\out.csv";
		List<Funcionario> list = new ArrayList<>();
		try {
			lerArquivo(caminhoDoArquivo, list);

			// Para percorre a lista
			// for(int i = 0; i< list.size() ;i++){
			// System.out.println(list.get(i));
			// System.out.println(list.indexOf(list.get(0)));
			// }

			list.remove(list.indexOf(list.get(0)));
			list.remove(list.indexOf(list.get(9)));

			escreverArquivo(saidaDoArquivo, list);

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		System.out.println("==========================");
		System.out.println("==========================");
		lerArquivo(saidaDoArquivo, list);
	}

	public static void lerArquivo(String caminhoDoArquivo, List<Funcionario> list) {
		try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
			int cont = 0;
			String linha = br.readLine();
			while (linha != null) {
				String[] linhas = linha.split(",");
				System.out.println(cont++ + " " + linha);
				list.add(new Funcionario(linhas[0], Double.parseDouble(linhas[1])));
				linha = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public static void escreverArquivo(String saidaDoArquivo, List<Funcionario> list) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(saidaDoArquivo))) {
			for (Funcionario escrever : list) {
				bw.write(escrever.getNome() + "," + escrever.getSalario());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}

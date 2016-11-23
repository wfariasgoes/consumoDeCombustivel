import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Veiculo> lVeiculos = new ArrayList<>();
		File arquivoCombustivel = new File("/Users/wesleygoes/Desafio/LogCombustivel.csv");

		try {

			String linhasArquivoCSV = null;
			Scanner leitorDados = new Scanner(arquivoCombustivel);

			while (leitorDados.hasNext()) {
				linhasArquivoCSV = leitorDados.nextLine();
				String[] item = linhasArquivoCSV.split(",");
				String marcaCarro = item[0].replace("\"", "");

				Controlador control = new Controlador();
				control.carregarDados(marcaCarro, item, lVeiculos);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}

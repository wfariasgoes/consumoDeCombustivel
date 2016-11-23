import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Controlador {

	public void carregarDados(String marcaCarro, String[] item, ArrayList<Veiculo> lVeiculos){
		CarregaListaGastos controlegastos = new CarregaListaGastos();
		List<Veiculo> listaDeVeiculos = controlegastos.addDadosNaLista(marcaCarro, item, lVeiculos);
		double soma =0;
		for (int i = 0; i < lVeiculos.size(); i++) {
			System.out.println(lVeiculos.get(i).getPreco());
			soma += lVeiculos.get(i).getPreco();
		}
		System.out.println("Total de gás ");
	}

	 
}

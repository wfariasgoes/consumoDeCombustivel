import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarregaListaGastos {

	public List<Veiculo> addDadosNaLista(String marcaCarro, String[] item, ArrayList<Veiculo> lVeiculos) {
		Veiculo veiculo = new Veiculo();
		if (marcaCarro.equals("Honda") || marcaCarro.equals("Ford")) {
			veiculo.setMarca(removeAspas(item[0]));
			veiculo.setModelo(removeAspas(item[1]));
			veiculo.setData(Date.valueOf(removeAspas(item[2])));
			veiculo.setQuilometragem(Double.valueOf(removeAspas(item[3])));
			veiculo.setCombustivel(Double.valueOf(removeAspas(item[4])));
			veiculo.setPreco(Double.valueOf(removeAspas(item[5])));
			lVeiculos.add(veiculo);
		}
		return lVeiculos;

	}

	public String removeAspas(String conteudo) {
		return conteudo.replace("\"", "");
	}

}

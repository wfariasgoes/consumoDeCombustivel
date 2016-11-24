import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Controlador {

	public void carregarDados(String marcaCarro, String[] item, ArrayList<Veiculo> lVeiculos) {
		CarregaListaGastos controlegastos = new CarregaListaGastos();
		List<Veiculo> listaDeVeiculos = controlegastos.addDadosNaLista(marcaCarro, item, lVeiculos);

		ArrayList<ConsumoDeGasolina> consumos = new ArrayList<ConsumoDeGasolina>();
		for (Veiculo veiculo : listaDeVeiculos) {
			 ConsumoDeGasolina consumoDeGasolina = new ConsumoDeGasolina();
			 
			 consumoDeGasolina.setMarcaCarro(veiculo.getMarca());
			 consumoDeGasolina.setModeloCarro(veiculo.getModelo());
			 consumoDeGasolina.setCarroKM(111);
			 consumoDeGasolina.setValorGasto(12.00);
			 consumoDeGasolina.setLitros(123.00);
			 consumoDeGasolina.setDataInicial(buscaPrimeiroAbastecimento(veiculo.getData(),listaDeVeiculos));
			 consumoDeGasolina.setIntervaloDeDias(22);
			 consumoDeGasolina.setMediaCombutivelKM(65);
			 consumoDeGasolina.setPiorConsumoKM(123.12);
			 consumoDeGasolina.setMelhorConsumoKM(322.00);
			 consumoDeGasolina.setValorGastoKmL(222.00);
			 consumos.add(consumoDeGasolina);
		}
		gerarRelatorio(consumos);
	}

	private void gerarRelatorio(List<ConsumoDeGasolina> listaDeConsumo){
		try{
			BufferedWriter strWriter = new BufferedWriter(new FileWriter("/Users/wesleygoes/Desafio/Relatorio.csv"));
			
			//windows
//			BufferedWriter StrW = new BufferedWriter(new FileWriter("C:\\Relatorio.csv"));
			
			strWriter.write("\"MARCA\",\"MODELO\",\"KM\",\"R$\",\"LITROS\",\"DATAINI\",\"DIAS\",\"MEDIAKM/L\",\"PIORKM/L\",\"MELHORKM/L\",\"R$/KM\"" + "\r\n"); 
			for (ConsumoDeGasolina consumo : listaDeConsumo){
				strWriter.write("\""+consumo.getMarcaCarro()+"\",\""+consumo.getModeloCarro()+"\",\""+consumo.getCarroKM()+"\",\""+consumo.getLitros()+"\",\""+consumo.getDataInicial()+
						"\",\""+consumo.getIntervaloDeDias()+"\",\""+consumo.getMediaCombutivelKM()+"\",\""+consumo.getPiorConsumoKM()+"\",\""+consumo.getMelhorConsumoKM()+
						"\",\""+consumo.getValorGastoKmL()+"\n");
			}
			strWriter.close(); 
			System.out.println("Documento exportado!");
		}
		catch (RuntimeException | IOException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	/*
	 * Método para buscar o primeiro abastecimento
	 * */
	private LocalDate buscaPrimeiroAbastecimento(LocalDate data,List<Veiculo> listaDeVeiculos) {
		 
		Veiculo lastContact = Collections.max(listaDeVeiculos, Comparator.comparing(c -> c.getData()));
		System.out.println("max "+lastContact);
		return data;
	}

	/*
	 * Método para buscar o pmelhor registro por Km/L
	 * */
	float calculaMelhorKmL(List<Veiculo> abastecimentos){
		float valorAtual = 0;
		float melhorKmL = 0;
		
		List<Veiculo> listaDeAbastecimentos = abastecimentos;
		
		for (int index = 1; index < listaDeAbastecimentos.size(); index++){
			float kmPercorrido = (float) (listaDeAbastecimentos.get(index).getQuilometragem() - listaDeAbastecimentos.get(index - 1).getQuilometragem());
			valorAtual = (float) (kmPercorrido / listaDeAbastecimentos.get(index - 1).getCombustivel());

			if ((melhorKmL == 0) || (valorAtual > melhorKmL)){
				melhorKmL = valorAtual;
			}
		}
		return melhorKmL;
	}

	/*
	 * Método para buscar o pior registro por Km/L
	 * */
	private float calculaPiorKmL(List<Veiculo> abastecimentos) {
		float valorAtual = 0;
		float piorKmL = 0;
		List<Veiculo> listaDeAbastecimentos = abastecimentos;

		for (int index = 1; index < listaDeAbastecimentos.size(); index++) {
			float kmPercorrido = (float) (listaDeAbastecimentos.get(index).getQuilometragem() - listaDeAbastecimentos.get(index - 1).getQuilometragem());
			valorAtual = (float) (kmPercorrido / listaDeAbastecimentos.get(index - 1).getCombustivel());

			if ((piorKmL == 0) || (valorAtual < piorKmL)) {
				piorKmL = valorAtual;
			}
		}
		return piorKmL;
	}

}

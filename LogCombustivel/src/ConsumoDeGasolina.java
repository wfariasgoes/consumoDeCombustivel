import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ConsumoDeGasolina{
	private String marcaCarro;
	private String modeloCarro;
	private float carroKM;
	private double valorGasto;
	private double litros;
	private Date dataInicial;
	private int intervaloDeDias;
	private double mediaCombutivelKM;
	private double piorConsumoKM;
	private double melhorConsumoKM;
	private double valorGastoKmL;
	
	
	public String getMarcaCarro() {
		return marcaCarro;
	}
	public void setMarcaCarro(String marcaCarro) {
		this.marcaCarro = marcaCarro;
	}
	public String getModeloCarro() {
		return modeloCarro;
	}
	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
	public float getCarroKM() {
		return carroKM;
	}
	public void setCarroKM(float carroKM) {
		this.carroKM = carroKM;
	}
	public double getValorGasto() {
		return valorGasto;
	}
	public void setValorGasto(double valorGasto) {
		valorGasto = valorGasto;
	}
	public double getLitros() {
		return litros;
	}
	public void setLitros(double litros) {
		this.litros = litros;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public int getIntervaloDeDias() {
		return intervaloDeDias;
	}
	public void setIntervaloDeDias(int intervaloDeDias) {
		this.intervaloDeDias = intervaloDeDias;
	}
	public double getMediaCombutivelKM() {
		return mediaCombutivelKM;
	}
	public void setMediaCombutivelKM(double mediaCombutivelKM) {
		this.mediaCombutivelKM = mediaCombutivelKM;
	}
	public double getPiorConsumoKM() {
		return piorConsumoKM;
	}
	public void setPiorConsumoKM(double piorConsumoKM) {
		this.piorConsumoKM = piorConsumoKM;
	}
	public double getMelhorConsumoKM() {
		return melhorConsumoKM;
	}
	public void setMelhorConsumoKM(double melhorConsumoKM) {
		this.melhorConsumoKM = melhorConsumoKM;
	}
	public double getValorGastoKmL() {
		return valorGastoKmL;
	}
	public void setValorGastoKmL(double valorGastoKmL) {
		valorGastoKmL = valorGastoKmL;
	}
	
	 
	 
 }
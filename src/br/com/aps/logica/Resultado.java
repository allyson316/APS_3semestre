package br.com.aps.logica;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Resultado {
	
	//atributos
	private long tempoGasto;
	private long quantidadeTroca;
	private long quantidadeComparacao;
	
	//construtor vazio
	public Resultado(){
	}
	
	//construtor com parametros
	public Resultado(long tempoGasto,long quantidadeTroca, long quantidadeComparacao){
		this.tempoGasto = tempoGasto;
		this.quantidadeTroca = quantidadeTroca;
		this.quantidadeComparacao = quantidadeComparacao;
	}

	public long getTempoGasto() {
		return tempoGasto;
	}

	public void setTempoGasto(long tempoGasto) {
		this.tempoGasto = tempoGasto;
	}

	public long getQuantidadeTroca() {
		return quantidadeTroca;
	}

	public void setQuantidadeTroca(long quantidadeTroca) {
		this.quantidadeTroca = quantidadeTroca;
	}

	public long getQuantidadeComparacao() {
		return quantidadeComparacao;
	}

	public void setQuantidadeComparacao(long quantidadeComparacao) {
		this.quantidadeComparacao = quantidadeComparacao;
	}
	
	public String toString(){
		return 
				"%nTempo de ordenação: "  + tempoGasto +
				"%nQuantidade de trocas: " + quantidadeTroca +
				"%nQuantidade de Comparações: " + quantidadeComparacao;
	}
	
	public PrintWriter geraArquivoResultado(String resultado) throws IOException{
		
		FileWriter arquivo = new FileWriter("C:/Users/M2M/Desktop/Resultados/arquivo.txt");
		PrintWriter gravarArq = new PrintWriter(arquivo);
		
		gravarArq.printf("-------------------------------------------------%n");
		gravarArq.printf("--------------------Resultado--------------------%n");
		gravarArq.printf("-------------------------------------------------%n");
		gravarArq.printf(toString());
		
		arquivo.close();
		
		return gravarArq;
	}
}

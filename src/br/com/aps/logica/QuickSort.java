package br.com.aps.logica;
import java.io.File;

public class QuickSort{
	private long tempoInicio = 0;
	private long quantidadeTroca = 0;
	private long quantidadeComparacao = 0;

//-------------------------------------------------------------Ordenando Inteiros---------------------------------------------------------------------
	public Resultado quickSortInteiros (int[] v){
		
		//calcular o tempo de ordenação - marca o tempo de inicio
		tempoInicio = CalculaTempo.tempoInicial(tempoInicio);
		
		ordenarInteiro(v, 0, v.length - 1);
		
		//calcula o tempo total de ordenação
		tempoInicio = CalculaTempo.tempoTotal(tempoInicio);
		
		//Constrói o resultado
		Resultado resultadoQuickSort = new Resultado(tempoInicio, quantidadeTroca, quantidadeComparacao);
		
		return resultadoQuickSort;
	}
	
	
	public int[] ordenarInteiro(int[] v, int esquerda, int direita) {
		
		//esquerda recebe inicio do vetor
		int esq = esquerda;
		//direita recebe o fim do vetor
		int dir = direita;
		//pivo recebe o meio do vetor
		int pivo = v[(esq + dir) / 2];
		//variável auxiliar na torca
		int troca;
		//enquanto a variavel que armazena o indice de inicio do vetor for menor ou igual a variavel que armazena o fim o laço se manterá
		while (esq <= dir) {
			//avalia se o valor que está na posição anterior é menor que o pivo, se for menor não há troca e passa para a proxima posiçao
			while (v[esq] < pivo) {
				esq = esq + 1;
				quantidadeComparacao++;
			}
			//avalia se o valor que está no indice "dir" é maior que o pivo
			while (v[dir] > pivo) {
				dir = dir - 1;
				quantidadeComparacao++;
			}
			//se o numero da posicao anterior for maior que o da outra posicao, sera realizada a troca de posiçoes
			if (esq <= dir) {
				troca = v[esq];
				v[esq] = v[dir];
				v[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;
				quantidadeTroca++;
			}
		}
		//Chama o proprio metodo de maneira recursiva pra ordenar o vetor do incio ate o "meio"
		if (dir > esquerda){
			ordenarInteiro(v, esquerda, dir);
		}
		//Chama o proprio metodo de maneira recursiva pra ordenar o vetor do fim ate o "meio"
		if (esq < direita){
			ordenarInteiro(v, esq, direita);
		}
						
		return v;
	}	
	
	
//----------------------------------------------------------------Ordenação de Arquivos---------------------------------------------------------------
	public Resultado quickSortArquivos (File[] v){
		
		//calcular o tempo de ordenação - marca o tempo de inicio
		tempoInicio = CalculaTempo.tempoInicial(tempoInicio);
		
		ordenarArquivo(v, 0, v.length - 1);
		
		//calcula o tempo total de ordenação
		tempoInicio = CalculaTempo.tempoTotal(tempoInicio);
		
		//Constrói o resultado
		Resultado resultadoQuickSort = new Resultado(tempoInicio, quantidadeTroca, quantidadeComparacao);
		
		return resultadoQuickSort;
	}
	
	
	public static File[] ordenarArquivo(File[] v, int esquerda, int direita) {
		
		int esq = esquerda;
		int dir = direita;
		File pivo = v[(esq + dir) / 2];
		File troca;
		while (esq <= dir) {
			while (v[esq].length() < pivo.length()) {
				esq = esq + 1;
			}
			while (v[dir].length() > pivo.length()) {
				dir = dir - 1;
			}
			if (esq <= dir) {
				troca = v[esq];
				v[esq] = v[dir];
				v[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;
			}
		}
		if (dir > esquerda)
			ordenarArquivo(v, esquerda, dir);
		if (esq < direita)
			ordenarArquivo(v, esq, direita);
						
		return v;
	}
}

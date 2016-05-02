package br.com.aps.logica;
import java.io.File;

public class QuickSort{
	private long tempoInicio = 0;
	private long quantidadeTroca = 0;
	private long quantidadeComparacao = 0;

//-------------------------------------------------------------Ordenando Inteiros---------------------------------------------------------------------
	public Resultado quickSortInteiros (int[] v){
		
		//calcular o tempo de ordena��o - marca o tempo de inicio
		tempoInicio = CalculaTempo.tempoInicial(tempoInicio);
		
		ordenarInteiro(v, 0, v.length - 1);
		
		//calcula o tempo total de ordena��o
		tempoInicio = CalculaTempo.tempoTotal(tempoInicio);
		
		//Constr�i o resultado
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
		//vari�vel auxiliar na torca
		int troca;
		//enquanto a variavel que armazena o indice de inicio do vetor for menor ou igual a variavel que armazena o fim o la�o se manter�
		while (esq <= dir) {
			//avalia se o valor que est� na posi��o anterior � menor que o pivo, se for menor n�o h� troca e passa para a proxima posi�ao
			while (v[esq] < pivo) {
				esq = esq + 1;
				quantidadeComparacao++;
			}
			//avalia se o valor que est� no indice "dir" � maior que o pivo
			while (v[dir] > pivo) {
				dir = dir - 1;
				quantidadeComparacao++;
			}
			//se o numero da posicao anterior for maior que o da outra posicao, sera realizada a troca de posi�oes
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
	
	
//----------------------------------------------------------------Ordena��o de Arquivos---------------------------------------------------------------
	public Resultado quickSortArquivos (File[] v){
		
		//calcular o tempo de ordena��o - marca o tempo de inicio
		tempoInicio = CalculaTempo.tempoInicial(tempoInicio);
		
		ordenarArquivo(v, 0, v.length - 1);
		
		//calcula o tempo total de ordena��o
		tempoInicio = CalculaTempo.tempoTotal(tempoInicio);
		
		//Constr�i o resultado
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

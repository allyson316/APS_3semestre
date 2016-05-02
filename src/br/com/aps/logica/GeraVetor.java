package br.com.aps.logica;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GeraVetor {
	
	
	public int[] vetorAleatorio(int tamanho) {
		
		int[] vetor = new int[tamanho];
		
		//instanciando classe Random para gerar numeros aleatorios
		Random  numAleatorio= new Random();
		for (int i = 0; i < tamanho; i++) 
		{
			//gerando numeros aleatorios e atribuindo a posicao i do vetor
			vetor[i] = numAleatorio.nextInt(tamanho);
		}
		return vetor;
	}
	
	
	public int[] vetorCrescente(int tamanho) {
		
		int[] vetor = new int[tamanho];
		
		//Chama o metodo vetorAleatorio criando um vetor de numeros aleatorios
		//porém desordenado.
		vetor = vetorAleatorio(tamanho);
		
		//Organizando o vetor em ordem crescente
		Arrays.sort(vetor);
		return vetor;
	}
	
	
	public int[] vetorDecrescente(int tamanho){
	
		int[] vetor = new int[tamanho];
		
		//fazendo uso novamente do metodo vetorAleatorio
		vetor = vetorAleatorio(tamanho);
		
		//criando um vetor de string para fazer conversao;
		String[] vetorConvert = new String[tamanho];
		
		//convertendo elemento a elemento para string e atribuindo ao vetor 
		//de String
		for(int i = 0; i < tamanho; i++){
			vetorConvert[i] =  Integer.toString(vetor[i]);
		}
		
		//Usando metodo para ordenação decrescente(Só funciona com string, por isso os dados
		//tiveram que ser convertidos para String)
		Arrays.sort(vetorConvert, Collections.reverseOrder());
		
		//Devolvendo convertido para o vetor de inteiros
		for(int i = 0; i < tamanho; i++)
		{
			vetor[i] = Integer.parseInt(vetorConvert[i]);
		}
		return vetor;
		
	}
}

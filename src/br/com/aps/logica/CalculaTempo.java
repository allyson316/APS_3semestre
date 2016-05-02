package br.com.aps.logica;

public class CalculaTempo {
	
	//método estatico utilizo sem nescessidade de instanciar um objeto
	public static long tempoInicial(long tempoInicio){
		
		//tempoInicio recebe tempo atual do sistema
		tempoInicio = System.currentTimeMillis();
		
		return tempoInicio;
	}
	
	public static long tempoTotal(long tempoInicio){
		
		//tempo total é calculado: tempo atual - tempoInicio
		long tempoTotal = System.currentTimeMillis() - tempoInicio;
		
		return tempoTotal;
	}
}

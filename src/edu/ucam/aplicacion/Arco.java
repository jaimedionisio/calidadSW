package edu.ucam.aplicacion;

import java.io.IOException;
import java.io.Writer;

public class Arco extends Arma {

	//Variables
	
	private int flechas;

	//Getter y Setters
	
	public int getFlechas() {
		return flechas;
	}
	
	public void setFlechas(int flechas) {
		this.flechas = flechas;
	}
	
	//constructor 
	
	

	public Arco(String nombreArma, float pesoArma, float longitudArma, int flechas) {
		super(nombreArma, longitudArma, longitudArma);
		this.flechas = flechas;
	}

	//Métodos
	public int fuerzaArma() {
		return (int) (30 + this.longitudArma);		
	}
	public void MostrarInfo(){
		System.out.println("ID: " + this.getIdArma() + "\n Tipo Arco       Nombe:"+this.nombreArma+ " - Peso: " + this.pesoArma +"Gramos - Logitud: "+ this.longitudArma + "Ctms - Flechas: " + this.flechas + " - Fuerza: " + this.fuerzaArma());
	}
	
	public void escribirArma(Writer w)
	{
		try
		{
			super.escribirArma(w);
			w.write(";");
			w.write(String.valueOf(flechas));			
				
			
		} catch (IOException e) {
		    System.err.println("Problem writing to the file statsTest.txt");
		}
	}	
	
}
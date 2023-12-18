package edu.ucam.aplicacion;

import java.io.IOException;
import java.io.Writer;

public class CaminanteBlanco extends Personaje {

	//Variables
	private boolean inmuneALaLuz;
	private int escalaRaza;

	//Getters y Setters
	
	public boolean esInmuneALaLuz() {
		return inmuneALaLuz;
	}

	public void setInmuneALaLuz(boolean inmuneALaLuz) {
		this.inmuneALaLuz = inmuneALaLuz;
	}

	public int getEscalaRaza() {
		return escalaRaza;
	}

	public void setEscalaRaza(int escalaRaza) {
		this.escalaRaza = escalaRaza;
	}
	
	
	//Constructor
	public CaminanteBlanco(String nombrePersonaje, int edadPersonaje, Arma armaPersonaje, boolean inmuneALaLuz, int escalaRaza) {
		super(nombrePersonaje, edadPersonaje, armaPersonaje);
		this.inmuneALaLuz = inmuneALaLuz;
		if (escalaRaza >= 1 && escalaRaza<=3){
			this.escalaRaza = escalaRaza;
		}
		else
		{
			System.out.println("Error: La escala de la Raza debe estar comprendida entre 1 y 3");
		}
	}

	//Métodos
	public int fuerzaPersonaje() {
		return((this.armaPersonaje.fuerzaArma()) * (this.escalaRaza));
	}
	public void MostrarInfo(){
		System.out.println("ID: " + this.getIdPersonaje() + " Caminante Blanco: "+this.nombrePersonaje+ " - Edad: " + this.edadPersonaje +" años - Arma: "+ this.armaPersonaje.nombreArma + " - Es Inmune a la luz: " + this.inmuneALaLuz +" - Escala en la raza de " + this.escalaRaza + " - Fuerza: " + this.fuerzaPersonaje() );
	}
	
	public void escribirPersonaje(Writer w)
	{
		try
		{
			super.escribirPersonaje(w);
			w.write(";");
			w.write(String.valueOf(inmuneALaLuz));
			w.write(";");
			w.write(String.valueOf(escalaRaza));
				
			
		} catch (IOException e) {
		    System.err.println("Problem writing to the file statsTest.txt");
		}
	}	

}
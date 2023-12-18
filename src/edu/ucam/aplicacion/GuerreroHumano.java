package edu.ucam.aplicacion;

import java.io.IOException;
import java.io.Writer;

public class GuerreroHumano extends Personaje {

	//variables
	
	
	private Reino reinoNacimiento;
	private int expGuerra;
	
	
	//constructor
	
	public GuerreroHumano(String nombrePersonaje, int edadPersonaje, Arma armaPersonaje, Reino reinoNacimiento, int expGuerra) {
		super(nombrePersonaje, edadPersonaje, armaPersonaje);
		this.reinoNacimiento = reinoNacimiento;
		this.expGuerra = expGuerra; 
		
	}
	
	//Getters y Setters
	
	
	public Reino getReinoNacimiento() {
		return reinoNacimiento;
	}

	public void setReinoNacimiento(Reino reinoNacimiento) {
		this.reinoNacimiento = reinoNacimiento;
	}


	public int getExpGuerra() {
		return expGuerra;
	}


	public void setExpGuerra(int expGuerra) {
		if (expGuerra>=0 && expGuerra<=0){
			this.expGuerra = expGuerra;
		}
		else
		{
			System.out.println("ERROR La experiencia de guerra debe estar comprendida entre 0 y 100");
		}
	}

	// M�todos
	
	public int fuerzaPersonaje() {
		return((this.armaPersonaje.fuerzaArma()) * (this.expGuerra/this.edadPersonaje));
		
	}
	public void MostrarInfo(){
		System.out.println("ID: " + this.getIdPersonaje() + " Guerrero Humano: "+this.nombrePersonaje+ " - Edad: " + this.edadPersonaje +" a�os - Arma: "+ this.armaPersonaje.nombreArma + " - Reino: " + this.reinoNacimiento.getNombreReino() +" - Exp Guerra de  " + this.expGuerra + " - Fuerza: " + this.fuerzaPersonaje()  );
	}
	
	public void escribirPersonaje(Writer w)
	{
		try
		{
			super.escribirPersonaje(w);
			w.write(";");
			w.write(String.valueOf(reinoNacimiento.getIdReino()));
			w.write(";");
			w.write(String.valueOf(expGuerra));
				
			
		} catch (IOException e) {
		    System.err.println("Problem writing to the file statsTest.txt");
		}
	}	

}
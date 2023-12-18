package edu.ucam.aplicacion;

public class Hacha extends Arma {
	
	//Constructor
	
	public Hacha(String nombreArma, float pesoArma, float longitudArma) {
		super(nombreArma, longitudArma, longitudArma);
	}
	
	//Metodos
	
	public int fuerzaArma() {
		return (int) (80-(3*Math.pow((this.pesoArma/1000),2)));
	}
	public void MostrarInfo(){
		System.out.println("ID: " + this.getIdArma() + "\n Tipo Hacha      Nombe:"+this.nombreArma+ " - Peso: " + this.pesoArma +"Gramos - Logitud: "+ this.longitudArma + "Ctms" + " - Fuerza: " + this.fuerzaArma());
	}

}
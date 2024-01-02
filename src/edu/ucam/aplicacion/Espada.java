package edu.ucam.aplicacion;

public class Espada extends Arma {

	//Constructor
	public Espada(String nombreArma, float pesoArma, float longitudArma) {
		super(nombreArma, longitudArma, longitudArma);
	}
	
	//Metodos de la clase
	public int fuerzaArma() {
		return (int) (30 + this.longitudArma);
	}
	public void MostrarInfo(){
		System.out.println("ID: " + this.getIdArma() + "\n Tipo Espada     Nombe:"+this.nombreArma+ " - Peso: " + this.pesoArma +"Gramos - Logitud: "+ this.longitudArma + "Ctms" + " - Fuerza: " + this.fuerzaArma());
	}
	
}
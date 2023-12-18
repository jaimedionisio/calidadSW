package edu.ucam.aplicacion;

import java.io.IOException;

import java.io.Writer;
import java.util.*;

public class Ejercito {

//Variables
	private int idEjercito;
	private static int idSiguienteEjercito= 1;
	private String nombreEjercito;
	private Personaje capitan;
	public Set <Personaje> ColeccionSoldados = new HashSet<Personaje>() ;
	public static Set <Ejercito> ColeccionEjercitos = new HashSet<Ejercito>();
	
	//Getter y Setter
	public String getNombreEjercito() {
		return this.nombreEjercito;
	}

	public void setNombreEjercito(String NombreEjercito) {
		this.nombreEjercito = NombreEjercito;
	}

	public Personaje getCapitan() {
		return this.capitan;
	}

	public void setCapitan(Personaje capitan) {
		this.capitan = capitan;
	}
		
	public int getIdEjercito() {
		return idEjercito;
	}

	//Constructor
	public Ejercito(String nombreEjercito, Personaje capitan) {
		this.idEjercito = idSiguienteEjercito; //Asigno el siguiente ID a este Personaje
		Ejercito.idSiguienteEjercito++; //Aumneto 1 el valor para el ID del pr�ximo personaje
		this.nombreEjercito = nombreEjercito;
		this.capitan = capitan;
	}
	
	public Ejercito(String nombreEjercito) { // Este constructor lo uso para la carga inicial
		this.idEjercito = idSiguienteEjercito; //Asigno el siguiente ID a este Personaje
		Ejercito.idSiguienteEjercito++; //Aumneto 1 el valor para el ID del pr�ximo personaje
		this.nombreEjercito = nombreEjercito;
		
	}

	//M�todos
	public int FuerzaGlobal() {
		// TODO - implement Ejercito.FuerzaGlobal
		throw new UnsupportedOperationException();
	}
	
	public void MostrarInfo(){
		System.out.println("ID: " + this.idEjercito + "\nEjercito: "+ this.nombreEjercito + "\nCapitan: "+ this.capitan.nombrePersonaje + "\nFuerza del Ejercito: " + fuerzaEjercito());
		System.out.println("                       SOLDADOS:\n                       ***********************************");
		for (Personaje PersonajeTemp : this.ColeccionSoldados) {
			
			System.out.println("                           Id:" + PersonajeTemp.getIdPersonaje() + " Nombre: " + PersonajeTemp.nombrePersonaje+"");

		}
		System.out.println("                       ***********************************\n\n");
	}

	public static void listarEjercitos(){
		for (Ejercito EjercitoTemp : ColeccionEjercitos) {
			EjercitoTemp.MostrarInfo();
			//listarSoldadosEjercito(EjercitoTemp);
		}
	}
	
	public static boolean borrarEjercito(Ejercito EjercitoBorrar){
		boolean resultado = false;
		
		if (EjercitoBorrar != null){
			System.out.println("Se ha eliminado el siguiente elemento:\n");
			EjercitoBorrar.MostrarInfo();
			resultado = ColeccionEjercitos.remove(EjercitoBorrar);
		}
		//System.out.println(ArmaBorrar.nombreArma);
		return resultado;
		
	}
	
	public static Ejercito BuscarEjercito(int IdEjercito){
		
		for (Ejercito ejercitoTemp : ColeccionEjercitos) {
			if (ejercitoTemp.getIdEjercito() == IdEjercito) 
			{
				return ejercitoTemp;
			}
			
		}
		return null;
		
	}
	
	public static Ejercito crearEjercito()
	{
		Scanner entradaTeclado = new Scanner (System.in); //Creaci�n de un objeto Scanner
		
		String nombreEjercito= "";
		int capitanId = 0;
		Personaje Capitan;
		
		System.out.println("� Nombre del Ejercito? ");
		nombreEjercito = entradaTeclado.nextLine ();
		Personaje.listarPersonajes();
		System.out.println("�Id del Capitan Capitan? ");
		capitanId =Integer.parseInt(entradaTeclado.nextLine ());
		Capitan = Personaje.BuscarPersonaje(capitanId);	 
		Ejercito Ejercitotemp = null;
		Ejercitotemp = new Ejercito(nombreEjercito, Capitan);
        
        return Ejercitotemp;

	}

	public static void EditarEjercito(Ejercito EjercitoEditar){
		EjercitoEditar.MostrarInfo();
		int capitanId=0;
		Personaje capitan =null;
		Scanner entradaTeclado = new Scanner (System.in);
		int Eleccion;
		do{				
		System.out.println("Que campo quieres cambiar?\n1 Nombre del Ejercito\n2 Capitan\n3 Soldados"); 
		Scanner c2 = new Scanner(System.in);
		Eleccion = Integer.parseInt(c2.nextLine ());
		}while (Eleccion>3);
		
		System.out.println("Cual es el nuevo valor?\n"); 
		Scanner c3 = new Scanner(System.in);
		String CampoaEditar = c3.nextLine ();
		if(Eleccion == 1){
			EjercitoEditar.setNombreEjercito(CampoaEditar);
		}
		else if(Eleccion == 2){
			//Scanner entradaTeclado = new Scanner;
			Personaje.listarPersonajes();
			System.out.println("�Id del Nuevo Capitan? ");
			capitanId =Integer.parseInt(entradaTeclado.nextLine ());
			capitan = Personaje.BuscarPersonaje(capitanId);	
			EjercitoEditar.setCapitan(capitan);
		}
				
					
		 
	}
	
	public static void AnadirSoldado(Ejercito ejercito)
	{
		int problema=0;
		Personaje.listarPersonajes();
		System.out.println("Introduce el Id del Personaje que quieres a�adir como Soldado."); 
		Scanner c1 = new Scanner(System.in);
		int PersonajeABuscar2 = Integer.parseInt(c1.nextLine ());
		Personaje Soldado = Personaje.BuscarPersonaje(PersonajeABuscar2);
		if (Soldado.equals(ejercito.getCapitan())){
			System.out.println("No puedes a�adir el Personaje como Soldado ya que es el Capitan");
			problema=1;
		}
		if (!Soldado.getClass().equals(ejercito.getCapitan().getClass())){
			System.out.println("No puedes a�adir el Personaje como Soldado ya que no son del mismo Tipo");
			problema=1;
		}
		if (Soldado instanceof GuerreroHumano && ejercito.getCapitan() instanceof GuerreroHumano){
			if (!((GuerreroHumano) Soldado).getReinoNacimiento().equals(((GuerreroHumano) ejercito.getCapitan()).getReinoNacimiento())){
				System.out.println("No puedes a�adir el Personaje como Soldado ya no es del mismo Reino que el Capitan");
				problema=1;
			}
						
		}
		
		if(Soldado.edadPersonaje<30){
			System.out.println("No puedes a�adir el Personaje como Soldado ya que es menor de 30 a�os");
			problema=1;
		}
		
		if(Soldado.fuerzaPersonaje()<40){
			System.out.println("No puedes a�adir el Personaje como Soldado ya que es su fuerza es menor que 40");
			problema=1;
		}
		
		if (Soldado.getClass().equals(ejercito.getCapitan().getClass()) && problema == 0){
			System.out.println("Se ha a�adido como soldado el Personaje:\n");
			Soldado.MostrarInfo();
			ejercito.ColeccionSoldados.add(Soldado);
		}
		
						
		
	}
	
	public static void BorrarSoldado(Ejercito EjercitoPadre)
	{
		listarSoldadosEjercito(EjercitoPadre);
		System.out.println("Introduce el Id del Soldado que quieres Borrar del Ejercito."); 
		Scanner c1 = new Scanner(System.in);
		int SoldadoABuscar = Integer.parseInt(c1.nextLine ());
		Personaje Soldadonuevo = Personaje.BuscarPersonaje(SoldadoABuscar);
		System.out.println("Se ha quitado del ejercito el soldado:\n");
		Soldadonuevo.MostrarInfo();
		EjercitoPadre.ColeccionSoldados.remove(Soldadonuevo);
		
	}

	public static void listarSoldadosEjercito(Ejercito EjercitoPadre){
		
		
		for (Personaje SoldadoTemp : EjercitoPadre.ColeccionSoldados) {
			SoldadoTemp.MostrarInfo();
		}
				
	}
	
	public int fuerzaEjercito () {
		int fuerza=0;
		
				fuerza = fuerza + this.capitan.fuerzaPersonaje();
				for (Personaje soldadoTemp : ColeccionSoldados) {
					fuerza = fuerza + soldadoTemp.fuerzaPersonaje(); 
			
				}
				return fuerza;
	}
	
	public void escribirEjercito(Writer w)
	{
		try
		{
			
			w.write(this.getClass().toString());
			w.write(';');
			w.write(String.valueOf(idEjercito));
			w.write(';');
			w.write(nombreEjercito);
			w.write(';');
			w.write(String.valueOf(capitan.getIdPersonaje()));
			w.write(';');
			for (Personaje PersonajeTemp : this.ColeccionSoldados) {
				w.write(String.valueOf(PersonajeTemp.getIdPersonaje()));
				w.write(';');
			}
			//w.write(String.valueOf(ColeccionEjercitosFronterizos));
					
			
		} catch (IOException e) {
		    System.err.println("Problem writing to the file statsTest.txt");
		}
	}
	
}
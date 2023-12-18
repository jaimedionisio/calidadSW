package edu.ucam.aplicacion;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public abstract class Personaje {

	//variables 
	
	private int idPersonaje;
	private static int IdSiguientePersonaje = 1;
	protected String nombrePersonaje;
	protected int edadPersonaje;
	protected Arma armaPersonaje;
	public static Set <Personaje> ColeccionPersonajes = new HashSet<Personaje>();

	//Constructor
	
	public Personaje(String nombrePersonaje, int edadPersonaje, Arma armaPersonaje) {
		this.idPersonaje = IdSiguientePersonaje; //Asigno el siguiente ID a este Personaje
		Personaje.IdSiguientePersonaje++; //Aumneto 1 el valor para el ID del próximo personaje
		this.nombrePersonaje = nombrePersonaje;
		this.edadPersonaje = edadPersonaje;
		this.armaPersonaje = armaPersonaje;
	}

	//Getters y Setters
	
	
	public int getIdPersonaje() {
		return idPersonaje;
	}
	
	public String getNombrePersonaje() {
		return nombrePersonaje;
	}

	public void setNombrePersonaje(String nombrePersonaje) {
		this.nombrePersonaje = nombrePersonaje;
	}

	public int getEdadPersonaje() {
		return edadPersonaje;
	}

	public void setEdadPersonaje(int edadPersonaje) {
		this.edadPersonaje = edadPersonaje;
	}

	public Arma getArmaPersonaje() {
		return armaPersonaje;
	}

	public void setArmaPersonaje(Arma armaPersonaje) {
		this.armaPersonaje = armaPersonaje;
	}

	
	// Metodos
	public abstract int fuerzaPersonaje();
	public abstract void MostrarInfo();
	public static Personaje crearPersonaje()
	{
		Scanner entradaTeclado = new Scanner (System.in); //Creación de un objeto Scanner
		int TipoDePersonaje=0;
		do{
			System.out.println("¿ Que Personaje vas a crear? (1-Guerrero Humano, 2- Caminante Blanco");
			
			TipoDePersonaje = Integer.parseInt(entradaTeclado.nextLine ()); //Invocamos un método sobre un objeto Scanner
		}while (TipoDePersonaje != 1 && TipoDePersonaje != 2);	
		
		boolean inmuneLuz;
		int expGuerra=0;
		int escalaRaza=0;
		String nombrePersonaje= "";
		Reino reinoNacimiento = null;
		int reinoNacimientoId = 0;
		int edadPersonaje=0;
		
		
		System.out.println("¿ Cual es su Nombre? ");
		nombrePersonaje = entradaTeclado.nextLine ();
		System.out.println("¿ Cuál es su edad? ");
		edadPersonaje = Integer.parseInt(entradaTeclado.nextLine ());
		Arma armaPersonaje = Arma.crearArma(); 
		Arma.ColeccionArmas.add(armaPersonaje);
		
		Personaje Personajetemp = null;
		
		if(TipoDePersonaje == 1){
			
			do{
				System.out.println("¿ Su Experiencia de guerra?? (de 0 a 100)");
				expGuerra = Integer.parseInt(entradaTeclado.nextLine ()); //Invocamos un método sobre un objeto Scanner
			}while (expGuerra<0 || expGuerra>100);
			
			
			for (Reino ListaReinos : Reino.ColeccionReinos) {
				ListaReinos.MostrarInfo();
			}
			
			System.out.println("¿A que Reino Pertenece de los anteriores?(Introduce el Id");
			reinoNacimientoId = Integer.parseInt(entradaTeclado.nextLine ());
			
			for (Reino reinoTemp : Reino.ColeccionReinos) {
				if (reinoNacimientoId == reinoTemp.getIdReino()){
					reinoNacimiento = reinoTemp;
				}
			}
			
			Personajetemp = new GuerreroHumano(nombrePersonaje, edadPersonaje, armaPersonaje, reinoNacimiento, expGuerra);
			
        }else if(TipoDePersonaje == 2){
				
			do{
				System.out.println("¿ Su Escala dentro de la Raza?? (de 1 a 3)");
				escalaRaza = Integer.parseInt(entradaTeclado.nextLine ()); //Invocamos un método sobre un objeto Scanner
			}while (escalaRaza<1 ||escalaRaza>3);
			
			do{
				System.out.println("¿ Es inmune a la luz?? (true o false)");
				inmuneLuz = Boolean.parseBoolean(entradaTeclado.nextLine ()); //Invocamos un método sobre un objeto Scanner
			}while (inmuneLuz != true && inmuneLuz != false);
			
			Personajetemp = new CaminanteBlanco(nombrePersonaje, edadPersonaje, armaPersonaje, inmuneLuz, escalaRaza);
		}
		//entradaTeclado.close();
		return Personajetemp;

	}

	
	public static void listarPersonajes(){
		
		for (Personaje Personajetemp : ColeccionPersonajes) {
			if (Personajetemp instanceof GuerreroHumano) 
			{
				GuerreroHumano CastPersonaje = (GuerreroHumano) Personajetemp;
				CastPersonaje.MostrarInfo();
			}
			else if (Personajetemp instanceof CaminanteBlanco) 
			{
				CaminanteBlanco CastPersonaje = (CaminanteBlanco) Personajetemp;
				CastPersonaje.MostrarInfo();
			}
			
		}
	}
	
	public static boolean borrarPersonaje(Personaje PersonajeBorrar){
		boolean resultado = false;
		
		if (PersonajeBorrar != null){
			System.out.println("Se ha eliminado el siguiente elemento:\n");
			PersonajeBorrar.MostrarInfo();
			resultado = ColeccionPersonajes.remove(PersonajeBorrar);
		}
		//System.out.println(ArmaBorrar.nombreArma);
		return resultado;
		
	}
	
	public static Personaje BuscarPersonaje(int IdPersonaje){
		
		for (Personaje PersonajeTemp : ColeccionPersonajes) {
			if (PersonajeTemp.getIdPersonaje() == IdPersonaje) 
			{
				return PersonajeTemp;
			}
			
		}
		return null;
		
	}

	public static void EditarPersonaje(Personaje PersonajeEditar){
		PersonajeEditar.MostrarInfo();
		
		if (PersonajeEditar instanceof GuerreroHumano){
			int Eleccion;
			do{				
			System.out.println("Que campo quieres cambiar?\n1 Nombre\n2 Edad\n3 Arma\n4 Reino de Nacimiento\n5 Experiencia de Guerra"); 
			Scanner c2 = new Scanner(System.in);
			Eleccion = Integer.parseInt(c2.nextLine ());
			}while (Eleccion>5);
			
			System.out.println("Cual es el nuevo valor?\n"); 
			Scanner c3 = new Scanner(System.in);
			String CampoaEditar = c3.nextLine ();
			if(Eleccion == 1){
				PersonajeEditar.setNombrePersonaje(CampoaEditar);
			}
			else if(Eleccion == 2){
				PersonajeEditar.setEdadPersonaje(Integer.parseInt(CampoaEditar));
			}
			else if(Eleccion == 3){
				PersonajeEditar.setArmaPersonaje(Arma.BuscarArma(Integer.parseInt(CampoaEditar)));
			}
			else if(Eleccion == 4){
				((GuerreroHumano) PersonajeEditar).setReinoNacimiento(Reino.BuscarReino(Integer.parseInt(CampoaEditar)));
			}
			else if(Eleccion == 5){
				((GuerreroHumano) PersonajeEditar).setExpGuerra(Integer.parseInt(CampoaEditar));
			}
			
			
		}
		else if (PersonajeEditar instanceof CaminanteBlanco){
			int Eleccion;
			do{				
			System.out.println("Que campo quieres cambiar?\n1 Nombre\n2 Edad\n3 Arma\n4 Inmune a la Luz\n5 Exxcala de la Raza"); 
			Scanner c2 = new Scanner(System.in);
			Eleccion = Integer.parseInt(c2.nextLine ());
			}while (Eleccion>5);
			
			System.out.println("Cual es el nuevo valor?\n"); 
			Scanner c3 = new Scanner(System.in);
			String CampoaEditar = c3.nextLine ();
			if(Eleccion == 1){
				PersonajeEditar.setNombrePersonaje(CampoaEditar);
			}
			else if(Eleccion == 2){
				PersonajeEditar.setEdadPersonaje(Integer.parseInt(CampoaEditar));
			}
			else if(Eleccion == 3){
				PersonajeEditar.setArmaPersonaje(Arma.BuscarArma(Integer.parseInt(CampoaEditar)));
			}
			else if(Eleccion == 4){
				((CaminanteBlanco) PersonajeEditar).setInmuneALaLuz(Boolean.parseBoolean(CampoaEditar));
			}
			else if(Eleccion == 5){
				((CaminanteBlanco) PersonajeEditar).setEscalaRaza(Integer.parseInt(CampoaEditar));
			}
			
			
		}
		
			
		 
	}
	
	public void escribirPersonaje(Writer w)
	{
		try
		{
			
			w.write(this.getClass().toString());
			w.write(';');
			w.write(String.valueOf(idPersonaje));
			w.write(';');
			w.write(nombrePersonaje);
			w.write(';');
			w.write(String.valueOf(edadPersonaje));
			w.write(';');
			w.write(String.valueOf(armaPersonaje.getIdArma()));
			
				
			
		} catch (IOException e) {
		    System.err.println("Problem writing to the file statsTest.txt");
		}
	}
	
}
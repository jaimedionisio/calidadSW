package edu.ucam.aplicacion;
import java.util.Date;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Batalla {

	//variables
	private int idBatalla;
	private static int idSiguienteBatalla = 1;
	private Ejercito ejercito1;
	private Ejercito ejercito2;
	private Reino lugarDeBatalla;
	private String ejercitoGanador;
	private Date fecha;
	public static Set <Batalla> ColeccionBatallas = new HashSet<Batalla>() ;
	
	
	
	//SETTER Y GETTER
	
	
	public Ejercito getEjercito1() {
		return ejercito1;
	}

	public int getIdBatalla() {
		return idBatalla;
	}

	public void setEjercito1(Ejercito ejercito1) {
		this.ejercito1 = ejercito1;
	}

	public Ejercito getEjercito2() {
		return ejercito2;
	}

	public void setEjercito2(Ejercito ejercito2) {
		this.ejercito2 = ejercito2;
	}

	public Reino getLugarDeBatalla() {
		return lugarDeBatalla;
	}

	public void setLugarDeBatalla(Reino lugarDeBatalla) {
		this.lugarDeBatalla = lugarDeBatalla;
	}

	public String getEjercitoGanador() {
		return ejercitoGanador;
	}

	public void setEjercitoGanador(String ejercitoGanador) {
		this.ejercitoGanador = ejercitoGanador;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(int year, int month, int day) {
	
		this.fecha = new Date(year-1900,month-1,day);	
	}
	

	//Constructor
	public Batalla(Ejercito ejercito1, Ejercito ejercito2, Reino lugarDeBatalla, int year, int month, int day) {
		this.idBatalla = idSiguienteBatalla; //Asigno el siguiente ID a este Personaje
		Batalla.idSiguienteBatalla++; //Aumneto 1 el valor para el ID del pr�ximo personaje
		this.ejercito1 = ejercito1;
		this.ejercito2 = ejercito2;
		this.lugarDeBatalla = lugarDeBatalla;
		setFecha(year,month,day);
		
	}

	//metodos
	
	
	public void MostrarInfo(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		
		//System.out.println("ID: " + this.idBatalla + "Fecha " + formatter.format(fecha)  );
		System.out.println("\nID: " + this.idBatalla + ":\n" + this.ejercito1.getNombreEjercito() +"("+ FuerzaEjercito1() +" Puntos de Fuerza)" + " Vs "+ this.ejercito2.getNombreEjercito()+ "("+ FuerzaEjercito2() +" Puntos de Fuerza)\nLugar de Batalla: " + this.lugarDeBatalla.getNombreReino() +"\nFecha: "+ formatter.format(fecha) + "\nGanador: " + this.ResultadoBatalla().getNombreEjercito());
	}
	
	public static Batalla crearBatalla()
	{
		Scanner entradaTeclado = new Scanner (System.in); //Creaci�n de un objeto Scanner
		
		int Ejercito1Id = 0;
		int Ejercito2Id = 0;
		int ReinoId = 0;
		Reino reino = null;
		Ejercito Ejercito1 = null;
		Ejercito Ejercito2 = null;
		
		int day = 0;
		int month = 0;
		int year = 0;
		
		Ejercito.listarEjercitos();
		System.out.println("�Id del Ejercito 1? ");
		Ejercito1Id =Integer.parseInt(entradaTeclado.nextLine ());
		Ejercito1 = Ejercito.BuscarEjercito(Ejercito2Id);	 
		
		Ejercito.listarEjercitos();
		System.out.println("�Id del Ejercito 2? ");
		Ejercito2Id =Integer.parseInt(entradaTeclado.nextLine ());
		Ejercito2 = Ejercito.BuscarEjercito(Ejercito2Id);	 
		
		Reino.listarReinos();
		System.out.println("�Introduce ID del Lugar de la Batalla? ");
		ReinoId =Integer.parseInt(entradaTeclado.nextLine ());
		reino = Reino.BuscarReino(ReinoId);	 
		
		
		System.out.println("� Introduzca la Fecha de la Batalla? ");
		System.out.println("� D�a? ");
		day =Integer.parseInt(entradaTeclado.nextLine ());
		System.out.println("� Mes? ");
		month =Integer.parseInt(entradaTeclado.nextLine ());
		System.out.println("� A�o? ");
		year =Integer.parseInt(entradaTeclado.nextLine ());
		
		
		
		Batalla Batallatemp = null;
        
		Batallatemp = new Batalla(Ejercito1,Ejercito2,reino,year, month, day);
        
        return Batallatemp;

	}
	
	public static void listarBatallas(){
		for (Batalla BatallaTemp : ColeccionBatallas) {
			BatallaTemp.MostrarInfo();
		}
	}
	
	public static boolean borrarBatalla(Batalla BatallaBorrar){
		boolean resultado = false;
		
		if (BatallaBorrar != null){
			System.out.println("Se ha eliminado el siguiente elemento:\n");
			BatallaBorrar.MostrarInfo();
			resultado = ColeccionBatallas.remove(BatallaBorrar);
		}
		//System.out.println(ArmaBorrar.nombreArma);
		return resultado;
		
	}
	
	public static Batalla BuscarBatalla(int IdBatalla){
		
		for (Batalla BatallaTemp : ColeccionBatallas) {
			if (BatallaTemp.getIdBatalla() == IdBatalla) 
			{
				return BatallaTemp;
			}
			
		}
		return null;
		
	}
	
	public static Batalla BuscarBatalla2(int day, int month, int year){
		
		Date fechaTemp = new Date(year-1900,month-1,day);
		for (Batalla BatallaTemp : ColeccionBatallas) {
			System.out.println(BatallaTemp.idBatalla);
			System.out.println(BatallaTemp.getFecha().getYear());
			System.out.println(BatallaTemp.getFecha().getMonth());
			System.out.println(BatallaTemp.getFecha().getDate());
			System.out.println("\n");
			if (BatallaTemp.getFecha().getDate() == day && BatallaTemp.getFecha().getMonth() == month-1 && BatallaTemp.getFecha().getYear() == (year-1900)) 
			{
				return BatallaTemp;
			}
			
		}
		
		return null;
		
	}
	
	public static void EditarBatalla(Batalla BatallaEditar){
		BatallaEditar.MostrarInfo();
		int Ejercito1Id = 0;
		int Ejercito2Id = 0;
		int ReinoId = 0;
		Reino reino = null;
		Ejercito Ejercito1 = null;
		Ejercito Ejercito2 = null;
		int lugarDeBatallaId = 0;
		int day = 0;
		int month = 0;
		int year = 0;
		
		
		Scanner entradaTeclado = new Scanner (System.in);
		int Eleccion;
		do{				
		System.out.println("Que campo quieres cambiar?\n1 Ejercito1\n2 Ejercito2\n3 Lugar de la Batalla\n4 Fecha\n"); 
		Scanner c2 = new Scanner(System.in);
		Eleccion = Integer.parseInt(c2.nextLine ());
		}while (Eleccion>4);
		
		if(Eleccion == 1){
			Ejercito.listarEjercitos();
			System.out.println("�Id del Nuevo Ejercito? ");
			Ejercito1Id =Integer.parseInt(entradaTeclado.nextLine ());
			Ejercito1 = Ejercito.BuscarEjercito(Ejercito1Id);	
			BatallaEditar.setEjercito1(Ejercito1);
		}
		else if(Eleccion == 2){
			Ejercito.listarEjercitos();
			System.out.println("�Id del Nuevo Ejercito? ");
			Ejercito2Id =Integer.parseInt(entradaTeclado.nextLine ());
			Ejercito2 = Ejercito.BuscarEjercito(Ejercito2Id);	
			BatallaEditar.setEjercito1(Ejercito2);
		}
		else if(Eleccion == 3){
			Reino.listarReinos();
			System.out.println("�Id del Nuevo Reino? ");
			ReinoId =Integer.parseInt(entradaTeclado.nextLine ());
			reino = Reino.BuscarReino(ReinoId);	
			BatallaEditar.setLugarDeBatalla(reino);
		}
		
		else if(Eleccion == 4){
			
			System.out.println("�D�a? ");
			day =Integer.parseInt(entradaTeclado.nextLine ());
			System.out.println("�Mes? ");
			month =Integer.parseInt(entradaTeclado.nextLine ());
			System.out.println("�A�o? ");
			year =Integer.parseInt(entradaTeclado.nextLine ());	
			BatallaEditar.setFecha(year, month, day);
		}
				
					
		 
	}
	
	

	public double FuerzaEjercito1() {
		
		double calculoEj1=0;
		
		
			if (ejercito1.getCapitan() instanceof GuerreroHumano) 
			{
				GuerreroHumano CastCapitan = (GuerreroHumano) ejercito1.getCapitan();
				if(CastCapitan.getReinoNacimiento().equals(lugarDeBatalla)){
					calculoEj1 = ejercito1.fuerzaEjercito()*1.25; 
				}
				else{
					calculoEj1 = ejercito1.fuerzaEjercito();
				}
			}
			else if (ejercito1.getCapitan() instanceof CaminanteBlanco) 
			{
				CaminanteBlanco CastCapitan = (CaminanteBlanco) ejercito1.getCapitan();
				boolean inmune = CastCapitan.esInmuneALaLuz();
				if(inmune == true){
					calculoEj1 = ejercito1.fuerzaEjercito()*1.25; 
				}
				else{
					calculoEj1 = ejercito1.fuerzaEjercito();
				}
			}
			
			
			//System.out.println("El Ejercito1 tiene una fuerza de: " + calculoEj1 );
			return calculoEj1;
			
			
		}
	
	public double FuerzaEjercito2() {
		
		double calculoEj2=0;
		
		
			if (ejercito2.getCapitan() instanceof GuerreroHumano) 
			{
				GuerreroHumano CastCapitan = (GuerreroHumano) ejercito2.getCapitan();
				if(CastCapitan.getReinoNacimiento().equals(lugarDeBatalla)){
					calculoEj2 = ejercito2.fuerzaEjercito()*1.25; 
				}
				else{
					calculoEj2 = ejercito2.fuerzaEjercito();
				}
			}
			else if (ejercito2.getCapitan() instanceof CaminanteBlanco) 
			{
				CaminanteBlanco CastCapitan = (CaminanteBlanco) ejercito2.getCapitan();
				boolean inmune = CastCapitan.esInmuneALaLuz();
				if(inmune == true){
					calculoEj2 = ejercito2.fuerzaEjercito()*1.25; 
				}
				else{
					calculoEj2 = ejercito2.fuerzaEjercito();
				}
			}
			
			
			//System.out.println("El Ejercito2 tiene una fuerza de: " + calculoEj2 );
			return calculoEj2;
			
			
		}
	
	
	public Ejercito ResultadoBatalla() {
		double calculoFinal=0;
		double calculoEj1= FuerzaEjercito1();
		double calculoEj2= FuerzaEjercito2();
		
	
			
			//System.out.println("El Ejercito1 tiene una fuerza de: " + calculoEj1 +"\nEl Ejercito2 tiene una fuerza de: " + calculoEj2  );
			if (calculoEj1>calculoEj2)
			{
				//System.out.println("\nEl ganador es el Ejercito1: " + ejercito1.getNombreEjercito());
				return ejercito1;
			}
			else if (calculoEj1<calculoEj2)
			{
				//System.out.println("\nEl ganador es el Ejercito2: " + ejercito2.getNombreEjercito());
				return ejercito2;
			}
			else 
			{
				System.out.println("\nHan Empatado");
				return null;
			}
			
		}
	
	public void escribirBatalla(Writer w)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			
			w.write(this.getClass().toString());
			w.write(';');
			w.write(String.valueOf(idBatalla));
			w.write(';');
			w.write(String.valueOf(ejercito1.getIdEjercito()));
			w.write(';');
			w.write(String.valueOf(ejercito2.getIdEjercito()));
			w.write(';');
			w.write(String.valueOf(lugarDeBatalla.getIdReino()));
			w.write(';');
			w.write(String.valueOf(formatter.format(fecha)));
			
				
			
		} catch (IOException e) {
		    System.err.println("Problem writing to the file statsTest.txt");
		}
	}
}
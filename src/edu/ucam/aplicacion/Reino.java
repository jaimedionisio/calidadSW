package edu.ucam.aplicacion;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Reino {
	//Variables
	private int idReino;
	private static int idSiguienteReino = 1;
	private String nombreReino;
	private String casaDuena;
	public Set <Reino> ColeccionReinosFronterizos = new HashSet<Reino>() ;
	public static Set <Reino> ColeccionReinos = new HashSet<Reino>() ;
	//GETTERS Y SETTERS
	
//	public static Set<Reino> getColeccionReinosFronterizos() {
//		return ColeccionReinosFronterizos;
//	}

	
	public void setNombreReino(String nombreReino) {
		this.nombreReino = nombreReino;
	}


	public void setCasaDuena(String casaDuena) {
		this.casaDuena = casaDuena;
	}


	public int getIdReino() {
		return idReino;
	}


	public String getNombreReino() {
		return nombreReino;
	}


	public String getCasaDuena() {
		return casaDuena;
	}

	//CONSTRUCTOR
	public Reino(String nombreReino, String casaDuena) {
		this.idReino = idSiguienteReino; //Asigno el siguiente ID a este Personaje
		Reino.idSiguienteReino++; //Aumneto 1 el valor para el ID del prnximo personaje
		this.nombreReino = nombreReino;
		this.casaDuena = casaDuena; 
	}
	
	public static Reino crearReino(String nombre, String casaDuena) {
	    return new Reino(nombre, casaDuena);
	}
	
	//METODOS
	public void MostrarInfo(){
		System.out.println("\nID: " + this.idReino + "\nReino: "+ this.nombreReino + "\nCasa Duena: " + this.casaDuena);
		System.out.println("                       FRONTERIZOS:\n                       ***********************************");
		for (Reino ReinoTemp : this.ColeccionReinosFronterizos) {
			
			System.out.println("                           Id:" + ReinoTemp.idReino + " Nombre: " + ReinoTemp.nombreReino +"");

		}
		System.out.println("                       ***********************************\n\n");
	}
	
	public static Reino crearReino()
	{
		Scanner entradaTeclado = new Scanner (System.in); //Creacinn de un objeto Scanner
		
		String nombreReino= "";
		String casaDuena= "";
		
		System.out.println("n Nombre del Reino? ");
		nombreReino = entradaTeclado.nextLine ();
		System.out.println("n Casa Duena? ");
		casaDuena =entradaTeclado.nextLine ();
			 
		Reino Reinotemp = null;
        
		Reinotemp = new Reino(nombreReino, casaDuena);
        
        return Reinotemp;

	}
	
	public static void listarReinos(){
		for (Reino ReinoTemp : ColeccionReinos) {
			ReinoTemp.MostrarInfo();
			listarReinosFronterizos(ReinoTemp);
		}
	}
	
	public static Reino BuscarReino(int IdReino){
		
		for (Reino ReinoTemp : ColeccionReinos) {
			if (ReinoTemp.getIdReino() == IdReino) 
			{
				return ReinoTemp;
			}
			
		}
		return null;
		
	}

	public static boolean borrarReino(Reino ReinoBorrar){
		boolean resultado = false;
		
		if (ReinoBorrar != null){
			System.out.println("Se ha eliminado el siguiente elemento:\n");
			ReinoBorrar.MostrarInfo();
			resultado = ColeccionReinos.remove(ReinoBorrar);
		}
		//System.out.println(ArmaBorrar.nombreArma);
		return resultado;
		
	}
	
	public static void listarReinosFronterizos(Reino ReinoPadre){
		
		
		for (Reino ReinoTemp : ReinoPadre.ColeccionReinosFronterizos) {
			ReinoTemp.MostrarInfo();
		}
				
	}
	
	
	
	public static void EditarReino(Reino ReinoEditar){
		
		ReinoEditar.MostrarInfo();
		
		
		int Eleccion;
		do{				
		System.out.println("Que campo quieres cambiar?\n1 Nombre del Reino\n2 Casa Duena\n3 ReinosFronterizos"); 
		Scanner c2 = new Scanner(System.in);
		Eleccion = Integer.parseInt(c2.nextLine ());
		}while (Eleccion>3);
		
		System.out.println("Cual es el nuevo valor?\n"); 
		Scanner c3 = new Scanner(System.in);
		String CampoaEditar = c3.nextLine ();
		if(Eleccion == 1){
			ReinoEditar.setCasaDuena(CampoaEditar);
		}
		else if(Eleccion == 2){
			ReinoEditar.setCasaDuena(CampoaEditar);
		}
				
					
		 
	}

	public static void AnadirReinoFronterizo(Reino ReinoPadre)
	{
		listarReinos();
		System.out.println("Introduce el Id del Reino que quieres anadir como Reino fronterizo."); 
		Scanner c1 = new Scanner(System.in);
		int ReinoABuscar2 = Integer.parseInt(c1.nextLine ());
		Reino ReinoFronterizo = BuscarReino(ReinoABuscar2);
		if (ReinoFronterizo.equals(ReinoPadre)){
			System.out.println("No puedes anadir el Reino como Reino fronterizo de si misimo");
		}
		else
		{
			System.out.println("Se ha anadido como fronterizo el reino:\n");
			ReinoFronterizo.MostrarInfo();
			ReinoPadre.ColeccionReinosFronterizos.add(ReinoFronterizo);
		}
		
		
	}
	
	public static void BorrarFronterizo(Reino ReinoPadre)
	{
		listarReinosFronterizos(ReinoPadre);
		System.out.println("Introduce el Id del Reino que quieres Borrar como Reino fronterizo."); 
		Scanner c1 = new Scanner(System.in);
		int ReinoABuscar = Integer.parseInt(c1.nextLine ());
		Reino ReinoFronterizo = BuscarReino(ReinoABuscar);
		System.out.println("Se ha Borrado como fronterizo el reino:\n");
		ReinoFronterizo.MostrarInfo();
		ReinoPadre.ColeccionReinosFronterizos.remove(ReinoFronterizo);
		
	}
	
	public void escribirReino(Writer w)
	{
		try
		{
			
			w.write(this.getClass().toString());
			w.write(';');
			w.write(String.valueOf(idReino));
			w.write(';');
			w.write(nombreReino);
			w.write(';');
			w.write(String.valueOf(casaDuena));
			w.write(';');
			for (Reino ReinoTemp : this.ColeccionReinosFronterizos) {
				w.write(String.valueOf(ReinoTemp.getIdReino()));
				w.write(';');
			}
			//w.write(String.valueOf(ColeccionReinosFronterizos));
					
			
		} catch (IOException e) {
		    System.err.println("Problem writing to the file statsTest.txt");
		}
	}
	


}
package edu.ucam.aplicacion;


import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public abstract class Arma {

//variables
private int idArma;
private static int idSiguienteArma = 1;
protected String nombreArma;
protected float pesoArma;
protected float longitudArma;
public static Set <Arma> ColeccionArmas = new HashSet<Arma>() ;
	
	//Constructor
	
	public Arma(String nombreArma, float pesoArma, float longitudArma) {
		this.idArma = idSiguienteArma; //Asigno el siguiente ID a este Personaje
		Arma.idSiguienteArma++; //Aumneto 1 el valor para el ID del pr�ximo personaje
		this.nombreArma = nombreArma;
		this.pesoArma = pesoArma;
		this.longitudArma = longitudArma;
	}

	
	//Getters y Setters
	
	
	public String getNombreArma() {
		return nombreArma;
	}


	public int getIdArma() {
		return idArma;
	}


	public void setNombreArma(String nombreArma) {
		this.nombreArma = nombreArma;
	}


 public float getPesoArma() {
  return pesoArma;
	}


	public void setPesoArma(float pesoArma) {
		this.pesoArma = pesoArma;
	}


	public float getLongitudArma() {
		return longitudArma;
	}


	public void setLongitudArma(float longitudArma) {
		this.longitudArma = longitudArma;
	}


	//M�todos
	
	public abstract int fuerzaArma();
	public abstract void MostrarInfo();
	
	
	public void escribirArma(Writer w)
	{
		try
		{
			
			w.write(this.getClass().toString());
			w.write(';');
			w.write(String.valueOf(idArma));
			w.write(';');
			w.write(nombreArma);
			w.write(';');
			w.write(String.valueOf(pesoArma));
			w.write(';');
			w.write(String.valueOf(longitudArma));
				
			
		} catch (IOException e) {
		    System.err.println("Problem writing to the file statsTest.txt");
		}
	}
	
	public static Arma crearArma()
	{
		Scanner entradaTeclado = new Scanner (System.in); //Creaci�n de un objeto Scanner
		int arma=0;
		int flechas=0;
		do{
			System.out.println("� Que arma deseas? (1-Hacha, 2- Espada, 3-Arco) ");
			
	        arma = Integer.parseInt(entradaTeclado.nextLine ()); //Invocamos un m�todo sobre un objeto Scanner
			
	        if(arma == 3){
				
				do{
					System.out.println("� Cuantas flechas tiene? (de 0 a 10) ");
					flechas = Integer.parseInt(entradaTeclado.nextLine ()); //Invocamos un m�todo sobre un objeto Scanner
				}while (flechas<0 || flechas>10);
				
			}
		}while (arma<1 || arma >3);	
		
		String nombreArma= "";
		float pesoArma=0;
		float longitudArma=0;
		
		System.out.println("� Nombre del arma? ");
		nombreArma = entradaTeclado.nextLine ();
		System.out.println("� Cuanto Pesa el arma (en gramos)? ");
		pesoArma =Float.parseFloat(entradaTeclado.nextLine ());
		System.out.println("� Cuanto Mide el arma (en ctms)? ");
		longitudArma = Float.parseFloat(entradaTeclado.nextLine ());
       
		 
		Arma Armatemp = null;
        if (arma ==3){
        	Armatemp = new Arco(nombreArma, pesoArma, longitudArma, flechas);
        }
        else if(arma == 2){
           	Armatemp = new Espada(nombreArma, pesoArma, longitudArma);
        }
        else if(arma == 1)
        {
        	Armatemp = new Hacha(nombreArma, pesoArma, longitudArma);
	    }
        
        //entradaTeclado.close();
        return Armatemp;

	}
	
	public static void listarArmas(){
		for (Arma ArmaTemp : ColeccionArmas) {
			if (ArmaTemp instanceof Arco) 
			{
				Arco CastArma = (Arco) ArmaTemp;
				CastArma.MostrarInfo();
			}
			else if (ArmaTemp instanceof Hacha) 
			{
				Hacha CastArma = (Hacha) ArmaTemp;
				CastArma.MostrarInfo();
			}
			else if (ArmaTemp instanceof Espada) 
			{
				Espada CastArma = (Espada) ArmaTemp;
				CastArma.MostrarInfo();
			}
	
		}
	}

	public static boolean borrarArma(Arma ArmaBorrar){
		boolean resultado = false;
		
		if (ArmaBorrar != null){
			System.out.println("Se ha eliminado el siguiente elemento:\n");
			ArmaBorrar.MostrarInfo();
			resultado = ColeccionArmas.remove(ArmaBorrar);
		}
		//System.out.println(ArmaBorrar.nombreArma);
		return resultado;
		
	}
	
	public static Arma BuscarArma(int NombreArma){
		
		for (Arma ArmaTemp : ColeccionArmas) {
			if (ArmaTemp.getIdArma() == NombreArma) 
			{
				return ArmaTemp;
			}
			
		}
		return null;
		
	}
	
	public static void EditarArma(Arma ArmaEditar){
		ArmaEditar.MostrarInfo();
		
		if (ArmaEditar instanceof Hacha || ArmaEditar instanceof Espada){
			int Eleccion;
			do{
			System.out.println("Que campo quieres cambiar?\n1 Nombre\n2 Peso\n3 Longitud"); 
			Scanner c2 = new Scanner(System.in);
			Eleccion = Integer.parseInt(c2.nextLine ());
			}while (Eleccion>3);
			
			System.out.println("Cual es el nuevo valor?\n"); 
			Scanner c3 = new Scanner(System.in);
			String CampoaEditar = c3.nextLine ();
			if(Eleccion == 1){
				ArmaEditar.setNombreArma(CampoaEditar);
			}
			else if(Eleccion == 2){
				ArmaEditar.setPesoArma(Float.parseFloat(CampoaEditar));
			}
			else if(Eleccion == 3){
				ArmaEditar.setLongitudArma(Float.parseFloat(CampoaEditar));
			}
			
			
		}
		else if (ArmaEditar instanceof Arco){
			int Eleccion;
			do{
			System.out.println("Que campo quieres cambiar?\n1 Nombre\n2 Peso\n3 Longitud\n4 Flechas"); 
			Scanner c2 = new Scanner(System.in);
			Eleccion = Integer.parseInt(c2.nextLine ());
			}while (Eleccion>4);
			
			
			if(Eleccion == 1){
				System.out.println("Cual es el nuevo nombre?\n"); 
				Scanner c3 = new Scanner(System.in);
				String CampoaEditar = c3.nextLine ();
				ArmaEditar.setNombreArma(CampoaEditar);
			}
			else if(Eleccion == 2){
				System.out.println("Cual es el nuevo valor en gramos ?\n"); 
				Scanner c3 = new Scanner(System.in);
				String CampoaEditar = c3.nextLine ();
				ArmaEditar.setPesoArma(Float.parseFloat(CampoaEditar));
			}
			else if(Eleccion == 3){
				System.out.println("Cual es el nuevo valor en ctms?\n"); 
				Scanner c3 = new Scanner(System.in);
				String CampoaEditar = c3.nextLine ();
				ArmaEditar.setLongitudArma(Float.parseFloat(CampoaEditar));
			}
			else if(Eleccion == 4){
				int comprobar=-1;
				do{
					System.out.println("Cual es el nuevo valor de 0 a 10?\n"); 
					Scanner c3 = new Scanner(System.in);
					String CampoaEditar = c3.nextLine ();
					Arco CastArma = (Arco) ArmaEditar;
					CastArma.setFlechas(Integer.parseInt(CampoaEditar));
					comprobar = Integer.parseInt(CampoaEditar);
				}while (comprobar <0 || comprobar >10 );
			}
			
		}
		
			
		 
	}
}

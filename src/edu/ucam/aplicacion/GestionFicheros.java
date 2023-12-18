package edu.ucam.aplicacion;
import java.io.*;
import java.util.Date;


public class GestionFicheros {
	public static void guardarArchivo(){
		
		
		try
		{
			File statText = new File("c:/temp/datosjuegodetronos.txt");
			FileOutputStream is = new FileOutputStream(statText);
	        OutputStreamWriter osw = new OutputStreamWriter(is);    
	        Writer w = new BufferedWriter(osw);
	        
	        for (Arma ArmaTemp : Arma.ColeccionArmas) {
	        	ArmaTemp.escribirArma(w);
	        	w.write('\n');
			}
	        for (Reino ReinoTemp : Reino.ColeccionReinos) {
	        	ReinoTemp.escribirReino(w);
	        	w.write('\n');
		        
			}
	        
	        for (Personaje PersonajeTemp : Personaje.ColeccionPersonajes) {
	        	PersonajeTemp.escribirPersonaje(w);
	        	w.write('\n');
			}
	        
	        for (Ejercito EjercitoTemp : Ejercito.ColeccionEjercitos) {
	        	EjercitoTemp.escribirEjercito(w);
	        	w.write('\n');
			}
	        
	        for (Batalla BatallaTemp : Batalla.ColeccionBatallas) {
	        	BatallaTemp.escribirBatalla(w);
	        	w.write('\n');
			}
	        

	        w.close();
	        
		} catch (IOException e) {
		    System.err.println("Problem writing to the file statsTest.txt");
		}
	}
	
	
	public static void guardarArchivo2(){

			
			for (Arma ArmaTemp : Arma.ColeccionArmas) {
				try {
				 FileOutputStream f = new FileOutputStream ("c:/temp/datos.txt");
				 ObjectOutputStream s =  new ObjectOutputStream (f);
				 s.writeObject(ArmaTemp.longitudArma);
				 s.close ();
				 } catch (IOException e) {
				 e.printStackTrace ();
				 }
			}

	}
}
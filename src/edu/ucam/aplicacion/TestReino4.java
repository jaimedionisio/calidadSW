package edu.ucam.aplicacion;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestReino4 {
    private Reino reino;

    @Before
    public void  PruebaBefore() {
        // Se ejecuta antes de cada prueba
        reino = new Reino("ReinoJUNIT", "CasaDuenaJUNIT");
    }

    @Test
    public void testGetIdReino() {
    
    	System.out.println("PASO1");
    	reino.MostrarInfo();
    	System.out.println("Resultado de probar GetIdReino:");
    	assertEquals(123, reino.getIdReino()); // Modificar para que falle
    
    
    }

    
    
    public void testGetNombreReino() {
    	System.out.println("Resultado de probar GetNombreReino:");
    	assertEquals("NombreReino2", reino.getNombreReino());
    	
    }
    

    @Test
    public void testGetCasaDuena() {
        assertEquals("CasaDuenaJUNIT2", reino.getCasaDuena());
    }

   /* @Test
    public void testCrearReino() {
        assertNotNull("Crear reino test FALL�:", Reino.crearReino());
              
    }*/

    @Test
    public void testListarReinos() {
        // Configuraci�n de prueba
        Reino.ColeccionReinos.clear(); // Limpiar la colecci�n para evitar interferencias con otras pruebas
        Reino reino1 = new Reino("Reino1", "Casa1");
        Reino reino2 = new Reino("Reino2", "Casa2");
        Reino.ColeccionReinos.add(reino1);
        Reino.ColeccionReinos.add(reino2);

        // Ejecutar el m�todo a probar
        Reino.listarReinos();

        // No hay una salida espec�fica que verificar, pero puedes verificar que no se haya producido una excepci�n.
        // Si el m�todo funciona correctamente, imprimir� informaci�n en la consola.

        // Tambi�n puedes agregar aserciones adicionales si decides cambiar el dise�o del m�todo listarReinos().
    }

 
    
    @Test
    public void testBuscarReino() {
    	System.out.println("Resultado de probar BuscarReino:");
        assertNull(Reino.BuscarReino(123));
    }

    @Test
    public void testBorrarReino() {
        //assertFalse(Reino.borrarReino(null));
        assertFalse(Reino.borrarReino(null));
        
    }

    @Test

    public void testAnadirReinoFronterizo() {
        
    }

    @Test
    public void testBorrarFronterizo() {
        // Implementar una l�gica para probar el m�todo BorrarFronterizo
    }
}

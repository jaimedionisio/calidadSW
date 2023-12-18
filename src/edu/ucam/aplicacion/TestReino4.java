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
        assertNotNull("Crear reino test FALLÓ:", Reino.crearReino());
              
    }*/

    @Test
    public void testListarReinos() {
        // Configuración de prueba
        Reino.ColeccionReinos.clear(); // Limpiar la colección para evitar interferencias con otras pruebas
        Reino reino1 = new Reino("Reino1", "Casa1");
        Reino reino2 = new Reino("Reino2", "Casa2");
        Reino.ColeccionReinos.add(reino1);
        Reino.ColeccionReinos.add(reino2);

        // Ejecutar el método a probar
        Reino.listarReinos();

        // No hay una salida específica que verificar, pero puedes verificar que no se haya producido una excepción.
        // Si el método funciona correctamente, imprimirá información en la consola.

        // También puedes agregar aserciones adicionales si decides cambiar el diseño del método listarReinos().
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
        // Implementar una lógica para probar el método BorrarFronterizo
    }
}

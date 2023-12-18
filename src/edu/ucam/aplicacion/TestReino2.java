package edu.ucam.aplicacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestReino2 {
    private Reino reino;

    @Before
    public void PruebaBefore() {
        // Se ejecuta antes de cada prueba
        reino = new Reino("ReinoJUNIT", "CasaDuenaJUNIT");
    }

    @Test
    public void testGetIdReino() {
        // Comprobamos que el ID del reino creado es el esperado
    	System.out.println("Comprobamos que el ID del reino creado es el esperado");
        assertEquals(2, reino.getIdReino());
        
    }

    @Test
    public void testGetNombreReino() {
        // Comprobamos que el nombre del reino es el esperado
        assertEquals("ReinoJUNIT", reino.getNombreReino());
    }

    @Test
    public void testGetCasaDuena() {
        // Comprobamos que la casa dueña del reino es la esperada
        assertEquals("CasaDuenaJUNIT", reino.getCasaDuena());
    }

    @Test
    public void testCrearReino() {
        // Configuramos la entrada estándar simulada con valores específicos
        String input = "NombreTest\nCasaDuenaTest\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Ejecutamos el método a probar
        Reino nuevoReino = Reino.crearReino();

        // Restauramos la entrada estándar
        System.setIn(System.in);

        // Verificamos que se haya creado un nuevo reino con los valores esperados
        assertEquals("NombreTest", nuevoReino.getNombreReino());
        assertEquals("CasaDuenaTest", nuevoReino.getCasaDuena());
    }

    @Test
    public void testListarReinos() {
        // Configuración de prueba
        Reino.ColeccionReinos.clear();
        Reino reino1 = new Reino("Reino1", "Casa1");
        Reino reino2 = new Reino("Reino2", "Casa2");
        Reino.ColeccionReinos.add(reino1);
        Reino.ColeccionReinos.add(reino2);

        // Ejecutar el método a probar
        Reino.listarReinos();
        // No hay una salida específica que verificar, pero puedes verificar que no se haya producido una excepción.
    }

    @Test
    public void testBuscarReino() {
        // Configuramos un reino con ID 1 en la colección
        Reino.ColeccionReinos.clear();
        Reino reino1 = new Reino("Reino1", "Casa1");
        Reino.ColeccionReinos.add(reino1);

        // Comprobamos que podemos encontrar el reino por su ID
        assertEquals(reino1, Reino.BuscarReino(1));
    }

    @Test
    public void testBorrarReino() {
        // Configuramos un reino con ID 1 en la colección
        Reino.ColeccionReinos.clear();
        Reino reino1 = new Reino("Reino1", "Casa1");
        Reino.ColeccionReinos.add(reino1);

        // Comprobamos que podemos borrar el reino de la colección
        assertTrue(Reino.borrarReino(reino1));
        // Verificamos que la colección está vacía después de borrar
        assertTrue(Reino.ColeccionReinos.isEmpty());
    }

    @Test
    public void testAnadirReinoFronterizo() {
        // Configuración de prueba
        Reino.ColeccionReinos.clear();
        Reino reinoPadre = new Reino("ReinoPadre", "CasaPadre");
        Reino reinoFronterizo = new Reino("ReinoFronterizo", "CasaFronterizo");
        Reino.ColeccionReinos.add(reinoPadre);
        Reino.ColeccionReinos.add(reinoFronterizo);

        // Configuramos la entrada estándar simulada con el ID del reino fronterizo
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Ejecutamos el método a probar
        
        Reino.AnadirReinoFronterizo(reinoPadre);

        // Restauramos la entrada estándar
        System.setIn(System.in);

        // Verificamos que el reino fronterizo se ha añadido correctamente
        assertTrue(reinoPadre.ColeccionReinosFronterizos.contains(reinoFronterizo));
    }

    @Test
    public void testBorrarFronterizo() {
        // Configuración de prueba
        Reino.ColeccionReinos.clear();
        Reino reinoPadre = new Reino("ReinoPadre", "CasaPadre");
        Reino reinoFronterizo = new Reino("ReinoFronterizo", "CasaFronterizo");
        reinoPadre.ColeccionReinosFronterizos.add(reinoFronterizo);

        // Configuramos la entrada estándar simulada con el ID del reino fronterizo
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Ejecutamos el método a probar
        Reino.BorrarFronterizo(reinoPadre);

        // Restauramos la entrada estándar
        System.setIn(System.in);

        // Verificamos que el reino fronterizo se ha borrado correctamente
        assertFalse(reinoPadre.ColeccionReinosFronterizos.contains(reinoFronterizo));
    }
}

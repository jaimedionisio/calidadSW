package edu.ucam.aplicacion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.StringWriter;
import java.io.Writer;

class ArmaTest {

    @Test
    void testArmaCreation() {
        // Test Case 1
        Arma arma = new Espada("Espada de prueba", 500, 80);
        assertNotNull(arma);
        assertEquals(1, arma.getIdArma());
    }

    @Test
    void testGettersAndSetters() {
        // Test Case 2
        Arma arma = new Hacha("Hacha de prueba", 700, 90);
        arma.setNombreArma("Nuevo Hacha");
        arma.setPesoArma(800);
        arma.setLongitudArma(95);

        assertEquals("Nuevo Hacha", arma.getNombreArma());
        assertEquals(800, arma.getPesoArma(), 0.001);
        assertEquals(95, arma.getLongitudArma(), 0.001);
    }

    @Test
    void testEscribirArma() {
        // Test Case 3
        Arma arma = new Arco("Arco de prueba", 600, 75, 5);
        Writer writer = new StringWriter();
        arma.escribirArma(writer);
        assertEquals("class edu.ucam.aplicacion.Arco;1;Arco de prueba;600.0;75.0", writer.toString());
    }

    @Test
    void testCrearArma() {
        // Test Case 4
        // Note: This test involves user input, consider using Mockito or other techniques for mocking.
        Arma arma = Arma.crearArma();
        assertNotNull(arma);
        // Verify other conditions based on expected input.
    }

    @Test
    void testListarArmas() {
        // Test Case 5
        Arma.ColeccionArmas.clear();
        Arma.ColeccionArmas.add(new Hacha("Hacha 1", 500, 80));
        Arma.ColeccionArmas.add(new Espada("Espada 1", 600, 90));
        Arma.ColeccionArmas.add(new Arco("Arco 1", 700, 75, 8));

        // Note: This test involves output, consider using testing frameworks for output validation.
        Arma.listarArmas();
    }

    // Similar tests for borrarArma, BuscarArma, EditarArma, Edge Cases, etc.

}

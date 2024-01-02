package test.java;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ucam.aplicacion.CargaDeDatos;
import edu.ucam.aplicacion.Reino;

public class TestReino_jd {

    private Reino reino;

    @Before
    public void cargaDatosEjemplo() {
        // Configurar objetos necesarios antes de cada prueba
    	CargaDeDatos.CargarDatos();
    	reino = new Reino("NombreReino", "CasaDuena");
    }

    @After
    public void liberarRecursos() {
        // Limpiar o liberar recursos despues de cada prueba
        reino = null;
    }

    @Test
    public void testGetNombreReino() {
        assertEquals("NombreReino2", reino.getNombreReino());
    }

    @Test
    public void testGetCasaDuena() {
        assertEquals("CasaDuena2", reino.getCasaDuena());
    }
    
    @Test
    public void testCrearReino() {
        String nombre = "NuevoReino";
        String casaDuena = "NuevaCasa";

        Reino nuevoReino = Reino.crearReino(nombre, casaDuena);
        assertNotNull("El nuevo Reino no deberia ser nulo", nuevoReino);
        assertEquals("El nombre del Reino no coincide", "NuevoReino", nuevoReino.getNombreReino());
        assertEquals("La casa duena del Reino no coincide", "NuevaCasa2", nuevoReino.getCasaDuena());

        System.out.println("Test testCrearReino ha salido bien.");
    }

    @Test
    public void testBuscarReino() {
    	Reino resultado = Reino.BuscarReino(10000);
        assertNotNull("no se ha encontrado el ID del Reino buscado en la prueba",resultado);
       // assertEquals("El reino, resultado);
    }
    
    
    @Test
    public void testBorrarReino() {
        boolean resultado = Reino.borrarReino(reino);
        assertTrue("Se ha borrado el reino Satisfactoreamente ",resultado);
        assertFalse("NO Se ha borrado el reino Satisfactoreamente ",resultado);
    }

   /* @Test
    public void testEditarReino() {
        String nuevoNombre = "NuevoNombre";
        String nuevaCasa = "NuevaCasa";

        // Simular la entrada del usuario
        String input = nuevoNombre + "\n" + nuevaCasa + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Ejecutar el método editarReino
        Reino.EditarReino(reino);

        // Restaurar la entrada estándar
        System.setIn(System.in);

        // Verificar que los cambios se han realizado correctamente
        assertEquals(nuevoNombre, reino.getNombreReino());
        assertEquals(nuevaCasa, reino.getCasaDuena());
    }*/
    
    @Test
    public void testEditarReino() {
        
    }

    @Test
    public void testAnadirReinoFronterizo() {
        
    }

    @Test
    public void testBorrarFronterizo() {
        
    }

    
    
    
    
}

import com.cevichemadrileno.modelo.AccesoBD;
import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.util.Constantes;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ActividadTest {

    /**
     * Test para verificar que se puede crear una actividad
     */
    @Test
    public void deberiaCrearseActividad(){
        // Loguearse como monitor
        AccesoBD accesoBD = new AccesoBD();
        accesoBD.login("123", "123");


        // Crear una nueva actividad
        Actividad actividad = new Actividad();
        actividad.setNombre("Actividad de prueba");
        actividad.setDescripcion("Descripcion de prueba");
        actividad.setFecha(Timestamp.valueOf("2023-10-01 10:00:00"));
        actividad.setIdSala(1);
        actividad.setNroMaximoInscritos(5);
        accesoBD.registrarActividad(actividad);

        // Verificar que la actividad fue creada correctamente
        Actividad actividadCreada = accesoBD.obtenerActividadPorNombre("Actividad de prueba");

        Assert.assertNotNull(actividadCreada);
        Assert.assertEquals(actividadCreada.getNombre(), actividad.getNombre());
        Assert.assertEquals(actividadCreada.getDescripcion(), actividad.getDescripcion());
        Assert.assertEquals(actividadCreada.getFecha(), actividad.getFecha());
        Assert.assertEquals(actividadCreada.getIdSala(), actividad.getIdSala());

        // Limpiar la base de datos después de la prueba
        accesoBD.eliminarActividad(actividadCreada.getId());
    }

    @Test
    public void deberiaInscribirseEnActividad(){
        AccesoBD accesoBD = new AccesoBD();

        // Loguearse como usuario
        accesoBD.login("2244193B", "123");

        // Traer una actividad cualquiera de la base de datos
        ArrayList<Actividad> actividades = accesoBD.obtenerActividades();
        Actividad actividad = actividades.get(actividades.size() - 1);

        // Inscribirse en la actividad
        accesoBD.inscribirseEnActividad(actividad.getId());

        // Verificar que el usuario está inscrito en la actividad
        boolean inscrito = accesoBD.usuarioYaInscritoEnActividad(actividad.getId(), Constantes.usuarioAutenticado.getId());
        Assert.assertTrue(inscrito);

        // Desinscribirse de la actividad
        accesoBD.desinscribirseDeActividad(actividad.getId(), Constantes.usuarioAutenticado.getId());
    }



}

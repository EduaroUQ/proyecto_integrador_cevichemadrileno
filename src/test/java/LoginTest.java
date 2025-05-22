import com.cevichemadrileno.modelo.AccesoBD;
import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.modelo.Sala;
import com.cevichemadrileno.modelo.Usuario;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;

import static com.cevichemadrileno.util.Constantes.salas;
import static com.cevichemadrileno.util.Constantes.usuarioAutenticado;

public class LoginTest {

    /**
     * Test para verificar que se puede loguear con credenciales correctas
     */
    @Test
    public void deberiaLoguearseExitosamente() {
        AccesoBD accesoBD = new AccesoBD();
        boolean resultadoLogin = accesoBD.login("123", "123");
        Assert.assertEquals(resultadoLogin, true);
    }

    /**
     * Test para verificar que no se puede loguear con credenciales incorrectas
     */
    @Test
    public void noDeberiaLoguearse() {
        AccesoBD accesoBD = new AccesoBD();
        boolean resultadoLogin = accesoBD.login("asdasd", "asdasdas");
        Assert.assertEquals(resultadoLogin, false);
    }

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

    /**
     * Test para verificar que se puede crear un usuario
     */
    @Test
    public void deberiaCrearUsuario(){
        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setCodigoMatricula("PRUEBA");
        usuario.setNombreApellidos("Usuario de prueba");
        usuario.setClave("123");
        usuario.setCiclo("DAW");
        usuario.setEsMonitor(false);

        // Guardar el usuario en la base de datos
        AccesoBD accesoBD = new AccesoBD();
        accesoBD.registrarUsuario(usuario);

        // Verificar que el usuario fue creado correctamente
        accesoBD.login("PRUEBA", "123");
        Assert.assertNotNull(usuarioAutenticado);

        // Limpiar la base de datos después de la prueba
        accesoBD.eliminarUsuario(usuarioAutenticado.getId());
    }

    /**
     * Test para verificar que se puede cargar la lista de salas
     */
    @Test
    public void deberiaCargarListaSalas(){
        AccesoBD accesoBD = new AccesoBD();
        accesoBD.cargarSalas();

        Assert.assertNotNull(salas);
        Assert.assertFalse(salas.isEmpty());
    }


}

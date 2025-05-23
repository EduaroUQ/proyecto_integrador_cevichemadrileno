import com.cevichemadrileno.modelo.AccesoBD;
import com.cevichemadrileno.modelo.Actividad;
import com.cevichemadrileno.modelo.Usuario;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;

import static com.cevichemadrileno.util.Constantes.salas;
import static com.cevichemadrileno.util.Constantes.usuarioAutenticado;

public class UsuarioTest {

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




}

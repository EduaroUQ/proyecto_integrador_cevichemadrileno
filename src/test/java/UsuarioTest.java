import com.cevichemadrileno.modelo.AccesoBD;
import com.cevichemadrileno.modelo.Usuario;
import com.cevichemadrileno.util.Constantes;
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
        usuario.setCodigoMatricula("PRU555");
        usuario.setNombreApellidos("Usuario de prueba");
        usuario.setClave("123");
        usuario.setCiclo("DAW");
        usuario.setEsMonitor(false);

        // Guardar el usuario en la base de datos
        AccesoBD accesoBD = new AccesoBD();
        accesoBD.registrarUsuario(usuario);

        // Verificar que el usuario fue creado correctamente
        Constantes.usuarioAutenticado = accesoBD.login("PRU555", "123");
        Assert.assertNotNull(Constantes.usuarioAutenticado);

        // Limpiar la base de datos después de la prueba
        accesoBD.eliminarUsuario(Constantes.usuarioAutenticado.getId());
    }




}

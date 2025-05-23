import com.cevichemadrileno.modelo.AccesoBD;
import org.junit.Assert;
import org.junit.Test;

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


}

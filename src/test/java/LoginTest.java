import com.cevichemadrileno.controlador.AccesoBD;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest {

    @Test
    public void deberiaLoguearseExitosamente() {
        AccesoBD accesoBD = new AccesoBD();
        boolean resultadoLogin = accesoBD.login("123", "123");
        Assert.assertEquals(resultadoLogin, true);
    }

    @Test
    public void noDeberiaLoguearse() {
        AccesoBD accesoBD = new AccesoBD();
        boolean resultadoLogin = accesoBD.login("asdasd", "asdasdas");
        Assert.assertEquals(resultadoLogin, false);
    }


}

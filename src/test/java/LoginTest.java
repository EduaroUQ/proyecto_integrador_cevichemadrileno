import com.cevichemadrileno.controlador.AccesoBD;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest {

    @Test
    public void primeraPrueba() {
        AccesoBD accesoBD = new AccesoBD();
        Assert.assertSame(1, 1);
    }

}

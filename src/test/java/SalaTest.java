import com.cevichemadrileno.modelo.AccesoBD;
import org.junit.Assert;
import org.junit.Test;

import static com.cevichemadrileno.util.Constantes.salas;

public class SalaTest {

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

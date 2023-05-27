package cancelacion_cuenta;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
public class CancelacionCodTest {
	@Test
	public void testFecha() {
		try {
			String fechaObtenida = CancelacionCod.fecha("leal.adrian.vacas@gmail.com");
			String fechaPrevista = "2023-01-01 00:00:00";
			assertEquals(fechaPrevista, fechaObtenida);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
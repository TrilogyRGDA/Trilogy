package cat_audiovisual;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class CatalogoAudiovisualTest {
	// PRUEBAS A PELÍCULAS
	@Test
	public void testObtImagenPeli() {
		ImageIcon imagen = CatalogoAudiovisual.obtenerImagenPelicula(0, 100, 100);
		assertNotNull(imagen);
	}
	@Test
	public void testDevRutaPeli() {
		String ruta = CatalogoAudiovisual.devolverRutaPeli(0);
		String resulEsperado = "/diamante_premium/peliculas/megan.jpg";
		assertEquals(resulEsperado, ruta);
	}
	@Test
	public void testAddStringPeli() {
		CatalogoAudiovisual.addStringPeli("/diamante_premium/peliculas/nueva_pelicula.jpg");
		String ruta = CatalogoAudiovisual.devolverRutaPeli(15);
		String resultEsperado = "/diamante_premium/peliculas/nueva_pelicula.jpg";
		assertEquals(resultEsperado, ruta);
	}
	@Test
	public void testDevolverID() {
		String id = CatalogoAudiovisual.devolverID("/diamante_premium/peliculas/megan.jpg");
		String resultEsperado="P_001";
		assertEquals(resultEsperado, id);
	}
	@Test
	public void testDevolverID_number() {
		int id = CatalogoAudiovisual.devolverID_number("/diamante_premium/peliculas/megan.jpg");
		int resultEsperado = 0;
		assertEquals(resultEsperado, id);
	}
	// PRUEBAS A MÚSICA Y ÁLBUMES
	@Test
	public void testObtTxtAlbum() {
		JLabel label = new JLabel();
		CatalogoAudiovisual.obtenerTextoAlbum(0, label);
		String resultEsperado="DONDE QUIERO ESTAR";
		assertEquals(resultEsperado, label.getText());
	}
	@Test
	public void testObtenerTextoCancion() {
		JLabel label = new JLabel();
		CatalogoAudiovisual.obtenerTextoCancion(0, label);
		String resultEsperado="DESPECHÁ";
		assertEquals(resultEsperado, label.getText());
	}
	@Test
	public void testObtenerImagenMusica() {
		ImageIcon imagen = CatalogoAudiovisual.obtenerImagenMusica(0, 100, 100);
		assertNotNull(imagen);
	}
	@Test
	public void testObtenerImagenAlbum() {
		ImageIcon imagen = CatalogoAudiovisual.obtenerImagenAlbum(0, 100, 100);
		assertNotNull(imagen);
	}
	@Test
	public void testDevolverRutaAlbum() {
		String ruta = CatalogoAudiovisual.devolverRutaAlbum(0);
		String resultEsperado="/Cristal_Basic/Portadas/dondequieroestar.png";
		assertEquals(resultEsperado, ruta);
	}
	@Test
	public void testDevolverID_number_album() {
		int id = CatalogoAudiovisual.devolverID_number_album("/Cristal_Basic/Portadas/dondequieroestar.png");
		int resultEsperado=1;
		assertEquals(resultEsperado, id);
	}
	@Test
	public void testDevolverID_array() {
		int id = CatalogoAudiovisual.devolverID_array("/Cristal_Basic/Portadas/dondequieroestar.png");
		int resultEsperado=0;
		assertEquals(resultEsperado, id);
	}
	// PRUEBAS DE SERIES, TEMPORADAS Y CAPÍTULOS
	@Test
	public void testObtenerImagenSeries() {
		ImageIcon imagen = CatalogoAudiovisual.obtenerImagenSeries(0, 100, 100);
		assertNotNull(imagen);
	}
	@Test
	public void testObtenerImagenCover() {
		ImageIcon imagen = CatalogoAudiovisual.obtenerImagenCover(0, 100, 100);
		assertNotNull(imagen);
	}
	@Test
	public void testDevolverRutaSerie() {
		String ruta = CatalogoAudiovisual.devolverRutaSerie(0);
		String resultEsperado="/Trilogy_imagenes/LaSenoraMaisel.jpg";
		assertEquals(resultEsperado, ruta);
	}
	@Test
	public void testDevolverIDserie() {
		String id = CatalogoAudiovisual.devolverIDserie("/Trilogy_imagenes/LaSenoraMaisel.jpg");
		String resultEsperado="S_01";
		assertEquals(resultEsperado, id);
	}
	@Test
	public void testDevolverID_numberserie() {
		int id = CatalogoAudiovisual.devolverID_numberserie("/Trilogy_imagenes/LaSenoraMaisel.jpg");
		int resultEsperado=0;
		assertEquals(resultEsperado, id);
	}
}
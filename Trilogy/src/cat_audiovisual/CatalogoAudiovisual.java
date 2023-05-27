package cat_audiovisual;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.util.ArrayList;
/**
 * La clase "CatalogoAudiovisual" es una página donde se encuentran todas las rutas de las imágenes de las películas, series y música.
 * En la parte de música tambien almacenamos los nombres de las caciones y álbumes.
 * No es una página visible para el usuario.
 * @author TRILOGY. Miembros: Adrián Leal Vacas, Gonzalo Amo Cano y Raúl Senso Montojo.
 */
public class CatalogoAudiovisual {
	// ATRIBUTO
	private static ArrayList<String> RUTAS_IMAGENES_PELI = new ArrayList<String>() {
		/**
		 * ArrayList que contiene todas las rutas de las imágenes de las películas.
		 * @since 19/04/2023
		 */
		private static final long serialVersionUID = 1L;
		{
			add("/diamante_premium/peliculas/megan.jpg");
			add("/diamante_premium/peliculas/Black_Adam.jpg");
			add("/diamante_premium/peliculas/escuadron_suicida.jpg");
			add("/diamante_premium/peliculas/fast_furious_hobbs_shaw.jpg");
			add("/diamante_premium/peliculas/jungla_de_cristal.jpg");
			add("/diamante_premium/peliculas/avatar_agua.jpg");
			add("/diamante_premium/peliculas/oso_vicioso.jpg");
			add("/diamante_premium/peliculas/super_mario_bros.jpg");
			add("/diamante_premium/peliculas/65.jpg");
			add("/diamante_premium/peliculas/dungeons_and_dragons.jpg");
			add("/diamante_premium/peliculas/el_exorcista_del_papa.jpg");
			add("/diamante_premium/peliculas/fast_and_furious_x.jpg");
			add("/diamante_premium/peliculas/gato_con_botas.jpg");
			add("/diamante_premium/peliculas/john_wick_4.jpg");
			add("/diamante_premium/peliculas/maridos.jpg");
		}};
		private static ArrayList<String> RUTAS_IMAGENES_SERIES = new ArrayList<String>() {
			/**
			 * ArrayList que contiene todas las rutas de las imágenes de las series.
			 * @since 19/04/2023
			 */
			private static final long serialVersionUID = 1L;
			{
				add("/Trilogy_imagenes/LaSenoraMaisel.jpg");
				add("/Trilogy_imagenes/TheOffice.jpg");
				add("/Trilogy_imagenes/DosChicasSinBlanca.jpg");
				add("/Trilogy_imagenes/AndJustLikeThat.jpg");
				add("/Trilogy_imagenes/Superstore.jpg");
				add("/Trilogy_imagenes/Friends.jpg");
				add("/Trilogy_imagenes/StrangerThings.jpg");
				add("/Trilogy_imagenes/CronicasVampiricas.jpg");
				add("/Trilogy_imagenes/TheLastOfUs.jpg");
				add("/Trilogy_imagenes/TheMandalorian.jpg");
				add("/Trilogy_imagenes/AliceInBordeland.jpg");
				add("/Trilogy_imagenes/EmilyEnParis.jpg");
				add("/Trilogy_imagenes/TheAmericans.jpg");
				add("/Trilogy_imagenes/TheBoys.jpg");
				add("/Trilogy_imagenes/TheManInTheHighCastle.jpg");
			}};
			private static ArrayList<String> RUTAS_IMAGENES_COVER = new ArrayList<String>() {
				/**
				 * ArrayList que contiene todas las rutas de las imágenes de las covers de las series, se usan en SeleccionCapSerie.
				 * @since 19/04/2023
				 */
				private static final long serialVersionUID = 1L;
				{
					add("/Trilogy_imagenes/LaSenoraMaiselCover.jpeg");
					add("/Trilogy_imagenes/TheOfficeCover.jpg");
					add("/Trilogy_imagenes/DosChicasSinBlancaCover.jpg");
					add("/Trilogy_imagenes/AndJustLikeThatCover.jpg");
					add("/Trilogy_imagenes/SuperstoreCover.jpg");
					add("/Trilogy_imagenes/FriendsCover.jpeg");
					add("/Trilogy_imagenes/StrangerThingsCover.jpg");
					add("/Trilogy_imagenes/CronicasVampiricasCover.jpg");
					add("/Trilogy_imagenes/TheLastOfUsCover.jpeg");
					add("/Trilogy_imagenes/TheMandalorianCover.jpg");
					add("/Trilogy_imagenes/AliceInBordelandCover.jpg");
					add("/Trilogy_imagenes/EmilyEnParisCover.jpg");
					add("/Trilogy_imagenes/TheAmericansCover.jpg");
					add("/Trilogy_imagenes/TheBoysCover.jpeg");
					add("/Trilogy_imagenes/TheManInTheHighCastleCover.jpg");
				}};
				private static ArrayList<String> RUTAS_IMAGENES_MUSICA = new ArrayList<String>() {
					/**
					 * ArrayList que contiene todas las rutas de las imágenes de las portadas de las canciones.
					 * @since 19/04/2023
					 */
					private static final long serialVersionUID = 1L;
					{
						add("/Cristal_Basic/Portadas/Despechá.png");
						add("/Cristal_Basic/Portadas/PlayaDelInglés.png");
						add("/Cristal_Basic/Portadas/LaInocente.png");
						add("/Cristal_Basic/Portadas/tqg.png");
						add("/Cristal_Basic/Portadas/Cupido.png");
						add("/Cristal_Basic/Portadas/SouceBoyz.png");
						add("/Cristal_Basic/Portadas/LykeMike.png");
						add("/Cristal_Basic/Portadas/Unveranosinti.png");
						add("/Cristal_Basic/Portadas/dondequieroestar.png");
						add("/Cristal_Basic/Portadas/caminando_por_la_vida.jpg");
						add("/Cristal_Basic/Portadas/soldadito_marinero.jpg");
						add("/Cristal_Basic/Portadas/una_vaina_loca.jpg");
						add("/Cristal_Basic/Portadas/3men2_kbrn.jpg");
						add("/Cristal_Basic/Portadas/jijantes.jpg");
						add("/Cristal_Basic/Portadas/mi_estralla_blanca.jpg");
					}};
					private static ArrayList<String> RUTAS_IMAGENES_ALBUM = new ArrayList<String>() {
						/**
						 * ArrayList que contiene todas las rutas de las imágenes de las portadas de los álbumes.
						 * @since 19/04/2023
						 */
						private static final long serialVersionUID = 1L;
						{
							add("/Cristal_Basic/Portadas/dondequieroestar.png");
							add("/Cristal_Basic/Portadas/Paraiso.png");
							add("/Cristal_Basic/Portadas/LykeMike.png");
							add("/Cristal_Basic/Portadas/YHLQMDLG.png");
							add("/Cristal_Basic/Portadas/SouceBoyz.png");
							add("/Cristal_Basic/Portadas/feliz_cumpleaños_ferxxo.jpg");
							add("/Cristal_Basic/Portadas/las_leyendas_nunca_mueren.jpg");
							add("/Cristal_Basic/Portadas/Unveranosinti.png");
							add("/Cristal_Basic/Portadas/la_vida_es_una.jpg");
							add("/Cristal_Basic/Portadas/rr.jpg");
							add("/Cristal_Basic/Portadas/motomami.jpg");
							add("/Cristal_Basic/Portadas/bien_o_mal.jpg");
							add("/Cristal_Basic/Portadas/3men2_kbrn.jpg");
							add("/Cristal_Basic/Portadas/energia.jpg");
							add("/Cristal_Basic/Portadas/barrio_fino.jpg");
						}};
						private static ArrayList<String> nombre_canciones=new ArrayList<String>() {
							/**
							 * ArrayList que contiene todos los nombres de las canciones.
							 * @since 19/04/2023
							 */
							private static final long serialVersionUID = 1L;
							{
								add("DESPECHÁ");
								add("PLAYA DEL INGLÉS");
								add("LA INOCENTE");
								add("TQG");
								add("CUPIDO");
								add("SIN FRENOS");
								add("MÍRENME AHORA");
								add("TITÍ ME PREGUNTÓ");
								add("APA");
								add("CAMINANDO POR LA VIDA");
								add("SOLDADITO MARINERO");
								add("UNA VAINA LOCA");
								add("SI SALIMOS");
								add("HIMNO JIJANTES");
								add("MI ESTRELLA BLANCA");
							}};
							private static ArrayList<String> nombre_albumes=new ArrayList<String>() {
								/**
								 * ArrayList que contiene todos los nombres de los álbumes.
								 * @since 19/04/2023
								 */
								private static final long serialVersionUID = 1L;
								{
									add("DONDE QUIERO ESTAR");
									add("PARAISO");
									add("LYKE MIKE");
									add("YHLQMDLG");
									add("SAUCE BOYZ");
									add("FELIZ CUMPLEAÑOS FERXXO");
									add("LAS LEYENDAS NUNCA MUEREN");
									add("UN VERANO SIN TI");
									add("LA VIDA ES UNA");
									add("RR");
									add("MOTOMAMI");
									add("BIEN O MAL");
									add("3MEN2 KBRN");
									add("ENERGÍA");
									add("BARRIO FINO");
								}};
								//-------------------------------------------------------------------------------------------------------------------------------
								// MÉTODOS
								//-------------------------------------------------------------------------------------------------------------------------------
								//-------------------------------------------------------------------------------------------------------------------------------
								// PELÍCULAS
								//-------------------------------------------------------------------------------------------------------------------------------
								// DEVOLVER ImageIcon PELI
								public static ImageIcon obtenerImagenPelicula(int indice, int width, int height) {
									ImageIcon imagen = new ImageIcon(CatalogoAudiovisual.class.getResource(RUTAS_IMAGENES_PELI.get(indice)));
									return new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
								}
								// DEVOLVER RUTA PELI
								public static String devolverRutaPeli(int indice) {
									return RUTAS_IMAGENES_PELI.get(indice);
								}
								// AGREGAR RUTA PELI
								public static void addStringPeli (String ruta) {
									RUTAS_IMAGENES_PELI.add(ruta);
								}
								// DEVOLVER POSICIÓN +1 DEL ARRAYLIST
								public static String devolverID (String ruta) {
									String id_peli="P_";
									int id= RUTAS_IMAGENES_PELI.indexOf(ruta);
									if ((id+1)<=9) {
										id_peli+="00"+(id+1);
									} else if ((id+1)>=10 && id<=99) {
										id_peli+="0"+(id+1);
									} else {
										id_peli+=(id+1);
									}
									return id_peli;
								}
								// DEVOLVER POSICIÓN DEL ARRAYLIST num
								public static int devolverID_number (String ruta) {
									int id= RUTAS_IMAGENES_PELI.indexOf(ruta);
									return id;
								}
								//-------------------------------------------------------------------------------------------------------------------------------
								// MÚSICA
								//-------------------------------------------------------------------------------------------------------------------------------
								//ASIGNAR NOMBRE ÁLBUM
								public static void  obtenerTextoAlbum(int indice, JLabel label) {
									String texto = nombre_albumes.get(indice);
									label.setText(texto);
								}
								//ASIGNAR NOMBRE CANCIÓN
								public static void  obtenerTextoCancion(int indice, JLabel label) {
									String texto = nombre_canciones.get(indice);
									label.setText(texto);
								}
								// DEVOLVER ImageIcon MÚSICA
								public static ImageIcon obtenerImagenMusica(int indice, int width, int height) {
									ImageIcon imagen = new ImageIcon(CatalogoAudiovisual.class.getResource(RUTAS_IMAGENES_MUSICA.get(indice)));
									return new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
								}
								// DEVOLVER ImageIcon ÁLBUM
								public static ImageIcon obtenerImagenAlbum(int indice, int width, int height) {
									ImageIcon imagen = new ImageIcon(CatalogoAudiovisual.class.getResource(RUTAS_IMAGENES_ALBUM.get(indice)));
									return new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
								}
								// DEVOLVER RUTA ÁLBUM
								public static String devolverRutaAlbum(int indice) {
									return RUTAS_IMAGENES_ALBUM.get(indice);
								}
								public static int devolverID_number_album (String ruta) {
									int id= RUTAS_IMAGENES_ALBUM.indexOf(ruta);
									return id+1;
								}
								public static int devolverID_array (String ruta) {
									int id= RUTAS_IMAGENES_ALBUM.indexOf(ruta);
									return id;
								}
								//-------------------------------------------------------------------------------------------------------------------------------
								// SERIES
								//-------------------------------------------------------------------------------------------------------------------------------
								// DEVOLVER ImageIcon SERIES
								public static ImageIcon obtenerImagenSeries(int indice, int width, int height) {
									ImageIcon imagen = new ImageIcon(CatalogoAudiovisual.class.getResource(RUTAS_IMAGENES_SERIES.get(indice)));
									return new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
								}
								// DEVOLVER ImageIcon COVERS
								public static ImageIcon obtenerImagenCover(int indice, int width, int height) {
									ImageIcon imagen = new ImageIcon(CatalogoAudiovisual.class.getResource(RUTAS_IMAGENES_COVER.get(indice)));
									return new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
								}
								// DEVOLVER RUTA CAPÍTULO
								public static String devolverRutaSerie(int indice) {
									return RUTAS_IMAGENES_SERIES.get(indice);
								}
								// DEVOLVER POSICIÓN +1 DEL ARRAYLIST
								public static String devolverIDserie (String ruta) {
									String id_serie="S_";
									int id= RUTAS_IMAGENES_SERIES.indexOf(ruta);
									if ((id+1)<=9) {
										id_serie+="0"+(id+1);
									} else if ((id+1)>=10 && id<=99) {
										id_serie+=""+(id+1);
									} else {
										id_serie+=(id+1);
									}
									return id_serie;
								}
								// DEVOLVER POSICIÓN +1 DEL ARRAYLIST num
								public static int devolverID_numberserie (String ruta) {
									int id_Serie= RUTAS_IMAGENES_SERIES.indexOf(ruta);
									return id_Serie;
								}
}
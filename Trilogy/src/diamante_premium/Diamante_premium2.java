package diamante_premium;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import cat_audiovisual.CatalogoAudiovisual;
import seleccionCapSerie.SeleccionCapSerie;
import seleccion_pelicula.Seleccion_pelicula;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * En la página de Diamante Premium 2 podrás consumir contenido audiovisual de películas, series y música según la selección y con un botón de recarga cambiará el contenido audiovisual respectivo a la selección.
 * Esta página tiene dos versiones, ya que el panel de la izquierda se puede maximizar de tamaño para una mejor visualización del contenido.
 * @param contentPane 
 * Contiene todos los atributos de la página.
 * @param panel_contenedor
 * Contiene todos los atributos para poder intercambiar paneles sin complicación.
 * @param lbl_Fondo
 * Tiene la imagen del fondo característico de Diamante Premium (Estético).
 * @param lbl_TXT_Peliculas
 * Tiene el título con el texto de las películas (Estético).
 * @param lbl_TXT_Series
 * Tiene el título con el texto de las series (Estético).
 * @param lbl_TXT_Musica
 * Tiene el título con el texto de la música (Estético).
 * @param lbl_IMGCancion1
 * Es un label con la función de pulsar y contiene la imagen de la canción que se va a reproducir.
 * @param lbl_IMGCancion2
 * Es un label con la función de pulsar y contiene la imagen de la canción que se va a reproducir.
 * @param lbl_IMGCancion3
 * Es un label con la función de pulsar y contiene la imagen de la canción que se va a reproducir.
 * @param lbl_IMGCancion4
 * Es un label con la función de pulsar y contiene la imagen de la canción que se va a reproducir.
 * @param lbl_IMGCancion5 
 * Es un label con la función de pulsar y contiene la imagen de la canción que se va a reproducir.
 * @param lbl_IMG_Peli_1 
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMG_Peli_2 
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMG_Peli_3
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMG_Peli_4
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMG_Peli_5 
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMGSerie1 
 * Es un label con la función de pulsar y contiene la imagen de la serie que se va a reproducir.
 * @param lbl_IMGSerie2
 * Es un label con la función de pulsar y contiene la imagen de la serie que se va a reproducir.
 * @param lbl_IMGSerie3
 * Es un label con la función de pulsar y contiene la imagen de la serie que se va a reproducir.
 * @param lbl_IMGSerie4
 * Es un label con la función de pulsar y contiene la imagen de la serie que se va a reproducir.
 * @param lbl_IMGSerie5
 * Es un label con la función de pulsar y contiene la imagen de la serie que se va a reproducir.
 * @param btn_Recarga_Musica
 * Botón que cambia el catálogo audiovisual de la música, para que puedas ver todo el contenido.
 * @param btn_Recarga_Peli
 * Botón que cambia el catálogo audiovisual de las películas, para que puedas ver todo el contenido.
 * @param btn_Recarga_Serie
 * Botón que cambia el catálogo audiovisual de las series, para que puedas ver todo el contenido.
 * @param lblTextoCancion1 
 * Tiene el texto del nombre de la canción correspondiendo con el label (lbl_IMG_Music_1).
 * @param lblTextoCancion2
 * Tiene el texto del nombre de la canción correspondiendo con el label (lbl_IMG_Music_2).
 * @param lblTextoCancion3 
 * Tiene el texto del nombre de la canción correspondiendo con el label (lbl_IMG_Music_3).
 * @param lblTextoCancion4
 * Tiene el texto del nombre de la canción correspondiendo con el label (lbl_IMG_Music_4).
 * @param lblTextoCancion5
 * Tiene el texto del nombre de la canción correspondiendo con el label (lbl_IMG_Music_5).
 * @author TRILOGY. Miembros: Adrián Leal Vacas, Gonzalo Amo Cano y Raúl Senso Montojo.
 */
public class Diamante_premium2 extends JFrame {
	/**
	 * Es la versión número 2 de la página del contenido audiovisual de la membresía Diamante Premium.
	 */
	private static final long serialVersionUID = 1L;
	// ----------------------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------------------
	private JPanel contentPane;
	private JPanel panel_contenedor;
	private JLabel lbl_Fondo;
	private JLabel lbl_TXT_Peliculas;
	private JLabel lbl_IMG_Peli_1;
	private JLabel lbl_IMGSerie1;
	private JLabel lbl_TXT_Musica;
	private JLabel lbl_IMGCancion1;
	private JLabel lbl_IMG_Peli_2;
	private JLabel lbl_IMGSerie2;
	private JLabel lbl_IMGCancion2;
	private JLabel lbl_IMG_Peli_3;
	private JLabel lbl_IMG_Peli_4;
	private JLabel lbl_IMGSerie3;
	private JLabel lbl_IMGSerie4;
	private JLabel lbl_IMGCancion3;
	private JLabel lbl_IMGCancion4;
	private JLabel lbl_IMGCancion5;
	private JLabel lbl_IMGSerie5;
	private JLabel lbl_IMG_Peli_5;
	private JLabel lbl_TXT_Series;
	private JButton btn_Recarga_Musica;
	private JButton btn_Recarga_Peli;
	private JButton btn_Recarga_Serie;
	private JLabel lblTextoCancion1;
	private JLabel lblTextoCancion2;
	private JLabel lblTextoCancion4;
	private JLabel lblTextoCancion3;
	private JLabel lblTextoCancion5;
	public static String ruta_peli;
	public static int contador=0;
	private static int num_peli=0;
	private static int num_peli_enlacep1=0;
	private static int num_peli_enlacep2=0;
	private static int num_peli_enlacep3=0;
	private static int num_peli_enlacep4=0;
	private static int num_peli_enlacep5=0;
	public static String ruta_serie;
	public static int contador2=0;
	public static int contadortemp=0;
	private static int num_serie=0;
	private static int num_serie_enlacep1=0;
	private static int num_serie_enlacep2=0;
	private static int num_serie_enlacep3=0;
	private static int num_serie_enlacep4=0;
	private static int num_serie_enlacep5=0;
	public static String ruta_album;
	public static int contador1_1=0;
	public static int contador1_2=0;
	private static int num_cancion=0;
	// ATRIBUTOS Y OBJETOS NECESARIOS PARA LA CONEXIÓN A LA BASE DE DATOS Y LA REALIZACIÓN DE UN CONSULTA BÁSICA
	private static String bd="XE"; // NOMBRE DE LA BASE DE DATOS POR DEFECTO, SIEMPRE DEJAR EL "XE"
	private static String login="TRILOGY"; // USUARIO DE LA BBDD
	private static String password="TRILOGY"; // CONTRASEÑA DE LA BBDD
	// RUTA DE SERVICIO
	private static String url="jdbc:oracle:thin:@localhost:1521:"+bd;
	// PONEMOS LOS OBJETOS A NULL Y SIN INSTANCIAR
	static Connection connection=null; // CONEXIÓN A LA BASE DE DATOS
	static Statement st; // PARA REALIZAR SQL ESTÁTICAS (HAY QUE ENLAZARLA SIEMPRE CON EL "Connection" SINO, NO FUNCIONA)
	static ResultSet rs; // PARA REALIZAR LA CONSULTA IGUAL QUE EN SQL DEVELOPER
	// ----------------------------------------------------------------------------------------
	// GETTERS AND SETTERS
	// ----------------------------------------------------------------------------------------
	public JPanel getPanel_contenedor() {
		return panel_contenedor;
	}
	public void setPanel_contenedor(JPanel panel_contenedor) {
		this.panel_contenedor = panel_contenedor;
	}
	// ----------------------------------------------------------------------------------------
	// MÉTODO MAIN
	// ----------------------------------------------------------------------------------------
	/**
	 * En el meétodo main ejecutamos la ventana principal Diamante_premium2.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diamante_premium2 frame = new Diamante_premium2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// ----------------------------------------------------------------------------------------
	// CONSTRUCTOR
	// ----------------------------------------------------------------------------------------
	/**
	 * En el constructor Diamante_premium2() están todos los atributos y métodos necesarios para cuando creemos el objeto tenga todas las funcionalidades.
	 */
	public Diamante_premium2() {
		// ----------------------------------------------------------------------------------------
		// contentPane CONTIENE TODOS LOS ATRIBUTOS DE LA PÁGINA
		// ----------------------------------------------------------------------------------------
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// ----------------------------------------------------------------------------------------
		// panel_contenedor CONTIENE TODOS LOS ATRIBUTOS PARA PODER INTERCAMBIAR PANELES SIN COMPLICACIÓN
		// ----------------------------------------------------------------------------------------
		panel_contenedor = new JPanel();
		panel_contenedor.setBounds(0, 0, 1130, 663);
		panel_contenedor.setLayout(null);
		// ----------------------------------------------------------------------------------------
		// lbl_Fondo TIENE LA IMAGEN DE FONDO DE LA PÁGINA
		// ----------------------------------------------------------------------------------------
		lbl_Fondo = new JLabel();
		lbl_Fondo.setBounds(0, 0, 1130, 663);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon logoOriginal = new ImageIcon(getClass().getResource("/Trilogy_imagenes/Fondo_Diamante_Premium.jpg")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgLogoOriginal = new ImageIcon(logoOriginal.getImage().getScaledInstance(lbl_Fondo.getWidth(), lbl_Fondo.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		lbl_Fondo.setIcon(imgLogoOriginal);
		// ----------------------------------------------------------------------------------------
		// lbl_TXT_Peliculas TIENE EL TEXTO DE PELÍCULAS
		// ----------------------------------------------------------------------------------------
		lbl_TXT_Peliculas = new JLabel("PELÍCULAS");
		lbl_TXT_Peliculas.setBounds(180, 20, 843, 30);
		lbl_TXT_Peliculas.setOpaque(true);
		lbl_TXT_Peliculas.setBackground(new Color(204, 255, 204));
		lbl_TXT_Peliculas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TXT_Peliculas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_TXT_Peliculas.setBorder(new LineBorder(new Color(211,211,211)));
		// ----------------------------------------------------------------------------------------
		// lbl_TXT_Series TIENE EL TEXTO DE SERIES
		// ----------------------------------------------------------------------------------------
		lbl_TXT_Series = new JLabel("SERIES");
		lbl_TXT_Series.setOpaque(true);
		lbl_TXT_Series.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TXT_Series.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_TXT_Series.setBorder(new LineBorder(new Color(211,211,211)));
		lbl_TXT_Series.setBackground(new Color(204, 255, 204));
		lbl_TXT_Series.setBounds(180, 234, 843, 30);
		// ----------------------------------------------------------------------------------------
		// lbl_TXT_Musica TIENE EL TEXTO DE MÚSICA
		// ----------------------------------------------------------------------------------------
		lbl_TXT_Musica = new JLabel("MÚSICA");
		lbl_TXT_Musica.setOpaque(true);
		lbl_TXT_Musica.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TXT_Musica.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_TXT_Musica.setBorder(new LineBorder(new Color(211,211,211)));
		lbl_TXT_Musica.setBackground(new Color(204, 255, 204));
		lbl_TXT_Musica.setBounds(180, 448, 843, 30);
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Peli_1 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMG_Peli_1 = new JLabel();
		lbl_IMG_Peli_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMG_Peli_1.setBounds(215, 72, 115, 140);
		lbl_IMG_Peli_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_peli_enlacep1==0) {
					num_peli=0;
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				} else {
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli_enlacep1);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				}
			}
		});
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMG_Peli_1.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(0,lbl_IMG_Peli_1.getWidth(),lbl_IMG_Peli_1.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Peli_2 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMG_Peli_2 = new JLabel();
		lbl_IMG_Peli_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMG_Peli_2.setBounds(380, 72, 115, 140);
		lbl_IMG_Peli_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_peli_enlacep2==0) {
					num_peli=1;
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				} else {
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli_enlacep2);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				}
			}
		});
		lbl_IMG_Peli_2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(1,lbl_IMG_Peli_2.getWidth(),lbl_IMG_Peli_2.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Peli_3 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMG_Peli_3 = new JLabel();
		lbl_IMG_Peli_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMG_Peli_3.setBounds(545, 72, 115, 140);
		lbl_IMG_Peli_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_peli_enlacep3==0) {
					num_peli=2;
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				} else {
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli_enlacep3);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				}
			}
		});
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMG_Peli_3.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(2,lbl_IMG_Peli_3.getWidth(),lbl_IMG_Peli_3.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Peli_4 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMG_Peli_4 = new JLabel();
		lbl_IMG_Peli_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMG_Peli_4.setBounds(710, 72, 115, 140);
		lbl_IMG_Peli_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_peli_enlacep4==0) {
					num_peli=3;
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				} else {
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli_enlacep4);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				}
			}
		});
		lbl_IMG_Peli_4.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(3,lbl_IMG_Peli_4.getWidth(),lbl_IMG_Peli_4.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Peli_5 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMG_Peli_5 =  new JLabel();
		lbl_IMG_Peli_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMG_Peli_5.setBounds(875, 72, 115, 140);
		lbl_IMG_Peli_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_peli_enlacep5==0) {
					num_peli=4;
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				} else {
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli_enlacep5);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				}
			}
		});
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMG_Peli_5.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(4,lbl_IMG_Peli_5.getWidth(),lbl_IMG_Peli_5.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Serie_1 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMGSerie1 = new JLabel();
		lbl_IMGSerie1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_serie_enlacep1==0) {
					num_serie=0;
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						// EJECUTAMOS LA QUERY ANTERIOR
						rs = stmt.executeQuery();
						// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
						// MIENTRAS QUE HAYA SIGUIENTE
						while (rs.next()) {
							// ALMACENA EL DATO DE LA COLUMNA
							contadortemp += rs.getInt(1);
						}
						rs.close();
						stmt.close();
						conexion.close();
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
						e2.printStackTrace();
					}
					SeleccionCapSerie prueba1 = new SeleccionCapSerie();
					prueba1.setVisible(true);
				} else  {
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie_enlacep1);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						// EJECUTAMOS LA QUERY ANTERIOR
						rs = stmt.executeQuery();
						// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
						// MIENTRAS QUE HAYA SIGUIENTE
						while (rs.next()) {
							// ALMACENA EL DATO DE LA COLUMNA
							contadortemp += rs.getInt(1);
						}
						rs.close();
						stmt.close();
						conexion.close();
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
						e2.printStackTrace();
					}
					SeleccionCapSerie prueba1 = new SeleccionCapSerie();
					prueba1.setVisible(true);
				}  	
			}
		});
		lbl_IMGSerie1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGSerie1.setBounds(215, 286, 115, 140);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie1.setIcon(CatalogoAudiovisual.obtenerImagenSeries(0,lbl_IMGSerie1.getWidth(),lbl_IMGSerie1.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Serie_2 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMGSerie2 = new JLabel();
		lbl_IMGSerie2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_serie_enlacep2==0) {
					num_serie=1;
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						// EJECUTAMOS LA QUERY ANTERIOR
						rs = stmt.executeQuery();
						// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
						// MIENTRAS QUE HAYA SIGUIENTE
						while (rs.next()) {
							// ALMACENA EL DATO DE LA COLUMNA
							contadortemp += rs.getInt(1);
						}
						rs.close();
						stmt.close();
						conexion.close();
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
						e2.printStackTrace();
					}
					SeleccionCapSerie prueba1 = new SeleccionCapSerie();
					prueba1.setVisible(true);
				} else {
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie_enlacep2);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						// EJECUTAMOS LA QUERY ANTERIOR
						rs = stmt.executeQuery();
						// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
						// MIENTRAS QUE HAYA SIGUIENTE
						while (rs.next()) {
							// ALMACENA EL DATO DE LA COLUMNA
							contadortemp += rs.getInt(1);
						}
						rs.close();
						stmt.close();
						conexion.close();
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
						e2.printStackTrace();
					}
					SeleccionCapSerie prueba1 = new SeleccionCapSerie();
					prueba1.setVisible(true);
				}
			}
		});
		lbl_IMGSerie2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGSerie2.setBounds(380, 286, 115, 140);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie2.setIcon(CatalogoAudiovisual.obtenerImagenSeries(1,lbl_IMGSerie2.getWidth(),lbl_IMGSerie2.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Serie_3 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMGSerie3 = new JLabel();
		lbl_IMGSerie3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_serie_enlacep3==0) {
					num_serie=2;
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						// EJECUTAMOS LA QUERY ANTERIOR
						rs = stmt.executeQuery();
						// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
						// MIENTRAS QUE HAYA SIGUIENTE
						while (rs.next()) {
							// ALMACENA EL DATO DE LA COLUMNA
							contadortemp += rs.getInt(1);
						}
						rs.close();
						stmt.close();
						conexion.close();
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
						e2.printStackTrace();
					}
					SeleccionCapSerie prueba1 = new SeleccionCapSerie();
					prueba1.setVisible(true);
				} else {
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie_enlacep3);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						// EJECUTAMOS LA QUERY ANTERIOR
						rs = stmt.executeQuery();
						// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
						// MIENTRAS QUE HAYA SIGUIENTE
						while (rs.next()) {
							// ALMACENA EL DATO DE LA COLUMNA
							contadortemp += rs.getInt(1);
						}
						rs.close();
						stmt.close();
						conexion.close();
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
						e2.printStackTrace();
					}
					SeleccionCapSerie prueba1 = new SeleccionCapSerie();
					prueba1.setVisible(true);
				}
			}
		});
		lbl_IMGSerie3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGSerie3.setBounds(545, 286, 115, 140);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie3.setIcon(CatalogoAudiovisual.obtenerImagenSeries(2,lbl_IMGSerie3.getWidth(),lbl_IMGSerie3.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Serie_4 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMGSerie4 = new JLabel();
		lbl_IMGSerie4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_serie_enlacep4==0) {
					num_serie=3;
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						// EJECUTAMOS LA QUERY ANTERIOR
						rs = stmt.executeQuery();
						// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
						// MIENTRAS QUE HAYA SIGUIENTE
						while (rs.next()) {
							// ALMACENA EL DATO DE LA COLUMNA
							contadortemp += rs.getInt(1);
						}
						rs.close();
						stmt.close();
						conexion.close();
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
						e2.printStackTrace();
					}
					SeleccionCapSerie prueba1 = new SeleccionCapSerie();
					prueba1.setVisible(true);
				} else {
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie_enlacep4);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						// EJECUTAMOS LA QUERY ANTERIOR
						rs = stmt.executeQuery();
						// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
						// MIENTRAS QUE HAYA SIGUIENTE
						while (rs.next()) {
							// ALMACENA EL DATO DE LA COLUMNA
							contadortemp += rs.getInt(1);
						}
						rs.close();
						stmt.close();
						conexion.close();
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
						e2.printStackTrace();
					}
					SeleccionCapSerie prueba1 = new SeleccionCapSerie();
					prueba1.setVisible(true);
				}
			}
		});
		lbl_IMGSerie4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGSerie4.setBounds(710, 286, 115, 140);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie4.setIcon(CatalogoAudiovisual.obtenerImagenSeries(3,lbl_IMGSerie4.getWidth(),lbl_IMGSerie4.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Serie_5 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMGSerie5 = new JLabel("");
		lbl_IMGSerie5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_serie_enlacep5==0) {
					num_serie=4;
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						// EJECUTAMOS LA QUERY ANTERIOR
						rs = stmt.executeQuery();
						// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
						// MIENTRAS QUE HAYA SIGUIENTE
						while (rs.next()) {
							// ALMACENA EL DATO DE LA COLUMNA
							contadortemp += rs.getInt(1);
						}
						rs.close();
						stmt.close();
						conexion.close();
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
						e2.printStackTrace();
					}
					SeleccionCapSerie prueba1 = new SeleccionCapSerie();
					prueba1.setVisible(true);
				} else {
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie_enlacep5);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						// EJECUTAMOS LA QUERY ANTERIOR
						rs = stmt.executeQuery();
						// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
						// MIENTRAS QUE HAYA SIGUIENTE
						while (rs.next()) {
							// ALMACENA EL DATO DE LA COLUMNA
							contadortemp += rs.getInt(1);
						}
						rs.close();
						stmt.close();
						conexion.close();
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
						e2.printStackTrace();
					}
					SeleccionCapSerie prueba1 = new SeleccionCapSerie();
					prueba1.setVisible(true);
				}
			}
		});
		lbl_IMGSerie5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGSerie5.setBounds(875, 286, 115, 140);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie5.setIcon(CatalogoAudiovisual.obtenerImagenSeries(4,lbl_IMGSerie5.getWidth(),lbl_IMGSerie5.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Music_1 TIENE LA IMAGEN DE LA MÚSICA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMGCancion1 = new JLabel();
		lbl_IMGCancion1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA CANCIÓN EN EL REPRODUCTOR POR DEFECTO DE TU ORDENADOR
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		lbl_IMGCancion1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGCancion1.setBounds(200, 500, 125, 120);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGCancion1.setIcon(CatalogoAudiovisual.obtenerImagenMusica(0,lbl_IMGCancion1.getWidth(),lbl_IMGCancion1.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Music_2 TIENE LA IMAGEN DE LA MÚSICA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMGCancion2 = new JLabel();
		lbl_IMGCancion2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA CANCIÓN EN EL REPRODUCTOR POR DEFECTO DE TU ORDENADOR
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		lbl_IMGCancion2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGCancion2.setBounds(370, 500, 125, 120);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGCancion2.setIcon(CatalogoAudiovisual.obtenerImagenMusica(1,lbl_IMGCancion2.getWidth(),lbl_IMGCancion2.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Music_3 TIENE LA IMAGEN DE LA MÚSICA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMGCancion3 = new JLabel();
		lbl_IMGCancion3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA CANCIÓN EN EL REPRODUCTOR POR DEFECTO DE TU ORDENADOR
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		lbl_IMGCancion3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGCancion3.setBounds(541, 500, 125, 120);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGCancion3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(2,lbl_IMGCancion3.getWidth(),lbl_IMGCancion3.getHeight()));	
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Music_4 TIENE LA IMAGEN DE LA MÚSICA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMGCancion4 = new JLabel();
		lbl_IMGCancion4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA CANCIÓN EN EL REPRODUCTOR POR DEFECTO DE TU ORDENADOR
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		lbl_IMGCancion4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGCancion4.setBounds(710, 500, 125, 120);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGCancion4.setIcon(CatalogoAudiovisual.obtenerImagenMusica(3,lbl_IMGCancion4.getWidth(),lbl_IMGCancion4.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lbl_IMG_Music_5 TIENE LA IMAGEN DE LA MÚSICA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lbl_IMGCancion5 = new JLabel();
		lbl_IMGCancion5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA CANCIÓN EN EL REPRODUCTOR POR DEFECTO DE TU ORDENADOR
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		lbl_IMGCancion5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGCancion5.setBounds(878, 500, 125, 120);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGCancion5.setIcon(CatalogoAudiovisual.obtenerImagenMusica(4,lbl_IMGCancion5.getWidth(),lbl_IMGCancion5.getHeight()));
		// ----------------------------------------------------------------------------------------
		// lblTextoCancion1 TIENE EL TEXTO DEL NOMBRE DE LA MÚSICA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lblTextoCancion1 = new JLabel("DESPECHÁ");
		lblTextoCancion1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoCancion1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTextoCancion1.setForeground(new Color(0,0,0));
		lblTextoCancion1.setBounds(200, 628, 125, 20);
		// ----------------------------------------------------------------------------------------
		// lblTextoCancion2 TIENE EL TEXTO DEL NOMBRE DE LA MÚSICA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lblTextoCancion2 = new JLabel("PLAYA DEL INGLÉS");
		lblTextoCancion2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoCancion2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTextoCancion2.setForeground(new Color(0,0,0));
		lblTextoCancion2.setBounds(370, 628, 125, 20);
		// ----------------------------------------------------------------------------------------
		// lblTextoCancion3 TIENE EL TEXTO DEL NOMBRE DE LA MÚSICA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lblTextoCancion3 = new JLabel("LA INOCENTE");
		lblTextoCancion3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoCancion3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTextoCancion3.setForeground(new Color(0,0,0));
		lblTextoCancion3.setBounds(541, 628, 125, 20);
		// ----------------------------------------------------------------------------------------
		// lblTextoCancion4 TIENE EL TEXTO DEL NOMBRE DE LA MÚSICA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lblTextoCancion4 = new JLabel("TQG");
		lblTextoCancion4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoCancion4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTextoCancion4.setForeground(new Color(0,0,0));
		lblTextoCancion4.setBounds(710, 628, 125, 20);
		// ----------------------------------------------------------------------------------------
		// lblTextoCancion5 TIENE EL TEXTO DEL NOMBRE DE LA MÚSICA QUE SE VA A REPRODUCIR
		// ----------------------------------------------------------------------------------------
		lblTextoCancion5 = new JLabel("CUPIDO");
		lblTextoCancion5.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoCancion5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTextoCancion5.setForeground(new Color(0,0,0));
		lblTextoCancion5.setBounds(878, 628, 125, 20);
		// ----------------------------------------------------------------------------------------
		// btn_Recarga_Peli CAMBIA LAS PELÍCULAS
		// ----------------------------------------------------------------------------------------
		contador=0;
		btn_Recarga_Peli = new JButton("");
		btn_Recarga_Peli.addMouseListener(new MouseAdapter() {
			@Override
			//CUANDO PASAS EL RATÓN POR ENCIMA
			public void mouseEntered(MouseEvent e) {
				btn_Recarga_Peli.setContentAreaFilled(true);
				btn_Recarga_Peli.setBackground(new Color(255, 255, 255, 160));
			}
			@Override
			//CUANDO EL RATÓN NO ESTÁ EN EL ÁREA DEL BOTÓN
			public void mouseExited(MouseEvent e) {
				btn_Recarga_Peli.setContentAreaFilled(false);
			}
			@Override
			//CUANDO PULSAS
			public void mouseClicked(MouseEvent e) {
				// INCREMENTO CONTADOR CADA VEZ QUE SE PULSA
				contador+=1;
				if(contador==1) {
					num_peli=5;
					// lbl_IMG_Peli_1
					lbl_IMG_Peli_1.setVisible(false);
					lbl_IMG_Peli_1.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_1.getWidth(),lbl_IMG_Peli_1.getHeight()));
					lbl_IMG_Peli_1.setVisible(true);
					num_peli_enlacep1=num_peli;
					num_peli++;
					// lbl_IMG_Peli_2
					lbl_IMG_Peli_2.setVisible(false);
					lbl_IMG_Peli_2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_2.getWidth(),lbl_IMG_Peli_2.getHeight()));
					lbl_IMG_Peli_2.setVisible(true);
					num_peli_enlacep2=num_peli;
					num_peli++;
					// lbl_IMG_Peli_3
					lbl_IMG_Peli_3.setVisible(false);
					lbl_IMG_Peli_3.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_3.getWidth(),lbl_IMG_Peli_3.getHeight()));
					lbl_IMG_Peli_3.setVisible(true);
					num_peli_enlacep3=num_peli;
					num_peli++;
					// lbl_IMG_Peli_4
					lbl_IMG_Peli_4.setVisible(false);
					lbl_IMG_Peli_4.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_4.getWidth(),lbl_IMG_Peli_4.getHeight()));
					lbl_IMG_Peli_4.setVisible(true);
					num_peli_enlacep4=num_peli;
					num_peli++;
					// lbl_IMG_Peli_5
					lbl_IMG_Peli_5.setVisible(false);
					lbl_IMG_Peli_5.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_5.getWidth(),lbl_IMG_Peli_5.getHeight()));
					lbl_IMG_Peli_5.setVisible(true);
					num_peli_enlacep5=num_peli;
				} else if (contador==2) {
					num_peli=10;
					// lbl_IMG_Peli_1
					lbl_IMG_Peli_1.setVisible(false);
					lbl_IMG_Peli_1.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_1.getWidth(),lbl_IMG_Peli_1.getHeight()));
					lbl_IMG_Peli_1.setVisible(true);
					num_peli_enlacep1=num_peli;
					num_peli++;
					// lbl_IMG_Peli_2
					lbl_IMG_Peli_2.setVisible(false);
					lbl_IMG_Peli_2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_2.getWidth(),lbl_IMG_Peli_2.getHeight()));
					lbl_IMG_Peli_2.setVisible(true);
					num_peli_enlacep2=num_peli;
					num_peli++;
					// lbl_IMG_Peli_3
					lbl_IMG_Peli_3.setVisible(false);
					lbl_IMG_Peli_3.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_3.getWidth(),lbl_IMG_Peli_3.getHeight()));
					lbl_IMG_Peli_3.setVisible(true);
					num_peli_enlacep3=num_peli;
					num_peli++;
					// lbl_IMG_Peli_4
					lbl_IMG_Peli_4.setVisible(false);
					lbl_IMG_Peli_4.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_4.getWidth(),lbl_IMG_Peli_4.getHeight()));
					lbl_IMG_Peli_4.setVisible(true);
					num_peli_enlacep4=num_peli;
					num_peli++;
					// lbl_IMG_Peli_5
					lbl_IMG_Peli_5.setVisible(false);
					lbl_IMG_Peli_5.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_5.getWidth(),lbl_IMG_Peli_5.getHeight()));
					lbl_IMG_Peli_5.setVisible(true);
					num_peli_enlacep5=num_peli;
					num_peli++;
				} else {
					// REINICIO CONTADOR
					contador=0;
					num_peli=0;
					// lbl_IMG_Peli_1
					lbl_IMG_Peli_1.setVisible(false);
					lbl_IMG_Peli_1.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_1.getWidth(),lbl_IMG_Peli_1.getHeight()));
					lbl_IMG_Peli_1.setVisible(true);
					num_peli_enlacep1=num_peli;
					num_peli++;
					// lbl_IMG_Peli_2
					lbl_IMG_Peli_2.setVisible(false);
					lbl_IMG_Peli_2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_2.getWidth(),lbl_IMG_Peli_2.getHeight()));
					lbl_IMG_Peli_2.setVisible(true);
					num_peli_enlacep2=num_peli;
					num_peli++;
					// lbl_IMG_Peli_3
					lbl_IMG_Peli_3.setVisible(false);
					lbl_IMG_Peli_3.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_3.getWidth(),lbl_IMG_Peli_3.getHeight()));
					lbl_IMG_Peli_3.setVisible(true);
					num_peli_enlacep3=num_peli;
					num_peli++;
					// lbl_IMG_Peli_4
					lbl_IMG_Peli_4.setVisible(false);
					lbl_IMG_Peli_4.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_4.getWidth(),lbl_IMG_Peli_4.getHeight()));
					lbl_IMG_Peli_4.setVisible(true);
					num_peli_enlacep4=num_peli;
					num_peli++;
					// lbl_IMG_Peli_5
					lbl_IMG_Peli_5.setVisible(false);
					lbl_IMG_Peli_5.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMG_Peli_5.getWidth(),lbl_IMG_Peli_5.getHeight()));
					lbl_IMG_Peli_5.setVisible(true);
					num_peli_enlacep5=num_peli;
				}
			}
		});
		btn_Recarga_Peli.setBorderPainted(false);
		btn_Recarga_Peli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Recarga_Peli.setContentAreaFilled(false);
		btn_Recarga_Peli.setBounds(79, 117, 50, 50);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon recarga_Peli = new ImageIcon(getClass().getResource("/Trilogy_imagenes/actualizacion.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgRecarga_Peli = new ImageIcon(recarga_Peli.getImage().getScaledInstance(btn_Recarga_Peli.getWidth(), btn_Recarga_Peli.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		btn_Recarga_Peli.setIcon(imgRecarga_Peli);
		// ----------------------------------------------------------------------------------------
		// btn_Recarga_Serie CAMBIA LAS SERIES
		// ----------------------------------------------------------------------------------------
		contador2=0;
		btn_Recarga_Serie = new JButton("");
		btn_Recarga_Serie.addMouseListener(new MouseAdapter() {
			@Override
			//CUANDO EL RATÓN PASA POR ENCIMA
			public void mouseEntered(MouseEvent e) {
				btn_Recarga_Serie.setContentAreaFilled(true);
				btn_Recarga_Serie.setBackground(new Color(255, 255, 255, 160));
			}
			@Override
			//CUANDO EL RATÓN SALE DEL ÁREA DEL BOTÓN
			public void mouseExited(MouseEvent e) {
				btn_Recarga_Serie.setContentAreaFilled(false);
			}
			@Override
			//CUANDO PULSAS
			public void mouseClicked(MouseEvent e) {
				// Incremento contador cada vez que se pulsa
				contador2+=1;
				if(contador2==1) {
					num_serie=5;
					// lbl_IMGSerie1
					lbl_IMGSerie1.setVisible(false);
					lbl_IMGSerie1.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie1.getWidth(),lbl_IMGSerie1.getHeight()));
					lbl_IMGSerie1.setVisible(true);
					num_serie_enlacep1=num_serie;
					num_serie++;
					// lbl_IMGSerie2
					lbl_IMGSerie2.setVisible(false);
					lbl_IMGSerie2.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie2.getWidth(),lbl_IMGSerie2.getHeight()));
					lbl_IMGSerie2.setVisible(true);
					num_serie_enlacep2=num_serie;
					num_serie++;
					// lbl_IMGSerie3
					lbl_IMGSerie3.setVisible(false);
					lbl_IMGSerie3.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie3.getWidth(),lbl_IMGSerie3.getHeight()));
					lbl_IMGSerie3.setVisible(true);
					num_serie_enlacep3=num_serie;
					num_serie++;
					// lbl_IMGSerie4
					lbl_IMGSerie4.setVisible(false);
					lbl_IMGSerie4.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie4.getWidth(),lbl_IMGSerie4.getHeight()));
					lbl_IMGSerie4.setVisible(true);
					num_serie_enlacep4=num_serie;
					num_serie++;
					// lbl_IMGSerie5
					lbl_IMGSerie5.setVisible(false);
					lbl_IMGSerie5.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie5.getWidth(),lbl_IMGSerie5.getHeight()));
					lbl_IMGSerie5.setVisible(true);
					num_serie_enlacep5=num_serie;
				} else if (contador2==2) {
					num_serie=10;
					// lbl_IMGSerie1
					lbl_IMGSerie1.setVisible(false);
					lbl_IMGSerie1.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie1.getWidth(),lbl_IMGSerie1.getHeight()));
					lbl_IMGSerie1.setVisible(true);
					num_serie_enlacep1=num_serie;
					num_serie++;
					// lbl_IMGSerie2
					lbl_IMGSerie2.setVisible(false);
					lbl_IMGSerie2.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie2.getWidth(),lbl_IMGSerie2.getHeight()));
					lbl_IMGSerie2.setVisible(true);
					num_serie_enlacep2=num_serie;
					num_serie++;
					// lbl_IMGSerie3
					lbl_IMGSerie3.setVisible(false);
					lbl_IMGSerie3.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie3.getWidth(),lbl_IMGSerie3.getHeight()));
					lbl_IMGSerie3.setVisible(true);
					num_serie_enlacep3=num_serie;
					num_serie++;
					// lbl_IMGSerie4
					lbl_IMGSerie4.setVisible(false);
					lbl_IMGSerie4.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie4.getWidth(),lbl_IMGSerie4.getHeight()));
					lbl_IMGSerie4.setVisible(true);
					num_serie_enlacep4=num_serie;
					num_serie++;
					// lbl_IMGSerie5
					lbl_IMGSerie5.setVisible(false);
					lbl_IMGSerie5.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie5.getWidth(),lbl_IMGSerie5.getHeight()));
					lbl_IMGSerie5.setVisible(true);
					num_serie_enlacep5=num_serie;
					num_serie++;
				} else {
					// REINICIO CONTADOR
					contador2=0;
					num_serie=0;
					// lbl_IMGSerie1
					lbl_IMGSerie1.setVisible(false);
					lbl_IMGSerie1.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie1.getWidth(),lbl_IMGSerie1.getHeight()));
					lbl_IMGSerie1.setVisible(true);
					num_serie_enlacep1=num_serie;
					num_serie++;
					// lbl_IMGSerie2
					lbl_IMGSerie2.setVisible(false);
					lbl_IMGSerie2.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie2.getWidth(),lbl_IMGSerie2.getHeight()));
					lbl_IMGSerie2.setVisible(true);
					num_serie_enlacep2=num_serie;
					num_serie++;
					// lbl_IMGSerie3
					lbl_IMGSerie3.setVisible(false);
					lbl_IMGSerie3.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie3.getWidth(),lbl_IMGSerie3.getHeight()));
					lbl_IMGSerie3.setVisible(true);
					num_serie_enlacep3=num_serie;
					num_serie++;
					// lbl_IMGSerie4
					lbl_IMGSerie4.setVisible(false);
					lbl_IMGSerie4.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie4.getWidth(),lbl_IMGSerie4.getHeight()));
					lbl_IMGSerie4.setVisible(true);
					num_serie_enlacep4=num_serie;
					num_serie++;
					// lbl_IMGSerie5
					lbl_IMGSerie5.setVisible(false);
					lbl_IMGSerie5.setIcon(CatalogoAudiovisual.obtenerImagenSeries(num_serie,lbl_IMGSerie5.getWidth(),lbl_IMGSerie5.getHeight()));
					lbl_IMGSerie5.setVisible(true);
					num_serie_enlacep5=num_serie;
				}
			}
		});
		btn_Recarga_Serie.setBorderPainted(false);
		btn_Recarga_Serie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Recarga_Serie.setContentAreaFilled(false);
		btn_Recarga_Serie.setBounds(79, 333, 50, 50);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon recarga_Serie = new ImageIcon(getClass().getResource("/Trilogy_imagenes/actualizacion.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgRecarga_Serie = new ImageIcon(recarga_Serie.getImage().getScaledInstance(btn_Recarga_Serie.getWidth(), btn_Recarga_Serie.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		btn_Recarga_Serie.setIcon(imgRecarga_Serie);
		// ----------------------------------------------------------------------------------------
		// btn_Recarga_Musica CAMBIA LA MÚSICA
		// ----------------------------------------------------------------------------------------
		contador1_1=0;
		btn_Recarga_Musica = new JButton("");
		btn_Recarga_Musica.addMouseListener(new MouseAdapter() {
			@Override
			//CUANDO EL RATÓN PASA POR ENCIMA
			public void mouseEntered(MouseEvent e) {
				btn_Recarga_Musica.setContentAreaFilled(true);
				btn_Recarga_Musica.setBackground(new Color(255, 255, 255, 160));
			}
			@Override
			//CUANDO EL RATÓN SALE DEL ÁREA DEL BOTÓN
			public void mouseExited(MouseEvent e) {
				btn_Recarga_Musica.setContentAreaFilled(false);
			}
			@Override
			//CUANDO PULSAS
			public void mouseClicked(MouseEvent e) {
				// INCREMENTO CONTADOR CADA VEZ QUE SE PULSA
				contador1_1+=1;
				if(contador1_1==1) {
					num_cancion=5;
					//1
					lbl_IMGCancion1.setVisible(false);
					lbl_IMGCancion1.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion1.getWidth(),lbl_IMGCancion1.getHeight()));
					lbl_IMGCancion1.setVisible(true);
					num_cancion++;
					//2
					lbl_IMGCancion2.setVisible(false);
					lbl_IMGCancion2.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion2.getWidth(),lbl_IMGCancion2.getHeight()));
					lbl_IMGCancion2.setVisible(true);
					num_cancion++;
					//3
					lbl_IMGCancion3.setVisible(false);
					lbl_IMGCancion3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion3.getWidth(),lbl_IMGCancion3.getHeight()));
					lbl_IMGCancion3.setVisible(true);
					num_cancion++;
					//4
					lbl_IMGCancion4.setVisible(false);
					lbl_IMGCancion4.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion4.getWidth(),lbl_IMGCancion4.getHeight()));
					lbl_IMGCancion4.setVisible(true);
					num_cancion++;
					//5
					lbl_IMGCancion5.setVisible(false);
					lbl_IMGCancion5.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion5.getWidth(),lbl_IMGCancion5.getHeight()));
					lbl_IMGCancion5.setVisible(true);
					num_cancion++;
				}
				else if(contador1_1==2) {
					num_cancion=10;
					//1
					lbl_IMGCancion1.setVisible(false);
					lbl_IMGCancion1.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion1.getWidth(),lbl_IMGCancion1.getHeight()));
					lbl_IMGCancion1.setVisible(true);
					num_cancion++;
					//2
					lbl_IMGCancion2.setVisible(false);
					lbl_IMGCancion2.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion2.getWidth(),lbl_IMGCancion2.getHeight()));
					lbl_IMGCancion2.setVisible(true);
					num_cancion++;
					//3
					lbl_IMGCancion3.setVisible(false);
					lbl_IMGCancion3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion3.getWidth(),lbl_IMGCancion3.getHeight()));
					lbl_IMGCancion3.setVisible(true);
					num_cancion++;
					//4
					lbl_IMGCancion4.setVisible(false);
					lbl_IMGCancion4.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion4.getWidth(),lbl_IMGCancion4.getHeight()));
					lbl_IMGCancion4.setVisible(true);
					num_cancion++;
					//5
					lbl_IMGCancion5.setVisible(false);
					lbl_IMGCancion5.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion5.getWidth(),lbl_IMGCancion5.getHeight()));
					lbl_IMGCancion5.setVisible(true);
					num_cancion++;	
				}else {
					// REINICIO CONTADOR
					contador1_1=0;
					num_cancion=0;
					//1
					lbl_IMGCancion1.setVisible(false);
					lbl_IMGCancion1.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion1.getWidth(),lbl_IMGCancion1.getHeight()));
					lbl_IMGCancion1.setVisible(true);
					num_cancion++;
					//2
					lbl_IMGCancion2.setVisible(false);
					lbl_IMGCancion2.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion2.getWidth(),lbl_IMGCancion2.getHeight()));
					lbl_IMGCancion2.setVisible(true);
					num_cancion++;
					//3
					lbl_IMGCancion3.setVisible(false);
					lbl_IMGCancion3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion3.getWidth(),lbl_IMGCancion3.getHeight()));
					lbl_IMGCancion3.setVisible(true);
					num_cancion++;
					//4
					lbl_IMGCancion4.setVisible(false);
					lbl_IMGCancion4.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion4.getWidth(),lbl_IMGCancion4.getHeight()));
					lbl_IMGCancion4.setVisible(true);
					num_cancion++;
					//5
					lbl_IMGCancion5.setVisible(false);
					lbl_IMGCancion5.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion5.getWidth(),lbl_IMGCancion5.getHeight()));
					lbl_IMGCancion5.setVisible(true);
					num_cancion++;	
				}
			}
		});
		btn_Recarga_Musica.setBorderPainted(false);
		btn_Recarga_Musica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Recarga_Musica.setContentAreaFilled(false);
		btn_Recarga_Musica.setBounds(79, 551, 50, 50);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon recarga_Musica = new ImageIcon(getClass().getResource("/Trilogy_imagenes/actualizacion.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgRecarga_Musica = new ImageIcon(recarga_Musica.getImage().getScaledInstance(btn_Recarga_Musica.getWidth(), btn_Recarga_Musica.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		btn_Recarga_Musica.setIcon(imgRecarga_Musica);
		// ----------------------------------------------------------------------------------------
		// JERARQUÍA DEL panel_contenedor
		// ----------------------------------------------------------------------------------------
		panel_contenedor.add(lblTextoCancion5);
		panel_contenedor.add(lblTextoCancion3);
		panel_contenedor.add(lblTextoCancion4);
		panel_contenedor.add(lblTextoCancion2);
		panel_contenedor.add(lblTextoCancion1);
		panel_contenedor.add(btn_Recarga_Musica);
		panel_contenedor.add(btn_Recarga_Serie);
		panel_contenedor.add(btn_Recarga_Peli);
		panel_contenedor.add(lbl_IMGCancion5);
		panel_contenedor.add(lbl_IMGSerie5);
		panel_contenedor.add(lbl_IMG_Peli_5);
		panel_contenedor.add(lbl_IMGCancion4);
		panel_contenedor.add(lbl_IMGCancion3);
		panel_contenedor.add(lbl_IMGSerie4);
		panel_contenedor.add(lbl_IMGSerie3);
		panel_contenedor.add(lbl_IMG_Peli_4);
		panel_contenedor.add(lbl_IMG_Peli_3);
		panel_contenedor.add(lbl_IMGCancion2);
		panel_contenedor.add(lbl_IMGSerie2);
		panel_contenedor.add(lbl_IMG_Peli_2);
		panel_contenedor.add(lbl_IMGCancion1);
		panel_contenedor.add(lbl_TXT_Musica);
		panel_contenedor.add(lbl_IMGSerie1);
		panel_contenedor.add(lbl_TXT_Series);
		panel_contenedor.add(lbl_IMG_Peli_1);
		panel_contenedor.add(lbl_TXT_Peliculas);
		panel_contenedor.add(lbl_Fondo);
		contentPane.add(panel_contenedor);
	}
}
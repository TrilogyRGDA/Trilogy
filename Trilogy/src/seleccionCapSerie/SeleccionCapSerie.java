package seleccionCapSerie;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import cat_audiovisual.CatalogoAudiovisual;
import diamante_premium.Diamante_premium;
import diamante_premium.Diamante_premium2;
import seleccionCapSerie.SeleccionCapSerie;
import Inicio_ZafiroStandarCod.inicio_ZafiroStandar;
import Inicio_ZafiroStandarCod.inicio_ZafiroStandar2;
import panel_IZ.Panel_iz_Principal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * En esta página (SeleccionCapSerie) se usa para ver el contenido dentro de una serie y con el botón de salida se cambiara la serie..
 *@param contentPane CONTIENE TODOS LOS ATRIBUTOS DE LA PÁGINA.
 *@param panel_contenedor CONTIENE TODOS LOS ATRIBUTOS PARA PODER INTERCAMBIAR PANELES SIN COMPLICACIÓN.
 *@param btn_PuertaSalida BOTÓN QUE HACE SALIR DE LA PAGÍNA DE ESA SERIE CONCRETA.
 *@param lbl_Temporada1 BOTÓN QUE INDICA LA TEMPORADA
 *@param lbl_Temporada2 BOTÓN QUE INDICA LA TEMPORADA
 *@param lbl_Temporada3 BOTÓN QUE INDICA LA TEMPORADA
 *@param lbl_Temporada4 BOTÓN QUE INDICA LA TEMPORADA
 *@param lbl_DescripcionCapitulo CUADRO DE TEXTO QUE DESCRIBE EL CAPÍTULO SELECCIONADO.
 *@param lbl_DescripcionSerie CUADRO DE TEXTO QUE DESCRIBE LA SERIE SELECCIONADA.
 *@param lbl_linea LABEL DECORATIVO.
 *@param lbl_NombreSerie CUADRO DE TEXTO QUE MUESTRA EL NOMBRE DE LA SERIE SELECCIONADA.
 *@param lbl_Portada_Serie LABEL QUE MUESTRA UNA COVER DE LA SERIE SELECCIONADA.
 *@param lbl_IMG_Fondo LABEL DECORATIVO CON LA IMAGEN DEL FONDO DEL CONTENTPANE.
 *@param lbl_DatosCapitulo CUADRO DE TEXTO QUE INDICA EL NOMBRE DEL CAPÍTULO.
 *@param Capitulo1 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo2 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo3 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo4 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo5 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo6 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo7 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo8 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo9 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo10 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo11 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo12 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo13 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo14 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo15 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param Capitulo16 CUADRO PARA SELECCIONAR EL CAPÍTULO DESEADO.
 *@param datos_serie1 CUADRO DE TEXTO QUE INDICA DURACIÓN APROXIMADA DE LOS CAPÍTULOS DE LA SERIE.
 *@param datos_serie2 CUADRO DE TEXTO QUE INDICA FECHA DE LANZAMIENTO DE LA SERIE.
 *@param datos_serie3 CUADRO DE TEXTO QUE INDICA LOS ARTÍSTAS DE LA SERIE.
 *@param lblBotonReproducir BOTÓN QUE AL PULSAR REPRODUCE EL CAPÍTULO SELECCIONADO.
 * @author TRILOGY. Miembros: Adrián Leal Vacas, Gonzalo Amo Cano y Raúl Senso Montojo.
 */
public class SeleccionCapSerie extends JFrame {
	/**
	 * Es única version de SeleccionCapSerie
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JPanel panel_contenedor;
	private JButton btn_PuertaSalida;
	private JLabel lbl_Temporada1;
	private JLabel lbl_Temporada2;
	private JLabel lbl_Temporada3;
	private JLabel lbl_Temporada4;
	private JLabel lbl_DescripcionCapitulo;
	private JLabel lbl_DescripcionSerie;
	private JLabel lbl_linea;
	private JLabel lbl_NombreSerie;
	private JLabel lbl_Portada_Serie;
	private JLabel lbl_IMG_Fondo;
	private JLabel lbl_DatosCapitulo;
	private JLabel Capitulo1;
	private JLabel Capitulo2;
	private JLabel Capitulo3;
	private JLabel Capitulo4;
	private JLabel Capitulo5;
	private JLabel Capitulo6;
	private JLabel Capitulo7;
	private JLabel Capitulo8;
	private JLabel Capitulo9;
	private JLabel Capitulo10;
	private JLabel Capitulo11;
	private JLabel Capitulo12;
	private JLabel Capitulo13;
	private JLabel Capitulo14;
	private JLabel Capitulo15;
	private JLabel Capitulo16;
	private JLabel datos_serie1;
	private JLabel datos_serie2;
	private JLabel datos_serie3;
	private JLabel lblBotonReproducir;
	private int numTem=0;
	private boolean botonPul=false;
	public static String ruta_serie;
	public static int contadorcapit=0;
	// ATRUBUTOS U OBJETOS NECESARIOS PARA AL CONEXIÓN Y LA BASE DE DATOS Y LA REALIZACIÓN DE UN CONSULTA BÁSICA
	private static String bd="XE"; // NOMBRE DE LA BASE DE DATOS POR DEFECTO, SIEMPRE DEJAR EL "XE"
	private static String login="TRILOGY"; // USUARIO DE LA BBDD
	private static String password="TRILOGY"; // CONTRASEÑA DE LA BBDD
	// RUTA DE SERVICIO
	private static String url="jdbc:oracle:thin:@localhost:1521:"+bd;
	// PONEMOS LOS OBJETOS A NULL Y SIN INSTANCIAR
	static Connection connection=null; // CONEXIÓN A LA BASE DE DATOS
	static Statement st; // PARA REALIZAR SQL ESTÁTICAS (HAY QUE ENLAZARLA SIEMPRE CON EL "Connection" SINO, NO FUNCIONA)
	static ResultSet rs; // PARA REALIZAR LA CONSULTA IGUAL QUE EN SQL DEVELOPER
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionCapSerie frame = new SeleccionCapSerie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void anadirpanel(JLabel... label ) {
		for (JLabel x : label ) {
			panel_contenedor.add(x);
		}
	}
	//------------------------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------MÉTODOS--------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	// PONER EL TEXTO A TODOS LOS CAMPOS DE LOS  lblcapitulos
	//------------------------------------------------------------------------------------------------------------------------------------------
	private void addTextCap () {
		Capitulo1.setText("Capitulo 1");
		Capitulo2.setText("Capitulo 2");
		Capitulo3.setText("Capitulo 3");
		Capitulo4.setText("Capitulo 4");
		Capitulo5.setText("Capitulo 5");
		Capitulo6.setText("Capitulo 6");
		Capitulo7.setText("Capitulo 7");
		Capitulo8.setText("Capitulo 8");
		Capitulo9.setText("Capitulo 9");
		Capitulo10.setText("Capitulo 10");
		Capitulo11.setText("Capitulo 11");
		Capitulo12.setText("Capitulo 12");
		Capitulo13.setText("Capitulo 13");
		Capitulo14.setText("Capitulo 14");
		Capitulo15.setText("Capitulo 15");
		Capitulo16.setText("Capitulo 16");
	}
	//------------------------------------------------------------------------------------------------------------------------------------------
	// PONER LOS PANELES INFORMATIVOS A LOS CAPÍTULOS
	//------------------------------------------------------------------------------------------------------------------------------------------
	private void addPanelInfor () {
		panel_contenedor.add(lbl_DatosCapitulo);
		panel_contenedor.add(lbl_DescripcionCapitulo);
		lbl_DatosCapitulo.setText("Capítulo: ");
		lbl_DescripcionCapitulo.setText("Descripción Capitulo");
	}
	//------------------------------------------------------------------------------------------------------------------------------------------
	// FUNCIÓN SACAR DATOS DEL CAPÍTULO
	//------------------------------------------------------------------------------------------------------------------------------------------
	private void funcionCap (int numCap) {
		// NOS CONECTAMOS A LA BASE DE DATOS
		String datos_capitulo="";
		String descripcion_capitulo="";
		Connection conexion;
		try {
			conexion = DriverManager.getConnection(url, login, password);
			// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
			String query = "SELECT NOMBRE, DURACION, DESCRIPCION FROM CAPITULOS WHERE ID_CAPITULO = ? AND ID_CAT_AUDIOVISUAL = ? AND ID_N_TEMPORADA = ? ";
			// LE DECIMOS QUE LA ? ANTERIOR COJA EL VALOR DE LA VARIABLE membresia_id (1 ES EL NUMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
			PreparedStatement stmt = conexion.prepareStatement(query);
			if (Panel_iz_Principal.series_zafiro_standar && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
				if (Panel_iz_Principal.comprobarSeries) {
					stmt.setString(2, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar2.ruta_serie));
				} else if (Panel_iz_Principal.comprobarDiamante) {
					stmt.setString(2, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
				}
				stmt.setInt(1, numCap);
				stmt.setInt(3, numTem);
			} else if (Panel_iz_Principal.series_zafiro_standar==false && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
				stmt.setInt(1, numCap);
				if (Panel_iz_Principal.comprobarSeries) {
					stmt.setString(2, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
				} else if (Panel_iz_Principal.comprobarDiamante) {
					stmt.setString(2, CatalogoAudiovisual.devolverIDserie(Diamante_premium.ruta_serie));
				}
				stmt.setInt(3, numTem);
			} 
			// EJECUTAMOS LA QUERY ANTERIOR
			rs = stmt.executeQuery();
			// PARA RECORER LAS LINEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
			// MIENTRAS QUE HAYA SIGUIENTE
			while (rs.next()) {
				// ALMACENA EL DATO DE LA COLUMNA NOMBRE EN LA VARIABLE nombre
				datos_capitulo += rs.getString("NOMBRE");
				datos_capitulo +="        Duración: "+ rs.getString("DURACION");
				descripcion_capitulo += rs.getString("DESCRIPCION");
			}
			//------------------------------------------------------------------------------------------------------------------------------------------
			//--------------------------------ADAPTAR TEXTO AL LABEL DESCRIPCIÓN CAPÍTULO--------------------------------------------------------
			//------------------------------------------------------------------------------------------------------------------------------------------
			// Dividir el texto en líneas de longitud máxima
			String textoDividido = "<html>"; // Para poder poner br de salto de línea / Inicio del html
			String[] palabras = descripcion_capitulo.split(" "); // Para detectar los espacios
			FontMetrics fm = lbl_DescripcionCapitulo.getFontMetrics(lbl_DescripcionCapitulo.getFont()); // Es para obtener el tipo de letra es decir la fuente de letra del texto
			int anchoMaximo = lbl_DescripcionCapitulo.getWidth(); // Cogemos el ancho del label
			int anchoActual = 0; // Esto para que el inicio del ancho sea 0 para poder ir incrementando
			// Recorro todo el texto con un FOR EACH
			for (String palabra : palabras) { 
				int anchoPalabra = fm.stringWidth(palabra); // Coger el ancho de la palabra
				// Si la suma del ancho actual y el ancho de la palabra es maYor al ancho del label, un br
				if (anchoActual + anchoPalabra > anchoMaximo) {
					textoDividido += "<br>"; // Salto de línea
					anchoActual = 0; // Vuelvo a poner el ancho a 0 para que este al inicio
				}
				textoDividido += palabra + " "; // Reconstruyo el texto con los parámetros necesarios
				anchoActual += anchoPalabra + fm.stringWidth(" "); // Actualizo el ancho actual
			}
			textoDividido += "</html>"; // Para poder poner br de salto de línea. / Cierre del html
			// Ponemos el texto dividido con html en el label
			lbl_DatosCapitulo.setText(datos_capitulo);
			lbl_DescripcionCapitulo.setText(textoDividido);
			lblBotonReproducir.setText(" ");
			rs.close();
			stmt.close();
			conexion.close();
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
			e2.printStackTrace();
		}
	}
	//------------------------------------------------------------------------------------------------------------------------------------------
	// REPRODUCIR CAP CAPÍTULO
	//------------------------------------------------------------------------------------------------------------------------------------------
	private void reproCap () {
		// CUANDO HACE CLICK TE MUESTRA LA SERIE 
		File path = new File ("./src/Trilogy_imagenes/Intro_Series.mp4"); // RUTA DE LA SERIE
		try {
			Desktop.getDesktop().open(path); // ABRE LA SERIE EN EL REPRODUCTOR POR DEFECTO DEL ORDENADOR

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		dispose();
	}
	/**
	 * En el constructor SeleccionCapSerie.java() están todos los atributos y métodos necesarios para cuando creemos el objeto tenga toda la funcionalidades.
	 */
	public SeleccionCapSerie() {
		// ----------------------------------------------------------------------------------------
		// contentPane CONTIENE TODOS LOS ATRIBUTOS DE LA PÁGINA
		// ----------------------------------------------------------------------------------------
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// ----------------------------------------------------------------------------------------
		// panel_contenedor CONTIENE TODOS LOS ATRIBUTOS PARA PODER INTERCAMBIAR PANELES SIN COMPLICACIÓN
		// ----------------------------------------------------------------------------------------
		panel_contenedor = new JPanel();
		panel_contenedor.setBounds(0, 0, 961, 664);
		panel_contenedor.setLayout(null);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------BOTÓN SALIDA--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------		
		btn_PuertaSalida = new JButton("");
		btn_PuertaSalida.setBorder(null);
		btn_PuertaSalida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_PuertaSalida.setOpaque(true);
		btn_PuertaSalida.setBackground(new Color(32,171,85));
		btn_PuertaSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_PuertaSalida.setBackground(new Color(153,255,153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_PuertaSalida.setBackground(new Color(32,171,85));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btn_PuertaSalida.setBounds(0, 607, 64, 57);//TAMAÑO DEL CUADRO
		ImageIcon salida = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoLogout.png"));
		ImageIcon imgIconoSalida = new ImageIcon(salida.getImage().getScaledInstance(btn_PuertaSalida.getWidth(), btn_PuertaSalida.getHeight(), Image.SCALE_SMOOTH));
		btn_PuertaSalida.setIcon(imgIconoSalida);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------BOTÓN REPRODUCIR--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		lblBotonReproducir = new JLabel(" ");
		lblBotonReproducir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBotonReproducir.setBounds(783, 321, 155, 42);
		ImageIcon botonIMG1 = new ImageIcon(getClass().getResource("/Trilogy_imagenes/boton-ver-ahora.png"));
		ImageIcon imgbotonIMG = new ImageIcon(botonIMG1.getImage().getScaledInstance(lblBotonReproducir.getWidth(), lblBotonReproducir.getHeight(), Image.SCALE_SMOOTH));
		lblBotonReproducir.setIcon(imgbotonIMG);
		lblBotonReproducir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (botonPul) {
					reproCap();
					botonPul=false;
				} else {
					JOptionPane.showMessageDialog(null, "No has seleccionado ningún capítulo. (Tontito)");
				}
			}
		});
		//------------------------------------------------------------------------------------------------------------------------------------------
		//--------------------------------------------------CAPÍTULOS--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		//---------------------LBL DESCRIPCIÓN CAPITULO--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		lbl_DescripcionCapitulo = new JLabel();
		lbl_DescripcionCapitulo.setOpaque(true);
		lbl_DescripcionCapitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DescripcionCapitulo.setForeground(Color.BLACK);
		lbl_DescripcionCapitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_DescripcionCapitulo.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_DescripcionCapitulo.setBackground(new Color(32,171,85));
		lbl_DescripcionCapitulo.setBounds(74, 557, 864, 96);	
		//------------------------------------------------------------------------------------------------------------------------------------------
		//----------------------LBL NOMBRE CAPÍTULO--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		lbl_DatosCapitulo = new JLabel();
		lbl_DatosCapitulo.setOpaque(true);
		lbl_DatosCapitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DatosCapitulo.setForeground(Color.WHITE);
		lbl_DatosCapitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_DatosCapitulo.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_DatosCapitulo.setBackground(new Color(32,171,85));
		lbl_DatosCapitulo.setBounds(53, 525, 885, 27);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-----------------------LBL NOMBRE CAPÍTULO--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		Capitulo16 = new JLabel("Capítulo 16");
		Capitulo16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo16.setOpaque(true);
		Capitulo16.setBounds(599, 487, 155, 27);
		Capitulo16.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo16.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (16);
			}
		});
		Capitulo15 = new JLabel("Capítulo 15");
		Capitulo15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo15.setOpaque(true);
		Capitulo15.setBounds(599, 449, 155, 27);
		Capitulo15.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo15.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (15);
			}
		});
		Capitulo14 = new JLabel("Capítulo 14");
		Capitulo14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo14.setOpaque(true);
		Capitulo14.setBounds(599, 412, 155, 27);
		Capitulo14.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo14.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (14);
			}
		});
		Capitulo13 = new JLabel("Capítulo 13");
		Capitulo13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo13.setOpaque(true);
		Capitulo13.setBounds(599, 374, 155, 27);
		Capitulo13.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo13.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (13);
			}
		});
		Capitulo12 = new JLabel("Capítulo 12");
		Capitulo12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo12.setOpaque(true);
		Capitulo12.setBounds(415, 487, 155, 27);
		Capitulo12.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo12.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (12);
			}
		});
		Capitulo11 = new JLabel("Capítulo 11");
		Capitulo11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo11.setOpaque(true);
		Capitulo11.setBounds(415, 449, 155, 27);
		Capitulo11.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo11.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (11);
			}
		});
		Capitulo10 = new JLabel("Capítulo 10");
		Capitulo10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo10.setOpaque(true);
		Capitulo10.setBounds(415, 412, 155, 27);
		Capitulo10.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo10.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (10);
			}
		});
		Capitulo9 = new JLabel("Capítulo 9");
		Capitulo9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo9.setOpaque(true);
		Capitulo9.setBounds(415, 374, 155, 27);
		Capitulo9.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo9.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (9);
			}
		});
		Capitulo8 = new JLabel("Capítulo 8");
		Capitulo8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo8.setOpaque(true);
		Capitulo8.setBounds(233, 487, 155, 27);
		Capitulo8.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo8.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (8);
			}
		});
		Capitulo7 = new JLabel("Capítulo 7");
		Capitulo7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo7.setOpaque(true);
		Capitulo7.setBounds(233, 449, 155, 27);
		Capitulo7.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo7.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (7);
			}
		});
		Capitulo6 = new JLabel("Capítulo 6");
		Capitulo6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo6.setOpaque(true);
		Capitulo6.setBounds(233, 412, 155, 27);
		Capitulo6.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo6.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (6);
			}
		});
		Capitulo5 = new JLabel("Capítulo 5");
		Capitulo5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo5.setOpaque(true);
		Capitulo5.setBounds(233, 374, 155, 27);
		Capitulo5.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo5.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (5);
			}
		});
		Capitulo4 = new JLabel("Capítulo 4");
		Capitulo4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo4.setOpaque(true);
		Capitulo4.setBounds(53, 487, 155, 27);
		Capitulo4.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo4.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (4);
			}
		});
		Capitulo3 = new JLabel("Capítulo 3");
		Capitulo3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo3.setOpaque(true);
		Capitulo3.setBounds(53, 449, 155, 27);
		Capitulo3.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo3.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (3);
			}
		});
		Capitulo2 = new JLabel("Capítulo 2");
		Capitulo2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo2.setOpaque(true);
		Capitulo2.setBounds(53, 412, 155, 27);
		Capitulo2.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (2);
			}
		});
		Capitulo1 = new JLabel("Capítulo 1");
		Capitulo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Capitulo1.setBounds(53, 374, 155, 27);
		Capitulo1.setOpaque(true);
		Capitulo1.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		Capitulo1.setHorizontalAlignment(SwingConstants.CENTER);
		Capitulo1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonPul=true;
				funcionCap (1);
			}
		});
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------TEMPORADAS--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------LBL TEMPORADA 4--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		lbl_Temporada4 = new JLabel("TEMPORADA 4");
		lbl_Temporada4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numTem=4;
				if(numTem==4) {
					lbl_Temporada4.setBorder(new LineBorder(Color.ORANGE,2));
					lbl_Temporada3.setBorder(new LineBorder(Color.LIGHT_GRAY));
					lbl_Temporada2.setBorder(new LineBorder(Color.LIGHT_GRAY));
					lbl_Temporada1.setBorder(new LineBorder(Color.LIGHT_GRAY));
				}
				addPanelInfor();
				Connection conexion;
				try {
					conexion = DriverManager.getConnection(url, login, password);
					// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
					String query = "SELECT COUNT(ID_CAPITULO) FROM CAPITULOS WHERE ID_N_TEMPORADA = 4 AND ID_CAT_AUDIOVISUAL =?";
					PreparedStatement stmt = conexion.prepareStatement(query);
					if (Panel_iz_Principal.series_zafiro_standar && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
						if (Panel_iz_Principal.comprobarSeries) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar2.ruta_serie));
						} else if (Panel_iz_Principal.comprobarDiamante) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						}
					} else if (Panel_iz_Principal.series_zafiro_standar==false && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
						if (Panel_iz_Principal.comprobarSeries) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
						} else if (Panel_iz_Principal.comprobarDiamante) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium.ruta_serie));
						}
					} 
					// EJECUTAMOS LA QUERY ANTERIOR
					rs = stmt.executeQuery();
					// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
					// MIENTRAS QUE HAYA SIGUIENTE
					while (rs.next()) {
						// ALMACENA EL DATO DE LA COLUMNA
						contadorcapit = rs.getInt(1);
					}//CONDICIÓN PARA QUE MUESTRE LOS CAPÍTULOS DE LAS TEMPORADA
					switch (contadorcapit){
					case 1:
						contadorcapit=0;
						anadirpanel(Capitulo1);
						addTextCap();
						break;
					case 2:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2);
						addTextCap();
						break;
					case 3:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3);
						addTextCap();
						break;
					case 4:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4);
						addTextCap();
						break;
					case 5:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5);
						addTextCap();
						break;
					case 6:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6);
						addTextCap();
						break;
					case 7:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7);
						addTextCap();
						break;
					case 8:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8);
						addTextCap();
						break;
					case 9:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9);
						addTextCap();
						break;
					case 10:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10);
						addTextCap();
						break;
					case 11:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11);
						addTextCap();
						break;
					case 12:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12);
						addTextCap();
						break;
					case 13:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13);
						addTextCap();
						break;
					case 14:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13,Capitulo14);
						addTextCap();
						break;
					case 15:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13,Capitulo14,Capitulo15);
						addTextCap();
						break;
					case 16:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13,Capitulo14,Capitulo15,Capitulo16);
						addTextCap();
						break;
					}
					rs.close();
					stmt.close();
					conexion.close();
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
					e2.printStackTrace();
				}
			}
		});
		lbl_Temporada4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_Temporada4.setOpaque(true);
		lbl_Temporada4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Temporada4.setForeground(Color.BLACK);
		lbl_Temporada4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Temporada4.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Temporada4.setBackground(Color.LIGHT_GRAY);
		lbl_Temporada4.setBounds(446, 327, 121, 36);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------LBL TEMPORADA 3--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		lbl_Temporada3 = new JLabel("TEMPORADA 3");
		lbl_Temporada3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numTem=3;
				if(numTem==3) {
					lbl_Temporada4.setBorder(new LineBorder(Color.LIGHT_GRAY));
					lbl_Temporada3.setBorder(new LineBorder(Color.ORANGE,2));
					lbl_Temporada2.setBorder(new LineBorder(Color.LIGHT_GRAY));
					lbl_Temporada1.setBorder(new LineBorder(Color.LIGHT_GRAY));
				}
				addPanelInfor();
				Connection conexion;
				try {
					conexion = DriverManager.getConnection(url, login, password);
					// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
					String query = "SELECT COUNT(ID_CAPITULO) FROM CAPITULOS WHERE ID_N_TEMPORADA = 3 AND ID_CAT_AUDIOVISUAL =?";
					PreparedStatement stmt = conexion.prepareStatement(query);
					if (Panel_iz_Principal.series_zafiro_standar && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
						if (Panel_iz_Principal.comprobarSeries) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar2.ruta_serie));
						} else if (Panel_iz_Principal.comprobarDiamante) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						}
					} else if (Panel_iz_Principal.series_zafiro_standar==false && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
						if (Panel_iz_Principal.comprobarSeries) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
						} else if (Panel_iz_Principal.comprobarDiamante) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium.ruta_serie));
						}
					} 
					// EJECUTAMOS LA QUERY ANTERIOR
					rs = stmt.executeQuery();
					// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
					// MIENTRAS QUE HAYA SIGUIENTE
					while (rs.next()) {
						// ALMACENA EL DATO DE LA COLUMNA
						contadorcapit = rs.getInt(1);
					}//CONDICIÓN PARA QUE MUESTRE LOS CAPÍTULOS DE LAS TEMPORADA
					switch (contadorcapit){
					case 1:
						contadorcapit=0;
						anadirpanel(Capitulo1);
						addTextCap();
						break;
					case 2:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2);
						addTextCap();
						break;
					case 3:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3);
						addTextCap();
						break;
					case 4:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4);
						addTextCap();
						break;
					case 5:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5);
						addTextCap();
						break;
					case 6:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6);
						addTextCap();
						break;
					case 7:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7);
						addTextCap();
						break;
					case 8:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8);
						addTextCap();
						break;
					case 9:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9);
						addTextCap();
						break;
					case 10:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10);
						addTextCap();
						break;
					case 11:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11);
						addTextCap();
						break;
					case 12:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12);
						addTextCap();
						break;
					case 13:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13);
						addTextCap();
						break;
					case 14:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13,Capitulo14);
						addTextCap();
						break;
					case 15:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13,Capitulo14,Capitulo15);
						addTextCap();
						break;
					case 16:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13,Capitulo14,Capitulo15,Capitulo16);
						addTextCap();
						break;
					}
					rs.close();
					stmt.close();
					conexion.close();
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
					e2.printStackTrace();
				}
			}
		});
		lbl_Temporada3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_Temporada3.setOpaque(true);
		lbl_Temporada3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Temporada3.setForeground(Color.BLACK);
		lbl_Temporada3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Temporada3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Temporada3.setBackground(Color.LIGHT_GRAY);
		lbl_Temporada3.setBounds(315, 327, 121, 36);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------LBL TEMPORADA 2--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		lbl_Temporada2 = new JLabel("TEMPORADA 2");
		lbl_Temporada2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numTem=2;
				if(numTem==2) {
					lbl_Temporada4.setBorder(new LineBorder(Color.LIGHT_GRAY));
					lbl_Temporada3.setBorder(new LineBorder(Color.LIGHT_GRAY));
					lbl_Temporada2.setBorder(new LineBorder(Color.ORANGE,2));
					lbl_Temporada1.setBorder(new LineBorder(Color.LIGHT_GRAY));
				}
				addPanelInfor();
				Connection conexion;
				try {
					conexion = DriverManager.getConnection(url, login, password);
					// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
					String query = "SELECT COUNT(ID_CAPITULO) FROM CAPITULOS WHERE ID_N_TEMPORADA = 2 AND ID_CAT_AUDIOVISUAL =?";
					PreparedStatement stmt = conexion.prepareStatement(query);
					if (Panel_iz_Principal.series_zafiro_standar && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
						if (Panel_iz_Principal.comprobarSeries) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar2.ruta_serie));
						} else if (Panel_iz_Principal.comprobarDiamante) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						}
					} else if (Panel_iz_Principal.series_zafiro_standar==false && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
						if (Panel_iz_Principal.comprobarSeries) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
						} else if (Panel_iz_Principal.comprobarDiamante) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium.ruta_serie));
						}
					} 
					// EJECUTAMOS LA QUERY ANTERIOR
					rs = stmt.executeQuery();
					// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
					// MIENTRAS QUE HAYA SIGUIENTE
					while (rs.next()) {
						// ALMACENA EL DATO DE LA COLUMNA
						contadorcapit = rs.getInt(1);
					}//CONDICIÓN PARA QUE MUESTRE LOS CAPÍTULOS DE LAS TEMPORADA
					switch (contadorcapit){
					case 1:
						contadorcapit=0;
						anadirpanel(Capitulo1);
						addTextCap();
						break;
					case 2:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2);
						addTextCap();
						break;
					case 3:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3);
						addTextCap();
						break;
					case 4:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4);
						addTextCap();
						break;
					case 5:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5);
						addTextCap();
						break;
					case 6:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6);
						addTextCap();
						break;
					case 7:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7);
						addTextCap();
						break;
					case 8:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8);
						addTextCap();
						break;
					case 9:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9);
						addTextCap();
						break;
					case 10:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10);
						addTextCap();
						break;
					case 11:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11);
						addTextCap();
						break;
					case 12:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12);
						addTextCap();
						break;
					case 13:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13);
						addTextCap();
						break;
					case 14:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13,Capitulo14);
						addTextCap();
						break;
					case 15:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13,Capitulo14,Capitulo15);
						addTextCap();
						break;
					case 16:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13,Capitulo14,Capitulo15,Capitulo16);
						addTextCap();
						break;
					}
					rs.close();
					stmt.close();
					conexion.close();
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
					e2.printStackTrace();
				}
			}
		});
		lbl_Temporada2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_Temporada2.setOpaque(true);
		lbl_Temporada2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Temporada2.setForeground(Color.BLACK);
		lbl_Temporada2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Temporada2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Temporada2.setBackground(Color.LIGHT_GRAY);
		lbl_Temporada2.setBounds(184, 327, 121, 36);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------LBL TEMPORADA 1--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		lbl_Temporada1 = new JLabel("TEMPORADA 1");
		lbl_Temporada1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numTem=1;
				if(numTem==1) {
					lbl_Temporada4.setBorder(new LineBorder(Color.LIGHT_GRAY));
					lbl_Temporada3.setBorder(new LineBorder(Color.LIGHT_GRAY));
					lbl_Temporada2.setBorder(new LineBorder(Color.LIGHT_GRAY));
					lbl_Temporada1.setBorder(new LineBorder(Color.ORANGE,2));
				}
				addPanelInfor();
				Connection conexion;
				try {
					conexion = DriverManager.getConnection(url, login, password);
					// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
					String query = "SELECT COUNT(ID_CAPITULO) FROM CAPITULOS WHERE ID_N_TEMPORADA = 1 AND ID_CAT_AUDIOVISUAL =?";
					PreparedStatement stmt = conexion.prepareStatement(query);
					if (Panel_iz_Principal.series_zafiro_standar && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
						if (Panel_iz_Principal.comprobarSeries) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar2.ruta_serie));
						} else if (Panel_iz_Principal.comprobarDiamante) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
						}
					} else if (Panel_iz_Principal.series_zafiro_standar==false && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
						if (Panel_iz_Principal.comprobarSeries) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
						} else if (Panel_iz_Principal.comprobarDiamante) {
							stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium.ruta_serie));
						}
					} 
					// EJECUTAMOS LA QUERY ANTERIOR
					rs = stmt.executeQuery();
					// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
					// MIENTRAS QUE HAYA SIGUIENTE
					while (rs.next()) {
						// ALMACENA EL DATO DE LA COLUMNA
						contadorcapit = rs.getInt(1);
					}//CONDICIÓN PARA QUE MUESTRE LOS CAPÍTULOS DE LAS TEMPORADA
					switch (contadorcapit){
					case 1:
						contadorcapit=0;
						anadirpanel(Capitulo1);
						addTextCap();
						break;
					case 2:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2);
						addTextCap();
						break;
					case 3:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3);
						addTextCap();
						break;
					case 4:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4);
						addTextCap();
						break;
					case 5:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5);
						addTextCap();
						break;
					case 6:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6);
						addTextCap();
						break;
					case 7:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7);
						addTextCap();
						break;
					case 8:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8);
						addTextCap();
						break;
					case 9:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9);
						addTextCap();
						break;
					case 10:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10);
						addTextCap();
						break;
					case 11:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11);
						addTextCap();
						break;
					case 12:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12);
						addTextCap();
						break;
					case 13:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13);
						addTextCap();
						break;
					case 14:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13,Capitulo14);
						addTextCap();
						break;
					case 15:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13,Capitulo14,Capitulo15);
						addTextCap();
						break;
					case 16:
						contadorcapit=0;
						anadirpanel(Capitulo1,Capitulo2,Capitulo3,Capitulo4,Capitulo5,Capitulo6,Capitulo7,Capitulo8,Capitulo9,Capitulo10,Capitulo11,Capitulo12,Capitulo13,Capitulo14,Capitulo15,Capitulo16);
						addTextCap();
						break;
					}
					rs.close();
					stmt.close();
					conexion.close();
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
					e2.printStackTrace();
				}
			}
		});
		lbl_Temporada1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_Temporada1.setOpaque(true);
		lbl_Temporada1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Temporada1.setForeground(Color.BLACK);
		lbl_Temporada1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Temporada1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Temporada1.setBackground(Color.LIGHT_GRAY);
		lbl_Temporada1.setBounds(53, 327, 121, 36);		
		System.out.println(numTem);
		//-------------------------------------------------------------------------------------------------------------------
		//---------------------------------------MOSTRAR TEMPORADAS SEGÚN TENGA LA SERIE-------------------------------------
		//-------------------------------------------------------------------------------------------------------------------
		//------------------------------------------MINIMIZADA - inicio_ZafiroStandar -----------------------------------------------------------

		if(inicio_ZafiroStandar.contadortemp==1 || Diamante_premium.contadortemp==1) {
			if (Panel_iz_Principal.comprobarSeries) {
				inicio_ZafiroStandar.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
			} else if (Panel_iz_Principal.comprobarDiamante) {
				Diamante_premium.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
			}
		}else if (inicio_ZafiroStandar.contadortemp==2 || Diamante_premium.contadortemp==2) {
			if (Panel_iz_Principal.comprobarSeries) {
				inicio_ZafiroStandar.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
				panel_contenedor.add(lbl_Temporada2);
			} else if (Panel_iz_Principal.comprobarDiamante) {
				Diamante_premium.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
				panel_contenedor.add(lbl_Temporada2);
			}
		}else if (inicio_ZafiroStandar.contadortemp==3 || Diamante_premium.contadortemp==3) {
			if (Panel_iz_Principal.comprobarSeries) {
				inicio_ZafiroStandar.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
				panel_contenedor.add(lbl_Temporada2);
				panel_contenedor.add(lbl_Temporada3);
			} else if (Panel_iz_Principal.comprobarDiamante) {
				Diamante_premium.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
				panel_contenedor.add(lbl_Temporada2);
				panel_contenedor.add(lbl_Temporada3);
			}
		}else if (inicio_ZafiroStandar.contadortemp==4 || Diamante_premium.contadortemp==4) {
			if (Panel_iz_Principal.comprobarSeries) {
				inicio_ZafiroStandar.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
				panel_contenedor.add(lbl_Temporada2);
				panel_contenedor.add(lbl_Temporada3);
				panel_contenedor.add(lbl_Temporada4);
			} else if (Panel_iz_Principal.comprobarDiamante) {
				Diamante_premium.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
				panel_contenedor.add(lbl_Temporada2);
				panel_contenedor.add(lbl_Temporada3);
				panel_contenedor.add(lbl_Temporada4);
			}
		}
		//------------------------------------------------------------------------------------------------------
		//------------------------------------------MÁXIMIZADA - inicio_ZafiroStandar2-----------------------------------------------------------
		if(inicio_ZafiroStandar2.contadortemp==1 || Diamante_premium2.contadortemp==1) {
			if (Panel_iz_Principal.comprobarSeries) {
				inicio_ZafiroStandar2.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
			} else if (Panel_iz_Principal.comprobarDiamante) {
				Diamante_premium2.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
			}
		}else if (inicio_ZafiroStandar2.contadortemp==2 || Diamante_premium2.contadortemp==2) {
			if (Panel_iz_Principal.comprobarSeries) {
				inicio_ZafiroStandar2.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
				panel_contenedor.add(lbl_Temporada2);
			} else if (Panel_iz_Principal.comprobarDiamante) {
				Diamante_premium2.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
				panel_contenedor.add(lbl_Temporada2);
			}
		}else if (inicio_ZafiroStandar2.contadortemp==3 || Diamante_premium2.contadortemp==3) {
			if (Panel_iz_Principal.comprobarSeries) {
				inicio_ZafiroStandar2.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
				panel_contenedor.add(lbl_Temporada2);
				panel_contenedor.add(lbl_Temporada3);
			} else if (Panel_iz_Principal.comprobarDiamante) {
				Diamante_premium2.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
				panel_contenedor.add(lbl_Temporada2);
				panel_contenedor.add(lbl_Temporada3);
			}
		}else if (inicio_ZafiroStandar2.contadortemp==4 || Diamante_premium2.contadortemp==4) {
			if (Panel_iz_Principal.comprobarSeries) {
				inicio_ZafiroStandar2.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
				panel_contenedor.add(lbl_Temporada2);
				panel_contenedor.add(lbl_Temporada3);
				panel_contenedor.add(lbl_Temporada4);
			} else if (Panel_iz_Principal.comprobarDiamante) {
				Diamante_premium2.contadortemp=0;
				panel_contenedor.add(lbl_Temporada1);
				panel_contenedor.add(lbl_Temporada2);
				panel_contenedor.add(lbl_Temporada3);
				panel_contenedor.add(lbl_Temporada4);
			}
		}
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------SERIES / CATÁLOGO AUDIOVISUAL-------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		//---------------------------------------------IMAGEN COVER SERIE --------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		lbl_Portada_Serie = new JLabel("");
		lbl_Portada_Serie.setForeground(new Color(0, 0, 0)); //EL COLOR DEL TEXTO
		lbl_Portada_Serie.setBorder(new LineBorder(Color.LIGHT_GRAY)); // EL COLOR DLE BORDE DEL CUADRO
		lbl_Portada_Serie.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		lbl_Portada_Serie.setHorizontalAlignment(SwingConstants.CENTER); //CENTRAR EL TEXTO DEL CUADRO
		lbl_Portada_Serie.setOpaque(true); // LÍNEA OBLIGATORIA PARA QUE EL FONDO TENGA COLOR SOLIDO
		lbl_Portada_Serie.setBackground(new Color(64, 128, 128));// COLOR DE FONDO
		lbl_Portada_Serie.setBounds(378, 0, 583, 310);//TAMAÑO DEL CUADRO
		// AJUSTAR IMAGEN AL CONTENIDO
		if (Panel_iz_Principal.series_zafiro_standar && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
			if (Panel_iz_Principal.comprobarSeries) {
				lbl_Portada_Serie.setIcon(CatalogoAudiovisual.obtenerImagenCover((CatalogoAudiovisual.devolverID_numberserie(inicio_ZafiroStandar2.ruta_serie)),lbl_Portada_Serie.getWidth(),lbl_Portada_Serie.getHeight()));
			} else if (Panel_iz_Principal.comprobarDiamante) {
				lbl_Portada_Serie.setIcon(CatalogoAudiovisual.obtenerImagenCover((CatalogoAudiovisual.devolverID_numberserie(Diamante_premium2.ruta_serie)),lbl_Portada_Serie.getWidth(),lbl_Portada_Serie.getHeight()));
			}
		} else if (Panel_iz_Principal.series_zafiro_standar==false && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
			if (Panel_iz_Principal.comprobarSeries) {
				lbl_Portada_Serie.setIcon(CatalogoAudiovisual.obtenerImagenCover((CatalogoAudiovisual.devolverID_numberserie(inicio_ZafiroStandar.ruta_serie)),lbl_Portada_Serie.getWidth(),lbl_Portada_Serie.getHeight()));
			} else if (Panel_iz_Principal.comprobarDiamante) {
				lbl_Portada_Serie.setIcon(CatalogoAudiovisual.obtenerImagenCover((CatalogoAudiovisual.devolverID_numberserie(Diamante_premium.ruta_serie)),lbl_Portada_Serie.getWidth(),lbl_Portada_Serie.getHeight()));
			}
		}
		// ----------------------------------------------------------------------------------------
		// -----------------------------------DATOS DE LA SERIE------------------------------------
		// ----------------------------------------------------------------------------------------
		String datos_serie="";
		String datos_seriedur="";
		String datos_seriefecha="";
		String datos_serieartis="";
		String descripcion_serie="";
		// NOS CONECTAMOS A LA BASE DE DATOS
		Connection conexion;
		try {
			conexion = DriverManager.getConnection(url, login, password);
			// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
			String query = "SELECT NOMBRE,DURACION,ARTISTA,FECHA_LANZAMIENTO,DESCRIPCION FROM CAT_AUDIOVISUAL WHERE ID_CAT_AUDIOVISUAL = ?";
			// LE DECIMOS QUE LA ? ANTERIOR COJA EL VALOR DE LA VARIABLE membresia_id (1 ES EL NUMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
			PreparedStatement stmt = conexion.prepareStatement(query);
			if (Panel_iz_Principal.series_zafiro_standar && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
				if (Panel_iz_Principal.comprobarSeries) {
					stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar2.ruta_serie));
				} else if (Panel_iz_Principal.comprobarDiamante) {
					stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium2.ruta_serie));
				}
			} else if (Panel_iz_Principal.series_zafiro_standar==false && (Panel_iz_Principal.comprobarSeries || Panel_iz_Principal.comprobarDiamante)) {
				if (Panel_iz_Principal.comprobarSeries) {
					stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
				} else if (Panel_iz_Principal.comprobarDiamante) {
					stmt.setString(1, CatalogoAudiovisual.devolverIDserie(Diamante_premium.ruta_serie));;
				}
			} 
			// EJECUTAMOS LA QUERY ANTERIOR
			rs = stmt.executeQuery();
			// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
			// MIENTRAS QUE HAYA SIGUIENTE
			while (rs.next()) {
				// ALMACENA EL DATO DE LA COLUMNA NOMBRE EN LA VARIABLE nombre
				datos_serie += rs.getString("NOMBRE");
				datos_seriedur +="Duración: "+ rs.getString("DURACION");
				datos_serieartis +="Artista: "+ rs.getString("ARTISTA");
				datos_seriefecha +="Fecha: "+ rs.getString("FECHA_LANZAMIENTO");
				descripcion_serie += rs.getString("DESCRIPCION");
			}
			rs.close();
			stmt.close();
			conexion.close();
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la serie. Perdone las molestias.");
			e2.printStackTrace();
		}
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------LABEL NOMBRE SERIE--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		lbl_NombreSerie = new JLabel(datos_serie);
		lbl_NombreSerie.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombreSerie.setForeground(Color.WHITE);
		lbl_NombreSerie.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_NombreSerie.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_NombreSerie.setBounds(20, 11, 341, 33);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------LABEL ARTÍSTAS SERIE--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		datos_serie3 = new JLabel(datos_serieartis);
		datos_serie3.setHorizontalAlignment(SwingConstants.CENTER);
		datos_serie3.setForeground(Color.WHITE);
		datos_serie3.setFont(new Font("Tahoma", Font.BOLD, 12));
		datos_serie3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		datos_serie3.setBounds(20, 53, 341, 27);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------LABEL FECHA SERIE--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		datos_serie2 = new JLabel(datos_seriefecha);
		datos_serie2.setHorizontalAlignment(SwingConstants.CENTER);
		datos_serie2.setForeground(Color.WHITE);
		datos_serie2.setFont(new Font("Tahoma", Font.BOLD, 12));
		datos_serie2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		datos_serie2.setBounds(172, 81, 189, 27);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------LABEL DURACIÓN SERIE--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		datos_serie1 = new JLabel(datos_seriedur);
		datos_serie1.setHorizontalAlignment(SwingConstants.CENTER);
		datos_serie1.setForeground(Color.WHITE);
		datos_serie1.setFont(new Font("Tahoma", Font.BOLD, 12));
		datos_serie1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		datos_serie1.setBounds(20, 81, 149, 27);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------LBL DESCRIPCIÓN SERIE--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		lbl_DescripcionSerie = new JLabel();
		lbl_DescripcionSerie.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DescripcionSerie.setForeground(Color.BLACK);
		lbl_DescripcionSerie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_DescripcionSerie.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_DescripcionSerie.setBounds(20, 109, 341, 201);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//------------------------------------ADAPTAR TEXTO AL lbl_DescripcionSerie--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		// Dividir el texto en líneas de longitud máxima
		String SerieDescripcionTexto = "<html>"; // Para poder poner br de salto de linea inicio del html
		String[] palabras1 = descripcion_serie.split(" "); // Para detectar los espacios
		FontMetrics fm1 = lbl_DescripcionSerie.getFontMetrics(lbl_DescripcionSerie.getFont()); // Es para obtener el tipo de letra, es decir, la fuente de letra del texto
		int anchoMaximo1 = lbl_DescripcionSerie.getWidth(); // Uso el ancho del label
		int anchoActual1 = 0; // Esto para que el inicio del ancho sea 0 para poder ir incrementando
		// Eecorro todo el texto con un FOR EACH
		for (String palabra : palabras1) { 
			int anchoPalabra = fm1.stringWidth(palabra); // Coger el ancho de la palabra
			// Si la suma del ancho actual y el ancho de la palabra es mayor al ancho del label pongo un br
			if (anchoActual1 + anchoPalabra > anchoMaximo1) {
				SerieDescripcionTexto += "<br>"; // salto de linea
				anchoActual1 = 0; // Vuelvo a poner el ancho a 0 para que vuelva al inicio
			}
			SerieDescripcionTexto += palabra + " "; // Reconstruyo el texto con los parámetros necesarios
			anchoActual1 += anchoPalabra + fm1.stringWidth(" "); // Actualizo el ancho actual
		}
		SerieDescripcionTexto += "</html>"; // Para poder poner br de salto de línea y el cierre del html
		// Pongo el texto dividido con html en el label
		lbl_DescripcionSerie.setText(SerieDescripcionTexto);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------DECORACIÓN--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------FONDO PANTALLA--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		lbl_IMG_Fondo = new JLabel("");
		lbl_IMG_Fondo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMG_Fondo.setBounds(0, 0, 961, 663);
		ImageIcon fondoIMG1 = new ImageIcon(getClass().getResource("/Trilogy_imagenes/Fondo_Formulario.png"));
		ImageIcon imgFondoIMG = new ImageIcon(fondoIMG1.getImage().getScaledInstance(lbl_IMG_Fondo.getWidth(), lbl_IMG_Fondo.getHeight(), Image.SCALE_SMOOTH));
		lbl_IMG_Fondo.setIcon(imgFondoIMG);
		lbl_IMG_Fondo.setOpaque(true);
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------LÍNEA MITAD--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		lbl_linea = new JLabel("");
		lbl_linea.setBackground(new Color(0, 0, 0));
		lbl_linea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_linea.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_linea.setOpaque(true);
		lbl_linea.setForeground(new Color(0, 0, 0));
		lbl_linea.setBounds(0, 308, 961, 2);		
		//------------------------------------------------------------------------------------------------------------------------------------------
		//-------------------------------------------JERARQUÍA PANELES--------------------------------------------------------
		//------------------------------------------------------------------------------------------------------------------------------------------
		panel_contenedor.add(lblBotonReproducir);
		panel_contenedor.add(datos_serie3);
		panel_contenedor.add(datos_serie2);
		panel_contenedor.add(datos_serie1);
		panel_contenedor.add(btn_PuertaSalida);
		panel_contenedor.add(lbl_DescripcionSerie);
		panel_contenedor.add(lbl_linea);
		panel_contenedor.add(lbl_NombreSerie);
		panel_contenedor.add(lbl_Portada_Serie);
		panel_contenedor.add(lbl_IMG_Fondo);
		contentPane.add(panel_contenedor);
	}
}
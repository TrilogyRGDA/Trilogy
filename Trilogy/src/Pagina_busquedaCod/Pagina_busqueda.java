package Pagina_busquedaCod;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import cat_audiovisual.CatalogoAudiovisual;
import inicioSesion.Inicio_Sesion;
import javax.swing.BorderFactory;
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
 * En la página de Página Búsqueda podrás buscar el contenido audiovisual (Películas,Seria o Música) según tu suscripción mensual, 
 * aparecen varios anuncios con contenido audiovisual propio como sugerencia.
 * @param contentPane CONTIENE TODOS LOS ATRIBUTOS DE LA PÁGINA.
 * @param panel_Pagina_busqueda CONTIENE TODOS LOS ATRIBUTOS PARA PODER INTERCAMBIAR PANELES SIN COMPLICACIÓN.
 * @param lblEnlace_Anuncio1 SUGERENCIA DE ANUNCIO 1.
 * @param lblEnlace_Anuncio2 SUGERENCIA DE ANUNCIO 2.
 * @param lblEnlace_Anuncio3 SUGERENCIA DE ANUNCIO 3.
 * @param lblTexto_Anuncio TEXTO ANUNCIO.
 * @param lblTexto_informativo TEXTO INFORMATIVO SOBRE LA PÁGINA DE BUSQUEDA.
 * @param text_Barra_busqueda BARRA DE BÚSQUEDA.
 * @param btnBuscar EL BOTÓN DE BUSCAR.
 * @param comboBox_Ordenar TIPOS DE ORDENACIÓN AL REALIZAR LA BÚSQUEDA.
 * @param lbl_Logo NUESTRO LOGO DE TRILOGY.
 * @param lblBordeSuperior BARRA VERDE SUPERIOR.
 * @param lblFondo_Verde FONDO COLOR VERDE.
 * @author TRILOGY. Miembros: Adrian Leal Vacas, Gonzalo Amo Cano y Raul Senso Montojo.
 */
public class Pagina_busqueda extends JFrame {
	/**
	 * Es la versión número 1 de la página del contenido audiovisual del Página Búsqueda.
	 */
	private static final long serialVersionUID = 1L;
	// ----------------------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------------------
	private JPanel contentPane;
	private JPanel panel_Pagina_busqueda;
	private JButton btnBuscar;
	private JLabel lblTexto_informativo;
	private JLabel lblTexto_Anuncio;
	private JLabel lblEnlace_Anuncio1;
	private JLabel lblEnlace_Anuncio2;
	private JLabel lblEnlace_Anuncio3;
	private JTextField text_Barra_busqueda;
	// ----------------------------------------------------------------------------------------
	// ATRIBUTOS U OBJETOS NECESARIOS PARA LA CONEXIÓN A LA BASE DE DATOS Y LA REALIZACIÓN DE UN CONSULTA BÁSICA
	// ----------------------------------------------------------------------------------------
	private static String bd="XE"; // NOMBRE DE LA BASE DE DATOS POR DEFECT SIEMPRE DEJAR EL "XE"
	private static String login="TRILOGY"; // USUARIO DE LA BBDD
	private static String password="TRILOGY"; // CONTRASEÑA DE LA BBDD
	// ----------------------------------------------------------------------------------------
	// RUTA DE SERVICIO
	// ----------------------------------------------------------------------------------------
	private static String url="jdbc:oracle:thin:@localhost:1521:"+bd;
	// ----------------------------------------------------------------------------------------
	// PONEMOS LOS OBJETOS A NULL Y SIN INSTANCIAR
	// ----------------------------------------------------------------------------------------
	static Connection connection=null; // CONEXION A LA BASE DE DATOS
	static Statement st; // PARA REALIZAR SQL ESTATICAS (HAY QUE ENLAZARLA SIEMPRE CON EL "Connection" SINO NO FUNCIONA)
	static ResultSet rs; // PARA REALIZAR LA CONSULTA IGUAL QUE EN SQL DEVELOPER
	// ----------------------------------------------------------------------------------------
	// GETTERS AND SETTERS
	// ----------------------------------------------------------------------------------------
	public JPanel getPanel_Pagina_busqueda() {
		return panel_Pagina_busqueda;
	}
	public void setPanel_Pagina_busqueda(JPanel panel_Pagina_busqueda) {
		this.panel_Pagina_busqueda = panel_Pagina_busqueda;
	}
	// ----------------------------------------------------------------------------------------
	// MÉTODO MAIN
	// ----------------------------------------------------------------------------------------
	/**
	 * En el método main ejecutamos la ventana principal Pagina_busqueda.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagina_busqueda frame = new Pagina_busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// ----------------------------------------------------------------------------------------	
	// MÉTODOS
	// ----------------------------------------------------------------------------------------
	// ----------------------------------------------------------------------------------------
	// MÉTODO PARA CONECTAR A LA BASE DE DATOS
	// ----------------------------------------------------------------------------------------
	/**
	 * El método conectar() realiza una conexión a la base de datos.
	 */
	public static void conectar() throws Exception{
		// DRIVER PARA ORACLE
		Class.forName("oracle.jdbc.driver.OracleDriver"); // EL DRIVER DEL JDBC SIEMPRE ES EL MISMO QUE ESTA PUESTO
		connection=DriverManager.getConnection(url,login,password); // NOS CONECTAMOS A LA BASE DE DATOS CON LA URL Y LOGIN Y EL PASSWORD QUE PREVIAMENTE PUSIMOS EN LOS ATRIBUTOS
	}
	// ----------------------------------------------------------------------------------------
	// MÉTODO PARA CERRAR LA BASE DE DATOS
	// ----------------------------------------------------------------------------------------
	/**
	 * El método cerrar() cierra la base de datos.
	 */
	public static void cerrar() throws SQLException{
		// SIEMPRE EN EL MISMO ORDEN SINO DA FALLO
		if (rs!=null) rs.close(); // CERRAMOS EL RS SI ES DIFERENTE AL NULL (FUNCIONANDO)
		if (st!=null) st.close(); // CERRAMOS EL ST SI ES DIFERENTE AL NULL (FUNCIONANDO)
		if (connection!=null) connection.close(); // CERRAMOS EL connection SI ES DIFERENTE AL NULL (FUNCIONANDO)
	}
	// ----------------------------------------------------------------------------------------
	// MÉTODO PARA BUSCAR EN PELIS
	// ----------------------------------------------------------------------------------------
	/**
	 * El método nombrePeli() busca el nombre de la película en la base de datos.
	 */
	public String nombrePeli (String nombre) {
		String nom_peli="";
		try {
			// LLAMO AL MÉTODO CONECTAR
			conectar();
			// NOS CONECTAMOS A LA BASE DE DATOS
			st=connection.createStatement();
			// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR
			PreparedStatement statement = connection.prepareStatement("select NOMBRE from CAT_AUDIOVISUAL WHERE UPPER(NOMBRE) LIKE '%'||?||'%' AND UPPER(ID_CAT_AUDIOVISUAL) LIKE 'P_%'");
			// LE DECIMOS QUE LA ? ANTERIOR COJA EL VALOR DE LA VARIABLE
			statement.setString(1, nombre.toUpperCase());
			// EJECUTAMOS LA QUERY ANTERIOR
			rs = statement.executeQuery();
			// PARA RECORER LAS LINEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
			// MIENTRAS QUE HAYA SIGUIENTE
			while (rs.next()) {
				// ALMACENA EL DATO OBTENIDO
				nom_peli = rs.getString("NOMBRE");
			}
			// CUANDO TERMINO LLAMO AL METO DE CERRAR LA CONEXIÓN
			cerrar();
		}catch (Exception e) {
		}
		return nom_peli;
	}
	// ----------------------------------------------------------------------------------------
	// MÉTODO BUSCAR EN SERIES
	// ----------------------------------------------------------------------------------------
	/**
	 * El método nombreSerie() busca el nombre de la serie en la base de datos.
	 */
	public String nombreSerie (String nombre) {
		String nom_Serie="";
		try {
			// LLAMO AL MÉTODO CONECTAR
			conectar();
			// NOS CONECTAMOS A LA BASE DE DATOS
			st=connection.createStatement();
			// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR
			PreparedStatement statement = connection.prepareStatement("select NOMBRE from CAT_AUDIOVISUAL WHERE UPPER(NOMBRE) LIKE '%'||?||'%' AND UPPER(ID_CAT_AUDIOVISUAL) LIKE 'S_%'");
			// LE DECIMOS QUE LA ? ANTERIOR COJA EL VALOR DE LA VARIABLE
			statement.setString(1, nombre.toUpperCase());
			// EJECUTAMOS LA QUERY ANTERIOR
			rs = statement.executeQuery();
			// PARA RECORER LAS LINEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
			// MIENTRAS QUE HAYA SIGUIENTE
			while (rs.next()) {
				// ALMACENA EL DATO OBTENIDO
				nom_Serie = rs.getString("NOMBRE");
			}
			// CUANDO TERMINO LLAMO AL METO DE CERRAR LA CONEXIÓN
			cerrar();
		}catch (Exception e) {
		}
		return nom_Serie;
	}
	// ----------------------------------------------------------------------------------------
	// MÉTODO BUSCAR EN CANCIONES
	// ----------------------------------------------------------------------------------------
	/**
	 * El método nombreCancion() busca el nombre de la canción en la base de datos.
	 */
	public String nombreCancion (String nombre) {
		String nom_Serie="";
		try {
			// LLAMO AL MÉTODO CONECTAR
			conectar();
			// NOS CONECTAMOS A LA BASE DE DATOS
			st=connection.createStatement();
			// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR
			PreparedStatement statement = connection.prepareStatement("select NOMBRE_CANCION from CANCIONES WHERE UPPER(NOMBRE_CANCION) LIKE '%'||?||'%'");
			// LE DECIMOS QUE LA ? ANTERIOR COJA EL VALOR DE LA VARIABLE
			statement.setString(1, nombre.toUpperCase());
			// EJECUTAMOS LA QUERY ANTERIOR
			rs = statement.executeQuery();
			// PARA RECORER LAS LINEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
			// MIENTRAS QUE HAYA SIGUIENTE
			while (rs.next()) {
				// ALMACENA EL DATO OBTENIDO
				nom_Serie = rs.getString("NOMBRE_CANCION");
			}
			// CUANDO TERMINO LLAMO AL METO DE CERRAR LA CONEXIÓN
			cerrar();
		}catch (Exception e) {
		}
		return nom_Serie;
	}
	// ----------------------------------------------------------------------------------------
	// CONSTRUCTOR
	// ----------------------------------------------------------------------------------------
	/**
	 * En el constructor Pagina_busqueda() están todos los atributos y métodos necesarios para cuando creemos el objeto tenga toda la funcionalidades.
	 */
	public Pagina_busqueda() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 703);
		contentPane = new JPanel();
		//------------------------------------------------------------------------------------------------------------	
		//PANEL PÁGINA DE BÚSQUEDA
		//------------------------------------------------------------------------------------------------------------	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel_Pagina_busqueda = new JPanel();
		panel_Pagina_busqueda.setBounds(0, 0, 961, 664);
		panel_Pagina_busqueda.setLayout(null);
		//------------------------------------------------------------------------------------------------------------	
		//lblTexto_informativo TEXTO INFORMATIVO SOBRE LA PÁGINA DE BÚSQUEDA
		//------------------------------------------------------------------------------------------------------------	
		lblTexto_informativo = new JLabel("<html><p style=\"color: #000000, text-align:center;\"> ¿Buscas un programa o una película en particular?<br>"//USO DE HTML PARA DARLE FORMA AL TEXTO, AÑADIMOS EL COLOR NEGRO PARA QUE SEA MÁS INTENSO
				+ " Si sabes lo que quieres ver, puedes usar la<br> función de búsqueda. Selecciona el icono: BUSCAR"
				+ " <br> y escribe cualquiera de las siguientes opciones:<br><br><br> ►El nombre de una serie<br><br>"
				+ " ►El título de una película<br><br> ►El nombre de una canción<br><br><br>"
				+ " Si un perfil no tiene comprados los niveles superiores,<br> "
				+ "los resultados de la búsqueda podrán excluir las series y películas<br>"
				+ " que el perfil tiene permitido ver.</p>");
		lblTexto_informativo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTexto_informativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto_informativo.setBounds(54, 218, 336, 398);
		lblTexto_informativo.setOpaque(true);//FONDO OPACO Y NO TRANSPARENTE QUE ES EL DE POR DEFECTO, ASÍ PODEMOS DARLE COLOR
		lblTexto_informativo.setBackground(new Color(153, 255, 153));//NUESTRO COLOR VERDE TRILOGY DE FONDO DEL CUADRO
		lblTexto_informativo.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		lblTexto_informativo.setBorder(BorderFactory.createLineBorder(Color.yellow,2));//BORDE DEL CUADRO DE TEXTO DE COLOR AMARILLO
		//------------------------------------------------------------------------------------------------------------	
		//lblTexto_informativo TEXTO ANUNCIO
		//------------------------------------------------------------------------------------------------------------		
		lblTexto_Anuncio = new JLabel("<html><p style=\"color: #000000\"> ¿No sabes que ver?<br>Te sugerimos que mires...</p>");//USO DE HTML PARA DAR FORMA AL TEXTO
		lblTexto_Anuncio.setBounds(420, 240, 510, 108);
		lblTexto_Anuncio.setOpaque(true);//FONDO OPACO Y NO TRANSPARENTE QUE ES EL DE POR DEFECTO, ASÍ PODEMOS DARLE COLOR
		lblTexto_Anuncio.setHorizontalAlignment(SwingConstants.CENTER); //TEXTO CENTRADO
		lblTexto_Anuncio.setFont(new Font("Monotype Corsiva", Font.ITALIC, 34));
		lblTexto_Anuncio.setBorder(BorderFactory.createLineBorder(Color.yellow,2));//BORDE DEL CUADRO DE TEXTO DE COLOR AMARILLO
		lblTexto_Anuncio.setBackground(new Color(153, 255, 153));//NUESTRO COLOR VERDE TRILOGY DE FONDO DEL CUADRO
		//------------------------------------------------------------------------------------------------------------	
		//ANUNCIOS IMÁGENES
		//------------------------------------------------------------------------------------------------------------		
		//------------------------------------------------------------------------------------------------------------	
		//lblEnlace_Anuncio1 SUGERENCIA DE ANUNCIO 1
		//------------------------------------------------------------------------------------------------------------		
		lblEnlace_Anuncio1 = new JLabel();
		lblEnlace_Anuncio1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/Intro_Series.mp4"); // RUTA DE LA SERIE
				try {
					Desktop.getDesktop().open(path); // ABRE LA SERIE EN EL REPRODUCTOR POR DEFECTO DEL ORDENADOR

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblEnlace_Anuncio1.setHorizontalAlignment(SwingConstants.CENTER);//TEXTO CENTRADO
		lblEnlace_Anuncio1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEnlace_Anuncio1.setBounds(420, 400, 145, 180);
		lblEnlace_Anuncio1.setOpaque(true);//FONDO OPACO Y NO TRANSPARENTE QUE ES EL DE POR DEFECTO, ASÍ PODEMOS DARLE COLOR(SE ELIMINA CUANDO TENGAMOS IMAGEN DEL ANUNCIO)
		lblEnlace_Anuncio1.setFont(new Font("Goudy Stout", Font.ITALIC, 11));
		lblEnlace_Anuncio1.setBackground(new Color(153, 255, 153));//NUESTRO COLOR VERDE TRILOGY DE FONDO DEL CUADRO(SE ELIMINA CUANDO TENGAMOS IMAGEN DEL ANUNCIO)
		lblEnlace_Anuncio1.setIcon(CatalogoAudiovisual.obtenerImagenSeries(6,lblEnlace_Anuncio1.getWidth(),lblEnlace_Anuncio1.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lblEnlace_Anuncio2 SUGERENCIA DE ANUNCIO 2
		//------------------------------------------------------------------------------------------------------------
		lblEnlace_Anuncio2 = new JLabel();
		lblEnlace_Anuncio2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/Intro_pelicula.mp4"); // RUTA DEL TRAILER
				try {
					Desktop.getDesktop().open(path); // ABRE LA PELÍCULA EN EL EDITOR POR DEFECTO DE TU ORDENADRO
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblEnlace_Anuncio2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEnlace_Anuncio2.setOpaque(true);
		lblEnlace_Anuncio2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnlace_Anuncio2.setFont(new Font("Goudy Stout", Font.ITALIC, 11));
		lblEnlace_Anuncio2.setBackground(new Color(153, 255, 153));
		lblEnlace_Anuncio2.setBounds(605, 400, 145, 180);
		lblEnlace_Anuncio2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(7,lblEnlace_Anuncio2.getWidth(),lblEnlace_Anuncio2.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lblEnlace_Anuncio3 SUGERENCIA DE ANUNCIO 3
		//------------------------------------------------------------------------------------------------------------
		lblEnlace_Anuncio3 = new JLabel();
		lblEnlace_Anuncio3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA PELÍCULA EN EL EDITOR POR DEFECTO DE TU ORDENADRO
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblEnlace_Anuncio3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEnlace_Anuncio3.setOpaque(true);
		lblEnlace_Anuncio3.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnlace_Anuncio3.setFont(new Font("Goudy Stout", Font.ITALIC, 11));
		lblEnlace_Anuncio3.setBackground(new Color(153, 255, 153));
		lblEnlace_Anuncio3.setBounds(785, 400, 145, 180);
		lblEnlace_Anuncio3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(0,lblEnlace_Anuncio3.getWidth(),lblEnlace_Anuncio3.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//btnBuscar EL BOTÓN DE BUSCAR
		//------------------------------------------------------------------------------------------------------------
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id_membresia = Inicio_Sesion.id_de_membresia;
				if (id_membresia==1) {
					String nom_can = nombreCancion(text_Barra_busqueda.getText());
					if (nom_can==null || nom_can=="") {
						lblEnlace_Anuncio3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(0,lblEnlace_Anuncio3.getWidth(),lblEnlace_Anuncio3.getHeight()));
						lblEnlace_Anuncio3.setText("");
					} else {
						lblEnlace_Anuncio3.setIcon(null);
						lblEnlace_Anuncio3.setText(nom_can);
					}
				} else if (id_membresia==2) {
					String nom_can = nombreCancion(text_Barra_busqueda.getText());
					String nom_ser = nombreSerie(text_Barra_busqueda.getText());
					if (nom_can==null || nom_can=="") {
						lblEnlace_Anuncio3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(0,lblEnlace_Anuncio3.getWidth(),lblEnlace_Anuncio3.getHeight()));
						lblEnlace_Anuncio3.setText("");
					} else if (nom_ser==null || nom_ser=="") {
						lblEnlace_Anuncio1.setIcon(CatalogoAudiovisual.obtenerImagenSeries(6,lblEnlace_Anuncio1.getWidth(),lblEnlace_Anuncio1.getHeight()));
						lblEnlace_Anuncio1.setText("");
					} else if ((nom_can==null || nom_can=="") && (nom_ser==null || nom_ser=="")) {
						lblEnlace_Anuncio3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(0,lblEnlace_Anuncio3.getWidth(),lblEnlace_Anuncio3.getHeight()));
						lblEnlace_Anuncio1.setIcon(CatalogoAudiovisual.obtenerImagenSeries(6,lblEnlace_Anuncio1.getWidth(),lblEnlace_Anuncio1.getHeight()));
						lblEnlace_Anuncio3.setText("");
						lblEnlace_Anuncio1.setText("");
					} else {
						lblEnlace_Anuncio3.setIcon(null);
						lblEnlace_Anuncio3.setText(nom_can);
						lblEnlace_Anuncio1.setIcon(null);
						lblEnlace_Anuncio1.setText(nom_ser);
					}
				} else if (id_membresia==3) {

					String nom_can = nombreCancion(text_Barra_busqueda.getText());
					String nom_pel = nombrePeli(text_Barra_busqueda.getText());
					if (nom_can==null || nom_can=="") {
						lblEnlace_Anuncio3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(0,lblEnlace_Anuncio3.getWidth(),lblEnlace_Anuncio3.getHeight()));
						lblEnlace_Anuncio3.setText("");
					} else if (nom_pel==null || nom_pel=="") {
						lblEnlace_Anuncio2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(7,lblEnlace_Anuncio2.getWidth(),lblEnlace_Anuncio2.getHeight()));
						lblEnlace_Anuncio2.setText("");
					} else if ((nom_can==null || nom_can=="") && (nom_pel==null || nom_pel=="")) {
						lblEnlace_Anuncio3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(0,lblEnlace_Anuncio3.getWidth(),lblEnlace_Anuncio3.getHeight()));
						lblEnlace_Anuncio2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(7,lblEnlace_Anuncio2.getWidth(),lblEnlace_Anuncio2.getHeight()));
						lblEnlace_Anuncio3.setText("");
						lblEnlace_Anuncio2.setText("");
					} else {
						lblEnlace_Anuncio3.setIcon(null);
						lblEnlace_Anuncio3.setText(nom_can);
						lblEnlace_Anuncio2.setIcon(null);
						lblEnlace_Anuncio2.setText(nom_pel);
					}
				} else if (id_membresia==4) {
					String nom_can = nombreCancion(text_Barra_busqueda.getText());
					String nom_ser = nombreSerie(text_Barra_busqueda.getText());
					String nom_pel = nombrePeli(text_Barra_busqueda.getText());
					if ((nom_can==null || nom_can=="") && (nom_ser==null || nom_ser=="") && (nom_pel==null || nom_pel=="")) {
						lblEnlace_Anuncio3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(0,lblEnlace_Anuncio3.getWidth(),lblEnlace_Anuncio3.getHeight()));
						lblEnlace_Anuncio2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(7,lblEnlace_Anuncio2.getWidth(),lblEnlace_Anuncio2.getHeight()));
						lblEnlace_Anuncio1.setIcon(CatalogoAudiovisual.obtenerImagenSeries(6,lblEnlace_Anuncio1.getWidth(),lblEnlace_Anuncio1.getHeight()));
						lblEnlace_Anuncio3.setText("");
						lblEnlace_Anuncio2.setText("");
						lblEnlace_Anuncio1.setText("");
					} else if ((nom_ser==null || nom_ser=="") && (nom_pel==null || nom_pel==""))  {
						lblEnlace_Anuncio2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(7,lblEnlace_Anuncio2.getWidth(),lblEnlace_Anuncio2.getHeight()));
						lblEnlace_Anuncio2.setText("");
						lblEnlace_Anuncio1.setIcon(CatalogoAudiovisual.obtenerImagenSeries(6,lblEnlace_Anuncio1.getWidth(),lblEnlace_Anuncio1.getHeight()));
						lblEnlace_Anuncio1.setText("");
					} else if ((nom_can==null || nom_can=="") && (nom_pel==null || nom_pel=="")) {
						lblEnlace_Anuncio3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(0,lblEnlace_Anuncio3.getWidth(),lblEnlace_Anuncio3.getHeight()));
						lblEnlace_Anuncio2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(7,lblEnlace_Anuncio2.getWidth(),lblEnlace_Anuncio2.getHeight()));
						lblEnlace_Anuncio3.setText("");
						lblEnlace_Anuncio2.setText("");
					} else if ((nom_can==null || nom_can=="") && (nom_ser==null || nom_ser=="")) {
						lblEnlace_Anuncio3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(0,lblEnlace_Anuncio3.getWidth(),lblEnlace_Anuncio3.getHeight()));
						lblEnlace_Anuncio1.setIcon(CatalogoAudiovisual.obtenerImagenSeries(6,lblEnlace_Anuncio1.getWidth(),lblEnlace_Anuncio1.getHeight()));
						lblEnlace_Anuncio3.setText("");
						lblEnlace_Anuncio1.setText("");
					} else if (nom_can==null || nom_can=="") {
						lblEnlace_Anuncio3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(0,lblEnlace_Anuncio3.getWidth(),lblEnlace_Anuncio3.getHeight()));
						lblEnlace_Anuncio3.setText("");
					} else if (nom_pel==null || nom_pel=="") {
						lblEnlace_Anuncio2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(7,lblEnlace_Anuncio2.getWidth(),lblEnlace_Anuncio2.getHeight()));
						lblEnlace_Anuncio2.setText("");
					} else if (nom_ser==null || nom_ser=="") {
						lblEnlace_Anuncio1.setIcon(CatalogoAudiovisual.obtenerImagenSeries(6,lblEnlace_Anuncio1.getWidth(),lblEnlace_Anuncio1.getHeight()));
						lblEnlace_Anuncio1.setText("");
					} else {
						lblEnlace_Anuncio3.setIcon(null);
						lblEnlace_Anuncio3.setText(nom_can);
						lblEnlace_Anuncio2.setIcon(null);
						lblEnlace_Anuncio2.setText(nom_pel);
						lblEnlace_Anuncio1.setIcon(null);
						lblEnlace_Anuncio1.setText(nom_ser);
					}
				}
			}
		});
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBounds(813, 92, 123, 28);
		//------------------------------------------------------------------------------------------------------------	
		//text_Barra_busqueda BARRA DE BÚSQUEDA
		//------------------------------------------------------------------------------------------------------------	
		text_Barra_busqueda = new JTextField();
		text_Barra_busqueda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(text_Barra_busqueda.getText().equalsIgnoreCase("¿Qué quieres buscar?...")) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO DEL USUARIO SI LO HAN ESCRITO
					text_Barra_busqueda.setText("");//SI EL TEXTO ESTÁ VACÍO
					text_Barra_busqueda.setForeground(new Color( 0, 0, 0)); //COLOR NEGRO
					text_Barra_busqueda.setBackground(new Color(255,255,255));//COLOR BLANCO
				}
			}			@Override
			public void focusLost(FocusEvent e) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO
				if (text_Barra_busqueda.getText().length() == 0) {
					text_Barra_busqueda.setForeground(new Color(192, 192, 192));
					text_Barra_busqueda.setText("¿Qué quieres buscar?...");
					text_Barra_busqueda.setBackground(UIManager.getColor("TextField.background"));
				}
			}	
		});
		text_Barra_busqueda.setColumns(10);
		text_Barra_busqueda.setBounds(468, 92, 347, 29);
		//------------------------------------------------------------------------------------------------------------	
		//lbl_Logo NUESTRO LOGO DE TRILOGY
		//------------------------------------------------------------------------------------------------------------					
		JLabel lbl_Logo = new JLabel();
		lbl_Logo.setBounds(38, 70, 408, 108);
		ImageIcon logo = new ImageIcon(getClass().getResource("/Trilogy_imagenes/LogoTrilogy.jpg"));// DIRECCION DE LA IMAGEN QUE QUIERO AJUSTAR
		ImageIcon imgfondologo = new ImageIcon(logo.getImage().getScaledInstance(lbl_Logo.getWidth(), lbl_Logo.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMÁTICAMENTE LA IMAGEN AL LABEL
		lbl_Logo.setIcon(imgfondologo);
		//------------------------------------------------------------------------------------------------------------
		//lblBordeSuperior BARRA VERDE SUPERIOR
		//------------------------------------------------------------------------------------------------------------
		JLabel lblBordeSuperior = new JLabel();
		lblBordeSuperior.setOpaque(true);
		lblBordeSuperior.setBackground(new Color(153, 255, 153));
		lblBordeSuperior.setBounds(0, 33, 961, 132);
		//------------------------------------------------------------------------------------------------------------
		//lblFondo_Verde FONDO COLOR VERDE
		//------------------------------------------------------------------------------------------------------------					
		JLabel lblFondo_Verde = new JLabel();
		lblFondo_Verde.setBounds(0, 0, 961, 669);
		ImageIcon fondoverde = new ImageIcon(getClass().getResource("/Trilogy_imagenes/Fondo_Formulario.png"));// DIRECCION DE LA IMAGEN QUE QUIERO AJUSTAR
		ImageIcon imgfondo = new ImageIcon(fondoverde.getImage().getScaledInstance(lblFondo_Verde.getWidth(), lblFondo_Verde.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMÁTICAMENTE LA IMAGEN AL LABEL
		lblFondo_Verde.setIcon(imgfondo);
		// ----------------------------------------------------------------------------------------
		// JERARQUÍA DEL panel_Pagina_busqueda
		// ----------------------------------------------------------------------------------------	
		panel_Pagina_busqueda.add(lblEnlace_Anuncio3);
		panel_Pagina_busqueda.add(lblEnlace_Anuncio2);
		panel_Pagina_busqueda.add(lblEnlace_Anuncio1);
		panel_Pagina_busqueda.add(lblTexto_Anuncio);
		panel_Pagina_busqueda.add(lblTexto_informativo);
		panel_Pagina_busqueda.add(text_Barra_busqueda);
		panel_Pagina_busqueda.add(btnBuscar);
		panel_Pagina_busqueda.add(lbl_Logo);
		panel_Pagina_busqueda.add(lblBordeSuperior);
		panel_Pagina_busqueda.add(lblFondo_Verde);
		contentPane.add(panel_Pagina_busqueda);
	}
}
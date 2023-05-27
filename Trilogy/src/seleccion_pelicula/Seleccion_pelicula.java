package seleccion_pelicula;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import diamante_premium.Diamante_premium;
import diamante_premium.Diamante_premium2;
import panel_IZ.Panel_iz_Principal;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Inicio_RubiStandarCod.Inicio_RubiStandar;
import Inicio_RubiStandarCod.Inicio_RubiStandar2;
import cat_audiovisual.CatalogoAudiovisual;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JButton;
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
 * En la página de Selección Pelicula podrás visualizar la película escogida previamente.
 * @param contentPane CONTIENE TODOS LOS ATRIBUTOS DE LA PÁGINA.
 * @param panel_contenedor CONTIENE TODOS LOS ATRIBUTOS PARA PODER INTERCAMBIAR PANELES SIN COMPLICACIÓN.
 * @param btn_ver_peli ES EL BOTÓN PARA EMPEZAR LA PELÍCULA.
 * @param lbl_datos_pelicula ADQUIERE LOS DATOS DE LA PELÍCULA DE LA BASE DE DATOS.
 * @param lbl_descripcion_peli ES UNA DESCRIPCIÓN DE LA PELÍCULA QUE EL USUARIO VA A VER.
 * @param lbl_portada_peli ES LA PORTADA DE LA PELÍCULA.
 * @param lbl_Fondo TIENE LA IMAGEN DEL FONDO DE LA VENTANA.
 */
public class Seleccion_pelicula extends JFrame {
	/**
	 * Es la versión número 1 de la página de Seleccion_pelicula.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_contenedor;
	private JLabel lbl_Fondo;
	private JLabel lbl_portada_peli;
	private JLabel lbl_descripcion_peli;
	private JLabel lbl_datos_pelicula;
	private JButton btn_ver_peli;
	// ATRUBUTOS O OBJTOS NECESARIOS PARA AL CONEXION Y LA BASE DE DATOS Y LA REALIZACIONDE UN CONSULTA BASICA
	private static String bd="XE"; // NOMBRE DE LA BASE DE DATOS POR DEFECT SIEMPRE DEJAR EL "XE"
	private static String login="TRILOGY"; // USUARIO DE LA BBDD
	private static String password="TRILOGY"; // CONTRASEÑA DE LA BBDD
	// RUTA DE SERVICIO
	private static String url="jdbc:oracle:thin:@localhost:1521:"+bd;
	// PONEMOS LOS OBJETOS A NULL Y SIN INTANCIAR
	static Connection connection=null; // CONEXION A LA BASE DE DATOS
	static Statement st; // PARA REALIZAR SQL ESTATICAS (HAY QUE ENLAZARLA SIEMPRE CON EL "Connection" SINO NO FUNCIONA)
	static ResultSet rs; // PARA REALIZAR LA CONSULTA IGUAL QUE EN SQL DEVELOPER
	/**
	 * En el método main ejecutamos la ventana principal Seleccion_pelicula.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seleccion_pelicula frame = new Seleccion_pelicula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * En el constructor Seleccion_pelicula() están todos los atributos y métodos necesarios para cuando creemos el objeto y tenga todas las funcionalidades.
	 */
	public Seleccion_pelicula() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// ----------------------------------------------------------------------------------------
		// panel_contenedor CONTIENE LOS ATRIBUTOS NECESARIOS
		// ----------------------------------------------------------------------------------------
		panel_contenedor = new JPanel();
		panel_contenedor.setBounds(0, 0, 961, 664);
		contentPane.add(panel_contenedor);
		panel_contenedor.setLayout(null);
		// ----------------------------------------------------------------------------------------
		// lbl_Fondo TIENE LA IMAGEN DE FONDO DE LA PÁGINA
		// ----------------------------------------------------------------------------------------
		lbl_Fondo = new JLabel();
		lbl_Fondo.setBounds(0, 0, 961, 664);
		lbl_Fondo.setOpaque(true);
		lbl_Fondo.setBackground(new Color(50,50,50));
		// ----------------------------------------------------------------------------------------
		// lbl_portada_peli ES LA PORTADA DE LA PELÍCULA.
		// ----------------------------------------------------------------------------------------
		lbl_portada_peli = new JLabel("");
		lbl_portada_peli.setForeground(new Color(255, 0, 0));
		lbl_portada_peli.setFont(new Font("Tw Cen MT", Font.BOLD, 13));
		lbl_portada_peli.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_portada_peli.setBounds(0, 0, 329, 428);
		lbl_portada_peli.setOpaque(true);
		lbl_portada_peli.setBackground(new Color(250,250,250));
		// AJUSTAR IMAGEN AL CONTENIDO
		if (Panel_iz_Principal.pelis_diamnte_premium && Panel_iz_Principal.comprobarDiamante) {
			lbl_portada_peli.setIcon(CatalogoAudiovisual.obtenerImagenPelicula((CatalogoAudiovisual.devolverID_number(Diamante_premium2.ruta_peli)),lbl_portada_peli.getWidth(),lbl_portada_peli.getHeight()));
		} else if (Panel_iz_Principal.pelis_diamnte_premium==false && Panel_iz_Principal.comprobarDiamante) {
			lbl_portada_peli.setIcon(CatalogoAudiovisual.obtenerImagenPelicula((CatalogoAudiovisual.devolverID_number(Diamante_premium.ruta_peli)),lbl_portada_peli.getWidth(),lbl_portada_peli.getHeight()));
		} else if (Panel_iz_Principal.pelis_rubi_standar && Panel_iz_Principal.comprobarPelis) {
			lbl_portada_peli.setIcon(CatalogoAudiovisual.obtenerImagenPelicula((CatalogoAudiovisual.devolverID_number(Inicio_RubiStandar2.ruta_peli)),lbl_portada_peli.getWidth(),lbl_portada_peli.getHeight()));
		} else if (Panel_iz_Principal.pelis_rubi_standar==false && Panel_iz_Principal.comprobarPelis) {
			lbl_portada_peli.setIcon(CatalogoAudiovisual.obtenerImagenPelicula((CatalogoAudiovisual.devolverID_number(Inicio_RubiStandar.ruta_peli)),lbl_portada_peli.getWidth(),lbl_portada_peli.getHeight()));
		}
		String datos_pelicula="Película: ";
		String descripcion_peli="";
		// NOS CONECTAMOS A LA BASE DE DATOS
		Connection con;
		try {
			con = DriverManager.getConnection(url, login, password);
			// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
			String query = "SELECT NOMBRE,DURACION,ARTISTA,FECHA_LANZAMIENTO,DESCRIPCION FROM CAT_AUDIOVISUAL WHERE ID_CAT_AUDIOVISUAL = ?";
			// LE DECIMOS QUE LA ? ANTERIOR COJA EL VALOR DE LA VARIABLE membresia_id (1 ES EL NUMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
			PreparedStatement stmt = con.prepareStatement(query);
			if (Panel_iz_Principal.pelis_diamnte_premium && Panel_iz_Principal.comprobarDiamante) {
				stmt.setString(1, CatalogoAudiovisual.devolverID(Diamante_premium2.ruta_peli));
			} else if (Panel_iz_Principal.pelis_diamnte_premium==false && Panel_iz_Principal.comprobarDiamante) {
				stmt.setString(1, CatalogoAudiovisual.devolverID(Diamante_premium.ruta_peli));
			} else if (Panel_iz_Principal.pelis_rubi_standar && Panel_iz_Principal.comprobarPelis) {
				stmt.setString(1, CatalogoAudiovisual.devolverID(Inicio_RubiStandar2.ruta_peli));
			} else if (Panel_iz_Principal.pelis_rubi_standar==false && Panel_iz_Principal.comprobarPelis) {
				stmt.setString(1, CatalogoAudiovisual.devolverID(Inicio_RubiStandar.ruta_peli));
			}
			// EJECUTAMOS LA QUERY ANTERIOR
			rs = stmt.executeQuery();
			// PARA RECORER LAS LINEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
			// MIENTRAS QUE AYA SIGUIENTE
			while (rs.next()) {
				// ALMACENA EL DATO DE LA COLUMNA NOMBRE EN LA VARIABLE nombre
				datos_pelicula += rs.getString("NOMBRE");
				datos_pelicula +="      Duración: "+ rs.getString("DURACION");
				datos_pelicula +="      Artista: "+ rs.getString("ARTISTA");
				datos_pelicula +="      Fecha de lanzamiento: "+ rs.getString("FECHA_LANZAMIENTO");
				descripcion_peli += rs.getString("DESCRIPCION");
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos de la película. Perdone las molestias.");
			e2.printStackTrace();
		}
		lbl_datos_pelicula = new JLabel(datos_pelicula);
		lbl_datos_pelicula.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_datos_pelicula.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_datos_pelicula.setFont(new Font("SansSerif", Font.BOLD, 11));
		lbl_datos_pelicula.setForeground(new Color(255, 255, 255));
		lbl_datos_pelicula.setBounds(0, 427, 961, 55);
		// ----------------------------------------------------------------------------------------
		// lbl_descripcion_peli ES UNA DESCRIPCIÓN DE LA PELÍCULA QUE EL USUARIO VA A VER.
		// ----------------------------------------------------------------------------------------
		lbl_descripcion_peli = new JLabel();
		lbl_descripcion_peli.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_descripcion_peli.setForeground(new Color(255, 255, 255));
		lbl_descripcion_peli.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_descripcion_peli.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_descripcion_peli.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lbl_descripcion_peli.setBounds(339, 0, 612, 428);
		// Dividir el texto en líneas de longitud máxima
		String textoDividido = "<html>"; // para poder poner br de salto de linea inicio del html
		String[] palabras = descripcion_peli.split(" "); // para detectar los espacios
		FontMetrics fm = lbl_descripcion_peli.getFontMetrics(lbl_descripcion_peli.getFont()); // es para obtener el tipo de letra es decir la fuente de letra del texto
		int anchoMaximo = lbl_descripcion_peli.getWidth(); // recogo el ancho del label
		int anchoActual = 0; // esto para que el inicio del ancho sea 0 para poder ir incrementando
		// recorro todo el texto con un for each
		for (String palabra : palabras) { 
			int anchoPalabra = fm.stringWidth(palabra); // coger el ancho de la palabra
			// si la suma del ancho actual y el ancho de la palabra es mañor al ancho del label pongo un br
			if (anchoActual + anchoPalabra > anchoMaximo) {
				textoDividido += "<br>"; // salto de linea
				anchoActual = 0; // buelbo a poner el encho a 0 para que vuelva al inicio
			}
			textoDividido += palabra + " "; // reconstruyo el texto con los parametros necesarios
			anchoActual += anchoPalabra + fm.stringWidth(" "); // actualizo el ancho actual
		}
		textoDividido += "</html>"; // para poder poner br de salto de linea y el cierre del html
		// Pongo el texto dividido con html en el label
		lbl_descripcion_peli.setText(textoDividido);
		// ----------------------------------------------------------------------------------------
		// btn_ver_peli ES EL BOTÓN PARA EMPEZAR LA PELÍCULA.
		// ----------------------------------------------------------------------------------------
		btn_ver_peli = new JButton("Ver_pelicula");
		btn_ver_peli.setOpaque(true);
		btn_ver_peli.setBackground(new Color(153, 255, 153));
		btn_ver_peli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// CUANDO HACE CLICK TE MUESTRA LA PELÍCULA QUE RECOMIENDA EL TEXTO PUBLICITARIO
				File path = new File ("./src/Trilogy_imagenes/Intro_pelicula.mp4"); // RUTA DEL TRAILER
				try {
					Desktop.getDesktop().open(path); // ABRE LA PELÍCULA EN EL EDITOR POR DEFECTO DE TU ORDENADRO
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btn_ver_peli.setBounds(0, 483, 961, 181);
		// ----------------------------------------------------------------------------------------
		// JERARQUÍA DEL panel_contenedor
		// ----------------------------------------------------------------------------------------
		panel_contenedor.add(btn_ver_peli);
		panel_contenedor.add(lbl_datos_pelicula);
		panel_contenedor.add(lbl_descripcion_peli);
		panel_contenedor.add(lbl_portada_peli);
		panel_contenedor.add(lbl_Fondo);
	}
}
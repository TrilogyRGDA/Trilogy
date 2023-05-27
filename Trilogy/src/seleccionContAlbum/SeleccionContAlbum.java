package seleccionContAlbum;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
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
import inicio_Cristal_Basic.Cristal_Basic;
import inicio_Cristal_Basic.Cristal_Basic2;
import panel_IZ.Panel_iz_Principal;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * Esta clase es para elegir las canciones que quieras escuchar de un álbum.
 * @author TRILOGY. Miembros: Adrián Leal Vacas, Gonzalo Amo Cano y Raúl Senso Montojo.
 * @param contentPane CONTIENE TODOS LOS ATRIBUTOS DE LA PÁGINA.
 * @param panelContenedor CONTIENE TODOS LOS ATRIBUTOS PARA PODER INTERCAMBIAR PANELES SIN COMPLICACIÓN.
 * @param btnplay1 ES EL BOTÓN PARA REANUDAR O EMPEZAR A ESCUCHAR LA CANCIÓN.
 * @param btnplay3 ES EL BOTÓN PARA REANUDAR O EMPEZAR A ESCUCHAR LA CANCIÓN.
 * @param btnSalida CIERRA LA VENTANA.
 * @param btnplay2 ES EL BOTÓN PARA REANUDAR O EMPEZAR A ESCUCHAR LA CANCIÓN.
 * @param lblTxtDuracion2 TIENE LA DURACIÓN DE LA CANCIÓN.(ESTÉTICO)
 * @param lblTxtDuracion3 TIENE LA DURACIÓN DE LA CANCIÓN.(ESTÉTICO)
 * @param lblTxtDuracion1 TIENE LA DURACIÓN DE LA CANCIÓN.(ESTÉTICO)
 * @param lblTextoCancion2 TIENE EL NOMBRE DE LA CANCIÓN.(ESTÉTICO)
 * @param lblTextoCancion3 TIENE EL NOMBRE DE LA CANCIÓN.(ESTÉTICO)
 * @param lblTextoCancion1 TIENE EL NOMBRE DE LA CANCIÓN.(ESTÉTICO)
 * @param lblTextoNombreyCreador TIENE EL NOMBRE DEL ÁLBUM Y EL NOMBRE DEL CREADOR.(ESTÉTICO)
 * @param lbl_Portada3 TIENE LA PORTADA DE LA CANCIÓN.(ESTÉTICO)
 * @param lbl_Portada2 TIENE LA PORTADA DE LA CANCIÓN.(ESTÉTICO)
 * @param lbl_Portada1 TIENE LA PORTADA DE LA CANCIÓN.(ESTÉTICO)
 * @param lbl_linea ES LA LÍNEA PARA SEPARAR LA PÁGINA.(ESTÉTICO)
 * @param lbl_Portada_Album TIENE LA PORTADA DEL ÁLBUM.(ESTÉTICO)
 * @param lbl_IMG_Fondo1 TIENE LA IMAGEN DE FONDO DE LA PÁGINA.(ESTÉTICO)
 */
public class SeleccionContAlbum extends JFrame {
	/**
	 * Es la única versión de la página de seleccion contenido del álbum.
	 */
	// ----------------------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnplay3;
	private JButton btnSalida;
	private JButton btnplay2;
	private JPanel panelContenedor;
	private JLabel lblTxtDuracion2;
	private JLabel lblTxtDuracion3;
	private JLabel lblTxtDuracion1;
	private JLabel lblTextoCancion2;
	private JLabel lblTextoCancion3;
	private JLabel lblTextoCancion1;
	private JLabel lblTextoNombreyCreador;
	private JLabel lbl_Portada3;
	private JLabel lbl_Portada2;
	private JLabel lbl_Portada1;
	private JLabel lbl_linea;
	private JLabel lbl_Portada_Album;
	private JLabel lbl_IMG_Fondo1;
	private JButton btnplay1;
	// ATRIBUTOS O OBJETOS NECESARIOS PARA AL CONEXIÓN Y LA BASE DE DATOS Y LA REALIZACION DE UN CONSULTA BÁSICA
	private static String bd="XE"; // NOMBRE DE LA BASE DE DATOS POR DEFECTO SIEMPRE DEJAR EL "XE"
	private static String login="TRILOGY"; // USUARIO DE LA BBDD
	private static String password="TRILOGY"; // CONTRASEÑA DE LA BBDD
	// RUTA DE SERVICIO
	private static String url="jdbc:oracle:thin:@localhost:1521:"+bd;
	// PONEMOS LOS OBJETOS A NULL Y SIN INSTANCIAR
	static Connection connection=null; // CONEXIÓN A LA BASE DE DATOS
	static Statement st; // PARA REALIZAR SQL ESTÁTICAS (HAY QUE ENLAZARLA SIEMPRE CON EL "Connection" SINO, NO FUNCIONA)
	static ResultSet rs; // PARA REALIZAR LA CONSULTA IGUAL QUE EN SQL DEVELOPER
	/**
	 * En el método main ejecutamos la ventana principal SeleccionContAlbum.
	 */
	// ----------------------------------------------------------------------------------------
	// MÉTODO MAIN
	// ----------------------------------------------------------------------------------------
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionContAlbum frame = new SeleccionContAlbum();
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
	 * En el constructor SeleccionContAlbum() están todos los atributos y métodos necesarios para cuando creemos el objeto tenga toda la funcionalidades.
	 */
	public SeleccionContAlbum() {
		// ----------------------------------------------------------------------------------------
		// contentPane CONTIENE TODOS LOS ATRIBUTOS DE LA PÁGINA
		// ----------------------------------------------------------------------------------------
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 703);
		// Establecer el fondo con transparencia
		contentPane.setBackground(new Color(0,0,0,10));
		contentPane.setLayout(null);
		// ----------------------------------------------------------------------------------------
		// panelContenedor CONTIENE TODOS LOS ATRIBUTOS PARA PODER INTERCAMBIAR PANELES SIN COMPLICACIÓN
		// ----------------------------------------------------------------------------------------
		panelContenedor = new JPanel();
		panelContenedor.setBounds(0, 0, 961, 664);
		panelContenedor.setLayout(null);
		// ----------------------------------------------------------------------------------------
		// AJUSTAR IMAGEN AL CONTENIDO
		// ----------------------------------------------------------------------------------------
		ImageIcon IconoSalida = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoLogout.png"));
		ImageIcon fondoIMG = new ImageIcon(getClass().getResource("/Trilogy_imagenes/Fondo_azul_SeleccionAlbum.jpg")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon play=new ImageIcon(getClass().getResource("/Trilogy_imagenes/Boton_Play_Verde.jpg"));
		// ----------------------------------------------------------------------------------------
		//btnplay3 ES EL BOTÓN PARA REANUDAR O EMPEZAR A ESCUCHAR LA CANCIÓN.
		// ----------------------------------------------------------------------------------------
		btnplay3 = new JButton("");
		btnplay3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA CANCIÓN EN EL EDITOR POR DEFECTO DEL ORDENADRO
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnplay3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnplay3.setContentAreaFilled(false);
		btnplay3.setBorderPainted(false);
		btnplay3.setBounds(733, 446, 59, 45);
		ImageIcon imgplay3 = new ImageIcon(play.getImage().getScaledInstance(btnplay3.getWidth(), btnplay3.getHeight(), Image.SCALE_SMOOTH));
		btnplay3.setIcon(imgplay3);
		// ----------------------------------------------------------------------------------------
		//btnSalida CIERRA LA VENTANA.
		// ----------------------------------------------------------------------------------------
		btnSalida = new JButton("");
		btnSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); // CUANDO PINCHAS EN EL ICONO LA ACCIÓN ES SALIR DE LA VENTANA
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalida.setContentAreaFilled(true);
				//btnSalida.setBackground(new Color(255, 255, 255, 180)); BUSCAR SOLUCIÓN
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalida.setContentAreaFilled(false);
			}
		});
		btnSalida.setBounds(0,607,64,57);
		btnSalida.setBorderPainted(false);
		btnSalida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalida.setContentAreaFilled(false);
		ImageIcon imgSalida = new ImageIcon(IconoSalida.getImage().getScaledInstance(btnSalida.getWidth(), btnSalida.getHeight(), Image.SCALE_SMOOTH));
		btnSalida.setIcon(imgSalida);
		// ----------------------------------------------------------------------------------------
		//btnplay2 ES EL BOTÓN PARA REANUDAR O EMPEZAR A ESCUCHAR LA CANCIÓN.
		// ----------------------------------------------------------------------------------------
		btnplay2 = new JButton("");
		btnplay2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA CANCIÓN EN EL EDITOR POR DEFECTO DE TU ORDENADRO
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnplay2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnplay2.setContentAreaFilled(false);
		btnplay2.setBorderPainted(false);
		btnplay2.setBounds(733, 390, 59, 45);
		ImageIcon imgplay2 = new ImageIcon(play.getImage().getScaledInstance(btnplay2.getWidth(), btnplay2.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMÁTICAMENTE LA IMAGEN
		btnplay2.setIcon(imgplay2);
		// ----------------------------------------------------------------------------------------
		//btnplay1 ES EL BOTÓN PARA REANUDAR O EMPEZAR A ESCUCHAR LA CANCIÓN.
		// ----------------------------------------------------------------------------------------
		btnplay1 = new JButton("");
		btnplay1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA CANCIÓN EN EL EDITOR POR DEFECTO DEL ORDENADRO
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnplay1.setBounds(733, 334, 59, 45);
		ImageIcon imgPlay1 = new ImageIcon(play.getImage().getScaledInstance(btnplay1.getWidth(), btnplay1.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMÁTICAMENTE LA IMAGEN
		btnplay1.setIcon(imgPlay1);
		btnplay1.setIcon(imgPlay1);
		btnplay1.setBorderPainted(false);
		btnplay1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnplay1.setContentAreaFilled(false);
		// ----------------------------------------------------------------------------------------
		//lbl_Portada3 TIENE LA PORTADA DE LA CANCIÓN.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lbl_Portada3 = new JLabel("");
		lbl_Portada3.setOpaque(true);
		lbl_Portada3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Portada3.setForeground(Color.BLACK);
		lbl_Portada3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Portada3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Portada3.setBackground(Color.LIGHT_GRAY);
		lbl_Portada3.setBounds(82, 448, 45, 45);
		// ----------------------------------------------------------------------------------------
		//lbl_Portada2 TIENE LA PORTADA DE LA CANCIÓN.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lbl_Portada2 = new JLabel("");
		lbl_Portada2.setOpaque(true);
		lbl_Portada2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Portada2.setForeground(Color.BLACK);
		lbl_Portada2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Portada2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Portada2.setBackground(Color.LIGHT_GRAY);
		lbl_Portada2.setBounds(82, 390, 45, 45);
		// ----------------------------------------------------------------------------------------
		//lbl_Portada1 TIENE LA PORTADA DE LA CANCIÓN.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lbl_Portada1 = new JLabel("");
		lbl_Portada1.setOpaque(true);
		lbl_Portada1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Portada1.setForeground(Color.BLACK);
		lbl_Portada1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Portada1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Portada1.setBackground(Color.LIGHT_GRAY);
		lbl_Portada1.setBounds(82, 334, 45, 45);
		// ----------------------------------------------------------------------------------------
		//lbl_linea ES LA LÍNEA PARA SEPARAR LA PÁGINA.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lbl_linea = new JLabel("");
		lbl_linea.setBackground(new Color(0, 0, 0));
		lbl_linea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_linea.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_linea.setOpaque(true);
		lbl_linea.setForeground(new Color(0, 0, 0));
		lbl_linea.setBounds(0, 308, 961, 2);

		// ----------------------------------------------------------------------------------------
		//lbl_Portada_Album TIENE LA PORTADA DEL ÁLBUM.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lbl_Portada_Album = new JLabel("");
		lbl_Portada_Album.setForeground(new Color(0, 0, 0)); //EL COLOR DEL TEXTO
		lbl_Portada_Album.setBorder(new LineBorder(Color.LIGHT_GRAY)); // EL COLOR DLE BORDE DEL CUADRO
		lbl_Portada_Album.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		lbl_Portada_Album.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Portada_Album.setBackground(new Color(192, 192, 192));// COLOR DE FONDO
		lbl_Portada_Album.setBounds(28, 24, 289, 257);//TAMAÑO DEL CUADRO
		// AJUSTAR IMAGEN AL CONTENIDO
		if (Panel_iz_Principal.album_cristal_basic && Panel_iz_Principal.comprobarMusica) {
			lbl_Portada_Album.setIcon(CatalogoAudiovisual.obtenerImagenAlbum((CatalogoAudiovisual.devolverID_array(Cristal_Basic2.ruta_album)), lbl_Portada_Album.getWidth(), lbl_Portada_Album.getHeight()));
			lbl_Portada1.setIcon(CatalogoAudiovisual.obtenerImagenAlbum((CatalogoAudiovisual.devolverID_array(Cristal_Basic2.ruta_album)), lbl_Portada1.getWidth(), lbl_Portada1.getHeight()));
			lbl_Portada2.setIcon(CatalogoAudiovisual.obtenerImagenAlbum((CatalogoAudiovisual.devolverID_array(Cristal_Basic2.ruta_album)), lbl_Portada2.getWidth(), lbl_Portada2.getHeight()));
			lbl_Portada3.setIcon(CatalogoAudiovisual.obtenerImagenAlbum((CatalogoAudiovisual.devolverID_array(Cristal_Basic2.ruta_album)), lbl_Portada3.getWidth(), lbl_Portada3.getHeight()));
		} else if (Panel_iz_Principal.album_cristal_basic==false && Panel_iz_Principal.comprobarMusica) {
			lbl_Portada_Album.setIcon(CatalogoAudiovisual.obtenerImagenAlbum((CatalogoAudiovisual.devolverID_array(Cristal_Basic.ruta_album)),lbl_Portada_Album.getWidth(),lbl_Portada_Album.getHeight()));
			lbl_Portada1.setIcon(CatalogoAudiovisual.obtenerImagenAlbum((CatalogoAudiovisual.devolverID_array(Cristal_Basic.ruta_album)), lbl_Portada1.getWidth(), lbl_Portada1.getHeight()));
			lbl_Portada2.setIcon(CatalogoAudiovisual.obtenerImagenAlbum((CatalogoAudiovisual.devolverID_array(Cristal_Basic.ruta_album)), lbl_Portada2.getWidth(), lbl_Portada2.getHeight()));
			lbl_Portada3.setIcon(CatalogoAudiovisual.obtenerImagenAlbum((CatalogoAudiovisual.devolverID_array(Cristal_Basic.ruta_album)), lbl_Portada3.getWidth(), lbl_Portada3.getHeight()));
		}
		String[] nombreCanciones = new String[5];
		String datos_album="";
		String nom_album="";
		String[] duracion=new String[5];
		Connection con;
		try {
			con = DriverManager.getConnection(url, login, password);
			String query="SELECT NOMBRE_CANCION FROM CANCIONES WHERE ID_ALBUM = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			if (Panel_iz_Principal.album_cristal_basic && Panel_iz_Principal.comprobarMusica) {
				stmt.setInt(1, CatalogoAudiovisual.devolverID_array(Cristal_Basic2.ruta_album)+1);
			}else if (Panel_iz_Principal.album_cristal_basic==false && Panel_iz_Principal.comprobarMusica) {
				stmt.setInt(1, (CatalogoAudiovisual.devolverID_array(Cristal_Basic.ruta_album)+1));
				System.out.println(CatalogoAudiovisual.devolverID_array(Cristal_Basic.ruta_album)+1);
			}
			// EJECUTAMOS LA QUERY ANTERIOR
			rs = stmt.executeQuery();
			int i=0;
			while (rs.next() && i < 5) { // Iterar sobre los registros y asignar los nombres a variables distintas
				nombreCanciones[i] = rs.getString("NOMBRE_CANCION");
				i++;
			}
			rs.close();
			stmt.close();
			String query_album = "SELECT NOMBRE_ALBUM, ARTISTA FROM ALBUMES WHERE ID_ALBUM=?";
			PreparedStatement stmt_album = con.prepareStatement(query_album);
			if (Panel_iz_Principal.album_cristal_basic && Panel_iz_Principal.comprobarMusica) {
				stmt_album.setInt(1, CatalogoAudiovisual.devolverID_array(Cristal_Basic2.ruta_album)+1);
			}else if (Panel_iz_Principal.album_cristal_basic==false && Panel_iz_Principal.comprobarMusica) {
				stmt_album.setInt(1, (CatalogoAudiovisual.devolverID_array(Cristal_Basic.ruta_album)+1));
			}
			ResultSet rs_album = stmt_album.executeQuery();
			if (rs_album.next()) {
				nom_album=rs_album.getString("NOMBRE_ALBUM");
				datos_album += rs_album.getString("NOMBRE_ALBUM");
				datos_album+=", ";
				datos_album += rs_album.getString("ARTISTA");
			}
			rs_album.close();
			stmt_album.close();
			//QUERY DE DURACIÓN
			String query_duracion="SELECT DURACION FROM CANCIONES WHERE ID_ALBUM=?";
			PreparedStatement stmt_DURACION = con.prepareStatement(query_duracion);
			if (Panel_iz_Principal.album_cristal_basic && Panel_iz_Principal.comprobarMusica) {
				stmt_DURACION.setInt(1, CatalogoAudiovisual.devolverID_array(Cristal_Basic2.ruta_album)+1);
			}else if (Panel_iz_Principal.album_cristal_basic==false && Panel_iz_Principal.comprobarMusica) {
				stmt_DURACION.setInt(1, (CatalogoAudiovisual.devolverID_array(Cristal_Basic.ruta_album)+1));
			}
			ResultSet rs_duracion = stmt_DURACION.executeQuery();
			int j=0;
			while (rs_duracion.next() && j < 5) { // Iterar sobre los registros y asignar los nombres a variables distintas
				duracion[j] = rs_duracion.getString("DURACION");
				j++;
			}
			rs_duracion.close();
			stmt_DURACION.close();
			con.close();
		}catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "ERROR. No se ha podido poner los datos del álbum. Perdone las molestias.");
			e2.printStackTrace();
		}
		// ----------------------------------------------------------------------------------------
		//lblTxtDuracion1 TIENE LA DURACIÓN DE LA CANCIÓN.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lblTxtDuracion1 = new JLabel(duracion[1]);
		lblTxtDuracion1.setForeground(Color.WHITE);
		lblTxtDuracion1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtDuracion1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		lblTxtDuracion1.setBounds(833, 350, 98, 14);
		// ----------------------------------------------------------------------------------------
		//lblTxtDuracion2 TIENE LA DURACIÓN DE LA CANCIÓN.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lblTxtDuracion2 = new JLabel(duracion[2]);
		lblTxtDuracion2.setForeground(Color.WHITE);
		lblTxtDuracion2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtDuracion2.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		lblTxtDuracion2.setBounds(833, 407, 98, 14);
		// ----------------------------------------------------------------------------------------
		//lblTxtDuracion3 TIENE LA DURACIÓN DE LA CANCIÓN.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lblTxtDuracion3 = new JLabel(duracion[3]);
		lblTxtDuracion3.setForeground(Color.WHITE);
		lblTxtDuracion3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtDuracion3.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		lblTxtDuracion3.setBounds(833, 460, 98, 14);
		// ----------------------------------------------------------------------------------------
		//lblTextoNombreyCreador TIENE EL NOMBRE DEL ÁLBUM Y EL NOMBRE DEL CREADOR.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lblTextoNombreyCreador = new JLabel(datos_album);
		lblTextoNombreyCreador.setForeground(Color.WHITE);
		lblTextoNombreyCreador.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextoNombreyCreador.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		lblTextoNombreyCreador.setBounds(340, 99, 591, 89);
		// ----------------------------------------------------------------------------------------
		//lblTextoCancion1 TIENE EL NOMBRE DE LA CANCIÓN.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lblTextoCancion1 = new JLabel(nombreCanciones[1]);
		lblTextoCancion1.setForeground(Color.WHITE);
		lblTextoCancion1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		lblTextoCancion1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextoCancion1.setBounds(137, 343, 453, 28);
		// ----------------------------------------------------------------------------------------
		//lblTextoCancion2 TIENE EL NOMBRE DE LA CANCIÓN.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lblTextoCancion2 = new JLabel(nombreCanciones[2]);
		lblTextoCancion2.setForeground(Color.WHITE);
		lblTextoCancion2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextoCancion2.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		lblTextoCancion2.setBounds(137, 399, 453, 28);
		// ----------------------------------------------------------------------------------------
		//lblTextoCancion3 TIENE EL NOMBRE DE LA CANCIÓN.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lblTextoCancion3 = new JLabel(nombreCanciones[3]);
		lblTextoCancion3.setForeground(Color.WHITE);
		lblTextoCancion3.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextoCancion3.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		lblTextoCancion3.setBounds(137, 457, 453, 28);
		// ----------------------------------------------------------------------------------------
		//lbl_IMG_Fondo1 TIENE LA IMAGEN DE FONDO DE LA PÁGINA.(ESTÉTICO)
		// ----------------------------------------------------------------------------------------
		lbl_IMG_Fondo1 = new JLabel("");
		lbl_IMG_Fondo1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMG_Fondo1.setBounds(0, 0, 961, 664);
		ImageIcon imgFondoIMG = new ImageIcon(fondoIMG.getImage().getScaledInstance(lbl_IMG_Fondo1.getWidth(), lbl_IMG_Fondo1.getHeight(), Image.SCALE_SMOOTH));
		lbl_IMG_Fondo1.setIcon(imgFondoIMG);
		lbl_IMG_Fondo1.setOpaque(true);
		// ----------------------------------------------------------------------------------------
		// JERARQUÍA DEL panel_contenedor
		// ----------------------------------------------------------------------------------------
		panelContenedor.add(btnplay3);
		panelContenedor.add(btnSalida);
		panelContenedor.add(btnplay2);
		panelContenedor.add(btnplay1);
		panelContenedor.add(btnplay1);
		panelContenedor.add(lblTxtDuracion2);
		panelContenedor.add(lblTxtDuracion3);
		panelContenedor.add(lblTxtDuracion1);
		panelContenedor.add(lblTextoCancion2);
		panelContenedor.add(lblTextoCancion3);
		panelContenedor.add(lblTextoCancion1);
		panelContenedor.add(lblTextoNombreyCreador);
		panelContenedor.add(lbl_Portada3);
		panelContenedor.add(lbl_Portada2);
		panelContenedor.add(lbl_Portada1);
		panelContenedor.add(lbl_linea);
		panelContenedor.add(lbl_Portada_Album);
		panelContenedor.add(lbl_IMG_Fondo1);
		contentPane.add(panelContenedor);
	}
}
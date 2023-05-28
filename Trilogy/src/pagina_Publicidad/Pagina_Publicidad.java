package pagina_Publicidad;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import cancelacion_cuenta.CancelacionCod;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
//import java.net.URI;
import java.awt.Cursor;
import javax.swing.JButton;
/**
 * Esta página es un pantalla de publicidad. En ella se mostrará un mensaje ofeciendo que veas lo que quieras, 
 * en caso de que no quieras ver nada, te mostramos un mensaje motivador para que veas parte de nuestro contenido, en este caso el trailer de la película para que te quedes con las ganas de verla y desees verla.
 * Esta página tiene dos versiones, ya que el panel de la izquierda se puede reducir de tamaño para una mejor visualización del contenido.
 * @param contentPane
 * Es el panel principal donde contiene todos los atributos necesarios.
 * @param panel_contenedor
 * Contiene todos los atributos, para la facilitar los cambios de panel.
 * @param lbl_IMG_Fondo
 * Tiene la imagen del fondo característico de color verde.(Estético).
 * @param btnEngranaje_Admin
 * El botón btnEngranaje_Admin te envía a una página donde puedes realizar una serie de configuraciones sobre la cuenta del usuario que ha iniciado sesión.
 * @param lbl_Logo
 * Label con la imagen de nuestro logo (Estético).
 * @param lbl_TXT_Publicitario
 * Contiene texto en el que indica lo que puedes hacer en Trilogy(Estético).
 * @param lbl_TXT_Recomen_Peli
 * Contiene texto donde te sugiere que ver, en el lado derecho del texto está "lbl_Trailer_Peli" con el trailer..
 * @param lbl_Trailer_Peli
 * Contiene la imagen de la película que te publicitan en  "lbl_TXT_Recomen_Peli" y cuando pulsas te muestra el trailer de la película.
 * @author TRILOGY. Miembros: Adrián Leal Vacas, Gonzalo Amo Cano y Raúl Senso Montojo.
 */
public class Pagina_Publicidad extends JFrame {
	// UID VERSIÓN
	/**
	 * La versión del programa de Pagina_Publicidad es la 1.
	 * Incluye publicidad y recomendaciones
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	// ------------------------------------------------------------------------------------------------------
	// ATRIBUTOS
	// ------------------------------------------------------------------------------------------------------
	private JPanel contentPane;
	private JPanel panel_contenedor;
	private JLabel lbl_IMG_Fondo;
	private JLabel lbl_Logo;
	private JLabel lbl_TXT_Publicitario;
	private JLabel lbl_TXT_Recomen_Peli;
	private JLabel lbl_Trailer_Peli;
	private JButton btnEngranaje_Admin;
	// ----------------------------------------------------------------------------------------
	// GETTERS AND SETTERS
	// ----------------------------------------------------------------------------------------
	public JPanel getPanel_contenedor() {
		return panel_contenedor;
	}
	public void setPanel_contenedor(JPanel panel_contenedor) {
		this.panel_contenedor = panel_contenedor;
	}
	// ------------------------------------------------------------------------------------------------------
	// MÉTODO MAIN
	// ------------------------------------------------------------------------------------------------------
	/**
	 * En el método main ejecutamos la ventana principal Pagina_Publicidad donde te mostrará publicidad.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagina_Publicidad frame = new Pagina_Publicidad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// ------------------------------------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------------------------------------
	/**
	 * El constructor se llama a los atributos y métodos necesarios para el funcionamiento de la clase Pagina_Publicidad.
	 */
	// ----------------------------------------------------------------------------------------
	// PANEL ADMINISTRADOR
	// ----------------------------------------------------------------------------------------
	public Pagina_Publicidad() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 703); // TAMAÑO DE LA VENTANA PRINCIPAL
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// ----------------------------------------------------------------------------------------
		// PANEL_CONTENEDOR
		// ----------------------------------------------------------------------------------------
		panel_contenedor = new JPanel();
		panel_contenedor.setBounds(0, 0, 961, 664);
		contentPane.add(panel_contenedor);
		panel_contenedor.setLayout(null);
		// ----------------------------------------------------------------------------------------
		// LABEL DE LA IMAGEN DE FONDO
		// ----------------------------------------------------------------------------------------
		lbl_IMG_Fondo = new JLabel("");
		lbl_IMG_Fondo.setBounds(0, 0, 961, 664);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon fondoIMG = new ImageIcon(getClass().getResource("/Trilogy_imagenes/Fondo_Pantalla_Inicio_Oscuro.jpg")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgFondoIMG = new ImageIcon(fondoIMG.getImage().getScaledInstance(lbl_IMG_Fondo.getWidth(), lbl_IMG_Fondo.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMÁTICAMENTE LA IMAGEN
		lbl_IMG_Fondo.setIcon(imgFondoIMG);
		// ----------------------------------------------------------------------------------------
		// btnEngranaje_Admin TE REDIRIGE A ADMINISTRAR TU CUENTA
		// ----------------------------------------------------------------------------------------
		btnEngranaje_Admin = new JButton("");
		btnEngranaje_Admin.setBounds(929, 0, 32, 32);
		btnEngranaje_Admin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEngranaje_Admin.setBackground(new Color(241,245,245)); // COLOR DE FONDO
		btnEngranaje_Admin.addMouseListener(new MouseAdapter() {
			@Override
			//CUANDO PULSAS
			public void mouseClicked(MouseEvent e) {
				try {
					CancelacionCod pag_admin_user = new CancelacionCod();
					pag_admin_user.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon engranaje_admin = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoEngranaje.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgEngranaje_admin = new ImageIcon(engranaje_admin.getImage().getScaledInstance(btnEngranaje_Admin.getWidth(), btnEngranaje_Admin.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMÁTICAMENTE LA IMAGEN
		btnEngranaje_Admin.setIcon(imgEngranaje_admin);
		// ----------------------------------------------------------------------------------------
		// LABEL CON EL LOGO DE TRILOGY
		// ----------------------------------------------------------------------------------------
		lbl_Logo = new JLabel("");
		lbl_Logo.setBounds(255, 75, 450, 100);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon logo = new ImageIcon(getClass().getResource("/Trilogy_imagenes/LogoTrilogy.jpg")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgLogo = new ImageIcon(logo.getImage().getScaledInstance(lbl_Logo.getWidth(), lbl_Logo.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMÁTICAMENTE LA IMAGEN
		lbl_Logo.setIcon(imgLogo);
		// ----------------------------------------------------------------------------------------
		// LABEL DE TEXTO PUBLICITARIO DONDE TE MUESTRA UN MENSAJE
		// ----------------------------------------------------------------------------------------
		lbl_TXT_Publicitario = new JLabel("Selecciona sólo el contenido que te apetece ver.");
		lbl_TXT_Publicitario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TXT_Publicitario.setBounds(180, 240, 600, 100);
		lbl_TXT_Publicitario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_TXT_Publicitario.setOpaque(true); // PARA PODER PONER COLOR DE FONDO
		lbl_TXT_Publicitario.setBackground(new Color(241,245,245)); // COLOR DE FONDO
		// ----------------------------------------------------------------------------------------
		// LABEL RECOMENDADO UNA PELICULA
		// ----------------------------------------------------------------------------------------
		lbl_TXT_Recomen_Peli = new JLabel("<html>"
				+ "<p style=\"text-align: center;\">Hoy es un gran día para ver una película de acción:</p><br>"
				+ "<p style=\"text-align: center;\">Dwayne Johnson, 'La Roca'</p>"
				+ "</html>");
		lbl_TXT_Recomen_Peli.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TXT_Recomen_Peli.setBounds(100, 425, 550, 150);
		lbl_TXT_Recomen_Peli.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_TXT_Recomen_Peli.setOpaque(true); // PARA PODER PONER COLOR DE FONDO
		lbl_TXT_Recomen_Peli.setBackground(new Color(241,245,245)); // COLOR DE FONDO
		// ----------------------------------------------------------------------------------------
		// LABEL DONDE CONTIENE LA PELÍCULA MENCIONADA EN "lbl_TXT_Recomen_Peli"
		// ----------------------------------------------------------------------------------------
		lbl_Trailer_Peli = new JLabel("");
		lbl_Trailer_Peli.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_Trailer_Peli.addMouseListener(new MouseAdapter() {
			// EVENTO AL PULSAR
			@Override
			public void mouseClicked(MouseEvent e) {
				// CUANDO PULSA TE MUESTRA LA PELÍCULA QUE RECOMIENDA EL TEXTO PUBLICITARIO
				File path = new File ("./src/Trilogy_imagenes/Intro_pelicula.mp4"); // RUTA DEL TRAILER
				try {
					Desktop.getDesktop().open(path); // ABRE LA PELÍCULA EN EL REPRODUCTOR POR DEFECTO DE TU ORDENADOR
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				// CON UN ENLACE A INTERNET
				/*try {
					  Desktop desktop = java.awt.Desktop.getDesktop();
					  URI uri = new URI("https://youtu.be/LlIU1o2iyjw");
					  desktop.browse(uri);
					} catch (Exception ex) {
					  ex.printStackTrace();
					}*/
			}
		});
		lbl_Trailer_Peli.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Trailer_Peli.setBounds(720, 393, 169, 230);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon peli = new ImageIcon(getClass().getResource("/Trilogy_imagenes/pelicula_accion.jpg")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgPeli = new ImageIcon(peli.getImage().getScaledInstance(lbl_Trailer_Peli.getWidth(), lbl_Trailer_Peli.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMÁTICAMENTE LA IMAGEN
		lbl_Trailer_Peli.setIcon(imgPeli);
		// ----------------------------------------------------------------------------------------
		// JERARQUIA DEL panel_contenedor
		// ----------------------------------------------------------------------------------------
		panel_contenedor.add(btnEngranaje_Admin);
		panel_contenedor.add(lbl_Trailer_Peli);
		panel_contenedor.add(lbl_TXT_Recomen_Peli);
		panel_contenedor.add(lbl_TXT_Publicitario);
		panel_contenedor.add(lbl_Logo);
		panel_contenedor.add(lbl_IMG_Fondo);
	}
}
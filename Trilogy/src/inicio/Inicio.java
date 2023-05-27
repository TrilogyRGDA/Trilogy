package inicio;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import inicioSesion.Inicio_Sesion;
import registro.Formulario;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
/**
 * Esta clase es la principal cuando inicia la aplicación.
 * En esta clase puedes iniciar sesión en el caso que ya te hayas registrado o por el contrario, registrarse en la ventana Formulario.
 * La ventana de inicio esta separada en 2 partes principales. 
 * 1ª Poder registrarse en la aplicación para empezar a consumir contenido audiovisual. 
 * 2ª Poder iniciar sesión en el caso que previamente estés registrado y poder empezar a consumir contenido audiovisual.
 * contentPane
 * Es el panel principal donde contiene todos los atributos necesarios.
 * @param lbl_IMG_Fondo
 * Contiene la imagen del fondo.
 * @param lbl_IMG_Logo
 * Contiene la imagen del logo.
 * @param lbl_Texto_Publicidad
 * Contiene un texto de publicidad.
 * @param btn_Registrarse
 * Es el botón donde te redirige a la ventana para registrarse.
 * @param btn_InicioSesion
 * Es el botón donde te redirige a la ventana para iniciar sesión.
 * @param btn_Salir
 * Es el botón que te permite cerrar la aplicación.
 * @author TRILOGY. Miembros: Adrián Leal Vacas, Gonzalo Amo Cano y Raúl Senso Montojo.
 */
public class Inicio extends JFrame {
	// UID VERSIÓN
	/**
	 * La única versión del programa de Inicio.
	 * Incluye las posibilidades de registro e inicio de sesión.
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	// ----------------------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------------------
	private JPanel contentPane;
	private JLabel lbl_IMG_Fondo;
	private JLabel lbl_IMG_Logo;
	private JLabel lbl_Texto_Publicidad;
	private JButton btn_Registrarse;
	private JButton btn_InicioSesion;
	private JButton btn_Salir;
	// ----------------------------------------------------------------------------------------
	// MÉTODO MAIN
	// ----------------------------------------------------------------------------------------
	/**
	 * En el método main ejecutamos la ventana principal Inicio donde será la primera ventana de la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	 * El constructor invoca a los atributos y métodos necesarios para el funcionamiento de la clase Inicio.
	 */
	public Inicio() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// ----------------------------------------------------------------------------------------
		// FONDO DE LA PANTALLA
		// ----------------------------------------------------------------------------------------
		lbl_IMG_Fondo = new JLabel("");
		lbl_IMG_Fondo.setBounds(0, 0, 1180, 664);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon fondoIMG = new ImageIcon(getClass().getResource("/Trilogy_imagenes/Fondo_Pantalla_Inicio_Oscuro.jpg")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgFondoIMG = new ImageIcon(fondoIMG.getImage().getScaledInstance(lbl_IMG_Fondo.getWidth(), lbl_IMG_Fondo.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		lbl_IMG_Fondo.setIcon(imgFondoIMG);
		lbl_IMG_Fondo.setOpaque(false);
		// ----------------------------------------------------------------------------------------
		// IMAGEN DEL LOGO
		// ----------------------------------------------------------------------------------------
		lbl_IMG_Logo = new JLabel("");
		lbl_IMG_Logo.setForeground(new Color(255, 255, 255));
		lbl_IMG_Logo.setBounds(390, 100, 400, 100);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon logo = new ImageIcon(getClass().getResource("/Trilogy_imagenes/LogoTrilogy.jpg")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgLogo = new ImageIcon(logo.getImage().getScaledInstance(lbl_IMG_Logo.getWidth(), lbl_IMG_Logo.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		lbl_IMG_Logo.setIcon(imgLogo);
		// ----------------------------------------------------------------------------------------
		// TEXTO DE PUBLICIDAD
		// ----------------------------------------------------------------------------------------
		lbl_Texto_Publicidad = new JLabel("<html>"
				+ "<p style=\"text-align: center;\">TODA LA MÚSICA</p>"
				+ "<p style=\"text-align: center;\">Y TU DECIDES QUE MÁS DESEAS VER</p>"
				+ "<p style=\"text-align: center;\">CORREO: trilogyrgda@gmail.com</p>"
				+ "</html>");
		lbl_Texto_Publicidad.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_Texto_Publicidad.setOpaque(true); // PARA PODER PONER COLOR DE FONDO
		lbl_Texto_Publicidad.setBackground(new Color(241,245,245)); // COLOR DE FONDO
		lbl_Texto_Publicidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Texto_Publicidad.setBounds(390, 287, 400, 100);
		// ----------------------------------------------------------------------------------------
		// BOTÓN REGISTRARSE
		// ----------------------------------------------------------------------------------------
		btn_Registrarse = new JButton("REGISTRARSE");
		btn_Registrarse.setBorderPainted(false);
		btn_Registrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// EVENTOS DEL RATÓN
		btn_Registrarse.addMouseListener(new MouseAdapter() {
			// CUANDO ESTAS PASANDO POR ENCIMA
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Registrarse.setBackground(new Color(190,190,190)); // EL COLOR QUE SE VA A PONER CUANDO PASES POR ENCIMA
			}
			// CUANDO DEJES DE PASAR POR ENCIMA
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Registrarse.setBackground(new Color(255,255,255)); // EL COLOR QUE SE VA A PONER CUANDO DEJES DE PASAR POR ENCIMA
			}
			// CUANDO HACES CLICK, CIERRA LA PÁGINA DE INICIO Y ABRE LA DE REGISTRO
			@Override
			public void mouseClicked(MouseEvent e) {
				Formulario formularioReg = new Formulario(); // INSTANCIAR LA VENTANA DE REGISTRO.
				formularioReg.setVisible(true); // MUESTRA LA VENTANA SELECCIONADA
				dispose(); // CIERRA LA VENTANA ACTUAL
			}
		});
		btn_Registrarse.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btn_Registrarse.setBackground(new Color(241,245,245));
		btn_Registrarse.setBounds(369, 458, 440, 80);
		// ----------------------------------------------------------------------------------------
		// BOTÓN INICIO SESIÓN
		// ----------------------------------------------------------------------------------------
		btn_InicioSesion = new JButton("<html><p style=\"text-align: center;\">INICIO</p> <p style=\"text-align: center;\">SESIÓN</p></html>");
		btn_InicioSesion.addMouseListener(new MouseAdapter() {
			// CUANDO ESTAS PASANDO POR ENCIMA
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_InicioSesion.setBackground(new Color(190,190,190)); // EL COLOR QUE SE VA A PONER CUANDO PASES POR ENCIMA
			}
			// CUANDO DEJES DE PASAR POR ENCIMA
			@Override
			public void mouseExited(MouseEvent e) {
				btn_InicioSesion.setBackground(new Color(255,255,255)); // EL COLOR QUE SE VA A PONER CUANDO DEJES DE PASAR POR ENCIMA
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Inicio_Sesion inicioSesion = new Inicio_Sesion();
				inicioSesion.setVisible(true);
				dispose();
			}
		});
		btn_InicioSesion.setBorderPainted(false);
		btn_InicioSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_InicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_InicioSesion.setBackground(new Color(241, 245, 245));
		btn_InicioSesion.setBounds(989, 24, 150, 60);
		// ----------------------------------------------------------------------------------------
		// BOTÓN DE SALIR
		// ----------------------------------------------------------------------------------------
		btn_Salir = new JButton("");
		btn_Salir.setHorizontalAlignment(SwingConstants.CENTER);
		btn_Salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Salir.setBounds(37, 582, 60, 58);
		btn_Salir.setFocusPainted(false);
		btn_Salir.setBorderPainted(false);
		btn_Salir.setBackground(new Color(241, 245, 245));
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon iconoSalir = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoLogout.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgiconoSalir = new ImageIcon(iconoSalir.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		btn_Salir.setIcon(imgiconoSalir);
		// EVENTOS CON EL RATÓN (MOUSE)
		btn_Salir.addMouseListener(new MouseAdapter() {
			// CUANDO ESTAS PASANDO POR ENCIMA
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Salir.setBackground(new Color(190,190,190)); // EL COLOR QUE SE VA A PONER CUANDO PASES POR ENCIMA
			}
			// CUANDO DEJES DE PASAR POR ENCIMA
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Salir.setBackground(new Color(241,245,225)); // EL COLOR QUE SE VA A PONER CUANDO DEJES DE PASAR POR ENCIMA
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0); // ESTO ES LO QUE HACE QUE CIERRE LA APP
			}
		});
		// ----------------------------------------------------------------------------------------
		// GERARQUIA DEL contentPane
		// ----------------------------------------------------------------------------------------
		contentPane.add(lbl_IMG_Logo);
		contentPane.add(lbl_Texto_Publicidad);
		contentPane.add(btn_Registrarse);
		contentPane.add(btn_InicioSesion);
		contentPane.add(btn_Salir);
		contentPane.add(lbl_IMG_Fondo);
	}
}
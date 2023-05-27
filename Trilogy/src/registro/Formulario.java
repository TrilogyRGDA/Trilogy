package registro;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import inicioSesion.Inicio_Sesion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import Seleccion_MembresiaCod.Seleccion_Membresia;
import javax.swing.JComboBox;
/**
 * En esta clase es para el registro. 
 * Esta clase puedes registrarte y te redirige a la pantalla para elegir la membresía para que luego puedas consumir el contenido audiovisual respectivo a la membresía adquirida.
 * La ventana de registro te permite registrarte en la aplicación para poder consumir los contenidos de la aplicación.
 * @param contentPane CONTIENE TODOS LOS ATRIBUTOS DE LA PÁGINA.
 * @param txtIntroduceTuNombre TIENE EL TEXTO DEL NOMBRE DEL USUARIO.
 * @param txtIntroduceElNtlf TIENE EL TEXTO DEL TELÉFONO DEL USUARIO.
 * @param txt_confirmaEmail TIENE EL TEXTO DE LA CONFIRMACIÓN DE EMAIL.
 * @param txtFecha TIENE EL TEXTO DE LA FECHA DE CADUCIDAD DE LA TARJETA
 * @param txtIntroduceTusEmail_1 TIENE EL TEXTO DEL EMAIL DEL USUARIO.
 * @param textNCuenta TIENE EL TEXTO DEL NÚMERO DE CUENTA DE LA TARJETA DEL USUARIO.
 * @param text_IntroduceApellidos_1 TIENE EL TEXTO DE LOS APELLIDOS DEL USUARIO.
 * @param textCalle TIENE EL TEXTO DE LA CALLE DONDE VIVE EL USUARIO.
 * @param ComboBoxTipo TIENE LAS OPCIONES DE TIPOS DE PAGO QUE PERMITE.
 * @param btnRegistrarme REGISTRA AL USUARIO RECOGIENDO LOS PARÁMETROS ANTERIORES.
 * @param btnInicio_Sesion DIRIGE AL USUARIO A LA PÁGINA INICIO DE SESIÓN.
 * @param passwordField TIENE EL TEXTO DE LA CONTRASEÑA DEL USUARIO.
 * @param lbl_PuertaSalida_1 CIERRA LA VENTANA.(ESTÉTICO)
 * @param lbl_Fecha TIENE EL TEXTO DE FECHA PARA QUE EL USUARIO INTRODUZCA LA FECHA DE CADUCIDAD.(ESTÉTICO)
 * @param lbl_Tipo TIENE EL TEXTO PARA QUE EL USUARIO SELECCIONE EL TIPO DE PAGO.(ESTÉTICO)
 * @param lbl_NCUENTA TIENE EL TEXTO PARA QUE EL USUARIO ESCRIBA EL NÚMERO DE CUENTA.(ESTÉTICO)
 * @param lbl_Tlf TIENE EL TEXTO DE TELÉFONO PARA INTRODUCIR EL TELÉFONO.(ESTÉTICO)
 * @param lbl_Calle TIENE EL TÍTULO DE LA CALLE.(ESTÉTICO)
 * @param lbl_DatosBancarios TIENE EL TEXTO DE DATOS BANCARIOS.(ESTÉTICO)
 * @param lbl_Contraseña1 TIENE EL TEXTO DE INTRODUCE LA CONTRASEÑA.(ESTÉTICO)
 * @param lbl_confirmacionEmail TIENE EL TEXTO  QUE CONFIRMA EL EMAIL.(ESTÉTICO)
 * @param lbl_Email TIENE EL TEXTO DE EMAIL.(ESTÉTICO)
 * @param lbl_Apellido TIENE EL TÍTULO DE INTRODUCIR EL APELLIDO.(ESTÉTICO)
 * @param lbl_AccesoAMiembros TIENE EL TÍTULO DE ACCESO A MIEMBROS.(ESTÉTICO)
 * @param lbl_REGISTRO TIENE EL TÍTULO DE REGISTRO PARA SER MIEMBROS.(ESTÉTICO)
 * @param lbl_nom TIENE EL TÍTULO DE NOMBRE.(ESTÉTICO)
 * @param lbl_Logo TIENE EL LOGO DE LA EMPRESA.(ESTÉTICO)
 * @param lblBordeSuperior TIENE EL BORDE DE LA PARTE SUPERIOR.
 * @param lbl_Fondo TIENE LA IMAGEN DE FONDO DE LA PÁGINA.
 * @author TRILOGY. Miembros: Adrián Leal Vacas, Gonzalo Amo Cano y Raúl Senso Montojo.
 */
public class Formulario extends JFrame {
	/**
	 * Es la única versión número de la página de formulario.
	 */
	private static final long serialVersionUID = 1L;
	// ----------------------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------------------
	private JPanel contentPane;
	private JLabel lbl_PuertaSalida_1;
	private JTextField txtIntroduceElNtlf;
	private JTextField txt_confirmaEmail;
	private JPasswordField passwordField;
	private JTextField textNCuenta;
	private JTextField txtFecha;
	private JButton btnRegistrarme;
	private JButton btnInicio_Sesion;
	public static String passwd; 
	public static String correo;
	public static String nombre;
	public static String apellidos;
	public static String calle;
	public static String num_telefono;
	public static String num_tarjeta;
	public static String fecha_caducidad;
	public static String tipo_tarjeta;
	private JTextField txtIntroduceTuNombre;
	private JTextField text_IntroduceApellidos_1;
	private JTextField txtIntroduceTusEmail_1;
	private JTextField textCalle;
	private int verificar_datos=0;
	private JComboBox<String> ComboBoxTipo;
	private String texto;
	// ----------------------------------------------------------------------------------------
	// MÉTODO MAIN
	// ----------------------------------------------------------------------------------------
	/**
	 * En el método main ejecutamos la ventana principal de registro (class Formulario) llamada Formulario, donde se ejecuta la ventana de Formulario.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	 * En el constructor Formulario() estaán todos los atributos y métodos necesarios para cuando creemos el objeto tenga todas las funcionalidades.
	 */
	public Formulario() {
		// ----------------------------------------------------------------------------------------
		// contentPane CONTIENE TODOS LOS ATRIBUTOS DE LA PÁGINA
		// ----------------------------------------------------------------------------------------
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 644);//TAMAÑO VENTANA
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//------------------------------------------------------------------------------------------------------
		//lbl_PuertaSalida_1 CIERRA LA VENTANA.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		ImageIcon IconoSalida = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoLogout.png"));			
		lbl_PuertaSalida_1 = new JLabel(); // ACCIÓN CUANDO PULSAS SOBRE EL ICONO DE SALIDA
		lbl_PuertaSalida_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_PuertaSalida_1.setOpaque(true);
		lbl_PuertaSalida_1.setBackground(new Color(32,171,85));
		lbl_PuertaSalida_1.addMouseListener(new MouseAdapter() {
			@Override
			//CUANDO EL RATÓN PASA POR ENCIMA
			public void mouseEntered(MouseEvent e) {
				lbl_PuertaSalida_1.setBackground(new Color(153,255,153));
			}
			@Override
			//CUANDO EL RATÓN DEJA DE PASAR POR ENCIMA
			public void mouseExited(MouseEvent e) {
				lbl_PuertaSalida_1.setBackground(new Color(32,171,85));
			}
			@Override
			//CUANDO PULSAS
			public void mouseClicked(MouseEvent e) {
				System.exit(0);//CIERRA LAS VENTANAS
			}
		});
		lbl_PuertaSalida_1.setIcon(new ImageIcon(Formulario.class.getResource("/Trilogy_imagenes/IconoLogout.png")));
		lbl_PuertaSalida_1.setBounds(10, 537, 64, 57);//TAMAÑO DEL CUADRO
		ImageIcon imgIconoSalida = new ImageIcon(IconoSalida.getImage().getScaledInstance(lbl_PuertaSalida_1.getWidth(), lbl_PuertaSalida_1.getHeight(), Image.SCALE_SMOOTH));
		lbl_PuertaSalida_1.setIcon(imgIconoSalida);
		//------------------------------------------------------------------------------------------------------
		//txtIntroduceTuNombre TIENE EL TEXTO DEL NOMBRE DEL USUARIO.
		//------------------------------------------------------------------------------------------------------
		txtIntroduceTuNombre = new JTextField(); // ACCIÓN CUANDO PULSAS PARA ESCRIBIR TU USUARIO
		txtIntroduceTuNombre.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtIntroduceTuNombre.getText().equalsIgnoreCase("Introduce tu nombre")) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO DEL USUARIO SI LO HAN ESCRITO
					txtIntroduceTuNombre.setText("");
					txtIntroduceTuNombre.setForeground(Color.BLACK); // CAMBIO EL COLOR DE GRIS CLARO A NEGRO
					txtIntroduceTuNombre.setBackground(Color.WHITE); // SIGO CON EL FONDO BLANCO
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				// Restaurar el valor predeterminado del campo de contraseña si está vacío
				if (txtIntroduceTuNombre.getText().length() == 0) {
					txtIntroduceTuNombre.setForeground(new Color(192, 192, 192));
					txtIntroduceTuNombre.setText("Introduce tu nombre");
					txtIntroduceTuNombre.setBackground(UIManager.getColor("TextField.background"));
				}
			}
		});
		//-----------------------------------------------------------------------------------------------------------------------------------------------------
		// TEXTO PARA INTRODUCIR EL TELÉFONO
		//-----------------------------------------------------------------------------------------------------------------------------------------------------
		JTextField txtIntroduceElTLF = new JTextField(); // ACCIÓN CUANDO PULSAS PARA ESCRIBIR TU USUARIO
		txtIntroduceElTLF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtIntroduceElTLF.getText().equalsIgnoreCase("Introduce el tlf")) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO DEL USUARIO SI LO HAN ESCRITO
					txtIntroduceElTLF.setText("");
					txtIntroduceElTLF.setForeground(Color.BLACK); // CAMBIO EL COLOR DE GRIS CLARO A NEGRO
					txtIntroduceElTLF.setBackground(Color.WHITE); // SIGO CON EL FONDO BLANCO
				}
			}		
		});
		//------------------------------------------------------------------------------------------------------
		//text_IntroduceApellidos_1 TIENE EL TEXTO DE LOS APELLIDOS DEL USUARIO.
		//------------------------------------------------------------------------------------------------------
		text_IntroduceApellidos_1 = new JTextField(); // ACCIÓN CUANDO PULSAS PARA ESCRIBIR TU USUARIO
		text_IntroduceApellidos_1.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(text_IntroduceApellidos_1.getText().equalsIgnoreCase("Introduce tus apellidos")) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO DEL USUARIO SI LO HAN ESCRITO
					text_IntroduceApellidos_1.setText("");
					text_IntroduceApellidos_1.setForeground(Color.BLACK); // CAMBIO EL COLOR DE GRIS CLARO A NEGRO
					text_IntroduceApellidos_1.setBackground(Color.WHITE); // SIGO CON EL FONDO BLANCO
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				// Restaurar el valor predeterminado del campo de contraseña si está vacío
				if (text_IntroduceApellidos_1.getText().length() == 0) {
					text_IntroduceApellidos_1.setForeground(new Color(192, 192, 192));
					text_IntroduceApellidos_1.setText("Introduce tus apellidos");
					text_IntroduceApellidos_1.setBackground(UIManager.getColor("TextField.background"));
				}
			}
		});
		//------------------------------------------------------------------------------------------------------
		//txtIntroduceElNtlf TIENE EL TEXTO DEL TELÉFONO DEL USUARIO.
		//------------------------------------------------------------------------------------------------------
		txtIntroduceElNtlf = new JTextField();
		txtIntroduceElNtlf.setText("Introduce el NºTLF");
		txtIntroduceElNtlf.setForeground(Color.LIGHT_GRAY);
		txtIntroduceElNtlf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIntroduceElNtlf.setColumns(10);
		txtIntroduceElNtlf.setBackground(Color.WHITE);
		txtIntroduceElNtlf.setBounds(325, 290, 224, 30);
		txtIntroduceElNtlf.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtIntroduceElNtlf.getText().equalsIgnoreCase("Introduce el NºTLF")) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO DEL USUARIO SI LO HAN ESCRITO
					txtIntroduceElNtlf.setText("");
					txtIntroduceElNtlf.setForeground(Color.BLACK); // CAMBIO EL COLOR DE GRIS CLARO A NEGRO
					txtIntroduceElNtlf.setBackground(Color.WHITE); // SIGO CON EL FONDO BLANCO
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				// Restaurar el valor predeterminado del campo de contraseña si está vacío
				if (txtIntroduceElNtlf.getText().length() == 0) {
					txtIntroduceElNtlf.setForeground(new Color(192, 192, 192));
					txtIntroduceElNtlf.setText("Introduce el NºTLF");
					txtIntroduceElNtlf.setBackground(UIManager.getColor("TextField.background"));
				}
			}
		});
		//------------------------------------------------------------------------------------------------------
		//txt_confirmaEmail TIENE EL TEXTO DE LA CONFIRMACIÓN DE EMAIL
		//------------------------------------------------------------------------------------------------------
		txt_confirmaEmail = new JTextField();
		txt_confirmaEmail.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txt_confirmaEmail.getText().equalsIgnoreCase("Introduce tu email")) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO DEL USUARIO SI LO HAN ESCRITO
					txt_confirmaEmail.setText("");
					txt_confirmaEmail.setForeground(Color.BLACK); // CAMBIO EL COLOR DE GRIS CLARO A NEGRO
					txt_confirmaEmail.setBackground(Color.WHITE); // SIGO CON EL FONDO BLANCO
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				// Restaurar el valor predeterminado del campo de contraseña si está vacío
				if (txt_confirmaEmail.getText().length() == 0) {
					txt_confirmaEmail.setForeground(new Color(192, 192, 192));
					txt_confirmaEmail.setText("Introduce tu email");
					txt_confirmaEmail.setBackground(UIManager.getColor("TextField.background"));
				}
			}
		});
		//------------------------------------------------------------------------------------------------------
		//txtFecha TIENE EL TEXTO DE LA FECHA DE CADUCIDAD DE LA TARJETA
		//------------------------------------------------------------------------------------------------------
		txtFecha = new JTextField();
		txtFecha.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtFecha.getText().equalsIgnoreCase("Introduce la Fecha")) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO DEL USUARIO SI LO HAN ESCRITO
					txtFecha.setText("");
					txtFecha.setForeground(Color.BLACK); // CAMBIO EL COLOR DE GRIS CLARO A NEGRO
					txtFecha.setBackground(Color.WHITE); // SIGO CON EL FONDO BLANCO
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				// Restaurar el valor predeterminado del campo de contraseña si está vacío
				if (txtFecha.getText().length() == 0) {
					txtFecha.setForeground(new Color(192, 192, 192));
					txtFecha.setText("Introduce la Fecha");
					txtFecha.setBackground(UIManager.getColor("TextField.background"));
				}
			}
		});
		txtFecha.setText("Introduce la Fecha");
		txtFecha.setForeground(Color.LIGHT_GRAY);
		txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFecha.setColumns(10);
		txtFecha.setBackground(Color.WHITE);
		txtFecha.setBounds(723, 497, 224, 30);
		//------------------------------------------------------------------------------------------------------
		//btnRegistrarme REGISTRA AL USUARIO RECOGIENDO LOS PARÁMETROS ANTERIORES.
		//------------------------------------------------------------------------------------------------------
		String ncuenta="^ES\\d+$";
		String tlfnRegexp="^[6]\\d{8}$";
		//COMPRUEBA QUE TENGA CUALQUIER CARÁCTER ANTES DEL "@"", PERO NO PUEDE EMPEZAR POR UN NÚMERO, NO PERMITE CARACTERES ESPECIALES, SALVO PUNTOS Y GUIÓN BAJO, DESPUES DEL "@"", SOLO PERMITE GMAIL O HOTMAIL .COM/ES
		String emailRegexp="^[a-zA-Z][a-zA-Z0-9._]*(?<!\\.)@(GMAIL|HOTMAIL)\\.(COM|ES)$"; 
		//COMPRUEBA QUE TENGA MAYÚSCULAS, MINÚSCULAS, LETRAS, NÚMEROS Y CARACTERES ESPECIALES AL MENOS UNO, MÁS O IGUAL A 8 CARACTERES Y MENOS O IGUAL A 60
		String passwdRegexp="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^\\w\\s]).{8,60}$";
		btnRegistrarme = new JButton("REGISTRARME");
		btnRegistrarme.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			//CUANDO PULSAS
			public void mouseClicked(MouseEvent e) {
				texto="";
				verificar_datos=0;
				String fechaParaBD = null;
				if(txtIntroduceTuNombre.getText().toUpperCase().length()<31 && !txtIntroduceTuNombre.getText().equalsIgnoreCase("Introduce tu nombre")) {
					System.out.println("Nombre Correcto");
					verificar_datos+=1;
				}
				else {
					texto+="Nombre, ";
				}
				if(text_IntroduceApellidos_1.getText().toUpperCase().length()<31 && !text_IntroduceApellidos_1.getText().equalsIgnoreCase("Introduce tus apellidos")) {
					System.out.println("Apellidos Correctos");
					verificar_datos+=1;
				}
				else {
					texto+="Apellidos, ";
				}
				if(Pattern.matches(tlfnRegexp, txtIntroduceElNtlf.getText().toUpperCase())) {
					System.out.println("Numero De Tlf Correcto");
					verificar_datos+=1;
				}
				else {
					texto+="Número de Teléfono, ";
				}
				if(Pattern.matches(emailRegexp, txtIntroduceTusEmail_1.getText().toUpperCase()) && txtIntroduceTusEmail_1.getText().length()<46) {
					System.out.println("Email correcto");
					verificar_datos+=1;
				}
				else {
					texto+="Email, ";
				}
				if(Pattern.matches(emailRegexp, txt_confirmaEmail.getText().toUpperCase()) && txt_confirmaEmail.getText().length()<46 && txtIntroduceTusEmail_1.getText().toUpperCase().equals( txt_confirmaEmail.getText().toUpperCase())) {
					System.out.println("Confirmar Email correcto");
					verificar_datos+=1;
				}
				else {
					texto+="Confirmar Email, ";
				}
				if(Pattern.matches(passwdRegexp, passwordField.getText())) {
					System.out.println("Contraseña correcta");
					verificar_datos+=1;
				}
				else {
					texto+="Contraseña, ";
				}
				if(Pattern.matches(ncuenta, textNCuenta.getText().toUpperCase()) && textNCuenta.getText().toUpperCase().length()==24) {
					System.out.println("Número de cuenta Correcto");
					verificar_datos+=1;
				}
				else {
					texto+="Número de cuenta, ";
				}
				if(txtFecha.getText().length()==7) {
					// Obtener la fecha actual
					LocalDate fechaActual = LocalDate.now();
					// Obtener la fecha de caducidad de la tarjeta de crédito
					String fechaCaducidadTexto = txtFecha.getText();
					// Agregar "01/" al principio para insertar en la base de datos
					fechaParaBD = "01/" + fechaCaducidadTexto;
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate fechaCaducidad = LocalDate.parse(fechaParaBD, formatter);
					// Verificar si la tarjeta está caducada o no
					if (fechaCaducidad.isBefore(fechaActual)) {
						texto+="Tarjeta Caducada, ";
					} else {
						System.out.println("La tarjeta está vigente");
						verificar_datos+=1;
					}
					// Imprimir la fecha formateada para la base de datos
					System.out.println("Fecha para insertar en la base de datos: " + fechaParaBD);
				}
				else {
					texto+="Fecha Invalida, ";
				}
				System.out.println(verificar_datos);
				if (verificar_datos==8) {
					passwd = passwordField.getText();
					correo = txt_confirmaEmail.getText().toUpperCase();
					nombre = txtIntroduceTuNombre.getText();
					apellidos = text_IntroduceApellidos_1.getText();
					calle = textCalle.getText();
					num_telefono = txtIntroduceElNtlf.getText();
					num_tarjeta = textNCuenta.getText();
					fecha_caducidad = fechaParaBD;
					tipo_tarjeta =ComboBoxTipo.getSelectedItem().toString();
					System.out.println(passwd);
					Seleccion_Membresia secMebresias = new Seleccion_Membresia();
					secMebresias.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "ERROR. Datos incorrectos verifique estos datos por favor: "+texto);
				}
			}
		});
		btnRegistrarme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarme.setBackground(new Color(255, 255, 255));
		btnRegistrarme.setBounds(865, 551, 128, 30);
		// ------------------------------------------------------------------------------------------------------
		// btnInicio_Sesion MANDA AL USUARIO A LA PÁGINA INICIO DE SESIÓN.
		// ------------------------------------------------------------------------------------------------------
		btnInicio_Sesion = new JButton("INICIO SESIÓN");
		btnInicio_Sesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inicio_Sesion inicioSesion = new Inicio_Sesion();
				inicioSesion.setVisible(true);
				dispose();
			}
		});
		btnInicio_Sesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicio_Sesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInicio_Sesion.setBackground(Color.WHITE);
		btnInicio_Sesion.setBounds(1006, 551, 128, 30);
		// ------------------------------------------------------------------------------------------------------
		// textNCuenta TIENE EL TEXTO DEL NÚMERO DE CUENTA DE LA TARJETA DEL USUARIO.
		// ------------------------------------------------------------------------------------------------------
		textNCuenta = new JTextField();
		textNCuenta.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textNCuenta.getText().equalsIgnoreCase("Introduce el Nº de Cuenta")) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO DEL USUARIO SI LO HAN ESCRITO
					textNCuenta.setText("");
					textNCuenta.setForeground(Color.BLACK); // CAMBIO EL COLOR DE GRIS CLARO A NEGRO
					textNCuenta.setBackground(Color.WHITE); // SIGO CON EL FONDO BLANCO
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				// Restaurar el valor predeterminado del campo de contraseña si está vacío
				if (textNCuenta.getText().length() == 0) {
					textNCuenta.setForeground(new Color(192, 192, 192));
					textNCuenta.setText("Introduce el Nº de Cuenta");
					textNCuenta.setBackground(UIManager.getColor("TextField.background"));
				}
			}
		});
		textNCuenta.setText("Introduce el Nº de Cuenta");
		textNCuenta.setForeground(Color.LIGHT_GRAY);
		textNCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNCuenta.setColumns(10);
		textNCuenta.setBackground(Color.WHITE);
		textNCuenta.setBounds(723, 415, 224, 30);
		//------------------------------------------------------------------------------------------------------
		//lbl_Fecha TIENE EL TEXTO DE FECHA PARA QUE EL USUARIO INTRODUZCA LA FECHA DE CADUCIDAD.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_Fecha = new JLabel("FECHA");
		lbl_Fecha.setOpaque(true);
		lbl_Fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Fecha.setForeground(Color.BLACK);
		lbl_Fecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Fecha.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Fecha.setBackground(Color.WHITE);
		lbl_Fecha.setBounds(723, 456, 99, 30);
		//------------------------------------------------------------------------------------------------------
		//lbl_NCUENTA TIENE EL TEXTO PARA QUE EL USUARIO ESCRIBA EL NÚMERO DE CUENTA.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_NCUENTA = new JLabel("Nº Cuenta");
		lbl_NCUENTA.setOpaque(true);
		lbl_NCUENTA.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NCUENTA.setForeground(Color.BLACK);
		lbl_NCUENTA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_NCUENTA.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_NCUENTA.setBackground(Color.WHITE);
		lbl_NCUENTA.setBounds(723, 372, 112, 30);
		//------------------------------------------------------------------------------------------------------
		//lbl_Tipo TIENE EL TEXTO PARA QUE EL USUARIO SELECCIONE EL TIPO DE PAGO.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_Tipo = new JLabel("TIPO");
		lbl_Tipo.setBounds(723, 290, 86, 30);
		lbl_Tipo.setOpaque(true);
		lbl_Tipo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Tipo.setForeground(Color.BLACK);
		lbl_Tipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Tipo.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Tipo.setBackground(Color.WHITE);
		//------------------------------------------------------------------------------------------------------
		//lbl_DatosBancarios TIENE EL TEXTO DE DATOS BANCARIOS.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_DatosBancarios = new JLabel("DATOS BANCARIOS");
		lbl_DatosBancarios.setBounds(723, 249, 213, 30);
		lbl_DatosBancarios.setOpaque(true);
		lbl_DatosBancarios.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_DatosBancarios.setForeground(Color.BLACK);
		lbl_DatosBancarios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_DatosBancarios.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_DatosBancarios.setBackground(Color.WHITE);
		//------------------------------------------------------------------------------------------------------
		//passwordField TIENE EL TEXTO DE LA CONTRASEÑA DEL USUARIO.
		//------------------------------------------------------------------------------------------------------
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(passwordField.getText().equalsIgnoreCase("*******************")) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO DEL USUARIO SI LO HAN ESCRITO
					passwordField.setText("");
					passwordField.setForeground(Color.BLACK); // CAMBIO EL COLOR DE GRIS CLARO A NEGRO
					passwordField.setBackground(Color.WHITE); // SIGO CON EL FONDO BLANCO
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				// Restaurar el valor predeterminado del campo de contraseña si está vacío
				if (passwordField.getPassword().length == 0) {
					passwordField.setForeground(new Color(192, 192, 192));
					passwordField.setText("*******************");
					passwordField.setBackground(UIManager.getColor("TextField.background"));
				}
			}
		});
		passwordField.setForeground(new Color(192, 192, 192));
		passwordField.setText("*******************");
		passwordField.setBounds(59, 498, 490, 30);
		//------------------------------------------------------------------------------------------------------
		//txt_confirmaEmail TIENE EL TEXTO DE LA CONFIRMACIÓN DE EMAIL.
		//------------------------------------------------------------------------------------------------------
		txt_confirmaEmail.setText("Introduce tu email");
		txt_confirmaEmail.setForeground(Color.LIGHT_GRAY);
		txt_confirmaEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_confirmaEmail.setColumns(10);
		txt_confirmaEmail.setBackground(Color.WHITE);
		txt_confirmaEmail.setBounds(59, 414, 490, 30);
		//------------------------------------------------------------------------------------------------------
		//lbl_Contraseña1 TIENE EL TEXTO DE INTRODUCE LA CONTRASEÑA.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_Contraseña1 = new JLabel("CONTRASEÑA MAX 60 CARACTERES");
		lbl_Contraseña1.setOpaque(true);
		lbl_Contraseña1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Contraseña1.setForeground(Color.BLACK);
		lbl_Contraseña1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Contraseña1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Contraseña1.setBackground(Color.WHITE);
		lbl_Contraseña1.setBounds(59, 455, 490, 32);
		//------------------------------------------------------------------------------------------------------
		//txt_confirmaEmail TIENE EL TEXTO DE LA CONFIRMACIÓN DE EMAIL.
		//------------------------------------------------------------------------------------------------------
		JTextField txtConfirmaElEmail = new JTextField(); // ACCIÓN CUANDO PULSAS PARA ESCRIBIR TU USUARIO
		txtConfirmaElEmail.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtConfirmaElEmail.getText().equalsIgnoreCase("Confirma el email")) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO DEL USUARIO SI LO HAN ESCRITO
					txtConfirmaElEmail.setText("");
					txtConfirmaElEmail.setForeground(Color.BLACK); // CAMBIO EL COLOR DE GRIS CLARO A NEGRO
					txtConfirmaElEmail.setBackground(Color.WHITE); // SIGO CON EL FONDO BLANCO
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				// Restaurar el valor predeterminado del campo de contraseña si está vacío
				if (txtConfirmaElEmail.getText().length() == 0) {
					txtConfirmaElEmail.setForeground(new Color(192, 192, 192));
					txtConfirmaElEmail.setText("Confirma el email");
					txtConfirmaElEmail.setBackground(UIManager.getColor("TextField.background"));
				}
			}
		});
		JLabel lbl_confirmacionEmail = new JLabel("CONFIRMACION EMAIL");
		lbl_confirmacionEmail.setOpaque(true);
		lbl_confirmacionEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_confirmacionEmail.setForeground(Color.BLACK);
		lbl_confirmacionEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_confirmacionEmail.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_confirmacionEmail.setBackground(Color.WHITE);
		lbl_confirmacionEmail.setBounds(59, 371, 224, 32);
		//------------------------------------------------------------------------------------------------------
		//lbl_Email TIENE EL TEXTO DE EMAIL.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_Email = new JLabel("EMAIL");
		lbl_Email.setOpaque(true);
		lbl_Email.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Email.setForeground(Color.BLACK);
		lbl_Email.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Email.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Email.setBackground(Color.WHITE);
		lbl_Email.setBounds(59, 290, 128, 32);
		//------------------------------------------------------------------------------------------------------
		//txtIntroduceTusEmail_1 TIENE EL TEXTO DEL EMAIL DEL USUARIO.
		//------------------------------------------------------------------------------------------------------
		txtIntroduceTusEmail_1 = new JTextField(); // ACCIÓN CUANDO PULSAS PARA ESCRIBIR TU USUARIO
		txtIntroduceTusEmail_1.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtIntroduceTusEmail_1.getText().equalsIgnoreCase("Introduce tu email")) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO DEL USUARIO SI LO HAN ESCRITO
					txtIntroduceTusEmail_1.setText("");
					txtIntroduceTusEmail_1.setForeground(Color.BLACK); // CAMBIO EL COLOR DE GRIS CLARO A NEGRO
					txtIntroduceTusEmail_1.setBackground(Color.WHITE); // SIGO CON EL FONDO BLANCO
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				// Restaurar el valor predeterminado del campo de contraseña si está vacío
				if (txtIntroduceTusEmail_1.getText().length() == 0) {
					txtIntroduceTusEmail_1.setForeground(new Color(192, 192, 192));
					txtIntroduceTusEmail_1.setText("Introduce tu email");
					txtIntroduceTusEmail_1.setBackground(UIManager.getColor("TextField.background"));
				}
			}
		});
		txtIntroduceTusEmail_1.setText("Introduce tu email");
		txtIntroduceTusEmail_1.setForeground(Color.LIGHT_GRAY);
		txtIntroduceTusEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIntroduceTusEmail_1.setColumns(10);
		txtIntroduceTusEmail_1.setBackground(Color.WHITE);
		txtIntroduceTusEmail_1.setBounds(59, 333, 490, 30);
		//------------------------------------------------------------------------------------------------------
		//lbl_Tlf TIENE EL TEXTO DE TLF PARA INTRODUCIR EL TELÉFONO.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_Tlf = new JLabel("TLF");
		lbl_Tlf.setOpaque(true);
		lbl_Tlf.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Tlf.setForeground(Color.BLACK);
		lbl_Tlf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Tlf.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Tlf.setBackground(Color.WHITE);
		lbl_Tlf.setBounds(219, 292, 64, 30);
		//------------------------------------------------------------------------------------------------------
		//text_IntroduceApellidos_1 TIENE EL TEXTO DE LOS APELLIDOS DEL USUARIO.
		//------------------------------------------------------------------------------------------------------
		text_IntroduceApellidos_1.setFont(new Font("Tahoma", Font.PLAIN, 14)); // TIPO DE TEXTO,LETRA, TAMAÑO...
		text_IntroduceApellidos_1.setForeground(Color.LIGHT_GRAY); //COLOR DE LA LETRA
		text_IntroduceApellidos_1.setText("Introduce tus apellidos"); // TEXTO INICIAL DE EJEMPLO
		text_IntroduceApellidos_1.setBackground(Color.WHITE); // COLOR DEL FONDO
		text_IntroduceApellidos_1.setBounds(325, 239, 224, 30); //TAMAÑO DEL CUADRO
		text_IntroduceApellidos_1.setColumns(10);
		//------------------------------------------------------------------------------------------------------
		//txtIntroduceTuNombre TIENE EL TEXTO DEL NOMBRE DEL USUARIO.
		//------------------------------------------------------------------------------------------------------
		txtIntroduceTuNombre.setFont(new Font("Tahoma", Font.PLAIN, 14)); // TIPO DE TEXTO,LETRA, TAMAÑO...
		txtIntroduceTuNombre.setForeground(Color.LIGHT_GRAY); //COLOR DE LA LETRA
		txtIntroduceTuNombre.setText("Introduce tu nombre"); // TEXTO INICIAL DE EJEMPLO
		txtIntroduceTuNombre.setBackground(Color.WHITE); // COLOR DEL FONDO
		txtIntroduceTuNombre.setBounds(59, 239, 224, 30); //TAMAÑO DEL CUADRO
		txtIntroduceTuNombre.setColumns(10);
		//------------------------------------------------------------------------------------------------------
		//ComboBoxTipo TIENE LAS OPCIONES DE TIPOS DE PAGO QUE PERMITE.
		//------------------------------------------------------------------------------------------------------
		ComboBoxTipo = new JComboBox<String>();
		ComboBoxTipo.setBounds(723, 331, 224, 30);
		ComboBoxTipo.setBorder(new CompoundBorder());
		ComboBoxTipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ComboBoxTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ComboBoxTipo.setOpaque(true);
		ComboBoxTipo.setBackground(new Color(255, 255, 255));
		ComboBoxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Tarjeta de credito", "Tarjeta de debito", "MASTERCAD","PayPal"}));
		//------------------------------------------------------------------------------------------------------
		//lbl_Apellido TIENE EL TÍTULO DE INTRODUCIR EL APELLIDO.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_Apellido = new JLabel("Apellidos");
		lbl_Apellido.setOpaque(true);
		lbl_Apellido.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Apellido.setForeground(Color.BLACK);
		lbl_Apellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Apellido.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Apellido.setBackground(Color.WHITE);
		lbl_Apellido.setBounds(325, 196, 112, 32);
		//------------------------------------------------------------------------------------------------------
		//lbl_AccesoAMiembros TIENE EL TÍTULO DE ACCESO A MIEMBROS.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_AccesoAMiembros = new JLabel("ACCESO A MIEMBROS");
		lbl_AccesoAMiembros.setForeground(new Color(0, 0, 0)); //EL COLOR DEL TEXTO
		lbl_AccesoAMiembros.setBorder(new LineBorder(Color.LIGHT_GRAY)); // EL COLOR DEL BORDE DEL CUADRO
		lbl_AccesoAMiembros.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		lbl_AccesoAMiembros.setHorizontalAlignment(SwingConstants.CENTER); //CENTRAR EL TEXTO DEL CUADRO
		lbl_AccesoAMiembros.setOpaque(true); // LÍNEA OBLIGATORIA PARA QUE EL FONDO TENGA COLOR SÓLIDO
		lbl_AccesoAMiembros.setBackground(Color.WHITE);// COLOR DE FONDO
		lbl_AccesoAMiembros.setBounds(59, 59, 232, 32);//TAMAÑO DEL CUADRO
		// ------------------------------------------------------------------------------------------------------
		// lbl_REGISTRO TIENE EL TÍTULO DE REGISTRO PARA SER MIEMBROS.(ESTÉTICO)
		// ------------------------------------------------------------------------------------------------------
		JLabel lbl_REGISTRO = new JLabel("REGISTRO PARA SER MIEMBRO:");
		lbl_REGISTRO.setOpaque(true);
		lbl_REGISTRO.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_REGISTRO.setForeground(Color.BLACK);
		lbl_REGISTRO.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_REGISTRO.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_REGISTRO.setBackground(Color.WHITE);
		lbl_REGISTRO.setBounds(59, 143, 431, 42);
		//------------------------------------------------------------------------------------------------------
		//lbl_nom TIENE EL TÍTULO DE NOMBRE.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_nom = new JLabel("NOMBRE");
		lbl_nom.setForeground(new Color(0, 0, 0)); //EL COLOR DEL TEXTO
		lbl_nom.setBorder(new LineBorder(Color.LIGHT_GRAY)); // EL COLOR DEL BORDE DEL CUADRO
		lbl_nom.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		lbl_nom.setHorizontalAlignment(SwingConstants.CENTER); //CENTRAR EL TEXTO DEL CUADRO
		lbl_nom.setOpaque(true); // LÍNEA OBLIGATORIA PARA QUE EL FONDO TENGA COLOR SÓLIDO
		lbl_nom.setBackground(Color.WHITE); // EL COLOR DEL FONDO
		lbl_nom.setBounds(59, 196, 112, 32);//TAMAÑO DEL CUADRO
		//------------------------------------------------------------------------------------------------------
		//lbl_Calle TIENE EL TÍTULO DE LA CALLE.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_Calle = new JLabel("CALLE");
		lbl_Calle.setOpaque(true);
		lbl_Calle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Calle.setForeground(Color.BLACK);
		lbl_Calle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Calle.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Calle.setBackground(Color.WHITE);
		lbl_Calle.setBounds(723, 164, 140, 32);
		//------------------------------------------------------------------------------------------------------
		//textCalle TIENE EL TEXTO DE LA CALLE DONDE VIVE EL USUARIO.
		//------------------------------------------------------------------------------------------------------
		textCalle = new JTextField();
		textCalle.setText("Introduce tu calle");
		textCalle.setForeground(Color.LIGHT_GRAY);
		textCalle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCalle.setColumns(10);
		textCalle.setBackground(Color.WHITE);
		textCalle.setBounds(723, 207, 360, 30);
		textCalle.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textCalle.getText().equalsIgnoreCase("Introduce tu calle")) { //CONDICIÓN PARA QUE SE MANTENGA EL TEXTO DEL USUARIO SI LO HAN ESCRITO
					textCalle.setText("");
					textCalle.setForeground(Color.BLACK); // CAMBIO EL COLOR DE GRIS CLARO A NEGRO
					textCalle.setBackground(Color.WHITE); // SIGO CON EL FONDO BLANCO
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				// Restaurar el valor predeterminado del campo de contraseña si está vacío
				if (textCalle.getText().length() == 0) {
					textCalle.setForeground(new Color(192, 192, 192));
					textCalle.setText("Introduce tu calle");
					textCalle.setBackground(UIManager.getColor("TextField.background"));
				}
			}
		});
		//------------------------------------------------------------------------------------------------------
		//lbl_Logo TIENE EL LOGO DE LA EMPRESA.(ESTÉTICO)
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_Logo = new JLabel();
		lbl_Logo.setBounds(744, 43, 390, 110); //TAMAÑO DLE CUADRO
		ImageIcon logo = new ImageIcon(getClass().getResource("/Trilogy_imagenes/LogoTrilogy.jpg")); //DIRECCIÓN DE LA IMAGEN QUE QUIERO AJUSTAR		
		ImageIcon imglogo = new ImageIcon(logo.getImage().getScaledInstance(lbl_Logo.getWidth(), lbl_Logo.getHeight(), Image.SCALE_AREA_AVERAGING)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMÁTICAMENTE LA IMAGEN AL LABEL
		lbl_Logo.setIcon(imglogo);
		//------------------------------------------------------------------------------------------------------
		//lblBordeSuperior TIENE EL BORDE DE LA PARTE SUPERIOR.
		//------------------------------------------------------------------------------------------------------
		JLabel lblBordeSuperior = new JLabel();
		lblBordeSuperior.setOpaque(true); // LÍNEA OBLIGATORIA PARA QUE EL FONDO TENGA COLOR SÓLIDO
		lblBordeSuperior.setBackground(new Color(153, 255, 153));
		lblBordeSuperior.setBounds(0, 49, 1164, 83);
		//------------------------------------------------------------------------------------------------------
		//lbl_Fondo TIENE LA IMAGEN DE FONDO DE LA PÁGINA.
		//------------------------------------------------------------------------------------------------------
		JLabel lbl_Fondo = new JLabel();
		lbl_Fondo.setBackground(new Color(255, 255, 255));
		lbl_Fondo.setToolTipText("");
		lbl_Fondo.setBounds(0, 0, 1164, 605);//TAMAÑO DEL CUADRO
		ImageIcon fondo1 = new ImageIcon(getClass().getResource("/Trilogy_imagenes/Fondo_Formulario.png")); // DIRECCIÓN DE LA IMAGEN QUE QUIERO AJUSTAR
		ImageIcon imgfondo = new ImageIcon(fondo1.getImage().getScaledInstance(lbl_Fondo.getWidth(), lbl_Fondo.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMÁTICAMENTE LA IMAGEN AL LABEL
		lbl_Fondo.setIcon(imgfondo);
		//------------------------------------------------------------------------------------------------------
		//JERARQUÍA DEL Panel
		//------------------------------------------------------------------------------------------------------
		contentPane.add(ComboBoxTipo);
		contentPane.add(textCalle);
		contentPane.add(lbl_Calle);
		getContentPane().add(lbl_PuertaSalida_1);
		contentPane.add(btnRegistrarme);
		contentPane.add(btnInicio_Sesion);
		contentPane.add(txtFecha);
		contentPane.add(lbl_Fecha);
		contentPane.add(textNCuenta);
		contentPane.add(lbl_NCUENTA);
		contentPane.add(lbl_Tipo);
		contentPane.add(lbl_DatosBancarios);
		contentPane.add(passwordField);
		contentPane.add(txt_confirmaEmail);
		contentPane.add(txtIntroduceElNtlf);
		contentPane.add(lbl_Contraseña1);
		contentPane.add(lbl_confirmacionEmail);
		contentPane.add(lbl_Email);
		contentPane.add(txtIntroduceTusEmail_1);
		contentPane.add(lbl_Tlf);
		getContentPane().add(text_IntroduceApellidos_1);
		getContentPane().add(txtIntroduceTuNombre);
		contentPane.add(lbl_Apellido);
		contentPane.add(lbl_AccesoAMiembros);
		contentPane.add(lbl_REGISTRO);
		getContentPane().add(lbl_Logo);
		getContentPane().add(lbl_nom);
		getContentPane().add(lblBordeSuperior);	
		getContentPane().add(lbl_Fondo, BorderLayout.SOUTH);
	}
}
package cancelacion_cuenta;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
public class CancelacionCod extends JFrame {
	/**
	 * @param private JPanel contentPane 
	 * Es el panel principal donde contiene todos los atributos.
	 * @param private JPanel panelContenedor 
	 * Es el panel que contiene todos los atributos que hacen posible la visualización de la página.
	 * @param private JLabel lbl_Texto_AgradecimientoUsuario
	 * Texto de agradecimiento cuando el usuario cancela la suscripción.
	 * @param private JLabel lbl_Fecha_Facturacion_Usuario
	 *  Texto que cambia cada vez que se introduzca un usuario y muestre la fecha de su próxima facturación.
	 * @param private JLabel lbl_Fecha_Proxima_Facturacion
	 * Texto que indica el campo de la próxima facturación.
	 * @param private JButton btnConfirm
	 * Botón que cuando se pulsa elimina todos los datos del usuario de la BBDD.
	 * @param private JButton btnCancelarMembresía
	 * Botón de seguridad que pregunta al usuario la confirmacíon de la cancelación.
	 * @param private JButton btnCambiarMembresía
	 * Botón que al presionarlo te cambia de membresía y te indica el nuevo precio de esta.
	 * @param private JLabel lbl_TuMembresiaTitulo
	 * Indica la membresía en la que se encuentra el usuario.
	 * @param private JLabel lbl_Logo
	 * Imagen de nuestro logo (Estético).
	 * @param private JLabel lblBordeSuperior
	 * Barra decorativa (Estético).
	 * @param private JLabel lbl_Fondo
	 * Label que contiene la imagen del fondo (Estético).
	 * @param private JButton btnCerrarSesion
	 * Botón que al presionarlo cierra la sesión del usuario.
	 * @param private JComboBox<String> comboBox_Tipo_de_membreisa1
	 * Selección de los tipos de membresía disponibles a elegir.
	 * @author TRILOGY. Miembros: Adrián Leal Vacas, Gonzalo Amo Cano y Raúl Senso Montojo.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelContenedor;
	private JLabel lbl_Texto_AgradecimientoUsuario;
	private JLabel lbl_Fecha_Facturacion_Usuario;
	private JLabel lbl_Fecha_Proxima_Facturacion;
	private JButton btnConfirm;
	private JButton btnCancelarMembresía;
	private JButton btnCambiarMembresía;
	private JLabel lbl_TuMembresiaTitulo;
	private JLabel lbl_Logo;
	private JLabel lblBordeSuperior;
	private JLabel lbl_Fondo;
	private JButton btnCerrarSesion;
	private JComboBox<String> comboBox_Tipo_de_membreisa1;
	// ATRIBUTOS Y OBJETOS NECESARIOS PARA AL CONEXIÓN, LA BASE DE DATOS Y LA REALIZACIÓN DE UN CONSULTA BÁSICA
	private static String bd="XE"; // NOMBRE DE LA BASE DE DATOS POR DEFECTO SIEMPRE, DEJAR EL "XE"
	private static String login="TRILOGY"; // USUARIO DE LA BBDD
	private static String password="TRILOGY"; // CONTRASEÑA DE LA BBDD
	// RUTA DE SERVICIO
	private static String url="jdbc:oracle:thin:@localhost:1521:"+bd;
	// PONEMOS LOS OBJETOS A NULL Y SIN INSTANCIAR
	static Connection connection=null; // CONEXIÓN A LA BASE DE DATOS
	static Statement st; // PARA REALIZAR SQL ESTÁTICAS (HAY QUE ENLAZARLA SIEMPRE CON EL "Connection" SINO, NO FUNCIONA)
	static ResultSet rs; // PARA REALIZAR LA CONSULTA IGUAL QUE EN SQL DEVELOPER
	// ------------------------------------------------------------------------------------------------------
	// MÉTODOS
	// ------------------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------------------
	// MÉTODO PARA CONECTAR A LA BASE DE DATOS
	// ------------------------------------------------------------------------------------------------------
	/**
	 * El método conectar() realiza una conexión a la base de datos.
	 */
	public static void conectar() throws Exception{
		// DRIVER PARA ORACLE
		Class.forName("oracle.jdbc.driver.OracleDriver"); // EL DRIVER DEL JDBC SIEMPRE ES EL MISMO QUE ESTA PUESTO
		connection=DriverManager.getConnection(url,login,password); // NOS CONECTAMOS A LA BASE DE DATOS CON LA URL Y LOGIN Y EL PASSWORD QUE PREVIAMENTE PUSIMOS EN LOS ATRIBUTOS
	}
	// ------------------------------------------------------------------------------------------------------
	// MÉTODO PARA CERRAR LA BASE DE DATOS
	// ------------------------------------------------------------------------------------------------------
	/**
	 * El método cerrar() cierra la base de datos.
	 */
	public static void cerrar() throws SQLException{
		// SIEMPRE EN EL MISMO ORDEN, SINO, DA FALLO
		if (rs!=null) rs.close(); // CERRAMOS EL RS SI ES DIFERENTE AL NULL (FUNCIONANDO)
		if (st!=null) st.close(); // CERRAMOS EL ST SI ES DIFERENTE AL NULL (FUNCIONANDO)
		if (connection!=null) connection.close(); // CERRAMOS EL connection SI ES DIFERENTE AL NULL (FUNCIONANDO)
	}
	public static String fecha(String correos) throws Exception{
		conectar();
		// GUARDAMOS EN UNA VARIABLE EL VALOR DEL TEXTO DE txt_Correo
		String fecha=null;
		// COMPROBAMOS CON UN SELECT SI EXISTE EL CORREO EN LA BASE DE DATOS
		// NOS CONECTAMOS A LA BASE DE DATOS
		st=connection.createStatement();
		// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE correos) (SIRVE PARA CREAR LA SENTENCIA SQL)
		PreparedStatement statement = connection.prepareStatement("select FECHA_FACTURACION from USUARIOS WHERE CORREO = ?");
		// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE correos (1 ES EL NÚMERO DE ? Y correos EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
		statement.setString(1, correos.toUpperCase());
		// EJECUTAMOS LA QUERY ANTERIOR
		rs = statement.executeQuery();
		// PARA RECORER LAS LÍNEAS QUE NOS SALGA EN LA SENTENCIA QUERY ANTERIOR
		// MIENTRAS QUE HAYA SIGUIENTE
		while (rs.next()) {
			// ALMACENA EL DATO DE LA COLUMNA NOMBRE EN LA VARIABLE nombre
			fecha = rs.getString("FECHA_FACTURACION");
		}
		cerrar();
		return fecha;
	}
	/**
	 * El constructor llama a los atributos y métodos necesarios para el funcionamiento de la clase CancelacionCod.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelacionCod frame = new CancelacionCod();
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
	 * El constructor llama a los atributos y métodos necesarios para el funcionamiento de la clase CancelacionCod.
	 * @throws Exception 
	 */
	public CancelacionCod() throws Exception {
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setType(Type.UTILITY);
		setResizable(false);//QUE NO PUEDA MODIFICARSE EL TAMAÑO DE LA VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 703);
		contentPane.setBackground(new Color(0,0,0,10));// ESTABLECER EL FONDO CON LA TRANSPARENCIA
		contentPane.setLayout(null);
		// ------------------------------------------------------------------------------------------------------
		// PANEL DEL ADMINISTRADOR
		// ------------------------------------------------------------------------------------------------------
		panelContenedor = new JPanel();
		panelContenedor.setBounds(0, 0, 961, 664);
		panelContenedor.setLayout(null);
		//--------------------------------------------------------------------------------------------------------
		// TEXTO AGRADECIMIENTO AL USUARIO POR SU CUENTA
		//--------------------------------------------------------------------------------------------------------	
		lbl_Texto_AgradecimientoUsuario = new JLabel
				("<html>Eres parte esencial de Trilogy; por eso, nos mantenemos pendientes<br>" 
						+ "  de lo que necesitasy por eso nos actualizamos continuamente <br>" 
						+ "<br>Contamos contigo como prioridad número 1<br><br>" 
						+ "«¡Gracias por confiar en nosotros!»" 
						, SwingConstants.CENTER);
		lbl_Texto_AgradecimientoUsuario.setOpaque(true);
		lbl_Texto_AgradecimientoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Texto_AgradecimientoUsuario.setForeground(Color.BLACK);
		lbl_Texto_AgradecimientoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Texto_AgradecimientoUsuario.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Texto_AgradecimientoUsuario.setBackground(Color.WHITE);
		lbl_Texto_AgradecimientoUsuario.setBounds(84, 426, 526, 132);
		//--------------------------------------------------------------------------------------------------------	
		// TEXTO QUE CAMBIA CADA VEZ QUE SE INTRODUZCA UN USUARIO Y MUESTRE LA FECHA DE SU PRÓXIMA FACTURACIÓN
		//--------------------------------------------------------------------------------------------------------	
		lbl_Fecha_Facturacion_Usuario = new JLabel("");
		lbl_Fecha_Facturacion_Usuario.setOpaque(true);
		lbl_Fecha_Facturacion_Usuario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Fecha_Facturacion_Usuario.setForeground(Color.BLACK);
		lbl_Fecha_Facturacion_Usuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_Fecha_Facturacion_Usuario.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Fecha_Facturacion_Usuario.setBackground(Color.WHITE);
		lbl_Fecha_Facturacion_Usuario.setBounds(84, 371, 324, 30);
		lbl_Fecha_Facturacion_Usuario.setText(fecha(Inicio_Sesion.correo_usuario)+" se renueva mensualmente");
		//--------------------------------------------------------------------------------------------------------
		// TEXTO DE FECHA PRÓXIMA FACTURACIÓN
		//--------------------------------------------------------------------------------------------------------	
		lbl_Fecha_Proxima_Facturacion = new JLabel("FECHA DE LA PRÓXIMA FACTURACIÓN");
		lbl_Fecha_Proxima_Facturacion.setOpaque(true);
		lbl_Fecha_Proxima_Facturacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Fecha_Proxima_Facturacion.setForeground(Color.BLACK);
		lbl_Fecha_Proxima_Facturacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Fecha_Proxima_Facturacion.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lbl_Fecha_Proxima_Facturacion.setBackground(Color.WHITE);
		lbl_Fecha_Proxima_Facturacion.setBounds(84, 318, 324, 42);
		//------------------------------------------------------------------------------------------------------
		// BOTÓN DE CONFIRMAR
		//--------------------------------------------------------------------------------------------------------	
		btnConfirm = new JButton("CONFIRMAR");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					conectar();
					lbl_Texto_AgradecimientoUsuario.setText("Gracias por haber formado parte de Trilogy, estaremos esperando tu regreso");
					try {
						String correo = Inicio_Sesion.correo_usuario.toUpperCase();
						PreparedStatement selectStatement = connection.prepareStatement("SELECT ID_USUARIO FROM USUARIOS WHERE UPPER(CORREO) = UPPER(?)");
						selectStatement.setString(1, correo);
						ResultSet resultSet = selectStatement.executeQuery();
						if (resultSet.next()) {
							int idUsuario = resultSet.getInt("ID_USUARIO");
							PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM CON_MEMBRESIAS WHERE ID_USUARIO = ?");
							deleteStatement.setInt(1, idUsuario);
							deleteStatement.executeUpdate();
							deleteStatement.close();
						}
						resultSet.close();
						selectStatement.close();
					} catch (SQLException e1) {
						cerrar();
						JOptionPane.showMessageDialog(null, "ERROR. No se ha realizado el eliminado del usuario. Perdone las molestias.");
					}
					try {
						String correo = Inicio_Sesion.correo_usuario.toUpperCase();
						PreparedStatement selectStatement = connection.prepareStatement("SELECT ID_USUARIO FROM USUARIOS WHERE UPPER(CORREO) = UPPER(?)");
						selectStatement.setString(1, correo);
						ResultSet resultSet = selectStatement.executeQuery();
						if (resultSet.next()) {
							int idUsuario = resultSet.getInt("ID_USUARIO");
							PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM ADMINISTRADORES WHERE ID_USUARIO = ?");
							deleteStatement.setInt(1, idUsuario);
							deleteStatement.executeUpdate();
							deleteStatement.close();
						}
						resultSet.close();
						selectStatement.close();
					} catch (SQLException e1) {
						cerrar();
						JOptionPane.showMessageDialog(null, "ERROR. No se ha realizado el eliminado del usuario. Perdone las molestias.");
					}
					try {
						String correo = Inicio_Sesion.correo_usuario.toUpperCase();
						PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM USUARIOS WHERE UPPER(CORREO) = UPPER(?)");
						deleteStatement.setString(1, correo);
						deleteStatement.executeUpdate();
						deleteStatement.close();
						JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO CORRECTAMENTE");
					} catch (SQLException e1) {
						cerrar();
						JOptionPane.showMessageDialog(null, "ERROR. No se ha realizado el eliminado del usuario. Perdone las molestias.");
					}
					cerrar();
					System.exit(0);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR. No se ha podido cerrar la base de datos. Perdone las molestias.");
				}
			}
		});
		btnConfirm.setVisible(false);
		btnConfirm.setForeground(new Color(0, 0, 0)); //COLOR DEL TEXTO
		btnConfirm.setBackground(new Color(204, 0, 0)); //COLOR DEL FONDO
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15)); //TIPO DE LETRA,TAMAÑO...
		btnConfirm.setBounds(137, 35, 1, -1);//TAMAÑO DEL BOTÓN
		//--------------------------------------------------------------------------------------------------------
		// BOTÓN DE CANCELAR MEMBRESÍA		
		//--------------------------------------------------------------------------------------------------------
		btnCancelarMembresía = new JButton("CANCELAR MEMBRESÍA");
		btnCancelarMembresía.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_Texto_AgradecimientoUsuario.setText("¿Estás seguro de que quieres cancelar tú membresía?");
				btnCancelarMembresía.setVisible(false);
				btnConfirm.setVisible(true);
				btnConfirm.setForeground(new Color(0, 0, 0)); //COLOR DEL TEXTO
				btnConfirm.setBackground(new Color(204, 0, 0)); //COLOR DEL FONDO
				btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15)); //TIPO DE LETRA,TAMAÑO...
				btnConfirm.setBounds(627, 489, 248, 57);//TAMAÑO DEL BOTÓN
			}
		});
		btnCancelarMembresía.setForeground(new Color(0, 0, 0)); //COLOR DEL TEXTO
		btnCancelarMembresía.setBackground(new Color(204, 0, 0)); //COLOR DEL FONDO
		btnCancelarMembresía.setFont(new Font("Tahoma", Font.PLAIN, 15)); //TIPO DE LETRA,TAMAÑO...
		btnCancelarMembresía.setBounds(627, 489, 248, 57);//TAMAÑO DEL BOTÓN
		//--------------------------------------------------------------------------------------------------------
		// BOTÓN DE CERRAR SESIÓN
		//--------------------------------------------------------------------------------------------------------
		btnCerrarSesion = new JButton("CERRAR SESIÓN");
		btnCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCerrarSesion.setForeground(new Color(0, 0, 0)); //COLOR DEL TEXTO
		btnCerrarSesion.setBackground(new Color(255, 255, 255)); //COLOR DEL FONDO
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 15)); //TIPO DE LETRA,TAMAÑO...
		btnCerrarSesion.setBounds(599, 251, 248, 57);//TAMAÑO DEL BOTÓN
		//--------------------------------------------------------------------------------------------------------		
		// BOTÓN DE CAMBIAR MEMBRESÍA	
		//--------------------------------------------------------------------------------------------------------
		btnCambiarMembresía = new JButton("CAMBIAR MEMBRESÍA");
		btnCambiarMembresía.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String precio;
				btnConfirm.setVisible(false);
				btnCancelarMembresía.setVisible(true);
				lbl_Texto_AgradecimientoUsuario.setText("<html>Eres parte esencial de Trilogy; por eso, nos mantenemos pendientes<br>" 
						+ "  de lo que necesitasy por eso nos actualizamos continuamente <br>" 
						+ "<br>Contamos contigo como prioridad número 1<br><br>" 
						+ "«¡Gracias por confiar en nosotros!»");
				int membresia_id=-1;
				// GUARDO EL VALOR DEL comboBox_Tipo_de_membreisa2 PARA LUEGO PODER COMPARARLO CON LA BASE DE DATOS PARA LA CONSULTA DE CAMBIAR MEMBRESÍA
				String tipo_de_membreisa=comboBox_Tipo_de_membreisa1.getSelectedItem().toString().toUpperCase();
				switch (tipo_de_membreisa) {
				case "CRISTAL_BASIC":
					membresia_id=1;
					precio="0.00€";
					break;
				case "ZAFIRO_STANDARD":
					membresia_id=2;
					precio="5.99€";
					break;
				case "RUBI_STANDARD":
					membresia_id=3;
					precio="5.99€";
					break;
				case "DIAMANTE_PREMIUM":
					membresia_id=4;
					precio="9.99€";
					break;
				default:
					membresia_id=1;
					precio="0.00€";
					break;
				}
				try {
					Connection conn = DriverManager.getConnection(url, login, password);
					String sql = "UPDATE CON_MEMBRESIAS SET ID_MEMBRESIAS = ? WHERE ID_USUARIO = (SELECT ID_USUARIO FROM USUARIOS WHERE UPPER(CORREO) = ?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, membresia_id);
					pstmt.setString(2, Inicio_Sesion.correo_usuario.toUpperCase());
					pstmt.executeUpdate();
					pstmt.close();
					conn.close();
					JOptionPane.showMessageDialog(null, " El usuario se ha actualizado correctamente, su membresía ahora es de  "+precio+". Por temas de seguridad se cerrará la aplicación. Perdone las molestias");
					System.exit(0);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCambiarMembresía.setForeground(new Color(0, 0, 0)); //COLOR DEL TEXTO
		btnCambiarMembresía.setBackground(new Color(255, 255, 255)); //COLOR DEL FONDO
		btnCambiarMembresía.setFont(new Font("Tahoma", Font.PLAIN, 15)); //TIPO DE LETRA,TAMAÑO...
		btnCambiarMembresía.setBounds(627, 421, 248, 57);//TAMAÑO DEL BOTÓN
		//---------------------------------------------------------------------------------------------------------
		// TEXTO DE  -- TU MEMEBRESÍA --
		//--------------------------------------------------------------------------------------------------------
		lbl_TuMembresiaTitulo = new JLabel("TU MEMBRESÍA");
		lbl_TuMembresiaTitulo.setForeground(new Color(0, 0, 0)); //EL COLOR DEL TEXTO
		lbl_TuMembresiaTitulo.setBorder(new LineBorder(Color.LIGHT_GRAY)); // EL COLOR DEL BORDE DEL CUADRO
		lbl_TuMembresiaTitulo.setFont(new Font("Tahoma", Font.BOLD, 14)); // TIPO DE LETRA,TAMAÑO...
		lbl_TuMembresiaTitulo.setHorizontalAlignment(SwingConstants.CENTER); //CENTRAR EL TEXTO DEL CUADRO
		lbl_TuMembresiaTitulo.setOpaque(true); // LÍNEA OBLIGATORIA PARA QUE EL FONDO TENGA COLOR SÓLIDO
		lbl_TuMembresiaTitulo.setBackground(Color.WHITE); // EL COLOR DEL FONDO
		lbl_TuMembresiaTitulo.setBounds(84, 212, 324, 42);
		//---------------------------------------------------------------------------------------------------------
		// SELECCIÓN  -- MEMEBRESÍA --
		//--------------------------------------------------------------------------------------------------------
		comboBox_Tipo_de_membreisa1 = new JComboBox<String>();
		comboBox_Tipo_de_membreisa1.setBounds(84, 265, 324, 42);
		comboBox_Tipo_de_membreisa1.setBorder(new CompoundBorder());
		comboBox_Tipo_de_membreisa1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_Tipo_de_membreisa1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox_Tipo_de_membreisa1.setOpaque(true);
		comboBox_Tipo_de_membreisa1.setBackground(new Color(255, 255, 255));
		comboBox_Tipo_de_membreisa1.setModel(new DefaultComboBoxModel<String>(new String[] {"Cristal_Basic", "Zafiro_Standard", "Rubi_Standard", "Diamante_Premium"}));
		//--------------------------------------------------------------------------------------------------------
		// LOGO TRILOGY
		//--------------------------------------------------------------------------------------------------------
		lbl_Logo = new JLabel();
		lbl_Logo.setBounds(280, 65, 382, 110); //TAMAÑO DEL CUADRO
		ImageIcon logo = new ImageIcon(getClass().getResource("/Trilogy_imagenes/LogoTrilogy.jpg")); //DIRECCIÓN DE LA IMAGEN QUE QUIERO AJUSTAR
		ImageIcon imglogo = new ImageIcon(logo.getImage().getScaledInstance(lbl_Logo.getWidth(), lbl_Logo.getHeight(), Image.SCALE_AREA_AVERAGING)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		lbl_Logo.setIcon(imglogo);
		//------------------------------------------------------------------------------------------------------------
		// BORDE SUPERIOR VERDE
		//--------------------------------------------------------------------------------------------------------
		lblBordeSuperior = new JLabel();
		lblBordeSuperior.setOpaque(true); // LÍNEA OBLIGATORIA PARA QUE EL FONDO TENGA COLOR SÓLIDO
		lblBordeSuperior.setBackground(new Color(153, 255, 153));
		lblBordeSuperior.setBounds(0, 0, 961, 132);
		//-------------------------------------------------------------------------------------------------------------
		// IMAGEN DE FONDO DE LA VENTANA
		//--------------------------------------------------------------------------------------------------------
		lbl_Fondo = new JLabel();
		lbl_Fondo.setToolTipText("");
		lbl_Fondo.setBounds(0, 0, 961, 664);//TAMAÑO DEL CUADRO
		ImageIcon fondo1 = new ImageIcon(getClass().getResource("/Trilogy_imagenes/Fondo_Formulario.png")); // DIRECCIÓN DE LA IMAGEN QUE QUIERO AJUSTAR
		ImageIcon imgfondo = new ImageIcon(fondo1.getImage().getScaledInstance(lbl_Fondo.getWidth(), lbl_Fondo.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		lbl_Fondo.setIcon(imgfondo);
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		// JERARQUÍA DEL PANEL PRINCIPAL
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		panelContenedor.add(comboBox_Tipo_de_membreisa1);
		panelContenedor.add(lbl_Texto_AgradecimientoUsuario);
		panelContenedor.add(lbl_Fecha_Facturacion_Usuario);
		panelContenedor.add(lbl_Fecha_Proxima_Facturacion);
		panelContenedor.add(btnConfirm);
		panelContenedor.add(btnCancelarMembresía);
		panelContenedor.add(btnCerrarSesion);
		panelContenedor.add(btnCambiarMembresía);
		panelContenedor.add(lbl_TuMembresiaTitulo);
		panelContenedor.add(lbl_Logo);
		panelContenedor.add(lblBordeSuperior);
		panelContenedor.add(lbl_Fondo);
		contentPane.add(panelContenedor);
	}
}
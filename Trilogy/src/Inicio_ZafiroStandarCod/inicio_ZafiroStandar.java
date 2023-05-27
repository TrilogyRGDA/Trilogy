package Inicio_ZafiroStandarCod;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import cat_audiovisual.CatalogoAudiovisual;
import seleccionCapSerie.SeleccionCapSerie;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * En la página de Inicio Zafiro Standar podrás consumir contenido audiovisual de series y con un botón de recarga cambiará el contenido audiovisual.
 * Esta página tiene dos versiones, ya que el panel de la izquierda se puede reducir de tamaño para una mejor visualización del contenido.
 * @param contentPane 
 * Contiene todos los atributos de la página.
 * @param panel_contenedor 
 * Contiene todos los atributos para poder intercambiar paneles sin complicación.
 * @param lblFondo_Rojo 
 * Tiene la imagen del fondo característico de series.(Estético).
 * @param lbl_LoMasNuevo 
 * Tiene el texto de -LO MÁS NUEVO-(Estético).
 * @param  lbl_TOP5
 * Tiene el texto de -TOP 5 ÚLTIMO MES-(Estético).
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
 * @param lbl_IMGSerie6 
 * Es un label con la función de pulsar y contiene la imagen de la serie que se va a reproducir.
 * @param lbl_IMGSerie7 
 * Es un label con la función de pulsar y contiene la imagen de la serie que se va a reproducir.
 * @param lbl_IMGSerie8 
 * Es un label con la función de pulsar y contiene la imagen de la serie que se va a reproducir.
 * @param lbl_IMGSerie9
 * Es un label con la función de pulsar y contiene la imagen de la serie que se va a reproducir.
 * @param lbl_IMGSerie10 
 * Es un label con la función de pulsar y contiene la imagen de la serie que se va a reproducir.
 * @param btn_Recarga1
 * Botón que cambia el catalogo audiovisual de las series de -LO MÁS NUEVO- para que puedas ver todo lo nuevo en series.
 * @author TRILOGY. Miembros: Adrián Leal Vacas, Gonzalo Amo Cano y Raúl Senso Montojo.
 */
public class inicio_ZafiroStandar extends JFrame {
	/**
	 * Es la versión número 1 de la página del contenido audiovisual del Inicio Zafiro Standar
	 */
	private static final long serialVersionUID = 1L;
	// ----------------------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------------------
	private JPanel contentPane;
	private JButton btn_Recarga1;
	private JLabel lbl_IMGSerie1;
	private JLabel lbl_IMGSerie2;
	private JLabel lbl_IMGSerie3;
	private JLabel lbl_IMGSerie4;
	private JLabel lbl_IMGSerie5;
	private JLabel lbl_IMGSerie6;
	private JLabel lbl_IMGSerie7;
	private JLabel lbl_IMGSerie8;
	private JLabel lbl_IMGSerie9;
	private JLabel lbl_IMGSerie10;
	private JPanel Panel_ZafiroStandar;
	private JLabel lbl_LoMasNuevo;
	private JLabel lbl_TOP5;
	public static String ruta_serie;
	public static int contador=0;
	public static int contadortemp=0;
	private static int num_serie=0;
	private static int num_serie_enlacep1=0;
	private static int num_serie_enlacep2=0;
	private static int num_serie_enlacep3=0;
	private static int num_serie_enlacep4=0;
	private static int num_serie_enlacep5=0;
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
	public JPanel getPanel_ZafiroStandar() {
		return Panel_ZafiroStandar;
	}
	public void setPanel_ZafiroStandar(JPanel panel_ZafiroStandar) {
		Panel_ZafiroStandar = panel_ZafiroStandar;
	}
	// ----------------------------------------------------------------------------------------
	// MÉTODO MAIN
	// ----------------------------------------------------------------------------------------
	/**
	 * En el método main ejecutamos la ventana principal Inicio_ZafiroStandar.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio_ZafiroStandar frame = new inicio_ZafiroStandar();
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
	 * En el constructor Inicio_ZafiroStandar() están todos los atributos y métodos necesarios para cuando creemos el objeto tenga todas las funcionalidades.
	 */
	public inicio_ZafiroStandar() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 703);
		contentPane = new JPanel();
		//------------------------------------------------------------------------------------------------------------	
		//PANEL ZAFIRO STANDAR
		//------------------------------------------------------------------------------------------------------------	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//------------------------------------------------------------------------------------------------------------	
		// Panel Administrador
		//------------------------------------------------------------------------------------------------------------	
		Panel_ZafiroStandar = new JPanel();
		Panel_ZafiroStandar.setBounds(0, 0, 961, 664);
		contentPane.add(Panel_ZafiroStandar);
		Panel_ZafiroStandar.setLayout(null);
		//------------------------------------------------------------------------------------------------------------	
		//TÍTULOS SERIES
		//------------------------------------------------------------------------------------------------------------	
		// ----------------------------------------------------------------------------------------
		// lbl_LoMasNuevo TIENE EL TEXTO DE -LO MÁS NUEVO-
		// ----------------------------------------------------------------------------------------
		lbl_LoMasNuevo = new JLabel("LO MÁS NUEVO");
		lbl_LoMasNuevo.setOpaque(true);
		lbl_LoMasNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_LoMasNuevo.setFont(new Font("Tahoma", Font.BOLD, 14)); 
		lbl_LoMasNuevo.setBorder(new LineBorder(new Color(211, 211, 211)));
		lbl_LoMasNuevo.setBackground(new Color(204, 255, 204));
		lbl_LoMasNuevo.setBounds(107, 58, 812, 30);
		// ----------------------------------------------------------------------------------------
		// lbl_TOP5 TIENE EL TEXTO DE -TOP 5 ÚLTIMO MES-
		// ----------------------------------------------------------------------------------------
		lbl_TOP5 = new JLabel("TOP 5 ÚLTIMO MES");
		lbl_TOP5.setOpaque(true);
		lbl_TOP5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TOP5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_TOP5.setBorder(new LineBorder(new Color(211, 211, 211)));
		lbl_TOP5.setBackground(new Color(204, 255, 204));
		lbl_TOP5.setBounds(107, 362, 812, 30);
		//------------------------------------------------------------------------------------------------------------	
		//SERIES
		//------------------------------------------------------------------------------------------------------------	
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGSerie10 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------
		lbl_IMGSerie10 = new JLabel("");
		lbl_IMGSerie10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_serie_enlacep2==0) {
					num_serie=5;
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
		lbl_IMGSerie10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGSerie10.setBounds(767, 425, 142, 182);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie10.setIcon(CatalogoAudiovisual.obtenerImagenSeries(5,lbl_IMGSerie10.getWidth(),lbl_IMGSerie10.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGSerie9 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------
		lbl_IMGSerie9 = new JLabel("");
		lbl_IMGSerie9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_serie_enlacep2==0) {
					num_serie=0;
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
		lbl_IMGSerie9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGSerie9.setBounds(605, 425, 142, 182);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie9.setIcon(CatalogoAudiovisual.obtenerImagenSeries(0,lbl_IMGSerie9.getWidth(),lbl_IMGSerie9.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGSerie8 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------
		lbl_IMGSerie8 = new JLabel("");
		lbl_IMGSerie8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_serie_enlacep4==0) {
					num_serie=14;
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
		lbl_IMGSerie8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGSerie8.setBounds(443, 425, 142, 182);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie8.setIcon(CatalogoAudiovisual.obtenerImagenSeries(14,lbl_IMGSerie8.getWidth(),lbl_IMGSerie8.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGSerie7 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------
		lbl_IMGSerie7 = new JLabel("");
		lbl_IMGSerie7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_serie_enlacep5==0) {
					num_serie=8;
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
		lbl_IMGSerie7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGSerie7.setBounds(280, 425, 142, 182);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie7.setIcon(CatalogoAudiovisual.obtenerImagenSeries(8,lbl_IMGSerie7.getWidth(),lbl_IMGSerie7.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGSerie5 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------
		lbl_IMGSerie6 = new JLabel("");
		lbl_IMGSerie6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_serie_enlacep1==0) {
					num_serie=11;
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
					ruta_serie=CatalogoAudiovisual.devolverRutaSerie(num_serie_enlacep1);
					Connection conexion;
					try {
						conexion = DriverManager.getConnection(url, login, password);
						// REALIZAMOS EL SELECT CON LOS DATOS QUE QUEREMOS ALMACENAR (? --> ES UN CAMPO QUE LO VA A ADQUIRIR DE LA VARIABLE membresia_id) (SIRVE PARA CREAR LA SENTENCIA SQL)
						String query = "SELECT COUNT(ID_N_TEMPORADA) FROM TEMPORADAS WHERE ID_CAT_AUDIOVISUAL = ?";
						// LE DECIMOS QUE LA ? ANTERIOR USE EL VALOR DE LA VARIABLE membresia_id (1 ES EL NÚMERO DE ? Y membresia_id EL VALOR QUE LE QUEREMOS METER, EN ESTE CASO EL VALOR ALMACENADO EN LA VARIABLE)
						PreparedStatement stmt = conexion.prepareStatement(query);
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
		lbl_IMGSerie6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGSerie6.setBounds(117, 425, 142, 182);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie6.setIcon(CatalogoAudiovisual.obtenerImagenSeries(11,lbl_IMGSerie6.getWidth(),lbl_IMGSerie6.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGSerie5 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
		lbl_IMGSerie5.setBounds(767, 122, 142, 182);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie5.setIcon(CatalogoAudiovisual.obtenerImagenSeries(4,lbl_IMGSerie5.getWidth(),lbl_IMGSerie5.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGSerie4 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------
		lbl_IMGSerie4 = new JLabel("");
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
		lbl_IMGSerie4.setBounds(605, 122, 142, 182);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie4.setIcon(CatalogoAudiovisual.obtenerImagenSeries(3,lbl_IMGSerie4.getWidth(),lbl_IMGSerie4.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGSerie3 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------
		lbl_IMGSerie3 = new JLabel("");
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
		lbl_IMGSerie3.setBounds(443, 122, 142, 182);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie3.setIcon(CatalogoAudiovisual.obtenerImagenSeries(2,lbl_IMGSerie3.getWidth(),lbl_IMGSerie3.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGSerie2 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------
		lbl_IMGSerie2 = new JLabel("");
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
		lbl_IMGSerie2.setBounds(280, 122, 142, 182);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie2.setIcon(CatalogoAudiovisual.obtenerImagenSeries(1,lbl_IMGSerie2.getWidth(),lbl_IMGSerie2.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGSerie1 TIENE LA IMAGEN DE LA SERIE QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------
		lbl_IMGSerie1 = new JLabel("");
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
						stmt.setString(1, CatalogoAudiovisual.devolverIDserie(inicio_ZafiroStandar.ruta_serie));
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
		lbl_IMGSerie1.setBounds(117, 122, 142, 182);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGSerie1.setIcon(CatalogoAudiovisual.obtenerImagenSeries(0,lbl_IMGSerie1.getWidth(),lbl_IMGSerie1.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		// IMAGEN DE FONDO DE LA VENTANA ZAFIRO STANDAR
		//------------------------------------------------------------------------------------------------------------		
		JLabel lblFondo_Azul = new JLabel();
		lblFondo_Azul.setBounds(0, 0, 1280, 664);
		ImageIcon fondo1 = new ImageIcon(getClass().getResource("/Trilogy_imagenes/azulyverde.jpg"));// DIRECCIÓN DE LA IMAGEN QUE QUIERO AJUSTAR
		ImageIcon imgfondo = new ImageIcon(fondo1.getImage().getScaledInstance(lblFondo_Azul.getWidth(), lblFondo_Azul.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		lblFondo_Azul.setIcon(imgfondo);
		//------------------------------------------------------------------------------------------------------------	
		// BOTONES DE ACTUALIZACIÓN DEL CONTENIDO
		//------------------------------------------------------------------------------------------------------------	
		//------------------------------------------------------------------------------------------------------------
		//btn_Recarga1 CAMBIA LAS SERIES DE -LO MÁS NUEVO-
		//------------------------------------------------------------------------------------------------------------
		contador=0;
		btn_Recarga1 = new JButton("");
		btn_Recarga1.addMouseListener(new MouseAdapter() {
			@Override
			//CUANDO PASAS POR ENCIMA DEL BOTÓN
			public void mouseEntered(MouseEvent e) {
				btn_Recarga1.setContentAreaFilled(true);
				btn_Recarga1.setBackground(new Color(255, 255, 255, 160));
			}
			//CUANDO EL RATÓN SALE DEL BOTÓN
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Recarga1.setContentAreaFilled(false);
			}
			//CUANDO EL RATON ES PULSADO
			@Override
			public void mouseClicked(MouseEvent e) {
				// INCREMENTO CONTADOR CADA VEZ QUE SE PULSA
				contador+=1;
				if(contador==1) {
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
				} else if (contador==2) {
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
					contador=0;
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
		btn_Recarga1.setContentAreaFilled(false);
		btn_Recarga1.setBorderPainted(false);
		btn_Recarga1.setBounds(39, 171, 50, 50);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon recarga1 = new ImageIcon(getClass().getResource("/Trilogy_imagenes/actualizacion.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgRecarga1 = new ImageIcon(recarga1.getImage().getScaledInstance(btn_Recarga1.getWidth(), btn_Recarga1.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		btn_Recarga1.setIcon(imgRecarga1);
		// --------------------------------------------------------------------------
		//JERARQUÍA DEL PANEL PRINCIPAL
		// --------------------------------------------------------------------------
		Panel_ZafiroStandar.add(btn_Recarga1);
		Panel_ZafiroStandar.add(lbl_LoMasNuevo);
		Panel_ZafiroStandar.add(lbl_TOP5);
		Panel_ZafiroStandar.add(lbl_IMGSerie10);
		Panel_ZafiroStandar.add(lbl_IMGSerie9);
		Panel_ZafiroStandar.add(lbl_IMGSerie8);
		Panel_ZafiroStandar.add(lbl_IMGSerie7);
		Panel_ZafiroStandar.add(lbl_IMGSerie6);
		Panel_ZafiroStandar.add(lbl_IMGSerie5);
		Panel_ZafiroStandar.add(lbl_IMGSerie4);
		Panel_ZafiroStandar.add(lbl_IMGSerie3);
		Panel_ZafiroStandar.add(lbl_IMGSerie2);
		Panel_ZafiroStandar.add(lbl_IMGSerie1);
		Panel_ZafiroStandar.add(lblFondo_Azul);
	}
}
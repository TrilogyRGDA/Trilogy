package panel_IZ;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import pagina_Publicidad.Pagina_Publicidad;
import pagina_Publicidad.Pagina_Publicidad2;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import diamante_premium.Diamante_premium;
import diamante_premium.Diamante_premium2;
import inicioSesion.Inicio_Sesion;
import Inicio_RubiStandarCod.Inicio_RubiStandar;
import Inicio_RubiStandarCod.Inicio_RubiStandar2;
import Inicio_ZafiroStandarCod.inicio_ZafiroStandar;
import Inicio_ZafiroStandarCod.inicio_ZafiroStandar2;
import inicio_Cristal_Basic.Cristal_Basic;
import inicio_Cristal_Basic.Cristal_Basic2;
import Pagina_busquedaCod.Pagina_busqueda;
import Pagina_busquedaCod.Pagina_busqueda2;
/**
 * La página del panel de la izquieda es una página donde unificamos todas las demas ventanas pero para hacerder a ella tienes que registrarte en otras ventanas que van antes de esta.
 * En esta página podras ver películas, series y música segun la membresia adquirida. Esta separada en musica para todas las membresia y es la gratuita, series para zafiro, películas para rubi y diamante para películas y series.
 * Hay una parte de publicidad donde te sugeriremos una serie, película o música de forma aleatoria.
 * Cada parte de la membresias tiene su página personalizada y con mejores contenidos. 
 * En esta página podras cambiar tu mmebresía o darte debaja dandole a un botón en especifico.
 * (ESTÉTICO/BOTONES)
 * @param contentPane Es el panel principal donde contiene todos los atributos.
 * @param panelLateral Es el panel que interaciona como desplegable cambiando su tamaño y nos da la funcionalidad de agrandar la pantalla para las personas con dificultad y realizar las tareas de salir de la aplicación e ir a las demas pantallas.
 * @param lbl_FleDesple El label es una imagen clickable que cambia de imagen para informar al usuarios de lo que puede hacer. Lo que puede hacer es encoger o agrandar el panelLateral.
 * @param btn_LogoOriginal El botón de btn_LogoOriginal te enviara al la pantalla que se muestra al principio donde te mostrara publicidad y una recomendación.
 * @param btn_BuscarLateral El botón de btn_BuscarLateral te enviara a una página donde podras buscar la película, serie o música que quieras mediante el nombre.
 * @param btn_Musica El botón de btn_Musica te mostrara una págian donde podras escuchar canciones o albumes.
 * @param btn_Peliculas El botón de btn_Peliculas te mostrara una págian donde podras ver películas.
 * @param btn_Series El botón de btn_Series te mostrara una págian donde podras ver series y capítulos de dicha serie.
 * @param btn_Diamante El botón de btn_Diamante te mostrara una págian donde podras escuchar música, ver series y ver pelícilas.
 * @param btn_Salir te permite cerrar la aplicación.
 * (CÓDIGO)
 * @param desktopPane El desktopPane es el componente que nos permite intercambiar paneles sin tener que habrir una ventana entera solo cargando el panel.
 * @param diamante diamante es un objeto que pertenece a la clase Diamante_premium.
 * @param diamante2 diamante2 es un objeto que pertenece a la clase Diamante_premium2.
 * @param publicidad publicidad es un objeto que pertenece a la clase Pagina_Publicidad.
 * @param publicidad2 publicidad2 es un objeto que pertenece a la clase Pagina_Publicidad2.
 * @param rubi rubi es un objeto que pertenece a la clase Inicio_RubiStandar.
 * @param rubi2 rubi2 es un objeto que pertenece a la clase Inicio_RubiStandar2.
 * @param zafiro zafiro es un objeto que pertenece a la clase inicio_ZafiroStandar.
 * @param zafiro2 zafiro2 es un objeto que pertenece a la clase inicio_ZafiroStandar2.
 * @param p_musica p_musica es un objeto que pertenece a la clase Cristal_Basic.
 * @param p_musica2 p_musica2 es un objeto que pertenece a la clase Cristal_Basic2.
 * @param  buscar buscar es un objeto que pertenece a la clase Pagina_busqueda
 * @param  buscar2 buscar2 es un objeto que pertenece a la clase Pagina_busqueda2.
 * @param desactivar El boolean desactivar es un comprobador si se ha pulsado el botón btn_LogoOriginal o no (por defecto desactivar esta a false y cuando pulsas el botón btn_LogoOriginal se vuelve a true).
 * @param tamBigPelis El boolean tamBigPelis es un comprobador del tamaño que hay para poner el panel correspondiente (por defecto tamBigPelis esta a false panel pequeño y cuando pulsas el lbl_FleDesple se vuelve a true que es el tamaño del panel grande).
 * @param tamBigSeries El boolean tamBigSeries es un comprobador del tamaño que hay para poner el panel correspondiente (por defecto tamBigSeries esta a false panel pequeño y cuando pulsas el lbl_FleDesple se vuelve a true que es el tamaño del panel grande).
 * @param tamBigMusica El boolean tamBigMusica es un comprobador del tamaño que hay para poner el panel correspondiente (por defecto tamBigMusica esta a false panel pequeño y cuando pulsas el lbl_FleDesple se vuelve a true que es el tamaño del panel grande).
 * @param tamBigBusqueda El boolean tamBigBusqueda es un comprobador del tamaño que hay para poner el panel correspondiente (por defecto tamBigBusqueda esta a false panel pequeño y cuando pulsas el lbl_FleDesple se vuelve a true que es el tamaño del panel grande).
 * @param tamBigDiamante El boolean tamBigDiamante es un comprobador del tamaño que hay para poner el panel correspondiente (por defecto tamBigDiamante esta a false panel pequeño y cuando pulsas el lbl_FleDesple se vuelve a true que es el tamaño del panel grande).
 * @param comprobarPelis El boolean comprobarPelis es un comprobador si se ha pulsado el botón btn_Peliculas o no (por defecto comprobarPelis esta a false y cuando pulsas el botón btn_Peliculas se vuelve a true).
 * @param comprobarSeries El boolean comprobarSeries es un comprobador si se ha pulsado el botón btn_Series o no (por defecto comprobarSeries esta a false y cuando pulsas el botón btn_Series se vuelve a true).
 * @param comprobarMusica El boolean comprobarMusica es un comprobador si se ha pulsado el botón btn_Musica o no (por defecto comprobarMusica esta a false y cuando pulsas el botón btn_Musica se vuelve a true).
 * @param comprobarBusqueda El boolean comprobarBusqueda es un comprobador si se ha pulsado el botón btn_BuscarLateral o no (por defecto comprobarBusqueda esta a false y cuando pulsas el botón btn_BuscarLateral se vuelve a true).
 * @param comprobarPublicadaGrande El boolean comprobarPublicadaGrande es un comprobador del tamaño que hay para poner el panel correspondiente (por defecto comprobarPublicadaGrande esta a true panel pequeño y cuando pulsas el lbl_FleDesple se vuelve a false que es el tamaño del panel grande).
 * @param comprobarDiamante El boolean comprobarDiamante es un comprobador si se ha pulsado el botón btn_Diamante o no (por defecto comprobarDiamante esta a false y cuando pulsas el botón btn_Diamante se vuelve a true).
 * @author TRILOGY. Miembros: Adrian Leal Vacas, Gonzalo Amo Cano y Raul Senso Montojo.
 */
public class Panel_iz_Principal extends JFrame {
	// -----------------------------------------------------------------------------------------------------
	// VERSIÓN DEL PROGRAMA
	// -----------------------------------------------------------------------------------------------------
	/**
	 * La versión 1 del programa del Panel_iz_Principal.
	 */
	private static final long serialVersionUID = 1L;
	// -----------------------------------------------------------------------------------------------------
	// ATRIBUTOS
	// -----------------------------------------------------------------------------------------------------
	private JPanel contentPane;
	private JPanel panelLateral;
	private JButton btn_Salir;
	private JButton btn_BuscarLateral;
	private JButton btn_Musica;
	private JButton btn_Peliculas;
	private JButton btn_Series;
	private JButton btn_LogoOriginal;
	private JLabel lbl_FleDesple;
	private JDesktopPane desktopPane;
	private JButton btn_Diamante;
	Diamante_premium diamante = new Diamante_premium();
	Diamante_premium2 diamante2 = new Diamante_premium2();
	Pagina_Publicidad publicidad = new Pagina_Publicidad();
	Pagina_Publicidad2 publicidad2 = new Pagina_Publicidad2();
	Inicio_RubiStandar rubi = new Inicio_RubiStandar();
	Inicio_RubiStandar2 rubi2 = new Inicio_RubiStandar2();
	inicio_ZafiroStandar zafiro = new inicio_ZafiroStandar();
	inicio_ZafiroStandar2 zafiro2 = new inicio_ZafiroStandar2();
	Cristal_Basic p_musica = new Cristal_Basic();
	Cristal_Basic2 p_musica2 = new Cristal_Basic2();
	Pagina_busqueda buscar = new Pagina_busqueda();
	Pagina_busqueda2 buscar2 = new Pagina_busqueda2();
	private boolean desactivar=false;
	private boolean tamBigPelis=false;
	private boolean tamBigSeries=false;
	private boolean tamBigMusica=false;
	private boolean tamBigBusqueda=false;
	private boolean tamBigDiamante=false;
	public static boolean comprobarPelis=false;
	public static boolean comprobarSeries=false;
	public static boolean comprobarMusica=false;
	private boolean comprobarBusqueda=false;
	private boolean comprobarPublicadaGrande=false;
	public static boolean comprobarDiamante=false;
	public static boolean pelis_diamnte_premium=false;
	public static boolean pelis_rubi_standar=false;
	public static boolean album_cristal_basic=false;
	public static boolean series_zafiro_standar=false;
	// -----------------------------------------------------------------------------------------------------
	// GETTERS AND SETTERS
	// -----------------------------------------------------------------------------------------------------
	public JPanel getPanelLateral() {
		return panelLateral;
	}
	public void setPanelLateral(JPanel panelLateral) {
		this.panelLateral = panelLateral;
	}
	// -----------------------------------------------------------------------------------------------------
	// MÉTODO MAIN
	// -----------------------------------------------------------------------------------------------------
	/**
	 * En el MÉTODO main ejecutamos la ventana principal Pagina_administrador y realizamos la conexión a la base de datos para el funcionamiento de la página.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel_iz_Principal frame = new Panel_iz_Principal();
					frame.setLocationRelativeTo(null);	// CENTRAR CONTENIDO
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// -----------------------------------------------------------------------------------------------------
	// MÉTODOS
	// -----------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------
	// AÑADIR UN PANEL DE TAMAÑO PEQUEÑO
	// -----------------------------------------------------------------------------------------------------
	/**
	 * En este MÉTODO se intercambiara el panel seleccionado por el que estaba pero en el tamaño pequeño.
	 * @param panelNuevo es un atributo que se le pasara por parametro para intercambiar los paneles en el desktopPane.
	 */
	public void nuevoPanel(JPanel panelNuevo) {
		desktopPane.add(panelNuevo);
		panelNuevo.setBounds(0, 0, 961, 664);
		desktopPane.repaint();
		desktopPane.revalidate();
	}
	// -----------------------------------------------------------------------------------------------------
	// AÑADIR UN PANEL DE TAMAÑO GRANDE
	// -----------------------------------------------------------------------------------------------------
	/**
	 * En este MÉTODO se intercambiara el panel seleccionado por el que estaba pero en el tamaño grande.
	 * @param panelNuevo es un atributo que se le pasara por parametro para intercambiar los paneles en el desktopPane.
	 */
	public void nuevoPanel2(JPanel panelNuevo) {
		desktopPane.add(panelNuevo);
		panelNuevo.setBounds(0, 0, 1130, 663);
		desktopPane.repaint();
		desktopPane.revalidate();
	}
	// -----------------------------------------------------------------------------------------------------
	// ELIMINAR TODOS LOS PANELES
	// -----------------------------------------------------------------------------------------------------
	/**
	 * En este MÉTODO se elimina todos los paneles del desktopPane.
	 */
	public void eliminar() {
		desktopPane.remove(publicidad.getPanel_contenedor());
		desktopPane.remove(publicidad2.getPanel_contenedor());
		desktopPane.remove(buscar.getPanel_Pagina_busqueda());
		desktopPane.remove(buscar2.getPanel_Pagina_busqueda());
		desktopPane.remove(p_musica.getPanel_CristalBasic());
		desktopPane.remove(p_musica2.getPanel_CristalBasic());
		desktopPane.remove(rubi.getPanel_RubiStandar());
		desktopPane.remove(rubi2.getPanel_RubiStandar());
		desktopPane.remove(zafiro.getPanel_ZafiroStandar());
		desktopPane.remove(zafiro2.getPanel_ZafiroStandar());
		desktopPane.remove(diamante.getPanel_contenedor());
		desktopPane.remove(diamante2.getPanel_contenedor());
	}
	// -----------------------------------------------------------------------------------------------------
	// BOTONES MÁS PEQUEÑOS
	// -----------------------------------------------------------------------------------------------------
	/**
	 * El MÉTODO EsconderBotones() realiza un encogimiento de los elementos del panel de la izquierda.
	 */
	public void EsconderBotones() {
		// -----------------------------------------------------------------------------------------------------				
		// BOTON DEL LOGO
		// -----------------------------------------------------------------------------------------------------
		btn_LogoOriginal.setBounds(3, 34, 64, 64); // HACEMOS EL BOTÓN MÁS PEQUEÑO
		btn_LogoOriginal.setText(""); // LIMPIAMOS EL TEXTO
		btn_LogoOriginal.setHorizontalAlignment(SwingConstants.CENTER); // CENTRO EL TEXTO
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon logoOriginal2 = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoTrilogy.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgLogoOriginal2 = new ImageIcon(logoOriginal2.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_LogoOriginal.setIcon(imgLogoOriginal2);
		// -----------------------------------------------------------------------------------------------------
		// BOTON DEL BUSCAR
		// -----------------------------------------------------------------------------------------------------				
		btn_BuscarLateral.setBounds(3, 130, 64, 64); // HACEMOS EL BOTÓN MÁS PEQUEÑO
		btn_BuscarLateral.setText(""); // LIMPIAMOS EL TEXTO
		btn_BuscarLateral.setHorizontalAlignment(SwingConstants.CENTER); // CENTRO EL TEXTO
		// -----------------------------------------------------------------------------------------------------
		// BOTON DE LA MÚSICA
		// -----------------------------------------------------------------------------------------------------				
		btn_Musica.setBounds(3, 222, 64, 64); // HACEMOS EL BOTÓN MÁS PEQUEÑO
		btn_Musica.setText(""); // LIMPIAMOS EL TEXTO
		btn_Musica.setHorizontalAlignment(SwingConstants.CENTER); // CENTRO EL TEXTO
		// -----------------------------------------------------------------------------------------------------
		// BOTON DE LA PELÍCULAS
		// -----------------------------------------------------------------------------------------------------				
		btn_Peliculas.setBounds(3, 314, 64, 64); // HACEMOS EL BOTÓN MÁS PEQUEÑO
		btn_Peliculas.setText(""); // LIMPIAMOS EL TEXTO
		btn_Peliculas.setHorizontalAlignment(SwingConstants.CENTER); // CENTRO EL TEXTO
		// -----------------------------------------------------------------------------------------------------
		// BOTON DE LA SERIE
		// -----------------------------------------------------------------------------------------------------				
		btn_Series.setBounds(3, 406, 64, 64); // HACEMOS EL BOTÓN MÁS PEQUEÑO
		btn_Series.setText(""); // LIMPIAMOS EL TEXTO
		btn_Series.setHorizontalAlignment(SwingConstants.CENTER); // CENTRO EL TEXTO
		// -----------------------------------------------------------------------------------------------------
		// BOTON DE DIAMANTE
		// -----------------------------------------------------------------------------------------------------				
		btn_Diamante.setBounds(3, 498, 64, 64); // HACEMOS EL BOTÓN MÁS PEQUEÑO
		btn_Diamante.setText(""); // LIMPIAMOS EL TEXTO
		btn_Diamante.setHorizontalAlignment(SwingConstants.CENTER); // CENTRO EL TEXTO
		// -----------------------------------------------------------------------------------------------------
		// BOTON DE SALIR
		// -----------------------------------------------------------------------------------------------------
		btn_Salir.setBounds(3, 588, 64, 64); // HACEMOS EL BOTÓN MÁS PEQUEÑO
		btn_Salir.setText(""); // LIMPIAMOS EL TEXTO
		btn_Salir.setHorizontalAlignment(SwingConstants.CENTER); // CENTRO EL TEXTO
	}
	// -----------------------------------------------------------------------------------------------------
	// BOTONES TAMAÑO ORIGINAL
	// -----------------------------------------------------------------------------------------------------
	/**
	 * El MÉTODO MostrarBotones() realiza un ensanchamiento de los elementos del panel de la izquierda (por defecto).
	 */
	public void MostrarBotones() {
		// -----------------------------------------------------------------------------------------------------
		// BOTON DEL LOGO
		// -----------------------------------------------------------------------------------------------------
		btn_LogoOriginal.setBounds(10, 34, 199, 64); 
		btn_LogoOriginal.setText(""); // LIMPIAMOS EL TEXTO
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon logoOriginal = new ImageIcon(getClass().getResource("/Trilogy_imagenes/LogoTrilogyNegro.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgLogoOriginal = new ImageIcon(logoOriginal.getImage().getScaledInstance(btn_LogoOriginal.getWidth(), btn_LogoOriginal.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_LogoOriginal.setIcon(imgLogoOriginal);
		// -----------------------------------------------------------------------------------------------------
		// BOTON DEL BUSCAR
		// -----------------------------------------------------------------------------------------------------
		btn_BuscarLateral.setBounds(10, 130, 199, 64); 
		btn_BuscarLateral.setText("      Que buscas"); 
		btn_BuscarLateral.setHorizontalAlignment(SwingConstants.LEFT);
		btn_BuscarLateral.setFont(new Font("Tahoma", Font.BOLD, 14));
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon buscarLateral = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoLupa.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgBuscarLateral = new ImageIcon(buscarLateral.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH));
		btn_BuscarLateral.setIcon(imgBuscarLateral);
		// -----------------------------------------------------------------------------------------------------
		// BOTON DE LA MÚSICA
		// -----------------------------------------------------------------------------------------------------
		btn_Musica.setBounds(10, 222, 199, 64); 
		btn_Musica.setText("      Música"); 
		btn_Musica.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Musica.setFont(new Font("Tahoma", Font.BOLD, 14));
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon musica = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoMusicas.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgMusica = new ImageIcon(musica.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_Musica.setIcon(imgMusica);
		// -----------------------------------------------------------------------------------------------------
		// BOTON DE LA PELÍCULAS
		// -----------------------------------------------------------------------------------------------------
		btn_Peliculas.setBounds(10, 314, 199, 64); 
		btn_Peliculas.setText("      Películas"); 
		btn_Peliculas.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Peliculas.setFont(new Font("Tahoma", Font.BOLD, 14));
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon peliculas = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoPeliculas.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgPeliculas = new ImageIcon(peliculas.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_Peliculas.setIcon(imgPeliculas);
		// -----------------------------------------------------------------------------------------------------
		// BOTON DE LA SERIE
		// -----------------------------------------------------------------------------------------------------
		btn_Series.setBounds(10, 406, 199, 64); 
		btn_Series.setText("      Series"); 
		btn_Series.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Series.setFont(new Font("Tahoma", Font.BOLD, 14));
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon serires = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoSeries.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgSerires = new ImageIcon(serires.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_Series.setIcon(imgSerires);
		// -----------------------------------------------------------------------------------------------------
		// BOTON DEL DIAMANTE
		// -----------------------------------------------------------------------------------------------------
		btn_Diamante.setBounds(10, 498, 199, 64); 
		btn_Diamante.setText("      Diamante"); 
		btn_Diamante.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Diamante.setFont(new Font("Tahoma", Font.BOLD, 14));
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon diamant = new ImageIcon(getClass().getResource("/Trilogy_imagenes/diamnt_rosa.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgDiamant = new ImageIcon(diamant.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_Diamante.setIcon(imgDiamant);
		// -----------------------------------------------------------------------------------------------------
		// BOTON DE SALIR
		// -----------------------------------------------------------------------------------------------------
		btn_Salir.setBounds(10, 588, 199, 64); 
		btn_Salir.setText("      Logout"); 
		btn_Salir.setHorizontalAlignment(SwingConstants.LEFT); 
		btn_Salir.setFont(new Font("Tahoma", Font.BOLD, 14)); 
		ImageIcon iconoSalir = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoLogout.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgiconoSalir = new ImageIcon(iconoSalir.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_Salir.setIcon(imgiconoSalir);
	}
	// -----------------------------------------------------------------------------------------------------
	// CONSTRUCTOR
	// -----------------------------------------------------------------------------------------------------
	/**
	 * El constructor se llama a los atributos y MÉTODOs necesarios para el funcionamiento de la clase Panel_iz_Principal.
	 */
	public Panel_iz_Principal() {
		// -----------------------------------------------------------------------------------------------------
		// VENTANA DE AFUERA
		// -----------------------------------------------------------------------------------------------------
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1196, 702); // TAMAÑO DE LA VENTANA
		// -----------------------------------------------------------------------------------------------------
		// CONTENTPANE
		// -----------------------------------------------------------------------------------------------------
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// -----------------------------------------------------------------------------------------------------
		// DESKTOPPANE CAMBIADOR DE PANELES
		// -----------------------------------------------------------------------------------------------------
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(219, 0, 961, 663);
		desktopPane.add(publicidad.getPanel_contenedor());
		// -----------------------------------------------------------------------------------------------------
		// PANEL LATERAL
		// -----------------------------------------------------------------------------------------------------
		panelLateral = new JPanel();
		panelLateral.setBackground(new Color(153, 255, 153));
		panelLateral.setBounds(0, 0, 219, 663); // TAMAÑO DEL PANEL DE LA IZQUIERDA TOTALMENTE EXTENDIDO
		panelLateral.setLayout(null);
		// -----------------------------------------------------------------------------------------------------
		// GERARQUIA DEL CONTENTPANE
		contentPane.add(desktopPane);
		contentPane.add(panelLateral);
		// -----------------------------------------------------------------------------------------------------
		// BOTÓN DE LOGOUT
		// -----------------------------------------------------------------------------------------------------
		btn_Salir = new JButton("      Logout");
		btn_Salir.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Salir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Salir.setFocusPainted(false);
		btn_Salir.setBorderPainted(false);
		btn_Salir.setBackground(new Color(153, 255, 153));
		btn_Salir.setBounds(10, 588, 199, 64);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon iconoSalir = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoLogout.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgiconoSalir = new ImageIcon(iconoSalir.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_Salir.setIcon(imgiconoSalir);
		// EVENTOS CON EL RATON (MOUSE)
		btn_Salir.addMouseListener(new MouseAdapter() {
			// CUANDO ESTAS PASANDO POR ENCIMA
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Salir.setBackground(new Color(92,252,92)); // EL COLOR QUE SE VA A PONER CUANDO PASES POR ENCIMA (O ESTE COLOR 29,239,29 PREGUNTAR AL GRUPO)
				btn_Salir.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			// CUANDO DESJES DE PASAR POR ENCIMA
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Salir.setBackground(new Color(153,255,153)); // EL COLOR QUE SE VA A PONER CUANDO DEJES DE PASES POR ENCIMA
				btn_Salir.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0); // ESTO ES LO QUE HACE QUE CIERRE LA APP
			}
		});
		// -----------------------------------------------------------------------------------------------------
		// BOTÓN DE BUSCAR
		// -----------------------------------------------------------------------------------------------------
		btn_BuscarLateral = new JButton("      Que buscas");
		btn_BuscarLateral.setHorizontalAlignment(SwingConstants.LEFT);
		btn_BuscarLateral.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_BuscarLateral.setFocusPainted(false);
		btn_BuscarLateral.setBorderPainted(false);
		btn_BuscarLateral.setBackground(new Color(153, 255, 153));
		btn_BuscarLateral.setBounds(10, 130, 199, 64);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon buscarLateral = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoLupa.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgBuscarLateral = new ImageIcon(buscarLateral.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH));
		btn_BuscarLateral.setIcon(imgBuscarLateral);
		// EVENTOS CON EL RATON (MOUSE)
		btn_BuscarLateral.addMouseListener(new MouseAdapter() {
			// CUANDO ESTAS PASANDO POR ENCIMA
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_BuscarLateral.setBackground(new Color(92,252,92)); // EL COLOR QUE SE VA A PONER CUANDO PASES POR ENCIMA (O ESTE COLOR 29,239,29 PREGUNTAR AL GRUPO)
				btn_BuscarLateral.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			// CUANDO DESJES DE PASAR POR ENCIMA
			@Override
			public void mouseExited(MouseEvent e) {
				btn_BuscarLateral.setBackground(new Color(153,255,153)); // EL COLOR QUE SE VA A PONER CUANDO DEJES DE PASES POR ENCIMA
				btn_BuscarLateral.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelLateral.getBounds().width == 219) {
					desactivar=true;
					comprobarSeries=false;
					comprobarMusica=false;
					comprobarBusqueda=true;
					comprobarPelis=false;
					comprobarDiamante=false;
					tamBigBusqueda=true;
					eliminar();
					nuevoPanel(buscar.getPanel_Pagina_busqueda());
				} else {
					desactivar=true;
					comprobarSeries=false;
					comprobarMusica=false;
					comprobarBusqueda=true;
					comprobarPelis=false;
					comprobarDiamante=false;
					tamBigBusqueda=false;
					eliminar();
					nuevoPanel2(buscar2.getPanel_Pagina_busqueda());
				}
			}
		});
		// -----------------------------------------------------------------------------------------------------
		// BOTÓN DE MÚSICA
		// -----------------------------------------------------------------------------------------------------
		btn_Musica = new JButton("      Música");
		btn_Musica.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Musica.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Musica.setFocusPainted(false);
		btn_Musica.setBorderPainted(false);
		btn_Musica.setBackground(new Color(153, 255, 153));
		btn_Musica.setBounds(10, 222, 199, 64);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon musica = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoMusicas.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgMusica = new ImageIcon(musica.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_Musica.setIcon(imgMusica);
		// EVENTOS CON EL RATON (MOUSE)
		btn_Musica.addMouseListener(new MouseAdapter() {
			// CUANDO ESTAS PASANDO POR ENCIMA
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Musica.setBackground(new Color(92,252,92)); // EL COLOR QUE SE VA A PONER CUANDO PASES POR ENCIMA (O ESTE COLOR 29,239,29 PREGUNTAR AL GRUPO)
				btn_Musica.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			// CUANDO DESJES DE PASAR POR ENCIMA
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Musica.setBackground(new Color(153,255,153)); // EL COLOR QUE SE VA A PONER CUANDO DEJES DE PASES POR ENCIMA
				btn_Musica.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelLateral.getBounds().width == 219) {
					desactivar=true;
					comprobarSeries=false;
					comprobarMusica=true;
					comprobarBusqueda=false;
					comprobarPelis=false;
					comprobarDiamante=false;
					tamBigMusica=true;
					eliminar();
					nuevoPanel(p_musica.getPanel_CristalBasic());
				} else {
					desactivar=true;
					comprobarSeries=false;
					comprobarMusica=true;
					comprobarBusqueda=false;
					comprobarPelis=false;
					comprobarDiamante=false;
					tamBigMusica=false;
					eliminar();
					nuevoPanel2(p_musica2.getPanel_CristalBasic());
				}
			}
		});
		// -----------------------------------------------------------------------------------------------------
		// BOTÓN DE PELÍCULAS
		// -----------------------------------------------------------------------------------------------------
		btn_Peliculas = new JButton("      Películas");
		btn_Peliculas.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Peliculas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Peliculas.setFocusPainted(false);
		btn_Peliculas.setBorderPainted(false);
		btn_Peliculas.setBackground(new Color(153, 255, 153));
		btn_Peliculas.setBounds(10, 314, 199, 64);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon peliculas = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoPeliculas.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgPeliculas = new ImageIcon(peliculas.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_Peliculas.setIcon(imgPeliculas);
		// EVENTOS CON EL RATON (MOUSE)
		btn_Peliculas.addMouseListener(new MouseAdapter() {
			// CUANDO ESTAS PASANDO POR ENCIMA
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Peliculas.setBackground(new Color(92,252,92)); // EL COLOR QUE SE VA A PONER CUANDO PASES POR ENCIMA (O ESTE COLOR 29,239,29 PREGUNTAR AL GRUPO)
				btn_Peliculas.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			// CUANDO DESJES DE PASAR POR ENCIMA
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Peliculas.setBackground(new Color(153,255,153)); // EL COLOR QUE SE VA A PONER CUANDO DEJES DE PASES POR ENCIMA
				btn_Peliculas.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Inicio_Sesion.id_de_membresia == 3 || Inicio_Sesion.id_de_membresia == 4) {
					if (panelLateral.getBounds().width == 219) {
						desactivar=true;
						comprobarSeries=false;
						comprobarMusica=false;
						comprobarBusqueda=false;
						comprobarPelis=true;
						comprobarDiamante=false;
						tamBigPelis=true;
						eliminar();
						nuevoPanel(rubi.getPanel_RubiStandar());
					} else {
						desactivar=true;
						comprobarSeries=false;
						comprobarMusica=false;
						comprobarBusqueda=false;
						comprobarPelis=true;
						comprobarDiamante=false;
						tamBigPelis=false;
						eliminar();
						nuevoPanel2(rubi2.getPanel_RubiStandar());
					}
				} else {
					JOptionPane.showMessageDialog(null, "ERROR. Su membresia no permite entrar en este apartadolo siento por las molestias, si quieres ver este apartado adquiere la membresia diamante_premium o rubi_standard.");
				}
			}
		});
		// -----------------------------------------------------------------------------------------------------
		// BOTÓN DE SERIES
		// -----------------------------------------------------------------------------------------------------
		btn_Series = new JButton("      Series");
		btn_Series.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Series.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Series.setFocusPainted(false);
		btn_Series.setBorderPainted(false);
		btn_Series.setBackground(new Color(153, 255, 153));
		btn_Series.setBounds(10, 406, 199, 64);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon serires = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoSeries.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgSerires = new ImageIcon(serires.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_Series.setIcon(imgSerires);
		// EVENTOS CON EL RATON (MOUSE)
		btn_Series.addMouseListener(new MouseAdapter() {
			// CUANDO ESTAS PASANDO POR ENCIMA
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Series.setBackground(new Color(92,252,92)); // EL COLOR QUE SE VA A PONER CUANDO PASES POR ENCIMA (O ESTE COLOR 29,239,29 PREGUNTAR AL GRUPO)
				btn_Series.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			// CUANDO DESJES DE PASAR POR ENCIMA
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Series.setBackground(new Color(153,255,153)); // EL COLOR QUE SE VA A PONER CUANDO DEJES DE PASES POR ENCIMA
				btn_Series.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Inicio_Sesion.id_de_membresia == 2 || Inicio_Sesion.id_de_membresia == 4) {
					if (panelLateral.getBounds().width == 219) {
						desactivar=true;
						comprobarSeries=true;
						comprobarMusica=false;
						comprobarBusqueda=false;
						comprobarPelis=false;
						comprobarDiamante=false;
						tamBigSeries=true;
						eliminar();
						nuevoPanel(zafiro.getPanel_ZafiroStandar());
					} else {
						desactivar=true;
						comprobarSeries=true;
						comprobarMusica=false;
						comprobarBusqueda=false;
						comprobarPelis=false;
						comprobarDiamante=false;
						tamBigSeries=false;
						eliminar();
						nuevoPanel2(zafiro2.getPanel_ZafiroStandar());
					}
				} else {
					JOptionPane.showMessageDialog(null, "ERROR. Su membresia no permite entrar en este apartadolo siento por las molestias, si quieres ver este apartado adquiere la membresia diamante_premium o zafiro_standard.");
				}
			}
		});
		// -----------------------------------------------------------------------------------------------------
		// BOTÓN DE DIAMANTE
		// -----------------------------------------------------------------------------------------------------
		btn_Diamante = new JButton("      Diamante");
		btn_Diamante.addMouseListener(new MouseAdapter() {
			// CUANDO ESTAS PASANDO POR ENCIMA
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Diamante.setBackground(new Color(92,252,92)); // EL COLOR QUE SE VA A PONER CUANDO PASES POR ENCIMA (O ESTE COLOR 29,239,29 PREGUNTAR AL GRUPO)
				btn_Diamante.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			// CUANDO DESJES DE PASAR POR ENCIMA
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Diamante.setBackground(new Color(153,255,153)); // EL COLOR QUE SE VA A PONER CUANDO DEJES DE PASES POR ENCIMA
				btn_Diamante.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Inicio_Sesion.id_de_membresia == 4) {
					if (panelLateral.getBounds().width == 219) {
						desactivar=true;
						comprobarSeries=false;
						comprobarMusica=false;
						comprobarBusqueda=false;
						comprobarPelis=false;
						comprobarDiamante=true;
						tamBigDiamante=true;
						eliminar();
						nuevoPanel(diamante.getPanel_contenedor());
					} else {
						desactivar=true;
						comprobarSeries=false;
						comprobarMusica=false;
						comprobarBusqueda=false;
						comprobarPelis=false;
						comprobarDiamante=true;
						tamBigDiamante=false;
						eliminar();
						nuevoPanel2(diamante2.getPanel_contenedor());
					}
				} else {
					JOptionPane.showMessageDialog(null, "ERROR. Su membresia no permite entrar en este apartadolo siento por las molestias, si quieres ver este apartado adquiere la membresia diamante_premium");
				}
			}
		});
		btn_Diamante.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Diamante.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Diamante.setFocusPainted(false);
		btn_Diamante.setBorderPainted(false);
		btn_Diamante.setBackground(new Color(153, 255, 153));
		btn_Diamante.setBounds(10, 498, 199, 64);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon diamant = new ImageIcon(getClass().getResource("/Trilogy_imagenes/diamnt_rosa.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgDiamant = new ImageIcon(diamant.getImage().getScaledInstance(57, 57, Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_Diamante.setIcon(imgDiamant);
		// -----------------------------------------------------------------------------------------------------
		// BOTÓN DEL LOGO
		// -----------------------------------------------------------------------------------------------------
		btn_LogoOriginal = new JButton("");
		btn_LogoOriginal.addMouseListener(new MouseAdapter() {
			// CUANDO ESTAS PASANDO POR ENCIMA
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_LogoOriginal.setBackground(new Color(92,252,92)); // EL COLOR QUE SE VA A PONER CUANDO PASES POR ENCIMA (O ESTE COLOR 29,239,29 PREGUNTAR AL GRUPO)
				btn_LogoOriginal.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			// CUANDO DESJES DE PASAR POR ENCIMA
			@Override
			public void mouseExited(MouseEvent e) {
				btn_LogoOriginal.setBackground(new Color(153,255,153)); // EL COLOR QUE SE VA A PONER CUANDO DEJES DE PASES POR ENCIMA
				btn_LogoOriginal.setForeground(new Color(0,0,0)); // COLOR CUANDO YA HAS PASADO POR ENCIMA
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelLateral.getBounds().width == 219) {
					desactivar=false;
					comprobarSeries=false;
					comprobarMusica=false;
					comprobarBusqueda=false;
					comprobarPelis=false;
					comprobarPublicadaGrande=false;
					eliminar();
					nuevoPanel(publicidad.getPanel_contenedor());
				} else {
					desactivar=false;
					comprobarSeries=false;
					comprobarMusica=false;
					comprobarBusqueda=false;
					comprobarPelis=false;
					comprobarPublicadaGrande=true;
					eliminar();
					nuevoPanel2(publicidad2.getPanel_contenedor());
				}
			}
		});
		btn_LogoOriginal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_LogoOriginal.setFocusPainted(false);
		btn_LogoOriginal.setBorderPainted(false);
		btn_LogoOriginal.setBackground(new Color(153, 255, 153));
		btn_LogoOriginal.setBounds(10, 34, 199, 64);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon logoOriginal = new ImageIcon(getClass().getResource("/Trilogy_imagenes/LogoTrilogyNegro.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgLogoOriginal = new ImageIcon(logoOriginal.getImage().getScaledInstance(btn_LogoOriginal.getWidth(), btn_LogoOriginal.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		btn_LogoOriginal.setIcon(imgLogoOriginal);
		// -----------------------------------------------------------------------------------------------------
		// FLECHA CON FUNCION DE DESPLEGABLE
		// -----------------------------------------------------------------------------------------------------
		lbl_FleDesple = new JLabel("");
		lbl_FleDesple.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_FleDesple.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // CUANDO PASAS POR ARRIBA CAMBIA EL ASPECTO DEL CURSOR
		lbl_FleDesple.setBounds(196, 0, 23, 26); // TAMAÑO DEL LABEL QUE VA A CONTENER LA IMAGEN
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon fleDesple = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoDesplegableEncoger.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgfleDesple = new ImageIcon(fleDesple.getImage().getScaledInstance(lbl_FleDesple.getWidth(), lbl_FleDesple.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		lbl_FleDesple.setIcon(imgfleDesple); // DECIMOS QUE EL ICONO ES IGUAL A EL OBJETO QUE SE AJUSTA AUTOMATICAMENTE AL TAMAÑO DEL LABEL
		// EVENTOS CON EL RATÓN
		lbl_FleDesple.addMouseListener(new MouseAdapter() {
			@Override
			// CUANDO EL RATÓN CLICKEA
			public void mouseClicked(MouseEvent e) {
				if (panelLateral.getBounds().width == 219) {
					// PANELES GRANDES
					panelLateral.setBounds(0,0,72,664);
					desktopPane.setBounds(70,0,1130,663);
					lbl_FleDesple.setBounds(47, 0, 23, 26);
					ImageIcon fleDespleDesplegar = new ImageIcon(getClass().getResource("/Trilogy_imagenes/IconoDesplegableDesplegar.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
					ImageIcon imgfleDespleDesplegar = new ImageIcon(fleDespleDesplegar.getImage().getScaledInstance(lbl_FleDesple.getWidth(), lbl_FleDesple.getHeight(), Image.SCALE_SMOOTH));
					lbl_FleDesple.setIcon(imgfleDespleDesplegar);
					EsconderBotones();
					if (comprobarPublicadaGrande==false && desactivar==false){
						eliminar();
						nuevoPanel2(publicidad2.getPanel_contenedor());
						comprobarPublicadaGrande=true;
					} else if (comprobarPelis==true && tamBigPelis==true) {
						eliminar();
						nuevoPanel2(rubi2.getPanel_RubiStandar());
						pelis_rubi_standar=true;
						tamBigPelis=false;
					} else if (comprobarDiamante==true && tamBigDiamante==true) {
						eliminar();
						nuevoPanel2(diamante2.getPanel_contenedor());
						pelis_diamnte_premium=true;
						series_zafiro_standar=true;
						album_cristal_basic=true;
						tamBigDiamante=false;
					} else if (comprobarSeries==true && tamBigSeries==true) {
						eliminar();
						nuevoPanel2(zafiro2.getPanel_ZafiroStandar());
						series_zafiro_standar=true;
						tamBigSeries=false;
					} else if (comprobarMusica==true && tamBigMusica==true) {
						eliminar();
						nuevoPanel2(p_musica2.getPanel_CristalBasic());
						album_cristal_basic=true;
						tamBigMusica=false;
					} else if (comprobarBusqueda==true && tamBigBusqueda==true) {
						eliminar();
						nuevoPanel2(buscar2.getPanel_Pagina_busqueda());
						tamBigBusqueda=false;
					}
				} else {
					// PANELES PEQUEÑOS
					panelLateral.setBounds(0,0,219,664);
					desktopPane.setBounds(219,0,961,663);
					lbl_FleDesple.setBounds(196, 0, 23, 26);
					lbl_FleDesple.setIcon(imgfleDesple);
					diamante.getPanel_contenedor().setBounds(0, 0, 961, 663);
					MostrarBotones();
					if (comprobarPublicadaGrande==true && desactivar==false) {
						eliminar();
						nuevoPanel(publicidad.getPanel_contenedor());
						comprobarPublicadaGrande=false;
					} else if (comprobarPelis==true && tamBigPelis==false) {
						eliminar();
						nuevoPanel(rubi.getPanel_RubiStandar());
						pelis_rubi_standar=false;
						tamBigPelis=true;
					} else if (comprobarDiamante==true && tamBigDiamante==false) {
						eliminar();
						nuevoPanel(diamante.getPanel_contenedor());
						pelis_diamnte_premium=false;
						album_cristal_basic=false;
						series_zafiro_standar=false;
						tamBigDiamante=true;
					} else if (comprobarSeries==true && tamBigSeries==false) {
						eliminar();
						nuevoPanel(zafiro.getPanel_ZafiroStandar());
						series_zafiro_standar=false;
						tamBigSeries=true;
					} else if (comprobarMusica==true && tamBigMusica==false) {
						eliminar();
						nuevoPanel(p_musica.getPanel_CristalBasic());
						album_cristal_basic=false;
						tamBigMusica=true;
					} else if (comprobarBusqueda==true && tamBigBusqueda==false) {
						eliminar();
						nuevoPanel(buscar.getPanel_Pagina_busqueda());
						tamBigBusqueda=true;
					}
				}
			}
		});
		// -----------------------------------------------------------------------------------------------------
		// GERARQUIA DEL PANEL LATERAL
		// -----------------------------------------------------------------------------------------------------
		panelLateral.add(lbl_FleDesple);
		panelLateral.add(btn_LogoOriginal);
		panelLateral.add(btn_BuscarLateral);
		panelLateral.add(btn_Musica);
		panelLateral.add(btn_Peliculas);
		panelLateral.add(btn_Series);
		panelLateral.add(btn_Diamante);
		panelLateral.add(btn_Salir);
	}
}
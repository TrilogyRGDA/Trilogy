package inicio_Cristal_Basic;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import cat_audiovisual.CatalogoAudiovisual;
import seleccionContAlbum.SeleccionContAlbum;
import java.awt.Cursor;
import java.awt.Desktop;
/**
 * En la página de Inicio Cristal Basic 2 podrás consumir contenido audiovisual de música y con dos botónes de recarga cambiarán el contenido audiovisual respectivo a la selección.
 * Esta página tiene dos versiones, ya que el panel de la izquierda se puede maximizar de tamaño para una mejor visualización del contenido.
 * @param contentPane 
 * Contiene todos los atributos de la página.
 * @param Panel_CristalBasic
 * Contiene todos los atributos para poder intercambiar paneles sin complicación.
 * @param btn_Recarga_Canciones
 * Botón que cambia el catálogo audiovisual de las canciones para que puedas ver todas las que están disponibles.
 * @param btn_Recarga_Canciones2 
 * Botón que cambia el catálogo audiovisual de los álbumes para que puedas ver todos los que están disponibles.
 * @param lblFondo_Cristal
 * Tiene la imagen del fondo característico de Cristal Basic.(Estético)
 * @param lbl_IMGCancion1 
 * Es un label con la función de pulsar y contiene la imagen de la canción que se va a reproducir.
 * @param lblTextoCancion1
 * Tiene el texto del nombre de la canción correspondiendo con el label (lbl_IMG_Music_1).
 * @param lbl_IMGCancion2
 * Es un label con la función de pulsar y contiene la imagen de la canción que se va a reproducir.
 * @param lblTextoCancion2
 * Tiene el texto del nombre de la canción correspondiendo con el label (lbl_IMG_Music_2).
 * @param lbl_IMGCancion3
 * Es un label con la función de pulsar y contiene la imagen de la canción que se va a reproducir.
 * @param lblTextoCancion3
 * Tiene el texto del nombre de la canción correspondiendo con el label (lbl_IMG_Music_3).
 * @param lbl_IMGCancion4
 * Es un label con la función de pulsar y contiene la imagen de la canción que se va a reproducir.
 * @param lblTextoCancion4
 * Tiene el texto del nombre de la canción correspondiendo con el label (lbl_IMG_Music_4).
 * @param lbl_IMGCancion5
 * Es un label con la función de pulsar y contiene la imagen de la canción que se va a reproducir.
 * @param lblTextoCancion5
 * Tiene el texto del nombre de la canción correspondiendo con el label (lbl_IMG_Music_5).
 * @param lbl_IMGAlbum1 
 * Es un label con la función de pulsar y contiene la imagen del álbum que se va a mostrar en SeleccionContAlbum().
 * @param lblTextoAlbum1
 * Tiene el texto del nombre del álbum correspondiendo con el label (lbl_IMGAlbum1).
 * @param lbl_IMGAlbum2
 * Es un label con la función de pulsar y contiene la imagen del álbum que se va a mostrar en SeleccionContAlbum().
 * @param lblTextoAlbum2
 * Tiene el texto del nombre del álbum correspondiendo con el label (lbl_IMGAlbum2).
 * @param lbl_IMGAlbum3
 * Es un label con la función de pulsar y contiene la imagen del álbum que se va a mostrar en SeleccionContAlbum().
 * @param lblTextoAlbum3
 * Tiene el texto del nombre del álbum correspondiendo con el label (lbl_IMGAlbum3).
 * @param lbl_IMGAlbum4
 * Es un label con la función de pulsar y contiene la imagen del álbum que se va a mostrar en SeleccionContAlbum().
 *  @param lblTextoAlbum4
 *  Tiene el texto del nombre del álbum correspondiendo con el label (lbl_IMGAlbum4).
 * @param lbl_IMGAlbum5 
 * Es un label con la función de pulsar y contiene la imagen del álbum que se va a mostrar en SeleccionContAlbum().
 * @param lblTextoAlbum5
 * Tiene el texto del nombre del álbum correspondiendo con el label (lbl_IMGAlbum5).
 * @param lbl_Albumes
 * Tiene el título con el texto del álbumes (Estético).
 * @param lbl_CancionesMasEscuchadas
 * Tiene el título con el texto de canciones más escuchadas (Estético).
 * @author TRILOGY. Miembros: Adrián Leal Vacas, Gonzalo Amo Cano y Raúl Senso Montojo.
 */
public class Cristal_Basic2 extends JFrame {
	/**
	 * Es la versión número 2 de la página de la membresia Cristal Basic 2.
	 */
	private static final long serialVersionUID = 1L;
	// ----------------------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------------------
	private JPanel contentPane;
	private JButton btn_Recarga_Canciones;
	private JButton btn_Recarga_Canciones2;
	private JLabel lbl_IMGCancion1;
	private JLabel lblTextoCancion1;
	private JLabel lbl_IMGCancion2;
	private JLabel lblTextoCancion2;
	private JLabel lbl_IMGCancion3;
	private JLabel lblTextoCancion3;
	private JLabel lbl_IMGCancion4;
	private JLabel lblTextoCancion4;
	private JLabel lbl_IMGCancion5;
	private JLabel lblTextoCancion5;
	private JLabel lbl_IMGAlbum1;
	private JLabel lblTextoAlbum1;
	private JLabel lbl_IMGAlbum2;
	private JLabel lblTextoAlbum2;
	private JLabel lbl_IMGAlbum3;
	private JLabel lblTextoAlbum3;
	private JLabel lbl_IMGAlbum4;
	private JLabel lbl_IMGAlbum5;
	private JLabel lblTextoAlbum5;
	private JLabel lblTextoAlbum4;
	private JLabel lbl_Albumes;
	private JLabel lbl_CancionesMasEscuchadas;
	private JLabel lblFondo_Cristal;
	private JPanel Panel_CristalBasic;
	public static String ruta_album;
	public static int contador1_1=0;
	public static int contador1_2=0;
	private static int num_cancion=0;
	private static int num_album=0;
	private static int num_album_enlace1=0;
	private static int num_album_enlace2=0;
	private static int num_album_enlace3=0;
	private static int num_album_enlace4=0;
	private static int num_album_enlace5=0;
	// ----------------------------------------------------------------------------------------
	// GETTERS AND SETTERS
	// ----------------------------------------------------------------------------------------
	public JPanel getPanel_CristalBasic() {
		return Panel_CristalBasic;
	}
	public void setPanel_CristalBasic(JPanel panel_CristalBasic) {
		Panel_CristalBasic = panel_CristalBasic;
	}
	// MÉTODO MAIN
	// ----------------------------------------------------------------------------------------
	/**
	 * En el método main ejecutamos la ventana principal Cristal_Basic2.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cristal_Basic2 frame = new Cristal_Basic2();
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
	 * En el constructor Cristal_Basic2() están todos los atributos y métodos necesarios para cuando creemos el objeto tenga todas las funcionalidades.
	 */
	public Cristal_Basic2() {
		// ----------------------------------------------------------------------------------------
		// contentPane CONTIENE TODOS LOS ATRIBUTOS DE LA PÁGINA
		// ----------------------------------------------------------------------------------------
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 703);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// ----------------------------------------------------------------------------------------
		// Panel_CristalBasic CONTIENE TODOS LOS ATRIBUTOS PARA PODER INTERCAMBIAR PANELES SIN COMPLICACIÓN
		// ----------------------------------------------------------------------------------------
		Panel_CristalBasic = new JPanel();
		Panel_CristalBasic.setBounds(0, 0, 1130, 663);
		contentPane.add(Panel_CristalBasic);
		Panel_CristalBasic.setLayout(null);
		// ----------------------------------------------------------------------------------------
		//TÍTULOS DE TEXTO DE LO QUE TE MUESTRA
		// ----------------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------
		//lbl_CancionesMasEscuchadas TIENE EL TITULO DE LA CATEGORÍA DE LAS CANCIONES MÁS ESCUCHADAS
		// ----------------------------------------------------------------------------------------
		lbl_CancionesMasEscuchadas = new JLabel("CANCIONES MÁS ESCUCHADAS");
		lbl_CancionesMasEscuchadas.setOpaque(true);
		lbl_CancionesMasEscuchadas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CancionesMasEscuchadas.setFont(new Font("Tahoma", Font.BOLD, 14)); 
		lbl_CancionesMasEscuchadas.setBorder(new LineBorder(new Color(211, 211, 211)));
		lbl_CancionesMasEscuchadas.setBackground(new Color(204, 255, 204));
		lbl_CancionesMasEscuchadas.setBounds(180, 51, 888, 30);
		// ----------------------------------------------------------------------------------------
		//lbl_Albumes TIENE EL TITULO DE LA CATEGORÍA DE LOS ALBUMES QUE SE VAN A REPRODUCIR.
		// ----------------------------------------------------------------------------------------
		lbl_Albumes = new JLabel("ÁLBUMES MÁS EXSITOSOS\r\n");
		lbl_Albumes.setOpaque(true);
		lbl_Albumes.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Albumes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Albumes.setBorder(new LineBorder(new Color(211, 211, 211)));
		lbl_Albumes.setBackground(new Color(204, 255, 204));
		lbl_Albumes.setBounds(180, 345, 888, 30);
		// ----------------------------------------------------------------------------------------
		// ÁLBUMES
		// ----------------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------
		//lbl_IMGAlbum5 TIENE LA IMAGEN DEL ÁLBUM QUE SE QUIERE MOSTRAR.
		// ----------------------------------------------------------------------------------------
		lbl_IMGAlbum5 = new JLabel("");
		lbl_IMGAlbum5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(num_album_enlace5==0) {
					num_album=4;
					ruta_album=CatalogoAudiovisual.devolverRutaAlbum(num_album);
					SeleccionContAlbum prueba=new SeleccionContAlbum();
					prueba.setVisible(true);
				}else {
					ruta_album=CatalogoAudiovisual.devolverRutaAlbum(num_album_enlace5);
					SeleccionContAlbum prueba=new SeleccionContAlbum();
					prueba.setVisible(true);
				}
			}
		});
		lbl_IMGAlbum5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGAlbum5.setOpaque(true);
		lbl_IMGAlbum5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMGAlbum5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_IMGAlbum5.setBorder(new LineBorder(new Color(211,211,211)));
		lbl_IMGAlbum5.setBackground(new Color(255,255,255));
		lbl_IMGAlbum5.setBounds(881, 402, 142, 136);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon souceboyz = new ImageIcon(getClass().getResource("/Cristal_Basic/Portadas/SouceBoyz.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgsouceboyz = new ImageIcon(souceboyz.getImage().getScaledInstance(lbl_IMGAlbum5.getWidth(), lbl_IMGAlbum5.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		lbl_IMGAlbum5.setIcon(imgsouceboyz);
		// ----------------------------------------------------------------------------------------
		//lbl_IMGAlbum4 TIENE LA IMAGEN DEL ÁLBUM QUE SE QUIERE MOSTRAR.
		// ----------------------------------------------------------------------------------------
		lbl_IMGAlbum4 = new JLabel("");
		lbl_IMGAlbum4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(num_album_enlace4==0) {
					num_album=3;
					ruta_album=CatalogoAudiovisual.devolverRutaAlbum(num_album);
					SeleccionContAlbum prueba=new SeleccionContAlbum();
					prueba.setVisible(true);
				}else {
					ruta_album=CatalogoAudiovisual.devolverRutaAlbum(num_album_enlace4);
					SeleccionContAlbum prueba=new SeleccionContAlbum();
					prueba.setVisible(true);
				}
			}
		});
		lbl_IMGAlbum4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGAlbum4.setOpaque(true);
		lbl_IMGAlbum4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMGAlbum4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_IMGAlbum4.setBorder(new LineBorder(new Color(211,211,211)));
		lbl_IMGAlbum4.setBackground(new Color(255,255,255));
		lbl_IMGAlbum4.setBounds(719, 402, 142, 136);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon unverano = new ImageIcon(getClass().getResource("/Cristal_Basic/Portadas/Unveranosinti.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgunverano = new ImageIcon(unverano.getImage().getScaledInstance(lbl_IMGAlbum4.getWidth(), lbl_IMGAlbum4.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		lbl_IMGAlbum4.setIcon(imgunverano);
		// ----------------------------------------------------------------------------------------
		//lbl_IMGAlbum3 TIENE LA IMAGEN DEL ÁLBUM QUE SE QUIERE MOSTRAR.
		// ----------------------------------------------------------------------------------------
		lbl_IMGAlbum3 = new JLabel("");
		lbl_IMGAlbum3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(num_album_enlace3==0) {
					num_album=2;
					ruta_album=CatalogoAudiovisual.devolverRutaAlbum(num_album);
					SeleccionContAlbum prueba=new SeleccionContAlbum();
					prueba.setVisible(true);
				}else {
					ruta_album=CatalogoAudiovisual.devolverRutaAlbum(num_album_enlace3);
					SeleccionContAlbum prueba=new SeleccionContAlbum();
					prueba.setVisible(true);
				}
			}
		});
		lbl_IMGAlbum3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGAlbum3.setOpaque(true);
		lbl_IMGAlbum3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMGAlbum3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_IMGAlbum3.setBorder(new LineBorder(new Color(211,211,211)));
		lbl_IMGAlbum3.setBackground(new Color(255,255,255));
		lbl_IMGAlbum3.setBounds(557, 402, 142, 136);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon lykemike = new ImageIcon(getClass().getResource("/Cristal_Basic/Portadas/LykeMike.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imglikemike = new ImageIcon(lykemike.getImage().getScaledInstance(lbl_IMGAlbum3.getWidth(), lbl_IMGAlbum3.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		lbl_IMGAlbum3.setIcon(imglikemike);
		// ----------------------------------------------------------------------------------------
		//lbl_IMGAlbum2 TIENE LA IMAGEN DEL ÁLBUM QUE SE QUIERE MOSTRAR.
		// ----------------------------------------------------------------------------------------
		lbl_IMGAlbum2 = new JLabel("");
		lbl_IMGAlbum2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(num_album_enlace2==0) {
					num_album=1;
					ruta_album=CatalogoAudiovisual.devolverRutaAlbum(num_album);
					SeleccionContAlbum prueba=new SeleccionContAlbum();
					prueba.setVisible(true);
				}else {
					ruta_album=CatalogoAudiovisual.devolverRutaAlbum(num_album_enlace2);
					SeleccionContAlbum prueba=new SeleccionContAlbum();
					prueba.setVisible(true);
				}
			}
		});
		lbl_IMGAlbum2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGAlbum2.setOpaque(true);
		lbl_IMGAlbum2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMGAlbum2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_IMGAlbum2.setBorder(new LineBorder(new Color(211,211,211)));
		lbl_IMGAlbum2.setBackground(new Color(255,255,255));
		lbl_IMGAlbum2.setBounds(394, 402, 142, 136);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon paraiso = new ImageIcon(getClass().getResource("/Cristal_Basic/Portadas/Paraiso.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgparaiso = new ImageIcon(paraiso.getImage().getScaledInstance(lbl_IMGAlbum2.getWidth(), lbl_IMGAlbum2.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		lbl_IMGAlbum2.setIcon(imgparaiso);
		// ----------------------------------------------------------------------------------------
		//lbl_IMGAlbum1 TIENE LA IMAGEN DEL ÁLBUM QUE SE QUIERE MOSTRAR.
		// ----------------------------------------------------------------------------------------
		lbl_IMGAlbum1 = new JLabel("");
		lbl_IMGAlbum1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(num_album_enlace1==0) {
					num_album=0;
					ruta_album=CatalogoAudiovisual.devolverRutaAlbum(num_album);
					SeleccionContAlbum prueba=new SeleccionContAlbum();
					prueba.setVisible(true);
				}else {
					ruta_album=CatalogoAudiovisual.devolverRutaAlbum(num_album_enlace1);
					SeleccionContAlbum prueba=new SeleccionContAlbum();
					prueba.setVisible(true);
				}
			}
		});
		lbl_IMGAlbum1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGAlbum1.setOpaque(true);
		lbl_IMGAlbum1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMGAlbum1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_IMGAlbum1.setBorder(new LineBorder(new Color(211,211,211)));
		lbl_IMGAlbum1.setBackground(new Color(255,255,255));
		lbl_IMGAlbum1.setBounds(231, 402, 142, 136);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon dondequieroestar = new ImageIcon(getClass().getResource("/Cristal_Basic/Portadas/dondequieroestar.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgdondequieroestar = new ImageIcon(dondequieroestar.getImage().getScaledInstance(lbl_IMGAlbum1.getWidth(), lbl_IMGAlbum1.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		lbl_IMGAlbum1.setIcon(imgdondequieroestar);
		// ----------------------------------------------------------------------------------------
		// CANCIONES
		// ----------------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------
		//lbl_IMGCancion5 TIENE LA IMAGEN DE LA CANCIÓN QUE SE VA A REPRODUCIR.
		// ----------------------------------------------------------------------------------------
		lbl_IMGCancion5 = new JLabel("");
		lbl_IMGCancion5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA CANCIÓN EN EL REPRODUCTOR POR DEFECTO DE TU ORDENADOR
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl_IMGCancion5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGCancion5.setOpaque(true);
		lbl_IMGCancion5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMGCancion5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_IMGCancion5.setBorder(new LineBorder(new Color(211,211,211)));
		lbl_IMGCancion5.setBackground(new Color(255,255,255));
		lbl_IMGCancion5.setBounds(881, 115, 142, 136);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGCancion5.setIcon(CatalogoAudiovisual.obtenerImagenMusica(4,lbl_IMGCancion5.getWidth(),lbl_IMGCancion5.getHeight()));
		// ----------------------------------------------------------------------------------------
		//lbl_IMGCancion4 TIENE LA IMAGEN DE LA CANCIÓN QUE SE VA A REPRODUCIR.
		// ----------------------------------------------------------------------------------------
		lbl_IMGCancion4 = new JLabel("");
		lbl_IMGCancion4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA CANCIÓN EN EL REPRODUCTOR POR DEFECTO DE TU ORDENADOR
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl_IMGCancion4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGCancion4.setOpaque(true);
		lbl_IMGCancion4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMGCancion4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_IMGCancion4.setBorder(new LineBorder(new Color(211,211,211)));
		lbl_IMGCancion4.setBackground(new Color(255,255,255));
		lbl_IMGCancion4.setBounds(719, 115, 142, 136);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGCancion4.setIcon(CatalogoAudiovisual.obtenerImagenMusica(3,lbl_IMGCancion4.getWidth(),lbl_IMGCancion4.getHeight()));
		// ----------------------------------------------------------------------------------------
		//lbl_IMGCancion3 TIENE LA IMAGEN DE LA CANCIÓN QUE SE VA A REPRODUCIR.
		// ----------------------------------------------------------------------------------------
		lbl_IMGCancion3 = new JLabel("");
		lbl_IMGCancion3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA CANCIÓN EN EL REPRODUCTOR POR DEFECTO DE TU ORDENADOR
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl_IMGCancion3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGCancion3.setOpaque(true);
		lbl_IMGCancion3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMGCancion3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_IMGCancion3.setBorder(new LineBorder(new Color(211,211,211)));
		lbl_IMGCancion3.setBackground(new Color(255,255,255));
		lbl_IMGCancion3.setBounds(557, 115, 142, 136);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGCancion3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(2,lbl_IMGCancion3.getWidth(),lbl_IMGCancion3.getHeight()));	
		// ----------------------------------------------------------------------------------------
		//lbl_IMGCancion2 TIENE LA IMAGEN DE LA CANCIÓN QUE SE VA A REPRODUCIR.
		// ----------------------------------------------------------------------------------------
		lbl_IMGCancion2 = new JLabel("");
		lbl_IMGCancion2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path);// ABRE LA CANCIÓN EN EL REPRODUCTOR POR DEFECTO DE TU ORDENADOR
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl_IMGCancion2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGCancion2.setOpaque(true);
		lbl_IMGCancion2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMGCancion2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_IMGCancion2.setBorder(new LineBorder(new Color(211,211,211)));
		lbl_IMGCancion2.setBackground(new Color(255,255,255));
		lbl_IMGCancion2.setBounds(394, 115, 142, 136);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGCancion2.setIcon(CatalogoAudiovisual.obtenerImagenMusica(1,lbl_IMGCancion2.getWidth(),lbl_IMGCancion2.getHeight()));
		// ----------------------------------------------------------------------------------------
		//lbl_IMGCancion1 TIENE LA IMAGEN DE LA CANCIÓN QUE SE VA A REPRODUCIR.
		// ----------------------------------------------------------------------------------------
		lbl_IMGCancion1 = new JLabel("");
		lbl_IMGCancion1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File path = new File ("./src/Trilogy_imagenes/ROSALÍA _DESPECHÁ.mp3");
				try {
					Desktop.getDesktop().open(path); // ABRE LA CANCIÓN EN EL REPRODUCTOR POR DEFECTO DE TU ORDENADOR
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lbl_IMGCancion1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGCancion1.setOpaque(true);
		lbl_IMGCancion1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMGCancion1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_IMGCancion1.setBorder(new LineBorder(new Color(211,211,211)));
		lbl_IMGCancion1.setBackground(new Color(255,255,255));
		lbl_IMGCancion1.setBounds(231, 115, 142, 136);
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGCancion1.setIcon(CatalogoAudiovisual.obtenerImagenMusica(0,lbl_IMGCancion1.getWidth(),lbl_IMGCancion1.getHeight()));
		// ----------------------------------------------------------------------------------------
		//btn_Recarga_Canciones2 CAMBIA LOS ÁLBUMES MÁS EXITOSOS
		// ----------------------------------------------------------------------------------------
		contador1_2=0;
		btn_Recarga_Canciones2 = new JButton("");
		btn_Recarga_Canciones2.addMouseListener(new MouseAdapter() {
			@Override
			//CUANDO PASAS EL RATÓN POR ENCIMA
			public void mouseEntered(MouseEvent e) {
				btn_Recarga_Canciones2.setContentAreaFilled(true);
				btn_Recarga_Canciones2.setBackground(new Color(150, 150, 200, 160));
			}
			@Override
			//CUANDO EL RATÓN SALE DEL ÁREA DEL BOTÓN
			public void mouseExited(MouseEvent e) {
				btn_Recarga_Canciones2.setContentAreaFilled(false);
			}
			@Override
			//CUANDO PULSAS
			public void mouseClicked(MouseEvent e) {
				//INCREMENTO DEL CONTADOR CADA VEZ QUE SE PULSA
				contador1_2+=1;
				if(contador1_2==1) {
					num_album=5;
					//1
					lbl_IMGAlbum1.setVisible(false);
					lbl_IMGAlbum1.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum1.getWidth(),lbl_IMGAlbum1.getHeight()));
					lbl_IMGAlbum1.setVisible(true);
					num_album_enlace1=num_album;
					num_album++;
					//2
					lbl_IMGAlbum2.setVisible(false);
					lbl_IMGAlbum2.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum2.getWidth(),lbl_IMGAlbum2.getHeight()));
					lbl_IMGAlbum2.setVisible(true);
					num_album_enlace2=num_album;
					num_album++;
					//3
					lbl_IMGAlbum3.setVisible(false);
					lbl_IMGAlbum3.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum3.getWidth(),lbl_IMGAlbum3.getHeight()));
					lbl_IMGAlbum3.setVisible(true);
					num_album_enlace3=num_album;
					num_album++;
					//4
					lbl_IMGAlbum4.setVisible(false);
					lbl_IMGAlbum4.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum4.getWidth(),lbl_IMGAlbum4.getHeight()));
					lbl_IMGAlbum4.setVisible(true);
					num_album_enlace4=num_album;
					num_album++;
					//5
					lbl_IMGAlbum5.setVisible(false);
					lbl_IMGAlbum5.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum5.getWidth(),lbl_IMGAlbum5.getHeight()));
					lbl_IMGAlbum5.setVisible(true);
					num_album_enlace5=num_album;
					num_album++;
				}else if(contador1_2==2) {
					num_album=10;
					//1
					lbl_IMGAlbum1.setVisible(false);
					lbl_IMGAlbum1.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum1.getWidth(),lbl_IMGAlbum1.getHeight()));
					lbl_IMGAlbum1.setVisible(true);
					num_album_enlace1=num_album;
					num_album++;
					//2
					lbl_IMGAlbum2.setVisible(false);
					lbl_IMGAlbum2.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum2.getWidth(),lbl_IMGAlbum2.getHeight()));
					lbl_IMGAlbum2.setVisible(true);
					num_album_enlace2=num_album;
					num_album++;
					//3
					lbl_IMGAlbum3.setVisible(false);
					lbl_IMGAlbum3.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum3.getWidth(),lbl_IMGAlbum3.getHeight()));
					lbl_IMGAlbum3.setVisible(true);
					num_album_enlace3=num_album;
					num_album++;
					//4
					lbl_IMGAlbum4.setVisible(false);
					lbl_IMGAlbum4.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum4.getWidth(),lbl_IMGAlbum4.getHeight()));
					lbl_IMGAlbum4.setVisible(true);
					num_album_enlace4=num_album;
					num_album++;
					//5
					lbl_IMGAlbum5.setVisible(false);
					lbl_IMGAlbum5.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum5.getWidth(),lbl_IMGAlbum5.getHeight()));
					lbl_IMGAlbum5.setVisible(true);
					num_album_enlace5=num_album;
					num_album++;
				}else {
					//REINICIO CONTADOR
					contador1_2=0;
					num_album=0;
					//1
					lbl_IMGAlbum1.setVisible(false);
					lbl_IMGAlbum1.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum1.getWidth(),lbl_IMGAlbum1.getHeight()));
					lbl_IMGAlbum1.setVisible(true);
					num_album_enlace1=num_album;
					num_album++;
					//2
					lbl_IMGAlbum2.setVisible(false);
					lbl_IMGAlbum2.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum2.getWidth(),lbl_IMGAlbum2.getHeight()));
					lbl_IMGAlbum2.setVisible(true);
					num_album_enlace2=num_album;
					num_album++;
					//3
					lbl_IMGAlbum3.setVisible(false);
					lbl_IMGAlbum3.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum3.getWidth(),lbl_IMGAlbum3.getHeight()));
					lbl_IMGAlbum3.setVisible(true);
					num_album_enlace3=num_album;
					num_album++;
					//4
					lbl_IMGAlbum4.setVisible(false);
					lbl_IMGAlbum4.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum4.getWidth(),lbl_IMGAlbum4.getHeight()));
					lbl_IMGAlbum4.setVisible(true);
					num_album_enlace4=num_album;
					num_album++;
					//5
					lbl_IMGAlbum5.setVisible(false);
					lbl_IMGAlbum5.setIcon(CatalogoAudiovisual.obtenerImagenAlbum(num_album,lbl_IMGAlbum5.getWidth(),lbl_IMGAlbum5.getHeight()));
					lbl_IMGAlbum5.setVisible(true);
					num_album_enlace5=num_album;
					num_album++;
				}
			}
		});
		btn_Recarga_Canciones2.setBorderPainted(false);
		btn_Recarga_Canciones2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Recarga_Canciones2.setContentAreaFilled(false);
		btn_Recarga_Canciones2.setBounds(57, 449, 50, 50);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon FlechaVerde2 = new ImageIcon(getClass().getResource("/Trilogy_imagenes/actualizacion.png"));// DIRECCION DE LA IMAGEN QUE QUIERO AJUSTAR
		ImageIcon imgRecarga_Series2 = new ImageIcon(FlechaVerde2.getImage().getScaledInstance(btn_Recarga_Canciones2.getWidth(), btn_Recarga_Canciones2.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		btn_Recarga_Canciones2.setIcon(imgRecarga_Series2);
		// ----------------------------------------------------------------------------------------
		//btn_Recarga_Canciones CAMBIA LAS CANCIONES MÁS ESCUCHADAS
		// ----------------------------------------------------------------------------------------
		contador1_1=0;
		btn_Recarga_Canciones = new JButton("");
		btn_Recarga_Canciones.addMouseListener(new MouseAdapter() {
			@Override
			//CUANDO PASAS EL RATÓN POR ENCIMA
			public void mouseEntered(MouseEvent e) {
				btn_Recarga_Canciones.setContentAreaFilled(true);
				btn_Recarga_Canciones.setBackground(new Color(150, 150, 200, 160));
			}
			@Override
			//CUANDO EL RATÓN NO ESTÁ PASANDO POR ENCIMA
			public void mouseExited(MouseEvent e) {
				btn_Recarga_Canciones.setContentAreaFilled(false);
			}
			@Override
			//CUANDO PULSAS
			public void mouseClicked(MouseEvent e) {
				//INCREMENTO CONTADOR CADA VEZ QUE PULSAS
				contador1_1+=1;
				if(contador1_1==1) {
					num_cancion=5;
					//1
					lbl_IMGCancion1.setVisible(false);
					lbl_IMGCancion1.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion1.getWidth(),lbl_IMGCancion1.getHeight()));
					lbl_IMGCancion1.setVisible(true);
					num_cancion++;
					//2
					lbl_IMGCancion2.setVisible(false);
					lbl_IMGCancion2.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion2.getWidth(),lbl_IMGCancion2.getHeight()));
					lbl_IMGCancion2.setVisible(true);
					num_cancion++;
					//3
					lbl_IMGCancion3.setVisible(false);
					lbl_IMGCancion3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion3.getWidth(),lbl_IMGCancion3.getHeight()));
					lbl_IMGCancion3.setVisible(true);
					num_cancion++;
					//4
					lbl_IMGCancion4.setVisible(false);
					lbl_IMGCancion4.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion4.getWidth(),lbl_IMGCancion4.getHeight()));
					lbl_IMGCancion4.setVisible(true);
					num_cancion++;
					//5
					lbl_IMGCancion5.setVisible(false);
					lbl_IMGCancion5.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion5.getWidth(),lbl_IMGCancion5.getHeight()));
					lbl_IMGCancion5.setVisible(true);
					num_cancion++;
				}
				else if(contador1_1==2) {
					num_cancion=10;
					//1
					lbl_IMGCancion1.setVisible(false);
					lbl_IMGCancion1.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion1.getWidth(),lbl_IMGCancion1.getHeight()));
					lbl_IMGCancion1.setVisible(true);
					num_cancion++;
					//2
					lbl_IMGCancion2.setVisible(false);
					lbl_IMGCancion2.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion2.getWidth(),lbl_IMGCancion2.getHeight()));
					lbl_IMGCancion2.setVisible(true);
					num_cancion++;
					//3
					lbl_IMGCancion3.setVisible(false);
					lbl_IMGCancion3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion3.getWidth(),lbl_IMGCancion3.getHeight()));
					lbl_IMGCancion3.setVisible(true);
					num_cancion++;
					//4
					lbl_IMGCancion4.setVisible(false);
					lbl_IMGCancion4.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion4.getWidth(),lbl_IMGCancion4.getHeight()));
					lbl_IMGCancion4.setVisible(true);
					num_cancion++;
					//5
					lbl_IMGCancion5.setVisible(false);
					lbl_IMGCancion5.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion5.getWidth(),lbl_IMGCancion5.getHeight()));
					lbl_IMGCancion5.setVisible(true);
					num_cancion++;	
				}else {
					// REINICIO DEL CONTADOR
					contador1_1=0;
					num_cancion=0;
					//1
					lbl_IMGCancion1.setVisible(false);
					lbl_IMGCancion1.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion1.getWidth(),lbl_IMGCancion1.getHeight()));
					lbl_IMGCancion1.setVisible(true);
					num_cancion++;
					//2
					lbl_IMGCancion2.setVisible(false);
					lbl_IMGCancion2.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion2.getWidth(),lbl_IMGCancion2.getHeight()));
					lbl_IMGCancion2.setVisible(true);
					num_cancion++;
					//3
					lbl_IMGCancion3.setVisible(false);
					lbl_IMGCancion3.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion3.getWidth(),lbl_IMGCancion3.getHeight()));
					lbl_IMGCancion3.setVisible(true);
					num_cancion++;
					//4
					lbl_IMGCancion4.setVisible(false);
					lbl_IMGCancion4.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion4.getWidth(),lbl_IMGCancion4.getHeight()));
					lbl_IMGCancion4.setVisible(true);
					num_cancion++;
					//5
					lbl_IMGCancion5.setVisible(false);
					lbl_IMGCancion5.setIcon(CatalogoAudiovisual.obtenerImagenMusica(num_cancion,lbl_IMGCancion5.getWidth(),lbl_IMGCancion5.getHeight()));
					lbl_IMGCancion5.setVisible(true);
					num_cancion++;	
				}
			}
		});
		btn_Recarga_Canciones.setBorderPainted(false);
		btn_Recarga_Canciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Recarga_Canciones.setContentAreaFilled(false);
		btn_Recarga_Canciones.setBounds(57, 157, 50, 50);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon FlechaVerde = new ImageIcon(getClass().getResource("/Trilogy_imagenes/actualizacion.png")); // DIRECCION DE LA IMAGEN QUE QUIERO AJUSTAR
		ImageIcon imgRecarga_Series = new ImageIcon(FlechaVerde.getImage().getScaledInstance(btn_Recarga_Canciones.getWidth(), btn_Recarga_Canciones.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		btn_Recarga_Canciones.setIcon(imgRecarga_Series);
		// ----------------------------------------------------------------------------------------
		//TEXTOS INFERIORES DE LAS CANCIONES Y ÁLBUMES
		// ----------------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------
		//lblTextoAlbum5 TIENE EL TEXTO DEL NOMBRE DEL ÁLBUM QUE SE QUIERE MOSTRAR.
		// ----------------------------------------------------------------------------------------
		lblTextoAlbum5 = new JLabel("SAUCE BOYZ");
		lblTextoAlbum5.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoAlbum5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTextoAlbum5.setBounds(881, 549, 142, 27);
		// ----------------------------------------------------------------------------------------
		//lblTextoAlbum4 TIENE EL TEXTO DEL NOMBRE DEL ÁLBUM QUE SE QUIERE MOSTRAR.
		// ----------------------------------------------------------------------------------------
		lblTextoAlbum4 = new JLabel("<html>UN VERANO<br><center> SIN TI");
		lblTextoAlbum4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoAlbum4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTextoAlbum4.setBounds(719, 549, 142, 27);
		// ----------------------------------------------------------------------------------------
		//lblTextoAlbum3 TIENE EL TEXTO DEL NOMBRE DEL ÁLBUM QUE SE QUIERE MOSTRAR.
		// ----------------------------------------------------------------------------------------
		lblTextoAlbum3 = new JLabel("LYKE MIKE");
		lblTextoAlbum3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoAlbum3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTextoAlbum3.setBounds(557, 549, 142, 27);
		// ----------------------------------------------------------------------------------------
		//lblTextoAlbum2 TIENE EL TEXTO DEL NOMBRE DEL ÁLBUM QUE SE QUIERE MOSTRAR.
		// ----------------------------------------------------------------------------------------
		lblTextoAlbum2 = new JLabel("PARAISO");
		lblTextoAlbum2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoAlbum2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTextoAlbum2.setBounds(394, 549, 142, 27);
		// ----------------------------------------------------------------------------------------
		//lblTextoAlbum1 TIENE EL TEXTO DEL NOMBRE DEL ÁLBUM QUE SE QUIERE MOSTRAR.
		// ----------------------------------------------------------------------------------------
		lblTextoAlbum1 = new JLabel("<html>DONDE QUIERO<br><center>ESTAR<br></html>" 
				, SwingConstants.CENTER);
		lblTextoAlbum1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoAlbum1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTextoAlbum1.setBounds(231, 549, 142, 27);
		// ----------------------------------------------------------------------------------------
		//lblTextoCancion5 TIENE EL TEXTO DEL NOMBRE DE LA CANCIÓN QUE SE VA A REPRODUCIR.
		// ----------------------------------------------------------------------------------------
		lblTextoCancion5 = new JLabel("CUPIDO");
		lblTextoCancion5.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoCancion5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTextoCancion5.setBounds(881, 262, 142, 27);
		// ----------------------------------------------------------------------------------------
		//lblTextoCancion4 TIENE EL TEXTO DEL NOMBRE DE LA CANCIÓN QUE SE VA A REPRODUCIR.
		// ----------------------------------------------------------------------------------------
		lblTextoCancion4 = new JLabel("TQG");
		lblTextoCancion4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoCancion4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTextoCancion4.setBounds(719, 262, 142, 27);
		// ----------------------------------------------------------------------------------------
		//lblTextoCancion3 TIENE EL TEXTO DEL NOMBRE DE LA CANCIÓN QUE SE VA A REPRODUCIR.
		// ----------------------------------------------------------------------------------------
		lblTextoCancion3 = new JLabel("LA INOCENTE");
		lblTextoCancion3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoCancion3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTextoCancion3.setBounds(557, 262, 142, 27);
		// ----------------------------------------------------------------------------------------
		//lblTextoCancion2 TIENE EL TEXTO DEL NOMBRE DE LA CANCIÓN QUE SE VA A REPRODUCIR.
		// ----------------------------------------------------------------------------------------
		lblTextoCancion2 = new JLabel("PLAYA DEL INGLÉS");
		lblTextoCancion2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoCancion2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTextoCancion2.setBounds(394, 262, 142, 30);
		// ----------------------------------------------------------------------------------------
		//lblTextoCancion1 TIENE EL TEXTO DEL NOMBRE DE LA CANCIÓN QUE SE VA A REPRODUCIR.
		// ----------------------------------------------------------------------------------------
		lblTextoCancion1 = new JLabel("DESPECHÁ");
		lblTextoCancion1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoCancion1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTextoCancion1.setBounds(231, 262, 142, 27);
		// ----------------------------------------------------------------------------------------
		//lblFondo_Cristal TIENE LA IMAGEN DE FONDO DE LA PÁGINA.
		// ----------------------------------------------------------------------------------------
		lblFondo_Cristal = new JLabel();
		ImageIcon fondo1 = new ImageIcon(getClass().getResource("/Trilogy_imagenes/Fondo_Cristal_Basic.jpg"));// DIRECCION DE LA IMAGEN QUE QUIERO AJUSTAR
		lblFondo_Cristal.setBounds(0, 0, 1130, 664);
		ImageIcon imgfondo = new ImageIcon(fondo1.getImage().getScaledInstance(lblFondo_Cristal.getWidth(), lblFondo_Cristal.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		lblFondo_Cristal.setIcon(imgfondo);
		// ----------------------------------------------------------------------------------------
		//JERARQUÍA DEL panel_contenedor
		// ----------------------------------------------------------------------------------------
		Panel_CristalBasic.add(lbl_CancionesMasEscuchadas);
		Panel_CristalBasic.add(lbl_Albumes);
		Panel_CristalBasic.add(lbl_IMGAlbum5);
		Panel_CristalBasic.add(lbl_IMGAlbum4);
		Panel_CristalBasic.add(lbl_IMGAlbum3);
		Panel_CristalBasic.add(lbl_IMGAlbum2);
		Panel_CristalBasic.add(lbl_IMGAlbum1);
		Panel_CristalBasic.add(lbl_IMGCancion5);
		Panel_CristalBasic.add(lbl_IMGCancion4);
		Panel_CristalBasic.add(lbl_IMGCancion3);
		Panel_CristalBasic.add(lbl_IMGCancion2);
		Panel_CristalBasic.add(lbl_IMGCancion1);
		Panel_CristalBasic.add(btn_Recarga_Canciones2);
		Panel_CristalBasic.add(btn_Recarga_Canciones);
		Panel_CristalBasic.add(lblTextoAlbum5);
		Panel_CristalBasic.add(lblTextoAlbum4);
		Panel_CristalBasic.add(lblTextoAlbum3);
		Panel_CristalBasic.add(lblTextoAlbum2);
		Panel_CristalBasic.add(lblTextoAlbum1);
		Panel_CristalBasic.add(lblTextoCancion5);
		Panel_CristalBasic.add(lblTextoCancion4);
		Panel_CristalBasic.add(lblTextoCancion3);
		Panel_CristalBasic.add(lblTextoCancion2);
		Panel_CristalBasic.add(lblTextoCancion1);
		Panel_CristalBasic.add(lblFondo_Cristal);
	}
}
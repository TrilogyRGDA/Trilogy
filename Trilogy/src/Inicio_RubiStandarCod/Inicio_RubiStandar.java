package Inicio_RubiStandarCod;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import cat_audiovisual.CatalogoAudiovisual;
import seleccion_pelicula.Seleccion_pelicula;

import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * En la página de Inicio Rubí Standar podrás consumir contenido audiovisual de películas y con un botón de recarga cambiará el contenido audiovisual.
 * Esta página tiene dos versiones, ya que el panel de la izquierda se puede reducir de tamaño para una mejor visualización del contenido.
 * @param contentPane 
 * Contiene todos los atributos de la página.
 * @param panel_contenedor 
 * Contiene todos los atributos para poder intercambiar paneles sin complicación.
 * @param lblFondo_Rojo 
 * Tiene la imagen del fondo característico de películas.(Estético).
 * @param lbl_LoMasNuevo 
 * Tiene el texto de -LO MÁS NUEVO-(Estético).
 * @param  lbl_TOP5
 * Tiene el texto de -TOP 5 ÚLTIMO MES-(Estético).
 * @param lbl_IMGpelícula1 
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMGpelícula2 
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMGpelícula3
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMGpelícula4 
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMGpelícula5 
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMGpelícula6 
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMGpelícula7 
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMGpelícula8 
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMGpelícula9
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param lbl_IMGpelícula10 
 * Es un label con la función de pulsar y contiene la imagen de la película que se va a reproducir.
 * @param btn_Recarga1
 * Botón que cambia el catalogo audiovisual de las películas de -LO MÁS NUEVO- para que puedas ver todo lo nuevo en películas.
 * @author TRILOGY. Miembros: Adrián Leal Vacas, Gonzalo Amo Cano y Raúl Senso Montojo.
 */
public class Inicio_RubiStandar extends JFrame {
	/**
	 * Es la versión número 1 de la página del contenido audiovisual del Inicio Rubí Standar
	 */
	private static final long serialVersionUID = 1L;
	// ----------------------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------------------
	private JPanel contentPane;
	private JPanel Panel_RubiStandar;
	private JLabel lbl_IMGPelicula1;
	private JLabel lbl_IMGPelicula2;
	private JLabel lbl_IMGPelicula3;
	private JLabel lbl_IMGPelicula4;
	private JLabel lbl_IMGPelicula5;
	private JLabel lbl_IMGPelicula6;
	private JLabel lbl_IMGPelicula7;
	private JLabel lbl_IMGPelicula8;
	private JLabel lbl_IMGPelicula9;
	private JLabel lbl_IMGPelicula10;
	private JLabel lbl_TOP5;
	private JLabel lbl_LoMasNuevo;
	private JButton btn_Recarga1;
	public static String ruta_peli;
	public static int contador=0;
	private static int num_peli=0;
	private static int num_peli_enlacep1=0;
	private static int num_peli_enlacep2=0;
	private static int num_peli_enlacep3=0;
	private static int num_peli_enlacep4=0;
	private static int num_peli_enlacep5=0;
	// ----------------------------------------------------------------------------------------
	// GETTERS AND SETTERS
	// ----------------------------------------------------------------------------------------
	public JPanel getPanel_RubiStandar() {
		return Panel_RubiStandar;
	}
	public void setPanel_RubiStandar(JPanel panel_RubiStandar) {
		Panel_RubiStandar = panel_RubiStandar;
	}
	// ----------------------------------------------------------------------------------------
	// MÉTODO MAIN
	// ----------------------------------------------------------------------------------------
	/**
	 * En el método main ejecutamos la ventana principal Inicio_RubiStandar.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio_RubiStandar frame = new Inicio_RubiStandar();
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
	 * En el constructor Inicio_RubiStandar() están todos los atributos y métodos necesarios para cuando creemos el objeto tenga todas las funcionalidades.
	 */
	public Inicio_RubiStandar() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 703);
		contentPane = new JPanel();
		//------------------------------------------------------------------------------------------------------------	
		//PANEL RUBÍ STANDAR
		//------------------------------------------------------------------------------------------------------------	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//------------------------------------------------------------------------------------------------------------	
		// PANEL ADMINISTRADOR
		//------------------------------------------------------------------------------------------------------------	
		Panel_RubiStandar = new JPanel();
		Panel_RubiStandar.setBounds(0, 0, 961, 664);
		contentPane.add(Panel_RubiStandar);
		Panel_RubiStandar.setLayout(null);
		//------------------------------------------------------------------------------------------------------------	
		//TÍTULOS PELÍCULAS
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
		// lbl_TOP10 TIENE EL TEXTO DE -TOP 5 ÚLTIMO MES-
		// ----------------------------------------------------------------------------------------
		lbl_TOP5 = new JLabel("TOP 5 ÚLTIMO MES");
		lbl_TOP5.setOpaque(true);
		lbl_TOP5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TOP5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_TOP5.setBorder(new LineBorder(new Color(211, 211, 211)));
		lbl_TOP5.setBackground(new Color(204, 255, 204));
		lbl_TOP5.setBounds(107, 362, 812, 30);		
		//------------------------------------------------------------------------------------------------------------	
		//PELÍCULAS
		//------------------------------------------------------------------------------------------------------------	
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGPelicula10 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------	
		lbl_IMGPelicula10 = new JLabel("");
		lbl_IMGPelicula10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGPelicula10.setBounds(767, 425, 142, 182);
		lbl_IMGPelicula10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ruta_peli=CatalogoAudiovisual.devolverRutaPeli(14);
				Seleccion_pelicula prueba = new Seleccion_pelicula();
				prueba.setVisible(true);
			}
		});
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGPelicula10.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(14,lbl_IMGPelicula10.getWidth(),lbl_IMGPelicula10.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGPelicula9 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------	
		lbl_IMGPelicula9 = new JLabel("");
		lbl_IMGPelicula9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGPelicula9.setBounds(605, 425, 142, 182);
		lbl_IMGPelicula9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ruta_peli=CatalogoAudiovisual.devolverRutaPeli(13);
				Seleccion_pelicula prueba = new Seleccion_pelicula();
				prueba.setVisible(true);
			}
		});
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGPelicula9.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(13,lbl_IMGPelicula9.getWidth(),lbl_IMGPelicula9.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGPelicula8 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------	
		lbl_IMGPelicula8 = new JLabel("");
		lbl_IMGPelicula8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGPelicula8.setBounds(443, 425, 142, 182);
		lbl_IMGPelicula8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ruta_peli=CatalogoAudiovisual.devolverRutaPeli(12);
				Seleccion_pelicula prueba = new Seleccion_pelicula();
				prueba.setVisible(true);
			}
		});
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGPelicula8.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(12,lbl_IMGPelicula8.getWidth(),lbl_IMGPelicula8.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGPelicula7 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------	
		lbl_IMGPelicula7 = new JLabel("");
		lbl_IMGPelicula7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGPelicula7.setBounds(280, 425, 142, 182);
		lbl_IMGPelicula7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ruta_peli=CatalogoAudiovisual.devolverRutaPeli(11);
				Seleccion_pelicula prueba = new Seleccion_pelicula();
				prueba.setVisible(true);
			}
		});
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGPelicula7.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(11,lbl_IMGPelicula7.getWidth(),lbl_IMGPelicula7.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGPelicula6 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------	
		lbl_IMGPelicula6 = new JLabel("");
		lbl_IMGPelicula6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGPelicula6.setBounds(117, 425, 142, 182);
		lbl_IMGPelicula6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ruta_peli=CatalogoAudiovisual.devolverRutaPeli(10);
				Seleccion_pelicula prueba = new Seleccion_pelicula();
				prueba.setVisible(true);
			}
		});
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGPelicula6.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(10,lbl_IMGPelicula6.getWidth(),lbl_IMGPelicula6.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGPelicula5 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------	
		lbl_IMGPelicula5 = new JLabel("");
		lbl_IMGPelicula5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGPelicula5.setBounds(767, 122, 142, 182);
		lbl_IMGPelicula5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_peli_enlacep5==0) {
					num_peli=4;
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				} else {
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli_enlacep5);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				}
			}
		});
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGPelicula5.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(4,lbl_IMGPelicula5.getWidth(),lbl_IMGPelicula5.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGPelicula4 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------	
		lbl_IMGPelicula4 = new JLabel("");
		lbl_IMGPelicula4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGPelicula4.setBounds(605, 122, 142, 182);
		lbl_IMGPelicula4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_peli_enlacep4==0) {
					num_peli=3;
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				} else {
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli_enlacep4);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				}
			}
		});
		lbl_IMGPelicula4.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(3,lbl_IMGPelicula4.getWidth(),lbl_IMGPelicula4.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGPelicula3 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------	
		lbl_IMGPelicula3 = new JLabel("");
		lbl_IMGPelicula3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGPelicula3.setBounds(443, 122, 142, 182);
		lbl_IMGPelicula3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_peli_enlacep3==0) {
					num_peli=2;
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				} else {
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli_enlacep3);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				}
			}
		});
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGPelicula3.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(2,lbl_IMGPelicula3.getWidth(),lbl_IMGPelicula3.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGPelicula2 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------	
		lbl_IMGPelicula2 = new JLabel("");
		lbl_IMGPelicula2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGPelicula2.setBounds(280, 122, 142, 182);
		lbl_IMGPelicula2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_peli_enlacep2==0) {
					num_peli=1;
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				} else {
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli_enlacep2);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				}
			}
		});
		lbl_IMGPelicula2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(1,lbl_IMGPelicula2.getWidth(),lbl_IMGPelicula2.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		//lbl_IMGPelicula1 TIENE LA IMAGEN DE LA PELÍCULA QUE SE VA A REPRODUCIR
		//------------------------------------------------------------------------------------------------------------	
		lbl_IMGPelicula1 = new JLabel("");
		lbl_IMGPelicula1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_IMGPelicula1.setBounds(117, 122, 142, 182);
		lbl_IMGPelicula1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (num_peli_enlacep1==0) {
					num_peli=0;
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				} else {
					ruta_peli=CatalogoAudiovisual.devolverRutaPeli(num_peli_enlacep1);
					Seleccion_pelicula prueba = new Seleccion_pelicula();
					prueba.setVisible(true);
				}
			}
		});
		// AJUSTAR IMAGEN AL CONTENIDO
		lbl_IMGPelicula1.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(0,lbl_IMGPelicula1.getWidth(),lbl_IMGPelicula1.getHeight()));
		//------------------------------------------------------------------------------------------------------------	
		// IMAGEN DE FONDO DE LA VENTANA RUBÍ STANDAR
		//------------------------------------------------------------------------------------------------------------		
		JLabel lblFondo_Rojo = new JLabel();
		ImageIcon fondo1 = new ImageIcon(getClass().getResource("/Trilogy_imagenes/Fondo_Rubi_Standar.jpg"));// DIRECCIÓN DE LA IMAGEN QUE QUIERO AJUSTAR
		lblFondo_Rojo.setBounds(0, 0, 961, 664);
		ImageIcon imgfondo = new ImageIcon(fondo1.getImage().getScaledInstance(lblFondo_Rojo.getWidth(), lblFondo_Rojo.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN AL LABEL
		lblFondo_Rojo.setIcon(imgfondo);
		//------------------------------------------------------------------------------------------------------------	
		// BOTONES DE ACTUALIZACIÓN DEL CONTENIDO
		//------------------------------------------------------------------------------------------------------------	
		//------------------------------------------------------------------------------------------------------------
		//btn_Recarga1 CAMBIA LAS PELÍCULAS DE -LO MÁS NUEVO-
		//------------------------------------------------------------------------------------------------------------	
		contador=0;
		btn_Recarga1 = new JButton("");
		btn_Recarga1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Recarga1.addMouseListener(new MouseAdapter() {
			@Override
			//CUANDO EL CURSOR PASA POR ENCIMA
			public void mouseEntered(MouseEvent e) {
				btn_Recarga1.setContentAreaFilled(true);
				btn_Recarga1.setBackground(new Color(255, 255, 255, 160));
			}
			//CUANDO EL CURSOR NO ESTA ENCIMA
			@Override
			public void mouseExited(MouseEvent e) {
				btn_Recarga1.setContentAreaFilled(false);
			}
			//CUANDO PULSAS EN EL BOTÓN
			@Override
			public void mouseClicked(MouseEvent e) {
				// INCREMENTO CONTADOR CADA VEZ QUE PULSAS
				contador+=1;
				if(contador==1) {
					num_peli=5;
					// lbl_IMG_Peli_1
					lbl_IMGPelicula1.setVisible(false);
					lbl_IMGPelicula1.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula1.getWidth(),lbl_IMGPelicula1.getHeight()));
					lbl_IMGPelicula1.setVisible(true);
					num_peli_enlacep1=num_peli;
					num_peli++;
					// lbl_IMG_Peli_2
					lbl_IMGPelicula2.setVisible(false);
					lbl_IMGPelicula2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula2.getWidth(),lbl_IMGPelicula2.getHeight()));
					lbl_IMGPelicula2.setVisible(true);
					num_peli_enlacep2=num_peli;
					num_peli++;
					// lbl_IMG_Peli_3
					lbl_IMGPelicula3.setVisible(false);
					lbl_IMGPelicula3.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula3.getWidth(),lbl_IMGPelicula3.getHeight()));
					lbl_IMGPelicula3.setVisible(true);
					num_peli_enlacep3=num_peli;
					num_peli++;
					// lbl_IMG_Peli_4
					lbl_IMGPelicula4.setVisible(false);
					lbl_IMGPelicula4.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula4.getWidth(),lbl_IMGPelicula4.getHeight()));
					lbl_IMGPelicula4.setVisible(true);
					num_peli_enlacep4=num_peli;
					num_peli++;
					// lbl_IMG_Peli_5
					lbl_IMGPelicula5.setVisible(false);
					lbl_IMGPelicula5.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula5.getWidth(),lbl_IMGPelicula5.getHeight()));
					lbl_IMGPelicula5.setVisible(true);
					num_peli_enlacep5=num_peli;
				} else if (contador==2) {
					num_peli=10;
					// lbl_IMG_Peli_1
					lbl_IMGPelicula1.setVisible(false);
					lbl_IMGPelicula1.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula1.getWidth(),lbl_IMGPelicula1.getHeight()));
					lbl_IMGPelicula1.setVisible(true);
					num_peli_enlacep1=num_peli;
					num_peli++;
					// lbl_IMG_Peli_2
					lbl_IMGPelicula2.setVisible(false);
					lbl_IMGPelicula2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula2.getWidth(),lbl_IMGPelicula2.getHeight()));
					lbl_IMGPelicula2.setVisible(true);
					num_peli_enlacep2=num_peli;
					num_peli++;
					// lbl_IMG_Peli_3
					lbl_IMGPelicula3.setVisible(false);
					lbl_IMGPelicula3.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula3.getWidth(),lbl_IMGPelicula3.getHeight()));
					lbl_IMGPelicula3.setVisible(true);
					num_peli_enlacep3=num_peli;
					num_peli++;
					// lbl_IMG_Peli_4
					lbl_IMGPelicula4.setVisible(false);
					lbl_IMGPelicula4.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula4.getWidth(),lbl_IMGPelicula4.getHeight()));
					lbl_IMGPelicula4.setVisible(true);
					num_peli_enlacep4=num_peli;
					num_peli++;
					// lbl_IMG_Peli_5
					lbl_IMGPelicula5.setVisible(false);
					lbl_IMGPelicula5.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula5.getWidth(),lbl_IMGPelicula5.getHeight()));
					lbl_IMGPelicula5.setVisible(true);
					num_peli_enlacep5=num_peli;
					num_peli++;
				} else {
					// REINICIO CONTADOR
					contador=0;
					num_peli=0;
					// lbl_IMG_Peli_1
					lbl_IMGPelicula1.setVisible(false);
					lbl_IMGPelicula1.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula1.getWidth(),lbl_IMGPelicula1.getHeight()));
					lbl_IMGPelicula1.setVisible(true);
					num_peli_enlacep1=num_peli;
					num_peli++;
					// lbl_IMG_Peli_2
					lbl_IMGPelicula2.setVisible(false);
					lbl_IMGPelicula2.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula2.getWidth(),lbl_IMGPelicula2.getHeight()));
					lbl_IMGPelicula2.setVisible(true);
					num_peli_enlacep2=num_peli;
					num_peli++;
					// lbl_IMG_Peli_3
					lbl_IMGPelicula3.setVisible(false);
					lbl_IMGPelicula3.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula3.getWidth(),lbl_IMGPelicula3.getHeight()));
					lbl_IMGPelicula3.setVisible(true);
					num_peli_enlacep3=num_peli;
					num_peli++;
					// lbl_IMG_Peli_4
					lbl_IMGPelicula4.setVisible(false);
					lbl_IMGPelicula4.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula4.getWidth(),lbl_IMGPelicula4.getHeight()));
					lbl_IMGPelicula4.setVisible(true);
					num_peli_enlacep4=num_peli;
					num_peli++;
					// lbl_IMG_Peli_5
					lbl_IMGPelicula5.setVisible(false);
					lbl_IMGPelicula5.setIcon(CatalogoAudiovisual.obtenerImagenPelicula(num_peli,lbl_IMGPelicula5.getWidth(),lbl_IMGPelicula5.getHeight()));
					lbl_IMGPelicula5.setVisible(true);
					num_peli_enlacep5=num_peli;
				}
			}
		});
		btn_Recarga1.setContentAreaFilled(false);
		btn_Recarga1.setBorderPainted(false);
		btn_Recarga1.setBounds(39, 180, 50, 50);
		// AJUSTAR IMAGEN AL CONTENIDO
		ImageIcon recarga1 = new ImageIcon(getClass().getResource("/Trilogy_imagenes/actualizacion.png")); // CREACIÓN NUEVO OBJETO CON LA RUTA DE LA IMAGEN
		ImageIcon imgRecarga1 = new ImageIcon(recarga1.getImage().getScaledInstance(btn_Recarga1.getWidth(), btn_Recarga1.getHeight(), Image.SCALE_SMOOTH)); // CREAMOS OTRO OBJETO PARA QUE SE AJUSTE AUTOMATICAMENTE LA IMAGEN
		btn_Recarga1.setIcon(imgRecarga1);
		//------------------------------------------------------------------------------------------------------------
		// JERARQUÍA DEL PANEL PRINCIPAL
		//------------------------------------------------------------------------------------------------------------
		Panel_RubiStandar.add(btn_Recarga1);
		Panel_RubiStandar.add(lbl_LoMasNuevo);
		Panel_RubiStandar.add(lbl_TOP5);
		Panel_RubiStandar.add(lbl_IMGPelicula10);
		Panel_RubiStandar.add(lbl_IMGPelicula9);
		Panel_RubiStandar.add(lbl_IMGPelicula8);
		Panel_RubiStandar.add(lbl_IMGPelicula7);
		Panel_RubiStandar.add(lbl_IMGPelicula6);
		Panel_RubiStandar.add(lbl_IMGPelicula5);
		Panel_RubiStandar.add(lbl_IMGPelicula4);
		Panel_RubiStandar.add(lbl_IMGPelicula3);
		Panel_RubiStandar.add(lbl_IMGPelicula2);
		Panel_RubiStandar.add(lbl_IMGPelicula1);
		Panel_RubiStandar.add(lblFondo_Rojo);
	}
}
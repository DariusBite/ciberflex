package vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class FrmReproductor extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String miniUrl = "videos/Rick.mp4";
	private String workingDir;
	private File f;
	private JFXPanel panel;
	private int id_c;
	private MediaPlayer mediaPlayer;
	private MediaView mediaView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReproductor frame = new FrmReproductor(miniUrl, 1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmReproductor(String url, int id) {
		Platform.setImplicitExit(false);
		if(url != null)	miniUrl = url;
		if(id !=0) id_c = id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 1280, 600);
		panel = new JFXPanel();
		
		workingDir = System.getProperty("user.dir");
		f = new File(workingDir, miniUrl);
		
		Media media = new Media(f.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaView = new MediaView(mediaPlayer);
        Group root = new Group();
        Scene scene = new Scene(root,1280,600);
        root.getChildren().add(mediaView);
        panel.setScene(scene);
        setContentPane(panel);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(1190, 10, 70, 23);
        panel.add(btnSalir);
        btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
	}
	
	void salir(){
		mediaPlayer.stop();
		mediaPlayer.dispose();
		mediaPlayer = null;
		remove(panel);
		FrmInfoContenido ic = new FrmInfoContenido(id_c);
		ic.setVisible(true);
		dispose();
	}

}

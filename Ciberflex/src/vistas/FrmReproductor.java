package vistas;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReproductor frame = new FrmReproductor(miniUrl);
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
	public FrmReproductor(String url) {
		if(url != null){
			miniUrl = url;
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 1280, 600);
		panel = new JFXPanel();
		
		workingDir = System.getProperty("user.dir");
		f = new File(workingDir, miniUrl);
		
		Media media = new Media(f.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView mediaView = new MediaView(mediaPlayer);
        Group root = new Group();
        Scene scene = new Scene(root,1280,600);
        root.getChildren().add(mediaView);
        panel.setScene(scene);
        setContentPane(panel);
	}

}

package vistas;

import java.io.File;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.Track;
import javafx.stage.Stage;

/**
 * A sample media player which loops indefinitely over the same video
 */
public class FrmVideoPlayer extends Application {
	public static String miniUrl = "videos/Rick.mp4";
	private String workingDir = System.getProperty("user.dir");
	private File f = new File(workingDir, miniUrl);

    public static void main(String[] args) {
    	launch(args);
    }

    @Override 
    public void start(Stage stage) {
        stage.setTitle("Media Player");

        // Create media player
        Media media = new Media(f.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);


        // Add media display node to the scene graph
        MediaView mediaView = new MediaView(mediaPlayer);
        Group root = new Group();
        Scene scene = new Scene(root,1280,600);
        root.getChildren().add(mediaView);
        stage.setScene(scene);
        stage.show();
    }
    
}
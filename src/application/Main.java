package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	// para expor a referência para a cena
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Instancia um novo objeto loader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml")); // na instanciação passamos o caminho da view
			
			ScrollPane scrollPane = loader.load();
			
			// Para ajustar o menu superior à janela
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			
			mainScene = new Scene(scrollPane);
			// primaryStage é o "palco" da cena
			primaryStage.setScene(mainScene); // seta como a cena principal
			primaryStage.setTitle("Department application");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Scene getMainScene() {
		return mainScene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

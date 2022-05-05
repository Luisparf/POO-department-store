package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.ProductService;
import java.awt.event.ActionEvent;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemFuncionario;
	@FXML
	private MenuItem menuItemProduto;
	@FXML
	private MenuItem menuItemAbout;
	
		
	
	@FXML	
	public void onMenuItemFuncionarioAction() {
		System.out.println("onMenuItemFuncionarioAction");
	}
	
	@FXML	
	public void onMenuItemProdutoAction() {
		loadView("/gui/ProductList.fxml", (ProductListController controller) -> {
			controller.setProductService(new ProductService());
			controller.updateTableView();
		}); // a��o de inicializa��o como par�metro
		System.out.println("onMenuItemProdutoAction");
	}
	

	@FXML	
	public void onMenuItemSobreAction() {
		loadView("/gui/About.fxml", x -> {});
		System.out.println("onMenuSobreAction");
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) { // m�todo da interface initializable
		// TODO Auto-generated method stub
		
	}
	
	private synchronized <T> void  loadView(String absoluteName, Consumer<T> initializingAction) { // passamos uma fun��o lambda para n�o termos que criar v�rias vers�es de loadview
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName)); 
			VBox newVBox = loader.load();
			
			// faz uma refer�ncia para a cena:
			Scene mainScene = Main.getMainScene();
			// VBox da janela principal
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent(); // getRoot() faz refer�ncia para o ScrollPane e faz casting para o mesmo tipo
																					// getContent() acessa o conte�do do scrollpane, no caso o VBox e faz casting para o mesmo tipo
			// guarda uma refer�ncia para o menu:
			Node mainMenu = mainVBox.getChildren().get(0);
			// limpa todos os filhos do mainVBox
			mainVBox.getChildren().clear();	
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren()); // adiciona uma cole��o, os 'filhos' de VBox
			
			// executam a fun��o passada como argumento:
			T controller = loader.getController();	
			initializingAction.accept(controller);
			
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erros loading view", e.getMessage(), AlertType.ERROR);
		}
		
	}

}

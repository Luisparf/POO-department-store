package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Product;

public class ProductListController implements Initializable {
	
	// referência para a tableView
	@FXML
	private TableView<Product> tableViewProduct;
	
	@FXML
	private TableColumn<Product, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Product, String> tableColumnName;

	@FXML
	private Button btNovo;
	
	@FXML 
	public void onBtNovoAction() {
		System.out.println("onBtnovoAction");
	}


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}


	// padrão do javaFX para inicializar as colunas
	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		// referência para o Stage atual
		Stage stage = (Stage) Main.getMainScene().getWindow();
		
		//faz com o que o tableView acompanhe o tamanho da janela
		tableViewProduct.prefHeightProperty().bind(stage.heightProperty());
	}

}

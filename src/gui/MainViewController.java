package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

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
		System.out.println("onMenuItemProdutoAction");
	}
	

	@FXML	
	public void onMenuItemAboutAction() {
		System.out.println("onMenuItemAboutAction");
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}

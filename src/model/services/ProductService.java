package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Product;

public class ProductService {

	private ProductDao dao  = DaoFactory.createProductDao();
	
	public List<Product> findAll(){
		return dao.findAll();
	}
	
	public void saveOrUpdate(Product obj) {
		if (obj.getId() == null) {
			dao.insert(obj); // se o objeto não esta cadastrado, insere
		}else {
			dao.update(obj); // se não, atualiza
		}
	}
}

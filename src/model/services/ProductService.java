package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Product;

public class ProductService {

	private ProductDao dao  = DaoFactory.createDepartmentDao();
	
	public List<Product> findAll(){
		return dao.findAll();
	}
}

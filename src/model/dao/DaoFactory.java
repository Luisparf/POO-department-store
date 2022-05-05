package model.dao;

import db.DB;
import model.dao.impl.ProductDaoJDBC;
import model.dao.impl.FuncionarioDaoJDBC;

public class DaoFactory {

	public static FuncionarioDao createSellerDao() {
		return new FuncionarioDaoJDBC(DB.getConnection());
	}
	
	public static ProductDao createDepartmentDao() {
		return new ProductDaoJDBC(DB.getConnection());
	}
}

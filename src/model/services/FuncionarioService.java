package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.FuncionarioDao;
import model.entities.Funcionario;

public class FuncionarioService {

	private FuncionarioDao dao  = DaoFactory.createFuncionarioDao();
	
	public List<Funcionario> findAll(){
		return dao.findAll();
	}
	
	public void saveOrUpdate(Funcionario obj) {
		if (obj.getId() == null) {
			dao.insert(obj); // se o objeto n�o esta cadastrado, insere
		}else {
			dao.update(obj); // se n�o, atualiza
		}
	}
	
	public void remove(Funcionario obj) {
		dao.deleteById(obj.getId());
	}
}

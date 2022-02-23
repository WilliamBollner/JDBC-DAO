package entidadesDao;

import java.util.List;

import entidades.Cliente;
import interfaces.interfaceDao;

public class DaoCliente implements interfaceDao<Cliente>{

	@Override
	public boolean salvar(Cliente t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Cliente t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente retornarUm(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> retornarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}

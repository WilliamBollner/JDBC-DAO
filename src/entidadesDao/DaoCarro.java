package entidadesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Carro;
import interfaces.interfaceDao;
import utils.Conexao;

public class DaoCarro implements interfaceDao<Carro> {

	@Override
	public boolean salvar(Carro t) {
		String sql = "insert into carro(placa, marca, modelo) values(?,?,?)";
		Connection con = Conexao.conectar();

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, t.getPlaca());
			stm.setString(2, t.getMarca());
			stm.setString(3, t.getModelo());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean update(Carro t) {
		String sql = "update carro set placa = ?, marca = ?, modelo = ?";
		sql += " where id = ?";
		Connection con = Conexao.conectar();

		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, t.getPlaca());
			stm.setString(2, t.getMarca());
			stm.setString(3, t.getModelo());
			stm.setInt(4, t.getId());
			
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean excluir(int id) {

		String sql = "delete from carro where id = " + id;
		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			stm.execute();
		} catch (Exception e) {
			System.out.println("houve erro " + e);
		}
		return true;
	}

	@Override
	public Carro retornarUm(int id) {
		String sql = "select * from carro where id = " + id;
		Carro carro = null;

		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				carro = new Carro(rs.getInt("id"), rs.getString("placa"), rs.getString("marca"),
						rs.getString("modelo"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar");
			e.printStackTrace();
		}
		return carro;
	}

	@Override
	public List<Carro> retornarTodos() {
		List<Carro> carro = new ArrayList<>();
		String sql = "select * from carro";
		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				carro.add(new Carro(rs.getInt("id"), rs.getString("placa"), rs.getString("placa"),
						rs.getString("modelo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carro;
	}
	
}

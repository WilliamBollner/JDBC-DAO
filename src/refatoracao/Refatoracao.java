package refatoracao;

import java.util.List;
import javax.swing.JOptionPane;
import entidades.Carro;
import entidadesDao.DaoCarro;
import utils.Conexao;

public class Refatoracao {

	public static void main(String[] args) {

	
		
		listarTodos();

	}

	static void consultarPeloId() {
		String id = JOptionPane.showInputDialog("Digite o ID que quer consultar: ");
		int idN = Integer.parseInt(id);
		Carro carro = new DaoCarro().retornarUm(idN);
		System.out.println(carro.getId());
		System.out.println(carro.getPlaca());
		System.out.println(carro.getMarca());
		System.out.println(carro.getModelo());
	}

	static void inserir() {

		DaoCarro dCarro = new DaoCarro();
		String escolha = JOptionPane.showInputDialog("Quer inserir um carro? \n 1 - Sim \n 2 - Não");
		if (escolha.charAt(0) == '1') {
			String placa = JOptionPane.showInputDialog("Digite a placa:");
			String marca = JOptionPane.showInputDialog("Digite o marca:");
			String modelo = JOptionPane.showInputDialog("Digite o modelo:");
			Carro carro = new Carro(placa, marca, modelo);
			if (dCarro.salvar(carro)) {
				System.out.println("Carro salvo com sucesso");
			} else {
				System.out.println("Erro ao salvar");
			}
		}
	}

	static void alterar() {
		String id = JOptionPane.showInputDialog("Digite o ID que quer alterar: ");
		int idN = Integer.parseInt(id);
		Carro carro = new DaoCarro().retornarUm(idN);
		String placa = JOptionPane.showInputDialog("Digite a placa:");
		String marca = JOptionPane.showInputDialog("Digite o marca:");
		String modelo = JOptionPane.showInputDialog("Digite o modelo:");
		carro = new Carro(placa, marca, modelo);
		if (new DaoCarro().update(carro)) {
			System.out.println("Carro salvo com sucesso");
		} else {
			System.out.println("Erro ao salvar");
		}
	}

	static void testeConexao() {
		if (Conexao.conectar() != null) {
			System.out.println("Conectado");
		} else {
			System.out.println("Erro ao conectar ao banco");
		}
	}

	static void deletarPeloId() {
		DaoCarro daoCarro = new DaoCarro();
		String id = JOptionPane.showInputDialog("Digite o ID que quer deletar: ");
		int idN = Integer.parseInt(id);
		if (daoCarro.excluir(idN)) {
			System.out.println("Excluido");
		}
	}

	static void listarTodos()	{
		List<Carro> carros = new DaoCarro().retornarTodos();
		for(Carro c : carros) {
			JOptionPane.showMessageDialog(null, c.toString());
			JOptionPane.OPTIONS_PROPERTY.charAt(0);
		}	
	
	}
}
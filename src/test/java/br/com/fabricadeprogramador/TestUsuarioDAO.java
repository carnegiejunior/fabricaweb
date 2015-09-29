package br.com.fabricadeprogramador;

import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {

		// testeCadastrar();
		// testeAlterar(4);
		testeExcluir(4);
	}

	private static void testeExcluir(Integer id) {
		// cria classe de usuário
		Usuario usu = new Usuario();
		usu.setId(id);

		// cria classe DAO para conexão com o banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);

		System.out.println("Alterado com sucesso!!!");
	}

	private static void testeAlterar(Integer id) {
		// cria classe de usuário
		Usuario usu = new Usuario();
		usu.setId(id);
		usu.setNome("Samantha Carnegie");
		usu.setLogin("sam");
		usu.setSenha("123");

		// cria classe DAO para conexão com o banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);

		System.out.println("Alterado com sucesso!!!");
	}

	private static void testeCadastrar() {
		// cria classe de usuário
		Usuario usu = new Usuario();
		usu.setNome("Samantha");
		usu.setLogin("sam");
		usu.setSenha("123");

		// cria classe DAO para conexão com o banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);

		System.out.println("Cadastrado com sucesso!!!");

	}
}
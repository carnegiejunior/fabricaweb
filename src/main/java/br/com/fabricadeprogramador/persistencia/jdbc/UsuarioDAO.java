package br.com.fabricadeprogramador.persistencia.jdbc;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection conn = ConexaoFactory.getConnection();
	
	public void cadastrar(Usuario usu) {
		
		String sql = "insert into usuarios(nome,login,senha) values(?,?,?)";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,usu.getNome());
			stmt.setString(2,usu.getLogin());
			stmt.setString(3,usu.getSenha());
			
			//executa comando sql no banco
			stmt.execute();

			//fechando o statment
			stmt.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void alterar(Usuario usu) {
		String sql = "update usuarios set nome=?, login=?,senha=? where id=?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1,usu.getNome());
			stmt.setString(2,usu.getLogin());
			stmt.setString(3,usu.getSenha());
			stmt.setInt(4,usu.getId());
			
			//executa comando sql no banco
			stmt.execute();
			

			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void excluir(Usuario usu) {
		String sql = "delete from usuarios where id=?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1,usu.getId());
			
			//executa comando sql no banco
			stmt.execute();
			

			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

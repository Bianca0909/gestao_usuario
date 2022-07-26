package br.com.devti.gestaousuario.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.devti.gestaousuario.core.bo.UsuarioBO;
import br.com.devti.gestaousuario.core.dao.connection.ConexaoMySQL;
import br.com.devti.gestaousuario.core.entity.UsuarioEntity;
import br.com.devti.gestaousuario.core.util.exception.NegocioException;

public class UsuarioDAO {

	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException{
						
 		String sql = "INSERT INTO usuario (nome_usuario, login_usuario, senha_usuario, email_usuario) VALUES (?,?,?,?)";
 		
 		PreparedStatement ps = null;
 		
 		try {
		    ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getEmail());
			
			ps.execute();
			
			
		} catch (SQLException e) {	
			e.printStackTrace();
			throw new NegocioException("Erro ao cadastrar usuario");
			
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	
		return "Usuario cadastrado com sucesso no banco de dados";
	}
	
	public List<UsuarioEntity> listarUsuario() throws NegocioException {
	 String sql = "SELECT id_usuario, nome_usuario, senha_usuario, email_usuario FROM USUARIO";
	PreparedStatement ps = null; // Comando a ser executado
 	ResultSet rs = null;	// Vai pegar o resultado do comando executado no DB
 	List<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();
 		try {
		    ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.execute();
			rs = ps.executeQuery();
			
			while(rs.next()) {    //next() -> Pegar resultado e transforma em obj
				UsuarioEntity usuario = new UsuarioEntity();
				usuario.setCodigo(rs.getLong("id_usuario"));
				usuario.setNome(rs.getString("nome_usuario"));
				usuario.setEmail(rs.getString("email_usuario"));
                                usuario.setLogin("login_usuario");
                usuario.setSenha(rs.getString("senha_usuario"));
                usuarios.add(usuario);
			}
			
		} catch (SQLException e) {	
 //  		e.printStackTrace();
			throw new NegocioException("Erro ao listar usuários");
			
		} finally {
			if(ps != null) {
				try {
					ps.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	
		return usuarios; //Retornando lista 
	
	};
	
}









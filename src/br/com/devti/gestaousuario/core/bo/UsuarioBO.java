package br.com.devti.gestaousuario.core.bo;

import java.util.List;

import br.com.devti.gestaousuario.core.dao.UsuarioDAO;
import br.com.devti.gestaousuario.core.entity.UsuarioEntity;
import br.com.devti.gestaousuario.core.util.exception.NegocioException;

public class UsuarioBO {

	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException {
	
		if(!usuario.getEmail().contains("@")) {
			throw new NegocioException("Email em formato inválido");
		}
		//TODO Poderia criptografar a senha
		//TODO Poderia validar o restante das informações
		
		if(usuario == null || usuario.getNome().equals("")) {
			throw new NegocioException("O nome do usuário precisa ser preenchido");
		}
		
		UsuarioDAO udao = new UsuarioDAO();		
		return udao.salvarUsuario(usuario);
	}
	public List<UsuarioEntity> listarUsuario() throws NegocioException {
		return new UsuarioDAO().listarUsuario();
	};
	
}

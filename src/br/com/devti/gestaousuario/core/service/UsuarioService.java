package br.com.devti.gestaousuario.core.service;

import java.util.List;

import br.com.devti.gestaousuario.core.bo.UsuarioBO;
import br.com.devti.gestaousuario.core.entity.UsuarioEntity;
import br.com.devti.gestaousuario.core.util.exception.NegocioException;

public class UsuarioService {

	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException {
	    UsuarioBO bo = new UsuarioBO();
	    return bo.salvarUsuario(usuario);
	}
	
	public List<UsuarioEntity> listarUsuario() throws NegocioException {
		return new UsuarioBO().listarUsuario();
	}
	
}

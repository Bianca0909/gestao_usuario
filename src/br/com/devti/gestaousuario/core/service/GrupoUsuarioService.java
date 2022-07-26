package br.com.devti.gestaousuario.core.service;

import br.com.devti.gestaousuario.core.bo.GrupoUsuarioBO;
import br.com.devti.gestaousuario.core.entity.GrupoUsuarioEntity;
import br.com.devti.gestaousuario.core.entity.UsuarioEntity;
import br.com.devti.gestaousuario.core.util.exception.NegocioException;

public class GrupoUsuarioService {

	public String salvarGrupoUsuario(GrupoUsuarioEntity grupoUsuario) throws NegocioException {
		GrupoUsuarioBO bo = new GrupoUsuarioBO();
		return bo.salvarGrupoUsuario(grupoUsuario);
	}
}

package br.com.devti.gestaousuario.core.bo;

import br.com.devti.gestaousuario.core.dao.GrupoUsuarioDAO;
import br.com.devti.gestaousuario.core.dao.UsuarioDAO;
import br.com.devti.gestaousuario.core.entity.GrupoUsuarioEntity;
import br.com.devti.gestaousuario.core.entity.UsuarioEntity;
import br.com.devti.gestaousuario.core.util.exception.NegocioException;

public class GrupoUsuarioBO {

	public String salvarGrupoUsuario(GrupoUsuarioEntity GrupoUsuario) throws NegocioException{
		if(GrupoUsuario == null || GrupoUsuario.getNomeGrupo().equals("")) {
			 throw new NegocioException("Nome nulo");
		}
	 GrupoUsuarioDAO grupoUserDao = new GrupoUsuarioDAO();
	 return grupoUserDao.salvarGrupoUsuario(GrupoUsuario);
	}
}

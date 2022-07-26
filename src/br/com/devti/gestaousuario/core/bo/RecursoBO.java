package br.com.devti.gestaousuario.core.bo;

import br.com.devti.gestaousuario.core.dao.GrupoUsuarioDAO;
import br.com.devti.gestaousuario.core.dao.RecursoDAO;
import br.com.devti.gestaousuario.core.entity.GrupoUsuarioEntity;
import br.com.devti.gestaousuario.core.entity.RecursoEntity;
import br.com.devti.gestaousuario.core.util.exception.NegocioException;

public class RecursoBO {

	public String salvarRecurso(RecursoEntity recurso) throws NegocioException{
		if(recurso.getNomeRecurso() == null || recurso.getNomeRecurso().equals("")) {
			 throw new NegocioException("Nome nulo");
		}
	 RecursoDAO recursoDao = new RecursoDAO();
	 return recursoDao.salvarRecurso(recurso);
	}
}

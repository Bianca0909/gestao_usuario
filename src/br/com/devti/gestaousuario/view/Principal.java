package br.com.devti.gestaousuario.view;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.devti.gestaousuario.core.entity.GrupoUsuarioEntity;
import br.com.devti.gestaousuario.core.entity.RecursoEntity;
import br.com.devti.gestaousuario.core.entity.UsuarioEntity;
import br.com.devti.gestaousuario.core.service.GrupoUsuarioService;
import br.com.devti.gestaousuario.core.service.RecursoService;
import br.com.devti.gestaousuario.core.service.UsuarioService;
import br.com.devti.gestaousuario.core.util.exception.NegocioException;

public class Principal {

	public static void main(String[] args) throws NegocioException {
		// Montando o objeto com as informações da tela
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setNome("Rogério");
		usuario.setLogin("rogerionj");
		usuario.setSenha("1234");
		usuario.setEmail("rogerionj@gmail.com");
		// Estou chamando meu CORE/Backend para salvar o usuario em questao
		UsuarioService us = new UsuarioService();
		try {
			JOptionPane.showMessageDialog(null, new UsuarioService().salvarUsuario(usuario));
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro());
		}
		GrupoUsuarioService guS = new GrupoUsuarioService();
		GrupoUsuarioEntity grupoUsuario = new GrupoUsuarioEntity();
		grupoUsuario.setNomeGrupo("Financeiro");

		try {
			JOptionPane.showMessageDialog(null, new GrupoUsuarioService().salvarGrupoUsuario(grupoUsuario));
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro());
		}

		RecursoService recursoS = new RecursoService();
		RecursoEntity recurso = new RecursoEntity();
		recurso.setNomeRecurso("Depósito");

		try {
			JOptionPane.showMessageDialog(null, new RecursoService().salvarRecurso(recurso));
		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro());
		}
		List<UsuarioEntity> usuarios = new UsuarioService().listarUsuario();
		for (UsuarioEntity usuarioEntity : usuarios) {
			System.out.println("Nome: " + usuarioEntity.getNome() + "/n Código: " + usuarioEntity.getCodigo());
		}
	}

}

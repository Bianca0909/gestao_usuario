package br.com.devti.gestaousuario.core.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.devti.gestaousuario.core.dao.connection.ConexaoMySQL;
import br.com.devti.gestaousuario.core.entity.GrupoUsuarioEntity;
import br.com.devti.gestaousuario.core.entity.UsuarioEntity;
import br.com.devti.gestaousuario.core.util.exception.NegocioException;

public class GrupoUsuarioDAO {

	public String salvarGrupoUsuario(GrupoUsuarioEntity grupoUsuario) throws NegocioException {

		String sql = "INSERT INTO grupo_usuario (nome_grupo) VALUES (?)";

		PreparedStatement ps = null;

		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, grupoUsuario.getNomeGrupo());

			ps.execute();

		} catch (SQLException e) {
          e.printStackTrace();
			throw new NegocioException("Erro ao cadastrar Grupo de usuario");

		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return "Grupo de usuário cadastrado com sucesso no banco de dados";
	}
}

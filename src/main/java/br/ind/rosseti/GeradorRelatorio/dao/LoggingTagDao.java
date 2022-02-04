package br.ind.rosseti.GeradorRelatorio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ind.rosseti.GeradorRelatorio.config.Configuracoes;
import br.ind.rosseti.GeradorRelatorio.model.IsegSegment;
import br.ind.rosseti.GeradorRelatorio.model.LoggingTag;

public class LoggingTagDao {

	private static List<LoggingTag> lista = new ArrayList<LoggingTag>();

	private Configuracoes conf;
	
	public LoggingTagDao() {
		carregaDados();
	}

	private void carregaDados() {
		try (

				Connection connection = DriverManager.getConnection("jdbc:sqlite:" + conf.CAMINHO_DB)) {

			// lendo os registros
			PreparedStatement stmt = connection.prepareStatement("select * from LoggingTag");
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				LoggingTag obj = new LoggingTag();
				obj.setFk_LogId(resultSet.getLong("fk_LogId"));
				obj.setLoggingTagId(resultSet.getLong("LoggingTagId"));
				obj.setNome(resultSet.getString("Name"));
				obj.setPk_Key(resultSet.getLong("pk_Key"));
				obj.setPk_StartTime(resultSet.getString("pk_StartTime"));
				obj.setTagElementId(resultSet.getLong("TagElementId"));
				obj.setTagObjectId(resultSet.getLong("TagObjectId"));

				lista.add(obj);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public List<LoggingTag> findAll() {
		return lista;
	}

	public void printAll() {

		for (LoggingTag obj : lista) {

			System.out.println(obj.toString());

		}

	}

	public LoggingTag findByPk_Key(int id) {

		for (LoggingTag obj : lista) {

			if (obj.getPk_Key() == id) {
				return obj;
			}

		}

		return null;

	}

	public LoggingTag findByIdLista(int id) {

		return lista.get(id);

	}

}

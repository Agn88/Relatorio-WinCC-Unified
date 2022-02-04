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

public  class IsegSegmentDao {

	private static List<IsegSegment> lista = new ArrayList<IsegSegment>();
	private Configuracoes conf;
	
	public IsegSegmentDao() {
		carregaDados();
	}

	private void carregaDados() {
		try (

				Connection connection = DriverManager.getConnection("jdbc:sqlite:" + conf.CAMINHO_DB)) {

			// lendo os registros
			PreparedStatement stmt = connection.prepareStatement("select * from iseg_segment");
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				IsegSegment obj = new IsegSegment();
				obj.setFk_StorageId(resultSet.getInt("fk_StorageId"));
				obj.setLeftBound(resultSet.getString("LeftBound"));
				obj.setRightBound(resultSet.getString("RightBound"));
				obj.setEstimatedEndTime(resultSet.getString("EstimatedEndTime"));
				obj.setLocation(resultSet.getString("Location"));
				obj.setName(resultSet.getString("Name"));
				obj.setStatus(resultSet.getString("Status"));

				lista.add(obj);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public List<IsegSegment> findAll() {
		return lista;
	}

	public void printAll() {

		for (IsegSegment obj : lista) {

			System.out.println(obj.toString());

		}

	}
	
	
	public IsegSegment findByIdLista(int id) {

		return lista.get(id);

	}

}

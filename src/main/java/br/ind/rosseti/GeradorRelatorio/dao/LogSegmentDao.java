package br.ind.rosseti.GeradorRelatorio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

import br.ind.rosseti.GeradorRelatorio.config.Configuracoes;
import br.ind.rosseti.GeradorRelatorio.model.IsegSegment;
import br.ind.rosseti.GeradorRelatorio.model.LogSegment;
import br.ind.rosseti.GeradorRelatorio.model.LoggingTag;

public class LogSegmentDao {

	private static List<LogSegment> lista = new ArrayList<LogSegment>();
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	

	public void carregaDados(IsegSegment isegSegment, LoggingTag loggingTag) {

		try (

				Connection connection = DriverManager.getConnection("jdbc:sqlite:"
						+ isegSegment.getLocation().replace("\\", "/") + "/" + isegSegment.getName() + ".db3")) {

			String query = "select value, quality, strftime('%Y-%m-%d %H:%M:%f',(((\"pk_TimeStamp\"/86400/1.0E+7)- 134774)*86400), 'unixepoch','localtime') AS UTC_TimeStamp from LoggedProcessValue AS LogSegment WHERE LogSegment.pk_fk_Id="
					+ loggingTag.getPk_Key();

			System.out.println("Query executada: " + query);

			// lendo os registros
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet resultSet = stmt.executeQuery();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			while (resultSet.next()) {

				Timestamp t = Timestamp.valueOf(resultSet.getString("UTC_TimeStamp")); // Convert instant to Timestamp
				Instant anotherInstant = t.toInstant(); // Convert Timestamp to Instant

				LogSegment obj = new LogSegment();
				obj.setName(loggingTag.getNome());
				obj.setQualityCode(resultSet.getLong("Quality"));
				obj.setUTC_TimeStamp(anotherInstant);
				obj.setValue(resultSet.getLong("value"));

				lista.add(obj);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public List<LogSegment> findAll() {
		return lista;
	}

	public void printAll() {

		for (LogSegment obj : lista) {

			System.out.println(obj.toString());

		}

	}

}

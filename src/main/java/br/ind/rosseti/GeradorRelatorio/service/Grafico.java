package br.ind.rosseti.GeradorRelatorio.service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.ind.rosseti.GeradorRelatorio.GeradorRelatorioApplication;
import br.ind.rosseti.GeradorRelatorio.model.IsegSegment;
import br.ind.rosseti.GeradorRelatorio.model.LoggingTag;


public class Grafico {
	
	public LinkedList<Map> criaJSONGrafico(String dataInicial, String dataFinal, LoggingTag loggingTag_01,
			LoggingTag loggingTag_02, LoggingTag loggingTag_03, LoggingTag loggingTag_04, LoggingTag loggingTag_05,
			LoggingTag loggingTag_06) {
		
		List<String> listaJson = new ArrayList<String>();
		
		continuar


		for(IsegSegment isegSegment : GeradorRelatorioApplication.isegSegmentDao.findAll()) {
			
						
			System.out.println(isegSegment.getLeftBound() + " - " + isegSegment.getRightBound());
			
		}
		
		
		//GeradorRelatorioApplication.logSegmentDao.carregaDados(null, loggingTag_01);
		//ArrayList<Map> mapas = new ArrayList<>();
		LinkedList<Map> mapas = new LinkedList<>();
		 
		char quotes ='"';
		

		Instant dataIni = null;
		Instant dataFin = null;
		try {
			dataIni = new SimpleDateFormat("yyyy-MM-dd").parse(dataInicial).toInstant();
			dataFin = new SimpleDateFormat("yyyy-MM-dd").parse(dataFinal).toInstant();
		} catch (Exception ex) {
			System.out.println(
					"Erro na conversäo da data para Instant em findAllByPicadorDate, ao filtrar busca de alarmes.");
		}

		
		String linhaCompleta = "";
		String Json = "" ; 
		int cont = 0;
		Instant controlaA=Instant.now(), controlaB=Instant.now();

		/*
		for (DadoPicador obj : repository.findAllByPicadorDate(id, dataIni, dataFin)) {

				
				
				Map<String, String> mapTeste = null;
				
				
				
				mapTeste = Map.ofEntries(
						//new AbstractMap.SimpleEntry<>("date", obj.getDatahoraConsulta().atZone(ZoneId.systemDefault()).toString()),
						new AbstractMap.SimpleEntry<>("id", "" + obj.getId()),
						new AbstractMap.SimpleEntry<>("date", obj.getDatahoraConsulta().atZone(ZoneId.systemDefault()).toString()),
						new AbstractMap.SimpleEntry<>("param_sel_01", "" + obj.getConsumoCombustivelAoDia()),
						new AbstractMap.SimpleEntry<>("param_sel_02", "" + obj.getConsumoCombustivelAoMes()),
						new AbstractMap.SimpleEntry<>("param_sel_03", "" + obj.getHorimetroMaquina()),
						new AbstractMap.SimpleEntry<>("param_sel_04", "" + obj.getHorimetroMotorNaLentaDiario()),
						new AbstractMap.SimpleEntry<>("param_sel_05", "" + obj.getHorimetroMotorNaLentaMensal()),
						new AbstractMap.SimpleEntry<>("param_sel_06", "" + obj.getHorimetroProducaoDiario())
						 
				);

				
				mapas.addLast(mapTeste);
			
			
		}
		*/
	
		
		String jsonCompleto = "";
		
		
		return mapas;
	}


}

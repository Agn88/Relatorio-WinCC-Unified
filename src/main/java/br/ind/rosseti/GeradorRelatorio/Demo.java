package br.ind.rosseti.GeradorRelatorio;

import br.ind.rosseti.GeradorRelatorio.dao.IsegSegmentDao;
import br.ind.rosseti.GeradorRelatorio.dao.LogSegmentDao;
import br.ind.rosseti.GeradorRelatorio.dao.LoggingTagDao;

public class Demo {

	static IsegSegmentDao isegSegmentDao = new IsegSegmentDao();	
	static LoggingTagDao loggingTagDao = new LoggingTagDao();	
	static LogSegmentDao logSegmentDao = new LogSegmentDao();
	
	private static void inicializaDados() {
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------");
		
		//isegSegmentDao.carregaDados();
		//isegSegmentDao.printAll();
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------");
		
		//loggingTagDao.carregaDados();
		//loggingTagDao.printAll();
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------");
		
		logSegmentDao.carregaDados(isegSegmentDao.findByIdLista(5), loggingTagDao.findByPk_Key(25));
		//logSegmentDao.printAll();
		
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------");
	}
	

	public static void main(String args[]) {
		
		System.out.println("Incializando!");
		
		inicializaDados();
		
		
	}
	
	
}

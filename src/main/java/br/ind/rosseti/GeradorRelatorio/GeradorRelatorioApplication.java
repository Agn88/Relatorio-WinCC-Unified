package br.ind.rosseti.GeradorRelatorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.ind.rosseti.GeradorRelatorio.dao.IsegSegmentDao;
import br.ind.rosseti.GeradorRelatorio.dao.LogSegmentDao;
import br.ind.rosseti.GeradorRelatorio.dao.LoggingTagDao;

@EnableCaching
@SpringBootApplication
@EnableScheduling
@RestController
@EnableWebMvc 
public class GeradorRelatorioApplication extends WebMvcConfigurerAdapter {
	
	@Autowired
	public static IsegSegmentDao isegSegmentDao = new IsegSegmentDao();
	
	@Autowired
	public static LoggingTagDao loggingTagDao = new LoggingTagDao();
	
	@Autowired
	public static LogSegmentDao logSegmentDao = new LogSegmentDao();

	private static void inicializaDados() {

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------");

		//isegSegmentDao.carregaDados();
		//isegSegmentDao.printAll();

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------");

		//loggingTagDao.carregaDados();
		//loggingTagDao.printAll();

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------");

		//logSegmentDao.carregaDados(isegSegmentDao.findByIdLista(5), loggingTagDao.findByPk_Key(25));
		// logSegmentDao.printAll();

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------");
	}
	
	

	public static void main(String[] args) {
		
		SpringApplication.run(GeradorRelatorioApplication.class, args);
		
		//inicializaDados();
		
	}
	
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }

}

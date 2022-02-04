package br.ind.rosseti.GeradorRelatorio.Controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.ind.rosseti.GeradorRelatorio.GeradorRelatorioApplication;
import br.ind.rosseti.GeradorRelatorio.dao.LoggingTagDao;
import br.ind.rosseti.GeradorRelatorio.model.LoggingTag;
import br.ind.rosseti.GeradorRelatorio.service.Grafico;

@Controller
@RequestMapping("/")
public class HomeController {
	
	
	LoggingTagDao loggingTagDao = GeradorRelatorioApplication.loggingTagDao;
	
	
	@GetMapping
	public String home(Model model) {
		
		
		model.addAttribute("loggingTag", loggingTagDao.findAll());
		
		
		model.addAttribute("param_sel_01", "");
		model.addAttribute("param_sel_02", "");
		model.addAttribute("param_sel_03", "");
		model.addAttribute("param_sel_04", "");
		model.addAttribute("param_sel_05", "");
		model.addAttribute("param_sel_06", "");
		
		/*
		for(LoggingTag obj : loggingTagDao.findAll()) {
			
			System.out.println(obj.getName());
		}
		*/
		
		return "home";
	}



	
	
	
	@RequestMapping(value = "filtrografico", method = RequestMethod.GET)
	public String getParamsGrafico(@RequestParam Map<String, String> params, Model model) {
		
		String dataInicial = "";
		String dataFinal = "";
		
		model.addAttribute("loggingTag", loggingTagDao.findAll());
		
		
		String param_sel_01="";
		String param_sel_02="";
		String param_sel_03="";
		String param_sel_04="";
		String param_sel_05="";
		String param_sel_06="";
		
		
		int i = 1;
		int contaSelecaoVariaveis = 0;
		for (String x : params.values()) {
			
			if (i == 0) {
				dataInicial = x;
			} else if (i == 1) {
				dataFinal = x;
			}else {
				
					//Captura as variáveis selecionadas e seta as mesmas para tratamento
					if(contaSelecaoVariaveis==1) {
						model.addAttribute("param_sel_01", x);
						param_sel_01=x;
					}
					if(contaSelecaoVariaveis==2) {
						model.addAttribute("param_sel_02", x);
						param_sel_02=x;
					}
					if(contaSelecaoVariaveis==3) {
						model.addAttribute("param_sel_03", x);
						param_sel_03=x;
					}
					if(contaSelecaoVariaveis==4) {
						model.addAttribute("param_sel_04", x);
						param_sel_04=x;
					}
					if(contaSelecaoVariaveis==5) {
						model.addAttribute("param_sel_05", x);
						param_sel_05=x;
					}
					if(contaSelecaoVariaveis==6) {
						model.addAttribute("param_sel_06", x);
						param_sel_06=x;
					}
				
				
				contaSelecaoVariaveis++;
				
			}
				
			i++;
		}
		
		
		model.addAttribute("paramDataInicial", dataInicial);
		model.addAttribute("paramDataFinal", dataFinal);
		
		
		LoggingTag loggingTag_01 = new LoggingTag();
		LoggingTag loggingTag_02 = new LoggingTag();
		LoggingTag loggingTag_03 = new LoggingTag();
		LoggingTag loggingTag_04 = new LoggingTag();
		LoggingTag loggingTag_05 = new LoggingTag();
		LoggingTag loggingTag_06 = new LoggingTag();
		
		Grafico graf = new Grafico();
		
		
		//Captura os objetos das variáveis selecionadas
		for(LoggingTag obj: loggingTagDao.findAll()) {
			
			if(obj.getNome().equals(param_sel_01)) {
				loggingTag_01 = obj; 
			}
			if(obj.getNome().equals(param_sel_02)) {
				loggingTag_02 = obj; 
			}
			if(obj.getNome().equals(param_sel_03)) {
				loggingTag_03 = obj; 
			}
			if(obj.getNome().equals(param_sel_04)) {
				loggingTag_04 = obj; 
			}
			if(obj.getNome().equals(param_sel_05)) {
				loggingTag_05 = obj; 
			}
			if(obj.getNome().equals(param_sel_06)) {
				loggingTag_06 = obj; 
			}
			
		}
		 
		graf.criaJSONGrafico(dataInicial, dataFinal, loggingTag_01, loggingTag_02, loggingTag_03, loggingTag_04, loggingTag_05, loggingTag_06);
		
		
		
		
		
		

		/*
		
		String variaveis = "";
		List<String> listaVariaveis = new ArrayList<String>();
		List<Boolean> listaVariaveisAtivas = new ArrayList<Boolean>();

		
		String urlGrafico = "";
		String dataInicial = "";
		String dataFinal = "";
		
		listaVariaveisAtivas.add(false);// op001
		listaVariaveisAtivas.add(false);// op002
		listaVariaveisAtivas.add(false);// op003
		listaVariaveisAtivas.add(false);// op004
		listaVariaveisAtivas.add(false);// op005
		listaVariaveisAtivas.add(false);// op006
		listaVariaveisAtivas.add(false);// op007
		listaVariaveisAtivas.add(false);// op008
		listaVariaveisAtivas.add(false);// op009
		listaVariaveisAtivas.add(false);// op010
		listaVariaveisAtivas.add(false);// op011
		listaVariaveisAtivas.add(false);// op012
		listaVariaveisAtivas.add(false);// op013

		

	
		int i = 0;
		for (String x : params.values()) {
			if (i == 0) {
				dataInicial = x;
				urlGrafico = "?dataInicial=" + x;
			} else if (i == 1) {
				urlGrafico = urlGrafico + "&dataFinal=" + x + "&";
				dataFinal = x;
			} else {
				
				
				if (x.equals("consumo_combustivel_ao_dia")) {
					model.addAttribute("consumo_combustivel_ao_dia", true);
					listaVariaveisAtivas.set(0, true);
				}
				if (x.equals("consumo_combustivel_ao_mes")) {
					model.addAttribute("consumo_combustivel_ao_mes", true);
					listaVariaveisAtivas.set(1, true);
				}
				if (x.equals("horimetro_maquina")) {
					model.addAttribute("horimetro_maquina", true);
					listaVariaveisAtivas.set(2, true);
				}
				if (x.equals("horimetro_motor_na_lenta_diario")) {
					model.addAttribute("horimetro_motor_na_lenta_diario", true);
					listaVariaveisAtivas.set(3, true);
				}
				if (x.equals("horimetro_motor_na_lenta_mensal")) {
					model.addAttribute("horimetro_motor_na_lenta_mensal", true);
					listaVariaveisAtivas.set(4, true);
				}
				if (x.equals("horimetro_producao_diario")) {
					model.addAttribute("horimetro_producao_diario", true);
					listaVariaveisAtivas.set(5, true);
				}
				if (x.equals("horimetro_producao_mensal")) {
					model.addAttribute("horimetro_producao_mensal", true);
					listaVariaveisAtivas.set(6, true);
				}
				if (x.equals("nivel_radiador")) {
					model.addAttribute("nivel_radiador", true);
					listaVariaveisAtivas.set(7, true);
				}
				if (x.equals("nivel_tanque_diesel")) {
					model.addAttribute("nivel_tanque_diesel", true);
					listaVariaveisAtivas.set(8, true);
				}
				if (x.equals("pressao_oleo")) {
					model.addAttribute("pressao_oleo", true);
					listaVariaveisAtivas.set(9, true);
				}
				if (x.equals("rpm")) {
					model.addAttribute("rpm", true);
					listaVariaveisAtivas.set(10, true);
				}
				if (x.equals("temperatura_motor")) {
					model.addAttribute("temperatura_motor", true);
					listaVariaveisAtivas.set(11, true);
				}
				if (x.equals("tensao_bateria")) {
					model.addAttribute("tensao_bateria", true);
					listaVariaveisAtivas.set(12, true);
				}
				

				urlGrafico = urlGrafico + "op00" + i + "=" + x + "&";

				if (!variaveis.equals("")) {
					System.out.println("Nenhuma variável foi processada!");
				} else {

					listaVariaveis.add(x);
				}

			}

			i++;
		}

	
		
		DadoPicador dadoPicador = dadoPicadorService.findEndByPicador(idBuscar);
		Picador picador = picadorService.findById(idBuscar);

		model.addAttribute("picador", picador);

		model.addAttribute("grafico",dadoPicadorService.findAllByPicadorGrafico(idBuscar, dataInicial, dataFinal, listaVariaveis));

		
		
		
		model.addAttribute("paramsGrafico", urlGrafico);
		

		if (dadoPicador.getId() == 0) {
			String msg = "Sem nenhum dado de CLP coletado até o presente momento!";

			model.addAttribute("mensagem", msg);
			System.out.println(msg);

		} else {
			model.addAttribute("ultimaConsultaDadoPicador", dadoPicador);
		}
		
		
		*/

		return "home";
	}
	
	
	
	
	
	
	
}

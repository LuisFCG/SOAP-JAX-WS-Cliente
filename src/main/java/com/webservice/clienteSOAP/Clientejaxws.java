package com.webservice.clienteSOAP;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webservice.jaxws.jaxwstomcat.HelloWorld;
import webservice.jaxws.jaxwstomcat.HelloWorldImplService;


@Controller
public class Clientejaxws {

	private static Log LOG = LogFactory.getLog(Clientejaxws.class);
	
	HelloWorldImplService service = new HelloWorldImplService();
	HelloWorld hello = service.getHelloWorldImplPort();
	
	private String message = hello.helloWorld("luis");
	//private String solcitaUsu;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}
	
	@RequestMapping("/solicitausuario")
	public String solicitaUsuario( @RequestParam(value="name", required=false) String name, 
			ModelMap model) {
		LOG.info("Valor de la variable name: "+ name);
		HelloWorldImplService service = new HelloWorldImplService();
		HelloWorld hello2 = service.getHelloWorldImplPort();
		String resp  = hello2.helloWorld(name);
		LOG.info("Valor de la variable solcitaUsu: "+ resp );
		model.addAttribute("resp", resp );
		//model.put("solcitaUsu", this.solcitaUsu);
		return "index";
	}
	
}

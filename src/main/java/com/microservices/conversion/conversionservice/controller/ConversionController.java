package com.microservices.conversion.conversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

import com.microservices.conversion.conversionservice.bean.ConversionBean;

@RestController
//@RequestMapping("/answer")
@CrossOrigin("*")
public class ConversionController {

	
	/* @Autowired private ConversionProxy proxy;
	 
	  @GetMapping("converter/from/{from}/to/{to}/quantity/{quantity}") public
	 ConversionBean convertFeign(@PathVariable String from,
	 
	 @PathVariable String to, @PathVariable BigDecimal quantity) {
	  System.out.println("...............b4 proxy creation.................");
	  ConversionBean body=proxy.retrieveValue(from, to);
	  System.out.println("...............After proxy creation.................");
	  return new ConversionBean(body.getId(), from,
	  to,body.getConversionMultiple(), quantity,
	  quantity.multiply(body.getConversionMultiple()),body.getPort());
	 
	  }
	*/ 
	/*@GetMapping("converter/from/{from}/to/{to}/quantity/{quantity}")
	public ConversionBean convert(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {

		Map<String, String> uriVariblaes = new HashMap<String, String>();
		uriVariblaes.put("from", from);
		uriVariblaes.put("to", to);
		ResponseEntity<ConversionBean> forEntity = new RestTemplate()
				.getForEntity(
						"http://localhost:8000/exchange/from/{from}/to/{to}",
						ConversionBean.class, uriVariblaes);
		ConversionBean body = forEntity.getBody();

		return new ConversionBean(body.getId(), from, to,
				body.getConversionMultiple(), quantity, quantity.multiply(body
						.getConversionMultiple()), body.getPort());

	}

*/
	@Autowired
	private WebClient.Builder webClientBuilder;
	@GetMapping("converter/from/{from}/to/{to}/quantity/{quantity}")
	public Flux convert(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		Map<String, String> uriVariblaes = new HashMap<String, String>();
		uriVariblaes.put("from", from);
		uriVariblaes.put("to", to);
		
		Flux<ConversionBean> bodyToFlux = webClientBuilder.build().get().uri("http://exchange/exchange/from/{from}/to/{to}",from,to)
						.retrieve().bodyToFlux(ConversionBean.class);
		Flux conb = bodyToFlux;
		return conb;
		
	}
}

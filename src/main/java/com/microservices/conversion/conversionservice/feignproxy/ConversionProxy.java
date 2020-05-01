package com.microservices.conversion.conversionservice.feignproxy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.conversion.conversionservice.bean.ConversionBean;

//@FeignClient(name="conversion", url="localhost:8001")
public interface ConversionProxy {
	@GetMapping("/exchange/from/{from}/to/{to}")
	public ConversionBean retrieveValue(@PathVariable("from") String from,@PathVariable("to") String to);
		

}

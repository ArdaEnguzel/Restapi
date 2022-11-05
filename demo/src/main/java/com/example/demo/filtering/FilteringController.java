package com.example.demo.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.TryBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	@GetMapping("/filter")
	public MappingJacksonValue getBean() {
		TryBean bean= new TryBean("value1","value2","value3");
		MappingJacksonValue mappingJacksonValue= new MappingJacksonValue(bean);
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters= new SimpleFilterProvider().addFilter("TryBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
		
	}
	@GetMapping("/filter/v2")
	public TryBean getMyBean() {
		return new TryBean("value1","value2","value3");
	}

}

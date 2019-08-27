package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.LookUpCountries;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@Api(value="Lookup Methods", description="Operations lookup methods")
//@RestController = @Controller + @ResponseBody
@RestController 
@RequestMapping("/lookup")
public class LookupController {
	
	public static final Logger  logger = LoggerFactory.getLogger(LookupController.class);

	//http://localhost:8080/server-application/lookup/countries/
	@ApiOperation(value = "Countries", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value = "/countries/" , method = RequestMethod.GET)
	public ResponseEntity<List<LookUpCountries>> countryLookup(){
		
		System.out.println( "countries " );
		List<LookUpCountries> lookUpCountries = new ArrayList<LookUpCountries>();
		
		LookUpCountries lkup = null;
		lkup = new LookUpCountries();
		lkup.setCountryCode("423");
		lkup.setCountryName("INDIA");
		
		lookUpCountries.add(lkup);
		
		lkup = new LookUpCountries();
		lkup.setCountryCode("420");
		lkup.setCountryName("PAKISTHAN");
		
		lookUpCountries.add(lkup);
		
	    return new ResponseEntity<List<LookUpCountries>>(lookUpCountries, HttpStatus.OK); 
	}
	
	
	
	//http://localhost:8080/server-application/lookup/countries1/
		@RequestMapping(value = "/countries1/" , method = RequestMethod.GET)
		public List<LookUpCountries> countryLookup1(){
			
			System.out.println( "countries1 " );
			List<LookUpCountries> lookUpCountries = new ArrayList<LookUpCountries>();
			
			LookUpCountries lkup = null;
			lkup = new LookUpCountries();
			lkup.setCountryCode("423");
			lkup.setCountryName("INDIA");
			
			lookUpCountries.add(lkup);
			
			lkup = new LookUpCountries();
			lkup.setCountryCode("420");
			lkup.setCountryName("PAKISTHAN");
			
			lookUpCountries.add(lkup);
			
		    return lookUpCountries; 
		}

	
	//http://localhost:8080/server-application/lookup/countries/423
	@RequestMapping(value = "/countries/{id}" , method = RequestMethod.GET)
	public ResponseEntity<List<LookUpCountries>> countryDetails(@PathVariable ("id") String id ){ //@RequestParam (value = "id") String id
		
		System.out.println( "/countries/{id} " );
		
		List<LookUpCountries> lookUpCountries = new ArrayList<LookUpCountries>();
		if (id == null || id.equals("423") ){
			LookUpCountries lkup = null;
			lkup = new LookUpCountries();
			lkup.setCountryCode("423");
			lkup.setCountryName("INDIA");
			lookUpCountries.add(lkup);
			  
			return new ResponseEntity<List<LookUpCountries>>(lookUpCountries, HttpStatus.OK);
		}else if (id == null || id.equals("420") ){
			return new ResponseEntity<List<LookUpCountries>>(HttpStatus.NO_CONTENT);
		}
		 return new ResponseEntity<List<LookUpCountries>>(HttpStatus.BAD_REQUEST); 
	}
	
	
	
		//http://localhost:8080/server-application/lookup/countries?id=423
		@RequestMapping(value = "/countries" , method = RequestMethod.GET)
		public ResponseEntity<List<LookUpCountries>> countryDetailsById(@RequestParam (value = "id") String id ){
			
			System.out.println( "/countries?{id} by id " );
			
			List<LookUpCountries> lookUpCountries = new ArrayList<LookUpCountries>();
			if (id == null || id.equals("423") ){
				LookUpCountries lkup = null;
				lkup = new LookUpCountries();
				lkup.setCountryCode("424");
				lkup.setCountryName("SRILANKA");
				lookUpCountries.add(lkup);
				  
				return new ResponseEntity<List<LookUpCountries>>(lookUpCountries, HttpStatus.OK);
			}else if (id == null || id.equals("420") ){
				return new ResponseEntity<List<LookUpCountries>>(HttpStatus.NO_CONTENT);
			}
			 return new ResponseEntity<List<LookUpCountries>>(HttpStatus.BAD_REQUEST); 
		}
	
	
}

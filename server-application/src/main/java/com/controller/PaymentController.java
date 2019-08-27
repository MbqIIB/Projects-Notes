package com.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.PaymentRequestDTO;
import com.dto.PaymentResponseDTO;


//http://localhost:8080/server-application/payment/pay?key="test"



@RestController // @RestController = @Controller + @ResponseBody
@RequestMapping("/payment")
public class PaymentController {
	
	@RequestMapping(value="/pay" , method = RequestMethod.POST)
	public PaymentResponseDTO paymentReq(@RequestParam (value = "key") String key,  @RequestBody PaymentRequestDTO payRequest){
		
		System.out.println("paymentReq :: " );
		
		 PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();	 
		 
		 if (payRequest.getItemId()!= null){
			 paymentResponseDTO.setCode(000);
			 paymentResponseDTO.setStatus("Success");			 
		 }else{
			 paymentResponseDTO.setCode(001);
			 paymentResponseDTO.setStatus("Failure");		
		 }
		 
	     return paymentResponseDTO; 
	}

}


package com.inwaiders.plames.modules.paygate.domain.billing.gateway;

import com.inwaiders.plames.api.utils.DescribedFunctionResult;
import com.inwaiders.plames.modules.paygate.domain.billing.Bill;

public interface PaymentGateway {
	
//	public Bill genBill(User user, int amount);
	public DescribedFunctionResult processBill(Bill bill);
	
	public void confirmPayment(Bill bill);
	
	public String getName();

	public boolean isActive();
	
	public void save();
	public void delete();
	
	public Long getId();
	
	public static PaymentGateway create(String type) {
		
		return PaymentGatewayHlRepository.create(type);
	}
	
	public static PaymentGateway getDefault() {
		
		return PaymentGatewayHlRepository.getDefault();
	}
}

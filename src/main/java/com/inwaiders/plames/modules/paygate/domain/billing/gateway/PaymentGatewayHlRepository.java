package com.inwaiders.plames.modules.paygate.domain.billing.gateway;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class PaymentGatewayHlRepository<T extends PaymentGateway> {

	private static List<PaymentGatewayHlRepository> repositories = new ArrayList<>();
	private static PaymentGateway defaultPaygate = null;
	
	public abstract T create();
	public abstract T getById(long id);
	public abstract List<PaymentGateway> getAll();
	
	public abstract String getType();
	
	public static PaymentGateway create(String type) {
		
		for(PaymentGatewayHlRepository repository : repositories) {
			
			if(repository.getType().equals(type)) {
				
				return repository.create();
			}
		}
		
		return null;
	}
	
	public static PaymentGatewayHlRepository getRepository(PaymentGateway gateway) {
		
		for(PaymentGatewayHlRepository repository : repositories) {
			
			if((Class<?>)(((ParameterizedType) repository.getClass().getGenericSuperclass()).getActualTypeArguments()[0]) == gateway.getClass()) {
				
				return repository;
			}
		}
		
		return null;
	}
	
	public static PaymentGatewayHlRepository getRepository() {
		
		return getRepository(getDefault());
	}
	
	public static void addRepository(PaymentGatewayHlRepository repository) {
		
		repositories.add(repository);
	}
	
	public static List<PaymentGatewayHlRepository> getRepositories() {
	
		return repositories;
	}
	
	public static void setDefault(PaymentGateway repository) {
		
		defaultPaygate = repository;
	}
	
	public static PaymentGateway getDefault() {
		
		return defaultPaygate;
	}
}

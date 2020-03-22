package com.inwaiders.plames.modules.paygate.domain.billing;

import com.inwaiders.plames.api.user.User;

public interface Bill {
	
	public void onSuccess();
	public void onError();
	
	public int getAmount();

	public void setDescription(String desc);
	public String getDescription();

	public User getUser();

	public boolean isPaid();
	
	public void setPaymentTime(long time);
	public long getPaymentTime();
	
	public void save();
	public void delete();
	
	public Long getId();
}

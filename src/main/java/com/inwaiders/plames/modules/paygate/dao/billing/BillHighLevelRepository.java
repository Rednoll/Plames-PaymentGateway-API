package com.inwaiders.plames.modules.paygate.dao.billing;

import com.inwaiders.plames.dao.HighLevelRepository;
import com.inwaiders.plames.modules.paygate.domain.billing.Bill;

public abstract class BillHighLevelRepository<T extends Bill> implements HighLevelRepository<T>{

	@Override
	public void save(T entity) {
		
		entity.save();
	}
}

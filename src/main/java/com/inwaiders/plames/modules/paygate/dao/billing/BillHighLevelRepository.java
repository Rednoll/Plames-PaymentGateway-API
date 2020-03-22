package com.inwaiders.plames.modules.paygate.dao.billing;

import com.inwaiders.plames.dao.EntityLink;
import com.inwaiders.plames.dao.HighLevelRepository;
import com.inwaiders.plames.modules.paygate.domain.billing.Bill;
import com.inwaiders.plames.spring.SpringUtils;

public abstract class BillHighLevelRepository<T extends Bill> implements HighLevelRepository<T>{

	@Override
	public void save(T entity) {
		
		entity.save();
	}
	
	@Override
	public EntityLink getLink(T entity) {
		
		return new EntityLink(SpringUtils.getEntityName(entity.getClass()), entity.getId());
	}
}

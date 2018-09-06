package com.nhs_test.dao;

import com.nhs_test.model.Frequency;
import com.nhs_test.model.RegularAmount;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;

public class RegularAmounrDaoImplTest extends EntityDaoImplTest{

	@Autowired
	RegularAmountDao regularAmountDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Employee.xml"));
		return dataSet;
	}


	public RegularAmount getAmount(){
		RegularAmount amount = new RegularAmount();
		amount.setFrequency(Frequency.TWO_WEEK);
		amount.setAmount("120.00");
		return amount;
	}

}

package com.nhs_test.service;

import com.nhs_test.dao.RegularAmountDao;
import com.nhs_test.model.Frequency;
import com.nhs_test.model.RegularAmount;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class RegularAmountServiceImplTest {

	@Mock
	RegularAmountDao dao;
	
	@InjectMocks
	RegularAmountServiceImpl regularAmountService;
	
	@Spy
	List<RegularAmount> amounts = new ArrayList<RegularAmount>();
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		amounts = getAmountList();
	}

	@Test
	public void saveRegularAmount(){
		doNothing().when(dao).saveRegularAmount(any(RegularAmount.class));
		regularAmountService.saveRegularAmount(any(RegularAmount.class));
		verify(dao, atLeastOnce()).saveRegularAmount(any(RegularAmount.class));
	}

	
	public List<RegularAmount> getAmountList(){
		RegularAmount amount1 = new RegularAmount();

		amount1.setFrequency(Frequency.FOUR_WEEK);
		amount1.setAmount("160");

		RegularAmount amount2 = new RegularAmount();
		amount2.setFrequency(Frequency.QUARTER);
		amount2.setAmount("1444.43");
		
		amounts.add(amount1);
		amounts.add(amount2);
		return amounts;
	}
	
}

package com.nhs_test.controller;

import com.nhs_test.model.Frequency;
import com.nhs_test.model.RegularAmount;
import com.nhs_test.service.RegularAmountService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class AppControllerTest {


	@Mock
	RegularAmountService service;
	
	@Mock
	MessageSource message;
	
	@InjectMocks
	AppController appController;
	
	@Spy
	List<RegularAmount> amounts = new ArrayList<RegularAmount>();

	@Spy
	ModelMap model;
	
	@Mock
	BindingResult result;
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		amounts = getAmountList();
	}

	@Test
	public void newRegularAmount(){
		Assert.assertEquals(appController.newRegularAmount(model), "insertIncome");
		Assert.assertNotNull(model.get("amount"));
	}

	@Test
	public void saveAmountWithValidationError(){
		when(result.hasErrors()).thenReturn(true);
		doNothing().when(service).saveRegularAmount(any(RegularAmount.class));
		Assert.assertEquals(appController.saveRegularAmount(amounts.get(0), result, model), "insertIncome");
	}

	public List<RegularAmount> getAmountList(){

		//test a week
		RegularAmount amount1 = new RegularAmount();
		amount1.setFrequency(Frequency.WEEK);
		amount1.setAmount("10000");

		RegularAmount amount1_1 = new RegularAmount();
		amount1_1.setFrequency(Frequency.WEEK);
		amount1_1.setAmount("8888,88");

		//test two weeks
		RegularAmount amount2 = new RegularAmount();
		amount2.setFrequency(Frequency.TWO_WEEK);
		amount2.setAmount("120.00");

		//test four weeks
		RegularAmount amount3 = new RegularAmount();
		amount3.setFrequency(Frequency.FOUR_WEEK);
		amount3.setAmount("1776.4");

		//test quarter
		RegularAmount amount4 = new RegularAmount();
		amount4.setFrequency(Frequency.QUARTER);
		amount4.setAmount("1444.43");

		//test monthly
		RegularAmount amount5 = new RegularAmount();
		amount4.setFrequency(Frequency.QUARTER);
		amount4.setAmount("888.81");

		//test yearly
		RegularAmount amount6 = new RegularAmount();
		amount4.setFrequency(Frequency.QUARTER);
		amount4.setAmount("4544,44");

		amounts.add(amount1);
		amounts.add(amount1_1);
		amounts.add(amount2);
		amounts.add(amount3);
		amounts.add(amount4);
		amounts.add(amount5);
		amounts.add(amount6);
		return amounts;
	}

}

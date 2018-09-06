package com.nhs_test.controller;

import com.nhs_test.model.RegularAmount;
import com.nhs_test.service.RegularAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	RegularAmountService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will provide the medium to add an amount.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newRegularAmount(ModelMap model) {
		RegularAmount amount = new RegularAmount();
		model.addAttribute("amount", amount);
		model.addAttribute("edit", false);
		return "insertIncome";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving amount in database. It also validates the amount input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveRegularAmount(@Valid RegularAmount amount, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "insertIncome";
		}
		service.saveRegularAmount(amount);

		model.addAttribute("success", "RegularAmount " + amount.getFrequency() + " Income multiple of weeks");
		return "success";
	}

	/*
	 * Method used to populate the frequency list in view.
	 */
	@ModelAttribute("frequency")
	public List<String> initializeCountries() {

		List<String> frequency = new ArrayList<String>();
		frequency.add("WEEK");
		frequency.add("TWO_WEEK");
		frequency.add("FOUR_WEEK");
		frequency.add("MONTH");
		frequency.add("QUARTER");
		frequency.add("YEAR");

		return frequency;
	}

}

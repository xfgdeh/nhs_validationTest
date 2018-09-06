package com.nhs_test.validator;

import com.nhs_test.model.RegularAmount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DecimalFormat;

public class AmountValidator implements ConstraintValidator<Amount, String> {

    private static final Integer WEEK_FREQUENCY = 1;
    private static final Integer TWOWEEK_FREQUENCY = 2;
    private static final Integer FOURWEEK_FREQUENCY = 4;
    private static final Integer QUARTER_FREQUENCY = 13;
    private static final Integer YEAR_FREQUENCY= 52;

    /*
    * Regex validation: Integers, 2 decimals, and dots comas
     */
    private static final String numberRegex = "^[1-9][0-9]*";
    private static final String acceptComaAndDotRegex = "^[0-9]{1,2}([,.][0-9]{1,2})?$";

    @Override
    public void initialize(Amount paramA) {
    }

    public boolean isValid( String amount, ConstraintValidatorContext ctx) {
        RegularAmount regularAmount = new RegularAmount();

        if(amount == null){
            return false;
        }
        // Checks if the amount is valid with Regex
        if(ValidatedAmount(amount)){
            switch (regularAmount.getFrequency()){
                // no need to have a case  for a weekly value as any number divided by 1 is the same number
                case WEEK:
                    return amountDivisibleToWeeklyValue(amount,WEEK_FREQUENCY);
                case TWO_WEEK:
                    return amountDivisibleToWeeklyValue(amount,TWOWEEK_FREQUENCY);
                case FOUR_WEEK:
                    return amountDivisibleToWeeklyValue(amount,FOURWEEK_FREQUENCY);
                case QUARTER:
                    return amountDivisibleToWeeklyValue(amount,QUARTER_FREQUENCY);
                case YEAR:
                    return amountDivisibleToWeeklyValue(amount,YEAR_FREQUENCY);
                default:
                    return true;
            }
        }else {
            return false;
        }
    }

    private boolean ValidatedAmount( String amount) {
        //Inputs accepted shoud be integers separated by a comma or dot
        return amount.matches(numberRegex) ||amount.matches(acceptComaAndDotRegex);
    }

    private boolean amountDivisibleToWeeklyValue( String amount, Integer weeks) {

        //parsing String to double value
        Double result = Double.valueOf(amount)/ weeks;

        DecimalFormat decimalFormat = new DecimalFormat("######.##");

        String amountValue = decimalFormat.format(result);

        Double defaultAmountValue = Double.valueOf(amountValue) * weeks;

        if(defaultAmountValue.equals(Double.valueOf(amount))){

            return ValidatedAmount(String.valueOf(amountValue));
        }
        return false;
    }

}

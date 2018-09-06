import com.nhs_test.model.Frequency;
import com.nhs_test.model.RegularAmount;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static com.nhs_test.model.Frequency.*;
import static junit.framework.TestCase.assertEquals;

public class amountTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testIncorrectAmount(){
        testingRegularAmount(MONTH,"String",false);
    }

    @Test
    public void testIncorrectAmountForWeek(){
        testingRegularAmount(WEEK,"-122",false);
    }

    @Test
    public void testIncorrectAmountTwoWeeks(){
        testingRegularAmount(TWO_WEEK,"777.11999",false);
    }

    @Test
    public void testIncorrectAmountFourWeeks(){
        testingRegularAmount(FOUR_WEEK,"000",false);
    }

    @Test
    public void testIncorrectAmountQuarterly(){
        testingRegularAmount(QUARTER,"13269.0008",false);
    }

    @Test
    public void testIncorrectAmountMonthly(){
        testingRegularAmount(MONTH,"1690.0001",false);
    }

    @Test
    public void testYearly(){
        testingRegularAmount(YEAR,"-7777.777",false);
    }

    private void testingRegularAmount(Frequency frequency, String amount, boolean ValidOrNotValid) {
        RegularAmount regularAmount = new RegularAmount(frequency,amount);
        Set<ConstraintViolation<RegularAmount>> constraintViolations = validator.validate( regularAmount );
        assertEquals( ValidOrNotValid, constraintViolations.size()== 0 );
    }

}
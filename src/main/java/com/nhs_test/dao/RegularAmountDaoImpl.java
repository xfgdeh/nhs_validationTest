package com.nhs_test.dao;

import com.nhs_test.model.RegularAmount;
import org.springframework.stereotype.Repository;

@Repository("regularAmountDao")
public class RegularAmountDaoImpl extends AbstractDao<Integer, RegularAmount> implements RegularAmountDao  {

    @Override
    public void saveRegularAmount(RegularAmount amount) {

    }
}



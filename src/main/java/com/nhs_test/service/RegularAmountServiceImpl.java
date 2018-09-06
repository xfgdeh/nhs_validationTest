package com.nhs_test.service;

import com.nhs_test.dao.RegularAmountDao;
import com.nhs_test.model.RegularAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("regularAmountService")
@Transactional
public class RegularAmountServiceImpl implements RegularAmountService{

    @Autowired
    private RegularAmountDao dao;




    @Override
    public void saveRegularAmount(RegularAmount amount) {
        dao.saveRegularAmount(amount);
    }
}


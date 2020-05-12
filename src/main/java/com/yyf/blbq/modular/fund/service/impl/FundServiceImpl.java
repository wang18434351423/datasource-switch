package com.yyf.blbq.modular.fund.service.impl;

import com.yyf.blbq.modular.fund.mapper.FundMapper;
import com.yyf.blbq.modular.fund.service.FundService;
import com.yyf.blbq.util.DataSourceCutOver;
import com.yyf.blbq.util.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wangchen
 * @create 2020/05/11/15:50
 */
@Service
public class FundServiceImpl implements FundService {

    @Autowired
    private FundMapper fundMapper;

    @DataSourceCutOver(DataSourceType.SLAVE)
    @Override
    public List<Map<String, Object>> countryList() {
        return fundMapper.countryList();
    }
}

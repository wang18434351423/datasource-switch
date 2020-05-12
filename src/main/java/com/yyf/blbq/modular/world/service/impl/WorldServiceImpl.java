package com.yyf.blbq.modular.world.service.impl;

import com.yyf.blbq.modular.world.mapper.WorldMapper;
import com.yyf.blbq.modular.world.service.WorldService;
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
public class WorldServiceImpl implements WorldService {

    @Autowired
    private WorldMapper worldMapper;

    @DataSourceCutOver(DataSourceType.MASTER)
    @Override
    public List<Map<String, Object>> getCountry() {
        return worldMapper.countryList();
    }

}

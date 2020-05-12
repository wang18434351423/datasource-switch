package com.yyf.blbq.modular.fund.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author wangchen
 * @create 2020/05/11/16:02
 */
@Mapper
public interface FundMapper {

    @Select("select * from fun_country")
    List<Map<String, Object>> countryList();
}

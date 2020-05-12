package com.yyf.blbq.modular.world.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author wangchen
 * @create 2020/05/11/15:53
 */
@Mapper
public interface WorldMapper {

    @Select("select * from country")
    List<Map<String, Object>> countryList();
}

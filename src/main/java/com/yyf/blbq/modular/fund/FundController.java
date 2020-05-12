package com.yyf.blbq.modular.fund;

import com.yyf.blbq.modular.fund.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wangchen
 * @create 2020/05/11/15:47
 */
@RequestMapping("/fund")
@RestController
public class FundController {

    @Autowired
    private FundService fundService;

    @RequestMapping("/country")
    public List<Map<String, Object>> getFundCountry(){
        return fundService.countryList();
    }
}

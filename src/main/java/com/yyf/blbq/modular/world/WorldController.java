package com.yyf.blbq.modular.world;

import com.yyf.blbq.modular.world.service.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wangchen
 * @create 2020/05/11/15:46
 */
@RequestMapping("/world")
@RestController
public class WorldController {

    @Autowired
    private WorldService worldService;

    @RequestMapping("/country")
    public List<Map<String,Object>> getCountry(){
        return worldService.getCountry();
    }
}

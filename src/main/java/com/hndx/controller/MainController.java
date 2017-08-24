package com.hndx.controller;
import com.hndx.model.PbDepartEntity;
import org.springframework.data.domain.Sort.Direction;
import com.hndx.model.PbBalanceEntity;

import com.hndx.model.PbEmplyEntity;
import com.hndx.model.PbIcanteenEntity;
import com.hndx.repository.PbIcanteenRepository;
import com.hndx.repository.PbBalanceRepository;

import com.hndx.repository.PbEmplyRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Copy by drizzit on 2017/8/19.
 */
@Controller
public class MainController {


    @Autowired
    PbBalanceRepository pbBalanceRepository;
    @Autowired
    PbEmplyRepository pbEmplyRepository;
    @Autowired
    PbIcanteenRepository pbIcanteenRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getClas(ModelMap modelMap) {

        return "test";
    }
    @RequestMapping(value = "/{dxmoblie}", method = RequestMethod.GET)
    public String getIndex(@PathVariable("dxmoblie") String dxmoblie, ModelMap modelMap, ModelMap icmodelMap) {
        //修改为dome钉钉认证传递过来的手机号码
        //String qPhone="13807310001";
        List<PbEmplyEntity> empList = pbEmplyRepository.findByPhoneEquals(dxmoblie);
        if (empList.isEmpty()) {
            return "index";
        }
        else {

            Integer empSysNo = empList.iterator().next().getSysNo();
            List<PbBalanceEntity> balList = pbBalanceRepository.findBySysNoEquals(empSysNo);
            //用户是否有一卡通钱包
            if (balList.isEmpty())
            { return "index"; }
            else            {
                modelMap.addAttribute("pbBalanceEntityList", balList);


            //用户是否有金额变动数据。最近5条。
                Pageable pageable = new PageRequest(0, 5,Direction.DESC, "id");
                Page<PbIcanteenEntity> icanteenEntityPage = pbIcanteenRepository.readBySysNoEquals(empSysNo,pageable);
                List<PbIcanteenEntity> pbIcanteenEntityList =  icanteenEntityPage.getContent();

                if (pbIcanteenEntityList.isEmpty()){
                    return "index";
                }
                else {
                    icmodelMap.addAttribute("pbIcanteenEntityList", pbIcanteenEntityList);
                    return "index";
                }
            }
        }

    }
}
package com.dylan.girl.controller;

import com.dylan.girl.domain.Girl;
import com.dylan.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "girls")
    public List<Girl> grilList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param girl
     * @return
     */
    @GetMapping(value = "girlAdd")
    public Girl girlAdd(@Valid Girl girl, BindingResult result){
        if (result.hasErrors()){
            System.out.println(result.getFieldError().getDefaultMessage());
            return null;
        }

        return girlRepository.save(girl);

    }

    /**
     * 查询一个女孩儿
     * @param id
     * @return
     */
    @GetMapping(value = "findOne")
    public Girl findOne(@RequestParam("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新女孩儿
     * @param id
     * @param cupSize
     * @return
     */
    @GetMapping(value = "updateGirl")
    public Girl updateGirl(@RequestParam("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }

    /**
     * 更新女孩儿
     * @param id
     * @return
     */
    @GetMapping(value = "deleteGirl")
    public void deleteGirl(@RequestParam("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 根据年龄查询女孩信息
     * @param age
     * @return
     */
    @GetMapping(value = "findGirlsByParam")
    public List<Girl> findGirlsByParam(@RequestParam("age") Integer age){
        return girlRepository.findByAge(age);

    }
}

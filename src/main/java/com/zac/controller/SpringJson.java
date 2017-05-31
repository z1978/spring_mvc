package com.zac.controller;

import java.io.Writer;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
 
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
 
@Component
class Attender {
    private int augend, addend;
     
    public Attender(){}
 
    public int getAugend(){
        return augend;
    }
    public void setAugend(int augend){
        this.augend = augend;
    }
 
    public int getAddend(){
        return addend;
    }
    public void setAddend(int addend){
        this.addend = addend;
    }
}
 
@Component
class Outcome {
    private int result;
 
    public Outcome(){}
 
    public int getResult(){
        return result;
    }
    public void setResult(int result){
        this.result = result;
    }
}
 
@Controller
public class SpringJson {
 
    @Autowired
    private Outcome outcome;
 
    @RequestMapping("/ajaxcalc")
    public @ResponseBody Outcome getResult(@RequestBody Attender attender){
 
        outcome.setResult(attender.getAugend() + attender.getAddend());
        return outcome;
    }
}

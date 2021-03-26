package com.faba.spring1.Controller;


import com.faba.spring1.Service.RomanNumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class ConversionController {

    @GetMapping("/decimal/roman")
    public String decimalToRoman(@RequestParam(value = "number") Integer number){
        return RomanNumberUtils.toRoman(number);
    }
}

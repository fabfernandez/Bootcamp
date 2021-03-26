package com.faba.spring1.Controller;

import com.faba.spring1.Service.MorseService;
import com.faba.spring1.View.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseController {

    @GetMapping("/translate")
    public Message translateMorse(@RequestParam(value = "morse") String morse){
        return new Message(MorseService.translate(morse),morse );
    }
}

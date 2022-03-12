package br.inatel.c216.myrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.c216.myrestapi.model.MyMessage;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public MyMessage processarGetHello() {
        MyMessage myMessage = new MyMessage();
        myMessage.setInfo("Hello World!");
        return myMessage;
    }

}

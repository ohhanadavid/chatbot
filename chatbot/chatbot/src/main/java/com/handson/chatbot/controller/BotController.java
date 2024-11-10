package com.handson.chatbot.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.handson.chatbot.service.ImdbService;


@RestController
@RequestMapping("/bot")
public class BotController {

    @Autowired
    ImdbService amazonService;

    @RequestMapping(value = "/imdb250Top", method = RequestMethod.GET)
    public ResponseEntity<?> get250Top(@RequestParam String keyword) throws IOException
    {
        return new ResponseEntity<>(amazonService.searchProducts(keyword), HttpStatus.OK);
    }

    @RequestMapping(value = "/imdbFan", method = RequestMethod.GET)
    public ResponseEntity<?> getFan(@RequestParam String keyword) throws IOException
    {
        return new ResponseEntity<>(amazonService.fanFavert(), HttpStatus.OK);
    }


}

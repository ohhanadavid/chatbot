package com.handson.chatbot.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.handson.chatbot.service.ImdbService;


@RestController
@RequestMapping("/bot")
public class BotController {

    @Autowired
    ImdbService imdbService;

    @RequestMapping(value = "/imdb250Top", method = RequestMethod.GET)
    public ResponseEntity<?> get250Top(@RequestParam Double num_of_movies) throws IOException
    {
        return new ResponseEntity<>(imdbService.searchProducts(num_of_movies), HttpStatus.OK);
    }

    @RequestMapping(value = "/imdbFan", method = RequestMethod.GET)
    public ResponseEntity<?> getFan() throws IOException
    {
        return new ResponseEntity<>(imdbService.fanFavert(), HttpStatus.OK);
    }


    @RequestMapping(value = "", method = { RequestMethod.POST})
    public ResponseEntity<?> getBotResponse(@RequestBody BotQuery query) throws IOException {
        HashMap<String, String> params = query.getQueryResult().getParameters();
        String res = "Not found";
        if (params.containsKey("num_of_movies")) {
            res = imdbService.searchProducts(Double.valueOf((String) params.get("num_of_movies")));
        } 
        return new ResponseEntity<>(BotResponse.of(res), HttpStatus.OK);
    }


    static class BotQuery {
        QueryResult queryResult;

        public QueryResult getQueryResult() {
            return queryResult;
        }
    }

    static class QueryResult {
        HashMap<String, String> parameters;

        public HashMap<String, String> getParameters() {
            return parameters;
        }
    }

    static class BotResponse {
        String fulfillmentText;
        String source = "BOT";

        public String getFulfillmentText() {
            return fulfillmentText;
        }

        public String getSource() {
            return source;
        }

        public static BotResponse of(String fulfillmentText) {
            BotResponse res = new BotResponse();
            res.fulfillmentText = fulfillmentText;
            return res;
        }
    }
}

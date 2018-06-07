package com.laziodisu.controller;

import com.laziodisu.bean.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PaymentController {
    @GetMapping(path = "/payment/{taxcode}"  )
    public ResponseEntity<Boolean> verifyTaxCode(@PathVariable("taxcode") String taxCode) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(taxCode==null || taxCode.length()!=16){
            response=false;
        }else
            response=true;
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }
    @GetMapping(path = "/payment/{paymentid}"  )
    public ResponseEntity<Boolean> verifyPayment(@PathVariable("paymentid") String paymentId) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(paymentId==null ){
            response=false;
        }else {

            response=ThreadLocalRandom.current().nextBoolean();

        }
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }
    @PostMapping(path = "/payment"  )
    public ResponseEntity<Integer> calculateCoins(@RequestBody Double studentISEE,@RequestBody Double avarage) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Integer response;
        if(studentISEE==null || avarage==null ){
            response=-1;
        }else {
            response=ThreadLocalRandom.current().nextInt(1, 7);


        }
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }
    @PostMapping(path = "/payment"  )
    public ResponseEntity<Boolean> assingCoins(@RequestBody User user, @RequestBody Integer coins) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(user==null || coins==0 ){
            response=false;
        }else {
            //TODO salvare valore in BIZAGI DB
            user.setCoins(coins);
            response=true;

        }
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }
}

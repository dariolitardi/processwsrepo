package com.laziodisu.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.laziodisu.bean.Reservation;
import com.laziodisu.bean.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
@RestController
@RequestMapping("canteen")
public class CanteenController {
    @GetMapping(path = "/credit/checktaxcode/{taxcode}"  )
    public ResponseEntity<String> verifyTaxCodeCredit(@PathVariable("taxcode") String taxCode) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(taxCode==null || taxCode.length()!=16){
            response=false;
        }else
            response=true;
        Gson gson = new Gson();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("response", response);

        String json= gson.toJson(jsonObject);
        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }
    @GetMapping(path = "/charge/checktaxcode/{taxcode}"  )
    public ResponseEntity<String > verifyTaxCodeCharge(@PathVariable("taxcode") String taxCode) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(taxCode==null || taxCode.length()!=16){
            response=false;
        }else
            response=true;
        Gson gson = new Gson();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("response", response);

        String json= gson.toJson(jsonObject);
        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }
    @GetMapping(path = "/credit/checkpayment/{paymentid}"  )
    public ResponseEntity<String> verifyPayment(@PathVariable("paymentid") String paymentId) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(paymentId==null ){
            response=false;
        }else {

            response=ThreadLocalRandom.current().nextBoolean();

        }
        Gson gson = new Gson();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("response", response);

        String json= gson.toJson(jsonObject);
        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }
    @PostMapping(path = "/credit/calculatecoins"  )
    public ResponseEntity<String> calculateCoins(@RequestBody Double studentISEE, @RequestBody Double avarage) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Integer response;

        if(studentISEE==null || avarage==null ){
            response=-1;
        }else {
            response=ThreadLocalRandom.current().nextInt(1, 7);


        }
        Gson gson = new Gson();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("response", response);

        String json= gson.toJson(jsonObject);
        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }
    @PostMapping(path = "/credit/assigncoins"  )
    public ResponseEntity<String> assingCoins(@RequestBody User user, @RequestBody Integer coins) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(user==null || coins==0 ){
            response=false;
        }else {
            //TODO salvare valore in BIZAGI DB
            user.setCoins(coins);
            response=true;

        }
        Gson gson = new Gson();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("response", response);

        String json= gson.toJson(jsonObject);
        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }
    @GetMapping(path = "/charge/reservation/{taxcode}"  )
    public ResponseEntity<String> checkReservation(@PathVariable("taxcode") String taxCode) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(taxCode==null || taxCode.length()!=16 ){
            response=false;
        }else {

            Date date= new Date();
            Reservation reservation= new Reservation();
            if (reservation.getReservationDate() != null) {


            if(date.compareTo(reservation.getReservationDate())==0){
                response=true;

            }else{
                response=false;

            }}else
                response=false;
        }
        Gson gson = new Gson();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("response", response);

        String json= gson.toJson(jsonObject);
        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }
    @GetMapping(path = "/charge/reservation/price/{isreserved}"  )
    public ResponseEntity<String> calculatePrice(@PathVariable("isreserved") Boolean isReserved) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Integer response;

        if(isReserved){
          response=3;
        }else
            response=4;
        Gson gson = new Gson();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("response", response);

        String json= gson.toJson(jsonObject);
        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }

}

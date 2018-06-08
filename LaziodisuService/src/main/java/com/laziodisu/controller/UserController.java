package com.laziodisu.controller;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.laziodisu.bean.Registration;
import com.laziodisu.bean.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping(path = "/createuser"  )
    public ResponseEntity<String> createUser(@RequestBody User user) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(user==null){
            response=false;
        }else{
            response=true;
        //TODO insert registration in Bizagi DB
        }
        Gson gson = new Gson();
        gson.toJson(response, Boolean.class);
        return new ResponseEntity<>(gson.toString(), responseHeaders, HttpStatus.OK);
    }


    @GetMapping(path = "/taxcode/{taxcode}"  )
    public ResponseEntity<String> verifyTaxCode(@PathVariable("taxcode")String taxCode) {

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

    @GetMapping(path = "/universityinfo/{universityid}"  )
    public ResponseEntity<String> getUniversityInformation(@PathVariable("universityid") String universityID) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Integer response;
        if(universityID==null ){
            response=-1;
        }else {
            //TODO query
            Registration registration= new Registration();
            //response=registration.getStudentCareer().getAccademicYear();
            response=ThreadLocalRandom.current().nextInt(1, 100);
        }
        Gson gson = new Gson();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("response", response);

        String json= gson.toJson(jsonObject);

        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }

    @GetMapping(path = "/isee/{taxcode}"  )
    public ResponseEntity<String> getISEE(@PathVariable("taxcode") String taxCode) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Double response;
        if(taxCode==null || taxCode.length()!=16 ){
            response=-1.0;
        }else {
            response=ThreadLocalRandom.current().nextDouble(1, 70000);

        }
        Gson gson = new Gson();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("response", response);

        String json= gson.toJson(jsonObject);

        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }
    @GetMapping(path = "/document/{documentid}"  )
    public ResponseEntity<String> checkDocument(@PathVariable("documentid") String documentID) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(documentID==null ){
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
    @GetMapping(path = "/lastscolarship/{taxcode}"  )
    public ResponseEntity<String> getScolarshipLastYear(@PathVariable("taxcode") String taxCode) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Double  response;
        if(taxCode==null || taxCode.length()!=16 ){
            response=0.0;
        }else {
            Double d= ThreadLocalRandom.current().nextDouble(1, 5000);


            response= Math.floor(d*100) / 100;



        }
        Gson gson = new Gson();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("response", response);

        String json= gson.toJson(jsonObject);

        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }
    @GetMapping(path = "/cfu/{taxcode}"  )
    public ResponseEntity<String> getCFU(@PathVariable("taxcode") String taxCode) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Integer  response;
        if(taxCode==null || taxCode.length()!=16 ){
            response=0;
        }else {
            response= ThreadLocalRandom.current().nextInt(1, 180);






        }
        Gson gson = new Gson();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("response", response);

        String json= gson.toJson(jsonObject);

        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }
    @GetMapping(path = "/reduction/{taxcode}"  )
    public ResponseEntity<String> getReduction(@PathVariable("taxcode") String taxCode) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Integer  response;
        if(taxCode==null || taxCode.length()!=16 ){
            response=0;
        }else {
            response= ThreadLocalRandom.current().nextInt(20, 100);






        }
        Gson gson = new Gson();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("response", response);

        String json= gson.toJson(jsonObject);

        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }

}

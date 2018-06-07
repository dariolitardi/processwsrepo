package com.laziodisu.controller;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import com.laziodisu.bean.Registration;
import com.laziodisu.bean.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class UserController {

    @PostMapping(path = "/user"  )
    public ResponseEntity<Boolean> createUser(@RequestBody User user) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(user==null){
            response=false;
        }else{
            response=true;
        //TODO insert registration in Bizagi DB
        }
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }


    @GetMapping(path = "/user/taxcode/{taxcode}"  )
    public ResponseEntity<Boolean> verifyTaxCode(@PathVariable("taxcode")String taxCode) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(taxCode==null || taxCode.length()!=16){
            response=false;
        }else
            response=true;
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }

    @GetMapping(path = "/user/universityinfo/{universityid}"  )
    public ResponseEntity<Integer> getUniversityInformation(@PathVariable("universityid") String universityID) {


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
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }

    @GetMapping(path = "/user/isee/{taxcode}"  )
    public ResponseEntity<Double> getISEE(@PathVariable("taxcode") String taxCode) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Double response;
        if(taxCode==null || taxCode.length()!=16 ){
            response=-1.0;
        }else {
            response=ThreadLocalRandom.current().nextDouble(1, 70000);

        }
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }
    @GetMapping(path = "/user/document/{documentid}"  )
    public ResponseEntity<Boolean> checkDocument(@PathVariable("documentid") String documentID) {


        HttpHeaders responseHeaders = new HttpHeaders();
        Boolean response;
        if(documentID==null ){
            response=false;
        }else {
            response=ThreadLocalRandom.current().nextBoolean();

        }
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }

}

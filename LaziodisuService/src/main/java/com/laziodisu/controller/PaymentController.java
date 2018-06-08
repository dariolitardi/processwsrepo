package com.laziodisu.controller;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.laziodisu.bean.Registration;
import com.laziodisu.bean.ScolarshipList;
import com.laziodisu.bean.User;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
@RestController
@RequestMapping("payment")
public class PaymentController {

    @GetMapping(path = "/information"  )
    public ResponseEntity<String> requestInformation() {


        HttpHeaders responseHeaders = new HttpHeaders();
        List<ScolarshipList> list= new LinkedList<>();
        for(int i=0; i< 10; i++){
            ScolarshipList scolarshipList= new ScolarshipList();


            Double d= ThreadLocalRandom.current().nextDouble(1, 100);


            Double cfnr= Math.floor(d*100) / 100;
            scolarshipList.setCFNR(cfnr);

            scolarshipList.setListType(String.valueOf(ThreadLocalRandom.current().nextInt(1, 3)));
            scolarshipList.setLocationStatus(String.valueOf(ThreadLocalRandom.current().nextInt(1, 3)));

            scolarshipList.setPositionScore(i);
            User user = new User();
            RandomStringGenerator randomStringGenerator =
                    new RandomStringGenerator.Builder()
                            .withinRange('0', 'z')
                            .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                            .build();
          String taxcode=  randomStringGenerator.generate(16).toUpperCase();
            user.setTaxCode(taxcode);
            user.setPIN(String.valueOf(ThreadLocalRandom.current().nextInt(1000000, 9999999)));
            user.setExemption(ThreadLocalRandom.current().nextBoolean());
            scolarshipList.setUser(user);
            list.add(scolarshipList);
        }
        Gson gson = new Gson();

        String data = gson.toJson(list);
        JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();

        return new ResponseEntity<>(jsonArray.toString(), responseHeaders, HttpStatus.OK);
    }

}

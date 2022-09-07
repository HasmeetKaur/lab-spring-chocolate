package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateRepository chocolateRepository;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(){
//        List<Chocolate> chocolates = chocolateRepository.findAllById(id);
        return new ResponseEntity<>(chocolateRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable Long id){
        Optional<Chocolate> chocolate = chocolateRepository.findById(id);
        if(chocolate.isPresent()){
            return new ResponseEntity<>(chocolate.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

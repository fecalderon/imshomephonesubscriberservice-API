package wpwa.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wpwa.application.exception.ResourceNotFoundException;
import wpwa.application.model.Subscriber;
import wpwa.application.repository.SubscriberRepository;

import java.util.List;

@RestController
@RequestMapping("/ims/subscriber")
public class SubscriberController {

    @Autowired
    private SubscriberRepository subscriberRepository;

    // GET All
    @GetMapping
    public List<Subscriber> getAllSubscribers(){
        return subscriberRepository.findAll();
    }

    // CREATE Subscriber REST API
    @PostMapping
    public Subscriber createSubscriber(@RequestBody Subscriber subscriber){
        return subscriberRepository.save(subscriber);
    }

    // GET by phoneNumber
    @GetMapping("{phoneNumber}")
    public ResponseEntity<Subscriber> getSubscriberByPhoneNumber(@PathVariable String phoneNumber){
        Subscriber subscriber = subscriberRepository.findById(phoneNumber).orElseThrow(() -> new ResourceNotFoundException("Subscriber with phone number: " + phoneNumber + " does not exist!"));
        return ResponseEntity.ok(subscriber);
    }

    // UPDATE Subscriber REST API
    @PutMapping("{phoneNumber}")
    public ResponseEntity<Subscriber> updateSubscriber(@PathVariable String phoneNumber, @RequestBody Subscriber subscriberInfo){
        Subscriber updateSubscriber = subscriberRepository.findById(phoneNumber).orElseThrow(() -> new ResourceNotFoundException("Subscriber with phone number: " + phoneNumber + " does not exist!"));
        updateSubscriber.setPhoneNumber(phoneNumber);
        updateSubscriber.setUsername(subscriberInfo.getUsername());
        updateSubscriber.setPassword(subscriberInfo.getPassword());
        updateSubscriber.setDomain(subscriberInfo.getDomain());
        updateSubscriber.setStatus(subscriberInfo.getStatus());
        subscriberRepository.save(updateSubscriber);
        return ResponseEntity.ok(updateSubscriber);
    }

    // DELETE Subscriber REST API
    @DeleteMapping("{phoneNumber}")
    public ResponseEntity<HttpStatus> deleteSubscriber(@PathVariable String phoneNumber){
        Subscriber subscriber = subscriberRepository.findById(phoneNumber).orElseThrow(() -> new ResourceNotFoundException("Subscriber with phone number: " + phoneNumber + " does not exist!"));
        subscriberRepository.delete(subscriber);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

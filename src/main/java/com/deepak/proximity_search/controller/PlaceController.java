package com.deepak.proximity_search.controller;

import com.deepak.proximity_search.dto.PlaceCreateRequest;
import com.deepak.proximity_search.dto.PlaceResponse;
import com.deepak.proximity_search.dto.PlaceUpdateRequest;
import com.deepak.proximity_search.entity.Place;
import com.deepak.proximity_search.service.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {
    private final PlaceService placeService;
    public PlaceController(PlaceService placeService){
        this.placeService = placeService;
    }
//    createPlace
    @PostMapping()
    public ResponseEntity<PlaceResponse> createPlace(@RequestBody PlaceCreateRequest request){
        PlaceResponse placeResponse = placeService.createPlace(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }
    @PostMapping("/{id}")
    public ResponseEntity<PlaceResponse> updatePlace(@PathVariable Integer id, @RequestBody PlaceUpdateRequest request){
        PlaceResponse placeResponse = placeService.updatePlace(id,request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(place);
        return ResponseEntity.ok(placeResponse);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Integer id){
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlaceResponse> getPlace(@PathVariable Integer id){
        PlaceResponse placeResponse = placeService.getPlaceById(id);
        return ResponseEntity.status(HttpStatus.OK).body(placeResponse);
    }
    @GetMapping()
    public ResponseEntity<List<PlaceResponse>> getAllPlaces(){
        List<PlaceResponse> places = placeService.getAllPlace();
        return ResponseEntity.ok(places);
    }
}

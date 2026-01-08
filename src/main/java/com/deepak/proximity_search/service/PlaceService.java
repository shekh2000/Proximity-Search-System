package com.deepak.proximity_search.service;

import com.deepak.proximity_search.dto.PlaceCreateRequest;
import com.deepak.proximity_search.entity.Place;

public interface PlaceService {
    Place createPlace(PlaceCreateRequest obj);
    void updatePlace();
//    void deletePlace();
//    void getPlaceById();
//    void getAllPlace();
//    void findPlacesWithinRadius();
//    void getPlacesByCategory();
}

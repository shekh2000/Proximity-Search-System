package com.deepak.proximity_search.service;

import com.deepak.proximity_search.dto.PlaceCreateRequest;
import com.deepak.proximity_search.dto.PlaceUpdateRequest;
import com.deepak.proximity_search.entity.Place;

import java.util.List;

public interface PlaceService {
    Place createPlace(PlaceCreateRequest obj);
    Place updatePlace(Integer id, PlaceUpdateRequest obj);
    void deletePlace(Integer id);
    Place getPlaceById(Integer id);
    List<Place> getAllPlace();
//    void findPlacesWithinRadius();
//    void getPlacesByCategory();
}

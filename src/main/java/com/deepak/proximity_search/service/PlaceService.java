package com.deepak.proximity_search.service;

import com.deepak.proximity_search.dto.PlaceCreateRequest;
import com.deepak.proximity_search.dto.PlaceResponse;
import com.deepak.proximity_search.dto.PlaceUpdateRequest;
import com.deepak.proximity_search.entity.Place;

import java.util.List;

public interface PlaceService {
    PlaceResponse createPlace(PlaceCreateRequest obj);
    PlaceResponse updatePlace(Integer id, PlaceUpdateRequest obj);
    void deletePlace(Integer id);
    PlaceResponse getPlaceById(Integer id);
    List<PlaceResponse> getAllPlace();
//    void findPlacesWithinRadius();
//    void getPlacesByCategory();
}

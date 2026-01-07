package com.deepak.proximity_search.service;

import com.deepak.proximity_search.dto.PlaceCreateRequest;

public interface PlaceService {
    void updatePlace();
    void createPlace(PlaceCreateRequest obj);
    void deletePlace();
    void getPlaceById();
    void getAllPlace();
    void findPlacesWithinRadius();
    void getPlacesByCategory();
}

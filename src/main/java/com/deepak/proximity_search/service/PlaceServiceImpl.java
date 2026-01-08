package com.deepak.proximity_search.service;
import com.deepak.proximity_search.dto.PlaceCreateRequest;
import com.deepak.proximity_search.entity.Coordinate;
import com.deepak.proximity_search.entity.Place;
import com.deepak.proximity_search.entity.PlaceCategory;

import java.util.ArrayList;
import java.util.List;


public class PlaceServiceImpl implements PlaceService{
    List<Place> places = new ArrayList<>();
    @Override
    public Place createPlace(PlaceCreateRequest obj){
        Place place = new Place();
        place.setId(places.size());
        place.setName(obj.getName());
        place.setCapacity(obj.getCapacity());
        PlaceCategory placeCategory = PlaceCategory.valueOf(obj.getCategory().toUpperCase());
        place.setCategory(placeCategory);
        Coordinate coordinate = new Coordinate();
        coordinate.setLatitude(obj.getLatitude());
        coordinate.setLongitude(obj.getLongitude());
        place.setLocation(coordinate);
        places.add(place);
        return place;
    }
    void updatePlace(){

    }
//    void deletePlace(){
//
//    }
//    void getPlaceById(){
//
//    }
//    void getAllPlace(){
//
//    }
//    void findPlacesWithinRadius(){
//
//    }
//    void getPlacesByCategory(){
//
//    }
}

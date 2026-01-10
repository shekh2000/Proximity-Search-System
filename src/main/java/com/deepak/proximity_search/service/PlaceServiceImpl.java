package com.deepak.proximity_search.service;
import com.deepak.proximity_search.dto.PlaceCreateRequest;
import com.deepak.proximity_search.dto.PlaceUpdateRequest;
import com.deepak.proximity_search.entity.Coordinate;
import com.deepak.proximity_search.entity.Place;
import com.deepak.proximity_search.entity.PlaceCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
    @Override
    public Place updatePlace(Integer id, PlaceUpdateRequest obj){
        Place place = places.get(id);
        place.setName(obj.getName());
        place.setCapacity(obj.getCapacity());
        place.setCategory(PlaceCategory.valueOf(obj.getCategory().toUpperCase()));
        Coordinate coordinate = new Coordinate();
        coordinate.setLatitude(obj.getLatitude());
        coordinate.setLongitude(obj.getLongitude());
        place.setLocation(coordinate);
        return place;
    }
    @Override
    public void deletePlace(Integer id){
        Place place = places.get(id);
        place.setActive(false);
    }
    @Override
    public Place getPlaceById(Integer id){
        return places.get(id);
    }
    @Override
    public List<Place> getAllPlace(){
        return places.stream()
                .filter(Place::isActive)
                .collect(Collectors.toList());
    }
//    void findPlacesWithinRadius(){
//
//    }
//    void getPlacesByCategory(){
//
//    }
}

package com.deepak.proximity_search.service;
import com.deepak.proximity_search.dto.PlaceCreateRequest;
import com.deepak.proximity_search.dto.PlaceResponse;
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
    public PlaceResponse createPlace(PlaceCreateRequest obj){
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
        PlaceResponse placeResponse = new PlaceResponse();
        placeResponse.setName(place.getName());
        placeResponse.setCapacity(place.getCapacity());
        placeCategory = place.getCategory();
        placeResponse.setCategory(placeCategory.name());
        coordinate = place.getLocation();
        placeResponse.setLatitude(coordinate.getLatitude());
        placeResponse.setLongitude(coordinate.getLongitude());
        return placeResponse;
    }
    @Override
    public PlaceResponse updatePlace(Integer id, PlaceUpdateRequest obj){
        Place place = places.get(id);
        place.setName(obj.getName());
        place.setCapacity(obj.getCapacity());
        place.setCategory(PlaceCategory.valueOf(obj.getCategory().toUpperCase()));
        Coordinate coordinate = new Coordinate();
        coordinate.setLatitude(obj.getLatitude());
        coordinate.setLongitude(obj.getLongitude());
        place.setLocation(coordinate);
        PlaceResponse placeResponse = new PlaceResponse();
        placeResponse.setName(place.getName());
        placeResponse.setCapacity(place.getCapacity());
        PlaceCategory placeCategory = place.getCategory();
        placeResponse.setCategory(placeCategory.name());
        coordinate = place.getLocation();
        placeResponse.setLatitude(coordinate.getLatitude());
        placeResponse.setLongitude(coordinate.getLongitude());
        return placeResponse;
    }
    @Override
    public void deletePlace(Integer id){
        Place place = places.get(id);
        place.setActive(false);
    }
    @Override
    public PlaceResponse getPlaceById(Integer id){
        Place place = places.get(id);
        PlaceResponse placeResponse = new PlaceResponse();
        placeResponse.setName(place.getName());
        placeResponse.setCapacity(place.getCapacity());
        PlaceCategory placeCategory = place.getCategory();
        placeResponse.setCategory(placeCategory.name());
        placeResponse.setLatitude(place.getLocation().getLatitude());
        placeResponse.setLongitude(place.getLocation().getLongitude());
        return placeResponse;
    }

    public PlaceResponse mapToPlaceResponse(Place place){
        PlaceResponse placeResponse = new PlaceResponse();
        placeResponse.setName(place.getName());
        placeResponse.setCapacity(place.getCapacity());
        PlaceCategory placeCategory = place.getCategory();
        placeResponse.setCategory(placeCategory.name());
        placeResponse.setLatitude(place.getLocation().getLatitude());
        placeResponse.setLongitude(place.getLocation().getLongitude());
        return placeResponse;
    }
    @Override
    public List<PlaceResponse> getAllPlace(){
        return places.stream()
                .filter(Place::isActive)
                .map(this::mapToPlaceResponse)
                .collect(Collectors.toList());
    }
//    void findPlacesWithinRadius(){
//
//    }
//    void getPlacesByCategory(){
//
//    }
}

package com.alaorden.service.impl;

import com.alaorden.model.Address;
import com.alaorden.model.Location;
import com.alaorden.model.User;
import com.alaorden.repository.AddressRepository;
import com.alaorden.repository.LocationRepository;
import com.alaorden.repository.UserRepository;
import com.alaorden.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;


@Service
public class AddressServiceImpl implements AddressService {


    private AddressRepository addressRepository;
    private UserRepository userRepository;
    private LocationRepository locationRepository;
    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository, LocationRepository locationRepository){
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
    }
    @Transactional
    public Address createAddress(Address address){
        return addressRepository.save(address);
    }
    @Transactional
    public Address deleteAddress(int id){
        Address address = addressRepository.findByIdAddress(id);
        if(address == null){
            return null;
        }else{
            addressRepository.delete(address);
            return address;
        }
    }
    public List<Address> listAddressByUser(int id){
        User user = userRepository.findByIdUser(id);
        List<Address> addresses = addressRepository.findAllByUser(user);
        for(Address address : addresses){
            address.setUser(new User());
            address.getUser().setIdUser(id);
        }
        return addresses;
    }
    public List<Address> listAddress(){
        List<Address> addresses = addressRepository.findAll();
        for(Address address : addresses){
            int id = address.getUser().getIdUser();
            address.setUser(new User());
            address.getUser().setIdUser(id);
        }
        return addresses;
    }
    public BigDecimal computeDeliveryPrice(double distancia){
        return BigDecimal.valueOf(distancia*0.05 + 5.00);
    }

    public double computeDistance(double latA,double longA,double latB,double longB){
        /*var R = 6371; // Radius of the earth in km
        var dLat = deg2rad(lat2-lat1);  // deg2rad below
        var dLon = deg2rad(lon2-lon1);
        var a =
                Math.sin(dLat/2) * Math.sin(dLat/2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                Math.sin(dLon/2) * Math.sin(dLon/2)
                ;
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        var d = R * c; // Distance in km
        return d;*/

        double R = 6137;
        double dLat = Math.toRadians(latB-latA);
        double dLong = Math.toRadians(longB-longA);
        double a = Math.sin(dLat/2)*Math.sin(dLat/2)+Math.cos(Math.toRadians(latA))*Math.cos(Math.toRadians(latB))*Math.sin(dLong/2)*Math.sin(dLong/2);
        double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        double d = R*c;
        return d;
    }

    public boolean Exist(String s,List<String>ls){
        for(String franchise : ls){
            if(s.equals(franchise) )return true;
        }
        return false;
    }
    public List<Location> listDistanceMin(double latitud,double longitud){
        List<Location> locations = locationRepository.findAll();
        List<String>setLocations = new ArrayList<>();

        List<Location> selectedLocations = new ArrayList<>();

        for(Location location : locations){
            double dist = computeDistance(latitud,longitud,location.getLatitude(),location.getLongitude());
            if(dist <= 30)//<---- Distancia minima de 30 kilometros
            {
                if(!Exist(location.getFranchise().getName(),setLocations)){
                    selectedLocations.add(location);
                    setLocations.add(location.getFranchise().getName());
                }
            }
        }
        return selectedLocations;
    }




}

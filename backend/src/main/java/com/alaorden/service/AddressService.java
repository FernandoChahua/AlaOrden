package com.alaorden.service;

import com.alaorden.model.Address;
import com.alaorden.model.User;
import com.alaorden.model.Location;

import java.util.*;
import java.math.BigDecimal;
public interface AddressService {

    Address createAddress(Address address);
    Address deleteAddress(int id);
    List<Address> listAddressByUser(int id);
    List<Address> listAddress();
    BigDecimal computeDeliveryPrice(double distancia);
    double computeDistance(double latA,double longA,double latB,double longB);
    boolean Exist(String s,List<String>ls);
    List<Location> listDistanceMin(double latitud,double longitud);
}

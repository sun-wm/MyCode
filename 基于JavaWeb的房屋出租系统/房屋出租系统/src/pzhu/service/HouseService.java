package pzhu.service;

import java.util.List;

import pzhu.pojo.House;



public  interface HouseService {
	List<House> showHouses();
	int addHouse(House house);
	int outHouse(String place);
	int modifyHouse(House house);
}

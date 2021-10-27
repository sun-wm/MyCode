package pzhu.dao;

import java.util.List;

import pzhu.pojo.House;


public interface HouseDao {
	List<House> selectAllHouses();
	int insertHouse(House house);
	int deleteHouse(String place);
	int reviseHouse(House house);
}

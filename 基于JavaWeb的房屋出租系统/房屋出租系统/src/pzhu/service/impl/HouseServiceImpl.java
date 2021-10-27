package pzhu.service.impl;




import java.util.List;

import pzhu.dao.HouseDao;
import pzhu.dao.impl.HouseDaoImpl;
import pzhu.pojo.House;
import pzhu.service.HouseService;

public class HouseServiceImpl  implements HouseService{
	HouseDao hd=new HouseDaoImpl();

	@Override
	public List<House> showHouses() {
		
		return hd.selectAllHouses();
	}

	@Override
	public int addHouse(House house) {
		// TODO Auto-generated method stub
		return hd.insertHouse(house);
	}

	@Override
	public int outHouse(String place) {
		// TODO Auto-generated method stub
		return hd.deleteHouse(place);
	}

	@Override
	public int modifyHouse(House house) {
		// TODO Auto-generated method stub
		return hd.reviseHouse(house);
	}
	
	
	
}

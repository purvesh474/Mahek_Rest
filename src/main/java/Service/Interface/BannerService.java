package Service.Interface;

import java.util.ArrayList;

import Dao.Banner;

public interface BannerService {
	
public int insert(Banner banner);
public Banner getBannerById(int id );
public ArrayList<Banner> getAllBanner();
public int updateBannerById(int id,Banner banner);
public int deleteBannerbyId(int id);

}

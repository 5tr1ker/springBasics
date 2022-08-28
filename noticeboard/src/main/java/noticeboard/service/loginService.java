package noticeboard.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noticeboard.entity.userdata.idinfo;
import noticeboard.entity.userdata.profileSetting;
import noticeboard.repository.loginRepository;

@Service
@Transactional
public class loginService {

	@Autowired loginRepository loginRepository;
	
	public int register(Map<String, String> userInfo) {
		idinfo result = loginRepository.findById(userInfo.get("id"));
		if(result != null) {
			return -1;
		}
		if(!userInfo.get("pw").equals(userInfo.get("checkpw"))) return -2;
		profileSetting ps = profileSetting.createprofileSetting();
		idinfo idinfo_data = idinfo.createId(userInfo.get("id"), userInfo.get("pw"));
		idinfo_data.setProfileSetting(ps);
		loginRepository.save(idinfo_data);
		return 1;
	}
	
	public int login(Map<String , String> userInfo) {
		idinfo result = loginRepository.findById(userInfo.get("id"));
		if(result == null || !result.getPassword().equals(userInfo.get("pw"))) {
			return -1;
		}
		return 1;
	}

	public String findId(Map<String,String> userinfo) {
		idinfo result = loginRepository.findById(userinfo.get("id"));
		if(result == null) return "-1";
		String password = result.getPassword();
		return password.substring( 0 , password.length() - (password.length() - 3));
	}
	
	public profileSetting getProfile(String id) {
		idinfo data = loginRepository.findById(id);
		if(data==null) return null;
		return data.getProfileSetting();
	}

	public int remove(String userinfo) {
		//loginRepository.deleteByUserId(userinfo);
		idinfo data = loginRepository.findById(userinfo);
		loginRepository.delete(data);
		return 0;
	}
}

package noticeboard.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noticeboard.entity.userdata.idinfo;
import noticeboard.repository.loginRepository;

@Service
@Transactional
public class loginService {

	@Autowired loginRepository loginRepository;
	
	public int register(Map<String, String> userInfo) {
		idinfo result = loginRepository.findOne(userInfo.get("id"));
		if(result != null) {
			return -1;
		}
		if(!userInfo.get("pw").equals(userInfo.get("checkpw"))) return -2;
		
		idinfo idinfo_data = idinfo.createId(userInfo.get("id"), userInfo.get("pw"));
		loginRepository.save(idinfo_data);
		return 1;
	}
}

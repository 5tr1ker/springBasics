package noticeboard.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import noticeboard.entity.DTO.profileDTO;
import noticeboard.entity.userdata.idinfo;
import noticeboard.entity.userdata.profileSetting;
import noticeboard.repository.loginRepository;
import noticeboard.repository.profileRepository;

@Service
@Transactional
public class profileService {
	
	@Autowired profileRepository profileRepos;
	@Autowired loginRepository loginRepos;
	
	public Map<String, String> getProfile(String idinfo) {
		Long result_totalPost = profileRepos.getTotalPost(idinfo);
		Long result_totalCommit = profileRepos.getTotalComment(idinfo);
		Long result_postView = profileRepos.getPostView(idinfo);
		String result_joindate = profileRepos.getJoinDate(idinfo);
		Map<String , String> map = new HashMap<String, String>();
		map.put("totalPost" , result_totalPost.toString());
		map.put("totalCommit" , result_totalCommit.toString());
		if(result_postView == null) map.put("postView" , "0");
		else map.put("postView" , result_postView.toString());
		map.put("joindate" , result_joindate);
		return map;
	}

	public int updateProfileData(profileDTO data) {
		String userid = data.getIdstatus();
		String changeId = data.getInput_profiledata().getUserid();
		profileSetting st = profileRepos.findprofilesettings(data.getIdstatus());
		st.setEmail(data.getInput_profiledata().getEmail());
		st.setPhone(data.getInput_profiledata().getPhone());
		st.setOption1(data.getInput_profiledata().getOption1());
		st.setOption2(data.getInput_profiledata().getOption2());
		if(!userid.equals(changeId)) {
			idinfo search = loginRepos.findById(changeId);
			if(search != null) return -2; // 존재하는 아이디
			idinfo ii = loginRepos.findById(data.getIdstatus()); // 존재하지 않으면 변경
			ii.setId(changeId);
		}
		return 0;
	};
}

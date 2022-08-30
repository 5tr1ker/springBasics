package noticeboard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import noticeboard.entity.freeboard.freeAttach;
import noticeboard.entity.freeboard.freePost;
import noticeboard.repository.postRepository;

@Service
@Transactional
public class attachManager {
	
	@Autowired postRepository postRepos;
	
	public void modifiedupload(List<MultipartFile> files , Long postnumber) {
		String file_Path = "C:\\notice\\file\\";
		
		freePost fp = postRepos.findPostByNumbers(postnumber);
		List<freeAttach> fileData = fp.getFreeAttach();
		for(freeAttach list : fileData) {
			String name = list.getChangedFile();
			String realName = list.getFilename();
			String extend = realName.substring(realName.lastIndexOf('.') , realName.length());
			
			File file = new File("C:\\notice\\file\\" + name + extend);
			if(file.exists() && !file.getName().equals(name + extend)) file.delete();
		}
		
		for(MultipartFile file : files) {
			if (file != null) {
				
				String uuid = UUID.randomUUID().toString().replaceAll("-" , ""); // 고유 문자열
				String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length()); // 확장자
				
				File saveFile = new File(file_Path+"\\"+uuid + fileExtension);
				freeAttach fa = freeAttach.createFreeAttach(file.getOriginalFilename() , uuid , file.getSize());
				
				try {
					file.transferTo(saveFile);
					fp.addFreeAttach(fa);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void upload(List<MultipartFile> files , Long postnumber) {
		String file_Path = "C:\\notice\\file\\";
		
		freePost fp = postRepos.findPostByNumbers(postnumber);

		for(MultipartFile file : files) {
			if (file != null) {
				
				String uuid = UUID.randomUUID().toString().replaceAll("-" , ""); // 고유 문자열
				String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),file.getOriginalFilename().length()); // 확장자
				
				File saveFile = new File(file_Path+"\\"+uuid + fileExtension);
				freeAttach fa = freeAttach.createFreeAttach(file.getOriginalFilename() , uuid , file.getSize());
				
				try {
					file.transferTo(saveFile);
					fp.addFreeAttach(fa);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}

	}

}

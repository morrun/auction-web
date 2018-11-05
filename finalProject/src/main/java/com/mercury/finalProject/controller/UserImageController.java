package com.mercury.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mercury.finalProject.bean.UserDetail;
import com.mercury.finalProject.dao.UserDetailDao;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.S3Services;
import com.mercury.finalProject.serviceImpl.UserDetailServiceImpl;

@RestController
public class UserImageController {
	@Autowired
	private UserDetailDao userDetailDao;
	@Value("${morrun.aws.link}")
	private String preName;
	@Autowired
	private S3Services s3s;
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
	@PostMapping("/imageUser/{id}")
	public void addUserImages(@RequestParam("file") MultipartFile file,@PathVariable int id) {

		String keyName = file.getOriginalFilename();
		String[] arr = keyName.split("\\.");
		String type = arr[arr.length-1];
		UserDetail ud = userDetailDao.findByUserId(id);
		
		String inAwsName = "user" + id + "" + ud.getId() + "." + type;
		String finalName = preName +  "/" + inAwsName;
		ud.setImageUrl(finalName);
		userDetailDao.save(ud);
		s3s.uploadFile(inAwsName, file);
		
	}
}

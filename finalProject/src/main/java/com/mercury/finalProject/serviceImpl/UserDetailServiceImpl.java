package com.mercury.finalProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mercury.finalProject.bean.UserDetail;
import com.mercury.finalProject.dao.UserDetailDao;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.S3Services;
import com.mercury.finalProject.service.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UserDetailDao userDetailDao;
	@Value("${morrun.aws.link}")
	private String preName;
	@Autowired
	private S3Services s3s;
	@Override
	public List<UserDetail> getAllUserDetail() {
		// TODO Auto-generated method stub
		return userDetailDao.findAll();
	}
	@Override
	public Response updateUserDetail(UserDetail ud) {
		userDetailDao.save(ud);
		return new Response(true);
	}
	@Override
	public UserDetail findByUserId(int id) {
		
		return userDetailDao.findByUserId(id);
	}
	@Override
	public Response saveUserHeadIcon(MultipartFile file, int id) {
		String keyName = file.getOriginalFilename();
		String[] arr = keyName.split("\\.");
		String type = arr[arr.length-1];
		UserDetail ud = findByUserId(id);
		
		String inAwsName = "user" + id + "" + ud.getId() + "." + type;
		String finalName = preName +  "/" + inAwsName;
		ud.setImage(finalName);
		System.out.println(ud + "**********************************888");
		userDetailDao.save(ud);
		s3s.uploadFile(inAwsName, file);
		return new Response(true);
	}

}

package kr.co.swl.service;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface HomeServiceInterface {
	public HashMap<String,Object> fileupload(MultipartHttpServletRequest req, HashMap<String, Object> paramMap);
}

package com.citi.hackathon_backend.controller;

import com.citi.hackathon_backend.userInfo.entity.UserInfo;
import com.citi.hackathon_backend.org.entity.Organization;
import com.citi.hackathon_backend.org.repository.OrgRepository;
import com.citi.hackathon_backend.volunteerInfo.entity.VolunteerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.citi.hackathon_backend.userInfo.repository.UserInfoRepository;
import com.citi.hackathon_backend.volunteerInfo.repository.VolunteerInfoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CrudController {
	
	@Autowired
	private VolunteerInfoRepository volunteerInfoRepositor;
	
	@Autowired
	private UserInfoRepository userInfoRepositor;

	@Autowired
	private OrgRepository orgRepository;

	@GetMapping(value = "/volunteer/findFamiliarVolunteers/{organizatioName}")
	public ResponseEntity<Map> findFamiliarVolunteers(@PathVariable String organizatioName){
		List<VolunteerInfo> volunteers = (List<VolunteerInfo>) volunteerInfoRepositor.findAll();

		List list = new ArrayList<VolunteerInfo>();

		for(VolunteerInfo v : volunteers){
			if(isSubstring(organizatioName, v.getPersonalDescription())){
				list.add(v);
			}
		}

		Map map = new HashMap<>();
		map.put("organizatioName",organizatioName);
		map.put("volunteers", list);

		return ResponseEntity.ok(map);
	}

	@PostMapping(value = "volunteer/updateVolunteer")
	public ResponseEntity<String> updateVolunteer(@RequestBody VolunteerInfo volunteer){

		volunteerInfoRepositor.save(volunteer);
		return ResponseEntity.ok("success");

	}

	@DeleteMapping(value = "volunteer/deleteVolunteer")
	public ResponseEntity<String> deleteVolunteer(@RequestBody VolunteerInfo volunteer){

		volunteerInfoRepositor.delete(volunteer);
		return ResponseEntity.ok("success");

	}

	@PostMapping(value = "user/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody UserInfo user){

		userInfoRepositor.save(user);
		return ResponseEntity.ok("success");

	}

	@DeleteMapping(value = "user/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestBody UserInfo user){

		userInfoRepositor.delete(user);
		return ResponseEntity.ok("success");

	}

	@GetMapping(value = "org/findAllOrg")
	public ResponseEntity<List<Organization>> findAllOrg(){
		List list = new ArrayList<Organization>();
		list = (List<Organization>) orgRepository.findAll();

		return ResponseEntity.ok(list);
	}



	public static boolean isSubstring(String s, String l) {
		int sLength = s.length();
		int lLength = l.length();

		if (sLength > lLength) {
			return false;
		}

		for (int i = 0; i <= lLength - sLength; i++) {
			if (l.substring(i, i + sLength).equals(s)) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(isSubstring("house find", "Very familiar with health care and house find"
		));
	}


}

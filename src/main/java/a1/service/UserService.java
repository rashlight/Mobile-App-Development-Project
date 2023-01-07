package a1.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import a1.model.UserDTO;
import a1.repository.UserRepository;
import a1.repository.entity.UserEntity;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	public List<UserDTO> findAll(){
		List<UserDTO> results = new ArrayList<>();
		List<UserEntity> userEntities = userRepository.findAll();
		for (UserEntity item : userEntities) {
			UserDTO userDTO = new UserDTO();
			userDTO.setName(item.getName());
			userDTO.setEmail(item.getEmail());
			results.add(userDTO);
		}
		return results;
	}



	public void add(UserDTO user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(user.getName());
		userEntity.setEmail(user.getEmail());
		userRepository.save(userEntity);
		
	}



	public void deleteById(Long userNo) {
		userRepository.deleteById(userNo);
		
	}



	public void updateUser(UserDTO user) {
		UserEntity userEntity = userRepository.findById(user.getId()).get();
		userEntity.setEmail(user.getEmail());
		userEntity.setName(user.getName());
		userRepository.save(userEntity);
		
	}
	
	

}

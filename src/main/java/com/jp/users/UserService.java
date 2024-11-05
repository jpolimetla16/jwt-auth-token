package com.jp.users;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepository userRepository;

	public UserResponseDto createUser(UserRequestDto userRequestDto) {
		UserEntity userEntity = mapper.map(userRequestDto, UserEntity.class);
		UserEntity savedEntity = userRepository.save(userEntity);
		return mapper.map(savedEntity, UserResponseDto.class);
	}

	public List<UserResponseDto> getAllUsers() {
		List<UserEntity> list = userRepository.findAll();
		return list.stream().map(userEntity -> new UserResponseDto(userEntity.getUserId(), userEntity.getEmail(),
				userEntity.getPassword())).collect(Collectors.toList());
	}

	public UserResponseDto getUser(String userId) {
		UserEntity userEntity = userRepository.findByUserId(userId).orElseThrow(()->new RuntimeException("Missing User Id:" + userId));
		return mapper.map(userEntity, UserResponseDto.class);
	}

	public UserResponseDto updateUser(String userId, UserRequestDto userRequestDto) {
		UserEntity updatedUser = userRepository.findByUserId(userId)
				.orElseThrow(() -> new RuntimeException("Missing User Id:" +userId));
		updatedUser.setEmail(userRequestDto.getEmail());
		updatedUser.setPassword(userRequestDto.getPassword());
	
		return mapper.map(userRepository.save(updatedUser),UserResponseDto.class);

	}

	public void deleteUser(String userId) {
		UserEntity userEntity = userRepository.findByUserId(userId)
				.orElseThrow(() -> new RuntimeException("Missing User Id:" +userId));
		userRepository.deleteById(userEntity.getId());
	}

}

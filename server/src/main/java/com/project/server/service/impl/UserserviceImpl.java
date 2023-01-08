package com.project.server.service.impl;

import com.project.server.dto.UserDto;
import com.project.server.dto.UserModel;
import com.project.server.entity.*;

import com.project.server.repository.*;

import com.project.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserserviceImpl implements UserService<UserModel> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserLoginRepository userLoginRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    public UserserviceImpl(UserRepository userRepository,
                           UserLoginRepository userLoginRepository,
                           UserAccountRepository userAccountRepository){
        this.userRepository = userRepository;
        this.userLoginRepository=userLoginRepository;
        this.userAccountRepository=userAccountRepository;
    }

    @Override
    public List<UserModel> findAll() {
        return null;
    }

    @Override
    public UserModel findbyId(UUID id) {
        Optional<User> user = userRepository.findById(id);
        Optional<UserLoginDetail> loginDetail = userLoginRepository.findById(user.get().getUserid());
        Optional<UserAccountDetail> accountDetail = userAccountRepository.findById(user.get().getUserid());
        UserModel model = new UserModel(user.get().getUserid(),
                accountDetail.get().getFirstname(),
                accountDetail.get().getSecondname(),
                accountDetail.get().getDob(),
                accountDetail.get().getRole(),
                loginDetail.get().getUsername(),
                loginDetail.get().getPassword(),
                accountDetail.get().getGender(),
                loginDetail.get().getEmail(),
                loginDetail.get().getToken(),
                loginDetail.get().getTokenGeneratedDate(),
                user.get().getCreateddate(),
                accountDetail.get().getAvatarContent());

        return model;
    }

    @Override
    public UserModel findbyToken(String token) {
        UserLoginDetail loginDetail = userLoginRepository.findUserByToken(token);
        User user = userRepository.findIdfromLoginid(loginDetail.getId());
        UserAccountDetail accountDetail = user.getAccountDetail();
        UserModel model = new UserModel(user.getUserid(),
                accountDetail.getFirstname(),
                accountDetail.getSecondname(),
                accountDetail.getDob(),
                accountDetail.getRole(),
                loginDetail.getUsername(),
                loginDetail.getPassword(),
                accountDetail.getGender(),
                loginDetail.getEmail(),
                loginDetail.getToken(),
                loginDetail.getTokenGeneratedDate(),
                user.getCreateddate(),
                accountDetail.getAvatarContent());
        return model;
    }

    @Override
    public void save(UserModel model) {

    }

    @Override
    public void remove(UUID id) {

    }

    @Override
    public String addNewUser(UserModel user) {
        String token = UUID.randomUUID().toString();
        UserLoginDetail loginDetail = new UserLoginDetail(user.getUsername(),
                                                            user.getPassword(),
                                                          user.getEmail(),
                                                        token,
                                                   user.getTokenGeneratedDate());
        UserAccountDetail accountDetail = new UserAccountDetail(user.getFirstname(),
                                                                user.getSecondname(),
                                                                 user.getGender(),
                                                             user.getDob(),user.getRole(),
                                                            user.getAvatarContent());
        User new_user = new User(user.getUserid(),user.getCreateddate(),loginDetail,accountDetail);
        userRepository.save(new_user);
        userLoginRepository.save(loginDetail);
        userAccountRepository.save(accountDetail);
        return token;
    }

    @Override
    public UserModel findbyPassword(String username, String password) {
        UserLoginDetail loginDetail = userLoginRepository.findUserByPassword(username,password);
        User user = userRepository.findIdfromLoginid(loginDetail.getId());
        UserAccountDetail accountDetail = user.getAccountDetail();
        UserModel model = new UserModel(user.getUserid(),
                                    accountDetail.getFirstname(),
                                        accountDetail.getSecondname(),
                                                accountDetail.getDob(),
                                                accountDetail.getRole(),
                                                loginDetail.getUsername(),
                                                loginDetail.getPassword(),
                                                    accountDetail.getGender(),
                                                    loginDetail.getEmail(),
                                                loginDetail.getToken(),
                                                 loginDetail.getTokenGeneratedDate(),
                                                  user.getCreateddate(),accountDetail.getAvatarContent());
        return model;
    }
}

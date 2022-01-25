package com.vijaykumar.user.service;

import com.vijaykumar.user.model.User;
import com.vijaykumar.user.repository.UserRepository;
import com.vijaykumar.user.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserUtils userUtils;

    @Override
    public String createUser(User user) {
        userRepository.saveUser(user);
        return "User Created Successfully";
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userRepository.getUserByEmail(email);
        if(user==null){
            return null;
        }
        return user;
    }

    @Override
    public User updateUserByEmail(String email, User user) {

        User usr = getUserByEmail(email);
        if(usr==null)
            return null;
        User updatedUser = new User(user.getFirstName(),user.getLastName(),user.getEmail(), user.getDueAmount());
        userRepository.saveUser(updatedUser);
        return updatedUser;
    }

    @Override
    public long getDueAmount(String email) {
        User user = getUserByEmail(email);
        if(user==null){
            return 0;
        }
        return user.getDueAmount();
    }

    @Override
    public String clearDueAmount(String email, long paidAmount) {
        long pendingDueAmount = getDueAmount(email);
        String displayMsg;
        if(pendingDueAmount==paidAmount){
            displayMsg = "Your Due is Fully Cleared";
        }else if(pendingDueAmount>paidAmount){
            displayMsg = "After Payment Your Due is "+(pendingDueAmount-paidAmount);
        }else {
            displayMsg = "Your Due is Fully Cleared, Please collect the Remaining Amount At BillDesk. \ni.e"+(paidAmount-pendingDueAmount);
        }

        //Update the Cleared Amount in DB
        User updateUser = getUserByEmail(email);
        updateUser.setDueAmount(pendingDueAmount-paidAmount);

        updateUserByEmail(email,updateUser);

        return displayMsg;
    }

}

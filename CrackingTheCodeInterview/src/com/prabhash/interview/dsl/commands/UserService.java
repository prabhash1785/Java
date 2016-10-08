package com.prabhash.interview.dsl.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Service entity which stores registered users and services.
 * 
 * @author Prabhash Rathore
 *
 */
class UserService {
    private String serviceName;
    private Map<Integer, User> userMap;
    private List<UserService> registeredService;
    
  public UserService(String serviceName) {
      this.serviceName = serviceName;
      this.userMap = new HashMap<>();
      this.registeredService = new ArrayList<>();
  }

  public void addUser(User user) {
      if(user == null) {
          return;
      }
      
      // map will make key is always unique
      userMap.put(user.getId(), user);
      
      // add this user to all registered services
      for(UserService userService : registeredService) {
          // if registered service already contains user then no need to add it again, also prevents cyclic calls
          if(userService.userMap.containsKey(user.getId())) {
              continue;
          }
          userService.addUser(user);
      }
  }

  public void deleteUser(User user) {
      if(user == null) {
          return;
      }
      
      if(userMap.containsKey(user.getId())) {
          userMap.remove(user.getId());
      }
      
      // remove users from registered services
      for(UserService userService : registeredService) {
          // if registered service already does not contain user then no need to delete it again, also prevents cyclic calls
          if(!userService.userMap.containsKey(user.getId())) {
              continue;
          }
          userService.deleteUser(user);
      }
  }

  public List<User> getUsers() {
      Set<Integer> keySet = userMap.keySet();
       List<User> list = new ArrayList<>();
      for(Integer key : keySet) {
          list.add(userMap.get(key));
      }
      return list; 
  }

  public void registerListener(UserService userService) {
      if(userService == null) {
          return;
      }
      
      registeredService.add(userService);
  }

  public void deregisterListener(UserService userService) {
      if(userService == null) {
          return;
      }
      
      registeredService.remove(userService);
  }
    
    @Override
    public boolean equals(Object service) {
        if(service == null) {
            return false;
        }
        
        if(service.getClass() != this.getClass()) {
            return false;
        }
        
        UserService userService = (UserService) service;
        if(userService.serviceName.equals(this.serviceName)) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = hash * 23 + this.serviceName.hashCode();
        return hash;
    }
    
    @Override
    public String toString() {
        return serviceName;
    }
}

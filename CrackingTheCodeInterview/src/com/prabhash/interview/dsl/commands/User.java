package com.prabhash.interview.dsl.commands;

/**
 * User entity
 * 
 * @author Prabhash Rathore
 *
 */
class User {
	  private String name;
	  private int id;
	    
	    public int getId() {
	        return this.id;
	    }

	  public User(String name, int id) {
	    this.name = name;
	    this.id = id;
	  }
	    
	    @Override
	    public boolean equals(Object obj) {
	        if(obj == null) {
	            return false;
	        }
	        
	        if(obj.getClass() != this.getClass()) {
	            return false;
	        }
	        
	        User user = (User) obj;
	        if(user.id == this.id && user.name.equals(this.name)) {
	            return true;
	        }
	        
	        return false;
	    }
	    
	    @Override
	    public int hashCode() {
	        int hash = 7;
	        int prime = 23;
	        hash = hash * prime + this.id + this.name.hashCode();
	        
	        return hash;
	    }
	    
	    @Override
	    public String toString() {
	        return this.name + " " + this.id;
	    }
	}

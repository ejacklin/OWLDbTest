package com.DBTest;

import javax.persistence.EntityManager;

/**
 * Created by Erin on 8/14/2017.
 */
public class UserDB {
    public static User getUserById(Integer userId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
            User user = em.find(User.class, userId);
            return user;
        }finally {
            em.close();
        }
    }

    public static void main(String[] args){
        UserDB db = new UserDB();

        User u = db.getUserById(6);
        System.out.println(u.getFirst_name());
    }
}

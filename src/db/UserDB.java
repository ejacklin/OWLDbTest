package db;


import javax.persistence.EntityManager;

/**
 * Created by Erin on 8/14/2017.
 */
public class UserDB {
    public static UserEntity getUserById(Integer id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
            UserEntity user = em.find(UserEntity.class, id);
            return user;
        }finally {
            em.close();
        }
    }

    public static SessionEntity getSessionById(Integer session_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
            SessionEntity session = em.find(SessionEntity.class, session_id);
            return session;
        }finally {
            em.close();
        }
    }

    public static void main(String[] args){
        UserDB db = new UserDB();

//        Session s = db.getSessionById(2);
        UserEntity u = db.getUserById(12);
        System.out.println(u.getFirstName());
//        System.out.println(s.getDate());
    }
}

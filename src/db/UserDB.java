package db;
import business.*;


import javax.persistence.EntityManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Erin on 8/14/2017.
 */
public class UserDB {

    private static EntityManager em;
    private ArrayList<Session> dSessions = new ArrayList<>();;
    private ArrayList<Exercise> dExercises = new ArrayList<>();


    public static UserEntity getUserById(Integer id){
        em = DBUtil.getEmFactory().createEntityManager();
        try{
            return  em.find(UserEntity.class, id);
        }finally {
            em.close();
        }
    }


    public UserEntity findWithUsername(String username) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List userEntities = em.createQuery(
                "SELECT u FROM UserEntity u WHERE u.username LIKE :username")
                .setParameter("username",username)
                .setMaxResults(10)
                .getResultList();
        em.close();
        return (UserEntity) userEntities.get(0);
    }


    public User GetDBResponse(UserEntity userEntity){
        Collection<SessionEntity> sessions = userEntity.getSessionsByUserId();
        Workout work = null;
        for (SessionEntity s : sessions){
            Collection<WorkoutEntity> workouts = s.getWorkoutsBySessionId();
            for(WorkoutEntity w : workouts){

                Collection<ExerciseEntity> exercises = w.getExercisesByWorkoutId();
                for(ExerciseEntity e: exercises){
                    Collection<CardioEntity> cardios = e.getCardiosByExerciseId();
                    for( CardioEntity c : cardios){
                        dExercises.add(new Cardio(e.getName(),Integer.toString(c.getTime()),
                                Integer.toString(c.getDistance())));
                    }
                    Collection<StrengthEntity> strengths = e.getStrengthsByExerciseId();
                    for(StrengthEntity st : strengths){
                        System.out.println(e.getName() + "  " + Integer.toString(st.getReps()) + "  " +
                                Integer.toString(st.getWeight())  + "  " + Integer.toString(st.getSets()));
                        Strength strength = new Strength(e.getName(),Integer.toString(st.getReps()),
                                Integer.toString(st.getWeight()),Integer.toString(st.getSets()));
                        dExercises.add(strength);
                    }
                }
                 work = new Workout(w.getName(),dExercises);
            }
            DateFormat format_date = new SimpleDateFormat("EEE, MMM d, ''yy");
            dSessions.add(new Session(format_date.format(s.getDate()),work));
        }

        return new User(userEntity.getUsername(),userEntity.getPassword(),userEntity.getEmail(),dSessions);
    }




    public static void main(String[] args){
        UserDB userDB = new UserDB();
        UserEntity user = userDB.findWithUsername("tlanister");
        User u = userDB.GetDBResponse(user);
        System.out.println(user.getLastName());
    }
}

package db;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Erin on 8/13/2017.
 */
@Entity
@Table(name = "session", schema = "owl_schema", catalog = "")
public class SessionEntity {
    private int sessionId;
    private int userId;
    private Date date;
    private UserEntity userByUserId;
    private Collection<WorkoutEntity> workoutsBySessionId;

    @Id
    @Column(name = "session_id", nullable = false)
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "user_id", nullable = false, updatable = false, insertable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionEntity that = (SessionEntity) o;

        if (sessionId != that.sessionId) return false;
        if (userId != that.userId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId;
        result = 31 * result + userId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "sessionBySessionId")
    public Collection<WorkoutEntity> getWorkoutsBySessionId() {
        return workoutsBySessionId;
    }

    public void setWorkoutsBySessionId(Collection<WorkoutEntity> workoutsBySessionId) {
        this.workoutsBySessionId = workoutsBySessionId;
    }
}

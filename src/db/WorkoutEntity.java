package db;

import javax.persistence.*;

/**
 * Created by Erin on 8/13/2017.
 */
@Entity
@Table(name = "workout", schema = "owl_schema", catalog = "")
public class WorkoutEntity {
    private int workoutId;
    private int sessionId;
    private String name;

    @Id
    @Column(name = "workout_id")
    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    @Basic
    @Column(name = "session_id")
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkoutEntity that = (WorkoutEntity) o;

        if (workoutId != that.workoutId) return false;
        if (sessionId != that.sessionId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workoutId;
        result = 31 * result + sessionId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

package db;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Erin on 8/13/2017.
 */
@Entity
@Table(name = "exercise", schema = "owl_schema", catalog = "")
public class ExerciseEntity {
    private int exerciseId;
    private int workoutId;
    private Serializable type;
    private Integer distance;
    private Integer time;
    private Integer weight;
    private Integer sets;
    private Integer reps;
    private String name;

    @Id
    @Column(name = "exercise_id")
    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    @Basic
    @Column(name = "workout_id")
    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    @Basic
    @Column(name = "type")
    public Serializable getType() {
        return type;
    }

    public void setType(Serializable type) {
        this.type = type;
    }

    @Basic
    @Column(name = "distance")
    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "time")
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Basic
    @Column(name = "weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "sets")
    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    @Basic
    @Column(name = "reps")
    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
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

        ExerciseEntity that = (ExerciseEntity) o;

        if (exerciseId != that.exerciseId) return false;
        if (workoutId != that.workoutId) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (distance != null ? !distance.equals(that.distance) : that.distance != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (sets != null ? !sets.equals(that.sets) : that.sets != null) return false;
        if (reps != null ? !reps.equals(that.reps) : that.reps != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exerciseId;
        result = 31 * result + workoutId;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (sets != null ? sets.hashCode() : 0);
        result = 31 * result + (reps != null ? reps.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

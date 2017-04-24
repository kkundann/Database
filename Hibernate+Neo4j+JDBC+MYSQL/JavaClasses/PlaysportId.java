/**
 * Created by kundan on 10/18/16.
 */

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PlaysportId implements Serializable {

    private Student student;
    private Sport sport;

    @ManyToOne(cascade = CascadeType.ALL)
    public Student getStudent()
    {
        return student;
    }
    public void setStudent(Student student)
    {
        this.student = student;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Sport getSport()
    {
        return sport;
    }
    public void setSport(Sport sport) {
        this.sport = sport;
    }
}

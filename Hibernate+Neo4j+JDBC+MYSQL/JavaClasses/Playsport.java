/**
 * Created by kundan on 10/18/16.
 */
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "play_sport")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.student",
                joinColumns = @JoinColumn(name = "SID")),
        @AssociationOverride(name = "primaryKey.sport",
                joinColumns = @JoinColumn(name = "SPID")) })
public class Playsport
{
    //Composite ID
    private PlaysportId primaryKey = new PlaysportId();

    //Additional Column
    private String level;
    private String totalhour;


    @EmbeddedId
    public PlaysportId getPrimaryKey()
    {
        return this.primaryKey;
    }

    public void setPrimaryKey(PlaysportId primaryKey)
    {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Student getStudent()
    {
        return getPrimaryKey().getStudent();
    }
    public void setStudent(Student student)
    {
        getPrimaryKey().setStudent(student);
    }

    @Transient
    public Sport getSport()
    {
        return getPrimaryKey().getSport();
    }
    public void setSport(Sport sport)
    {
        getPrimaryKey().setSport(sport);
    }

    @Column(name = "LEVEL")
    public String getLevel()
    {
        return this.level;
    }
    public void setLevel(String level)
    {
        this.level = level;
    }

    @Column(name = "TOTALHOUR")
    public String getTotalhour()
    {
        return this.totalhour;
    }
    public void setTotalhour(String totalhour)
    {
        this.totalhour = totalhour;
    }

}



/**
 * Created by kundan on 10/18/16.
 */
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student
{
    private long sid;
    private String sname;
    private String sgender;
    private String sage;
    private String smajor;
    private Set<Playgame> playgameSet = new HashSet<Playgame>();
    private Set<Playsport> playsportSet = new HashSet<Playsport>();

    public Student(String sname,String sgender,String sage,String smajor)
    {
        this.sname = sname;
        this.sgender = sgender;
        this.sage = sage;
        this.smajor = smajor;
    }


    public Student()
    {
        //Empty constructor is required by Hibernate
    }

    @Id
    @GeneratedValue
    @Column(name = "SID")
    public long getSid()
    {
        return this.sid;
    }
    public void setSid(long sid)
    {
        this.sid = sid;
    }

    @Column(name = "SNAME")
    public String getSname()
    {
        return this.sname;
    }
    public void setSname(String sname)
    {
        this.sname = sname;
    }

    @Column(name = "SGENDER")
    public String getSgender()
    {
        return this.sgender;
    }
    public void setSgender(String sgender)
    {
        this.sgender = sgender;
    }

    @Column(name = "SAGE")
    public String getSage()
    {
        return this.sage;
    }
    public void setSage(String sage)
    {
        this.sage = sage;
    }

    @Column(name = "SMAJOR")
    public String getSmajor()
    {
        return this.smajor;
    }
    public void setSmajor(String smajor)
    {
        this.smajor = smajor;
    }

    @OneToMany(mappedBy = "primaryKey.student", cascade = CascadeType.ALL)
    public Set<Playgame> getPlaygameSet()
    {
        return this.playgameSet;
    }
    public void setPlaygameSet(Set<Playgame> playgameSet)
    {
        this.playgameSet = playgameSet;
    }

    public void addPlaygame(Playgame playgame)
    {
        this.playgameSet.add(playgame);
    }

    @OneToMany(mappedBy = "primaryKey.student", cascade = CascadeType.ALL)
    public Set<Playsport> getPlaysportSet()
    {
        return this.playsportSet;
    }
    public void setPlaysportSet(Set<Playsport> playsportSet)
    {
        this.playsportSet = playsportSet;
    }

    public void addPlaysport(Playsport playsport)
    {
        this.playsportSet.add(playsport);
    }

}


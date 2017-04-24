/**
 * Created by kundan on 10/18/16.
 */

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "sport")
public class Sport
{
    private long spid;
    private String spname;
    private String sptype;

    public Sport(String spname,String sptype)
    {
        this.spname = spname;
        this.sptype=sptype;
    }

    public Sport()
    {
        //Empty constructor is required by Hibernate
    }

    @Id
    @GeneratedValue
    @Column(name = "SPID")
    public long getSpid()
    {
        return this.spid;
    }
    public void setSpid(long spid)
    {
        this.spid = spid;
    }

    @Column(name = "SPNAME")
    public String getSpname()
    {
        return this.spname;
    }
    public void setSpname(String spname)
    {
        this.spname = spname;
    }

    @Column(name = "SPTYPE")
    public String getSptype()
    {
        return this.sptype;
    }
    public void setSptype(String sptype)
    {
        this.sptype = sptype;
    }


}

/**
 * Created by kundan on 10/18/16.
 */
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game
{
    private long gid;
    private String gname;
    private String ggenre;

    public Game(String gname,String ggenre)
    {
        this.gname = gname;
        this.ggenre =ggenre;
    }

    public Game()
    {
        //Empty constructor is required by Hibernate
    }

    @Id
    @GeneratedValue
    @Column(name = "GID")
    public long getGid()
    {
        return this.gid;
    }
    public void setGid(long gid)
    {
        this.gid = gid;
    }

    @Column(name = "GNAME")
    public String getGname()
    {
        return this.gname;
    }
    public void setGname(String gname)
    {
        this.gname = gname;
    }

    @Column(name = "GGENRE")
    public String getGgenre()
    {
        return this.ggenre;
    }
    public void setGgenre(String ggenre)
    {
        this.ggenre = ggenre;
    }


}

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
@Table(name = "play_game")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.student",
                joinColumns = @JoinColumn(name = "SID")),
        @AssociationOverride(name = "primaryKey.game",
                joinColumns = @JoinColumn(name = "GID")) })
public class Playgame
{
    //Composite ID
    private PlaygameId primaryKey = new PlaygameId();

    //Additional Column
    private String platform;
    private String totalhour;

    @EmbeddedId
    public PlaygameId getPrimaryKey()
    {
        return primaryKey;
    }

    public void setPrimaryKey(PlaygameId primaryKey)
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
    public Game getGame()
    {
        return getPrimaryKey().getGame();
    }
    public void setGame(Game game)
    {
        getPrimaryKey().setGame(game);
    }

    @Column(name = "PLATFORM")
    public String getPlatform()
    {
        return this.platform;
    }
    public void setPlatform(String platform)
    {
        this.platform = platform;
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


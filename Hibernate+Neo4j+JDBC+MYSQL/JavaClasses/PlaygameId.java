/**
 * Created by kundan on 10/18/16.
 */

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PlaygameId implements Serializable{

    private Student student;
    private Game game;

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
    public Game getGame()
    {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
}

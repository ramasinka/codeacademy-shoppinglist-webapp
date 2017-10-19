package lt.codeacademy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ShareSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;
    private long listId;
    private long toUserId;
    private String email;
    private Date date;
    private String status;

    public ShareSummary(long userId, long listId, String email) {
        this.userId = userId;
        this.listId = listId;
        this.email = email;
    }
}

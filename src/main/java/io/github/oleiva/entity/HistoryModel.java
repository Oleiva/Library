package io.github.oleiva.entity;

/**
 * Created by OleIva on 21.03.2016.
 */

//        import com.google.common.base.Objects;
//        import edu.com.softserveinc.bawl.models.enums.IssueStatus;
        import org.apache.log4j.Logger;

        import javax.persistence.*;
        import javax.validation.constraints.NotNull;
        import java.util.Date;


@Entity
@Table(name="HISTORY")
public class HistoryModel {

    public static final Logger LOG=Logger.getLogger(HistoryModel.class);

    @Id
    @GeneratedValue
    @Column(unique=true, name="ID")
    private int id;

    @Column(name="USER_ID")
    private int userId;

//    @Column(name="STATUS")
//    @Enumerated(EnumType.STRING)
//    private IssueStatus status;

    @Column(name="DATE", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date date;

//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "ISSUE_ID")
//    private IssueModel issue;

    public HistoryModel(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
//
//    public IssueStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(IssueStatus status) {
//        this.status = status;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public IssueModel getIssue() {
//        return issue;
//    }

//    public void setIssue(IssueModel issue) {
//        this.issue = issue;
//    }

    public HistoryModel withUserId(int userId) {
        this.userId = userId;
        return this;
    }

//    public HistoryModel withStatus(IssueStatus status) {
//        this.status = status;
//        return this;
//    }

    public HistoryModel withDate(Date date) {
        this.date = date;
        return this;
    }

//    public HistoryModel withIssue(IssueModel issue) {
//        this.issue = issue;
//        return this;
//    }


}
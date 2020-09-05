package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "follow")

@Entity
public class Follow {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "follow_id", nullable = false)
    private Employee follow_id;

    @ManyToOne
    @JoinColumn(name = "followed_id", nullable = false)
    private Employee followed_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getFollow_id() {
        return follow_id;
    }

    public void setFollow_id(Employee follow_id) {
        this.follow_id = follow_id;
    }

    public Employee getFollowed_id() {
        return followed_id;
    }

    public void setFollowed_id(Employee followed_id) {
        this.followed_id = followed_id;
    }
}
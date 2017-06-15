package com.gluteen.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yusufaslan on 31.05.2017.
 */
@Entity
@NoArgsConstructor
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titleBody;

    @Temporal(TemporalType.TIMESTAMP)
    private Date titleCreated;

    @ManyToOne
    @JoinColumn(name = "title_creater_id")
    private Person titleCreater;

    public Title(String titleBody, Date titleCreated, Person titleCreater) {
        this.titleBody = titleBody;
        this.titleCreated = titleCreated;
        this.titleCreater = titleCreater;
    }

    public Person getTitleCreater() {
        return titleCreater;
    }

    public void setTitleCreater(Person titleCreater) {
        this.titleCreater = titleCreater;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleBody() {
        return titleBody;
    }

    public void setTitleBody(String titleBody) {
        this.titleBody = titleBody;
    }

    public Date getTitleCreated() {
        return titleCreated;
    }

    public void setTitleCreated(Date titleCreated) {
        this.titleCreated = titleCreated;
    }



}

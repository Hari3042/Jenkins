package com.appranix.demo.locations.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "build_info")
public class BuildInfo {

    @Id
    @Column
    private String id;

    @Column
    private String buildName;

    @Column
    private Date createdAt;

    public BuildInfo() {}

    public BuildInfo(String id, String buildName, Date createdAt) {
        this.id = id;
        this.buildName = buildName;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

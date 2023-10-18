package com.example.hospital.model;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name="user")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String name;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "realname", nullable = false)
    private String realname;
    @Column(name = "telephone", nullable = false)
    private String telephone;
    @Column(name = "dept_id", nullable = false)
    private Long dept_id;
    @Column(name = "user_type", nullable = false)
    private Long user_type;
    @Column(name = "last_login", nullable = false)
    private LocalDateTime last_login;
    @Column(name = "active", nullable = false, columnDefinition = "int default 1 comment '1:active, 0:inactive'")
    private int active = 1;
    @Column(name = "create_time", nullable = false)
    private LocalDateTime create_time;
    public Doctor() {
    }
    public Doctor(Long id, String name, String password, String realname, String telephone, Long dept_id, Long user_type, LocalDateTime last_login, int active, LocalDateTime create_time) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.realname = realname;
        this.telephone = telephone;
        this.dept_id = dept_id;
        this.user_type = user_type;
        this.last_login = last_login;
        this.active = active;
        this.create_time = create_time;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setRealname(String realname){
        this.realname = realname;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public void setDept_id(Long dept_id){
        this.dept_id = dept_id;
    }
    public void setUser_type(Long user_type){
        this.user_type = user_type;
    }
    public void setLast_login(LocalDateTime last_login){
        this.last_login = last_login;
    }
    public void setActive(int active){
        this.active = active;
    }
    public void setCreate_time(LocalDateTime create_time){
        this.create_time = create_time;
    }
}

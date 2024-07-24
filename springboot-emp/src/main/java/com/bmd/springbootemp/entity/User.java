package com.bmd.springbootemp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //400表示参数封装问题
    private Integer id;
    private String uname;
    private String upwd;
    private String email;
    private String phone;
    private Integer gender;
    private Integer dept_id;
    private String pname;
}

package com.bmd.springbootemp.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Community {
    private Integer cId;
    private String Category;
    private String cName;
    private String cAuthor;
    private String cDate;
    private Integer cNumber;
    private Integer cCode;
}

package com.example.rest.entity;

import lombok.Data;
import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author
 * @create 2021 - 03 - 04 下午 01:30
 **/
@Table(name = "Resources")
@Entity
@Data
public class Resources {
    @Id
    @Column(name = "Uid")
    private String uid;

    @Column(name = "Type")
    private String type;

    @Column(name = "FileName")
    private String fileName;

    @Column(name = "Contents")
    private byte [] contents;
}

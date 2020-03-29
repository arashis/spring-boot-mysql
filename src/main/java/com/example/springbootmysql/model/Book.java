package com.example.springbootmysql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/*
* delete_flag=0(ture)のものだけ取り出したかったら@Whereでしていできる
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer bookId;

    /*
    * 値の検証をしたければ以下のようなアノテーションをつけるとよい
    * NotNull : nullはダメ
    * Column(nullable = false, unique = ture) : nullはダメ、重複する値はダメ
    * Pattern(regexp = "", message = "") : 受け取る文字列の正規表現
    * Size(max = , min = ) : 受け取る値の最大値最小値
    * */
    private String title;

    private String description;

    @Column(nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean deleteFlag;
}

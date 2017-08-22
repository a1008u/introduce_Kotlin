package com.info.introduce.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "User")
open class User {

    @Id
    @Column
    var userno :String = "Unkown"
    
    // @Column
    // private var username:String = "Unkown"

    // @JsonIgnore REST APIでUserクラスをJSON出力する場合に、パスワード・フィールドを除外する
    @JsonIgnore
    @Column
    var encodedPassword:String = "Unkown"

}
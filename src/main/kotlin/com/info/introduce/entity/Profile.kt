package com.info.introduce.entity

import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

@Entity
@Table(name = "Profile")
data class Profile(
        @Id @GeneratedValue @Column
        var Id: Int? = null,

        @Column(nullable = false)
        var userno: String = "",

         @Column(nullable = false) @Size(min = 1, max = 30)
        var name: String = "",

        @Column(nullable = false) @Max(150) @Min(0)
        var age: Int? = 0,

        @Column(nullable = false)
        var Department: String  = "",

        @Column
         var Club: String = "",

         @Column(nullable = false)
         var Dispatchlocation: String = "",

        @Column
        var Freetext: String = ""
){}
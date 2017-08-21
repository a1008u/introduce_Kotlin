package com.info.introduce.app.repository

import com.info.introduce.entity.Profile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface ProfileRepository : JpaRepository<Profile, Integer> {

    fun findByUserno(Userno:String) : Profile

    @Query("SELECT x FROM Profile x ORDER BY x.id")
    fun findAllOrderByName() : MutableList<Profile>

}

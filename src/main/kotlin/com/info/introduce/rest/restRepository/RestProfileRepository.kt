package com.info.introduce.rest.restRepository

import com.info.introduce.entity.Profile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RestProfileRepository : JpaRepository<Profile, Integer> {
    
    fun findByUserno(Userno:String) : Profile

    @Query("SELECT x FROM Profile x ORDER BY x.id")
    fun findAllOrderByName() : MutableList<Profile>

    fun deleteByUserno(userno: String)

}


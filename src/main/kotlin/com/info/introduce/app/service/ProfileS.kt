package com.info.introduce.app.service

import com.info.introduce.app.bean.ProfileBean
import com.info.introduce.app.repository.ProfileRepository
import com.info.introduce.entity.Profile
import com.info.introduce.rest.restBean.RestProfileBean
import com.info.introduce.rest.restRepository.RestProfileRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired

abstract class ProfileS {

    @Autowired
    lateinit var RestProfileRepository: RestProfileRepository

    @Autowired
    lateinit var ProfileRepository : ProfileRepository

    // extension
    fun ProfileBean.copyProfile(): Profile {
        val Profile = ProfileRepository.findByUserno(Userno)
        BeanUtils.copyProperties(this, Profile)
        return Profile
    }

    fun RestProfileBean.copyProfile(): Profile {
        val Profile = RestProfileRepository.findByUserno(Userno)
        BeanUtils.copyProperties(this, Profile)
        return Profile
    }

}
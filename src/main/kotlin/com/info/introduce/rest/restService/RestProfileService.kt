package com.info.introduce.rest.restService

import com.info.introduce.app.bean.ProfileBean
import com.info.introduce.entity.Profile
import com.info.introduce.rest.restBean.RestProfileBean
import com.info.introduce.rest.restRepository.RestProfileRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RestProfileService{

    @Autowired
    lateinit var RestProfileRepository: RestProfileRepository

    // 【cRud】--------------------------------------------
    fun findAll(): List<ProfileBean> = RestProfileRepository.findAllOrderByName().run {
        val ProfileBeanList = mutableListOf<ProfileBean>()
        forEach { profile -> ProfileBeanList.add(ProfileBean().also {BeanUtils.copyProperties(profile, it)}) }
        ProfileBeanList
    }

    fun findOne(RestProfileBean: RestProfileBean): RestProfileBean {
        val Profile = RestProfileRepository.findByUserno(RestProfileBean.Userno)
        BeanUtils.copyProperties(Profile, RestProfileBean)
        return RestProfileBean
    }

    // 【Crud】--------------------------------------------
    fun create(RestProfileBean: RestProfileBean): Profile = RestProfileRepository.saveAndFlush(RestProfileBean.copyProfile())

    // 【crUd】--------------------------------------------
    fun update(RestProfileBean: RestProfileBean): Profile = RestProfileRepository.saveAndFlush(RestProfileBean.copyProfile())

    // 【cruD】--------------------------------------------
    // findOne→delete
    fun delete(RestProfileBean: RestProfileBean) = RestProfileRepository.deleteByUserno(RestProfileBean.Userno)

    // extension
    private fun RestProfileBean.copyProfile(): Profile {
        val Profile = RestProfileRepository.findByUserno(Userno)
        BeanUtils.copyProperties(this, Profile)
        return Profile
    }
}
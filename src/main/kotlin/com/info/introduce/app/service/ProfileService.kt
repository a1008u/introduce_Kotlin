package com.info.introduce.app.service

import com.info.introduce.app.bean.ProfileBean
import com.info.introduce.app.repository.ProfileRepository
import com.info.introduce.entity.Profile
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
@ComponentScan("bean")
class ProfileService : ProfileS() {

    // 【cRud】--------------------------------------------
    fun findAll(): List<ProfileBean> = ProfileRepository.findAllOrderByName().run {
        val ProfileBeanList = mutableListOf<ProfileBean>()
        forEach { profile -> ProfileBeanList.add(ProfileBean().also {BeanUtils.copyProperties(profile, it)}) }
        ProfileBeanList
    }

    // 【cRud】--------------------------------------------
    fun findOne(ProfileBean: ProfileBean): ProfileBean {
        val Profile = ProfileRepository.run { findByUserno(ProfileBean.Userno)}
        BeanUtils.copyProperties(Profile, ProfileBean)
        return ProfileBean
    }

    // 【Crud】--------------------------------------------
    fun create(ProfileBean: ProfileBean): Profile = ProfileRepository.run { save(ProfileBean.copyProfile()) }

    // 【crUd】--------------------------------------------
    fun update(ProfileBean: ProfileBean): Profile = ProfileRepository.run { save(ProfileBean.copyProfile()) }

    fun findOneAndSave(ProfileBean: ProfileBean): Profile {
        val Profile = ProfileRepository.run { findByUserno(ProfileBean.Userno) }
        BeanUtils.copyProperties(ProfileBean, Profile)
        return ProfileRepository.run { save(Profile) }
    }

    // 【cruD】--------------------------------------------
    // findOne→delete
    fun delete(ProfileBean: ProfileBean) =
            ProfileRepository.run { delete(ProfileRepository.run { findByUserno(ProfileBean.Userno) }) }
}

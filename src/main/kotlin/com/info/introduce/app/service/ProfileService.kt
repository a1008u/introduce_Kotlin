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
class ProfileService {

	@Autowired
	val ProfileRepository :ProfileRepository? = null

    // 【cRud】--------------------------------------------
    fun findAll(): List<ProfileBean> {

        val ListProfile = ProfileRepository?.run{ findAllOrderByName()}

        val ProfileBeanList = ListProfile?.run {
            val ProfileBeanList = mutableListOf<ProfileBean>()

            this.forEach { profile ->
                val ProfileBean = ProfileBean()
                BeanUtils.copyProperties(profile, ProfileBean)
                ProfileBeanList.add(ProfileBean)
            }
            ProfileBeanList
        }

        return ProfileBeanList as MutableList<ProfileBean>
    }

    // 【cRud】--------------------------------------------
    fun findOne(ProfileBean: ProfileBean): ProfileBean {
        val Profile = ProfileRepository?.run { findByUserno(ProfileBean.Userno)}
        BeanUtils.copyProperties(Profile, ProfileBean)
        return ProfileBean
    }

    // 【Crud】--------------------------------------------
    fun create(ProfileBean: ProfileBean): Profile {
        val Profile = copyProfile(ProfileBean)
        return ProfileRepository?.run { save(Profile) } as Profile
    }

    // 【crUd】--------------------------------------------
    fun update(ProfileBean: ProfileBean): Profile {
        val Profile = copyProfile(ProfileBean)
        return ProfileRepository?.run { save(Profile) } as Profile
    }

    fun findOneAndSave(ProfileBean: ProfileBean): Profile {
        val Profile = ProfileRepository?.run { findByUserno(ProfileBean.Userno) }
        BeanUtils.copyProperties(ProfileBean, Profile)
        return ProfileRepository?.run { save(Profile) } as Profile
    }

    // 【cruD】--------------------------------------------
    // findOne→delete
    fun delete(ProfileBean: ProfileBean) {
        val Profile = ProfileRepository?.run { findByUserno(ProfileBean.Userno) }
        ProfileRepository?.run { delete(Profile) }
    }

    // Common Pattern
    private fun copyProfile(ProfileBean: ProfileBean): Profile {
        val Profile = Profile()
        BeanUtils.copyProperties(ProfileBean, Profile)
        return Profile
    }

}

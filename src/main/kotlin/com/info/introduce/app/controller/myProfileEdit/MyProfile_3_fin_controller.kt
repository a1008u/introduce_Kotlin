package com.info.introduce.app.controller.myProfileEdit

import com.info.introduce.app.bean.ProfileBean
import com.info.introduce.app.controller.form.ProfileForm
import com.info.introduce.app.service.ProfileService
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.support.SessionStatus

@Controller
@RequestMapping("MyProfile_fin")
@SessionAttributes(value = "MyProfileForm")
@ComponentScan("bean")
class MyProfile_3_fin_controller {

    @Autowired
    lateinit var ProfileService: ProfileService

    @Autowired
    lateinit var ProfileBean: ProfileBean

    /**
     * 1.セッションを削除
     * @param sessionStatus
     */
    @GetMapping
    fun clearSession(sessionStatus: SessionStatus): String {

        sessionStatus.setComplete()
        return "myprofile/MyProfile_fin"
    }

    /**
     * 2.編集情報を保存する
     * @param Mav
     * @param MyProfileForm @ModelAttribute("MyProfileForm")
     */
    @PostMapping
    internal fun updateForm(Mav: Model, @ModelAttribute("MyProfileForm") MyProfileForm: ProfileForm): String {

        BeanUtils.copyProperties(MyProfileForm, ProfileBean)
        ProfileService?.run { findOneAndSave(ProfileBean as ProfileBean) }

        return "redirect:/MyProfile_fin"
    }
}
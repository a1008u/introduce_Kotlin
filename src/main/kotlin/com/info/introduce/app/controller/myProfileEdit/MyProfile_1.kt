package com.info.introduce.app.controller.myProfileEdit

import com.info.introduce.app.bean.ProfileBean
import com.info.introduce.app.controller.form.ProfileForm
import com.info.introduce.app.service.LoginUserDetails
import com.info.introduce.app.service.ProfileService
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("MyProfile")
@SessionAttributes(value = *arrayOf("MyProfileBean","MyProfileForm"))
@ComponentScan("bean")
class MyProfile_1 {
    @Autowired
    lateinit var ProfileService: ProfileService

    @Autowired
    lateinit var ProfileBean: ProfileBean

    /**
     * 1.リクエスト時に必ず呼び出す(Formの初期化)-------------------
     * ＊セッションにMyProfileFormを格納する
     */
    @ModelAttribute(value = "MyProfileForm")
    internal fun setUpMyProfileForm(): ProfileForm {

        println("【セッション情報の作成】-----------------------------------------")
        println("create MyProfileForm")
        println("-----------------------------------------【セッション情報の作成】")

        return ProfileForm()
    }

    /**
     * 2-1----------------------------------------------------
     * ログインユーザ(自分)の情報をFormに格納し、MyProfile編集ページへ

     * @param model
     * @param MyProfileForm ＊セッションに格納しているFormを取得
     * @param userDetails　@AuthenticationPrincipal
     * @param MyProfileBean @ModelAttribute("MyProfileBean")
     */
    @GetMapping
    internal fun MyEditForm(model: Model,
                            MyProfileForm: ProfileForm,
                            @AuthenticationPrincipal userDetails: LoginUserDetails,
                            @ModelAttribute("MyProfileBean") MyProfileBean: ProfileBean): String {

        BeanUtils.copyProperties(MyProfileBean, MyProfileForm)
        model.addAttribute("MyProfileForm", MyProfileForm)

        return "myprofile/MyProfile"
    }

    /**
     * 2-2----------------------------------------------------
     * ProfileListからUserNoを取得し、Profile編集ページへ
     * (Profile編集ページは2-1と共通)
     * @param userno @RequestParam
     * @param model
     * @param MyProfileForm ＊セッションに格納しているFormを取得
     */
    @GetMapping(path = arrayOf("edit"))
    internal fun ListEditForm(@RequestParam("userno") userno: String,
                              model: Model,
                              MyProfileForm: ProfileForm): String {

        ProfileBean.apply { Userno = userno }
        ProfileBean = ProfileService.run { findOne(ProfileBean) }
        BeanUtils.copyProperties(ProfileBean, MyProfileForm)
        model.addAttribute("MyProfileForm", MyProfileForm)

        return "myprofile/MyProfile"
    }

}
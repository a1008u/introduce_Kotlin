package com.info.introduce.app.controller.myProfileEdit

import com.info.introduce.app.controller.form.ProfileForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("MyProfile_confirm")
@SessionAttributes(value = "MyProfileForm")
class MyProfile_2_confirm_controller {

    /**
     * 2-1----------------------------------------------------
     * 編集情報を取得し、入力→確認画面へ
     * @param Mav
     * @param MyProfileForm　@Validated @ModelAttribute("MyProfileForm") ＊セッションに格納しているFormを取得
     * @param result
     */
    @PostMapping
    internal fun editForm(Mav: Model,
                          @Validated @ModelAttribute("MyProfileForm") MyProfileForm: ProfileForm,
                          result: BindingResult): String {

        // 単項目チェック
        if (result.hasErrors()) return "myprofile/MyProfile"

        // 相関チェック

        // Usernoの確認
        Check_Userno(MyProfileForm)

        return "myprofile/MyProfile_confirm"
    }

    /**
     * 2-1----------------------------------------------------
     * 確認画面→入力画面へ
     * @param Mav
     * @param MyProfileForm　@Validated @ModelAttribute("MyProfileForm") ＊セッションに格納しているFormを取得
     * @param result
     */
    @GetMapping(path = arrayOf("return"))
    internal fun retrunForm(Mav: Model,
                            @Validated @ModelAttribute("MyProfileForm") MyProfileForm: ProfileForm,
                            result: BindingResult): String {

        // 単項目チェック
        if (result.hasErrors()) return "myprofile/MyProfile"

        // 相関チェック

        // Usernoの確認
        Check_Userno(MyProfileForm)
        return "myprofile/MyProfile"
    }

    //
    /**
     * 共通メソッド----------------------------------------------------------
     * Usernoの確認
     * @param MyProfileForm　
     */
    private fun Check_Userno(MyProfileForm: ProfileForm) {
        println("========================")
        System.out.println("  社員番号：" + MyProfileForm.userno)
        println("========================")
    }
}
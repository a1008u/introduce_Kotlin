package com.info.introduce.app.controller

import com.info.introduce.app.bean.ProfileBean
import com.info.introduce.app.service.LoginUserDetails
import com.info.introduce.app.service.ProfileService
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.SessionAttributes


@Controller
//マッピングするURLの接頭辞
@RequestMapping(value = "/Top", method = arrayOf(RequestMethod.GET))
@SessionAttributes(value = "MyProfileBean")
@ComponentScan("bean")
public class TopController {

	@Autowired
	internal var profileService: ProfileService? = null

	/**
	 * メイン画面表示
	 * MyProfileを取得して、Topページへ
	 * @param model
	 * @param userDetails @AuthenticationPrincipal
	 */
	@GetMapping
	internal fun list(model: Model, @AuthenticationPrincipal userDetails: LoginUserDetails): String {

		println("【ログイン情報の確認】-----------------------------------------")
		println("ログインしました")
		println("-----------------------------------------【ログイン情報の確認】")

		model.addAttribute("MyProfileBean", createMyProfileBean(userDetails))

		return "contents/Top"
	}

	/**
	 * MyProfileを取得
	 * @param userDetails
	 */
	private fun createMyProfileBean(userDetails: LoginUserDetails): ProfileBean {
		val MyProfileBean = ProfileBean()
		MyProfileBean.Userno = userDetails.loginUser?.userno as String
		val ProfileBean = profileService?.run { findOne(MyProfileBean) }
		BeanUtils.copyProperties(ProfileBean, MyProfileBean)
		return MyProfileBean
	}
}

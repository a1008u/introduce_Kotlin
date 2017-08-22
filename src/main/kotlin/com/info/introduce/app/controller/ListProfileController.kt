package com.info.introduce.app.controller

import com.info.introduce.app.service.ProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("ListProfile")
class ListProfileController {
    @Autowired
    internal var ProfileService: ProfileService? = null

    /**
     * Profile一覧を表示する。
     * @param model
     */
    @GetMapping
    internal fun list(model: Model): String {

        val ListProfile = ProfileService?.run { findAll() }
        model.addAttribute("ListProfile", ListProfile)

        return "contents/ListProfile"
    }

}
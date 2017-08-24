package com.info.introduce.rest.restController

import com.info.introduce.rest.restBean.RestProfileBean
import com.info.introduce.rest.restService.RestProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/Top")
class TopRestController {

    @Autowired
    lateinit var RestProfileService: RestProfileService

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.GET))
    internal fun getCustomer(@PathVariable Userno: String): RestProfileBean {

        ZonedDateTime.now().show()
        return RestProfileBean(Userno).apply { RestProfileService.findOne(this) }
    }

    fun ZonedDateTime.show(){
        var nowTime = this.run { format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) }
        println("=== ajaxを押下した時刻：$nowTime ===")
    }

}
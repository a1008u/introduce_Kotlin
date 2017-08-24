package com.info.introduce.rest.restBean

import org.springframework.stereotype.Component

@Component
data class RestProfileBean(var Userno: String = "Unknown",
                      var Name: String = "Unknown",
                      var Age: Int = 0,
                      var Department: String = "Unknown",
                      var Club: String = "Unknown",
                      var Dispatchlocation: String = "Unknown",
                      var Freetext: String = "Unknown") {}
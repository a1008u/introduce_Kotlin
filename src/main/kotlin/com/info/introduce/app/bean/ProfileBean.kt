package com.info.introduce.app.bean

import org.springframework.stereotype.Component

@Component
class ProfileBean(var Userno: String = "Unknown",
                  var Name: String = "Unknown",
                  var Age: Int = 0,
                  var Department: String = "Unknown",
                  var Club: String = "Unknown",
                  var Dispatchlocation: String = "Unknown",
                  var Freetext: String = "Unknown") {}

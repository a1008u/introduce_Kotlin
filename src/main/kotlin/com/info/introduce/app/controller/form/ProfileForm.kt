package com.info.introduce.app.controller.form

import org.hibernate.validator.constraints.NotBlank
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

class ProfileForm {

    private var id: Int? = null

    @NotBlank
    @Size(min = 1, max = 30)
    var Name: String? = null

    @NotBlank
    var userno: String? = null

    @Max(150)
    @Min(0)
    var Age: Int? = null

    @NotBlank
    var Department: String? = null

    var Club: String? = null

    @NotBlank
    var Dispatchlocation: String? = null

    var Freetext: String? = null

}

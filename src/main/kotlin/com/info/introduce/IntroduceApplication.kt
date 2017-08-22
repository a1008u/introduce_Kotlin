package com.info.introduce

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class IntroduceApplication{

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(IntroduceApplication::class.java, *args)
        }
    }

}

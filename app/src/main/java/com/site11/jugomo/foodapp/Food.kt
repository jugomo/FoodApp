package com.site11.jugomo.foodapp

/**
 * Created by julio on 24/08/17.
 */
class Food {
    var name: String? = null
    var desc: String? = null
    var img: Int? = null

    constructor(name: String, desc: String, img: Int) {
        this.name = name
        this.desc = desc
        this.img = img
    }
}


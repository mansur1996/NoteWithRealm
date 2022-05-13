package com.example.modul6lesson3database.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Note : RealmObject {
    @PrimaryKey()
    var id : Long? = null
    var time : String? = null
    var note : String? = null

    constructor(id: Long?, time: String?, note: String?) : super() {
        this.id = id
        this.time = time
        this.note = note
    }

    constructor(){}
}
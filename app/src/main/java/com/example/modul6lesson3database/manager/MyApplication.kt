package com.example.modul6lesson3database.manager

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initRealm()
    }

    private fun initRealm(){
        Realm.init(this)

        val config = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true) //do background thread
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)
    }
}
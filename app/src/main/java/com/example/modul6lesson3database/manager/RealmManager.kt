package com.example.modul6lesson3database.manager

import com.example.modul6lesson3database.model.Note
import io.realm.Realm
import io.realm.RealmResults

class RealmManager {
    private val TAG: String = RealmManager::class.java.simpleName

    private var realm : Realm = Realm.getDefaultInstance()

    // I create a companion object to use outside
    companion object{
        private var realmManager : RealmManager? = null
        val instance : RealmManager?
            get() {
                if(realmManager == null){
                    realmManager = RealmManager()
                }
                return realmManager
            }
    }

    fun saveNote(note : Note){
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(note)
        realm.commitTransaction()
    }

    fun loadNotes() : ArrayList<Note>{
        val notes : ArrayList<Note> = ArrayList()

        val results : RealmResults<Note> = realm.where(Note::class.java).findAll()

        notes.addAll(results)
        return notes
    }
}

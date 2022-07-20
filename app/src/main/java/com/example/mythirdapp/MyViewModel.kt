package com.example.mythirdapp

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var data: MutableList<Person> = mutableListOf(
        Person("Taro", "taro@yamada", 36),
        Person("Hanako", "hanako@flower", 25),
        Person("Sachiko", "sachiko@happy", 14)
    )

    fun allByText(): String {
        var res = ""
        for (item in data) {
            res += item.to_s()
            res += "\n"
        }
        return res
    }

    fun getById(id: Int): Person = data[id]

    fun add(name: String, mail: String, age: Int) {
        data.add(Person(name, mail, age))
    }
}

class Person(name:String, mail:String, age:Int) {
    var name:String = name
    var mail:String = mail
    var age:Int = age

    fun age_s():String = age.toString()

    fun to_s(): Any?= "$name ($mail, $age)"
}



//    MutableLiveData<MutableList<Person>>()
//    }
//
//    val name:MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }
//
//    val mail:MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }
//
//    val age:MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }
//
//    val allText:MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }
//    val nameObserver = Observer<String> {newName ->
//        frm_name.setText(newName, TextView.BufferType.NORMAL)
//            }
//    myViewModel.name.observe(this, nameObserver)
//
////    val allText:MutableLiveData<String> by lazy {
////        MutableLiveData<String>()
////    }
//
//    fun allByText(): String {
//        var res = ""
//        for (item in data) {
//            res += item.to_s()
//            res += "\n"
//        }
//        return res
//    }
//
//    fun getById(id:Int): Person = data[id]
//
//    fun add(name:String, mail:String, age:Int) {
//        var name:String = name
//        var mail:String = mail
//        var age:Int = age
//    }
//
//    init {
//        data.value = mutableListOf(
//            Person("Taro", "taro@yamada", 36),
//            Person("Hanako", "hanako@flower", 25),
//            Person("Sachiko", "sachiko@happy", 14)
//        )
//      allText.value = allByText()
//        name.value = "name"
//        mail.value = "mail@address"
//        age.value = "0"
//    }
//}
//
//class Person(name:String, mail:String, age:Int) {
//    var name:String = name
//    var mail:String = mail
//    var age:Int = age
//
//    fun age_s():String = age.toString()
//
//    fun to_s(): Any?= "$name ($mail, $age)"
//}
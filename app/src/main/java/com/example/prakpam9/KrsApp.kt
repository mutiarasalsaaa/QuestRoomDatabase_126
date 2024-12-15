package com.example.prakpam9

import android.app.Application
import com.example.prakpam9.dependenciesinjection.ContainerApp

class KrsApp : Application() {
    //Fungsinya utk menyimpan instance ContainerApp
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        //membuat instance ContainerApp
        containerApp = ContainerApp(this)
        //instance adalah object yg dibuat dari class
    }
}
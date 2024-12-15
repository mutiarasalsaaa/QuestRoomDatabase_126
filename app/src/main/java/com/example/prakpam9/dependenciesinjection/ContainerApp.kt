package com.example.prakpam9.dependenciesinjection

import android.content.Context
import com.example.prakpam9.Data.Database.KrsDatabase
import com.example.prakpam9.Repository.LocalRepositoryMhs
import com.example.prakpam9.Repository.RepositoryMhs


interface InterfaceContainerApp {
    val repositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDataBase(context).mahasiswaDao())
    }
}

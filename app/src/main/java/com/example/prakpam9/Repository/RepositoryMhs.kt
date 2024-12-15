package com.example.prakpam9.Repository


import com.example.prakpam9.Data.Entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface RepositoryMhs {
    //Suspend Untuk operasi berat create,update,delete
    suspend fun insertMhs(mahasiswa: Mahasiswa)

    fun getAllMhs() : Flow<List<Mahasiswa>>

    fun getMhs(nim : String) : Flow<Mahasiswa>

    suspend fun deleteMhs(Mahasiswa: Mahasiswa)

    suspend fun updateMhs(Mahasiswa: Mahasiswa)

}
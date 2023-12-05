package com.example.processoseletivo
import androidx.room.*

@Dao
interface DatabaseDao {
    @Insert
    suspend fun insertCandidato(dbcandidato: BDcandidato)

    @Query("SELECT * FROM BDcandidato")
    suspend fun getAllCandidato(): List<BDcandidato>

    @Insert
    suspend fun insertEmpresa(db_empresa: BDempresa)

    @Query("SELECT * FROM BDempresa")
    suspend fun getAllEmpresa(): List<BDempresa>
}
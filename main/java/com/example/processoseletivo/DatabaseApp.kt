package com.example.processoseletivo

import androidx.room.*

@Entity
data class BDcandidato(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nome: String,
    val descricao: String,
    val habilidade: String,
    val desejo_salarial: String,
    val cargo: String
)

@Entity
data class BDempresa(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nome: String,
    val descricao: String,
    val detalhes_da_vaga: String,
    val salario: String,
    val cargo: String
)

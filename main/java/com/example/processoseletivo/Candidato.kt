package com.example.processoseletivo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.processoseletivo.databinding.FragmentCadastroBinding
import com.example.processoseletivo.databinding.FragmentCandidatoBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Candidato : Fragment() {
    private lateinit var nome_candidato: TextView
    private lateinit var descricao_candidato: TextView
    private lateinit var habilidade_candidato: TextView
    private lateinit var desejo_salarial_candidato: TextView
    private lateinit var cargo_candidato: TextView

    private lateinit var binding: FragmentCandidatoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentCandidatoBinding.inflate(inflater, container, false)

        nome_candidato = binding.nomeCandidato
        nome_candidato.text = "AAAAAAAAAAAA"
        // Inflate the layout for this fragment
        GlobalScope.launch {
            val allDatasCandidato = MainActivity.database.databaseDao().getAllCandidato()
            for (d in allDatasCandidato){
                nome_candidato = binding.nomeCandidato
                descricao_candidato = binding.descricaoCandidato
                habilidade_candidato = binding.habilidadeCandidato
                desejo_salarial_candidato = binding.desejoSalarialCandidato
                cargo_candidato = binding.cargoCandidato

                nome_candidato.text = "${d.nome}"
                descricao_candidato.text = "${d.descricao}"
                habilidade_candidato.text = "${d.habilidade}"
                desejo_salarial_candidato.text = "${d.desejo_salarial}"
                cargo_candidato.text = "${d.cargo}"
            }
        }

        return binding.root
    }

}
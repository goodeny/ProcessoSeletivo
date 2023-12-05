package com.example.processoseletivo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.processoseletivo.databinding.FragmentCadastroBinding
import com.example.processoseletivo.databinding.FragmentCandidatoBinding
import com.example.processoseletivo.databinding.FragmentEmpresaBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Empresa : Fragment() {
    private lateinit var nome_empresa: TextView
    private lateinit var descricao_empresa: TextView
    private lateinit var detalhes_da_vaga_empresa: TextView
    private lateinit var salario_empresa: TextView
    private lateinit var cargo_empresa: TextView

    private lateinit var binding: FragmentEmpresaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentEmpresaBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        GlobalScope.launch {
            val allDatasEmpresa = MainActivity.database.databaseDao().getAllEmpresa()
            for (d in allDatasEmpresa){
                nome_empresa = binding.nomeEmpresa
                descricao_empresa = binding.descricaoEmpresa
                detalhes_da_vaga_empresa = binding.detalhesDaVagaEmpresa
                salario_empresa = binding.salarioEmpresa
                cargo_empresa = binding.cargoEmpresa

                nome_empresa.text = "${d.nome}"
                descricao_empresa.text = "${d.descricao}"
                detalhes_da_vaga_empresa.text = "${d.detalhes_da_vaga}"
                salario_empresa.text = "${d.salario}"
                cargo_empresa.text = "${d.cargo}"
            }
        }
        return binding.root
    }
}
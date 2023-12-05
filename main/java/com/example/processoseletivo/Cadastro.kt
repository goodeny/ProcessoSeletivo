package com.example.processoseletivo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.processoseletivo.databinding.FragmentCadastroBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Cadastro : Fragment() {
    private lateinit var set_nome_candidato: EditText
    private lateinit var set_descricao_candidato: EditText
    private lateinit var set_habilidade_candidato: EditText
    private lateinit var set_desejo_salarial_candidato: EditText
    private lateinit var set_cargo_candidato: EditText
    private lateinit var btn_cadastrar_candidato: Button

    private lateinit var set_nome_empresa: EditText
    private lateinit var set_descricao_empresa: EditText
    private lateinit var set_detalhes_vaga_empresa: EditText
    private lateinit var set_salario_empresa: EditText
    private lateinit var set_cargo_empresa: EditText

    private lateinit var btn_cadastrar_empresa: Button

    private lateinit var binding: FragmentCadastroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCadastroBinding.inflate(inflater, container, false)
        binding.candidatoView.setOnClickListener {
            it.findNavController().navigate(R.id.action_cadastro_to_empresa)
        }
        binding.empresaView.setOnClickListener {
            it.findNavController().navigate(R.id.action_cadastro_to_candidato)
        }
        set_nome_candidato = binding.setNomeCandidato
        set_descricao_candidato = binding.setDescricaoCandidato
        set_habilidade_candidato = binding.setHabilidadeCandidato
        set_desejo_salarial_candidato = binding.setDesejoSalarialCandidato
        set_cargo_candidato = binding.setCargoCandidato
        btn_cadastrar_candidato = binding.btnCadastrarCandidato

        set_nome_empresa = binding.setNomeEmpresa
        set_descricao_empresa = binding.setDescricaoEmpresa
        set_detalhes_vaga_empresa = binding.setDetalhesVagaEmpresa
        set_salario_empresa = binding.setSalarioEmpresa
        set_cargo_empresa = binding.setCargoEmpresa
        btn_cadastrar_empresa = binding.btnCadastrarEmpresa

        //cadastrar Candidato
        btn_cadastrar_candidato.setOnClickListener {
            val nomeCandidato = set_nome_candidato.text.toString()
            val descricaoCandidato = set_descricao_candidato.text.toString()
            val habilidadeCandidato = set_habilidade_candidato.text.toString()
            val desejo_salarioCandidato = set_desejo_salarial_candidato.text.toString()
            val cargoCandidato = set_cargo_candidato.text.toString()

            println("Nome do candidato: $nomeCandidato")
            if (nomeCandidato.isNotEmpty()){
                GlobalScope.launch {
                    val data_candidato = BDcandidato(nome = nomeCandidato, descricao = descricaoCandidato, habilidade = habilidadeCandidato, desejo_salarial = desejo_salarioCandidato, cargo = cargoCandidato )
                    MainActivity.database.databaseDao().insertCandidato(data_candidato)

                    val allDatasCandidato = MainActivity.database.databaseDao().getAllCandidato()
                    for (d in allDatasCandidato){
                        println("Nome: ${d.nome}\nDescrição: ${d.descricao}\nHabilidade: ${d.habilidade}\nDesejo Salarial: ${d.desejo_salarial}\nCargo:${d.cargo}")
                    }
                }
            }
            println("Clicou no botao")
        }

        //Cadastrar Empresa
        btn_cadastrar_empresa.setOnClickListener {
            val nomeEmpresa = set_nome_empresa.text.toString()
            val descricaoEmpresa = set_descricao_empresa.text.toString()
            val detalhes_vagaEmpresa = set_detalhes_vaga_empresa.text.toString()
            val salarioEmpresa = set_salario_empresa.text.toString()
            val cargoEmpresa = set_cargo_empresa.text.toString()

            println("Nome da empresa: $nomeEmpresa")
            if (nomeEmpresa.isNotEmpty()){
                GlobalScope.launch {
                    val data_empresa = BDempresa(nome = nomeEmpresa, descricao = descricaoEmpresa, detalhes_da_vaga = detalhes_vagaEmpresa, salario = salarioEmpresa, cargo = cargoEmpresa)
                    MainActivity.database.databaseDao().insertEmpresa(data_empresa)

                    val allDatasEmpresa = MainActivity.database.databaseDao().getAllEmpresa()
                    for (d in allDatasEmpresa){
                        println("Nome da empresa: ${d.nome}\nDescrição: ${d.descricao}\nDetalhes da vaga: ${d.detalhes_da_vaga}\nSalario: ${d.salario}\nCargo:${d.cargo}")
                    }
                }
           }
            println("Clicou no botao")
        }

        return binding.root
    }

}
package br.com.fabricadeprogramador.fdpapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viniciuspodi on 30/08/17.
 */

public class GerenciadorAgenda {

    private static List<Pessoa> pessoasList = new ArrayList<>();
    private static long index = 1;

    public static void salvar(Pessoa pessoa){
        if(pessoa.getId() == null){
            adicionar(pessoa);
        } else {
            editar(pessoa);
        }
    }

    public static void adicionar(Pessoa pessoa){
        pessoa.setId(index);
        pessoasList.add(pessoa);
        index++;
    }

    public static void editar(Pessoa pessoa){

        for (Pessoa p: pessoasList) {
            if(p.equals(pessoa)){
                int index = pessoasList.indexOf(p);
                pessoasList.set(index, pessoa);
            }
        }
    }

    public static void excluir(Pessoa pessoa){
        if(pessoasList.contains(pessoa)){
            pessoasList.remove(pessoa);
        }
    }

    public static List<Pessoa> getPessoasList() {
        return pessoasList;
    }
}

package com.Senai.AQV;

import java.util.List;

public class AQVController {

    private AQVDAO aqvdao;

    public AQVController(){
        this.aqvdao = new AQVDAO();
    }

    public void cadastrarAQV(AQV aqv){
        aqvdao.cadastrar(aqv);
    }

    public void atualizarAQV(AQV aqv){
        aqvdao.atualizar(aqv);
    }

    public BuscarPorId(int id){
        return aqvdao.BuscarPorId(id);
    }

    public List<AQV> exibirAQV() {
        return aqvdao.exibirAQV();
    }

    public boolean deletarAQV(int id) {
        return aqvdao.deletarAQV(id);
    }


}

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

    public List<AQV> exibirAQV(AQV aqv) {
        return aqvdao.exibirAQV(AQV);
    }

    public deletarAQV(int id) {
        return aqvdao.deletarAQV(id);
    }


}

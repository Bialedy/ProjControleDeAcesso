package com.Senai.AQV;


import java.util.List;

public class AQVController {

    public AQVDAO aqvdao;

    public AQVController(){
        this.aqvdao = new AQVDAO();
    }

    public boolean cadastrar(AQV aqv){
        return aqvdao.cadastrar(aqv);
    }

    public boolean atualizar(AQV aqv){
        return aqvdao.atualizar(aqv);
    }

    public List<AQV> exibir() {
        return aqvdao.exibir();
    }

    public boolean deletar (int id) {
        return aqvdao.deletar(id);
    }

    public void adicionar(AQV aqv) {
        aqvdao.cadastrar(aqv);
    }


    public AQVController(int id, AQV AQV){
        aqvdao.BuscarPorId(id);
    }

}

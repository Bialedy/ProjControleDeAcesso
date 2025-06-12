package com.Senai.AQV;


public class AQVController {

    public AQVDAO aqvdao;

    public AQVController(){
        this.aqvdao = new AQVDAO();
    }

    public boolean cadastrar(AQV aqv){
        aqvdao.cadastrar(aqv);
        return false;
    }

    public void atualizar(AQV aqv){
        aqvdao.atualizar(aqv);
    }

    public boolean exibir(AQV aqv) {
        aqvdao.exibir(aqv);
        return false;
    }

    public boolean deletar (AQV aqv) {
        return aqvdao.deletar(aqv);
    }

    public AQVController(int id, AQV AQV){
        aqvdao.BuscarPorId(id, AQV);
    }


}

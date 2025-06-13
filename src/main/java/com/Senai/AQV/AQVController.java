package com.Senai.AQV;


public class AQVController {

    public AQVDAO aqvdao;

    public AQVController(){
        this.aqvdao = new AQVDAO();
    }

    public boolean cadastrar(AQV AQV){
        aqvdao.cadastrar(AQV);
        return false;
    }

    public boolean atualizar(AQV aqv){
        aqvdao.atualizar(aqv);
        return false;
    }

    public boolean exibir(AQV aqv) {
        aqvdao.exibir(aqv);
        return false;
    }

    public boolean deletar (int id,AQV aqv) {
        aqvdao.deletar(id,aqv);
        return false;
    }

    public AQVController(int id, AQV AQV){
        aqvdao.BuscarPorId(id);
    }


}

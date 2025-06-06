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
        aqvdao.equals(aqv);
        return false;
    }

    public boolean deletar(int id) {
        return aqvdao.deletar(id, AQV);
    }

    public AQVController(int id){
        aqvdao.BuscarPorId(id, AQV);
    }


}

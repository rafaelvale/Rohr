package com.rohr.coletorinterno.rohr.LoginBO;

import android.app.Activity;

import com.rohr.coletorinterno.rohr.Model.Conferente;
//import com.rohr.coletorinterno.rohr.Repository.ConferentesRepository;

/**
 * Created by rafael.marques on 26/07/2016.
 */
public class LoginBO {


//    private ConferentesRepository conferentesRepository;

    public LoginBO(Activity activity){

 //       conferentesRepository = new ConferentesRepository(activity);
    }

    public boolean validarCamposLogin(Conferente conferente){
        boolean resultado = true;
       if(conferente.getTitle() == null || conferente.getTitle() == ""){
            conferente.getEdtTitle().setError("Campo Obrigatório!");
            resultado = false;
        }
        else if(!conferente.getTitle().equals("13265")){
           conferente.getEdtTitle().setError("Funcional Inválida!");
           resultado = false;

       }

        return resultado;
    }


    public void deslogar(){

    }

}

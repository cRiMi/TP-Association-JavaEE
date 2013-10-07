/**
 * Created with IntelliJ IDEA.
 * Autor: julienderay
 * Company : SERLI
 * Date: 07/10/13
 * Time: 10:15
 */
package com.association.controller.services;

import com.model.bean.Adherent;
import com.model.persistence.PersistenceServiceProvider;
import com.model.persistence.services.AdherentPersistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceLogin {

    public ServiceLogin() {
    }

    public Adherent login(String login, String password) {

        AdherentPersistence serviceAdh = PersistenceServiceProvider.getService(AdherentPersistence.class);
        Map<String,Object> param = new HashMap<>();

        param.put("adLogin = ", login);

        List<Adherent> adherant = serviceAdh.search(param);

        if(adherant.size() == 1 && adherant.get(0).getAdPassword().equals( password )) {
            return adherant.get(0);
        }
        else{
            return null;
        }
    }
}
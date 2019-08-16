package com.BriteERP.utilities;

import com.BriteERP.pages.CRMPage;
import com.BriteERP.pages.LoginPage;

public class Pages {

    private CRMPage crmPage;
    private LoginPage loginPage;

    public CRMPage crmPage(){
        if(crmPage==null){
            crmPage=new CRMPage();
        }
        return crmPage();
    }

    public LoginPage loginPage(){
        if(loginPage==null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }
}

package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class CRMPage {

    public CRMPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}

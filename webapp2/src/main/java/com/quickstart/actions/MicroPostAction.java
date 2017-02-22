package com.quickstart.actions;

import com.quickstart.model.MicroPost;
import jodd.madvoc.meta.Action;
import jodd.madvoc.meta.In;
import jodd.madvoc.meta.MadvocAction;
import jodd.madvoc.meta.Out;
import jodd.petite.meta.PetiteInject;

@MadvocAction
public class MicroPostAction {

    @Action
    public void get() {
        System.out.println("In test - micropostaction");
    }

}
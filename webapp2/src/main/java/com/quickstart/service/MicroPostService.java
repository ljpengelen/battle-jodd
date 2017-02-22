package com.quickstart.service;

import com.quickstart.model.MicroPost;
import jodd.joy.db.AppDao;
import jodd.petite.meta.PetiteBean;
import jodd.petite.meta.PetiteInject;
import java.util.*;

/**
 * Created by Jonas on 22/02/17.
 */

@PetiteBean
public class MicroPostService {

    @PetiteInject
    AppDao appDao;

    public List<MicroPost> findAllMicroPosts() {
        return appDao.listAll(MicroPost.class);
    }

    public void add(MicroPost microPost) {
        appDao.save(microPost);
    }

}

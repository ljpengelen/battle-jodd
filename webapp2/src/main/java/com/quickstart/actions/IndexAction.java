package com.quickstart.actions;

import com.quickstart.model.MicroPost;
import com.quickstart.service.MicroPostService;
import jodd.joy.madvoc.action.AppAction;
import jodd.madvoc.meta.Out;
import jodd.petite.meta.PetiteInject;

import java.util.List;

/**
 * Index action.
 */
public class IndexAction extends AppAction {

	@PetiteInject
	MicroPostService microPostService;

	@Out
	List<MicroPost> microPosts;
	/**
	 * Mapped to /index.html page. Does nothing.
	 */
	public void view() {
		System.out.println("IndexAction.view");
		microPosts = microPostService.findAllMicroPosts();
	}

}
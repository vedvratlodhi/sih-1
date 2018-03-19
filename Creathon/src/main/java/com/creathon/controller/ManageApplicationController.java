package com.creathon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.creathon.bean.SessionBean;
import com.creathon.bean.ShootApplication;
import com.creathon.service.ManageApplicationService;

@Controller
public class ManageApplicationController {

	@Autowired
	ManageApplicationService manageApplicationService;
	
	@RequestMapping(value = "/manageApplications", method = RequestMethod.GET)
	public ModelAndView manageApplications(ModelMap model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("manage_application");
		SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("sessionBean");
		if(sessionBean!=null){
			mav.addObject("applicationList", manageApplicationService.listOfShootApplication());
		}else{
			return new ModelAndView("redirect:/");
		}
		return mav;
	}
	
	@RequestMapping(value = "/viewApplicationDetails", method = RequestMethod.GET)
	public ModelAndView viewApplicationDetails(@RequestParam("Id") Integer applicationId, ModelMap model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("view_application_details");
		SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("sessionBean");
		System.out.println(sessionBean);
		if(sessionBean!=null){
			System.out.println("Application id-->"+applicationId);
			if(applicationId!=null){
				try{
					ShootApplication shootApplication = manageApplicationService.findByApplicationId(applicationId);
					System.out.println("ShootApplication-->"+shootApplication);
					mav.addObject("shootApplication", shootApplication);
					System.out.println("locationPermissionSize"+shootApplication.getLocationPermissions().size());
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}else{
			return new ModelAndView("redirect:/");
		}
		return mav;
	}
}

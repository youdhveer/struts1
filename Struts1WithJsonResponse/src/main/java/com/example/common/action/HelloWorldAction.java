package com.example.common.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.example.common.form.TestJsonForm;
import com.example.common.model.Country;
import com.example.common.model.State;
import com.google.gson.Gson;

public class HelloWorldAction extends Action{
	
	private List<Country> countryList;
	private List<State> stateList;
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		TestJsonForm helloWorldForm = (TestJsonForm) form;
		helloWorldForm.setMessage("Hello World! Struts");
		
		Country india=new Country(1, "India");
		Country nepal=new Country(2, "Nepal");
		Country bhutan=new Country(3, "Bhutan");
		
		countryList=new ArrayList<Country>();
		
		countryList.add(india);
		countryList.add(nepal);
		countryList.add(bhutan);
		
		Map<String,State> indiaMap=new HashMap<String,State>();
		stateList=new ArrayList<State>();
		stateList.add( new State(1,100, "UP"));
		stateList.add(new State(1,102, "Bihar"));
		stateList.add(new State(1,103, "Rajasthan"));
		
		
		Gson gson = new Gson();
		String jsonInString = gson.toJson(countryList);
		request.setAttribute("JsonObj", jsonInString);
		
		return mapping.findForward("success");
	}
	
}
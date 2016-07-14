package com.example.common.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.example.common.model.City;
import com.example.common.model.Country;
import com.example.common.model.State;
import com.google.gson.Gson;

public class JSONAction extends DispatchAction{

	
	private List<Country> countryList;
	private List<State> stateList;
	
	public ActionForward countries(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) 
	throws Exception {
		
		Country india=new Country(1, "India");
		Country nepal=new Country(2, "Nepal");
		Country bhutan=new Country(3, "Bhutan");

		countryList=new ArrayList<Country>();
		countryList.add(india);
		countryList.add(nepal);
		countryList.add(bhutan);
		
		
		Gson gson = new Gson();
		String jsonInString = gson.toJson(countryList);
		request.setAttribute("JsonObj", jsonInString);
		
		return mapping.findForward("success");
	}
	
	public ActionForward states(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) 
	throws Exception {
		
		String countryId=request.getParameter("countryId");
		System.out.println("countryId : "+countryId);
		//Fetch state from database based on this countryId
		//Here we are hard coding state data
		
		stateList=new ArrayList<State>();
		if(countryId !=null && countryId.trim().equals("1")){
			//India id : 1 so load only these states
			stateList.add( new State(1,100, "UP"));
			stateList.add(new State(1,102, "Bihar"));
			stateList.add(new State(1,103, "Rajasthan"));
		}else{
			stateList.add( new State(0,000, "None"));
		}
		Gson gson = new Gson();
		String jsonInString = gson.toJson(stateList);
		request.setAttribute("JsonObj", jsonInString);
		
		return mapping.findForward("success");
	}
	
	
	/**
	 * Using PrintWrite send JSON response
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward city(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) 
	throws Exception {
		
		String countryId=request.getParameter("countryId");
		String stateId=request.getParameter("stateId");
		System.out.println("countryId : "+countryId+", stateId : "+stateId);
		//Fetch state from database based on this countryId
		//Here we are hard coding state data
		
		
		List<City> cityList=new ArrayList<City>();
		City city1=new City(1, 100, 1000, "Ghaziabad");
		City city2=new City(1, 100, 1001, "Noida");
		City city3=new City(1, 100, 1001, "Meerut");
		cityList.add(city1);
		cityList.add(city2);
		cityList.add(city3);
		
		Gson gson = new Gson();
		String jsonInString = gson.toJson(cityList);
		request.setAttribute("JsonObj", jsonInString);
		
		PrintWriter writer = response.getWriter();
		writer.print(jsonInString);
		writer.flush();
		response.setContentType("application/json");
		return null;
		
		//return mapping.findForward("success");
	}
	
	
	
}

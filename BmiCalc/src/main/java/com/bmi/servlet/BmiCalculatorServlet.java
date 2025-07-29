package com.bmi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONObject;

import com.bmi.dao.BmiDao;
import com.bmi.model.BmiData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bmi")
public class BmiCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BmiCalculatorServlet() {
        super();
        
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("getAll")!=null) {
			BmiDao bmiDao=new BmiDao();
			List<BmiData> bmiDataList=bmiDao.getAllBmiData();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("bmiDatalist",bmiDataList);
			response.setContentType("application/json");
			
			PrintWriter out=response.getWriter();
			out.print(jsonObject.toString());
			out.flush();
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Methods","GET");
		response.setHeader("Access-Control-Allow-Headers","Content-Type");
		String name=request.getParameter("name");
		double weight=Double.parseDouble(request.getParameter("weight"));
		double height=Double.parseDouble(request.getParameter("height"));
		double bmi=calculateBmi(weight,height);
		BmiData bmiData=new BmiData();
		bmiData.setName(name);
		bmiData.setWeight(weight);
		bmiData.setHeight(height);
		bmiData.setBmi(bmi);
		
		BmiDao bmiDao=new BmiDao();
		bmiDao.saveBmiData(bmiData);
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("bmi",bmi);
		
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		out.print(jsonObject.toString());
		out.flush();
		
	}
	
	public double calculateBmi(double weight,double height) {
		return weight/(height*height);
	}

}

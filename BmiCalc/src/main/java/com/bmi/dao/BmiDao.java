package com.bmi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bmi.model.BmiData;

public class BmiDao {
	private Connection connection;
	public BmiDao() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bmi_database?serverTimezone=UTC","root","20040327");
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	public void saveBmiData(BmiData bmiData) {
		try {
			PreparedStatement statement=connection.prepareStatement("INSERT INTO bmi_data(name,weight,height,bmi) values(?,?,?,?)");
			statement.setString(1,bmiData.getName());
			statement.setDouble(2,bmiData.getWeight());
			statement.setDouble(3,bmiData.getHeight());
			statement.setDouble(4,bmiData.getBmi());
			
			statement.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<BmiData> getAllBmiData(){
		List<BmiData> bmiDataList=new ArrayList<>();
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("SELECT * FROM bmi_data");
			while(resultSet.next()) {
				BmiData bmiData=new BmiData();
				bmiData.setId(resultSet.getInt("id"));
				bmiData.setName(resultSet.getString("name"));
				bmiData.setWeight(resultSet.getDouble("weight"));
				bmiData.setHeight(resultSet.getDouble("height"));
				bmiData.setBmi(resultSet.getDouble("bmi"));
				bmiDataList.add(bmiData);
			}
		}
		catch(Exception e) {
			
		}
		return bmiDataList;
	}

}

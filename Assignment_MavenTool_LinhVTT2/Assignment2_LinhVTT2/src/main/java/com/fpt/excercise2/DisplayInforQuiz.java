package com.fpt.excercise2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class DisplayInforQuiz {

	public static void main(String[] args) {
		  JSONParser parser = new JSONParser();

		  System.out.println("===========List Quizs========");
	        try {

	            Object obj = parser.parse(new FileReader("C:\\Users\\training\\eclipse-workspace\\Assignment2_LinhVTT2\\quiz.json"));

	            JSONObject jsonObject = (JSONObject) obj;
	            
	            //read quiz
	            JSONObject quiz = (JSONObject) jsonObject.get("quiz");
	            
	            //read sport in quiz
	            JSONObject sport = (JSONObject) quiz.get("sport");      
	            //read q1 in sport
	            JSONObject q1 = (JSONObject) sport.get("q1");
	            String question = (String) q1.get("question");
	            System.out.println("Question : " + question);
	            System.out.print("Options: ");
	            JSONArray option = (JSONArray) q1.get("options");
	            for (Object object : option) {
					System.out.print("\t" + object);
				}
	            System.out.println();
	            String answer = (String) q1.get("answer");
	            System.out.println("Answer value: " + answer);
	            
	            //read maths in quiz
	            JSONObject maths = (JSONObject) quiz.get("maths");
	            
	            //read q1 in maths
	            JSONObject q2 = (JSONObject) maths.get("q1");
	            String question2 = (String) q2.get("question");
	            System.out.println("Question : " + question2);
	            System.out.print("Options: ");
	            JSONArray option2 = (JSONArray) q2.get("options");
	            for (Object object : option2) {
					System.out.print("\t" + object);
				}
	            System.out.println();
	            String answer2 = (String) q2.get("answer");
	            System.out.println("Answer value: " + answer2);
	            
	            
	            //read q2 in maths
	            JSONObject q3 = (JSONObject) maths.get("q2");
	            String question3 = (String) q3.get("question");
	            System.out.println("Question : " + question3);
	            System.out.print("Options: ");
	            JSONArray option3 = (JSONArray) q3.get("options");
	            for (Object object : option3) {
					System.out.print("\t" + object);
				}
	            System.out.println();
	            String answer3 = (String) q3.get("answer");
	            System.out.println("Answer value: " + answer3);
	            

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}

	    }




		

		
	       
}

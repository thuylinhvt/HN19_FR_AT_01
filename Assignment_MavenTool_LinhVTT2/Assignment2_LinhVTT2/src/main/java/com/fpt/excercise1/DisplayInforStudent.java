package com.fpt.excercise1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DisplayInforStudent {

	public static void main(String argv[]) {
		try {
			File fXmlFile = new File("C:\\Users\\training\\eclipse-workspace\\Assignment2_LinhVTT2\\student.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			NodeList nList = doc.getElementsByTagName("student");

			System.out.println("============List Students=============");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Student row : " + eElement.getAttribute("rollno"));
					System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println(
							"Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println(
							"Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Mark : " + eElement.getElementsByTagName("marks").item(0).getTextContent());
					System.out.println("-----------------");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

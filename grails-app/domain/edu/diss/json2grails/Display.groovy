package edu.diss.json2grails

class Display {

	String screenResolution
	String screenSize
	String touchScreen
	
	static belongsTo = [PhoneDetail]
	
    static constraints = {
    }
}

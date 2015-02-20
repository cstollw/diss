package edu.diss.json2missioncontrol

class Display {

	String screenResolution
	String screenSize
	String touchScreen
	
	static belongsTo = [PhoneDetail]
	
    static constraints = {
    }
}

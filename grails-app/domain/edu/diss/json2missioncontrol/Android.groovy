package edu.diss.json2missioncontrol

class Android {

	String os
	String ui
	
	static belongsTo = [PhoneDetail]
	
    static constraints = {
		ui  nullable : true
    }
}

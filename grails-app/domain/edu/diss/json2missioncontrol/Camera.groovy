package edu.diss.json2missioncontrol

class Camera {

	String primaryCamera
	
	static hasMany = [
		features : String
		]
	
	static belongsTo = [PhoneDetail]
	
    static constraints = {
    }
	
}

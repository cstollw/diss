package edu.diss.json2grails

class Camera {

	String primaryCamera
	
	static hasMany = [
		features : String
		]
	
	static belongsTo = [PhoneDetail]
	
    static constraints = {
    }
	
}

package edu.diss.json2grails

class Battery {

	String standByTime
	String talkTime
	String type
	
	static belongsTo = [PhoneDetail]
	
    static constraints = {
		standByTime  nullable : true
		talkTime  nullable : true
    }
}

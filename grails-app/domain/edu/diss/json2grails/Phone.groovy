package edu.diss.json2grails

class Phone {

	int age
	String phoneId
	String imageUrl
	String name
	String snippet
	
   static mapping = {
   }
	
    static constraints = {
        age size :1..4, unique: false, min:0, max: 9999
    }
		
}

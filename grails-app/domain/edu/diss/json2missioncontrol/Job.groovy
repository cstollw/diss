package edu.diss.json2missioncontrol


class Job {

    Date age
	String jobId
	String imageUrl
	String name
	String snippet


   static mapping = {
   }
	
    static constraints = {
        /*age size :1..4, unique: false, min:0, max: 9999*/
        age nullable: true
    }
		
}

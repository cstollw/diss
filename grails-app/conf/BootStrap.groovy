import grails.converters.JSON

import edu.diss.json2missioncontrol.*

import java.text.SimpleDateFormat

class BootStrap {
	
	def grailsApplication

    def init = { servletContext ->

        Job my = new Job()
        my.jobId= 123
        my.name= 'Adaptive Threshold'
/*        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String mydate = "01-08-2011";
        myphone.age= new Date()*/
        ;/*
        myphone.age= "14092011"*/
        my.imageUrl= "http://vgl-ait.org/cvwiki/lib/exe/fetch.php?media=opencv:tutorial:sis.jpg"
        my.snippet= "The Next, Next Generation \n\n Experience the future with this Binarization, the world's first one powered rainwater."
        my.save(flush:true, failOnError:true)


        /*  Von Hier war Bootstrap Original */
		
		JSON.registerObjectMarshaller( Job ) { Job phone ->
			return [
					id : phone.jobId,
					imageUrl : phone.imageUrl,
					name : phone.name,
					snippet : phone.snippet
			]
		}
		
		/*JSON.registerObjectMarshaller( PhoneDetail ) { PhoneDetail phoneDetail ->
			return [
				additionalFeatures: phoneDetail.additionalFeatures,
				android: phoneDetail.android,
				availability: phoneDetail.availability,
				battery: phoneDetail.battery,
				camera: phoneDetail.camera,
				connectivity: phoneDetail.connectivity,
				description: phoneDetail.description,
				display: phoneDetail.display,
				hardware: phoneDetail.hardware,
				id: phoneDetail.phoneId,
				images: phoneDetail.images,
				name: phoneDetail.name,
				sizeAndWeight: phoneDetail.sizeAndWeight,
				storage: phoneDetail.storage
				]
			}
		
		JSON.registerObjectMarshaller( Camera ) { Camera camera ->
			return [
					primary : camera.primaryCamera,
					features : camera.features,
			]
		}*/
		
		File phonesFolder = grailsApplication.mainContext.getResource("/jobsJson").file
		
		phonesFolder.listFiles().each { File file ->
			
			if(file.name.equals("jobs.json")){

				def jsonPhones = grails.converters.JSON.parse(file.text)
				jsonPhones.each {
					Job phone = new Job(it)
					phone.jobId = it.id
					phone.save(flush:true, failOnError:true)
				}
				
			} /*else {

				def jsonPhoneDetail = grails.converters.JSON.parse(file.text)

				PhoneDetail phoneDetail = new PhoneDetail(jsonPhoneDetail)
				phoneDetail.phoneId = jsonPhoneDetail.id

				phoneDetail.setAndroid(new Android(jsonPhoneDetail.android))
				phoneDetail.setBattery(new Battery(jsonPhoneDetail.battery))
				
				Camera camera = new Camera(jsonPhoneDetail.camera)
				camera.primaryCamera = jsonPhoneDetail.camera.primary
				phoneDetail.setCamera(camera)
				
				phoneDetail.setConnectivity(new Connectivity(jsonPhoneDetail.connectivity))
				phoneDetail.setDisplay(new Display(jsonPhoneDetail.display))
				phoneDetail.setHardware(new Hardware(jsonPhoneDetail.hardware))
				phoneDetail.setSizeAndWeight(new SizeAndWeight(jsonPhoneDetail.sizeAndWeight))
				phoneDetail.setStorage(new Storage(jsonPhoneDetail.storage))

				phoneDetail.save(flush:true, failOnError:true)

			}*/
		}

    }
	
    def destroy = {
		
    }

}

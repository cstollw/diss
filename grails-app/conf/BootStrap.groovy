import grails.converters.JSON

import edu.diss.json2grails.*

class BootStrap {
	
	def grailsApplication

    def init = { servletContext ->

        Phone myphone = new Phone()
        myphone.phoneId= 123
        myphone.name= 'ChrixPhone'
        myphone.age= 11
        myphone.imageUrl= "http://www.tomato.ph/images/shoponline/lifestyle/myphone/O3PH0014BB_0.jpg"
        myphone.snippet= "The Next, Next Generation \n\n Experience the future with MOTOROLA XOOM, the world's first tablet powered by Android 3.0 (Honeycomb)."
        myphone.save(flush:true, failOnError:true)


        /*  Von Hier war Bootstrap Original */
		
		JSON.registerObjectMarshaller( Phone ) { Phone phone ->
			return [
					age : phone.age,
					id : phone.phoneId,
					imageUrl : phone.imageUrl,
					name : phone.name,
					snippet : phone.snippet
			]
		}
		
		JSON.registerObjectMarshaller( PhoneDetail ) { PhoneDetail phoneDetail ->
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
		}
		
		File phonesFolder = grailsApplication.mainContext.getResource("/phonesJson").file
		
		phonesFolder.listFiles().each { File file ->
			
			if(file.name.equals("phones.json")){
				
				def jsonPhones = grails.converters.JSON.parse(file.text)
				jsonPhones.each {
					Phone phone = new Phone(it)
					phone.phoneId = it.id
					phone.save(flush:true, failOnError:true)
				}
				
			} else {

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

			}
		}

    }
	
    def destroy = {
		
    }

}

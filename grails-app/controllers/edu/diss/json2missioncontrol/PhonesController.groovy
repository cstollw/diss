package edu.diss.json2missioncontrol

import grails.converters.JSON
import grailsangularinterface.JobService

class PhonesController {

    def JobService jobService

    def beforeInterceptor = {
        log.info "Entering Action ${actionUri}"
    }

	def index() {
		def json = Job.list() as JSON
		render json
	}
		
    def showPhone() {
		def phone  = Job.findByJobId(params.phoneId)
        runjob()
        if (!phone) redirect(url: request.header('referer'))
        def json = phone as JSON
		render json
    }

    def runjob() {
        String applicationPath = grailsAttributes.getApplicationContext().getResource("/sh/shellscript.sh").getFile().toString()

        jobService.runshellscript(applicationPath)
//        redirect(url: request.header('referer'))
    }

	
}
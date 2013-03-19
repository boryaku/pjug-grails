import pjug.Meetup
import pjug.Pjugger

class BootStrap {

    /**
     * I prefer to put this in separate Services, this can get real big, real fast and it becomes fugly...
     */
    def init = { servletContext ->
        //we'll add a member
        Pjugger chris = new Pjugger(name: "Chris Buckley", email: "chris.buckley@puresrc.com", about: "Having fun..",
                                     recruiter: true).save(failOnError: true)

        Meetup grails2 = new Meetup(date: new Date(), location: "Oracle Portland Downtown", speaker: chris, topic: "Grails 2",
                                       topicDetails: "Really awesome talk about Grails :P").save(failOnError: true)

        //let's make some attendance assumptions :)
        (1..10).each{ i ->
            Pjugger pjugger = new Pjugger(name: "Recruiter "+i, email: "java_job@finder"+i+".com", about: "Employing US",
                            recruiter: true).save(failOnError: true)
            grails2.attendees.add(pjugger)
            grails2.save(failOnError: true)
        }

        (1..5).each{ i ->
            //you can define it as def but, I prefer the example above especially when we're dealing with multiple models
            def developer = new Pjugger(name: "Developer "+i, email: "java_job@needer"+i+".com", about: "Rock star Developer",
                            recruiter: false).save(failOnError: false)
            grails2.attendees.add(developer)
            grails2.save(failOnError: true)
        }

        //we have an implied logger always, thanks Grails
        log.info("Bootstrapped with "+grails2.attendees.size+" attendees for the "+grails2.topic+" meetup")
    }
    def destroy = {
    }
}

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        /**
         * Binding HTTP methods to Grails actions
         */
        "/rest/$controller/element/$id"(parseRequest:true){
           action = [GET:"show", DELETE: "delete", PUT: "update"]
        }

        "/rest/$controller/list"(parseRequest:true){
           action = [GET:"list", POST: "save"]
        }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}

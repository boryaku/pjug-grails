package pjug

import grails.converters.JSON
import grails.converters.XML
import org.springframework.dao.DataIntegrityViolationException

class PjuggerController {

    /**
     * Pjugger is REST aware, so we don't need the default configuration
     * static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
     */


    static allowedMethods = [save: "POST", update: "POST", delete: ["POST", "DELETE"]]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [pjuggerInstanceList: Pjugger.list(params), pjuggerInstanceTotal: Pjugger.count()]
    }

    def create() {
        [pjuggerInstance: new Pjugger(params)]
    }

    def save() {
        def pjuggerInstance = new Pjugger(params)
        if (!pjuggerInstance.save(flush: true)) {
            render(view: "create", model: [pjuggerInstance: pjuggerInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'pjugger.label', default: 'Pjugger'), pjuggerInstance.id])
        redirect(action: "show", id: pjuggerInstance.id)
    }

    def show() {
        def pjuggerInstance = Pjugger.get(params.id)
        if (!pjuggerInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pjugger.label', default: 'Pjugger'), params.id])
            redirect(action: "list")
            return
        }

        [pjuggerInstance: pjuggerInstance]
    }

    def edit() {
        def pjuggerInstance = Pjugger.get(params.id)
        if (!pjuggerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pjugger.label', default: 'Pjugger'), params.id])
            redirect(action: "list")
            return
        }

        [pjuggerInstance: pjuggerInstance]
    }

    def update() {
        def pjuggerInstance = Pjugger.get(params.id)
        if (!pjuggerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pjugger.label', default: 'Pjugger'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (pjuggerInstance.version > version) {
                pjuggerInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'pjugger.label', default: 'Pjugger')] as Object[],
                          "Another user has updated this Pjugger while you were editing")
                render(view: "edit", model: [pjuggerInstance: pjuggerInstance])
                return
            }
        }

        pjuggerInstance.properties = params

        if (!pjuggerInstance.save(flush: true)) {
            render(view: "edit", model: [pjuggerInstance: pjuggerInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'pjugger.label', default: 'Pjugger'), pjuggerInstance.id])
        redirect(action: "show", id: pjuggerInstance.id)
    }

    def delete() {
        def pjuggerInstance = Pjugger.get(params.id)
        if (!pjuggerInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pjugger.label', default: 'Pjugger'), params.id])
            redirect(action: "list")
            return
        }

        try {
            pjuggerInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'pjugger.label', default: 'Pjugger'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pjugger.label', default: 'Pjugger'), params.id])
            redirect(action: "show", id: params.id)
        }
    }

    /**
     * There's really no reason you wouldn't put this right in list but... maybe you want separate them ?!?
     */
    def users(){
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        withFormat {
                html { [pjuggerInstanceList: Pjugger.list(params), pjuggerInstanceInstanceTotal: Pjugger.count()] }
                xml { render Pjugger.list(params) as XML }
                json { render Pjugger.list(params) as JSON }
            }
    }
}

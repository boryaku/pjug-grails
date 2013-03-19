package pjug



import org.junit.*
import grails.test.mixin.*

@TestFor(PjuggerController)
@Mock(Pjugger)
class PjuggerControllerTests {


    def populateValidParams(params) {
      assert params != null

      params["name"] = 'Chris Buckley'
      params["email"] = "chris.buckley@puresrc.com"
      params["about"] = "Grails evangelist"
      params["recruiter"] = true
    }

    void testIndex() {
        controller.index()
        assert "/pjugger/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.pjuggerInstanceList.size() == 0
        assert model.pjuggerInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.pjuggerInstance != null
    }

    void testSave() {
        controller.save()

        assert model.pjuggerInstance != null
        assert view == '/pjugger/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/pjugger/show/1'
        assert controller.flash.message != null
        assert Pjugger.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/pjugger/list'


        populateValidParams(params)
        def pjugger = new Pjugger(params)

        assert pjugger.save() != null

        params.id = pjugger.id

        def model = controller.show()

        assert model.pjuggerInstance == pjugger
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/pjugger/list'


        populateValidParams(params)
        def pjugger = new Pjugger(params)

        assert pjugger.save() != null

        params.id = pjugger.id

        def model = controller.edit()

        assert model.pjuggerInstance == pjugger
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/pjugger/list'

        response.reset()


        populateValidParams(params)
        def pjugger = new Pjugger(params)

        assert pjugger.save() != null

        // test invalid parameters in update
        params.id = pjugger.id
        //Let's throw some invalid params to make these next tests fail
        params.email = ""
        params.name = ""

        controller.update()

        assert view == "/pjugger/edit"
        assert model.pjuggerInstance != null

        pjugger.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/pjugger/show/$pjugger.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        pjugger.clearErrors()

        populateValidParams(params)
        params.id = pjugger.id
        params.version = -1
        controller.update()

        assert view == "/pjugger/edit"
        assert model.pjuggerInstance != null
        assert model.pjuggerInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/pjugger/list'

        response.reset()

        populateValidParams(params)
        def pjugger = new Pjugger(params)

        assert pjugger.save() != null
        assert Pjugger.count() == 1

        params.id = pjugger.id

        controller.delete()

        assert Pjugger.count() == 0
        assert Pjugger.get(pjugger.id) == null
        assert response.redirectedUrl == '/pjugger/list'
    }
}

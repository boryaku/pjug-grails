package pjug

/**
 *
 * This entity represents a user in the PJUG community.  It provides the user's current email address and whether
 * or not they are a recruiter or not.
 *
 * Thanks for the Pizza TexSystems you rock!  www.teksystems.com
 * AND
 * Thanks Oracle for the meet up place you rock too! www.oracle.com
 *
 * @author Chris Buckley
 * www.puresrc.com
 */
class Pjugger {

    /**
     * Overriding the default Hibernate mapping scheme. Defining our DB columns and table name (schema and catalog
     * optional)
     */
    static mapping = {
        table "APP_PJUG_USER"
        name name: "PJUGGER_NAME", length: 50
        about name: "ABOUT_USER", type: "text"
    }

    /**
     * Override default behavior of constraint generation here
     */
    static constraints = {
        name blank: false
        email email: true, blank: false
    }

    /**
     * The Pjugger's full name
     */
    String name

    /**
     * The Pjugger's email address
     */
    String email

    /**
     * Tells what this Pjugger is all about
     */
    String about

    /**
     * Is the Pjugger a recruiter :P
     */
    Boolean recruiter

    /**
     * Override toString...
     * @return the pjugger's name
     */
    String toString(){
        // you can omit 'return' BUT I think it's best to use it
        return name
    }

    /**
     * Override Equals...
     * @param o that pjugger
     * @return  the same?
     */
    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Pjugger pjugger = (Pjugger) o

        if (email != pjugger.email) return false
        if (id != pjugger.id) return false

        return true
    }

    /**
     * Need this in collection contains equality checking...
     * @return
     */
    int hashCode() {
        int result
        result = (email != null ? email.hashCode() : 0)
        result = 31 * result + (id != null ? id.hashCode() : 0)
        return result
    }
}

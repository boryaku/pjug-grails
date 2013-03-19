package pjug

/**
 * It's kind of like a roundup except it's developers we're branding :)
 *
 * Thanks for the Pizza TexSystems you rock!  www.teksystems.com
 * AND
 * Thanks Oracle for the meet up place you rock too! www.oracle.com
 *
 * @author Chris Buckley
 * www.puresrc.com
 */
class Meetup {

    /**
     * Controlling the database definitions
     */
    static mapping = {
        location name: "MEETUP_LOCATION", type: "text"
        topic name: "topic", length: 25
    }

    /**
     * We're declaring our validation rules for this entity
     */
    static constraints = {
        date blank: false, unique: true
        topic blank: false, unique: false, size: 5..25
        topicDetails blank: false, unique: true, size: 5..500
        location blank: false, size: 15..500
    }

    /**
     * We have a speaker
     */
    static belongsTo = [speaker: Pjugger]

    /**
     * one-to-many, Meetup-to-Pjugger
     */
    static hasMany = [attendees: Pjugger]

    /**
     * The date and time we're meeting up.
     */
    Date date

    /**
     * What we're talking about.
     */
     String topic

    /**
     * Little more detail please :)
     */
    String topicDetails

    /**
     * Where we're going to be...
     */
    String location

}

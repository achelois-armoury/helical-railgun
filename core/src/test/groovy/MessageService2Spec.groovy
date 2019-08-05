import com.achelois.helical.annotations.CaseId
import spock.lang.Specification

class MessageService2Spec extends Specification {

    @CaseId(97)
    def "failed event retry"() {
        expect:
        false
    }

    @CaseId(98)
    def "success event retry"() {
        given: "I have some service"
        assert true
    }
}

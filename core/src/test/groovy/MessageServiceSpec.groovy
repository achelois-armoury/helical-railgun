import com.achelois.helical.annotations.CaseId
import spock.lang.Specification

class MessageServiceSpec extends Specification {

    @CaseId(99)
    def "failed event retry"() {
        expect:
        false
    }

    @CaseId(100)
    def "success event retry"() {
        given: "I have some service"
            assert true
    }

}

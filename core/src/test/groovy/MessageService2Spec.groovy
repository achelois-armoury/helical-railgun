import com.achelois.helical.annotations.CaseId
import com.codepine.api.testrail.model.Case
import spock.lang.Specification

class MessageService2Spec extends Specification {
    @CaseId(5)
    def "failed event retry"() {
        expect:
        false
    }

    def "success event retry"() {
        given: "I have some service"
        assert true
    }
}

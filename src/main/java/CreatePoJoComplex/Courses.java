package CreatePoJoComplex;

import java.util.List;

public class Courses {
    private List<Details> webAutomation;
    private List<Details> api;
    private List<Details> mobile;

    public List<Details> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<Details> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<Details> getApi() {
        return api;
    }

    public void setApi(List<Details> api) {
        this.api = api;
    }

    public List<Details> getMobile() {
        return mobile;
    }

    public void setMobile(List<Details> mobile) {
        this.mobile = mobile;
    }
}

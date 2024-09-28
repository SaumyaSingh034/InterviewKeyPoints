package POJO;

import java.util.List;

public class Courses {

    private List<CoursesDetails> webAutomation;

    public List<CoursesDetails> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<CoursesDetails> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<CoursesDetails> getApi() {
        return api;
    }

    public void setApi(List<CoursesDetails> api) {
        this.api = api;
    }

    public List<CoursesDetails> getMobile() {
        return mobile;
    }

    public void setMobile(List<CoursesDetails> mobile) {
        this.mobile = mobile;
    }

    private List<CoursesDetails> api;
    private List<CoursesDetails> mobile;
}

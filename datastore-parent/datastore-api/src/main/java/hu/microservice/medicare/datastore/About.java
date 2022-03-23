package hu.microservice.medicare.datastore;

public class About {

    private String header;
    private String about;
    private Integer filledByNumber;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getFilledByNumber() {
        return filledByNumber;
    }

    public void setFilledByNumber(Integer filledByNumber) {
        this.filledByNumber = filledByNumber;
    }

}

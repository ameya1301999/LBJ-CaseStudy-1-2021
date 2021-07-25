
// College class
public class College {

    private int collegeId;
    private String collegeName;
    private String courseType;
    private String city;
    private int fees;
    private int pinCode;

    public College() {
        this.collegeId = 0;
        this.collegeName = null;
        this.courseType = null;
        this.city = null;
        this.fees = 0;
        this.pinCode = 0;
    }

    public int getCollegeId() {
        return this.collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return this.collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCourseType() {
        return this.courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getFees() {
        return this.fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public int getPinCode() {
        return this.pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

}

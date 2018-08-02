package in.testpress.retrofit_from_scratch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreatedBy {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("large_image")
    @Expose
    private String largeImage;
    @SerializedName("medium_image")
    @Expose
    private String mediumImage;
    @SerializedName("medium_small_image")
    @Expose
    private String mediumSmallImage;
    @SerializedName("small_image")
    @Expose
    private String smallImage;
    @SerializedName("x_small_image")
    @Expose
    private String xSmallImage;
    @SerializedName("mini_image")
    @Expose
    private String miniImage;
    @SerializedName("membership_id")
    @Expose
    private Object membershipId;
    @SerializedName("birth_date")
    @Expose
    private Object birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getMediumImage() {
        return mediumImage;
    }

    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }

    public String getMediumSmallImage() {
        return mediumSmallImage;
    }

    public void setMediumSmallImage(String mediumSmallImage) {
        this.mediumSmallImage = mediumSmallImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getXSmallImage() {
        return xSmallImage;
    }

    public void setXSmallImage(String xSmallImage) {
        this.xSmallImage = xSmallImage;
    }

    public String getMiniImage() {
        return miniImage;
    }

    public void setMiniImage(String miniImage) {
        this.miniImage = miniImage;
    }

    public Object getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Object membershipId) {
        this.membershipId = membershipId;
    }

    public Object getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Object birthDate) {
        this.birthDate = birthDate;
    }

}

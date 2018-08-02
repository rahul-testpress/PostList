package in.testpress.retrofit_from_scratch;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post implements Parcelable {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("bookmark_id")
    @Expose
    private Object bookmarkId;
    @SerializedName("short_web_url")
    @Expose
    private String shortWebUrl;
    @SerializedName("short_url")
    @Expose
    private String shortUrl;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("created_by")
    @Expose
    private CreatedBy createdBy;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("comments_count")
    @Expose
    private Integer commentsCount;
    @SerializedName("comments_url")
    @Expose
    private String commentsUrl;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("upvotes")
    @Expose
    private Integer upvotes;
    @SerializedName("downvotes")
    @Expose
    private Integer downvotes;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("content_html")
    @Expose
    private String contentHtml;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("institute")
    @Expose
    private Integer institute;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("is_locked")
    @Expose
    private Boolean isLocked;
    @SerializedName("is_approved")
    @Expose
    private Boolean isApproved;
    @SerializedName("forum")
    @Expose
    private Boolean forum;
    @SerializedName("subject")
    @Expose
    private Object subject;
    @SerializedName("ip_address")
    @Expose
    private Object ipAddress;
    @SerializedName("views_count")
    @Expose
    private Integer viewsCount;
    @SerializedName("participants_count")
    @Expose
    private Integer participantsCount;
    @SerializedName("last_commented_by")
    @Expose
    private Object lastCommentedBy;
    @SerializedName("last_commented_time")
    @Expose
    private Object lastCommentedTime;

    protected Post(Parcel in) {
        url = in.readString();
        shortWebUrl = in.readString();
        shortUrl = in.readString();
        webUrl = in.readString();
        created = in.readString();
        if (in.readByte() == 0) {
            commentsCount = null;
        } else {
            commentsCount = in.readInt();
        }
        commentsUrl = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        modified = in.readString();
        if (in.readByte() == 0) {
            upvotes = null;
        } else {
            upvotes = in.readInt();
        }
        if (in.readByte() == 0) {
            downvotes = null;
        } else {
            downvotes = in.readInt();
        }
        title = in.readString();
        summary = in.readString();
        byte tmpIsActive = in.readByte();
        isActive = tmpIsActive == 0 ? null : tmpIsActive == 1;
        if (in.readByte() == 0) {
            institute = null;
        } else {
            institute = in.readInt();
        }
        publishedDate = in.readString();
        slug = in.readString();
        byte tmpIsLocked = in.readByte();
        isLocked = tmpIsLocked == 0 ? null : tmpIsLocked == 1;
        byte tmpIsApproved = in.readByte();
        isApproved = tmpIsApproved == 0 ? null : tmpIsApproved == 1;
        byte tmpForum = in.readByte();
        forum = tmpForum == 0 ? null : tmpForum == 1;
        if (in.readByte() == 0) {
            viewsCount = null;
        } else {
            viewsCount = in.readInt();
        }
        if (in.readByte() == 0) {
            participantsCount = null;
        } else {
            participantsCount = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(shortWebUrl);
        dest.writeString(shortUrl);
        dest.writeString(webUrl);
        dest.writeString(created);
        if (commentsCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(commentsCount);
        }
        dest.writeString(commentsUrl);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(modified);
        if (upvotes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(upvotes);
        }
        if (downvotes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(downvotes);
        }
        dest.writeString(title);
        dest.writeString(summary);
        dest.writeByte((byte) (isActive == null ? 0 : isActive ? 1 : 2));
        if (institute == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(institute);
        }
        dest.writeString(publishedDate);
        dest.writeString(slug);
        dest.writeByte((byte) (isLocked == null ? 0 : isLocked ? 1 : 2));
        dest.writeByte((byte) (isApproved == null ? 0 : isApproved ? 1 : 2));
        dest.writeByte((byte) (forum == null ? 0 : forum ? 1 : 2));
        if (viewsCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(viewsCount);
        }
        if (participantsCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(participantsCount);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(Object bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public String getShortWebUrl() {
        return shortWebUrl;
    }

    public void setShortWebUrl(String shortWebUrl) {
        this.shortWebUrl = shortWebUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }

    public String   getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getInstitute() {
        return institute;
    }

    public void setInstitute(Integer institute) {
        this.institute = institute;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Boolean getForum() {
        return forum;
    }

    public void setForum(Boolean forum) {
        this.forum = forum;
    }

    public Object getSubject() {
        return subject;
    }

    public void setSubject(Object subject) {
        this.subject = subject;
    }

    public Object getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(Object ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public Integer getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(Integer participantsCount) {
        this.participantsCount = participantsCount;
    }

    public Object getLastCommentedBy() {
        return lastCommentedBy;
    }

    public void setLastCommentedBy(Object lastCommentedBy) {
        this.lastCommentedBy = lastCommentedBy;
    }

    public Object getLastCommentedTime() {
        return lastCommentedTime;
    }

    public void setLastCommentedTime(Object lastCommentedTime) {
        this.lastCommentedTime = lastCommentedTime;
    }

}

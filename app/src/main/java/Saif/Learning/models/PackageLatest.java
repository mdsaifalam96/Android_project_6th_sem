
package Saif.Learning.models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PackageLatest {

    @SerializedName("exam_detail")
    private String mExamDetail;
    @SerializedName("exam_id")
    private String mExamId;
    @SerializedName("exam_time")
    private String mExamTime;
    @SerializedName("exam_title")
    private String mExamTitle;
    @SerializedName("exam_token")
    private String mExamToken;
    @SerializedName("exam_total")
    private String mExamTotal;
    @SerializedName("exam_thumbnail")
    private String mExamThumbnail;

    public String getmExamThumbnail() {
        return mExamThumbnail;
    }

    public void setmExamThumbnail(String examThumbnail){
        mExamThumbnail = examThumbnail;
    }

    public String getExamDetail() {
        return mExamDetail;
    }

    public void setExamDetail(String examDetail) {
        mExamDetail = examDetail;
    }

    public String getExamId() {
        return mExamId;
    }

    public void setExamId(String examId) {
        mExamId = examId;
    }

    public String getExamTime() {
        return mExamTime;
    }

    public void setExamTime(String examTime) {
        mExamTime = examTime;
    }

    public String getExamTitle() {
        return mExamTitle;
    }

    public void setExamTitle(String examTitle) {
        mExamTitle = examTitle;
    }

    public String getExamToken() {
        return mExamToken;
    }

    public void setExamToken(String examToken) {
        mExamToken = examToken;
    }

    public String getExamTotal() {
        return mExamTotal;
    }

    public void setExamTotal(String examTotal) {
        mExamTotal = examTotal;
    }

}

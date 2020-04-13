package com.dimple.project.member.itemBank.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (EduItemBank)表实体类
 *
 * @author 刘登辉
 * @since 2020-03-31 15:43:41
 */
@SuppressWarnings("serial")
public class EduItemBank{
    
    private Integer id;
    //章
    private Integer chapter;
    //节
    private Integer section;
    //关数
    private Integer subjectNumber;
    //标题
    private String title;
    //图片
    private String leftPicture;
    //英文语音
    private String leftEnglishVoice;
    //中文语音
    private String leftChineseVoice;
    //图片
    private String rightPicture;
    //英文语音
    private String rightEnglishVoice;
    //中文语音
    private String rightChineseVoice;
    //难度 1-5
    private Integer difficulty;
    
    private String content;
    
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public Integer getSubjectNumber() {
        return subjectNumber;
    }

    public void setSubjectNumber(Integer subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLeftPicture() {
        return leftPicture;
    }

    public void setLeftPicture(String leftPicture) {
        this.leftPicture = leftPicture;
    }

    public String getLeftEnglishVoice() {
        return leftEnglishVoice;
    }

    public void setLeftEnglishVoice(String leftEnglishVoice) {
        this.leftEnglishVoice = leftEnglishVoice;
    }

    public String getLeftChineseVoice() {
        return leftChineseVoice;
    }

    public void setLeftChineseVoice(String leftChineseVoice) {
        this.leftChineseVoice = leftChineseVoice;
    }

    public String getRightPicture() {
        return rightPicture;
    }

    public void setRightPicture(String rightPicture) {
        this.rightPicture = rightPicture;
    }

    public String getRightEnglishVoice() {
        return rightEnglishVoice;
    }

    public void setRightEnglishVoice(String rightEnglishVoice) {
        this.rightEnglishVoice = rightEnglishVoice;
    }

    public String getRightChineseVoice() {
        return rightChineseVoice;
    }

    public void setRightChineseVoice(String rightChineseVoice) {
        this.rightChineseVoice = rightChineseVoice;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
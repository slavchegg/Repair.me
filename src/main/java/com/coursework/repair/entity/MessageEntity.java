package com.coursework.repair.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "message", schema = "public", catalog = "postgres")
public class MessageEntity {
    private long id;
    private Long senderId;
    private Long dialogId;
    private Timestamp date;
    private String content;
//    private Boolean isRead;

    private ManEntity manBySenderId;
    private DialogEntity dialogByDialogId;
//    private Boolean isUserRead;
//    private Boolean isMechRead;
    private Boolean userread;
    private Boolean mechread;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sender_id")
    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    @Basic
    @Column(name = "dialog_id")
    public Long getDialogId() {
        return dialogId;
    }

    public void setDialogId(Long dialogId) {
        this.dialogId = dialogId;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "userread")
    public Boolean getUserread() {
        return userread;
    }

    public void setUserread(Boolean userread) {
        this.userread = userread;
    }

    @Basic
    @Column(name = "mechread")
    public Boolean getMechread() {
        return mechread;
    }

    public void setMechread(Boolean mechread) {
        this.mechread = mechread;
    }


//    @Basic
//    @Column(name = "is_user_read")
//    public Boolean getUserRead() {
//        return isUserRead;
//    }
//
//    public void setUserRead(Boolean userRead) {
//        isUserRead = userRead;
//    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MessageEntity that = (MessageEntity) o;
//        return id == that.id &&
//                Objects.equals(senderId, that.senderId) &&
//                Objects.equals(dialogId, that.dialogId) &&
//                Objects.equals(date, that.date) &&
//                Objects.equals(content, that.content) &&
//                Objects.equals(isRead, that.isRead);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, senderId, dialogId, date, content, isRead);
//    }

//    @Basic
//    @Column(name = "is_mech_read")
//    public Boolean getMechRead() {
//        return isMechRead;
//    }
//
//    public void setMechRead(Boolean mechRead) {
//        isMechRead = mechRead;
//    }

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", insertable = false, updatable = false)
    public ManEntity getManBySenderId() {
        return manBySenderId;
    }

    public void setManBySenderId(ManEntity manBySenderId) {
        this.manBySenderId = manBySenderId;
    }

    @ManyToOne
    @JoinColumn(name = "dialog_id", referencedColumnName = "id", insertable = false, updatable = false)
    public DialogEntity getDialogByDialogId() {
        return dialogByDialogId;
    }

    public void setDialogByDialogId(DialogEntity dialogByDialogId) {
        this.dialogByDialogId = dialogByDialogId;
    }


}

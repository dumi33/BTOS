package com.umc.btos.src.history.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
// History 목록 조회, 발신인 조회
public class History implements Comparable<History> {
    private String type; // diary : 일기 / letter : 편지 / reply : 답장
    private int typeIdx; // 식별자 (diary - diaryIdx / letter - letterIdx / reply - replyIdx)
    private String content; // 내용
    private int emotionIdx = 0; // 일기일 경우 감정 이모티콘이 없다면 0, 아니면 1~8 / 편지 또는 답장일 경우 0
    private int doneListNum = 0; // 일기일 경우 done list 개수 / 편지 또는 답장일 경우 0
    private String sendAt_raw; // 발신일(== 수신일) (yyyy-MM-dd HH:mm:ss)
    private String sendAt; // 발신일 - 화면 출력용 (yyyy.MM.dd)
    private String senderNickName; // 발신자 이름

    /// type = diary
    public History(String type, int typeIdx, String senderNickName, String content, int emotionIdx, int doneListNum, String sendAt_raw, String sendAt) {
        this.type = type;
        this.typeIdx = typeIdx;
        this.senderNickName = senderNickName;
        this.content = content;
        this.emotionIdx = emotionIdx;
        this.doneListNum = doneListNum;
        this.sendAt_raw = sendAt_raw;
        this.sendAt = sendAt;
    }

    public History(String type, int typeIdx, String senderNickName, String content, String sendAt_raw, String sendAt) {
        this.type = type;
        this.typeIdx = typeIdx;
        this.senderNickName = senderNickName;
        this.content = content;
        this.sendAt_raw = sendAt_raw;
        this.sendAt = sendAt;
    }

    @SneakyThrows
    @Override
    public int compareTo(History history) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // ex. 2022-01-20 14:03:23
        Date date1 = format.parse(sendAt_raw);
        Date date2 = format.parse(history.getSendAt_raw());

        if (date1.before(date2)) {
            return 1;
        } else {
            return -1;
        }
    }

}

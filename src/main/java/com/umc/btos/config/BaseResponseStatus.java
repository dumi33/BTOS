package com.umc.btos.config;

import lombok.Getter;

/*
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {
    /*
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    /*
     * 2000 : Request 오류
     */
    // Common
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    EMPTY_JWT(false, 2001, "JWT를 입력해주세요."),
    INVALID_JWT(false, 2002, "유효하지 않은 JWT입니다."),
    INVALID_USER_JWT(false, 2003, "권한이 없는 유저의 접근입니다."),

    // users
    USERS_EMPTY_USER_ID(false, 2010, "유저 아이디 값을 확인해주세요."),

    // [POST] /users
    POST_USERS_EMPTY_EMAIL(false, 2015, "이메일을 입력해주세요."),
    POST_USERS_INVALID_EMAIL(false, 2016, "이메일 형식을 확인해주세요."),
    POST_USERS_EXISTS_EMAIL(false, 2017, "중복된 이메일입니다."),


    /*
     * 3000 : Response 오류
     */
    // Common
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),

    // [POST] /users
    DUPLICATED_EMAIL(false, 3013, "중복된 이메일입니다."),
    FAILED_TO_LOGIN(false, 3014, "없는 아이디거나 비밀번호가 틀렸습니다."),


    /*
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다."),

    //[PATCH] /users/{userIdx}
    MODIFY_FAIL_USERNAME(false, 4014, "유저네임 수정 실패"),

    PASSWORD_ENCRYPTION_ERROR(false, 4011, "비밀번호 암호화에 실패하였습니다."),
    PASSWORD_DECRYPTION_ERROR(false, 4012, "비밀번호 복호화에 실패하였습니다."),


    // 5000 : 도기
    TEMP1(false, 9000, "conflict 방지용 1"),


    // 6000 : 레마
    TEMP2(false, 9000, "conflict 방지용 2"),
    UNPRIVATE_DATE(false, 6000, "당일에 작성한 일기만 발송 가능합니다!"),
    DIARY_ENCRYPTION_ERROR(false, 6000, "일기 또는 done list 내용 암호화에 실패하였습니다."),
    MODIFY_FAIL_DIARY(false, 6001, "일기 수정 실패 - 일기 내용"),
    MODIFY_FAIL_DONELIST(false, 6001, "일기 수정 실패 - done list"),
    DELETE_FAIL_DIARY(false, 6002, "일기 삭제 실패"),
    DELETE_FAIL_DONELIST(false, 6002, "done list 삭제 실패"),


    // 7000 : 자몽
    TEMP3(false, 9000, "conflict 방지용 3"),


    // 8000 : 잭
    MODIFY_FAIL_LETTER_STATUS(false,8001,"편지 삭제 실패"),
    MODIFY_FAIL_BLOCK_STATUS(false,8002,"차단 해제 실패"),
    GET_FAIL_USERIDX(false, 8003,"해당 유저의 인덱스가 입력되지않았습니다."),
    REPLY_DATABASE_ERROR(false,8004,"답장 생성 과정에서 DB에 문제가 있습니다."),
    MODIFY_FAIL_REPLY_STATUS(false, 8005,"답장 삭제 실패"),
    MODIFY_REPLY_ISCHECKED_ERROR(false, 8007,"답장의 열람여부 변경 실패"),
    NOTICE_DATABASE_ERROR(false, 8006,"공지 조회 실패"),
    TEMP4(false, 9000, "conflict 방지용 4");



    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) { // BaseResponseStatus 에서 각 해당하는 코드를 생성자로 맵핑
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

}

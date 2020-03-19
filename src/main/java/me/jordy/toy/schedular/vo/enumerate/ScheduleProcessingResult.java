package me.jordy.toy.schedular.vo.enumerate;

public enum ScheduleProcessingResult {
    SUCCESS("성공"), IN_PROCESS("진행 중"), FAIL("실패");

    String result;

    ScheduleProcessingResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

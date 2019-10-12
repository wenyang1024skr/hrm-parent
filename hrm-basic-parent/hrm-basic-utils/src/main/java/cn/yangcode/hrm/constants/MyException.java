package cn.yangcode.hrm.constants;

/**
 * @Auther: Wenyang
 * @Date: 2019/9/27 01:20
 * @Description:
 */
public enum MyException {
    ExceEXCEPTION_NULL("名字不能为空！！！"),
    EXCEPTION_EXIST("名字已经存在！！！");
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    MyException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}

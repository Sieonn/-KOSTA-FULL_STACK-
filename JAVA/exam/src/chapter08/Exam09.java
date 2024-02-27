package chapter08;


class UnspportedFuntionException extends RuntimeException {
    private final int ERR_CODE;

    UnspportedFuntionException(String message) {
        super(message);
        ERR_CODE = 100;
    }

    UnspportedFuntionException(String message, int errCode) {
        super(message);
        ERR_CODE = errCode;
    }

    public int getERR_CODE() {
        return ERR_CODE;
    }

    @Override
    public String getMessage() {
        return "[" + getERR_CODE() + "]" + super.getMessage();
    }
}

public class Exam09 {
    public static void main(String[] args) throws Exception {
        try {
            throw new UnspportedFuntionException("지원하지 않는 기능입니다.", 100);
        } catch (UnspportedFuntionException e) {
            System.out.println(e.getERR_CODE());
        }
    }
}

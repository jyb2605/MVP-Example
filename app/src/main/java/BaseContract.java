public class BaseContract {

    public interface Presenter<T> {

        void setView(T view);

        void releaseView();
    }

    //View 의 공용 함수가 필요한 경우 정해줍니다.
    public interface View {

    }
}

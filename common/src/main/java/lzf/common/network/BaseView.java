package lzf.common.network;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public interface BaseView {
    APIService apiService= SingleRetrofit.create();
    /*
    * 准备数据 获得传值
    * */
    void prepareData();
    /*
    * 获取view 如果用注解的话 这就不需要了
    * */
    void findView();
    /*
    * 设置监听
    * */
    void setListener();
    /*
    * 设置presenter
    * */
    void setPresenter();
}

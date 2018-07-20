package com.hulai.dushuren.net.retrofit.helper;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by JoJo on 2018/4/1.
 * wechat：18510829974
 * description：Retrofit请求缓存机制管理
 */
public class RetrofitCacheManager {
    /**
     * 只通过网络返回数据
     */
    public static  <T> DisposableObserver<T> loadOnlyNetwork(final Observable<T> observable, final BaseObserverListener observerListener){
        DisposableObserver<T> disposableObserver = observable
                .compose(RxSchedulers.<T>io_main())
                .subscribeWith(new DisposableObserver<T>() {
                    @Override
                    public void onNext(T result) {
                        observerListener.onNext(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        observerListener.onError( e);
                    }

                    @Override
                    public void onComplete() {
                        observerListener.onComplete();
                    }
                });

        return disposableObserver;
    }
}

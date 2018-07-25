package com.hulai.dushuren.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hulai.dushuren.R;
import com.hulai.dushuren.mvp.model.bean.BookBean;
import com.hulai.dushuren.retrofit.ApiService;
import com.hulai.dushuren.retrofit.RetrofitFactory;
import com.hulai.dushuren.retrofit.base.BaseBean;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ActRxJava extends AppCompatActivity {
    private static final String TAG = "ActRxJava";
    private ApiService apiService;
    private Observable<BaseBean<BookBean>> book;
    private Observable<BaseBean<BookBean>> book2;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_rx_java);
        apiService = RetrofitFactory.getInstance().getRetrofit().create(ApiService.class);
        book = apiService.getBook("237475019");

        book2 = apiService.getBook("237475019");

    }

    String result = "数据源来自 = ";

    //合并数据源
    public void merge(View view) {

        /*
         * 设置第1个Observable：通过网络获取数据
         * 此处仅作网络请求的模拟
         **/
        Observable<String> network = Observable.just("网络");

        /*
         * 设置第2个Observable：通过本地文件获取数据
         * 此处仅作本地文件请求的模拟
         **/
        Observable<String> file = Observable.just("本地文件");
        /*
         * 通过merge（）合并事件 & 同时发送事件
         **/
        Observable.merge(network, file)
                .subscribe(new io.reactivex.Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "数据源有： " + s);
                        result += s + "+";
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "获取数据完成");
                        Log.e(TAG, result);
                    }
                });
    }

    public void zip(View view) {
        book = book.subscribeOn(Schedulers.io());
        book2 = book2.subscribeOn(Schedulers.io());
        Observable.zip(book, book2, new BiFunction<BaseBean<BookBean>, BaseBean<BookBean>, String>() {
            @Override
            public String apply(BaseBean<BookBean> bookBeanBaseBean, BaseBean<BookBean> bookBeanBaseBean2) throws Exception {
                return bookBeanBaseBean.getObject().getAuthors() + " & " + bookBeanBaseBean2.getObject().getPublisher();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(TAG, "最终接收到的数据是：" + s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "失败：" + throwable.toString());
                    }
                });
    }

    public void nestedCallback(View view) {
        book.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<BaseBean<BookBean>>() {
                    @Override
                    public void accept(BaseBean<BookBean> bookBeanBaseBean) throws Exception {
                        Log.d(TAG, "第1次网络请求成功" + bookBeanBaseBean.getObject().toString());

                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<BaseBean<BookBean>, ObservableSource<BaseBean<BookBean>>>() {
                    @Override
                    public ObservableSource<BaseBean<BookBean>> apply(BaseBean<BookBean> bookBeanBaseBean) throws Exception {
                        if ("第1次网络请求失败".isEmpty()) {
                            return Observable.empty();
                        } else {
                            return book;
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean<BookBean>>() {
                    @Override
                    public void accept(BaseBean<BookBean> bookBeanBaseBean) throws Exception {
                        Log.d(TAG, "第2次网络请求成功" + bookBeanBaseBean.getObject().toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "第2次网络请求失败");
                    }
                });
    }

    /**
     * 有条件 网络请求轮询
     */
    public void repeatWhen(View view) {

        book.repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {
                return objectObservable.flatMap(new Function<Object, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Object o) throws Exception {
                        if (i > 3) {
                            // 此处选择发送onError事件以结束轮询，因为可触发下游观察者的onError（）方法回调
                            return Observable.error(new Throwable("轮询结束"));
                        }
                        // 若轮询次数＜4次，则发送1Next事件以继续轮询
                        // 注：此处加入了delay操作符，作用 = 延迟一段时间发送（此处设置 = 2s），以实现轮询间间隔设置
                        return Observable.just(1).delay(2000, TimeUnit.MILLISECONDS);
                    }
                });
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.Observer<BaseBean<BookBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<BookBean> bookBeanBaseBean) {
                        Log.e(TAG, bookBeanBaseBean.getObject().getAuthors());
                        i++;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "对Error" + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    /**
     * 网络请求出错重连
     *
     * @param view
     */
    // 可重试次数
    private int maxConnectCount = 10;
    // 当前已重试次数
    private int currentRetryCount = 0;
    // 重试等待时间
    private int waitRetryTime = 0;

    public void retryWhen(View view) {
        currentRetryCount = 0;
        book.retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
                        // 输出异常信息
                        Log.d(TAG, "发生异常 = " + throwable.toString());

                        /**
                         * 需求1：根据异常类型选择是否重试
                         * 即，当发生的异常 = 网络异常 = IO异常 才选择重试
                         */
                        if (throwable instanceof IOException) {

                            Log.d(TAG, "属于IO异常，需重试");

                            /**
                             * 需求2：限制重试次数
                             * 即，当已重试次数 < 设置的重试次数，才选择重试
                             */
                            if (currentRetryCount < maxConnectCount) {

                                // 记录重试次数
                                currentRetryCount++;
                                Log.d(TAG, "重试次数 = " + currentRetryCount);

                                /**
                                 * 需求2：实现重试
                                 * 通过返回的Observable发送的事件 = Next事件，从而使得retryWhen（）重订阅，最终实现重试功能
                                 *
                                 * 需求3：延迟1段时间再重试
                                 * 采用delay操作符 = 延迟一段时间发送，以实现重试间隔设置
                                 *
                                 * 需求4：遇到的异常越多，时间越长
                                 * 在delay操作符的等待时间内设置 = 每重试1次，增多延迟重试时间1s
                                 */
                                // 设置等待时间
                                waitRetryTime = 1000 + currentRetryCount * 1000;
                                Log.d(TAG, "等待时间 =" + waitRetryTime);
                                return Observable.just(1).delay(waitRetryTime, TimeUnit.MILLISECONDS);


                            } else {
                                // 若重试次数已 > 设置重试次数，则不重试
                                // 通过发送error来停止重试（可在观察者的onError（）中获取信息）
                                return Observable.error(new Throwable("重试次数已超过设置次数 = " + currentRetryCount + "，即 不再重试"));

                            }
                        }

                        // 若发生的异常不属于I/O异常，则不重试
                        // 通过返回的Observable发送的事件 = Error事件 实现（可在观察者的onError（）中获取信息）
                        else {
                            return Observable.error(new Throwable("发生了非网络异常（非I/O异常）"));
                        }
                    }
                });
            }
        }).subscribeOn(Schedulers.io())               // 切换到IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())  // 切换回到主线程 处理请求结果
                .subscribe(new io.reactivex.Observer<BaseBean<BookBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<BookBean> bookBeanBaseBean) {
                        Log.e(TAG, "发送成功：" + bookBeanBaseBean.getObject().getAuthors());
                    }

                    @Override
                    public void onError(Throwable e) {
                        // 获取停止重试的信息
                        Log.e(TAG, "Error" + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 无条件请求轮询
     * 步骤1：采用interval（）延迟发送
     * 注：此处主要展示无限次轮询，若要实现有限次轮询，仅需将interval（）改成intervalRange（）即可
     */
    public void interval(View view) {
        Observable.interval(2, 5, TimeUnit.SECONDS)
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Observable<BaseBean<BookBean>> book = apiService.getBook("237475019");
                        book.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new io.reactivex.Observer<BaseBean<BookBean>>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(BaseBean<BookBean> bookBeanBaseBean) {
                                        Log.e(TAG, bookBeanBaseBean.getObject().getAuthors());
                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });
                    }
                }).subscribe(new io.reactivex.Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {

            }

            @Override
            public void onError(Throwable e) {

                Log.e(TAG, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "对Complete事件作出响应");

            }
        });
    }

    public void map(View view) {
        book.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<BaseBean<BookBean>, BookBean>() {
                    @Override
                    public BookBean apply(BaseBean<BookBean> bookBeanBaseBean) throws Exception {
                        return bookBeanBaseBean.getObject();
                    }
                }).subscribe(new io.reactivex.Observer<BookBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BookBean bookBean) {
                Log.e(TAG, bookBean.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.toString());

            }

            @Override
            public void onComplete() {

            }
        });
    }
}

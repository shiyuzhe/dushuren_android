package com.hulai.dushuren.ui.fragment;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.hulai.dushuren.R;
import com.hulai.dushuren.base.BaseFragment;
import com.hulai.dushuren.mvp.model.bean.BookBean;
import com.hulai.dushuren.retrofit.ApiService;
import com.hulai.dushuren.retrofit.RetrofitFactory;
import com.hulai.dushuren.retrofit.RetrofitManager;
import com.hulai.dushuren.retrofit.base.BaseBean;
import com.jakewharton.rxbinding2.view.RxView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by HongJay on 2016/8/11.
 */
public class Fragment2 extends BaseFragment {


    @BindView(R.id.titile)
    TextView textView;

    private static Fragment2 instance;

    public static Fragment2 getInstance() {
        if (instance == null) {
            instance = new Fragment2();
        }
        Log.e("syz", "Fragment2");
        return instance;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fra_fragment1;
    }

    @Override
    protected void bindView() {
        RetrofitManager.getApiService().getBookNoRx("237475019").enqueue(new Callback<BaseBean<BookBean>>() {
            @Override
            public void onResponse(@NonNull Call<BaseBean<BookBean>> call, @NonNull Response<BaseBean<BookBean>> response) {
                if (response.body() != null && response.body().getObject() != null) {
                    textView.setText(response.body().getObject().toString());
                } else {
                    textView.setText("onResponse:response.body()==null");
                }
            }


            @Override
            public void onFailure(@NonNull Call<BaseBean<BookBean>> call, @NonNull Throwable t) {
                textView.setText("onFailure:" + t.getMessage());
            }
        });

        RxView.clicks(textView)
                .throttleFirst(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Toast.makeText(getActivity(), " RxView.clicks(textView)", Toast.LENGTH_SHORT).show();
                        rxSample();
                    }
                });

    }

    int count = 0;
    int maxCount = 10;

    private void rxRetory() {

        io.reactivex.Observable<BaseBean<BookBean>> book = RetrofitFactory.getInstance().getRetrofit().create(ApiService.class).getBook("237475019");
        book.retryWhen(new Function<io.reactivex.Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(io.reactivex.Observable<Throwable> throwableObservable) throws Exception {

                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
                        if (throwable instanceof IOException) {
                            if (count < maxCount) {
                                count++;
                                return io.reactivex.Observable.just(1).delay(1, TimeUnit.SECONDS);
                            } else {
                                return io.reactivex.Observable.error(new Throwable("IO Error"));
                            }

                        } else {
                            return io.reactivex.Observable.error(new Throwable("IO Error"));
                        }
                    }
                });
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<BookBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<BookBean> bookBeanBaseBean) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


//                .subscribe(new Observer<Object>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Object o) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    Subscription subscription;

    private void rxSample() {

        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                try {
                    InputStream is = getResources().getAssets().open("file.txt");
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();

                    int len = -1;
                    String str;
                    byte[] buffer = new byte[1024];
                    while ((len = is.read(buffer)) != -1) {
                        baos.write(buffer, 0, len);
                        str = baos.toString();
                        while (str != null && !e.isCancelled()) {
                            while (e.requested() == 0) {
                                if (e.isCancelled()) {
                                    break;
                                }
                            }
                            e.onNext(str);
                            str = null;
                        }
                    }


                } catch (Exception e1) {
                    e.onError(e1);
                } finally {
                    e.onComplete();

                }
            }
        }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        subscription = s;
                        s.request(1);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("file", "onNext:" + s);
                        try {
                            Thread.sleep(2000);
                            subscription.request(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
//                            Log.i("file", e.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("file", "onError:" + t.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
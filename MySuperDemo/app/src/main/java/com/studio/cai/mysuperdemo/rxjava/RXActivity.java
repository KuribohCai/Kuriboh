package com.studio.cai.mysuperdemo.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.studio.cai.mysuperdemo.R;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator Kuriboh on 2017/7/18.
 */

public class RXActivity extends FragmentActivity {

    private Observable mObservable;
    private Subscriber<String> mSubscriber;
    private Observer<String> mObserver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createObserver();
        createSubsriber();
        create();
        just();
        form();
        mObservable.subscribe(mObserver);
        mObservable.subscribe(mSubscriber);
        action();
        print();
        change();
        compose();
        scheduler();
    }

    private void scheduler() {
        Observable.just(1, 2, 3, 4) // IO 线程，由 subscribeOn() 指定
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .map(new Func1<Integer, Object>() {
                    @Override
                    public Object call(Integer integer) {
                        return null;
                    }
                }) // 新线程，由 observeOn() 指定
                .observeOn(Schedulers.io())
                .map(new Func1<Object, Object>() {
                    @Override
                    public Object call(Object o) {
                        return null;
                    }
                }) // IO 线程，由 observeOn() 指定
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {

                    }
                });  // Android 主线程，由 observeOn() 指定


//        Observable.create(onSubscribe)
//                .sub scribeOn(Schedulers.io())
//                .doOnSubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                        progressBar.setVisibility(View.VISIBLE); // 需要在主线程执行
//                    }
//                })
//                .subscribeOn(AndroidSchedulers.mainThread()) // 指定主线程
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
    }

    //    public class LiftAllTransformer implements Observable.Transformer<Integer, String> {
//        @Override
//        public Observable<String> call(Observable<Integer> observable) {
//            return observable
//                    .lift1()
//                    .lift2()
//                    .lift3()
//                    .lift4();
//        }
//    }
//
    private void compose() {
//
//        Observable.Transformer liftAll = new LiftAllTransformer();
//        observable1.compose(liftAll).subscribe(subscriber1);
//        observable2.compose(liftAll).subscribe(subscriber2);
//        observable3.compose(liftAll).subscribe(subscriber3);
//        observable4.compose(liftAll).subscribe(subscriber4);
    }

    private void change() {

        /**
         *  Observable.just("images/logo.png") // 输入类型 String
         .map(new Func1<String, Bitmap>() {
        @Override public Bitmap call(String filePath) { // 参数类型 String
        return BitmapFactory.decodeFile(filePath); // 返回类型 Bitmap
        }
        })
         .subscribe(new Action1<Bitmap>() {
        @Override public void call(Bitmap bitmap) { // 参数类型 Bitmap

        }
        });*/


        /** Student[] students = ...;
         Subscriber<String> subscriber = new Subscriber<String>() {
        @Override public void onNext(String name) {
        Log.d(tag, name);
        }
        };
         Observable.from(students)
         .map(new Func1<Student, String>() {
        @Override public String call(Student student) {
        return student.getName();
        }
        })
         .subscribe(subscriber);*/


        /**
         * Student[] students = ...;
         Subscriber<Course> subscriber = new Subscriber<Course>() {
        @Override public void onNext(Course course) {
        Log.d(tag, course.getName());
        }
        ...
        };
         Observable.from(students)
         .flatMap(new Func1<Student, Observable<Course>>() {
        @Override public Observable<Course> call(Student student) {
        return Observable.from(student.getCourses());
        }
        })
         .subscribe(subscriber);
         * */


        /**
         * networkClient.token() // 返回 Observable<String>，在订阅时请求 token，并在响应后发送 token
         .flatMap(new Func1<String, Observable<Messages>>() {
        @Override public Observable<Messages> call(String token) {
        // 返回 Observable<Messages>，在订阅时请求消息列表，并在响应后发送请求到的消息列表
        return networkClient.messages();
        }
        })
         .subscribe(new Action1<Messages>() {
        @Override public void call(Messages messages) {
        // 处理显示消息列表
        showMessages(messages);
        }
        });
         * */
    }

    private void print() {
        String[] names = {"a", "b", "c", "d", "e"};
        Observable.from(names)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String name) {
                        Log.d("rxjava", name);
                    }
                });
        /**
         * int drawableRes = ...;
         ImageView imageView = ...;
         Observable.create(new OnSubscribe<Drawable>() {
        @Override public void call(Subscriber<? super Drawable> subscriber) {
        Drawable drawable = getTheme().getDrawable(drawableRes));
        subscriber.onNext(drawable);
        subscriber.onCompleted();
        }
        })
         .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
         .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
         .subscribe(new Observer<Drawable>() {
        @Override public void onNext(Drawable drawable) {
        imageView.setImageDrawable(drawable);
        }

        @Override public void onCompleted() {
        }

        @Override public void onError(Throwable e) {
        Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show();
        }
        });
         * */
    }

    private void action() {
        Action1<String> onNextAction = new Action1<String>() {
            // onNext()
            @Override
            public void call(String s) {
                Log.d("rxjava", s);
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            // onError()
            @Override
            public void call(Throwable throwable) {
                // Error handling
            }
        };
        Action0 onCompletedAction = new Action0() {
            // onCompleted()
            @Override
            public void call() {
                Log.d("rxjava", "completed");
            }
        };

        // 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
        mObservable.subscribe(onNextAction);
        // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
        mObservable.subscribe(onNextAction, onErrorAction);
        // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        mObservable.subscribe(onNextAction, onErrorAction, onCompletedAction);
    }

    private void createSubsriber() {
        mSubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                Log.d("rxjava", "Item: " + s);
            }

            @Override
            public void onCompleted() {
                Log.d("rxjava", "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("rxjava", "Error!");
            }
        };
    }

    private void createObserver() {
        mObserver = new Observer<String>() {
            @Override
            public void onNext(String s) {
                Log.d("rxjava", "Item: " + s);
            }

            @Override
            public void onCompleted() {
                Log.d("rxjava", "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("rxjava", "Error!");
            }
        };
    }

    private void create() {
        mObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });
    }

    private void form() {
        String[] words = {"Hello", "Hi", "Aloha"};
        mObservable = Observable.from(words);
        // 将会依次调用：
        // onNext("Hello");
        // onNext("Hi");
        // onNext("Aloha");
        // onCompleted();
    }

    private void just() {
        mObservable = Observable.just("Hello", "Hi", "Aloha");
        // 将会依次调用：
        // onNext("Hello");
        // onNext("Hi");
        // onNext("Aloha");
        // onCompleted();
    }
}

package jp.co.myself.xacdonald;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jp.co.myself.xacdonald.model.webapi.WebApiUtils;
import jp.co.myself.xacdonald.model.webapi.home.Hit;
import jp.co.myself.xacdonald.model.webapi.home.ItemSearchResult;

public class MainActivity extends AppCompatActivity {

    private CompositeDisposable cd = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 以下のコードは削除予定。
        // RxJavaを利用した、WebAPI呼出のサンプルコード。
        Observable<ItemSearchResult> itemSearchResultObservable = WebApiUtils.getItemSearchForHome();

        Disposable d = itemSearchResultObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (response) -> {
                            for (Hit hit : response.getHits()) {
                                Log.d(MainActivity.class.getSimpleName(), "exImage_url:" + hit.getExImage().getUrl());
                            }
                        },
                        (err) -> {
                            Log.d(MainActivity.class.getSimpleName(), err.getMessage());
                        }
                );
        cd.add(d);
    }
}
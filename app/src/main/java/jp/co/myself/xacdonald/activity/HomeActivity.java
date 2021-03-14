package jp.co.myself.xacdonald.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import jp.co.myself.xacdonald.view.home.HomeRecyclerViewAdapter;
import jp.co.myself.xacdonald.viewmodel.HomeViewModel;
import jp.co.myself.xacdonald.viewmodel.HomeViewModelFactory;

public class HomeActivity extends AppCompatActivity {

    // 以下のコードは削除予定。
    private CompositeDisposable cd = null;
    // 以下のコードは削除予定。
    private HomeViewModel hvm = null;

    private ConstraintLayout cl = null;
    private RecyclerView rv = null;
    private HomeRecyclerViewAdapter hrva = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 以下のコードは削除予定。
        /*
        HighScoreItem hsi1 = new HighScoreItem("name1", "100", "http://localhost11");
        HighScoreItem hsi2 = new HighScoreItem("name2", "200", "http://localhost12");
        HighScoreItem hsi3 = new HighScoreItem("name3", "300", "http://localhost13");
        HighScoreItem hsi4 = new HighScoreItem("name4", "400", "http://localhost14");
        List<HighScoreItem> list = new ArrayList<>();
        list.add(hsi1);
        list.add(hsi2);
        list.add(hsi3);
        list.add(hsi4);
        HighScoreItemSet hsis = new HighScoreItemSet(list);
        LowPriceItem lpi1 = new LowPriceItem("http://localhost21");
        LowPriceItem lpi2 = new LowPriceItem("http://localhost22");
        LowPriceItem lpi3 = new LowPriceItem("http://localhost23");
        LowPriceItem lpi4 = new LowPriceItem("http://localhost24");
        List<Item> l = new ArrayList<>();
        l.add(lpi1);
        l.add(hsis);
        l.add(lpi2);
        l.add(lpi3);
        l.add(lpi4);
        for (Item i : l) {
            if (i instanceof LowPriceItem) {
                LowPriceItem lpi = (LowPriceItem)i;
                Log.d(HomeActivity.class.getSimpleName(), lpi.getImageUrl());
            } else if (i instanceof HighScoreItemSet) {
                HighScoreItemSet hsis2 = (HighScoreItemSet)i;
                Log.d(HomeActivity.class.getSimpleName(), String.valueOf(hsis2.getHighScoreItems().size()));
            }
        }
        */

        cd = new CompositeDisposable();
        hvm = new ViewModelProvider(this, new HomeViewModelFactory()).get(HomeViewModel.class);

        // レイアウトを初期化する。
        initLayout();

        setContentView(cl);

        // コンポーネントを配置する。
        deployComponent();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        cd.dispose();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Disposable d = hvm
                .searchItemForHome()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (res) -> {
                            Log.d(HomeActivity.class.getSimpleName(), "ok");
                            hvm.setItems(res);
                            hrva.notifyDataSetChanged();
                        },
                        (error) -> {
                            Log.d(HomeActivity.class.getSimpleName(), error.getMessage());
                        });
        cd.add(d);

        // 以下のコードは削除予定。
        // RxJavaを利用した、WebAPI呼出のサンプルコード。
        /*cd = new CompositeDisposable();
        Observable<ItemSearchResult> lowPriceItemSearchResultObs = WebApiUtils.getLowPriceItemForHome();
        Observable<ItemSearchResult> highScoreItemSearchResultObs = WebApiUtils.getHighScoreItemForHome();
        Observable<String> result =
                Observable.zip(lowPriceItemSearchResultObs.subscribeOn(Schedulers.io()), highScoreItemSearchResultObs.subscribeOn(Schedulers.io()), new BiFunction<ItemSearchResult, ItemSearchResult, String>() {
                    @NonNull
                    @Override
                    public String apply(@NonNull ItemSearchResult lowPriceItemSearchResult, @NonNull ItemSearchResult highScoreItemSearchResult) throws Exception {
                        return "ok";
                    }
                });
        Disposable d = result.subscribe(
                (res) -> {
                    Log.d(HomeActivity.class.getSimpleName(), "zip success.");
                },
                (error) -> {
                    Log.d(HomeActivity.class.getSimpleName(), "zip error.");
                });*/
        /*
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
        */
    }

    private void initLayout() {

        cl = new ConstraintLayout(this);
        cl.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT));

    }

    private void deployComponent() {

        rv = new RecyclerView(this);
        rv.setId(View.generateViewId());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setBackgroundColor(Color.BLUE);
        cl.addView(rv);
        ConstraintSet rvCs = new ConstraintSet();
        rvCs.constrainWidth(
                rv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        rvCs.constrainHeight(
                rv.getId(),
                ConstraintSet.MATCH_CONSTRAINT);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                0);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);
        rvCs.connect(
                rv.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                0);
        rvCs.applyTo(cl);
        hrva = new HomeRecyclerViewAdapter(hvm.getItems());
        rv.setAdapter(hrva);

    }
}
package jp.co.myself.xacdonald.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import jp.co.myself.xacdonald.view.home.HomeRecyclerViewAdapter;
import jp.co.myself.xacdonald.viewmodel.HomeViewModel;
import jp.co.myself.xacdonald.viewmodel.HomeViewModelFactory;

public class HomeFragment extends Fragment {

    private CompositeDisposable cd = null;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
        cd = new CompositeDisposable();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ConstraintLayout cl = new ConstraintLayout(getContext());

        HomeViewModel hvm = new ViewModelProvider(this, new HomeViewModelFactory()).get(HomeViewModel.class);
        
        RecyclerView rv = new RecyclerView(getContext());
        rv.setId(View.generateViewId());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setBackgroundColor(Color.BLUE);
        HomeRecyclerViewAdapter hrva = new HomeRecyclerViewAdapter(hvm.getItems());
        rv.setAdapter(hrva);
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

        Disposable d = hvm
                .searchItemForHome()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (res) -> {
                            Log.d(HomeFragment.class.getSimpleName(), "ok");
                            hvm.setItems(res);
                            hrva.notifyDataSetChanged();
                        },
                        (error) -> {
                            Log.d(HomeFragment.class.getSimpleName(), error.getMessage());
                        });
        cd.add(d);

        return cl;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        cd.dispose();
    }
}

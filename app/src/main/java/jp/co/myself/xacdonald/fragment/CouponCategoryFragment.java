package jp.co.myself.xacdonald.fragment;

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
import jp.co.myself.xacdonald.view.coupon.CouponRecyclerViewAdapter;
import jp.co.myself.xacdonald.viewmodel.CouponViewModel;
import jp.co.myself.xacdonald.viewmodel.CouponViewModelFactory;

public class CouponCategoryFragment extends Fragment {

    private static final String PARAM_COUPON_CATEGORY_ID = "coupon_category_id";

    private Integer couponCategoryID = null;

    private CouponViewModel cvm = null;

    private CouponRecyclerViewAdapter crva = null;

    public CouponCategoryFragment() {
        // Required empty public constructor
    }

    public static CouponCategoryFragment newInstance(Integer couponCategoryID) {
        CouponCategoryFragment fragment = new CouponCategoryFragment();
        Bundle args = new Bundle();
        args.putInt(PARAM_COUPON_CATEGORY_ID, couponCategoryID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            couponCategoryID = getArguments().getInt(PARAM_COUPON_CATEGORY_ID);
        }
        cvm = new ViewModelProvider(
                this,
                new CouponViewModelFactory()).get(CouponViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ConstraintLayout cl = new ConstraintLayout(getActivity());

        RecyclerView rv = new RecyclerView(getContext());
        rv.setId(View.generateViewId());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        crva = new CouponRecyclerViewAdapter(cvm.getCouponList());
        rv.setAdapter(crva);
        cl.addView(rv);
        ConstraintSet rvCs = new ConstraintSet();
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

        return cl;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (!cvm.isGotFirstCoupon()) {
            cvm
                    .getCoupon(couponCategoryID)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            (res) -> {
                                Log.d(CouponCategoryFragment.class.getSimpleName(), "ok");
                                cvm.setCouponList(res);
                                Log.d(CouponCategoryFragment.class.getSimpleName(), String.valueOf(crva.getItemCount()));
                                crva.notifyDataSetChanged();
                            },
                            (err) -> {
                                Log.d(CouponCategoryFragment.class.getSimpleName(), "err");
                            },
                            () -> {
                                Log.d(CouponCategoryFragment.class.getSimpleName(), "complete");
                            });
        }
    }
}
